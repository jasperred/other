package com.sunmw.web.bean.serviceOrder.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunmw.web.bean.serviceOrder.ServiceOrderServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.Inventory;
import com.sunmw.web.entity.InventoryLog;
import com.sunmw.web.entity.Machine;
import com.sunmw.web.entity.MachineFile;
import com.sunmw.web.entity.MachineType;
import com.sunmw.web.entity.ServiceApply;
import com.sunmw.web.entity.ServiceApplyFile;
import com.sunmw.web.entity.ServiceDeliveryItem;
import com.sunmw.web.entity.ServiceFault;
import com.sunmw.web.entity.ServiceHead;
import com.sunmw.web.entity.ServiceItem;
import com.sunmw.web.entity.ServiceOrderFile;
import com.sunmw.web.entity.ServiceOrderFilePK;
import com.sunmw.web.entity.ServiceVisit;
import com.sunmw.web.entity.Unit;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class ServiceOrderServicesImpl extends HibernateDaoSupport implements
		ServiceOrderServices {

	static Logger logger = Logger.getLogger(ServiceOrderServicesImpl.class);

	public Map searchServiceOrder(Map param, int currentPage, int pageRow) {
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		StringBuffer hql = new StringBuffer();
		hql
				.append(" from ServiceHead sh,Company c,Machine m,MachineType mt where sh.CompanyId = c.id and sh.MachineNo=m.MachineNo and m.MachineTypeId = mt.id");
		if (companyIds != null)
			hql.append(" and sh.CompanyId in (" + companyIds + ")");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("ShopName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" c.CompanyName like :Condition" + conList.size());
			conList.add("%" + param.get("ShopName") + "%");
		}
		if (!WebUtil.isNull(param.get("FixPeople"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.FixPeople like :Condition" + conList.size());
			conList.add("%" + param.get("FixPeople") + "%");
		}
		if (!WebUtil.isNull(param.get("ServiceNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceNo = :Condition" + conList.size());
			conList.add(param.get("ServiceNo"));
		}
		if (!WebUtil.isNull(param.get("MachineNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.MachineNo = :Condition" + conList.size());
			conList.add(param.get("MachineNo"));
		}
		if (!WebUtil.isNull(param.get("MachineTypeId"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" m.MachineTypeId = :Condition" + conList.size());
			conList.add(new Integer(param.get("MachineTypeId").toString()));
		}
		if (!WebUtil.isNull(param.get("MachineTypeName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" mt.MachineType like :Condition" + conList.size());
			conList.add("%" + param.get("MachineTypeName").toString() + "%");
		}
		if (!WebUtil.isNull(param.get("ServiceDateStatus"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceDateStatus = :Condition" + conList.size());
			conList.add(param.get("ServiceDateStatus"));
		}
		if (!WebUtil.isNull(param.get("ServiceMethod"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceMethod = :Condition" + conList.size());
			conList.add(param.get("ServiceMethod"));
		}
		if (!WebUtil.isNull(param.get("ServiceContract"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceContract = :Condition" + conList.size());
			conList.add(param.get("ServiceContract"));
		}
		if (!WebUtil.isNull(param.get("ServiceOperation"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceOperation = :Condition" + conList.size());
			conList.add(param.get("ServiceOperation"));
		}
		if (!WebUtil.isNull(param.get("CustomerName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.CustomerName like :Condition" + conList.size());
			conList.add("%" + param.get("CustomerName") + "%");
		}
		if (!WebUtil.isNull(param.get("ThruTime"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ThruTime = :Condition" + conList.size());
			conList.add(param.get("ThruTime"));
		}
		if (!WebUtil.isNull(param.get("ActionNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con
					.append(" sh.id in (select ServiceId from ServiceFault where FaultType = 'ACTION' and FaultNo = :Condition"
							+ conList.size() + ")");
			// con.append(" sf.FaultNo = :Condition"+conList.size());
			conList.add(param.get("ActionNo"));
		}
		if (!WebUtil.isNull(param.get("SymptomNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con
					.append(" sh.id in (select ServiceId from ServiceFault where FaultType = 'SYMPTOM' and FaultNo = :Condition"
							+ conList.size() + ")");
			conList.add(param.get("SymptomNo"));
		}
		if (!WebUtil.isNull(param.get("CauseNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con
					.append(" sh.id in (select ServiceId from ServiceFault where FaultType = 'CAUSE' and FaultNo = :Condition"
							+ conList.size() + ")");
			conList.add(param.get("CauseNo"));
		}
		if (!WebUtil.isNull(param.get("LocationNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con
					.append(" sh.id in (select ServiceId from ServiceFault where FaultType = 'LOCATION' and FaultNo = :Condition"
							+ conList.size() + ")");
			conList.add(param.get("LocationNo"));
		}
		if (!WebUtil.isNull(param.get("ServiceStatus"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceStatus = :Condition" + conList.size());
			conList.add(param.get("ServiceStatus"));
		}
		if (!WebUtil.isNull(param.get("ItemNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con
					.append(" sh.id in (select ServiceId from ServiceItem where ItemNo = :Condition"
							+ conList.size() + ")");
			conList.add(param.get("ItemNo"));
		}
		if (!WebUtil.isNull(param.get("FromServiceDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceDate >= :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get("FromServiceDate")
					.toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("EndServiceDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceDate < :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get("EndServiceDate")
					.toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("FromServiceFinishDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceFinishDate >= :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get(
					"FromServiceFinishDate").toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("EndServiceFinishDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceFinishDate < :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get(
					"EndServiceFinishDate").toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("FromCustomerRetrieveDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.CustomerRetrieveDate >= :Condition"
					+ conList.size());
			conList.add(WebUtil.toDateForString(param.get(
					"FromCustomerRetrieveDate").toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("EndCustomerRetrieveDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con
					.append(" sh.CustomerRetrieveDate < :Condition"
							+ conList.size());
			conList.add(WebUtil.toDateForString(param.get(
					"EndCustomerRetrieveDate").toString(), "yyyy-MM-dd"));
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
					.createQuery("select distinct sh.id,sh.ServiceNo,mt.MachineType,sh.MachineNo,sh.ServiceDate,sh.ServiceStatus,c.CompanyName"
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
				m.put("CompanyName", obj[6]);
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

	public Map searchServiceOrderByStatus(Map param, int currentPage,
			int pageRow) {
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		StringBuffer hql = new StringBuffer();
		hql
				.append(" from ServiceHead sh,Company c,Machine m,MachineType mt where sh.CompanyId = c.id and sh.MachineNo=m.MachineNo and m.MachineTypeId = mt.id");
		if (companyIds != null)
			hql.append(" and sh.CompanyId in (" + companyIds + ")");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("ShopName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" c.CompanyName like :Condition" + conList.size());
			conList.add("%" + param.get("ShopName") + "%");
		}
		if (!WebUtil.isNull(param.get("ServiceStatus"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sh.ServiceStatus = :Condition" + conList.size());
			conList.add(param.get("ServiceStatus"));
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
					.createQuery("select sh.id,sh.ServiceNo,mt.MachineType,sh.MachineNo,sh.ServiceDate,sh.ServiceStatus,c.CompanyName"
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
				m.put("CompanyName", obj[6]);
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

	public Map createServiceOrder(Map param) {
		Map result = new HashMap();
		String machineNo = (String) param.get("MachineNo");
		List<Object[]> ml = this
				.getHibernateTemplate()
				.find(
						"from Machine m,MachineType mt where m.MachineTypeId = mt.id and m.MachineNo = ?",
						machineNo);
		if (WebUtil.isNullForList(ml)) {
			result.put("Flag", "ERROR");
			result.put("Message", "无出库信息");
			return result;
		}
		UserLogin ul = (UserLogin) param.get("UserLogin");
		Object[] obj = ml.get(0);
		Machine m = (Machine) obj[0];
		MachineType mt = (MachineType) obj[1];
		// 维修能力判断，公司必须存在且正常状态
		List<Object[]> cl = this
				.getHibernateTemplate()
				.find(
						"from CompanyMachineTypeRef cmtr,Company c where cmtr.id.CompanyId = c.id and c.Status = 'NORMAL' and cmtr.id.CompanyId = ? and cmtr.id.MachineTypeId = ?",
						new Object[] { ul.getCompanyId(), m.getMachineTypeId() });

		if (WebUtil.isNullForList(cl)) {
			result.put("Flag", "ERROR");
			result.put("Message", "贵公司没有该机型维护能力");
			return result;
		}
		if (WebUtil.isNotNull(m.getStatus())
				&& m.getStatus().equals("REPAIRING")) {
			result.put("Flag", "ERROR");
			result.put("Message", "该机器正在维修中...");
			return result;
		}
		if (WebUtil.isNotNull(m.getStatus()) && m.getStatus().equals("CHANGE")) {
			result.put("Flag", "ERROR");
			result.put("Message", "该机器已换货");
			return result;
		}
		if (WebUtil.isNull(mt.getServiceProviderType())) {
			result.put("Flag", "ERROR");
			result.put("Message", "机型信息错误,[保修期内服务商]无内容");
			return result;
		}
		Object[] cc = cl.get(0);
		Company c = (Company) cc[1];
		if (c == null || c.getCompanyNo() == null) {
			result.put("Flag", "ERROR");
			result.put("Message", "公司信息错误");
			return result;
		}
		if (c.getCategory() == null || !c.getCategory().equals("SHOP")) {
			result.put("Flag", "ERROR");
			result.put("Message", "只有特约店才能受理维修单");
			return result;
		}
		Session session = this.getSession();
		ServiceHead sh;
		try {
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			sh = new ServiceHead();
			// 设置维修单各种状态
			sh.setServiceStatus("REPAIRING");// 维修状态
			sh.setApplyRateStatus("NO_APPLY");// 费用申请状态
			sh.setApplyPartStatus("NO_APPLY");// 零件申请状态
			sh.setApplyMachineStatus("NO_APPLY");// 整机申请状态
			sh.setVisitStatus("NO_VISIT");// 回访状态
			sh.setMachineNo(machineNo);
			sh.setMachineType(mt.getMachineType());
			// 技术费
			if (mt.getServiceProviderType().equals("特约维修店")) {
				sh.setApplyTecRate(WebUtil.round(mt.getRate1()));
			} else if (mt.getServiceProviderType().equals("销售商服务")) {
				sh.setApplyTecRate(WebUtil.round(mt.getRate2()));
			}
			sh.setLastDate(m.getLastTime());// 上次故障受理日
			sh.setCompanyId(ul.getCompanyId());
			sh.setCreateName(ul.getUserName());
			sh.setServiceDate(date);// 受理日默认时间
			sh.setCreateTime(date);
			sh.setCtime(date);
			sh.setCuser(ul.getUserName());
			Date serviceEndDate = null;
			// 保修期结束日
			if (WebUtil.isNotNull(m.getServiceEndDate())) {
				serviceEndDate = m.getServiceEndDate();

			}
			// 发票日期判断
			else if (WebUtil.isNotNull(m.getInvoiceDate())) {

				Date d = WebUtil.toDateForString(WebUtil.formatDateString(m
						.getInvoiceDate(), "yyyy-MM-dd"), "yyyy-MM-dd");
				serviceEndDate = WebUtil.toDateForString(WebUtil
						.ofterMonthDate(new Date(d.getTime() - 24 * 60 * 60
								* 1000), 12), "yyyy-MM-dd");

			}
			// 保修期开始日判断
			else if (WebUtil.isNotNull(m.getServiceFromDate())) {
				Date d = WebUtil.toDateForString(WebUtil.formatDateString(m
						.getServiceFromDate(), "yyyy-MM-dd"), "yyyy-MM-dd");
				serviceEndDate = WebUtil.toDateForString(WebUtil
						.ofterMonthDate(new Date(d.getTime() - 24 * 60 * 60
								* 1000), 15), "yyyy-MM-dd");

			}
			// 出库日期判断
			else if (WebUtil.isNotNull(m.getOutDate())) {
				Date d = WebUtil.toDateForString(WebUtil.formatDateString(m
						.getOutDate(), "yyyy-MM-dd"), "yyyy-MM-dd");
				serviceEndDate = WebUtil.toDateForString(WebUtil
						.ofterMonthDate(new Date(d.getTime() - 24 * 60 * 60
								* 1000), 15), "yyyy-MM-dd");
			}
			sh.setServiceEndDate(serviceEndDate);
			// 保修期判断
			if (WebUtil.isNotNull(m.getInvoiceDate())
					|| WebUtil.isNotNull(m.getOutDate())) {
				long d;
				if (WebUtil.isNotNull(m.getInvoiceDate()))
					d = WebUtil.toDateForString(
							WebUtil.ofterMonthDate(WebUtil.toDateForString(
									WebUtil.formatDateString(
											m.getInvoiceDate(), "yyyy-MM-dd"),
									"yyyy-MM-dd"), 12), "yyyy-MM-dd").getTime();
				else
					d = WebUtil.toDateForString(
							WebUtil.ofterMonthDate(WebUtil.toDateForString(
									WebUtil.formatDateString(m.getOutDate(),
											"yyyy-MM-dd"), "yyyy-MM-dd"), 15),
							"yyyy-MM-dd").getTime();
				if (d >= date.getTime() - 24 * 60 * 60 * 1000L) {
					sh.setServiceDateStatus("保修期内");
				} else {
					if (WebUtil.isNotNull(m.getServiceEndDate())) {
						d = WebUtil.toDateForString(
								WebUtil.formatDateString(m.getServiceEndDate(),
										"yyyy-MM-dd"), "yyyy-MM-dd").getTime();
						if (d >= date.getTime() - 24 * 60 * 60 * 1000L) {
							sh.setServiceDateStatus("维护合同期");
						} else {
							sh.setServiceDateStatus("保修期外");
						}
					}
				}
			}
			// 得到维修单编号
			Query q = session
					.createSQLQuery("{call Ap_GenerateServiceNo(?,?)}");
			q.setParameter(0, c.getCompanyNo());
			q.setParameter(1, "R");
			List<String> l = q.list();
			if (WebUtil.isNullForList(l)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单号生成错误");
				session.close();
				return result;
			}
			sh.setServiceNo(l.get(0));
			session.save(sh);
			// 设置机器状态为维修中
			m.setStatus("REPAIRING");
			m.setLastTime(date);
			m.setLastCompanyId(ul.getCompanyId());
			session.update(m);
			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("ServiceId", sh.getId().toString());
			result.put("ServiceNo", sh.getServiceNo());
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

	public Map newServiceOrderInfo(Map param) {
		Map result = new HashMap();
		String serviceId = (String) param.get("ServiceId");
		if(!WebUtil.isNumeric(serviceId))
		{
			result.put("Flag", "ERROR");
			result.put("Message", "找不到维修单信息");
			return result;
		}
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		String hql = "from ServiceHead sh,Company c,Machine m,MachineType mt where sh.CompanyId = c.id and sh.MachineNo = m.MachineNo and m.MachineTypeId = mt.id and sh.id = ? ";
		if (companyIds != null)
			hql += " and sh.CompanyId in (" + companyIds + ")";
		List<Object[]> shList = this.getHibernateTemplate().find(hql,
				new Integer(serviceId));
		if (WebUtil.isNullForList(shList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到维修单信息");
			return result;
		}
		Object[] obj = shList.get(0);
		ServiceHead sh = (ServiceHead) obj[0];
		Company c = (Company) obj[1];
		Machine m = (Machine) obj[2];
		MachineType mt = (MachineType) obj[3];
		// 维修信息
		result.put("ServiceId", sh.getId());
		result.put("ServiceType", sh.getServiceType());
		result.put("ServiceNo", sh.getServiceNo());
		result.put("MachineNo", sh.getMachineNo());
		result.put("CompanyId", sh.getCompanyId());
		result.put("CompanyName", c.getCompanyName());
		result.put("MachineTypeId", m.getMachineTypeId());
		result.put("MachineTypeName", mt.getMachineType());
		result.put("MachineTypeCat", mt.getMachineCat());
		result.put("MachineCd", mt.getMachineCd());
		result.put("ServiceDateStatus", sh.getServiceDateStatus());
		result.put("ServiceEndDate", sh.getServiceEndDate());
		result.put("InvoiceDate", m.getInvoiceDate());
		result.put("ServiceFromDate", m.getServiceFromDate());
		result.put("OutDate", m.getOutDate());
		result.put("LastDate", sh.getLastDate());
		result.put("ServiceDate", sh.getServiceDate());
		result.put("FromDate", sh.getFromDate());
		result.put("EndDate", sh.getEndDate());
		result.put("ServiceMethod", sh.getServiceMethod());
		result.put("ServiceContract", sh.getServiceContract());
		result.put("ServiceOperation", sh.getServiceOperation());
		result.put("BlackWhiteNumber", sh.getBlackWhiteNumber());
		result.put("ColorNumber", sh.getColorNumber());
		result.put("PlateNumber", sh.getPlateNumber());
		result.put("PartOrMachine", sh.getPartOrMachine());
		result.put("MichaneMemo", sh.getMachineMemo());
		result.put("CustomerCompany", sh.getCustomerCompany());
		result.put("CustomerNo", sh.getCustomerNo());
		result.put("CustomerZip", sh.getCustomerZip());
		result.put("CustomerName", sh.getCustomerName());
		result.put("CustomerTel", sh.getCustomerTel());
		result.put("CustomerAddress1", sh.getCustomerAddress1());
		result.put("CustomerAddress2", sh.getCustomerAddress2());
		result.put("CustomerAddress3", sh.getCustomerAddress3());
		result.put("CustomerAddress4", sh.getCustomerAddress4());
		result.put("CustomerAddress5", sh.getCustomerAddress5());
		result.put("CreateTime", sh.getCreateTime());
		result.put("CreateName", sh.getCreateName());
		//机器相关信息 2012-08-16
		result.put("MachinePaymentStatus", m.getPaymentStatus());
		result.put("MachinePaymentCompany", m.getPaymentCompany());
		result.put("MachinePaymentDate", m.getPaymentDate());
		
		// 状态
		Map statusMap = getUnitMap("'SERVICE_STATUS','APPLY_RATE_STATUS','APPLY_PART_STATUS','VISIT_STATUS'");
		result.put("ServiceStatus", sh.getServiceStatus());
		result.put("ServiceStatusName", statusMap.get("SERVICE_STATUS"
				+ sh.getServiceStatus()));
		result.put("ApplyRateStatus", sh.getApplyRateStatus());
		result.put("ApplyRateStatusName", statusMap.get("APPLY_RATE_STATUS"
				+ sh.getApplyRateStatus()));
		result.put("ApplyPartStatus", sh.getApplyPartStatus());
		result.put("ApplyPartStatusName", statusMap.get("APPLY_PART_STATUS"
				+ sh.getApplyPartStatus()));
		result.put("ApplyMachineStatus", sh.getApplyMachineStatus());
		result.put("ApplyMachineStatusName", statusMap.get("APPLY_PART_STATUS"
				+ sh.getApplyMachineStatus()));
		result.put("VisitStatus", sh.getVisitStatus());
		result.put("VisitStatusName", statusMap.get("VISIT_STATUS"
				+ sh.getVisitStatus()));
		// 故障
		List<ServiceFault> sfl = this.getHibernateTemplate()
				.find("from ServiceFault where ServiceId = ? order by id",
						sh.getId());
		result.put("ServiceFaultList", sfl);
		// 零件
		List<ServiceItem> sil = this.getHibernateTemplate().find(
				"from ServiceItem where ServiceId = ?", sh.getId());
		result.put("ServiceItemList", sil);
		// 审核结果/申述
		result.put("PartMemo1", sh.getPartMemo1());
		result.put("PartMemo2", sh.getPartMemo2());
		result.put("RateMemo1", sh.getRateMemo1());
		result.put("RateMemo2", sh.getRateMemo2());
		// 回访结果
		List<ServiceVisit> svList = this.getHibernateTemplate().find(
				"from ServiceVisit where ServiceId = ?", sh.getId());
		if (!WebUtil.isNullForList(svList)) {
			result.put("VisitResult", svList.get(0).getVisitResult());
		}
		// 维修结果
		result.put("ServiceAmt", sh.getServiceAmt());
		result.put("HomeAmt", sh.getHomeAmt());
		result.put("PartsAmt", sh.getPartsAmt());
		result.put("ConsumablesAmt", sh.getConsumablesAmt());
		result.put("OtherAmt", sh.getOtherAmt());
		result.put("OtherAmtMemo", sh.getOtherAmtMemo());
		result.put("ServiceFinishDate", sh.getServiceFinishDate());
		result.put("ServiceExpectedFinishDate", sh.getServiceExpectedFinishDate());
		result.put("ServiceResult", sh.getServiceResult());
		result.put("FixPeople", sh.getFixPeople());
		result.put("CustomerRetrieveDate", sh.getCustomerRetrieveDate());

		result.put("ApplyHomeRate", sh.getApplyHomeRate());
		result.put("ApplyOtherRate", sh.getApplyOtherRate());
		result.put("ApplyOtherRateMemo", sh.getApplyOtherRateMemo());
		// 技术费
		BigDecimal tecRate = null;
		if (mt.getServiceProviderType().equals("特约维修店")) {
			tecRate = mt.getRate1();
		} else {
			tecRate = mt.getRate2();
		}
		result.put("ApplyTecRate", tecRate);
		// 已过时日计算
		long t = 0;
		Date date = new Date();
		if (WebUtil.isNotNull(sh.getServiceDate())) {
			if (WebUtil.isNotNull(sh.getCustomerRetrieveDate())) {
				t = (sh.getCustomerRetrieveDate().getTime() - sh
						.getServiceDate().getTime());
			} else {
				t = (date.getTime() - sh.getServiceDate().getTime());
			}
		}

		result.put("ThruTime", WebUtil.toDH(t));
		// 反应时间计算
		long r = 0;
		if (WebUtil.isNotNull(sh.getServiceFinishDate())
				&& WebUtil.isNotNull(sh.getServiceMethod())) {
			if (sh.getServiceMethod().equals("送修")
					|| sh.getServiceMethod().equals("寄修")) {
				if (WebUtil.isNotNull(sh.getServiceDate()))
					r = (sh.getServiceFinishDate().getTime() - sh
							.getServiceDate().getTime());
			} else if (sh.getServiceMethod().equals("现场")) {
				if (WebUtil.isNotNull(sh.getEndDate()))
					r = (sh.getServiceFinishDate().getTime() - sh.getEndDate()
							.getTime());
			}
		}
		result.put("ResponseTime", WebUtil.toDH(r));
		// 移动时间计算
		long move = 0;
		if (WebUtil.isNotNull(sh.getFromDate())
				&& WebUtil.isNotNull(sh.getEndDate())) {
			move = (sh.getEndDate().getTime() - sh.getFromDate().getTime());
		}
		result.put("MoveTime", WebUtil.toDH(move));
		result.put("Memo", sh.getMemo());
		// 附件
		List<ServiceOrderFile> sofl = this.getHibernateTemplate().find(
				"from ServiceOrderFile where id.ServiceId = ?", sh.getId());
		result.put("ServiceOrderFileList", sofl);
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map invoiceFileUpload(Map param) {
		Map result = new HashMap();
		String serviceId = (String) param.get("ServiceId");
		String invoiceDate = (String) param.get("InvoiceDate");
		String fileUrl1 = (String) param.get("FileUrl1");
		String fileUrl2 = (String) param.get("FileUrl2");
		String fileName = (String) param.get("FileName");
		Long fileSize = (Long) param.get("FileSize");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			Query q1 = session
					.createQuery("from ServiceHead where id = :ServiceId");
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> sl = q1.list();
			if (WebUtil.isNullForList(sl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				return result;
			}

			Date date = new Date();
			// 维修单发票日期
			ServiceHead sh = sl.get(0);
			sh.setInvoiceDate(WebUtil
					.toDateForString(invoiceDate, "yyyy-MM-dd"));
			Query q3 = session
					.createQuery("from Machine where MachineNo = :MachineNo");
			q3.setParameter("MachineNo", sh.getMachineNo());
			List<Machine> ml = q3.list();
			if (WebUtil.isNullForList(ml)) {
				result.put("Flag", "ERROR");
				result.put("Message", "机器信息未找到");
				return result;
			}
			Machine m = ml.get(0);
			// 更新保修期结束日
			// 如果机器中有保修期结束日，使用机器中的保修期结束日
			if (WebUtil.isNotNull(m.getServiceEndDate())) {
				sh.setServiceEndDate(m.getServiceEndDate());
			}
			// 否则使用销售日期+12个月
			else {

				Date d = WebUtil.toDateForString(WebUtil.formatDateString(sh
						.getInvoiceDate(), "yyyy-MM-dd"), "yyyy-MM-dd");
				Date serviceEndDate = WebUtil.toDateForString(WebUtil
						.ofterMonthDate(new Date(d.getTime() - 24 * 60 * 60
								* 1000), 12), "yyyy-MM-dd");
				sh.setServiceEndDate(serviceEndDate);
			}
			// 重新判断保修期内/外
			if (sh.getServiceEndDate().getTime() < WebUtil.toDateForString(
					WebUtil.formatDateString(date, "yyyy-MM-dd"), "yyyy-MM-dd")
					.getTime())
				sh.setServiceDateStatus("保修期外");
			else
				sh.setServiceDateStatus("保修期内");
			sh.setMtime(date);
			sh.setMuser(ul.getUserName());
			session.update(sh);
			// 机器发票日期
			m
					.setInvoiceDate(WebUtil.toDateForString(invoiceDate,
							"yyyy-MM-dd"));
			m.setMtime(date);
			m.setMuser(ul.getUserName());
			session.update(m);
			// 维修单发票地址
			Query q2 = session
					.createQuery("from ServiceOrderFile where id.FileType = 'INVOICE' and id.ServiceId = :ServiceId");
			q2.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceOrderFile> sofl = q2.list();
			if (WebUtil.isNullForList(sofl)) {
				ServiceOrderFile sof = new ServiceOrderFile();
				ServiceOrderFilePK pk = new ServiceOrderFilePK();
				pk.setFileType("INVOICE");
				pk.setServiceId(new Integer(serviceId));
				sof.setId(pk);
				sof.setFileUrl(fileUrl1);
				sof.setFileName(fileName);
				if (fileSize != null)
					sof.setFileSize(fileSize.intValue());
				sof.setCtime(date);
				sof.setCuser(ul.getUserName());
				session.save(sof);
			} else {
				ServiceOrderFile sof = sofl.get(0);
				sof.setFileUrl(fileUrl1);
				sof.setFileName(fileName);
				if (fileSize != null)
					sof.setFileSize(fileSize.intValue());
				sof.setMtime(date);
				sof.setMuser(ul.getUserName());
				session.update(sof);
			}
			// 机器发票地址
			Query q4 = session
					.createQuery("from MachineFile where id = :MachineId");
			q4.setParameter("MachineId", m.getId());
			List<MachineFile> mfl = q4.list();
			if (WebUtil.isNullForList(mfl)) {
				MachineFile mf = new MachineFile();
				mf.setId(m.getId());
				mf.setFileUrl(fileUrl2);
				mf.setCtime(date);
				mf.setCuser(ul.getUserName());
				mf.setFileName(fileName);
				mf.setFileName(fileName);
				if (fileSize != null)
					mf.setFileSize(fileSize.intValue());
				session.save(mf);
			} else {
				MachineFile mf = mfl.get(0);
				mf.setFileUrl(fileUrl2);
				mf.setMtime(date);
				mf.setMuser(ul.getUserName());
				mf.setFileName(fileName);
				if (fileSize != null)
					mf.setFileSize(fileSize.intValue());
				session.update(mf);
			}
			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("Message", "保存成功");
			result.put("ServiceId", serviceId);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public Map serviceOrderFileUpload(Map param) {
		Map result = new HashMap();
		String serviceId = (String) param.get("ServiceId");
		String fileUrl = (String) param.get("FileUrl");
		String fileType = (String) param.get("FileType");
		String fileName = (String) param.get("FileName");
		Long fileSize = (Long) param.get("FileSize");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			Date date = new Date();

			// 维修单发票地址
			Query q2 = session
					.createQuery("from ServiceOrderFile where id.FileType = :FileType and id.ServiceId = :ServiceId");
			q2.setParameter("FileType", fileType);
			q2.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceOrderFile> sofl = q2.list();
			if (WebUtil.isNullForList(sofl)) {
				ServiceOrderFile sof = new ServiceOrderFile();
				ServiceOrderFilePK pk = new ServiceOrderFilePK();
				pk.setFileType(fileType);
				pk.setServiceId(new Integer(serviceId));
				sof.setId(pk);
				sof.setFileUrl(fileUrl);
				sof.setFileName(fileName);
				if (fileSize != null)
					sof.setFileSize(fileSize.intValue());
				sof.setCtime(date);
				sof.setCuser(ul.getUserName());
				session.save(sof);
			} else {
				ServiceOrderFile sof = sofl.get(0);
				sof.setFileUrl(fileUrl);
				sof.setFileName(fileName);
				if (fileSize != null)
					sof.setFileSize(fileSize.intValue());
				sof.setMtime(date);
				sof.setMuser(ul.getUserName());
				session.update(sof);
			}
			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("Message", "保存成功");
			result.put("ServiceId", serviceId);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	public Map saveServiceOrder(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String serviceId = (String) param.get("ServiceId");
		Session session = this.getSession();
		try {

			// 检查维修单是否存在
			Query q1 = session
					.createQuery("from ServiceHead where id = :ServiceId");
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> shl = q1.list();
			if (WebUtil.isNullForList(shl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				return result;
			}
			ServiceHead sh = shl.get(0);
			// 检查用户是否有权限修改维修单
			if (sh.getCompanyId() == null
					|| sh.getCompanyId().intValue() != ul.getCompanyId()
							.intValue()) {
				result.put("Flag", "ERROR");
				result.put("Message", "没有权限对维修单修改");
				return result;
			}
			// 检查维修单状态是否可修改
			// 维修状态：修理中；申请零件状态：未申请或未通过；申请主机状态：未申请或未通过；申请费用状态：未申请；回访状态：未回访
			if (!(sh.getServiceStatus().equals("REPAIRING")
					&& ((sh.getApplyPartStatus().equals("NO_APPLY") || sh
							.getApplyPartStatus().equals("RE_APPLY"))
					|| (sh.getApplyMachineStatus().equals("NO_APPLY") || sh
							.getApplyMachineStatus().equals("RE_APPLY")))
					&& sh.getApplyRateStatus().equals("NO_APPLY") && sh
					.getVisitStatus().equals("NO_VISIT"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单不能修改");
				return result;
			}
			Date date = new Date();
			Transaction tx = session.beginTransaction();
			// 保存可修改内容
			sh.setServiceType((String) param.get("ServiceType"));
			if (WebUtil.isNotNull(param.get("ServiceDate")))
				sh.setServiceDate(WebUtil.toDateForString(param.get(
						"ServiceDate").toString(), "yyyy-MM-dd HH:mm"));
			if (WebUtil.isNotNull(param.get("FromDate")))
				sh.setFromDate(WebUtil.toDateForString(param.get("FromDate")
						.toString(), "yyyy-MM-dd HH:mm"));
			if (WebUtil.isNotNull(param.get("EndDate")))
				sh.setEndDate(WebUtil.toDateForString(param.get("EndDate")
						.toString(), "yyyy-MM-dd HH:mm"));
			//预计完成时间
			if(WebUtil.isNotNull(param.get("ServiceExpectedFinishDate")))
				sh.setServiceExpectedFinishDate(WebUtil.toDateForString(param.get("ServiceExpectedFinishDate")
						.toString(), "yyyy-MM-dd HH:mm"));
			sh.setServiceMethod((String) param.get("ServiceMethod"));
			sh.setServiceContract((String) param.get("ServiceContract"));
			sh.setServiceOperation((String) param.get("ServiceOperation"));
			sh.setBlackWhiteNumber((String) param.get("BlackWhiteNumber"));
			sh.setColorNumber((String) param.get("ColorNumber"));
			sh.setPlateNumber((String) param.get("PlateNumber"));
			sh.setPartOrMachine((String) param.get("PartOrMachine"));
			sh.setMachineMemo((String) param.get("MachineMemo"));
			sh.setCustomerCompany((String) param.get("CustomerCompany"));
			sh.setCustomerNo((String) param.get("CustomerNo"));
			sh.setCustomerZip((String) param.get("CustomerZip"));
			sh.setCustomerAddress1((String) param.get("CustomerAddress1"));
			sh.setCustomerAddress2((String) param.get("CustomerAddress2"));
			sh.setCustomerAddress3((String) param.get("CustomerAddress3"));
			sh.setCustomerAddress4((String) param.get("CustomerAddress4"));
			sh.setCustomerAddress5((String) param.get("CustomerAddress5"));
			sh.setCustomerName((String) param.get("CustomerName"));
			sh.setCustomerTel((String) param.get("CustomerTel"));

			sh.setServiceAmt(WebUtil.toBigDecimal(param.get("ServiceAmt")));
			sh.setHomeAmt(WebUtil.toBigDecimal(param.get("HomeAmt")));
			sh.setPartsAmt(WebUtil.toBigDecimal(param.get("PartsAmt")));
			sh.setConsumablesAmt(WebUtil.toBigDecimal(param
					.get("ConsumablesAmt")));
			sh.setOtherAmt(WebUtil.toBigDecimal(param.get("OtherAmt")));
			sh.setOtherAmtMemo((String) param.get("OtherAmtMemo"));
			if (WebUtil.isNotNull(param.get("ServiceFinishDate")))
				sh.setServiceFinishDate(WebUtil.toDateForString(param.get(
						"ServiceFinishDate").toString(), "yyyy-MM-dd HH:mm"));
			sh.setServiceResult((String) param.get("ServiceResult"));
			sh.setFixPeople((String) param.get("FixPeople"));
			if (WebUtil.isNotNull(param.get("CustomerRetrieveDate")))
				sh
						.setCustomerRetrieveDate(WebUtil.toDateForString(param
								.get("CustomerRetrieveDate").toString(),
								"yyyy-MM-dd HH:mm"));
			sh.setMemo((String) param.get("Memo"));
			sh.setApplyHomeRate(WebUtil
					.toBigDecimal(param.get("ApplyHomeRate")));
			sh.setApplyOtherRate(WebUtil.toBigDecimal(param
					.get("ApplyOtherRate")));
			sh.setApplyOtherRateMemo((String) param.get("ApplyOtherRateMemo"));
			sh.setMtime(date);
			sh.setMuser(ul.getUserName());
			session.update(sh);
			// 保存故障
			List<Map> faultList = (List) param.get("FaultList");
			if (!WebUtil.isNullForList(faultList))
				for (Map f : faultList) {
					// 无ID新增
					if (WebUtil.isNull(f.get("ServiceFaultId"))) {
						// 无故障分类和故障号不保存
						if (WebUtil.isNull(f.get("FaultCateNo"))
								|| WebUtil.isNull(f.get("FaultNo")))
							continue;
						ServiceFault sf = new ServiceFault();
						sf.setServiceId(sh.getId());
						sf.setCtime(date);
						sf.setCuser(ul.getUserName());
						sf.setFaultCateNo((String) f.get("FaultCateNo"));
						sf.setFaultType((String) f.get("FaultType"));
						sf.setFaultNo((String) f.get("FaultNo"));
						sf.setFaultName((String) f.get("FaultName"));
						sf.setMustMemo((String) f.get("MustMemo"));
						sf.setMemo((String) f.get("Memo"));
						sf.setContent((String) f.get("Content"));
						session.save(sf);
					} else {
						List<ServiceFault> sfl = session.createQuery(
								"from ServiceFault where id = :ServiceFaultId")
								.setParameter(
										"ServiceFaultId",
										new Integer(f.get("ServiceFaultId")
												.toString())).list();
						if (WebUtil.isNullForList(sfl)) {
							continue;
						}
						ServiceFault sf = sfl.get(0);
						// 无故障分类和故障号删除
						if (WebUtil.isNull(f.get("FaultCateNo"))
								|| WebUtil.isNull(f.get("FaultNo")))
							session.delete(sf);
						else {
							sf.setMtime(date);
							sf.setMuser(ul.getUserName());
							sf.setFaultCateNo((String) f.get("FaultCateNo"));
							sf.setFaultType((String) f.get("FaultType"));
							sf.setFaultNo((String) f.get("FaultNo"));
							sf.setFaultName((String) f.get("FaultName"));
							sf.setMustMemo((String) f.get("MustMemo"));
							sf.setMemo((String) f.get("Memo"));
							sf.setContent((String) f.get("Content"));
							session.update(sf);
						}
					}
				}
			// 保存零件或整机
			List<Map> partOrMachineList = (List) param.get("PartOrMachineList");
			if (!WebUtil.isNullForList(partOrMachineList)) {
				StringBuffer s = new StringBuffer();
				for (Map f : partOrMachineList) {
					if (WebUtil.isNotNull(f.get("ServiceItemId"))) {
						if (s.length() > 0)
							s.append(",");
						s.append(f.get("ServiceItemId"));
					}
				}
				if (s.length() == 0) {
					session.createQuery(
							"delete ServiceItem where ServiceId = "
									+ sh.getId()).executeUpdate();
				} else {
					session.createQuery(
							"delete ServiceItem where ServiceId = "
									+ sh.getId() + " and id not in ("
									+ s.toString() + ")").executeUpdate();
				}
				for (Map f : partOrMachineList) {
					// 无ID新增
					if (WebUtil.isNull(f.get("ServiceItemId"))) {
						// 无分类、零件号和数量不保存
						if (WebUtil.isNull(f.get("ItemCate"))
								|| WebUtil.isNull(f.get("ItemNo"))
								|| WebUtil.isNull(f.get("ItemQty")))
							continue;
						ServiceItem si = new ServiceItem();
						si.setServiceId(sh.getId());
						si.setCtime(date);
						si.setCuser(ul.getUserName());
						si.setItemCate((String) f.get("ItemCate"));
						si.setItemName((String) f.get("ItemName"));
						si.setItemNo((String) f.get("ItemNo"));
						si.setItemSerialNo((String) f.get("ItemSerialNo"));
						si.setItemType((String) f.get("ItemType"));
						si.setQty(new Integer(f.get("ItemQty").toString()));
						si.setItemStatus((String) f.get("ItemStatus"));
						session.save(si);
					} else {
						List<ServiceItem> sil = session.createQuery(
								"from ServiceItem where id = :ServiceItemId")
								.setParameter(
										"ServiceItemId",
										new Integer(f.get("ServiceItemId")
												.toString())).list();
						if (WebUtil.isNullForList(sil)) {
							continue;
						}
						ServiceItem si = sil.get(0);
						// 无零件号和数量删除
						if (WebUtil.isNull(f.get("ItemNo"))
								|| WebUtil.isNull(f.get("ItemQty")))
							session.delete(si);
						else {
							si.setMtime(date);
							si.setMuser(ul.getUserName());
							si.setItemCate((String) f.get("ItemCate"));
							si.setItemName((String) f.get("ItemName"));
							si.setItemNo((String) f.get("ItemNo"));
							si.setItemSerialNo((String) f.get("ItemSerialNo"));
							si.setItemType((String) f.get("ItemType"));
							si.setQty(new Integer(f.get("ItemQty").toString()));
							si.setItemStatus((String) f.get("ItemStatus"));
							session.update(si);
						}
					}
				}
			}
			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("Message", "保存成功");
		} catch (HibernateException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} catch (NumberFormatException e) {
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

	public Map saveServiceOrderItem(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String serviceId = (String) param.get("ServiceId");
		Session session = this.getSession();
		try {

			// 检查维修单是否存在
			Query q1 = session
					.createQuery("from ServiceHead where id = :ServiceId");
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> shl = q1.list();
			if (WebUtil.isNullForList(shl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				return result;
			}
			ServiceHead sh = shl.get(0);
			// 检查用户是否有权限修改维修单
			if (sh.getCompanyId() == null
					|| sh.getCompanyId().intValue() != ul.getCompanyId()
							.intValue()) {
				result.put("Flag", "ERROR");
				result.put("Message", "没有权限对维修单修改");
				return result;
			}
			// 检查维修单状态是否可修改
			// 维修状态：修理中；申请零件状态：未申请或未通过；申请主机状态：未申请或未通过；申请费用状态：未申请；回访状态：未回访
			if (!(sh.getServiceStatus().equals("REPAIRING")
					&& (sh.getApplyPartStatus().equals("NO_APPLY")
							|| sh.getApplyPartStatus().equals("RE_APPLY")
							|| sh.getApplyMachineStatus().equals("NO_APPLY") || sh
							.getApplyMachineStatus().equals("RE_APPLY"))
					&& sh.getApplyRateStatus().equals("NO_APPLY") && sh
					.getVisitStatus().equals("NO_VISIT"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单不能修改");
				return result;
			}
			Date date = new Date();
			Transaction tx = session.beginTransaction();
			// 保存故障
			// List<Map> faultList = (List) param.get("FaultList");
			// if(!WebUtil.isNullForList(faultList))
			// for(Map f:faultList)
			// {
			// //无ID新增
			// if(WebUtil.isNull(f.get("ServiceFaultId")))
			// {
			// //无故障分类和故障号不保存
			// if(WebUtil.isNull(f.get("FaultCateNo"))||WebUtil.isNull(f.get("FaultNo")))
			// continue;
			// ServiceFault sf = new ServiceFault();
			// sf.setServiceId(sh.getId());
			// sf.setCtime(date);
			// sf.setCuser(ul.getUserName());
			// sf.setFaultCateNo((String)f.get("FaultCateNo"));
			// sf.setFaultType((String)f.get("FaultType"));
			// sf.setFaultNo((String)f.get("FaultNo"));
			// sf.setFaultName((String)f.get("FaultName"));
			// sf.setMustMemo((String)f.get("MustMemo"));
			// sf.setMemo((String)f.get("Memo"));
			// sf.setContent((String)f.get("Content"));
			// session.save(sf);
			// }
			// else
			// {
			// List<ServiceFault> sfl =
			// session.createQuery("from ServiceFault where id = :ServiceFaultId").setParameter("ServiceFaultId",
			// new Integer(f.get("ServiceFaultId").toString())).list();
			// if(WebUtil.isNullForList(sfl))
			// {
			// continue;
			// }
			// ServiceFault sf = sfl.get(0);
			// //无故障分类和故障号删除
			// if(WebUtil.isNull(f.get("FaultCateNo"))||WebUtil.isNull(f.get("FaultNo")))
			// session.delete(sf);
			// else
			// {
			// sf.setMtime(date);
			// sf.setMuser(ul.getUserName());
			// sf.setFaultCateNo((String)f.get("FaultCateNo"));
			// sf.setFaultType((String)f.get("FaultType"));
			// sf.setFaultNo((String)f.get("FaultNo"));
			// sf.setFaultName((String)f.get("FaultName"));
			// sf.setMustMemo((String)f.get("MustMemo"));
			// sf.setMemo((String)f.get("Memo"));
			// sf.setContent((String)f.get("Content"));
			// session.update(sf);
			// }
			// }
			// }
			// 保存零件或整机
			List<Map> partOrMachineList = (List) param.get("PartOrMachineList");
			if (!WebUtil.isNullForList(partOrMachineList)) {
				StringBuffer s = new StringBuffer();
				// for(Map f:partOrMachineList)
				// {
				// //零件申请通过后不能修改
				// if(!(sh.getApplyPartStatus().equals("NO_APPLY")||sh.getApplyPartStatus().equals("RE_APPLY")))
				// {
				// if(f.get("ItemCate")!=null&&(f.get("ItemCate").equals("零件")))
				// continue;
				// }
				// //主机申请通过后不能修改
				// if(!(sh.getApplyMachineStatus().equals("NO_APPLY")||sh.getApplyMachineStatus().equals("RE_APPLY")))
				// {
				// if(f.get("ItemCate")!=null&&(f.get("ItemCate").equals("选购件或耗材")||f.get("ItemCate").equals("主机")))
				// continue;
				// }
				// if(WebUtil.isNotNull(f.get("ServiceItemId")))
				// {
				// if(s.length()>0)
				// s.append(",");
				// s.append(f.get("ServiceItemId"));
				// }
				// }
				// if(s.length()==0)
				// {
				// session.createQuery("delete ServiceItem where ServiceId = "+sh.getId()).executeUpdate();
				// }
				// else
				// {
				// session.createQuery("delete ServiceItem where ServiceId = "+sh.getId()+" and id not in ("+s.toString()+")").executeUpdate();
				// }
				for (Map f : partOrMachineList) {
					// 零件申请通过后不能修改
					if (!(sh.getApplyPartStatus().equals("NO_APPLY") || sh
							.getApplyPartStatus().equals("RE_APPLY"))) {
						if (f.get("ItemCate") != null
								&& (f.get("ItemCate").equals("零件")))
							continue;
					}
					// 主机申请通过后不能修改
					if (!(sh.getApplyMachineStatus().equals("NO_APPLY") || sh
							.getApplyMachineStatus().equals("RE_APPLY"))) {
						if (f.get("ItemCate") != null
								&& (f.get("ItemCate").equals("选购件或耗材") || f
										.get("ItemCate").equals("主机")))
							continue;
					}
					// 无ID新增
					if (WebUtil.isNull(f.get("ServiceItemId"))) {
						// 无分类、零件号和数量不保存
						if (WebUtil.isNull(f.get("ItemCate"))
								|| WebUtil.isNull(f.get("ItemNo"))
								|| WebUtil.isNull(f.get("ItemQty")))
							continue;
						ServiceItem si = new ServiceItem();
						si.setServiceId(sh.getId());
						si.setCtime(date);
						si.setCuser(ul.getUserName());
						si.setItemCate((String) f.get("ItemCate"));
						si.setItemName((String) f.get("ItemName"));
						si.setItemNo((String) f.get("ItemNo"));
						si.setItemSerialNo((String) f.get("ItemSerialNo"));
						si.setItemType((String) f.get("ItemType"));
						si.setQty(new Integer(f.get("ItemQty").toString()));
						si.setItemStatus((String) f.get("ItemStatus"));
						session.save(si);
					} else {
						List<ServiceItem> sil = session.createQuery(
								"from ServiceItem where id = :ServiceItemId")
								.setParameter(
										"ServiceItemId",
										new Integer(f.get("ServiceItemId")
												.toString())).list();
						if (WebUtil.isNullForList(sil)) {
							continue;
						}
						ServiceItem si = sil.get(0);
						// 无零件号和数量删除
						if (WebUtil.isNull(f.get("ItemNo"))
								|| WebUtil.isNull(f.get("ItemQty")))
							session.delete(si);
						else {
							si.setMtime(date);
							si.setMuser(ul.getUserName());
							si.setItemCate((String) f.get("ItemCate"));
							si.setItemName((String) f.get("ItemName"));
							si.setItemNo((String) f.get("ItemNo"));
							si.setItemSerialNo((String) f.get("ItemSerialNo"));
							si.setItemType((String) f.get("ItemType"));
							si.setQty(new Integer(f.get("ItemQty").toString()));
							si.setItemStatus((String) f.get("ItemStatus"));
							session.update(si);
						}
					}
				}
			}
			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("Message", "保存成功");
		} catch (HibernateException e) {
			result.put("Flag", "ERROR");
			result.put("Message", e.getMessage());
			logger.error(e.getMessage());
		} catch (NumberFormatException e) {
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

	public Map cancelServiceOrder(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String serviceId = (String) param.get("ServiceId");
		Session session = this.getSession();
		// 检查维修单是否存在
		try {
			Query q1 = session
					.createQuery("from ServiceHead where id = :ServiceId");
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> shl = q1.list();
			if (WebUtil.isNullForList(shl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				return result;
			}
			ServiceHead sh = shl.get(0);
			// 检查用户是否有权限修改维修单
			if (sh.getCompanyId() == null
					|| sh.getCompanyId().intValue() != ul.getCompanyId()
							.intValue()) {
				result.put("Flag", "ERROR");
				result.put("Message", "没有权限对维修单修改");
				return result;
			}
			// 检查维修单状态是否可修改
			// 维修状态：修理中；申请零件状态：未申请或未通过；申请主机状态：未申请或未通过；申请费用状态：未申请；回访状态：未回访
			if (!(sh.getServiceStatus().equals("REPAIRING")
					&& (sh.getApplyPartStatus().equals("NO_APPLY") || sh
							.getApplyPartStatus().equals("RE_APPLY"))
					&& (sh.getApplyMachineStatus().equals("NO_APPLY") || sh
							.getApplyMachineStatus().equals("RE_APPLY"))
					&& sh.getApplyRateStatus().equals("NO_APPLY") && sh
					.getVisitStatus().equals("NO_VISIT"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单不能修改");
				return result;
			}

			Transaction tx = session.beginTransaction();
			// 维修单状态设为取消
			sh.setServiceStatus("CANCEL");
			session.update(sh);
			// 机器状态设为正常使用中
			List<Machine> ml = this.getHibernateTemplate().find(
					"from Machine where MachineNo = ?", sh.getMachineNo());
			if (!WebUtil.isNullForList(ml)) {
				Machine m = ml.get(0);
				m.setStatus("NORMAL");
				session.update(m);
			}
			//删除相关维修申请
			List<ServiceApply> saList = this.getHibernateTemplate().find("from ServiceApply where ServiceId = ?",sh.getId());
			if(!WebUtil.isNullForList(saList))
			{
				for(ServiceApply sa:saList)
				{
					//删除维修申请相关附件
					List<ServiceApplyFile> safList = this.getHibernateTemplate().find("from ServiceApplyFile where id.ServiceApplyId = ?",sa.getId());
					if(!WebUtil.isNullForList(safList))
					{
						for(ServiceApplyFile saf:safList)
						{
							session.delete(saf);
						}
					}
					//删除维修申请
					session.delete(sa);
				}
			}
			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("Message", "保存成功");
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

	public Map partOrMachineApply(Map param) {

		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String serviceId = (String) param.get("ServiceId");
		Session session = this.getSession();
		// 检查维修单是否存在
		try {
			Query q1 = session
					.createQuery("from ServiceHead where id = :ServiceId");
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> shl = q1.list();
			if (WebUtil.isNullForList(shl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				return result;
			}
			ServiceHead sh = shl.get(0);
			// 检查用户是否有权限修改维修单
			if (sh.getCompanyId() == null
					|| sh.getCompanyId().intValue() != ul.getCompanyId()
							.intValue()) {
				result.put("Flag", "ERROR");
				result.put("Message", "没有权限对维修单修改");
				return result;
			}
			// 检查维修单状态是否可修改
			// 维修状态：修理中；申请零件状态：未申请或未通过；申请主机状态：未申请或未通过；申请费用状态：未申请；回访状态：未回访
			if (!(sh.getServiceStatus().equals("REPAIRING")
					&& (sh.getApplyPartStatus().equals("NO_APPLY") || sh
							.getApplyPartStatus().equals("RE_APPLY"))
					&& (sh.getApplyMachineStatus().equals("NO_APPLY") || sh
							.getApplyMachineStatus().equals("RE_APPLY"))
					&& sh.getApplyRateStatus().equals("NO_APPLY") && sh
					.getVisitStatus().equals("NO_VISIT"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单不能修改");
				return result;
			}

			Transaction tx = session.beginTransaction();
			// 维修单状态设为待审核
			sh.setServiceStatus("IN_APPLY");
			session.update(sh);
			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("Message", "保存成功");
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

	public Map finishServiceOrder(Map param) {
		Map result = new HashMap();
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String serviceId = (String) param.get("ServiceId");
		Session session = this.getSession();
		// 检查维修单是否存在
		try {
			Query q1 = session
					.createQuery("from ServiceHead where id = :ServiceId");
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> shl = q1.list();
			if (WebUtil.isNullForList(shl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				return result;
			}
			ServiceHead sh = shl.get(0);
			// 检查用户是否有权限修改维修单
			if (sh.getCompanyId() == null
					|| sh.getCompanyId().intValue() != ul.getCompanyId()
							.intValue()) {
				result.put("Flag", "ERROR");
				result.put("Message", "没有权限对维修单修改");
				return result;
			}
			// 检查维修单状态是否可修改
			// 维修状态：修理中；申请零件状态：非不通过\补库存状态；申请主机状态：未申请或用库存或已发货；申请费用状态：未申请；回访状态：未回访
			if (!(sh.getServiceStatus().equals("REPAIRING")
					&& (!(sh.getApplyPartStatus().equals("RE_APPLY") || sh
							.getApplyPartStatus().equals("ADD_INV")))
					&& (sh.getApplyMachineStatus().equals("NO_APPLY")
							|| sh.getApplyMachineStatus().equals("USE_INV") || sh
							.getApplyMachineStatus().equals("DELIVERY"))
					&& sh.getApplyRateStatus().equals("NO_APPLY") && sh
					.getVisitStatus().equals("NO_VISIT"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单不能修改");
				return result;
			}
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			// 保存完成信息
			String serviceFinishDate = (String) param.get("ServiceFinishDate");
			String customerRetrieveDate = (String) param
					.get("CustomerRetrieveDate");
			String fixPeople = (String) param.get("FixPeople");
//			if (WebUtil.isNotNull(serviceFinishDate))
//				sh.setServiceFinishDate(WebUtil.toDateForString(
//						serviceFinishDate, "yyyy-MM-dd HH:mm"));
			//预计完成时间改为自动产生
			sh.setServiceFinishDate(date);
			if (WebUtil.isNotNull(customerRetrieveDate))
				sh.setCustomerRetrieveDate(WebUtil.toDateForString(
						customerRetrieveDate, "yyyy-MM-dd HH:mm"));
			sh.setFixPeople(fixPeople);
			// 已修复
			sh.setServiceStatus("REPAIR_COMPLETE");
			sh.setMtime(date);
			sh.setMuser(ul.getUserName());
			session.update(sh);
			// 是否需要加库存
			Query q5 = session
					.createQuery("from ServiceDeliveryItem where ServiceDeliveryId in (select sd.id from ServiceDelivery sd,ServiceApply sa where sd.ServiceApplyId = sa.id and sa.ServiceId = :ServiceId and sa.InvFlag = 'ADD_INV')");
			q5.setParameter("ServiceId", sh.getId());
			List<ServiceDeliveryItem> sdiList = q5.list();
			if (!WebUtil.isNullForList(sdiList)) {
				List invList = new ArrayList();
				for (ServiceDeliveryItem sdi : sdiList) {
					Map m = new HashMap();
					m.put("WhId", sh.getCompanyId().toString());
					// 如果有新零件/商品编号，入库用新的编号
					if (WebUtil.isNotNull(sdi.getNewItemNo()))
						m.put("SkuCd", sdi.getNewItemNo());
					else
						m.put("SkuCd", sdi.getItemNo());
					m.put("SkuName", sdi.getItemName());
					m.put("Qty", sdi.getItemQty());
					m.put("InvType", "A");
					m.put("LogType", "ADD_INV");
					m.put("InvCate", sdi.getItemCate());
					m.put("IoType", "I");
					m.put("BillNo", sh.getServiceNo());
					invList.add(m);
				}
				Map r = inventoryProcess(invList, "N", session);
				// 库存扣减失败
				if (r.get("Flag").equals("ERROR")) {
					result.putAll(r);
					tx.rollback();
					session.close();
					return result;
				}
			}
			// 机器状态改变
			// 如果维修类型为建议换货机器状态为已换货，否则机器状态为正常使用中
			// 查询机器
			Query q2 = session
					.createQuery("from Machine where MachineNo = :MachineNo");
			q2.setParameter("MachineNo", sh.getMachineNo());
			List<Machine> mList = q2.list();
			if (WebUtil.isNullForList(mList)) {
				result.put("Flag", "ERROR");
				result.put("Message", "机器信息未找到");
				tx.rollback();
				session.close();
				return result;
			}
			Machine m = mList.get(0);
			Query q3 = session
					.createQuery("from ServiceItem where ServiceId = :ServiceId and ItemCate = '主机' and ItemStatus = 'APPLY'");
			q3.setParameter("ServiceId", sh.getId());
			List<ServiceItem> siList = q3.list();
			// 主机换货，机器状态改为已换货
			if ((!WebUtil.isNullForList(siList))
					&& sh.getServiceType().equals("ON_CHANGE")) {
				m.setStatus("CHANGE");
			} else {
				m.setStatus("NORMAL");
			}
			session.update(m);

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

	// 无库位情况,不考虑1个商品在同一仓库有2个库存情况
	private Map inventoryProcess(List<Map> skuList, String allowNegativeInv,
			Session session) {
		// 默认不允许
		if (WebUtil.isNull(allowNegativeInv))
			allowNegativeInv = "N";
		Map result = new HashMap();
		Date date = new Date();
		for (Map m : skuList) {
			String whId = (String) m.get("WhId");
			String skuCd = (String) m.get("SkuCd");
			String skuName = (String) m.get("SkuName");
			String invCate = (String) m.get("InvCate");
			Integer qty = (Integer) m.get("Qty");
			// 库存类型A、B、C品
			String invType = (String) m.get("InvType");
			// 日志类型库存变动来源
			String logType = (String) m.get("LogType");
			// 库存变动类型I-入库,O-出库,R-替换
			String ioType = (String) m.get("IoType");
			Inventory inv = null;
			Integer invId = null;
			// 查询库存,必须是A品
			List<Inventory> invList = session.createQuery(
					"from Inventory where InvStatus = 'AVAILABLE' and WhId = '"
							+ whId + "' and SkuCd = '" + skuCd
							+ "' and InvType = 'A'").list();
			// 无库存
			if (WebUtil.isNullForList(invList)) {
				inv = new Inventory();
				inv.setCtime(date);
				inv.setInvStatus("AVAILABLE");
				inv.setInvType(invType);
				inv.setSkuCd(skuCd);
				inv.setSkuName(skuName);
				inv.setInvCate(invCate);
				inv.setWhId(whId);
				// 入库和替换
				if (ioType.equals("I") || ioType.equals("R")) {
					inv.setQuantity(qty);
					inv.setAvailableQuantity(qty);
				}
				// 出库
				else if (ioType.equals("O")) {
					// 不允许负库存
					if (allowNegativeInv.equals("N")) {
						result.put("Flag", "ERROR");
						result.put("Message", "库存数量不足");
						logger.error("仓库[" + whId + "]商品[" + skuCd + "]库存数量不足");
						// session.close();
						return result;
					}
					inv.setAvailableQuantity(0 - qty);
					inv.setQuantity(0 - qty);
				}
				session.save(inv);
			}
			// 有库存
			else {
				inv = invList.get(0);
				inv.setMtime(date);
				// 入库
				if (ioType.equals("I")) {
					inv.setAvailableQuantity(inv.getAvailableQuantity()
							.intValue()
							+ qty);
					inv.setQuantity(inv.getQuantity().intValue() + qty);
				}
				// 替换
				else if (ioType.equals("R")) {
					// 暂时未考虑可用库存不足的情况
					inv.setQuantity(qty);
					inv.setAvailableQuantity(qty);
				}
				// 出库
				else if (ioType.equals("O")) {
					// 库存足够
					if (inv.getAvailableQuantity().intValue() >= qty) {
						inv.setAvailableQuantity(inv.getAvailableQuantity()
								.intValue()
								- qty);
						inv.setQuantity(inv.getQuantity().intValue() - qty);
					}
					// 库存不足
					else {
						// 不允许负库存
						if (allowNegativeInv.equals("N")) {
							result.put("Flag", "ERROR");
							result.put("Message", "库存数量不足");
							logger.error("仓库[" + whId + "]商品[" + skuCd
									+ "]库存数量不足");
							return result;
						}
						inv.setAvailableQuantity(inv.getAvailableQuantity()
								.intValue()
								- qty);
						inv.setQuantity(inv.getQuantity().intValue() - qty);
					}
				}
				session.update(inv);

			}
			invId = inv.getId();
			// 库存日志
			InventoryLog il = new InventoryLog();
			il.setBillNo((String) m.get("BillNo"));
			il.setCtime(date);
			il.setInvId(invId);
			il.setInvType(invType);
			il.setIoType(ioType);
			il.setLogType(logType);
			il.setQuantity(qty);
			il.setSkuCd(skuCd);
			il.setWhId(whId);
			session.save(il);
		}
		result.put("Flag", "SUCCESS");
		return result;
	}
}
