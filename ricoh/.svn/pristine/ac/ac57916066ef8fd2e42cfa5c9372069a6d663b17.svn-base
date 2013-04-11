package com.sunmw.web.bean.machine.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunmw.web.bean.machine.MachineServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.CompanyMachineTypeRef;
import com.sunmw.web.entity.Machine;
import com.sunmw.web.entity.MachineCat;
import com.sunmw.web.entity.MachineType;
import com.sunmw.web.entity.Unit;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class MachineServicesImpl extends HibernateDaoSupport implements
		MachineServices {

	public Map searchMachine(Map param, int currentPage, int pageRow) {
		StringBuffer hql = new StringBuffer();
		hql
				.append("from Machine m ,MachineType mt where m.MachineTypeId = mt.id ");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("MachineNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" m.MachineNo = :Condition" + conList.size());
			conList.add(param.get("MachineNo").toString());
		}
		if (!WebUtil.isNull(param.get("PpsNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" m.PpsNo like :Condition" + conList.size());
			conList.add("%" + param.get("PpsNo") + "%");
		}

		if (!WebUtil.isNull(param.get("CustomerName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" m.CustomerName like :Condition" + conList.size());
			conList.add("%" + param.get("CustomerName") + "%");
		}
		if (!WebUtil.isNull(param.get("MachineTypeId"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" m.MachineTypeId = :Condition" + conList.size());
			conList.add(new Integer(param.get("MachineTypeId").toString()));
		}
		if (!WebUtil.isNull(param.get("MachineCd"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" mt.MachineCd = :Condition" + conList.size());
			conList.add(param.get("MachineCd"));
		}
		if (!WebUtil.isNull(param.get("FromOutDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" m.OutDate >= :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get("FromOutDate")
					.toString(), "yyyy-MM-dd"));
		}
		if (!WebUtil.isNull(param.get("EndOutDate"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" m.OutDate < :Condition" + conList.size());
			conList.add(WebUtil.toDateForString(param.get("EndOutDate")
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
			Query q = session.createQuery(hql.toString());
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
			List<Map> r = new ArrayList();
			for (Object[] obj : l) {
				Machine mm = (Machine) obj[0];
				MachineType mt = (MachineType) obj[1];
				Map m = new HashMap();
				m.put("MachineId", mm.getId().toString());
				m.put("MachineNo", mm.getMachineNo());
				m.put("PpsNo", mm.getPpsNo());
				m.put("MachineTypeId", mm.getMachineTypeId());
				m.put("MachineType", mt.getMachineType());
				m.put("MachineCd", mt.getMachineCd());
				m.put("CustomerName", mm.getCustomerName());
				m.put("CustomerNo", mm.getCustomerNo());
				m.put("OuterDate", WebUtil.formatDateString(mm.getOutDate(),
						"yyyy-MM-dd"));
				m.put("ServiceFromDate", WebUtil.formatDateString(mm
						.getServiceFromDate(), "yyyy-MM-dd"));
				m.put("ServiceEndDate", WebUtil.formatDateString(mm
						.getServiceEndDate(), "yyyy-MM-dd"));
				m.put("PaymentStatus", mm.getPaymentStatus());
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
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public String checkMachineNo(String machineNo) {
		List<Machine> ml = this.getHibernateTemplate().find(
				"from Machine where MachineNo = ?", machineNo);
		if (WebUtil.isNullForList(ml)) {
			return null;
		} else
			return "机号重复,机号[" + machineNo + "]在系统已存在";
	}

	public Integer saveMachine(Map param) {
		String machineId = (String) param.get("MachineId");
		Machine mt = null;
		if (WebUtil.isNotNull(machineId)) {
			List<Machine> l = this.getHibernateTemplate().find(
					"from Machine where id = ?", new Integer(machineId));
			if (!WebUtil.isNullForList(l)) {
				mt = l.get(0);
			}
		}
		Date date = new Date();
		if (mt == null) {
			mt = new Machine();
			mt.setCtime(date);
			mt.setCuser((String) param.get("UserName"));
			mt.setStatus("NORMAL");
			mt.setOrigin("NEW");
		} else {
			mt.setMtime(date);
			mt.setMuser((String) param.get("UserName"));
		}
		if (WebUtil.isNotNull(param.get("MachineCd")))
			mt.setMachineCd((String) param.get("MachineCd"));
		if (WebUtil.isNotNull(param.get("MachineTypeId")))
			mt.setMachineTypeId(new Integer(param.get("MachineTypeId")
					.toString()));
		if (WebUtil.isNotNull(param.get("MachineNo")))
			mt.setMachineNo((String) param.get("MachineNo"));
		if (WebUtil.isNotNull(param.get("PpsNo")))
			mt.setPpsNo((String) param.get("PpsNo"));
		if (WebUtil.isNotNull(param.get("ServiceFromDate")))
			mt.setServiceFromDate(WebUtil.toDateForString(param.get(
					"ServiceFromDate").toString(), "yyyy-MM-dd"));
		if (WebUtil.isNotNull(param.get("ServiceEndDate")))
			mt.setServiceEndDate(WebUtil.toDateForString(param.get(
					"ServiceEndDate").toString(), "yyyy-MM-dd"));
		if (WebUtil.isNotNull(param.get("OutDate")))
			mt.setOutDate(WebUtil.toDateForString(param.get("OutDate")
					.toString(), "yyyy-MM-dd"));
		if (WebUtil.isNotNull(param.get("InvoiceDate")))
			mt.setInvoiceDate(WebUtil.toDateForString(param.get("InvoiceDate")
					.toString(), "yyyy-MM-dd"));
		if (WebUtil.isNotNull(param.get("PaymentStatus")))
			mt.setPaymentStatus((String) param.get("PaymentStatus"));
		if (WebUtil.isNotNull(param.get("PaymentCompany")))
			mt.setPaymentCompany((String) param.get("PaymentCompany"));
		if (WebUtil.isNotNull(param.get("PaymentCompanyCd")))
			mt.setPaymentCompanyCd((String) param.get("PaymentCompanyCd"));
		if (WebUtil.isNotNull(param.get("PaymentDate")))
			mt.setPaymentDate(WebUtil.toDateForString(param.get("PaymentDate")
					.toString(), "yyyy-MM-dd"));
		if (WebUtil.isNotNull(param.get("PaymentAmt")))
			mt
					.setPaymentAmt(new BigDecimal(param.get("PaymentAmt")
							.toString()));
		if (WebUtil.isNotNull(param.get("CustomerNo")))
			mt.setCustomerNo(param.get("CustomerNo").toString());
		if (WebUtil.isNotNull(param.get("CustomerName")))
			mt.setCustomerName(param.get("CustomerName").toString());

		if (mt.getId() == null)
			this.getHibernateTemplate().save(mt);
		else
			this.getHibernateTemplate().update(mt);
		return mt.getId();
	}

	public Map getMachineInfo(String machineId) {
		if(!WebUtil.isNumeric(machineId))
		{
			return null;
		}
		List<Machine> l = this.getHibernateTemplate().find(
				"from Machine m where m.id = ?", new Integer(machineId));
		if (WebUtil.isNullForList(l))
			return null;
		Map<String, String> status = getMachineStatus();
		Machine m = l.get(0);
		Map<String, String> result = new HashMap();
		result.put("MachineId", m.getId().toString());
		result.put("MachineNo", m.getMachineNo());
		result.put("PpsNo", m.getPpsNo());
		result.put("ServiceFromDate", WebUtil.formatDateString(m
				.getServiceFromDate(), "yyyy-MM-dd"));
		result.put("ServiceEndDate", WebUtil.formatDateString(m
				.getServiceEndDate(), "yyyy-MM-dd"));
		result.put("OutDate", WebUtil.formatDateString(m.getOutDate(),
				"yyyy-MM-dd"));
		result.put("InvoiceDate", WebUtil.formatDateString(m.getInvoiceDate(),
				"yyyy-MM-dd"));
		result.put("PaymentStatus", m.getPaymentStatus());
		result.put("PaymentCompany", m.getPaymentCompany());
		result.put("PaymentCompanyCd", m.getPaymentCompanyCd());
		result.put("PaymentDate", WebUtil.formatDateString(m.getPaymentDate(),
				"yyyy-MM-dd"));
		if (WebUtil.isNotNull(m.getPaymentAmt()))
			result.put("PaymentAmt", m.getPaymentAmt().toString());
		result.put("LastTime", WebUtil.formatDateString(m.getLastTime(),
				"yyyy-MM-dd"));
		if (WebUtil.isNotNull(m.getLastCompanyId())) {
			List<Company> cl = this.getHibernateTemplate().find(
					"from Company where Status = 'NORMAL' and id = "
							+ m.getLastCompanyId());
			if (!WebUtil.isNullForList(cl)) {
				Company c = cl.get(0);
				result.put("LastCompanyName", c.getCompanyName());
				result.put("LastCompanyId", m.getLastCompanyId().toString());
			}
		}
		result.put("MachineStatus", m.getStatus());
		result.put("MachineStatusName", status.get(m.getStatus()));
		if (m.getMachineTypeId() != null) {
			List<MachineType> mtList = this.getHibernateTemplate().find(
					"from MachineType where Status = 'NORMAL' and id = "
							+ m.getMachineTypeId());
			if (!WebUtil.isNullForList(mtList)) {
				MachineType mt = mtList.get(0);
				result.put("MachineTypeId", m.getMachineTypeId().toString());
				result.put("MachineType", mt.getMachineType());
				result.put("MachineCd", mt.getMachineCd());
			}
		}
		result.put("Origin", m.getOrigin());
		result.put("CustomerNo", m.getCustomerNo());
		result.put("CustomerName", m.getCustomerName());
		return result;
	}

	// 得到机器状态
	private Map getMachineStatus() {
		Map m = new HashMap();
		List<Unit> ul = this.getHibernateTemplate().find(
				"from Unit where UnitType = 'MACHINE_STATUS'");
		for (Unit u : ul)
			m.put(u.getUnitNo(), u.getUnitName());
		return m;
	}

	public Map searchMachineType(Map param, int currentPage, int pageRow) {
		StringBuffer hql = new StringBuffer();
		hql.append("from MachineType where Status = 'NORMAL'");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("MachineType"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" MachineType like :Condition" + conList.size());
			conList.add("%"+param.get("MachineType").toString()+"%");
		}
		if (!WebUtil.isNull(param.get("MachineCd"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" MachineCd = :Condition" + conList.size());
			conList.add(param.get("MachineCd"));
		}
		if (!WebUtil.isNull(param.get("MachineCat"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" MachineCat = :Condition" + conList.size());
			conList.add(param.get("MachineCat"));
		}
		if (!WebUtil.isNull(param.get("ServiceProviderType"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" ServiceProviderType like :Condition" + conList.size());
			conList.add(param.get("ServiceProviderType"));
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
			Query q = session.createQuery(hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q.setParameter("Condition" + i, conList.get(i));
			}
			if (pageRow > 0) {
				q.setFirstResult((currentPage - 1) * pageRow);
				q.setMaxResults(pageRow);
			}
			result = new HashMap();
			List<MachineType> l = q.list();
			List<Map> r = new ArrayList();
			for (MachineType mt : l) {
				Map m = new HashMap();
				m.put("MachineTypeId", mt.getId());
				m.put("MachineType", mt.getMachineType());
				m.put("MachineCd", mt.getMachineCd());
				m.put("MachineCat", mt.getMachineCat());
				m.put("ServiceProviderType", mt.getServiceProviderType());
				if (WebUtil.isNotNull(mt.getRate1()))
					m.put("Rate1", mt.getRate1().toString());
				if (WebUtil.isNotNull(mt.getRate2()))
					m.put("Rate2", mt.getRate2().toString());
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
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public List machineTypeList() {
		List<MachineType> l = this.getHibernateTemplate().find(
				"from MachineType where Status = 'NORMAL' order by id");
		return l;
	}

	public String checkMachineCd(String machineCd) {
		List<MachineType> mtl = this.getHibernateTemplate().find(
				"from MachineType where Status = 'NORMAL' and MachineCd = ?",
				machineCd);
		if (WebUtil.isNullForList(mtl)) {
			return null;
		} else
			return "商品编号重复,商品编号[" + machineCd + "]在系统已存在";
	}

	public Integer saveMachineType(Map param) {
		String machineTypeId = (String) param.get("MachineTypeId");
		MachineType mt = null;
		if (WebUtil.isNotNull(machineTypeId)) {
			List<MachineType> l = this.getHibernateTemplate()
					.find("from MachineType where id = ?",
							new Integer(machineTypeId));
			if (!WebUtil.isNullForList(l)) {
				mt = l.get(0);
			}
		}
		Date date = new Date();
		if (mt == null) {
			mt = new MachineType();
			mt.setCtime(date);
			mt.setCuser((String) param.get("UserName"));
			mt.setStatus("NORMAL");
		} else {
			mt.setMtime(date);
			mt.setMuser((String) param.get("UserName"));
		}
		if (WebUtil.isNotNull(param.get("MachineType")))
			mt.setMachineType((String) param.get("MachineType"));
		if (WebUtil.isNotNull(param.get("MachineCd")))
			mt.setMachineCd((String) param.get("MachineCd"));
		if (WebUtil.isNotNull(param.get("MachineCat")))
			mt.setMachineCat((String) param.get("MachineCat"));
		if (WebUtil.isNotNull(param.get("ServiceProviderType")))
			mt
					.setServiceProviderType((String) param
							.get("ServiceProviderType"));
		if (WebUtil.isNotNull(param.get("Rate1")))
			mt.setRate1(new BigDecimal((String) param.get("Rate1")));
		if (WebUtil.isNotNull(param.get("Rate2")))
			mt.setRate2(new BigDecimal((String) param.get("Rate2")));

		if (mt.getId() == null)
			this.getHibernateTemplate().save(mt);
		else
			this.getHibernateTemplate().update(mt);
		return mt.getId();
	}

	public Map getMachineTypeInfo(String machineTypeId) {
		if(!WebUtil.isNumeric(machineTypeId))
			return null;
		List<MachineType> l = this.getHibernateTemplate().find(
				"from MachineType where id = ?", new Integer(machineTypeId));
		if (WebUtil.isNullForList(l))
			return null;
		MachineType mt = l.get(0);
		Map result = new HashMap();
		result.put("MachineTypeId", mt.getId().toString());
		result.put("MachineType", mt.getMachineType());
		result.put("MachineCd", mt.getMachineCd());
		result.put("MachineCat", mt.getMachineCat());
		result.put("ServiceProviderType", mt.getServiceProviderType());
		if (WebUtil.isNotNull(mt.getRate1()))
			result.put("Rate1", mt.getRate1().toString());
		if (WebUtil.isNotNull(mt.getRate2()))
			result.put("Rate2", mt.getRate2().toString());
		if (WebUtil.isNotNull(mt.getCtime()))
			result.put("Ctime", WebUtil.formatDateString(mt.getCtime(),
					"yyyy-MM-dd HH:mm:ss"));
		result.put("Cuser", mt.getCuser());
		return result;
	}

	public boolean deleteMachineType(String machineTypeId) {
		List<MachineType> l = this.getHibernateTemplate().find(
				"from MachineType where id = ?", new Integer(machineTypeId));
		if (WebUtil.isNullForList(l))
			return false;
		MachineType mt = l.get(0);
		mt.setStatus("DELETE");
		this.getHibernateTemplate().update(mt);
		return true;
	}

	public Map checkMachine(String machineNo, UserLogin ul) {
		Map result = new HashMap();
		List<Object[]> ml = this
				.getHibernateTemplate()
				.find(
						"from Machine m,MachineType mt where m.MachineTypeId = mt.id and m.MachineNo = ?",
						machineNo);
		if (WebUtil.isNullForList(ml)) {
			result.put("Flag", "ERROR");
			result.put("Message", "无理光公司出货信息");
			return result;
		}
		Object[] obj = ml.get(0);
		Machine m = (Machine) obj[0];
		MachineType mt = (MachineType) obj[1];
		int companyId = ul.getCompanyId();
		List<CompanyMachineTypeRef> cl = this
				.getHibernateTemplate()
				.find(
						"from CompanyMachineTypeRef where id.CompanyId = ? and id.MachineTypeId = ?",
						new Object[] { companyId, m.getMachineTypeId() });
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
		result.put("Flag", "SUCCESS");
		Map mm = new HashMap();
		mm.put("MachineId", m.getId());
		mm.put("MachineNo", m.getMachineNo());
		mm.put("MachineTypeId", mt.getId());
		mm.put("MachineTypeName", mt.getMachineType());
		mm.put("MachineCat", mt.getMachineCat());
		mm.put("MachineCd", mt.getMachineCd());
		mm.put("PpsNo", m.getPpsNo());
		mm.put("PaymentStatus", m.getPaymentStatus());
		mm.put("PaymentCompany", m.getPaymentCompany());
		mm.put("PaymentCompanyCd", m.getPaymentCompanyCd());
		mm.put("ServiceFromDate", m.getServiceFromDate());
		mm.put("ServiceEndDate", m.getServiceEndDate());
		mm.put("InvoiceDate", m.getInvoiceDate());
		mm.put("OutDate", m.getOutDate());
		mm.put("LastTime", m.getLastTime());
		result.put("Machine", mm);
		return result;
	}

	//默认保修期为1年
	public BigDecimal getServiceDate(String machineCat) {
		List<MachineCat> l = this.getHibernateTemplate().find("from MachineCat where MachineCatCode = ?",machineCat);
		if(WebUtil.isNullForList(l))
			return new BigDecimal(1);
		else
			return l.get(0).getServiceDate();
	}

}
