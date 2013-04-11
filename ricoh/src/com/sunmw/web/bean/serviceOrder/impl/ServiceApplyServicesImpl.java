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
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunmw.web.bean.serviceOrder.ServiceApplyServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.Inventory;
import com.sunmw.web.entity.InventoryLog;
import com.sunmw.web.entity.MachineType;
import com.sunmw.web.entity.ServiceApply;
import com.sunmw.web.entity.ServiceApplyFile;
import com.sunmw.web.entity.ServiceApplyFilePK;
import com.sunmw.web.entity.ServiceDelivery;
import com.sunmw.web.entity.ServiceDeliveryItem;
import com.sunmw.web.entity.ServiceFault;
import com.sunmw.web.entity.ServiceHead;
import com.sunmw.web.entity.ServiceItem;
import com.sunmw.web.entity.ServiceVisit;
import com.sunmw.web.entity.Unit;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class ServiceApplyServicesImpl extends HibernateDaoSupport implements
		ServiceApplyServices {
	static Logger logger = Logger.getLogger(ServiceApplyServicesImpl.class);

	public Map searchServiceApply(Map param, int currentPage, int pageRow) {
		Session session = null;
		Map result = null;
		try {
			UserLogin ul = (UserLogin) param.get("UserLogin");
			String companyIds = getCompanyByUser(ul);
			StringBuffer hql = new StringBuffer();
			hql
					.append(" from ServiceApply sa,Company c,ServiceHead sh where sa.ServiceId = sh.id and sa.CompanyId = c.id");
			if (companyIds != null)
				hql.append(" and sa.CompanyId in (" + companyIds + ")");
			StringBuffer con = new StringBuffer();
			List conList = new ArrayList();
			if (WebUtil.isNotNull(param.get("CompanyName"))) {
				if (con.length() > 0)
					con.append(" and ");
				con.append(" c.CompanyName like :Condition" + conList.size());
				conList.add("%" + param.get("CompanyName") + "%");
			}
			if (WebUtil.isNotNull(param.get("ServiceApplyType"))) {
				if (con.length() > 0)
					con.append(" and ");
				con
						.append(" sa.ServiceApplyType = :Condition"
								+ conList.size());
				conList.add(param.get("ServiceApplyType"));
			}
			if (WebUtil.isNotNull(param.get("Status"))) {
				if (con.length() > 0)
					con.append(" and ");
				con.append(" sa.Status = :Condition" + conList.size());
				conList.add(param.get("Status"));
			}
			if (WebUtil.isNotNull(param.get("ServiceNo"))) {
				if (con.length() > 0)
					con.append(" and ");
				con.append(" sa.ServiceNo = :Condition" + conList.size());
				conList.add(param.get("ServiceNo"));
			}
			if (con.length() > 0)
				hql.append(" and " + con.toString());

			session = this.getSession();
			Query q1 = session.createQuery("select count(*) " + hql.toString());
			// 查询条件
			for (int i = 0; i < conList.size(); i++) {
				q1.setParameter("Condition" + i, conList.get(i));
			}
			List<Long> countList = q1.list();
			int count = countList.get(0).intValue();
			hql.append(" order by sa.Ctime desc");
			Query q = session
					.createQuery("select sa.id,sa.ServiceNo,sa.Status,sa.ServiceApplyType,c.CompanyName,sa.ServiceApplyNo,sa.Muser,sh.MachineNo"
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
			Map statusMap = getUnitMap("'APPLY_RATE_STATUS','APPLY_PART_STATUS'");
			List<Map> r = new ArrayList();
			for (Object[] obj : l) {
				Map m = new HashMap();
				m.put("ServiceApplyId", obj[0]);
				m.put("ServiceNo", obj[1]);
				m.put("Status", obj[2]);
				m.put("ServiceApplyType", obj[3]);
				m.put("CompanyName", obj[4]);
				m.put("ServiceApplyNo", obj[5]);
				m.put("Muser", obj[6]);
				m.put("MachineNo", obj[7]);
				if (obj[3].toString().toUpperCase().equals("RATE")) {
					m.put("StatusName", statusMap.get("APPLY_RATE_STATUS"
							+ obj[2]));
					m.put("ServiceApplyTypeName", "维修费用申请");
				} else if (obj[3].toString().toUpperCase().equals("PART")) {
					m.put("StatusName", statusMap.get("APPLY_PART_STATUS"
							+ obj[2]));
					m.put("ServiceApplyTypeName", "零件申请");
				} else {
					m.put("StatusName", statusMap.get("APPLY_PART_STATUS"
							+ obj[2]));
					m.put("ServiceApplyTypeName", "主机申请");
				}
				r.add(m);
			}
			result.put("RESULT", r);
			result.put("COUNT_ROW", count);
		} catch (DataAccessResourceFailureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
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

	private Map getUnitMap(String unitType) {
		List<Unit> ul = this.getHibernateTemplate().find(
				"from Unit where UnitType in (" + unitType + ")");
		Map m = new HashMap();
		for (Unit u : ul) {
			m.put(u.getUnitType() + u.getUnitNo(), u.getUnitName());
		}
		return m;
	}

	public Map createServiceApplyByPartAndMachine(Map param) {
		Map result = new HashMap();
		String serviceId = (String) param.get("ServiceId");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		// String applyType = (String) param.get("ApplyType");
		Session session = this.getSession();
		try {
			// 检查公司
			Query q0 = session
					.createQuery("from Company where id = :CompanyId and Status = 'NORMAL'");
			q0.setParameter("CompanyId", ul.getCompanyId());
			List<Company> cl = q0.list();
			if (WebUtil.isNullForList(cl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "公司信息错误");
				return result;
			}
			Company c = cl.get(0);
			// 检查维修单是否存在
			Query q1 = session
					.createQuery("from ServiceHead where id = :ServiceId");
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> shl = q1.list();
			if (WebUtil.isNullForList(shl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				logger.error("维修单未找到");
				return result;
			}
			ServiceHead sh = shl.get(0);
			// 检查用户是否有权限修改维修单
			if (sh.getCompanyId().intValue() != ul.getCompanyId().intValue()) {
				result.put("Flag", "ERROR");
				result.put("Message", "没有权限对维修单操作");
				logger.error("没有权限对维修单操作");
				return result;
			}
			// 检查维修单状态是否可修改
			// 维修状态：修理中；
			if (!(sh.getServiceStatus().equals("REPAIRING"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单不能申请");
				logger.error("此状态的维修单不能申请");
				return result;
			}
			// 检查申请单是否存在
			Query q2 = session
					.createQuery("from ServiceApply where ServiceId = :ServiceId and ServiceApplyType in ('PART','MACHINE')");
			q2.setParameter("ServiceId", sh.getId());
			List<ServiceApply> sal = q2.list();
			if (!WebUtil.isNullForList(sal)) {
				result.put("Flag", "ERROR");
				result.put("Message", "此维修单已申请过");
				logger.error("此维修单已申请过");
				return result;
			}
			// 检查维修单明细
			Query q3 = session
					.createQuery("from ServiceItem where ServiceId = :ServiceId");
			q3.setParameter("ServiceId", sh.getId());
			List<ServiceItem> sil = q3.list();
			// if (WebUtil.isNullForList(sil)) {
			// result.put("Flag", "ERROR");
			// result.put("Message", "此维修单没有填写主机/零件/选购件或耗材");
			// return result;
			// }
			// 判断明细中是否有主机、耗材、零件
			boolean isMachine = false;
			boolean isPart = false;
			boolean isProduct = false;
			for (ServiceItem si : sil) {
				if (si.getItemCate().trim().equals("零件"))
					isPart = true;
				if (si.getItemCate().trim().equals("主机"))
					isMachine = true;
				if (si.getItemCate().trim().equals("选购件或耗材"))
					isProduct = true;
			}
			Date date = new Date();

			Transaction tx = session.beginTransaction();
			if (isPart || (!isMachine && !isProduct)) {
				ServiceApply sa = new ServiceApply();
				sa.setServiceId(sh.getId());
				sa.setCcompany(c.getCompanyName());
				sa.setCtime(date);
				sa.setCuser(ul.getUserName());
				sa.setStatus("IN_APPLY");// 待审核状态
				sa.setServiceApplyType("PART");
				sa.setCompanyId(sh.getCompanyId());
				sa.setServiceNo(sh.getServiceNo());
				if (WebUtil.isNotNull(sh.getServiceNo()))
					sa.setServiceApplyNo("SP" + sh.getServiceNo().substring(1)
							+ "2");
				// 非主机/耗材分类
				sa.setMachineCat("");
				session.save(sa);
				// 更新维修单状态
				sh.setApplyPartStatus("IN_APPLY");

				session.update(sh);
			}
			if (isMachine || isProduct) {
				ServiceApply sa = new ServiceApply();
				sa.setServiceId(sh.getId());
				sa.setCcompany(c.getCompanyName());
				sa.setCtime(date);
				sa.setCuser(ul.getUserName());
				sa.setStatus("IN_APPLY");// 待审核状态
				sa.setServiceApplyType("MACHINE");
				sa.setCompanyId(sh.getCompanyId());
				sa.setServiceNo(sh.getServiceNo());
				if (WebUtil.isNotNull(sh.getServiceNo()))
					sa.setServiceApplyNo("SM" + sh.getServiceNo().substring(1)
							+ "3");
				// 主机/耗材分类
				if (isMachine) {
					sa.setMachineCat("主机");
				} else {
					sa.setMachineCat("耗材或选购件");
				}
				session.save(sa);
				// 更新维修单状态
				sh.setApplyMachineStatus("IN_APPLY");
				session.update(sh);
			}

			tx.commit();
			result.put("Flag", "SUCCESS");
			// result.put("ServiceApplyId", sa.getId().toString());
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
	
	public Map checkServiceApplyByRate(String serviceId)
	{
		Map result = new HashMap();
		List<ServiceHead> shList = this.getHibernateTemplate().find("from ServiceHead where id = ?",new Integer(serviceId));
		if(WebUtil.isNullForList(shList))
		{
			result.put("Flag", "SUCCESS");
			result.put("Message", "false");
			return result;
		}
		ServiceHead sh = shList.get(0);
		//查一个特约店同一机号的维修单，按创建时间倒序排列
		List<ServiceHead> checkShList = this.getHibernateTemplate().find("from ServiceHead where ServiceStatus <> 'CANCEL'  and CompanyId = ? and MachineNo = ? and Ctime < '"+WebUtil.formatDateString(sh.getCtime(), "yyyy-MM-dd HH:mm:ss")+"' order by Ctime desc",new Object[]{sh.getCompanyId(),sh.getMachineNo()});
		if(WebUtil.isNullForList(checkShList))
		{
			result.put("Flag", "SUCCESS");
			result.put("Message", "true");
			return result;
		}
		ServiceHead checkSh = checkShList.get(0);
		//上一张维修单的维修完成日期加一天同本张维修单的受理时间比较
		Date serviceDate = WebUtil.toDateForString(WebUtil.formatDateString(sh.getServiceDate(), "yyyy-MM-dd"), "yyyy-MM-dd");
		Date serviceFinishDate = WebUtil.toDateForString(WebUtil.formatDateString(new Date(checkSh.getServiceFinishDate().getTime()+24*60*60*1000), "yyyy-MM-dd"), "yyyy-MM-dd");//
		//30天以内不能申请费用30*24*60*60*1000
		if((serviceDate.getTime()-serviceFinishDate.getTime())<=2592000000L)
		{
			result.put("Flag", "SUCCESS");
			result.put("Message", "false");
		}
		else
		{
			result.put("Flag", "SUCCESS");
			result.put("Message", "true");
		}		
		return result;
	}

	public Map createServiceApplyByRate(Map param) {
		Map result = new HashMap();
		String serviceId = (String) param.get("ServiceId");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String applyType = (String) param.get("ApplyType");
		Session session = this.getSession();
		try {
			// 检查公司
			Query q0 = session
					.createQuery("from Company where id = :CompanyId and Status = 'NORMAL'");
			q0.setParameter("CompanyId", ul.getCompanyId());
			List<Company> cl = q0.list();
			if (WebUtil.isNullForList(cl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "公司信息错误");
				return result;
			}
			Company c = cl.get(0);
			// 检查维修单是否存在
			Query q1 = session
					.createQuery("from ServiceHead where id = :ServiceId");
			q1.setParameter("ServiceId", new Integer(serviceId));
			List<ServiceHead> shl = q1.list();
			if (WebUtil.isNullForList(shl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修单未找到");
				logger.error("维修单未找到");
				return result;
			}
			ServiceHead sh = shl.get(0);
			// 检查用户是否有权限修改维修单
			if (sh.getCompanyId().intValue() != ul.getCompanyId().intValue()) {
				result.put("Flag", "ERROR");
				result.put("Message", "没有权限对维修单操作");
				logger.error("没有权限对维修单操作");
				return result;
			}
			// 检查维修单状态是否可修改
			// 维修状态：已修复；
			if (!(sh.getServiceStatus().equals("REPAIR_COMPLETE"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此状态的维修单不能申请");
				logger.error("此状态的维修单不能申请");
				return result;
			}
			// 费用状态检查
			if (!(sh.getApplyRateStatus().equals("NO_APPLY"))) {
				result.put("Flag", "ERROR");
				result.put("Message", "此维修单已申请过费用");
				logger.error("此维修单已申请过费用");
				return result;
			}
			// 回访状态检查
			// if (!(sh.getVisitStatus().equals("VISIT"))) {
			// result.put("Flag", "ERROR");
			// result.put("Message", "此维修单未回访,回访后才能申请费用");
			// logger.error("此维修单未回访,回访后才能申请费用");
			// return result;
			// }
			// 检查申请单是否存在
			Query q2 = session
					.createQuery("from ServiceApply where ServiceId = :ServiceId and ServiceApplyType = :ServiceApplyType");
			q2.setParameter("ServiceId", sh.getId());
			q2.setParameter("ServiceApplyType", applyType);
			List<ServiceApply> sal = q2.list();
			if (!WebUtil.isNullForList(sal)) {
				result.put("Flag", "ERROR");
				result.put("Message", "此维修单已申请过");
				logger.error("此维修单已申请过");
				return result;
			}
			// 检查维修单明细
			Query q3 = session
					.createQuery("from ServiceItem where ServiceId = :ServiceId and ItemType = :ItemType");
			q3.setParameter("ServiceId", sh.getId());
			q3.setParameter("ItemType", applyType);
			List<ServiceItem> sil = q3.list();
			// if(WebUtil.isNullForList(sil))
			// {
			// result.put("Flag", "ERROR");
			// result.put("Message", "此维修单没有明细内容");
			// return result;
			// }
			// 检查机型
			Query q4 = session
					.createQuery("from MachineType where id in (select MachineTypeId from Machine where MachineNo = :MachineNo)");
			q4.setParameter("MachineNo", sh.getMachineNo());
			List<MachineType> mtl = q4.list();
			if (WebUtil.isNullForList(mtl)) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修机型不存在");
				logger.error("维修机型不存在");
				return result;
			}
			MachineType mt = mtl.get(0);
			BigDecimal tecRate = null;
			if (mt.getServiceProviderType().equals("特约维修店")) {
				tecRate = mt.getRate1();
			} else {
				tecRate = mt.getRate2();
			}
			if (tecRate == null) {
				result.put("Flag", "ERROR");
				result.put("Message", "维修机型相关费用不存在");
				logger.error("维修机型相关费用不存在");
				return result;
			}
			Date date = new Date();

			Transaction tx = session.beginTransaction();
			ServiceApply sa = new ServiceApply();
			sa.setServiceId(sh.getId());
			sa.setCcompany(c.getCompanyName());
			sa.setCtime(date);
			sa.setCuser(ul.getUserName());
			sa.setTecRate(tecRate);
			sa.setStatus("IN_APPLY");// 待审核状态
			sa.setServiceApplyType("RATE");
			sa.setCompanyId(sh.getCompanyId());
			sa.setServiceNo(sh.getServiceNo());
			if (WebUtil.isNotNull(sh.getServiceNo()))
				sa.setServiceApplyNo("SF" + sh.getServiceNo().substring(1)
						+ "1");
			sa.setHomeRate(WebUtil.round(WebUtil.toBigDecimal(param
					.get("HomeRate"))));
			sa.setOtherRate(WebUtil.round(WebUtil.toBigDecimal(param
					.get("OtherRate"))));
			sa.setOtherRateMemo((String) param.get("OtherRateMemo"));

			session.save(sa);
			// if(!WebUtil.isNullForList(sil))
			// {
			// for(ServiceItem si:sil)
			// {
			// ServiceApplyItem sai = new ServiceApplyItem();
			// sai.setCtime(date);
			// sai.setCuser(ul.getUserName());
			// sai.setServiceApplyId(sa.getId());
			// sai.setItemType(si.getItemType());
			// sai.setItemName(si.getItemName());
			// sai.setItemNo(si.getItemNo());
			// sai.setItemQty(si.getQty());
			// session.save(sai);
			// }
			// }
			// 更新维修单状态
			sh.setApplyRateStatus("IN_APPLY");

			session.update(sh);
			tx.commit();
			result.put("Flag", "SUCCESS");
			// result.put("ServiceApplyId", sa.getId().toString());
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

	public Map serviceApplyInfo(Map param) {
		Map result = new HashMap();
		String serviceApplyId = (String) param.get("ServiceApplyId");
		if(!WebUtil.isNumeric(serviceApplyId))
		{
			result.put("Flag", "ERROR");
			result.put("Message", "找不到维修申请信息");
			return result;
		}
		String serviceId = (String) param.get("ServiceId");
		String applyType = (String) param.get("ApplyType");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		List<Object[]> saList = null;
		String hql = "from ServiceApply sa,Company c,ServiceHead sh where sa.ServiceId = sh.id and sa.CompanyId = c.id ";
		if (companyIds != null)
			hql += " and sa.CompanyId in (" + companyIds + ")";
		if (WebUtil.isNotNull(serviceApplyId))
			saList = this.getHibernateTemplate().find(hql + " and sa.id = ? ",
					new Integer(serviceApplyId));
		else
			saList = this.getHibernateTemplate().find(
					hql + " and sa.ServiceId = ? and sa.ApplyType = ? ",
					new Object[] { new Integer(serviceId), applyType });
		if (WebUtil.isNullForList(saList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到维修申请信息");
			return result;
		}
		Map statusMap = getUnitMap("'APPLY_RATE_STATUS','APPLY_PART_STATUS'");
		Object[] obj = saList.get(0);
		ServiceApply sa = (ServiceApply) obj[0];
		Company c = (Company) obj[1];
		ServiceHead sh = (ServiceHead) obj[2];
		result.put("ServiceApplyId", sa.getId());
		result.put("AuditedResult", sa.getAuditedResult());
		result.put("CompanyId", sa.getCompanyId());
		result.put("CompanyName", c.getCompanyName());
		result.put("HomeRate", sa.getHomeRate());
		result.put("MachineCat", sa.getMachineCat());
		result.put("OtherRate", sa.getOtherRate());
		result.put("OtherRateMemo", sa.getOtherRateMemo());
		result.put("PartType", sa.getPartType());
		result.put("ResultMemo", sa.getResultMemo());
		if (WebUtil.isNotNull(sa.getServiceApplyType()))
			result.put("ServiceApplyType", sa.getServiceApplyType().trim());
		String itemType = null;
		if (sa.getServiceApplyType().trim().toUpperCase().equals("RATE")) {
			result.put("StatusName", statusMap.get("APPLY_RATE_STATUS"
					+ sa.getStatus()));
			result.put("ServiceApplyTypeName", "维修费用申请");
			// 回访信息
			List<ServiceVisit> visitList = this.getHibernateTemplate().find(
					"from ServiceVisit where ServiceId = ?", sa.getServiceId());
			if (!WebUtil.isNullForList(visitList)) {
				result.put("VisitId", visitList.get(0).getId());
				result.put("VisitResult", visitList.get(0).getVisitResult());
			}
		} else if (sa.getServiceApplyType().trim().toUpperCase().equals(
				"MACHINE")) {
			result.put("StatusName", statusMap.get("APPLY_PART_STATUS"
					+ sa.getStatus()));
			result.put("ServiceApplyTypeName", "主机申请");
			itemType = "MACHINE";
		} else {
			result.put("StatusName", statusMap.get("APPLY_PART_STATUS"
					+ sa.getStatus()));
			result.put("ServiceApplyTypeName", "零件申请");
			itemType = "PART";
		}
		result.put("ServiceId", sa.getServiceId());
		result.put("ServiceNo", sa.getServiceNo());
		result.put("ShopMemo", sa.getShopMemo());
		result.put("Status", sa.getStatus());
		result.put("TecRate", sa.getTecRate());
		result.put("Ctime", sa.getCtime());
		result.put("Cuser", sa.getCuser());
		result.put("Ccompany", sa.getCcompany());
		result.put("Muser", sa.getMuser());
		result.put("ServiceApplyAuditedUser", sa.getServiceApplyAuditedUser());
		result.put("ReturnFlag", sa.getReturnFlag());
		result.put("ReturnMemo", sa.getReturnMemo());
		result.put("ReturnImprove", sa.getReturnImprove());
		result.put("ReturnConfirm", sa.getReturnConfirm());
		result.put("ServiceApplyNo", sa.getServiceApplyNo());
		result.put("ServiceType", sh.getServiceType());
		result.put("BackMemo", sa.getBackMemo());
		List<Object[]> sfl = this
				.getHibernateTemplate()
				.find(
						"from ServiceFault sf,Unit u where sf.FaultCateNo = u.UnitNo and sf.ServiceId = ?",
						sa.getServiceId());
		if (!WebUtil.isNullForList(sfl)) {
			List faultList = new ArrayList();
			for (Object[] oo : sfl) {
				ServiceFault sf = (ServiceFault) oo[0];
				Unit u = (Unit) oo[1];
				Map m = new HashMap();
				if (sf.getFaultType().equals("SYMPTOM"))
					m.put("FaultType", "故障现象");
				else if (sf.getFaultType().equals("CAUSE"))
					m.put("FaultType", "故障原因");
				else if (sf.getFaultType().equals("ACTION"))
					m.put("FaultType", "故障措施");
				else if (sf.getFaultType().equals("LOCATION"))
					m.put("FaultType", "故障部位");
				else if (sf.getFaultType().equals("TARGET"))
					m.put("FaultType", "故障零件");
				m.put("FaultCateNo", u.getUnitName());
				m.put("FaultNo", sf.getFaultNo());
				m.put("FaultName", sf.getFaultName());
				m.put("Memo", sf.getMemo());
				m.put("MustMemo", sf.getMustMemo());
				m.put("Content", sf.getContent());
				faultList.add(m);
			}
			result.put("ServiceFaultList", faultList);
		}
		// 申请单看到明细内容只能是状态是申请，数量大于0的数据
		String hql2 = "from ServiceItem where ItemStatus = 'APPLY' and Qty > 0 and ServiceId = "
				+ sa.getServiceId();
		// if(itemType!=null)
		// hql2+=" and ItemType = '"+itemType+"'";
		List sil = null;
		// 主机信息
		if (sa.getServiceApplyType().equals("MACHINE")) {
			hql2 += " and ItemCate in ('选购件或耗材','主机')";
		} else if (sa.getServiceApplyType().equals("PART")) {
			hql2 += " and ItemCate = '零件'";
		}
		sil = this.getHibernateTemplate().find(hql2);
		result.put("ServiceItemList", sil);
		// if(!WebUtil.isNullForList(sail))
		// {
		// List l = new ArrayList();
		// for(ServiceItem sai:sail)
		// {
		// Map m = new HashMap();
		// m.put("ServiceItemId", sai.getId());
		// m.put("ItemName", sai.getItemName());
		// m.put("ItemNo", sai.getItemNo());
		// m.put("ItemQty", sai.getQty());
		// m.put("ItemType", sai.getItemType());
		// l.add(m);
		// }
		// result.put("ServiceApplyItemList", l);
		// }
		List<ServiceApplyFile> safl = this.getHibernateTemplate()
				.find("from ServiceApplyFile where id.ServiceApplyId = ?",
						sa.getId());
		result.put("ServiceApplyFileList", safl);
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map auditedServiceApply(Map param) {
		Map result = new HashMap();
		String serviceApplyId = (String) param.get("ServiceApplyId");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		String hql = "from ServiceApply sa,ServiceHead sh where sa.ServiceId = sh.id and sa.id = ? ";
		if (companyIds != null)
			hql += " and sh.CompanyId in (" + companyIds + ")";
		List<Object[]> saList = this.getHibernateTemplate().find(hql,
				new Integer(serviceApplyId));
		if (WebUtil.isNullForList(saList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到维修单信息");
			return result;
		}
		//此处修改,判断状态是否可以修改
		Object[] obj = saList.get(0);
		Date date = new Date();
		ServiceApply sa = (ServiceApply) obj[0];
		ServiceHead sh = (ServiceHead) obj[1];
		//已审核过的状态,非IN_APPLY状态(通过、发货、未通过、用库存、补库存)不可再审核
		if(!sa.getStatus().equals("IN_APPLY"))
		{
			result.put("Flag", "ERROR");
			result.put("Message", "该状态的维修申请不能进行审核");
			return result;
		}
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			if (WebUtil.isNotNull(param.get("AuditedResult")))
				sa.setAuditedResult((String) param.get("AuditedResult"));
			if (WebUtil.isNotNull(param.get("ResultMemo")))
				sa.setResultMemo((String) param.get("ResultMemo"));
			if (WebUtil.isNotNull(param.get("PartType")))
				sa.setPartType((String) param.get("PartType"));
			// 费用申请
			if (sa.getServiceApplyType().trim().toUpperCase().equals("RATE")) {
				// 通过
				if (sa.getAuditedResult().equals("NO_INVOICE")) {
					sa.setStatus("NO_INVOICE");
					sa.setServiceApplyAuditedDate(date);
					sa.setMtime(date);
					sa.setMuser(ul.getUserName());
					sa.setServiceApplyAuditedUser(ul.getUserName());
					session.update(sa);
					sh.setApplyRateStatus("NO_INVOICE");
					sh.setMtime(date);
					sh.setMuser(ul.getUserName());
					session.update(sh);
				}
				// 不通过
				else if (sa.getAuditedResult().equals("RE_APPLY")) {
					sa.setStatus("RE_APPLY");
					sa.setServiceApplyAuditedDate(date);
					sa.setMtime(date);
					sa.setMuser(ul.getUserName());
					sa.setServiceApplyAuditedUser(ul.getUserName());
					session.update(sa);
					sh.setApplyRateStatus("RE_APPLY");
					sh.setMtime(date);
					sh.setMuser(ul.getUserName());
					session.update(sh);
				}
			}
			// 主机申请/零件申请
			else if (sa.getServiceApplyType().trim().toUpperCase().equals(
					"MACHINE")
					|| sa.getServiceApplyType().trim().toUpperCase().equals(
							"PART")) {
				// 通过和区域发货
				if (sa.getAuditedResult().equals("WAIT_DELIVERY")
						|| sa.getAuditedResult().equals("AREA_DELIVERY")) {
					sa.setStatus(sa.getAuditedResult());
					sa.setServiceApplyAuditedDate(date);
					sa.setMtime(date);
					sa.setMuser(ul.getUserName());
					sa.setServiceApplyAuditedUser(ul.getUserName());
					session.update(sa);
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"MACHINE")) {
						sh.setApplyMachineStatus(sa.getAuditedResult());
						sh.setMtime(date);
						sh.setMuser(ul.getUserName());
						session.update(sh);
					}
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"PART")) {
						sh.setApplyPartStatus(sa.getAuditedResult());
						sh.setMtime(date);
						sh.setMuser(ul.getUserName());
						session.update(sh);
					}
					// 查零件明细是否存在
					String itemHql = "from ServiceItem where ItemStatus = 'APPLY' and Qty > 0 and ServiceId = "
							+ sh.getId();
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"MACHINE"))
						itemHql += " and ItemCate in ('主机','选购件或耗材')";
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"PART"))
						itemHql += " and ItemCate = '零件'";
					List partList = session.createQuery(itemHql).list();
					// 无零件信息则直接发货
					if (WebUtil.isNullForList(partList)) {
						if (sa.getServiceApplyType().trim().toUpperCase()
								.equals("MACHINE")) {
							sh.setApplyMachineStatus("DELIVERY");
							session.merge(sh);
							sa.setStatus("DELIVERY");
							session.merge(sa);
						}
						if (sa.getServiceApplyType().trim().toUpperCase()
								.equals("PART")) {
							sh.setApplyPartStatus("DELIVERY");
							session.merge(sh);
							sa.setStatus("DELIVERY");
							session.merge(sa);
						}
					} else {
						Map r = generateDelivery(sa, ul.getUserName(), session);
						// 发货单生成失败
						if (r.get("Flag").equals("ERROR")) {
							result.putAll(r);
							tx.rollback();
							session.close();
							return result;
						}
					}

				}
				// 不通过
				else if (sa.getAuditedResult().equals("RE_APPLY")) {
					sa.setStatus("RE_APPLY");
					sa.setServiceApplyAuditedDate(date);
					sa.setMtime(date);
					sa.setMuser(ul.getUserName());
					sa.setServiceApplyAuditedUser(ul.getUserName());
					session.update(sa);
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"MACHINE")) {
						sh.setApplyMachineStatus("RE_APPLY");
						sh.setMtime(date);
						sh.setMuser(ul.getUserName());
						session.update(sh);
					}
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"PART")) {
						sh.setApplyPartStatus("RE_APPLY");
						sh.setMtime(date);
						sh.setMuser(ul.getUserName());
						session.update(sh);
					}
				}
				// 用库存
				else if (sa.getAuditedResult().equals("USE_INV")) {
					sa.setStatus("USE_INV");
					sa.setInvFlag("USE_INV");
					sa.setServiceApplyAuditedDate(date);
					sa.setMtime(date);
					sa.setMuser(ul.getUserName());
					sa.setServiceApplyAuditedUser(ul.getUserName());
					session.update(sa);
					String itemCate = null;
					String invhql = null;
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"MACHINE")) {
						sh.setApplyMachineStatus("USE_INV");
						sh.setMtime(date);
						sh.setMuser(ul.getUserName());
						session.update(sh);
						invhql = "from ServiceItem where ItemStatus = 'APPLY' and ServiceId = :ServiceId and ItemCate in ('选购件或耗材','主机')";
					}
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"PART")) {
						sh.setApplyPartStatus("USE_INV");
						sh.setMtime(date);
						sh.setMuser(ul.getUserName());
						session.update(sh);
						invhql = "from ServiceItem where ItemStatus = 'APPLY' and ServiceId = :ServiceId and ItemCate = '零件' ";
					}
					// 减库存
					List<Map> invList = new ArrayList();

					Query q1 = session.createQuery(invhql);
					q1.setParameter("ServiceId", sa.getServiceId());
					List<ServiceItem> sil = q1.list();
					// 无明细情况
					if (WebUtil.isNullForList(sil)) {
						// result.put("Flag", "ERROR");
						// result.put("Message", "找不到维修单明细");
						// tx.rollback();
						// session.close();
						// return result;
					} else {
						for (ServiceItem si : sil) {
							Map m = new HashMap();
							m.put("WhId", sa.getCompanyId().toString());
							m.put("SkuCd", si.getItemNo());
							m.put("Qty", si.getQty());
							m.put("InvType", "A");
							m.put("LogType", "USE_INV");
							m.put("IoType", "O");
							m.put("BillNo", sa.getServiceNo());
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

				}
				// 补库存
				else if (sa.getAuditedResult().equals("ADD_INV")) {
					sa.setStatus("ADD_INV");
					sa.setInvFlag("ADD_INV");
					sa.setServiceApplyAuditedDate(date);
					sa.setMtime(date);
					sa.setMuser(ul.getUserName());
					sa.setServiceApplyAuditedUser(ul.getUserName());
					session.update(sa);
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"MACHINE")) {
						sh.setApplyMachineStatus("ADD_INV");
						sh.setMtime(date);
						sh.setMuser(ul.getUserName());
						session.update(sh);
					}
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"PART")) {
						sh.setApplyPartStatus("ADD_INV");
						sh.setMtime(date);
						sh.setMuser(ul.getUserName());
						session.update(sh);
					}// 查零件明细是否存在
					String itemHql = "from ServiceItem where ItemStatus = 'APPLY' and Qty > 0 and ServiceId = "
							+ sh.getId();
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"MACHINE"))
						itemHql += " and ItemCate in ('主机','选购件或耗材')";
					if (sa.getServiceApplyType().trim().toUpperCase().equals(
							"PART"))
						itemHql += " and ItemCate = '零件'";
					List partList = session.createQuery(itemHql).list();
					// 无零件信息则直接发货
					if (WebUtil.isNullForList(partList)) {
						if (sa.getServiceApplyType().trim().toUpperCase()
								.equals("MACHINE")) {
							sh.setApplyMachineStatus("DELIVERY");
							session.merge(sh);
							sa.setStatus("DELIVERY");
							session.merge(sa);
						}
						if (sa.getServiceApplyType().trim().toUpperCase()
								.equals("PART")) {
							sh.setApplyPartStatus("DELIVERY");
							session.merge(sh);
							sa.setStatus("DELIVERY");
							session.merge(sa);
						}
					} else {
						Map r = generateDelivery(sa, ul.getUserName(), session);
						// 发货单生成失败
						if (r.get("Flag").equals("ERROR")) {
							result.putAll(r);
							tx.rollback();
							session.close();
							return result;
						}
					}
				}
			}

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

	// 生成发货单
	private Map generateDelivery(ServiceApply sa, String userName,
			Session session) {
		Map result = new HashMap();
		ServiceDelivery sd = new ServiceDelivery();
		sd.setServiceApplyId(sa.getId());
		sd.setServiceId(sa.getServiceId());
		sd.setServiceNo(sa.getServiceNo());
		sd.setCompanyId(sa.getCompanyId());
		// 状态为通过待发货或补库存
		sd.setStatus(sa.getStatus());
		if (sa.getServiceApplyType().trim().toUpperCase().equals("MACHINE")) {
			sd.setDepartment("SCM");
			if (WebUtil.isNotNull(sa.getServiceNo()))
				sd.setServiceDeliveryNo("SMVD" + sa.getServiceNo().substring(1)
						+ "3");
		} else {
			sd.setDepartment("CSPC");
			if (WebUtil.isNotNull(sa.getServiceNo()))
				sd.setServiceDeliveryNo("SPVD" + sa.getServiceNo().substring(1)
						+ "2");
		}
		// 计算审核对应天数
		Date date = new Date();
		long d = (date.getTime() - sa.getCtime().getTime())
				/ (24 * 60 * 60 * 1000);
		sd.setAuditedTime("" + (d + 1));
		sd.setCtime(date);
		sd.setCuser(userName);
		session.save(sd);
		String hql = "";
		// SCM
		if (sa.getServiceApplyType().trim().toUpperCase().equals("MACHINE"))
			hql = "from ServiceItem where ServiceId = :ServiceId and ItemCate in ('主机','选购件或耗材') and ItemStatus = 'APPLY'";
		// CSPC
		else
			hql = "from ServiceItem where ServiceId = :ServiceId and ItemCate = '零件' and ItemStatus = 'APPLY'";
		Query q1 = session.createQuery(hql);
		q1.setParameter("ServiceId", sa.getServiceId());
		List<ServiceItem> siList = q1.list();
		if (WebUtil.isNullForList(siList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到维修登记信息");
			return result;
		} else {
			for (ServiceItem si : siList) {
				ServiceDeliveryItem sdi = new ServiceDeliveryItem();
				sdi.setServiceDeliveryId(sd.getId());
				sdi.setItemCate(si.getItemCate());
				sdi.setItemName(si.getItemName());
				sdi.setItemNo(si.getItemNo());
				sdi.setItemQty(si.getQty());
				sdi.setItemSerialNo(si.getItemSerialNo());
				sdi.setCtime(date);
				sdi.setCuser(userName);
				session.save(sdi);
			}
		}

		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map reApplyService(Map param) {
		Map result = new HashMap();
		String serviceApplyId = (String) param.get("ServiceApplyId");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		List<Object[]> saList = this
				.getHibernateTemplate()
				.find(
						"from ServiceApply sa,ServiceHead sh where sa.ServiceId = sh.id and sa.id = ? and sh.CompanyId in ("
								+ companyIds + ")", new Integer(serviceApplyId));
		if (WebUtil.isNullForList(saList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到维修单信息");
			return result;
		}
		Object[] obj = saList.get(0);
		ServiceApply sa = (ServiceApply) obj[0];
		ServiceHead sh = (ServiceHead) obj[1];
		if (!sa.getStatus().equals("RE_APPLY")) {
			result.put("Flag", "ERROR");
			result.put("Message", "该状态不能操作");
			return result;
		}
		String shopMemo = (String) param.get("ShopMemo");
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();

			sa.setStatus("IN_APPLY");
			sa.setShopMemo(shopMemo);

			// 维修费用
			if (sa.getServiceApplyType().trim().toUpperCase().equals("RATE")) {
				sa.setHomeRate(WebUtil.round(WebUtil.toBigDecimal(param
						.get("HomeRate"))));
				sa.setOtherRate(WebUtil.round(WebUtil.toBigDecimal(param
						.get("OtherRate"))));
				sa.setOtherRateMemo((String) param.get("OtherRateMemo"));
			}
			session.update(sa);
			// 更新维修单状态
			if (sa.getServiceApplyType().trim().toUpperCase().equals("MACHINE")) {
				sh.setApplyMachineStatus("IN_APPLY");
			}
			if (sa.getServiceApplyType().trim().toUpperCase().equals("PART")) {
				sh.setApplyPartStatus("IN_APPLY");
			}
			if (sa.getServiceApplyType().trim().toUpperCase().equals("RATE")) {
				sh.setApplyRateStatus("IN_APPLY");
			}
			session.update(sh);

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

	public Map serviceApplyFileUpload(Map param) {
		Map result = new HashMap();
		String serviceApplyId = (String) param.get("ServiceApplyId");
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
					.createQuery("from ServiceApplyFile where id.FileType = :FileType and id.ServiceApplyId = :ServiceApplyId");
			q2.setParameter("FileType", fileType);
			q2.setParameter("ServiceApplyId", new Integer(serviceApplyId));
			List<ServiceApplyFile> sdfl = q2.list();
			if (WebUtil.isNullForList(sdfl)) {
				ServiceApplyFile sdf = new ServiceApplyFile();
				ServiceApplyFilePK pk = new ServiceApplyFilePK();
				pk.setFileType(fileType);
				pk.setServiceApplyId(new Integer(serviceApplyId));
				sdf.setId(pk);
				sdf.setFileUrl(fileUrl);
				sdf.setFileName(fileName);
				if (fileSize != null)
					sdf.setFileSize(fileSize.intValue());
				sdf.setCtime(date);
				sdf.setCuser(ul.getUserName());
				session.save(sdf);
			} else {
				ServiceApplyFile sdf = sdfl.get(0);
				sdf.setFileUrl(fileUrl);
				sdf.setFileName(fileName);
				if (fileSize != null)
					sdf.setFileSize(fileSize.intValue());
				sdf.setMtime(date);
				sdf.setMuser(ul.getUserName());
				session.update(sdf);
			}
			tx.commit();
			result.put("Flag", "SUCCESS");
			result.put("ServiceApplyId", serviceApplyId);
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

	// 未审核和审核未通过不能进行此操作
	public Map saveServiceApplyReturn(Map param) {
		Map result = new HashMap();
		String serviceApplyId = (String) param.get("ServiceApplyId");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		String hql = "from ServiceApply sa where sa.id = ? ";
		if (companyIds != null)
			hql += " and sa.CompanyId in (" + companyIds + ")";
		List<ServiceApply> saList = this.getHibernateTemplate().find(hql,
				new Integer(serviceApplyId));
		if (WebUtil.isNullForList(saList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "找不到维修申请信息");
			return result;
		}
		ServiceApply sa = saList.get(0);
		if (sa.getStatus().equals("IN_APPLY")
				|| sa.getStatus().equals("RE_APPLY")) {
			result.put("Flag", "ERROR");
			result.put("Message", "该状态不能操作");
			return result;
		}
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			sa.setReturnMemo((String) param.get("ReturnMemo"));
			sa.setReturnFlag((String) param.get("ReturnFlag"));
			sa.setReturnImprove((String) param.get("ReturnImprove"));
			sa.setReturnConfirm((String)param.get("ReturnConfirm"));
			sa.setMtime(new Date());
			sa.setMuser(ul.getUserName());
			session.update(sa);

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
