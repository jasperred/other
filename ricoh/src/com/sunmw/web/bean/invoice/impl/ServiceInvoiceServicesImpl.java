package com.sunmw.web.bean.invoice.impl;

import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunmw.web.bean.invoice.ServiceInvoiceServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.Invoice;
import com.sunmw.web.entity.InvoiceServiceRef;
import com.sunmw.web.entity.InvoiceServiceRefPK;
import com.sunmw.web.entity.ServiceApply;
import com.sunmw.web.entity.ServiceHead;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class ServiceInvoiceServicesImpl extends HibernateDaoSupport implements
		ServiceInvoiceServices {

	static Logger logger = Logger.getLogger(ServiceInvoiceServicesImpl.class);

	public Map searchServiceInvoice(Map param, int currentPage, int pageRow) {

		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl)) {
			result.put("RESULT", null);
			result.put("COUNT_ROW", 0);
			logger.error("用户公司信息不存在");
			return result;
		}
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory())
				|| !(c.getCategory().equals("RCN") || c.getCategory().equals(
						"SHOP"))) {
			result.put("RESULT", null);
			result.put("COUNT_ROW", 0);
			logger.error("无权限查看");
			return result;
		}
		StringBuffer hql = new StringBuffer();
		hql.append("from Invoice i,Company c where i.CompanyId = c.id ");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and i.CompanyId in (" + companyIds + ")");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("InvoiceCd"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" i.InvoiceCd like :Condition" + conList.size());
			conList.add("%" + param.get("InvoiceCd") + "%");
		}
		if (!WebUtil.isNull(param.get("CompanyName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" c.CompanyName like :Condition" + conList.size());
			conList.add("%" + param.get("CompanyName") + "%");
		}
		if (!WebUtil.isNull(param.get("InvoiceFromDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" i.InvoiceDate >= :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get("InvoiceFromDate")
					.toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("InvoiceEndDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" i.InvoiceDate < :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get("InvoiceEndDate")
					.toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("InvoiceNoticeFromDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" i.InvoiceNoticeDate >= :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get(
					"InvoiceNoticeFromDate").toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("InvoiceNoticeEndDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" i.InvoiceNoticeDate < :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get(
					"InvoiceNoticeEndDate").toString(), "yyyy-MM-dd"));
		}
		if (con.length() > 0)
			hql.append(" and " + con.toString());

		Session session = this.getSession();
		try {
			Query q1 = session.createQuery("select count(*) " + hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q1.setParameter("Condition" + i, conList.get(i));
			}
			List<Long> countList = q1.list();
			int count = countList.get(0).intValue();
			Query q = session
					.createQuery("select i.id,i.InvoiceCd,i.CompanyId,c.CompanyName,i.ServiceAmt,i.HomeAmt,i.OtherAmt,i.TotalAmt,i.InvoiceDate,i.InvoiceNoticeDate "
							+ hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q.setParameter("Condition" + i, conList.get(i));
			}
			if (pageRow > 0) {
				q.setFirstResult((currentPage - 1) * pageRow);
				q.setMaxResults(pageRow);
			}
			List<Object[]> l = q.list();
			List<Map> r = new ArrayList();
			for (Object[] obj : l) {
				Map m = new HashMap();
				m.put("InvoiceId", obj[0]);
				m.put("InvoiceCd", obj[1]);
				m.put("CompanyId", obj[2]);
				m.put("CompanyName", obj[3]);
				m.put("ServiceAmt", obj[4]);
				m.put("HomeAmt", obj[5]);
				m.put("OtherAmt", obj[6]);
				m.put("TotalAmt", obj[7]);
				if (WebUtil.isNotNull(obj[8]))
					m.put("InvoiceDate", WebUtil.formatDateString(
							(Date) obj[8], "yyyy-MM-dd"));
				if (WebUtil.isNotNull(obj[9]))
					m.put("InvoiceNoticeDate", WebUtil.formatDateString(
							(Date) obj[9], "yyyy-MM-dd"));
				r.add(m);
			}
			result.put("RESULT", r);
			result.put("COUNT_ROW", count);
		} catch (HibernateException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} catch (RuntimeException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	private String getCompanyByUser(UserLogin ul) {
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl))
			return "0";
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory()))
			return "0";
		if (c.getCategory().equals("SHOP"))
			return c.getId().toString();
		else {
			List<String> areaList = this
					.getHibernateTemplate()
					.find(
							"select sga.id.AreaCd from UserLoginSecurityGroup ulsg,SecurityGroupArea sga where ulsg.id.GroupId = sga.id.GroupId and ulsg.id.UserId = ?",
							ul.getId());
			if (WebUtil.isNullForList(areaList))
				return null;
			StringBuffer areaCds = new StringBuffer();
			for (String area : areaList) {
				if (areaCds.length() > 0)
					areaCds.append(",");
				areaCds.append("'" + area + "'");
			}
			// from Company where ProvinceCd in (select apr.ProvinceCd from
			// UserLoginSecurityGroup ulsg,SecurityGroupArea sga,AreaProvinceRef
			// apr where ulsg.id.GroupId = sga.id.GroupId and sga.id.AreaCd =
			// apr.AreaCd and ulsg.UserId = ?)
			List<Integer> companyList = this
					.getHibernateTemplate()
					.find(
							"select c.id from Company c,AreaProvinceRef apr where c.ProvinceCd = apr.ProvinceCd and apr.AreaCd in ("
									+ areaCds.toString() + ")");
			if (WebUtil.isNullForList(companyList))
				return "0";
			StringBuffer companyIds = new StringBuffer();
			for (Integer companyId : companyList) {
				if (companyIds.length() > 0)
					companyIds.append(",");
				companyIds.append(companyId);
			}
			return companyIds.toString();
		}
	}

	public Map invoiceInfo(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl)) {
			result.put("Flag", "ERROR");
			result.put("Message", "用户公司信息不存在");
			return result;
		}
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory())
				|| !(c.getCategory().equals("RCN") || c.getCategory().equals(
						"SHOP"))) {
			result.put("Flag", "ERROR");
			result.put("Message", "无权限查看");
			return result;
		}
		String invoiceId = (String) param.get("InvoiceId");
		if(!WebUtil.isNumeric(invoiceId))
		{
			result.put("Flag", "ERROR");
			result.put("Message", "找不到结算信息");
			return result;
		}
		StringBuffer hql = new StringBuffer();
		hql
				.append("from Invoice i,Company c where i.CompanyId = c.id and i.id = ?");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and i.CompanyId in (" + companyIds + ")");
		List<Object[]> invoiceList = this.getHibernateTemplate().find(
				hql.toString(), new Integer(invoiceId));
		if (WebUtil.isNullForList(invoiceList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到结算信息");
			return result;
		}
		Object[] obj = invoiceList.get(0);
		Invoice i = (Invoice) obj[0];
		Company cc = (Company) obj[1];
		result.put("InvoiceId", i.getId());
		result.put("InvoiceCd", i.getInvoiceCd());
		result.put("InvoiceDate", i.getInvoiceDate());
		result.put("InvoiceNoticeDate", i.getInvoiceNoticeDate());
		result.put("InvoiceNoticePerson", i.getInvoiceNoticePerson());
		result.put("InvoiceReceiveDate", i.getInvoiceReceiveDate());
		result.put("InvoiceStatus", i.getInvoiceStatus());
		result.put("InvoiceUrl", i.getInvoiceUrl());
		result.put("CompanyId", i.getCompanyId());
		result.put("CompanyName", cc.getCompanyName());
		result.put("FromDate", i.getFromDate());
		result.put("EndDate", i.getEndDate());
		result.put("HomeAmt", i.getHomeAmt());
		result.put("OtherAmt", i.getOtherAmt());
		result.put("ServiceAmt", i.getServiceAmt());
		result.put("PaymentDate", i.getPaymentDate());
		result.put("TotalAmt", i.getTotalAmt());
		result.put("Memo", i.getMemo());
		List<Object[]> invoiceItemList = this
				.getHibernateTemplate()
				.find(
						"from InvoiceServiceRef isr,ServiceHead sh where isr.id.ServiceId = sh.id and isr.id.InvoiceId = ?",
						i.getId());
		List l = new ArrayList();
		if (!WebUtil.isNullForList(invoiceItemList)) {
			for (Object[] os : invoiceItemList) {
				InvoiceServiceRef isr = (InvoiceServiceRef) os[0];
				ServiceHead sh = (ServiceHead) os[1];
				Map m = new HashMap();
				m.put("ServiceId", sh.getId());
				m.put("ServiceNo", sh.getServiceNo());
				m.put("MachineNo", sh.getMachineNo());
				m.put("MachineType", sh.getMachineType());
				m.put("ServiceAmt", isr.getServiceAmt());
				m.put("HomeAmt", isr.getHomeAmt());
				m.put("OtherAmt", isr.getOtherAmt());
				l.add(m);
			}
		}
		result.put("InvoiceItemList", l);
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map previewInvoiceServiceOrderList(Map param, int currentPage,
			int pageRow) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl)) {
			result.put("RESULT", null);
			result.put("COUNT_ROW", 0);
			logger.error("用户公司信息不存在");
			return result;
		}
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory())
				|| !(c.getCategory().equals("RCN") || c.getCategory().equals(
						"SHOP"))) {
			result.put("RESULT", null);
			result.put("COUNT_ROW", 0);
			logger.error("无权限查看");
			return result;
		}
		String companyIds = getCompanyByUser(ul);

		String fromDate = (String) param.get("FromDate");
		String endDate = (String) param.get("EndDate");
		String companyId = (String) param.get("CompanyId");
		fromDate = WebUtil.formatDateString(WebUtil.toDateForString(fromDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 00:00:00";
		endDate = WebUtil.formatDateString(WebUtil.toDateForString(endDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 23:59:59";
		Session session = this.getSession();
		try {
			Connection conn = session.connection();   
			ResultSet rs =null;  
			CallableStatement call = conn.prepareCall("{call Ap_PreviewInvoiceServiceOrderList(?,?,?,?)}"); 
			if(WebUtil.isNotNull(companyId))
				call.setString(1, companyId);
			else
				call.setString(1, null);		
			if(WebUtil.isNotNull(companyIds))
				call.setString(2, companyIds);
			else
				call.setString(2, null);
			call.setString(3, fromDate);
			call.setString(4, endDate);
			rs = call.executeQuery();  
			List<Map> invoiceList = new ArrayList();
			//if(rs.getRow()>0)
			while(rs.next())
			{
				if(rs.isAfterLast())
					break;
				Map m = new HashMap();
				m.put("CompanyId", rs.getObject(1));
				m.put("CompanyName", rs.getObject(2));
				m.put("TotalAmt", rs.getObject(3));
				invoiceList.add(m);
			}
			rs.close();  
//			SQLQuery q = session.createSQLQuery("{call Ap_PreviewInvoiceServiceOrderList(?,?,?,?)}");
//
//			if(WebUtil.isNotNull(companyId))
//				q.setParameter(0, companyId);
//			else
//				q.setParameter(0, null);		
//			if(WebUtil.isNotNull(companyIds))
//				q.setParameter(1, companyIds);
//			else
//				q.setParameter(1, null);
//			q.setParameter(2, fromDate);
//			q.setParameter(3, endDate);
//			List<Object[]> l = q.list();
//			List<Map> invoiceList = new ArrayList();
//			for (Object[] obj : l) {
//				Map m = new HashMap();
//				m.put("CompanyId", obj[0]);
//				m.put("CompanyName", obj[1]);
//				m.put("TotalAmt", obj[2]);
//				invoiceList.add(m);
//			}
			result.put("RESULT", invoiceList);
			result.put("COUNT_ROW", invoiceList.size());
		} catch (HibernateException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
		} catch (NumberFormatException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
		} catch (RuntimeException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public Map previewInvoiceServiceOrder(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl)) {
			result.put("Flag", "ERROR");
			result.put("Message", "用户公司信息不存在");
			return result;
		}
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory()) || !(c.getCategory().equals("RCN"))) {
			result.put("Flag", "ERROR");
			result.put("Message", "无权限操作");
			return result;
		}
		String companyId = (String) param.get("CompanyId");
		List<Company> cList = this.getHibernateTemplate().find(
				"from Company where id = ?", new Integer(companyId));
		if (WebUtil.isNullForList(cList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "结算对象的公司信息不存在");
			return result;
		}
		Company company = cList.get(0);
		String fromDate = (String) param.get("FromDate");
		String endDate = (String) param.get("EndDate");
		fromDate = WebUtil.formatDateString(WebUtil.toDateForString(fromDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 00:00:00";
		endDate = WebUtil.formatDateString(WebUtil.toDateForString(endDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 23:59:59";
		String companyIds = getCompanyByUser(ul);
		// 结算内容，审核通过，回访合格
		String hql = "from ServiceHead sh,ServiceApply sa,Company c,ServiceVisit sv where sh.CompanyId = c.id and sh.id = sa.ServiceId and sh.id = sv.ServiceId and sv.VisitResult not in ('','电话无人','没有发生维修') and sa.ServiceApplyType = 'RATE' and sa.Status = 'NO_INVOICE' and sh.ApplyRateStatus = 'NO_INVOICE' and sh.CompanyId = ? and sa.ServiceApplyAuditedDate >= ? and sa.ServiceApplyAuditedDate < ?";
		if (companyIds != null)
			hql += " and sh.CompanyId in (" + companyIds + ")";
		List<Object[]> shList = this.getHibernateTemplate()
				.find(
						hql,
						new Object[] {
								new Integer(companyId),
								WebUtil.toDateForString(fromDate,
										"yyyy-MM-dd HH:mm:ss"),
								WebUtil.toDateForString(endDate,
										"yyyy-MM-dd HH:mm:ss") });
		if (WebUtil.isNullForList(shList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "没有结算内容");
			return result;
		}
		result.put("CompanyId", company.getId());
		result.put("CompanyName", company.getCompanyName());
		result.put("FromDate", WebUtil.toDateForString(fromDate,
				"yyyy-MM-dd HH:mm:ss"));
		result.put("EndDate", WebUtil.toDateForString(endDate,
				"yyyy-MM-dd HH:mm:ss"));
		double tecRate = 0;
		double homeRate = 0;
		double otherRate = 0;
		double allRate = 0;
		List invoiceItem = new ArrayList();
		Map<Integer,String> cm = new HashMap();
		for (Object[] obj : shList) {
			ServiceHead sh = (ServiceHead) obj[0];
			ServiceApply sa = (ServiceApply) obj[1];

			if(cm.get(sh.getId())!=null)
				continue;
			if (sa.getTecRate() != null)
				tecRate += sa.getTecRate().doubleValue();
			if (sa.getHomeRate() != null)
				homeRate += sa.getHomeRate().doubleValue();
			if (sa.getOtherRate() != null)
				otherRate += sa.getOtherRate().doubleValue();
			Map m = new HashMap();
			m.put("ServiceId", sh.getId());
			m.put("ServiceNo", sh.getServiceNo());
			m.put("MachineNo", sh.getMachineNo());
			m.put("MachineType", sh.getMachineType());
			m.put("ServiceAmt", sa.getTecRate());
			m.put("HomeAmt", sa.getHomeRate());
			m.put("OtherAmt", sa.getOtherRate());
			m.put("OtherMemo", sa.getOtherRateMemo());
			cm.put(sh.getId(), sh.getServiceNo());
			invoiceItem.add(m);
		}
		result.put("ServiceAmt", WebUtil.round(new BigDecimal(tecRate)));
		result.put("HomeAmt", WebUtil.round(new BigDecimal(homeRate)));
		result.put("OtherAmt", WebUtil.round(new BigDecimal(otherRate)));
		allRate = tecRate + homeRate + otherRate;
		result.put("TotalAmt", WebUtil.round(new BigDecimal(allRate)));
		result.put("InvoiceItemList", invoiceItem);
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map generateInvoiceServiceOrder(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl)) {
			result.put("Flag", "ERROR");
			result.put("Message", "用户公司信息不存在");
			return result;
		}
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory()) || !(c.getCategory().equals("RCN"))) {
			result.put("Flag", "ERROR");
			result.put("Message", "无权限操作");
			return result;
		}
		String companyId = (String) param.get("CompanyId");
		List<Company> cList = this.getHibernateTemplate().find(
				"from Company where id = ?", new Integer(companyId));
		if (WebUtil.isNullForList(cList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "结算对象的公司信息不存在");
			return result;
		}
		Company company = cList.get(0);
		String fromDate = (String) param.get("FromDate");
		String endDate = (String) param.get("EndDate");
		String invoiceDate = (String) param.get("InvoiceDate");
		String invoiceCd = (String) param.get("InvoiceCd");
		fromDate = WebUtil.formatDateString(WebUtil.toDateForString(fromDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 00:00:00";
		endDate = WebUtil.formatDateString(WebUtil.toDateForString(endDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 23:59:59";
		String companyIds = getCompanyByUser(ul);
		// 结算内容，审核通过，回访合格
		String hql = "from ServiceHead sh,ServiceApply sa,Company c,ServiceVisit sv where sh.CompanyId = c.id and sh.id = sa.ServiceId and sh.id = sv.ServiceId and sv.VisitResult not in ('','电话无人','没有发生维修') and sa.ServiceApplyType = 'RATE' and sa.Status = 'NO_INVOICE' and sh.ApplyRateStatus = 'NO_INVOICE' and sh.CompanyId = ? and sa.ServiceApplyAuditedDate >= ? and sa.ServiceApplyAuditedDate < ?";
		if (companyIds != null)
			hql += " and sh.CompanyId in (" + companyIds + ")";
		List<Object[]> shList = this.getHibernateTemplate()
				.find(
						hql,
						new Object[] {
								new Integer(companyId),
								WebUtil.toDateForString(fromDate,
										"yyyy-MM-dd HH:mm:ss"),
								WebUtil.toDateForString(endDate,
										"yyyy-MM-dd HH:mm:ss") });
		if (WebUtil.isNullForList(shList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "没有结算内容");
			return result;
		}
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			Invoice i = new Invoice();
			i.setCtime(date);
			i.setCuser(ul.getUserName());
			i.setCompanyId(company.getId());
			i.setInvoiceCd(invoiceCd);
			i.setFromDate(WebUtil.toDateForString(fromDate,
					"yyyy-MM-dd HH:mm:ss"));
			i.setEndDate(WebUtil
					.toDateForString(endDate, "yyyy-MM-dd HH:mm:ss"));
			i
					.setInvoiceDate(WebUtil.toDateForString(invoiceDate,
							"yyyy-MM-dd"));
			i.setInvoiceNoticeDate(date);
			i.setInvoiceNoticePerson(ul.getUserName());
			i.setMemo((String)param.get("Memo"));
			double tecRate = 0;
			double homeRate = 0;
			double otherRate = 0;
			double allRate = 0;
			List invoiceItem = new ArrayList();
			Map<Integer,String> cm = new HashMap();
			for (Object[] obj : shList) {
				ServiceHead sh = (ServiceHead) obj[0];
				ServiceApply sa = (ServiceApply) obj[1];
				if(cm.get(sh.getId())!=null)
					continue;
				if (sa.getTecRate() != null)
					tecRate += sa.getTecRate().doubleValue();
				if (sa.getHomeRate() != null)
					homeRate += sa.getHomeRate().doubleValue();
				if (sa.getOtherRate() != null)
					otherRate += sa.getOtherRate().doubleValue();
				Map m = new HashMap();
				m.put("ServiceId", sh.getId());
				m.put("ServiceNo", sh.getServiceNo());
				m.put("MachineNo", sh.getMachineNo());
				m.put("MachineType", sh.getMachineType());
				m.put("ServiceAmt", sa.getTecRate());
				m.put("HomeAmt", sa.getHomeRate());
				m.put("OtherAmt", sa.getOtherRate());
				m.put("OtherMemo", sa.getOtherRateMemo());
				cm.put(sh.getId(), sh.getServiceNo());
			}
			allRate = tecRate + homeRate + otherRate;
			i.setServiceAmt(WebUtil.round(new BigDecimal(tecRate)));
			i.setHomeAmt(WebUtil.round(new BigDecimal(homeRate)));
			i.setOtherAmt(WebUtil.round(new BigDecimal(otherRate)));
			i.setTotalAmt(WebUtil.round(new BigDecimal(allRate)));
			i.setInvoiceStatus("INVOICE");
			session.save(i);
			cm.clear();
			for (Object[] obj : shList) {
				ServiceHead sh = (ServiceHead) obj[0];
				ServiceApply sa = (ServiceApply) obj[1];
				if(cm.get(sh.getId())!=null)
					continue;
				InvoiceServiceRef isr = new InvoiceServiceRef();
				InvoiceServiceRefPK pk = new InvoiceServiceRefPK();
				pk.setInvoiceId(i.getId());
				pk.setServiceId(sh.getId());
				isr.setId(pk);
				isr.setCompanyId(sh.getCompanyId());
				isr.setServiceAmt(sa.getTecRate());
				isr.setHomeAmt(sa.getHomeRate());
				isr.setOtherAmt(sa.getOtherRate());
				isr.setServiceApplyId(sa.getId());
				isr.setServiceNo(sh.getServiceNo());
				isr.setCtime(date);
				isr.setCuser(ul.getUserName());
				session.save(isr);
				sh.setApplyRateStatus("INVOICE");
				sh.setMtime(date);
				sh.setMuser(ul.getUserName());
				session.update(sh);
				sa.setStatus("INVOICE");
				sa.setMtime(date);
				sa.setMuser(ul.getUserName());
				session.update(sa);
				cm.put(sh.getId(), sh.getServiceNo());
			}

			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("InvoiceId", i.getId());
		} catch (HibernateException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
		} catch (RuntimeException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public Map saveInvoiceInfo(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl)) {
			result.put("Flag", "ERROR");
			result.put("Message", "用户公司信息不存在");
			return result;
		}
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory()) || !(c.getCategory().equals("RCN"))) {
			result.put("Flag", "ERROR");
			result.put("Message", "无权限查看");
			return result;
		}
		String invoiceId = (String) param.get("InvoiceId");
		StringBuffer hql = new StringBuffer();
		hql.append("from Invoice i where i.id = ?");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and i.CompanyId in (" + companyIds + ")");
		List<Invoice> invoiceList = this.getHibernateTemplate().find(
				hql.toString(), new Integer(invoiceId));
		if (WebUtil.isNullForList(invoiceList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到结算信息");
			return result;
		}
		Invoice i = invoiceList.get(0);
		if (WebUtil.isNotNull(param.get("InvoiceReceiveDate")))
			i.setInvoiceReceiveDate(WebUtil.toDateForString((String) param
					.get("InvoiceReceiveDate"), "yyyy-MM-dd"));
		if (WebUtil.isNotNull(param.get("PaymentDate")))
			i.setPaymentDate(WebUtil.toDateForString((String) param
					.get("PaymentDate"), "yyyy-MM-dd"));
		i.setMtime(new Date());
		i.setMuser(ul.getUserName());
		i.setMemo((String)param.get("Memo"));
		this.getHibernateTemplate().update(i);
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map invoiceFileUpload(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl)) {
			result.put("Flag", "ERROR");
			result.put("Message", "用户公司信息不存在");
			return result;
		}
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory()) || !(c.getCategory().equals("RCN"))) {
			result.put("Flag", "ERROR");
			result.put("Message", "无权限查看");
			return result;
		}
		String invoiceId = (String) param.get("InvoiceId");
		String fileUrl = (String) param.get("FileUrl");
		String fileType = (String) param.get("FileType");
		String fileName = (String) param.get("FileName");
		Long fileSize = (Long) param.get("FileSize");
		StringBuffer hql = new StringBuffer();
		hql.append("from Invoice i where i.id = ?");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and i.CompanyId in (" + companyIds + ")");
		List<Invoice> invoiceList = this.getHibernateTemplate().find(
				hql.toString(), new Integer(invoiceId));
		if (WebUtil.isNullForList(invoiceList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到结算信息");
			return result;
		}
		Invoice i = invoiceList.get(0);
		i.setMtime(new Date());
		i.setMuser(ul.getUserName());
		i.setInvoiceUrl(fileUrl);
		this.getHibernateTemplate().update(i);
		result.put("InvoiceId", i.getId().toString());
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map completeInvoice(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<Company> cl = this.getHibernateTemplate().find(
				"from Company where Status = 'NORMAL' and id = ?",
				ul.getCompanyId());
		if (WebUtil.isNullForList(cl)) {
			result.put("Flag", "ERROR");
			result.put("Message", "用户公司信息不存在");
			return result;
		}
		Company c = cl.get(0);
		if (WebUtil.isNull(c.getCategory()) || !(c.getCategory().equals("RCN"))) {
			result.put("Flag", "ERROR");
			result.put("Message", "无权限查看");
			return result;
		}
		String invoiceId = (String) param.get("InvoiceId");
		StringBuffer hql = new StringBuffer();
		hql.append("from Invoice i where i.id = ?");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and i.CompanyId in (" + companyIds + ")");
		List<Invoice> invoiceList = this.getHibernateTemplate().find(
				hql.toString(), new Integer(invoiceId));
		if (WebUtil.isNullForList(invoiceList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到结算信息");
			return result;
		}
		Invoice i = invoiceList.get(0);
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			if (WebUtil.isNotNull(param.get("InvoiceDate")))
				i.setInvoiceDate(WebUtil.toDateForString((String) param
						.get("InvoiceDate"), "yyyy-MM-dd"));
			if (WebUtil.isNotNull(param.get("InvoiceReceiveDate")))
				i.setInvoiceReceiveDate(WebUtil.toDateForString((String) param
						.get("InvoiceReceiveDate"), "yyyy-MM-dd"));
			if (WebUtil.isNotNull(param.get("PaymentDate")))
				i.setPaymentDate(WebUtil.toDateForString((String) param
						.get("PaymentDate"), "yyyy-MM-dd"));
			i.setMemo((String)param.get("Memo"));
			i.setInvoiceStatus("INVOICE_COMPLETE");
			Date date = new Date();
			i.setMtime(date);
			i.setMuser(ul.getUserName());
			session.update(i);
			session
					.createQuery(
							"update ServiceApply set Status = 'INVOICE_COMPLETE',mtime='"
									+ WebUtil.formatDateString(date,
											"yyyy-MM-dd HH:mm:ss")
									+ "',muser='"
									+ ul.getUserName()
									+ "' where id in (select ServiceApplyId from InvoiceServiceRef where id.InvoiceId = "
									+ i.getId() + ")").executeUpdate();
			session
					.createQuery(
							"update ServiceHead set ApplyRateStatus = 'INVOICE_COMPLETE',mtime='"
									+ WebUtil.formatDateString(date,
											"yyyy-MM-dd HH:mm:ss")
									+ "',muser='"
									+ ul.getUserName()
									+ "' where id in (select id.ServiceId from InvoiceServiceRef where id.InvoiceId = "
									+ i.getId() + ")").executeUpdate();
			tx.commit();
			result.put("Flag", "SUCCESS");
		} catch (HibernateException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
		} catch (RuntimeException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

}
