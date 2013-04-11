package com.sunmw.web.bean.base.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunmw.web.bean.base.BaseServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.MachineCat;
import com.sunmw.web.entity.Unit;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class BaseServicesImpl extends HibernateDaoSupport implements
		BaseServices {
	
	public List getUnitList(String unitType)
	{
		List l = this.getHibernateTemplate().find("from Unit where UnitType = ? order by DispIndex",unitType);
		return l;
	}
	
	public List getTreeUnit(String unitType,String parentNo)
	{
		List<Unit> ul = this.getHibernateTemplate().find("from Unit where UnitType = ? and ParentUnitNo = ? order by DispIndex",new Object[]{unitType,parentNo});
		return ul;
	}
	
	public Map userLoginMessage(UserLogin ul,Company c)
	{
		Map result = new HashMap();
		if(c==null||c.getCategory()==null)
			return result;
		if(c.getCategory().equals("SHOP"))
		{
			//未申请的维修单
			List l1 = this.getHibernateTemplate().find("select distinct ServiceNo from ServiceHead where CompanyId = ? and ServiceStatus = 'REPAIRING' and ApplyPartStatus = 'NO_APPLY' and ApplyMachineStatus = 'NO_APPLY'",c.getId());
			if(WebUtil.isNullForList(l1))
			{
				result.put("NO_APPLY", 0);
			}
			else
			{
				result.put("NO_APPLY", l1.size());
				result.put("NoApplyList", l1);
			}
			//被退回的维修申请单
			List l2 = this.getHibernateTemplate().find("select distinct ServiceNo from ServiceApply where CompanyId = ? and Status = 'RE_APPLY'",c.getId());
			if(WebUtil.isNullForList(l2))
			{
				result.put("RE_APPLY", 0);
			}
			else
			{
				result.put("RE_APPLY", l2.size());
				result.put("ReApplyList", l2);
			}
		}else if(c.getCategory().equals("CC"))
		{
			String companyIds = getCompanyByUser(ul);
			//未回访的维修单
			String hql= "select distinct ServiceNo from ServiceHead sh where sh.ServiceStatus = 'REPAIR_COMPLETE' and sh.VisitStatus = 'NO_VISIT' and sh.ApplyRateStatus = 'NO_INVOICE'";
			if(companyIds!=null)
				hql = hql + "and sh.CompanyId in (" + companyIds + ")";
			List l = this.getHibernateTemplate().find(hql);
			if(WebUtil.isNullForList(l))
			{
				result.put("NO_VISIT", 0);
			}
			else
			{
				result.put("NO_VISIT", l.size());
				result.put("NoVisitList", l);
			}
		}else if(c.getCategory().equals("RCN"))
		{
			String companyIds = getCompanyByUser(ul);
			//待审核
			String hql1 = "select distinct ServiceNo from ServiceApply  where Status = 'IN_APPLY'";
			if(companyIds!=null)
				hql1 = hql1 + " and CompanyId in (" + companyIds + ")";
			List l1 = this.getHibernateTemplate().find(hql1);
			if(WebUtil.isNullForList(l1))
			{
				result.put("IN_APPLY", 0);
			}
			else
			{
				result.put("IN_APPLY", l1.size());
				result.put("InApplyList", l1);
			}
			//未发货
			String hql2 = "select distinct ServiceNo,Department from ServiceDelivery  where Status = 'WAIT_DELIVERY'";
			if(companyIds!=null)
				hql2 = "select distinct ServiceNo,Department from ServiceDelivery  where Status = 'WAIT_DELIVERY' and CompanyId in (" + companyIds + ")";
			List<Object[]> l2 = this.getHibernateTemplate().find(hql2);
			if(WebUtil.isNullForList(l2))
			{
				result.put("SCM", 0);
				result.put("CSPC", 0);
			}
			else
			{
				int sc=0,cc = 0;
				List scList = new ArrayList();
				List ccList = new ArrayList();
				for(Object[] o:l2)
				{
					if(o[1].equals("SCM"))
					{
						sc++;
						scList.add(o[0]);
					}
					else
					{
						cc++;
						ccList.add(o[0]);
					}
				}
				result.put("SCM", sc);
				result.put("CSPC", cc);
				result.put("ScmList", scList);
				result.put("CspcList", ccList);
			}
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

	public List getMachineCatList() {
		List<MachineCat> l = this.getHibernateTemplate().find("from MachineCat order by Sort");
		return l;
	}

}
