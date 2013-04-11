package com.sunmw.web.bean.serviceOrder.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunmw.web.bean.serviceOrder.ServiceCsServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.ServiceHead;
import com.sunmw.web.entity.ServiceVisit;
import com.sunmw.web.entity.Unit;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class ServiceCsServicesImpl extends HibernateDaoSupport implements
		ServiceCsServices {

	public Map searchServiceVisit(Map param, int currentPage, int pageRow) {
		UserLogin ul = (UserLogin) param.get("UserLogin");

		StringBuffer hql = new StringBuffer();
		hql
				.append("from ServiceVisit sv,ServiceHead sh,Company c where sv.ServiceId = sh.id and sh.CompanyId = c.id ");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and sh.CompanyId in (" + companyIds + ")");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("CompanyName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" c.CompanyName like :Condition" + conList.size());
			conList.add("%" + param.get("CompanyName") + "%");
		}
		if (!WebUtil.isNull(param.get("VisitPeople"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sv.Cuser like :Condition" + conList.size());
			conList.add("%" + param.get("VisitPeople") + "%");
		}
		if (!WebUtil.isNull(param.get("ServiceNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sv.ServiceNo = :Condition" + conList.size());
			conList.add(param.get("ServiceNo"));
		}
		if (!WebUtil.isNull(param.get("VisitFromDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sv.Ctime >= :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get("VisitFromDate")
					.toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("VisitEndDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sv.Ctime < :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get("VisitEndDate")
					.toString(), "yyyy-MM-dd"));
		}
		if (con.length() > 0)
			hql.append(" and " + con.toString());

		Session session = this.getSession();
		Map result = null;
		try {
			Query q1 = session.createQuery("select count(*) " + hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q1.setParameter("Condition" + i, conList.get(i));
			}
			List<Long> countList = q1.list();
			int count = countList.get(0).intValue();
			hql.append(" order by sv.Ctime desc");
			Query q = session
					.createQuery("select sv.id,sv.ServiceId,sv.ServiceNo,sv.Status,sv.VisitFlag,sv.VisitResult,sv.VisitMemo,sv.Ctime,sv.Cuser,c.CompanyName,sv.ServiceVisitNo "
							+ hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q.setParameter("Condition" + i, conList.get(i));
			}
			if (pageRow > 0) {
				q.setFirstResult((currentPage - 1) * pageRow);
				q.setMaxResults(pageRow);
			}
			result = new HashMap();
			List<Object[]> l = q.list();
			Map statusMap = getUnitMap("'VISIT_STATUS'");
			List<Map> r = new ArrayList();
			for (Object[] obj : l) {
				Map m = new HashMap();
				m.put("ServiceVisiId", obj[0]);
				m.put("ServiceId", obj[1]);
				m.put("ServiceNo", obj[2]);
				m.put("Status", obj[3]);
				m.put("VisitFlag", obj[4]);
				m.put("VisitResult", obj[5]);
				m.put("VisitMemo", obj[6]);
				if (WebUtil.isNotNull(obj[7]))
					m.put("Ctime", WebUtil.formatDateString((Date) obj[7],
							"yyyy-MM-dd HH:mm"));
				m.put("Cuser", obj[8]);
				m.put("ServiceStatusName", statusMap.get("VISIT_STATUS"
						+ obj[3]));
				m.put("CompanyName", obj[9]);
				m.put("ServiceVisitNo", obj[10]);
				r.add(m);
			}
			result.put("RESULT", r);
			result.put("COUNT_ROW", count);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} finally {
			if (session != null&&session.isOpen())
				session.close();
		}
		return result;
	}
	
	public Map searchNoVisitServiceOrder(Map param, int currentPage, int pageRow) {
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		StringBuffer hql = new StringBuffer();
		hql
				.append(" from ServiceHead sh,Company c,ServiceApply sa where sh.CompanyId = c.id and sa.ServiceId = sh.id and sh.ServiceStatus = 'REPAIR_COMPLETE' and sh.VisitStatus = 'NO_VISIT' and sh.ApplyRateStatus = 'NO_INVOICE' and sa.ServiceApplyType = 'RATE'");
		if (companyIds != null)
			hql.append(" and sh.CompanyId in (" + companyIds + ")");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("CompanyName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" c.CompanyName like :Condition" + conList.size());
			conList.add("%" + param.get("CompanyName") + "%");
		}
		if (!WebUtil.isNull(param.get("ServiceNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceNo = :Condition" + conList.size());
			conList.add(param.get("ServiceNo"));
		}
		String fromDate = (String) param.get("FromServiceApplyAuditedDate");
		String endDate = (String) param.get("EndServiceApplyAuditedDate");
		if(WebUtil.isNotNull(fromDate))
		{
		fromDate = WebUtil.formatDateString(WebUtil.toDateForString(fromDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 00:00:00";
		}
		if(WebUtil.isNotNull(endDate))
		{
		endDate = WebUtil.formatDateString(WebUtil.toDateForString(endDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 23:59:59";
		}
		if (!WebUtil.isNull(fromDate)) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sa.ServiceApplyAuditedDate >= :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(fromDate, "yyyy-MM-dd HH:mm:ss"));
		}
		if (!WebUtil.isNull(endDate)) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sa.ServiceApplyAuditedDate < :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(endDate, "yyyy-MM-dd HH:mm:ss"));
		}
		if (con.length() > 0)
			hql.append(" and " + con.toString());

		Session session = this.getSession();
		Map result = null;
		try {
			Query q1 = session.createQuery("select count(*) " + hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q1.setParameter("Condition" + i, conList.get(i));
			}
			List<Long> countList = q1.list();
			int count = countList.get(0).intValue();
			hql.append(" order by sh.ServiceNo desc");
			Query q = session
					.createQuery("select sh.id,sh.ServiceNo,sh.MachineNo,sh.ServiceDate,sh.ServiceStatus,sa.ServiceApplyAuditedDate "
							+ hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q.setParameter("Condition" + i, conList.get(i));
			}
			if (pageRow > 0) {
				q.setFirstResult((currentPage - 1) * pageRow);
				q.setMaxResults(pageRow);
			}
			result = new HashMap();
			List<Object[]> l = q.list();
			Map statusMap = getUnitMap("'SERVICE_STATUS'");
			List<Map> r = new ArrayList();
			StringBuffer machineNos = new StringBuffer();
			for(Object[] obj : l)
			{
				if(machineNos.length()>0)
					machineNos.append(",");
				machineNos.append("'"+obj[2]+"'");
			}
			Map<Object,Object> mtMap = new HashMap();
			List<Object[]> mtList = this.getHibernateTemplate().find("select m.MachineNo,mt.MachineType from Machine m,MachineType mt where m.MachineTypeId = mt.id and m.MachineNo in ("+machineNos.toString()+")");
			if(!WebUtil.isNullForList(mtList))
			{
				for(Object[] mt:mtList)
				{
					mtMap.put(mt[0].toString().toUpperCase(), mt[1]);
				}
			}
			for (Object[] obj : l) {
				Map m = new HashMap();
				m.put("ServiceId", obj[0]);
				m.put("ServiceNo", obj[1]);
				m.put("MachineType", mtMap.get(obj[2].toString().toUpperCase()));
				m.put("MachineNo", obj[2]);
				if (WebUtil.isNotNull(obj[3]))
					m.put("ServiceDate", WebUtil.formatDateString(
							(Date) obj[3], "yyyy-MM-dd"));
				m.put("ServiceStatus", obj[4]);
				m.put("ServiceStatusName", statusMap.get("SERVICE_STATUS"
						+ obj[4]));
				if (WebUtil.isNotNull(obj[5]))
					m.put("ServiceApplyAuditedDate", WebUtil.formatDateString(
							(Date) obj[5], "yyyy-MM-dd"));
				r.add(m);
			}
			result.put("RESULT", r);
			result.put("COUNT_ROW", count);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} finally {
			if (session != null&&session.isOpen())
				session.close();
		}
		return result;
	}

	public Map searchNoVisitServiceOrderBack(Map param, int currentPage, int pageRow) {
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		StringBuffer hql = new StringBuffer();
		hql
				.append(" from ServiceHead sh,Company c,Machine m,MachineType mt,ServiceApply sa where sh.CompanyId = c.id and sh.MachineNo=m.MachineNo and sa.ServiceId = sh.id and m.MachineTypeId = mt.id and sh.ServiceStatus = 'REPAIR_COMPLETE' and sh.VisitStatus = 'NO_VISIT' and sh.ApplyRateStatus = 'NO_INVOICE' and sa.ServiceApplyType = 'RATE'");
		if (companyIds != null)
			hql.append(" and sh.CompanyId in (" + companyIds + ")");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("CompanyName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" c.CompanyName like :Condition" + conList.size());
			conList.add("%" + param.get("CompanyName") + "%");
		}
		if (!WebUtil.isNull(param.get("ServiceNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceNo = :Condition" + conList.size());
			conList.add(param.get("ServiceNo"));
		}
		String fromDate = (String) param.get("FromServiceApplyAuditedDate");
		String endDate = (String) param.get("EndServiceApplyAuditedDate");
		if(WebUtil.isNotNull(fromDate))
		{
		fromDate = WebUtil.formatDateString(WebUtil.toDateForString(fromDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 00:00:00";
		}
		if(WebUtil.isNotNull(endDate))
		{
		endDate = WebUtil.formatDateString(WebUtil.toDateForString(endDate,
				"yyyy-MM-dd"), "yyyy-MM-dd")
				+ " 23:59:59";
		}
		if (!WebUtil.isNull(fromDate)) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sa.ServiceApplyAuditedDate >= :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(fromDate, "yyyy-MM-dd HH:mm:ss"));
		}
		if (!WebUtil.isNull(endDate)) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sa.ServiceApplyAuditedDate < :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(endDate, "yyyy-MM-dd HH:mm:ss"));
		}
		if (con.length() > 0)
			hql.append(" and " + con.toString());

		Session session = this.getSession();
		Map result = null;
		try {
			Query q1 = session.createQuery("select count(*) " + hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q1.setParameter("Condition" + i, conList.get(i));
			}
			List<Long> countList = q1.list();
			int count = countList.get(0).intValue();
			hql.append(" order by sh.ServiceNo desc");
			Query q = session
					.createQuery("select sh.id,sh.ServiceNo,mt.MachineType,sh.MachineNo,sh.ServiceDate,sh.ServiceStatus,sa.ServiceApplyAuditedDate "
							+ hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q.setParameter("Condition" + i, conList.get(i));
			}
			if (pageRow > 0) {
				q.setFirstResult((currentPage - 1) * pageRow);
				q.setMaxResults(pageRow);
			}
			result = new HashMap();
			List<Object[]> l = q.list();
			Map statusMap = getUnitMap("'SERVICE_STATUS'");
			List<Map> r = new ArrayList();
			for (Object[] obj : l) {
				Map m = new HashMap();
				m.put("ServiceId", obj[0]);
				m.put("ServiceNo", obj[1]);
				m.put("MachineType", obj[2]);
				m.put("MachineNo", obj[3]);
				if (WebUtil.isNotNull(obj[4]))
					m.put("ServiceDate", WebUtil.formatDateString(
							(Date) obj[4], "yyyy-MM-dd"));
				m.put("ServiceStatus", obj[5]);
				m.put("ServiceStatusName", statusMap.get("SERVICE_STATUS"
						+ obj[5]));
				if (WebUtil.isNotNull(obj[6]))
					m.put("ServiceApplyAuditedDate", WebUtil.formatDateString(
							(Date) obj[6], "yyyy-MM-dd"));
				r.add(m);
			}
			result.put("RESULT", r);
			result.put("COUNT_ROW", count);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RuntimeException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} finally {
			if (session != null&&session.isOpen())
				session.close();
		}
		return result;
	}

	private Map getUnitMap(String unitType) {
		List<Unit> ul = this.getHibernateTemplate().find(
				"from Unit where UnitType in (" + unitType + ")");
		Map m = new HashMap();
		for (Unit u : ul) {
			m.put(u.getUnitType() + u.getUnitNo(), u.getUnitName());
		}
		return m;
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

	public Map visitServiceOrder(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String serviceId = (String) param.get("ServiceId");
		Session session = this.getSession();
		try {
			String companyIds = getCompanyByUser(ul);
			// 检查维修单是否存在
			String hql = "from ServiceHead where id = :ServiceId";
			if (companyIds != null)
				hql += " and CompanyId in (" + companyIds + ")";
			Query q1 = session.createQuery(hql);
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> shl = q1.list();
			if (WebUtil.isNullForList(shl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				return result;
			}
			ServiceHead sh = shl.get(0);
			// 检查维修单状态是否可修改
			// 维修状态：已修复；申请费用状态：通过未结；回访状态：未回访
			if (!(sh.getServiceStatus().equals("REPAIR_COMPLETE")
					&& sh.getApplyRateStatus().equals("NO_INVOICE") && sh
					.getVisitStatus().equals("NO_VISIT"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单不能回访");
				return result;
			}
			List<ServiceVisit> svList = this.getHibernateTemplate().find(
					"from ServiceVisit where ServiceId = ?", sh.getId());
			if (!WebUtil.isNullForList(svList)) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单已经回访");
				return result;
			}
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			sh.setVisitStatus("VISIT");
			sh.setMtime(date);
			sh.setMuser(ul.getUserName());
			session.update(sh);
			ServiceVisit sv = new ServiceVisit();
			sv.setCtime(date);
			sv.setCuser(ul.getUserName());
			sv.setServiceId(sh.getId());
			sv.setServiceNo(sh.getServiceNo());
			sv.setStatus("VISIT");
			sv.setVisitFlag((String) param.get("VisitFlag"));
			sv.setVisitMemo((String) param.get("VisitMemo"));
			sv.setVisitResult((String) param.get("VisitResult"));
			if (WebUtil.isNotNull(sh.getServiceNo()))
				sv.setServiceVisitNo("SFVC" + sh.getServiceNo().substring(1)
						+ "1");
			session.save(sv);

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
			if (session != null&&session.isOpen())
				session.close();
		}
		return result;
	}

	public Map serviceVisitInfo(Map param) {
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
						"CC"))) {
			result.put("Flag", "ERROR");
			result.put("Message", "无权限查看");
			return result;
		}
		String serviceVisitId = (String) param.get("ServiceVisitId");
		if(!WebUtil.isNumeric(serviceVisitId))
		{
			result.put("Flag", "ERROR");
			result.put("Message", "未找到回访记录");
			return result;
		}
		List<ServiceVisit> svList = this.getHibernateTemplate().find(
				"from ServiceVisit where id = ?", new Integer(serviceVisitId));
		if (WebUtil.isNullForList(svList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "未找到回访记录");
			return result;
		}
		ServiceVisit sv = svList.get(0);
		result.put("ServiceVisitId", sv.getId());
		result.put("ServiceId", sv.getServiceId());
		result.put("ServiceNo", sv.getServiceNo());
		result.put("ServiceVisitNo", sv.getServiceVisitNo());
		result.put("Status", sv.getStatus());
		result.put("VisitFlag", sv.getVisitFlag());
		result.put("VisitResult", sv.getVisitResult());
		result.put("VisitMemo", sv.getVisitMemo());
		if (WebUtil.isNotNull(sv.getCtime()))
			result.put("Ctime", WebUtil.formatDateString(sv.getCtime(),
					"yyyy-MM-dd HH:mm"));
		result.put("Cuser", sv.getCuser());
		result.put("Flag", "SUCCESS");
		return result;
	}

}
