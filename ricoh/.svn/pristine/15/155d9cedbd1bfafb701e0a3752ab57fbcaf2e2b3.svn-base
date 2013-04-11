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

import com.sunmw.web.bean.serviceOrder.ServiceDeliveryServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.ServiceApply;
import com.sunmw.web.entity.ServiceApplyFile;
import com.sunmw.web.entity.ServiceDelivery;
import com.sunmw.web.entity.ServiceDeliveryFile;
import com.sunmw.web.entity.ServiceDeliveryFilePK;
import com.sunmw.web.entity.ServiceDeliveryItem;
import com.sunmw.web.entity.ServiceHead;
import com.sunmw.web.entity.Unit;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class ServiceDeliveryServicesImpl extends HibernateDaoSupport implements
		ServiceDeliveryServices {

	public Map searchServiceDelivery(Map param, int currentPage, int pageRow) {
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		StringBuffer hql = new StringBuffer();
		hql
				.append(" from ServiceDelivery sd,ServiceHead sh,Company c where sd.CompanyId = c.id and sd.ServiceId = sh.id");
		if (companyIds != null)
			hql.append(" and sd.CompanyId in (" + companyIds + ")");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (WebUtil.isNotNull(param.get("ShopName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" c.CompanyName like :Condition" + conList.size());
			conList.add("%" + param.get("ShopName") + "%");
		}
		if (WebUtil.isNotNull(param.get("ServiceNo"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sd.ServiceNo = :Condition" + conList.size());
			conList.add(param.get("ServiceNo"));
		}
		if (WebUtil.isNotNull(param.get("Status"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sd.Status = :Condition" + conList.size());
			conList.add(param.get("Status"));
		}
		if (WebUtil.isNotNull(param.get("Department"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" sd.Department = :Condition" + conList.size());
			conList.add(param.get("Department"));
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
			hql.append(" order by sd.Ctime desc");
			Query q = session
					.createQuery("select sd.id,sd.ServiceNo,sd.Status,sd.Department,c.CompanyName,sd.ShippingNo,sd.ServiceDeliveryNo"
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
			Map statusMap = getUnitMap("'APPLY_PART_STATUS'");
			List<Map> r = new ArrayList();
			for (Object[] obj : l) {
				Map m = new HashMap();
				m.put("ServiceDeliveryId", obj[0]);
				m.put("ServiceNo", obj[1]);
				m.put("Status", obj[2]);
				m.put("Department", obj[3]);
				m.put("CompanyName", obj[4]);
				m.put("ShippingNo", obj[5]);
				m.put("ServiceDeliveryNo", obj[6]);
				m
						.put("StatusName", statusMap.get("APPLY_PART_STATUS"
								+ obj[2]));
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

	public Map serviceDeliveryInfo(Map param) {
		Map result = new HashMap();
		String serviceDeliveryId = (String) param.get("ServiceDeliveryId");
		if(!WebUtil.isNumeric(serviceDeliveryId))
		{
			result.put("Flag", "ERROR");
			result.put("Message", "发货信息未找到");
			return result;
		}
		String department = (String) param.get("Department");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		String hql = "from ServiceDelivery sd,Company c,ServiceApply sa where sd.CompanyId = c.id and sd.ServiceApplyId = sa.id and sd.id = ? and sd.Department = ?";
		if (companyIds != null)
			hql += " and sd.CompanyId in (" + companyIds + ")";
		List<Object[]> sdList = this.getHibernateTemplate().find(hql,
				new Object[] { new Integer(serviceDeliveryId), department });
		if (WebUtil.isNullForList(sdList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "发货信息未找到");
			return result;
		}
		Object[] obj = sdList.get(0);
		ServiceDelivery sd = (ServiceDelivery) obj[0];
		Company c = (Company) obj[1];
		ServiceApply sa = (ServiceApply) obj[2];
		result.put("ServiceDeliveryId", sd.getId());
		result.put("ServiceDeliveryNo", sd.getServiceDeliveryNo());
		result.put("ServiceApplyNo", sa.getServiceApplyNo());
		result.put("AllTime", sd.getAllTime());
		result.put("AuditedTime", sd.getAuditedTime());
		result.put("CompanyId", sd.getCompanyId());
		result.put("CompanyName", c.getCompanyName());
		result.put("Ctime", sd.getCtime());
		result.put("Cuser", sd.getCuser());
		result.put("DeliveryTime", sd.getDeliveryTime());
		result.put("Department", sd.getDepartment());
		result.put("ServiceApplyId", sd.getServiceApplyId());
		result.put("ServiceId", sd.getServiceId());
		result.put("ServiceNo", sd.getServiceNo());
		result.put("ShippingNo", sd.getShippingNo());
		result.put("DeliveryStock", sd.getDeliveryStock());
		result.put("DeliveryDate", sd.getDeliveryDate());
		result.put("ServiceDeliveryNo", sd.getServiceDeliveryNo());
		result.put("Status", sd.getStatus());
		result.put("ServiceApplyAuditedUser", sa.getServiceApplyAuditedUser());
		Map statusMap = getUnitMap("'APPLY_PART_STATUS'");
		result.put("StatusName", statusMap.get("APPLY_PART_STATUS"
				+ sd.getStatus()));
		List<ServiceDeliveryItem> sdiList = this.getHibernateTemplate().find(
				"from ServiceDeliveryItem where ServiceDeliveryId = ?",
				sd.getId());
		if (!WebUtil.isNullForList(sdiList)) {
			List sdItemList = new ArrayList();
			for (ServiceDeliveryItem sdi : sdiList) {
				Map m = new HashMap();
				m.put("id", sdi.getId());
				m.put("ItemCate", sdi.getItemCate());
				m.put("ItemNo", sdi.getItemNo());
				m.put("ItemName", sdi.getItemName());
				m.put("ItemQty", sdi.getItemQty());
				m.put("ItemSerialNo", sdi.getItemSerialNo());
				m.put("ItemChange", sdi.getItemChange());
				m.put("NewItemNo", sdi.getNewItemNo());
				m.put("HasInv", sdi.getHasInv());
				m.put("ItemOrderNo", sdi.getItemOrderNo());
				if (WebUtil.isNotNull(sdi.getItemOrderDate()))
					m.put("ItemOrderDate", WebUtil.formatDateString(sdi
							.getItemOrderDate(), "yyyy-MM-dd"));
				if (WebUtil.isNotNull(sdi.getItemDeliveryDate()))
					m.put("ItemDeliveryDate", WebUtil.formatDateString(sdi
							.getItemDeliveryDate(), "yyyy-MM-dd"));
				if (WebUtil.isNotNull(sdi.getItemArrivalDate()))
					m.put("ItemArrivalDate", WebUtil.formatDateString(sdi
							.getItemArrivalDate(), "yyyy-MM-dd"));
				sdItemList.add(m);
			}
			result.put("ServiceDeliveryItemList", sdItemList);

		}
		List<ServiceDeliveryFile> sdfList = this.getHibernateTemplate().find(
				"from ServiceDeliveryFile where id.ServiceDeliveryId = ?",
				sd.getId());
		result.put("ServiceDeliveryFileList", sdfList);
		// 维修申请的附件
		List<ServiceApplyFile> safl = this.getHibernateTemplate()
				.find("from ServiceApplyFile where id.ServiceApplyId = ?",
						sa.getId());
		result.put("ServiceApplyFileList", safl);
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map deliveryServiceOrder(Map param) {
		Map result = new HashMap();
		String serviceDeliveryId = (String) param.get("ServiceDeliveryId");
		String department = (String) param.get("Department");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		String hql = "from ServiceDelivery sd,ServiceApply sa,ServiceHead sh where sd.ServiceId = sh.id and sd.ServiceApplyId = sa.id and sd.id = ? and sd.Department = ?";
		if (companyIds != null)
			hql += " and sd.CompanyId in (" + companyIds + ")";
		List<Object[]> sdList = this.getHibernateTemplate().find(hql,
				new Object[] { new Integer(serviceDeliveryId), department });
		if (WebUtil.isNullForList(sdList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "发货信息未找到");
			return result;
		}
		Object[] obj = sdList.get(0);
		ServiceDelivery sd = (ServiceDelivery) obj[0];
		ServiceApply sa = (ServiceApply) obj[1];
		ServiceHead sh = (ServiceHead) obj[2];
		// 等待发货和补库存才能发货
		if (sd.getStatus().equals("DELIVERY")) {
			result.put("Flag", "ERROR");
			result.put("Message", "发货单已经发货,不能重复发货");
			return result;
		}
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			String shippingNo = (String) param.get("ShippingNo");
			String deliveryStock = (String) param.get("DeliveryStock");
			String deliveryDate = (String) param.get("DeliveryDate");
			sd.setShippingNo(shippingNo);
			sd.setDeliveryStock(deliveryStock);
			if (WebUtil.isNotNull(deliveryDate))
				sd.setDeliveryDate(WebUtil.toDateForString(deliveryDate,
						"yyyy-MM-dd"));
			sd.setStatus("DELIVERY");
			// 发货对应天数
			long d = (date.getTime() - sd.getCtime().getTime())
					/ (24 * 60 * 60 * 1000);
			sd.setDeliveryTime("" + (d + 1));
			// 总对应天数
			long a = (date.getTime() - sa.getCtime().getTime())
					/ (24 * 60 * 60 * 1000);
			sd.setAllTime("" + (a + 1));
			sd.setMtime(date);
			sd.setMuser(ul.getUserName());
			session.update(sd);
			// 更新申请单状态
			sa.setStatus("DELIVERY");
			sa.setMtime(date);
			sa.setMuser(ul.getUserName());
			session.update(sa);
			// 更新维修单状态
			if (sd.getDepartment().equals("SCM"))
				sh.setApplyMachineStatus("DELIVERY");
			else
				sh.setApplyPartStatus("DELIVERY");
			sh.setMtime(date);
			sh.setMuser(ul.getUserName());
			session.update(sh);
			List<Map> itemList = (List) param.get("ServiceDeliveryItemList");
			for (Map item : itemList) {
				String itemId = (String) item.get("ServiceDeliveryItemId");
				if (WebUtil.isNull(itemId))
					continue;
				Query q1 = session
						.createQuery("from ServiceDeliveryItem where id = :ServiceDeliveryItemId");
				q1.setParameter("ServiceDeliveryItemId", new Integer(itemId));
				List<ServiceDeliveryItem> l = q1.list();
				if (WebUtil.isNullForList(l)) {
					continue;
				}
				ServiceDeliveryItem sdi = l.get(0);
				sdi.setMtime(date);
				sdi.setMuser(ul.getUserName());
				if (WebUtil.isNotNull(item.get("ItemArrivalDate")))
					sdi.setItemArrivalDate(WebUtil.toDateForString(item.get(
							"ItemArrivalDate").toString(), "yyyy-MM-dd"));
				sdi.setItemChange((String) item.get("ItemChange"));
				if (WebUtil.isNotNull(item.get("ItemDeliveryDate")))
					sdi.setItemDeliveryDate(WebUtil.toDateForString(item.get(
							"ItemDeliveryDate").toString(), "yyyy-MM-dd"));
				sdi.setHasInv((String) item.get("HasInv"));
				if (WebUtil.isNotNull(item.get("ItemOrderDate")))
					sdi.setItemOrderDate(WebUtil.toDateForString(item.get(
							"ItemOrderDate").toString(), "yyyy-MM-dd"));
				sdi.setItemOrderNo((String) item.get("ItemOrderNo"));
				sdi.setNewItemNo((String) item.get("NewItemNo"));
				session.update(sdi);
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
			if (session != null&&session.isOpen())
				session.close();
		}
		return result;
	}
	
	public Map waitDeliveryServiceOrder(Map param) {
		Map result = new HashMap();
		String serviceDeliveryId = (String) param.get("ServiceDeliveryId");
		String department = (String) param.get("Department");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		String hql = "from ServiceDelivery sd,ServiceApply sa,ServiceHead sh where sd.ServiceId = sh.id and sd.ServiceApplyId = sa.id and sd.id = ? and sd.Department = ?";
		if (companyIds != null)
			hql += " and sd.CompanyId in (" + companyIds + ")";
		List<Object[]> sdList = this.getHibernateTemplate().find(hql,
				new Object[] { new Integer(serviceDeliveryId), department });
		if (WebUtil.isNullForList(sdList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "发货信息未找到");
			return result;
		}
		Object[] obj = sdList.get(0);
		ServiceDelivery sd = (ServiceDelivery) obj[0];
		ServiceApply sa = (ServiceApply) obj[1];
		ServiceHead sh = (ServiceHead) obj[2];
		// 等待发货和补库存才能发货
		if (sd.getStatus().equals("DELIVERY")) {
			result.put("Flag", "ERROR");
			result.put("Message", "发货单已经发货,不能进行缺货操作");
			return result;
		}
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			String shippingNo = (String) param.get("ShippingNo");
			String deliveryStock = (String) param.get("DeliveryStock");
			String deliveryDate = (String) param.get("DeliveryDate");
			sd.setShippingNo(shippingNo);
			sd.setDeliveryStock(deliveryStock);
			if (WebUtil.isNotNull(deliveryDate))
				sd.setDeliveryDate(WebUtil.toDateForString(deliveryDate,
						"yyyy-MM-dd"));
			sd.setStatus("NO_DELIVERY");
			// 发货对应天数
//			long d = (date.getTime() - sd.getCtime().getTime())
//					/ (24 * 60 * 60 * 1000);
//			sd.setDeliveryTime("" + (d + 1));
			// 总对应天数
//			long a = (date.getTime() - sa.getCtime().getTime())
//					/ (24 * 60 * 60 * 1000);
//			sd.setAllTime("" + (a + 1));
			sd.setMtime(date);
			sd.setMuser(ul.getUserName());
			session.update(sd);
			// 更新申请单状态
//			sa.setStatus("NO_DELIVERY");
//			sa.setMtime(date);
//			sa.setMuser(ul.getUserName());
//			session.update(sa);
			// 更新维修单状态
//			if (sd.getDepartment().equals("SCM"))
//				sh.setApplyMachineStatus("NO_DELIVERY");
//			else
//				sh.setApplyPartStatus("NO_DELIVERY");
//			sh.setMtime(date);
//			sh.setMuser(ul.getUserName());
//			session.update(sh);
			List<Map> itemList = (List) param.get("ServiceDeliveryItemList");
			for (Map item : itemList) {
				String itemId = (String) item.get("ServiceDeliveryItemId");
				if (WebUtil.isNull(itemId))
					continue;
				Query q1 = session
						.createQuery("from ServiceDeliveryItem where id = :ServiceDeliveryItemId");
				q1.setParameter("ServiceDeliveryItemId", new Integer(itemId));
				List<ServiceDeliveryItem> l = q1.list();
				if (WebUtil.isNullForList(l)) {
					continue;
				}
				ServiceDeliveryItem sdi = l.get(0);
				sdi.setMtime(date);
				sdi.setMuser(ul.getUserName());
				if (WebUtil.isNotNull(item.get("ItemArrivalDate")))
					sdi.setItemArrivalDate(WebUtil.toDateForString(item.get(
							"ItemArrivalDate").toString(), "yyyy-MM-dd"));
				sdi.setItemChange((String) item.get("ItemChange"));
				if (WebUtil.isNotNull(item.get("ItemDeliveryDate")))
					sdi.setItemDeliveryDate(WebUtil.toDateForString(item.get(
							"ItemDeliveryDate").toString(), "yyyy-MM-dd"));
				sdi.setHasInv((String) item.get("HasInv"));
				if (WebUtil.isNotNull(item.get("ItemOrderDate")))
					sdi.setItemOrderDate(WebUtil.toDateForString(item.get(
							"ItemOrderDate").toString(), "yyyy-MM-dd"));
				sdi.setItemOrderNo((String) item.get("ItemOrderNo"));
				sdi.setNewItemNo((String) item.get("NewItemNo"));
				session.update(sdi);
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
			if (session != null&&session.isOpen())
				session.close();
		}
		return result;
	}

	public Map deliveryBackApply(Map param) {
		Map result = new HashMap();
		String serviceDeliveryId = (String) param.get("ServiceDeliveryId");
		String backMemo = (String) param.get("BackMemo");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		String companyIds = getCompanyByUser(ul);
		String hql = "from ServiceDelivery sd,ServiceApply sa,ServiceHead sh where sd.ServiceId = sh.id and sd.ServiceApplyId = sa.id and sd.id = ? ";
		if (companyIds != null)
			hql += " and sd.CompanyId in (" + companyIds + ")";
		List<Object[]> sdList = this.getHibernateTemplate().find(hql,
				new Integer(serviceDeliveryId));
		if (WebUtil.isNullForList(sdList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "发货信息未找到!");
			return result;
		}
		Object[] obj = sdList.get(0);
		ServiceDelivery sd = (ServiceDelivery) obj[0];
		ServiceApply sa = (ServiceApply) obj[1];
		ServiceHead sh = (ServiceHead) obj[2];
		// 等待发货和补库存才能发货
		if (sd.getStatus().equals("DELIVERY")) {
			result.put("Flag", "ERROR");
			result.put("Message", "发货单已经发货,不能退回!");
			return result;
		}
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			Date date = new Date();
			// 删除发货
			session.delete(sd);
			session.createQuery(
					"delete ServiceDeliveryItem where ServiceDeliveryId = "
							+ sd.getId()).executeUpdate();
			session.createQuery(
					"delete ServiceDeliveryFile where id.ServiceDeliveryId = "
							+ sd.getId()).executeUpdate();
			// 更新维修申请状态
			sa.setStatus("IN_APPLY");
			sa.setMtime(date);
			sa.setMuser(ul.getUserName());
			//更新退回说明
			sa.setBackMemo(backMemo);
			session.update(sa);
			// 更新维修单状态
			if (sd.getDepartment().equals("SCM")) {
				sh.setApplyMachineStatus("IN_APPLY");
			} else {
				sh.setApplyPartStatus("IN_APPLY");
			}
			sh.setMtime(date);
			sh.setMuser(ul.getUserName());
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
			if (session != null&&session.isOpen())
				session.close();
		}
		return result;
	}

	public Map serviceDeliveryFileUpload(Map param) {
		Map result = new HashMap();
		String serviceDeliveryId = (String) param.get("ServiceDeliveryId");
		String fileUrl = (String) param.get("FileUrl");
		String fileType = (String) param.get("Department");
		String fileName = (String) param.get("FileName");
		Long fileSize = (Long) param.get("FileSize");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			Date date = new Date();

			// 维修单发票地址
			Query q2 = session
					.createQuery("from ServiceDeliveryFile where id.FileType = :FileType and id.ServiceDeliveryId = :ServiceDeliveryId");
			q2.setParameter("FileType", fileType);
			q2
					.setParameter("ServiceDeliveryId", new Integer(
							serviceDeliveryId));
			List<ServiceDeliveryFile> sdfl = q2.list();
			if (WebUtil.isNullForList(sdfl)) {
				ServiceDeliveryFile sdf = new ServiceDeliveryFile();
				ServiceDeliveryFilePK pk = new ServiceDeliveryFilePK();
				pk.setFileType(fileType);
				pk.setServiceDeliveryId(new Integer(serviceDeliveryId));
				sdf.setId(pk);
				sdf.setFileUrl(fileUrl);
				sdf.setFileName(fileName);
				if (fileSize != null)
					sdf.setFileSize(fileSize.intValue());
				sdf.setCtime(date);
				sdf.setCuser(ul.getUserName());
				session.save(sdf);
			} else {
				ServiceDeliveryFile sdf = sdfl.get(0);
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
			result.put("ServiceDeliveryId", serviceDeliveryId);
			result.put("Department", fileType);
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
			if (session != null&&session.isOpen())
				session.close();
		}
		return result;
	}
}
