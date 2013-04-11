package com.sunmw.web.bean.print.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunmw.web.action.print.ServiceOrderPrintBean;
import com.sunmw.web.action.print.ServiceReturnPrintBean;
import com.sunmw.web.bean.print.PrintServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.Machine;
import com.sunmw.web.entity.MachineType;
import com.sunmw.web.entity.ServiceApply;
import com.sunmw.web.entity.ServiceFault;
import com.sunmw.web.entity.ServiceHead;
import com.sunmw.web.entity.ServiceItem;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class PrintServicesImpl extends HibernateDaoSupport implements
		PrintServices {

	public Map serviceOrderPrintInfo(Map param) {
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
			result.put("Message", "无权限操作");
			return result;
		}
		String serviceId = (String) param.get("ServiceId");
		StringBuffer hql = new StringBuffer();
		hql
				.append("from ServiceHead sh,Company c,Machine m,MachineType mt where sh.CompanyId = c.id and sh.MachineNo = m.MachineNo and m.MachineTypeId = mt.id and sh.id = ?");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and sh.CompanyId in (" + companyIds + ")");
		List<Object[]> shList = this.getHibernateTemplate().find(
				hql.toString(), new Integer(serviceId));
		if (WebUtil.isNullForList(shList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "维修单没找到");
			return result;
		}
		Object[] obj = shList.get(0);
		ServiceHead sh = (ServiceHead) obj[0];
		Company cc = (Company) obj[1];
		Machine m = (Machine) obj[2];
		MachineType mt = (MachineType) obj[3];
		ServiceOrderPrintBean sp = new ServiceOrderPrintBean();
		sp.setCompanyName(cc.getCompanyName());
		sp.setServiceNo(sh.getServiceNo());
		if (WebUtil.isNotNull(m.getInvoiceDate()))
			sp.setInstallDate(WebUtil.formatDateString(m.getInvoiceDate(),
					"yyyy-MM-dd"));
		else
			sp.setInstallDate("");
		sp.setMachineTypeName(mt.getMachineType());
		sp.setMachineNo(sh.getMachineNo());
		sp.setBlackWhiteNumber(sh.getBlackWhiteNumber());
		sp.setColorNumber(sh.getColorNumber());
		sp.setServiceDateType(sh.getServiceDateStatus());
		sp.setFaultDate("");
		sp.setServiceMethod(sh.getServiceMethod());
		if (WebUtil.isNotNull(sh.getServiceDate()))
			sp.setServiceDate(WebUtil.formatDateString(sh.getServiceDate(),
					"yyyy-MM-dd"));
		if (WebUtil.isNotNull(sh.getFromDate()))
			sp.setFromDate(WebUtil.formatDateString(sh.getFromDate(),
					"yyyy-MM-dd HH:mm"));
		if (WebUtil.isNotNull(sh.getEndDate()))
			sp.setEndDate(WebUtil.formatDateString(sh.getEndDate(),
					"yyyy-MM-dd HH:mm"));
		if (WebUtil.isNotNull(sh.getServiceFinishDate()))
			sp.setServiceFinishDate(WebUtil.formatDateString(sh
					.getServiceFinishDate(), "yyyy-MM-dd"));
		if (WebUtil.isNotNull(sh.getCustomerRetrieveDate()))
			sp.setCustomerRetrieveDate(WebUtil.formatDateString(sh
					.getCustomerRetrieveDate(), "yyyy-MM-dd"));
		sp.setServicePeople(sh.getCuser());
		sp.setMachineMemo(sh.getMachineMemo());
		sp.setCustomerCompany(sh.getCustomerCompany());
		StringBuffer address  = new StringBuffer();
		if(WebUtil.isNotNull(sh.getCustomerAddress1()))
			address.append(sh.getCustomerAddress1());
		if(WebUtil.isNotNull(sh.getCustomerAddress2()))
			address.append(sh.getCustomerAddress2());
		if(WebUtil.isNotNull(sh.getCustomerAddress3()))
			address.append(sh.getCustomerAddress3());
		if(WebUtil.isNotNull(sh.getCustomerAddress4()))
			address.append(sh.getCustomerAddress4());
		if(WebUtil.isNotNull(sh.getCustomerAddress5()))
			address.append(sh.getCustomerAddress5());
		sp.setCustomerAddress1(address.toString());
		sp.setCustomerName(sh.getCustomerName());
		sp.setCustomerTel(sh.getCustomerTel());
		List<ServiceFault> sfList = this.getHibernateTemplate().find(
				"from ServiceFault where ServiceId = ?", sh.getId());
		if (!WebUtil.isNullForList(sfList)) {
			String symptom = "";
			String couse = "";
			String action = "";
			int s = 1, cs = 1, a = 1;
			for (ServiceFault sf : sfList) {
				if (sf.getFaultType().equals("SYMPTOM")) {
					symptom += s + "." + sf.getFaultName();
					if (WebUtil.isNotNull(sf.getContent())) {
						symptom += "(" + sf.getContent() + ")";
					}
					symptom += ";";
					s++;
				}
				if (sf.getFaultType().equals("CAUSE")) {
					couse += cs + "." + sf.getFaultName();
					if (WebUtil.isNotNull(sf.getContent())) {
						couse += "(" + sf.getContent() + ")";
					}
					couse += ";";
					cs++;
				}
				if (sf.getFaultType().equals("ACTION")) {
					action += a + "." + sf.getFaultName();
					if (WebUtil.isNotNull(sf.getContent())) {
						action += "(" + sf.getContent() + ")";
					}
					action += ";";
					a++;
				}
				sp.setFaultSymptom(symptom);
				sp.setFaultCause(couse);
				sp.setFaultAction(action);
			}
		}
		List<ServiceItem> siList = this.getHibernateTemplate().find(
				"from ServiceItem where  ItemStatus = 'APPLY' and Qty > 0 and ServiceId = ?", sh.getId());
		if (!WebUtil.isNullForList(siList)) {
			List serviceItemList = new ArrayList();
			int i = 1;
			for (ServiceItem si : siList) {
				if (si.getItemCate().equals("主机")) {
					sp.setChangeMachineNo("");
					sp.setChangeMachineType("");
				} else {
					Map item = new HashMap();
					item.put("index", "" + i);
					item.put("itemName", si.getItemName());
					item.put("itemCate", si.getItemCate());
					item.put("itemNo", si.getItemNo());
					item.put("qty", "" + si.getQty());
					serviceItemList.add(item);
					i++;
				}
			}
			JRDataSource serviceItemJR = new JRBeanCollectionDataSource(
					serviceItemList);
			sp.setServiceItemJR(serviceItemJR);
		}
		if (sh.getServiceStatus().equals("REPAIR_COMPLETE")) {
			if (sh.getServiceType().equals("ON_CHANGE")) {
				sp.setServiceResult("换货");
			} else {
				sp.setServiceResult("修复");
			}
		} else if (sh.getServiceStatus().equals("CANCEL")) {
			sp.setServiceResult("已取消");
		} else {
			sp.setServiceResult("修理中");
		}

		sp.setPartAmt(WebUtil
				.round(
						new BigDecimal((WebUtil.round(sh.getPartsAmt())
								.doubleValue() + WebUtil.round(
								sh.getConsumablesAmt()).doubleValue())))
				.toString());
		sp.setHomeAmt(WebUtil.round(sh.getHomeAmt()).toString());
		sp.setOtherAmt(WebUtil.round(sh.getOtherAmt()).toString());
		sp.setTotalAmt(WebUtil
				.round(
						new BigDecimal(
								(WebUtil.round(sh.getPartsAmt()).doubleValue()
										+ WebUtil.round(sh.getConsumablesAmt())
												.doubleValue()
										+ WebUtil.round(sh.getHomeAmt())
												.doubleValue() + WebUtil.round(
										sh.getOtherAmt()).doubleValue())))
				.toString());
		sp.setMemo(sh.getMemo());
		sp.setFixPeople(sh.getFixPeople());

		result.put("ServiceOrderPrintBean", sp);
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map serviceReturnPrintInfoByServiceId(Map param) {
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
			result.put("Message", "无权限操作");
			return result;
		}
		String serviceId = (String) param.get("ServiceId");
		StringBuffer hql = new StringBuffer();
		hql
				.append("from ServiceHead sh,Company c,Machine m,MachineType mt where sh.CompanyId = c.id and sh.MachineNo = m.MachineNo and m.MachineTypeId = mt.id and sh.id = ?");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and sh.CompanyId in (" + companyIds + ")");
		List<Object[]> shList = this.getHibernateTemplate().find(
				hql.toString(), new Integer(serviceId));
		if (WebUtil.isNullForList(shList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "维修单没找到");
			return result;
		}
		List<ServiceApply> saList = this
				.getHibernateTemplate()
				.find(
						"from ServiceApply where ServiceId = ? and ServiceApplyType = 'MACHINE'",
						new Integer(serviceId));
		if (WebUtil.isNullForList(saList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "维修单申请没找到");
			return result;
		}
		Object[] obj = shList.get(0);
		ServiceHead sh = (ServiceHead) obj[0];
		Company cc = (Company) obj[1];
		Machine m = (Machine) obj[2];
		MachineType mt = (MachineType) obj[3];
		ServiceApply sa = saList.get(0);
		ServiceReturnPrintBean sr = new ServiceReturnPrintBean();
		sr.setPpsNo(m.getPpsNo());
		if (sa.getServiceApplyAuditedDate() != null)
			sr.setApplyDate(WebUtil.formatDateString(sa
					.getServiceApplyAuditedDate(), "yyyy-MM-dd"));
		sr.setBlackWhiteNumber(sh.getBlackWhiteNumber());
		sr.setCompanyAddress(cc.getAddress());
		sr.setCompanyTel(cc.getPhone());
		sr.setCustomerCompany(cc.getCompanyName());
		sr.setCustomerName(m.getCustomerName());
		if (WebUtil.isNotNull(m.getInvoiceDate()))
			sr.setInvoiceDate(WebUtil.formatDateString(m.getInvoiceDate(),
					"yyyy-MM-dd"));
		result.put("ServiceReturnPrintBean", sr);
		result.put("Flag", "SUCCESS");
		return result;
	}

	public Map serviceReturnPrintInfo(Map param) {
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
			result.put("Message", "无权限操作");
			return result;
		}
		String serviceApplyId = (String) param.get("ServiceApplyId");
		StringBuffer hql = new StringBuffer();
		hql
				.append("from ServiceHead sh,ServiceApply sa,Company c,Machine m,MachineType mt where sh.id = sa.ServiceId and sh.CompanyId = c.id and sh.MachineNo = m.MachineNo and m.MachineTypeId = mt.id and sa.id = ?");
		String companyIds = getCompanyByUser(ul);
		if (companyIds != null)
			hql.append(" and sh.CompanyId in (" + companyIds + ")");
		List<Object[]> shList = this.getHibernateTemplate().find(
				hql.toString(), new Integer(serviceApplyId));
		if (WebUtil.isNullForList(shList)) {
			result.put("Flag", "ERROR");
			result.put("Message", "维修单相关信息没找到");
			return result;
		}
		Object[] obj = shList.get(0);
		ServiceHead sh = (ServiceHead) obj[0];
		ServiceApply sa = (ServiceApply) obj[1];
		Company cc = (Company) obj[2];
		Machine m = (Machine) obj[3];
		MachineType mt = (MachineType) obj[4];
		ServiceReturnPrintBean sr = new ServiceReturnPrintBean();
		sr.setPpsNo(m.getPpsNo());
		if (sa.getServiceApplyAuditedDate() != null)
			sr.setApplyDate(WebUtil.formatDateString(sa
					.getServiceApplyAuditedDate(), "yyyy-MM-dd"));
		sr.setBlackWhiteNumber(sh.getBlackWhiteNumber());
		sr.setCompanyAddress(cc.getAddress());
		sr.setCompanyTel(cc.getPhone());
		sr.setCustomerCompany(sh.getCustomerCompany());
		sr.setCustomerName(m.getCustomerName());
		if (WebUtil.isNotNull(m.getInvoiceDate()))
			sr.setInvoiceDate(WebUtil.formatDateString(m.getInvoiceDate(),
					"yyyy-MM-dd"));
		result.put("ServiceReturnPrintBean", sr);
		result.put("Flag", "SUCCESS");
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
}
