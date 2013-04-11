package com.sunmw.web.bean.area.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.sunmw.web.bean.area.AreaServices;
import com.sunmw.web.entity.Area;
import com.sunmw.web.entity.AreaProvinceRef;
import com.sunmw.web.entity.Province;
import com.sunmw.web.entity.SecurityGroup;
import com.sunmw.web.entity.SecurityGroupPermission;
import com.sunmw.web.entity.SecurityGroupPermissionPK;
import com.sunmw.web.util.WebUtil;

public class AreaServicesImpl extends HibernateDaoSupport implements
		AreaServices {

	public List<Area> areaList() {
		List<Area> l = this.getHibernateTemplate().find("from Area");
		return l;
	}

	public Map searchArea(Map param, int currentPage, int pageRow) {
		StringBuffer hql = new StringBuffer();
		hql.append("from Area");
		StringBuffer con = new StringBuffer();
		List conList = new ArrayList();
		if (!WebUtil.isNull(param.get("areaCd"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" id = :Condition" + conList.size());
			conList.add(param.get("areaCd"));
		}
		if (!WebUtil.isNull(param.get("areaName"))) {
			if (con.length() > 0)
				con.append(" and ");
			con.append(" AreaName like :Condition" + conList.size());
			conList.add("%" + param.get("areaName") + "%");
		}
		if (con.length() > 0)
			hql.append(" where " + con.toString());
		Session session = this.getSession();
		Map result = null;
		try {
			Query q1 = session.createQuery("select count(*) " + hql.toString());
			for (int i = 0; i < conList.size(); i++) {
				q1.setParameter("Condition" + i, conList.get(i));
			}
			List<Long> countList = q1.list();
			int count = countList.get(0).intValue();
			Query q = session.createQuery(hql.toString());
			for (int i = 0; i < conList.size(); i++) {
				q.setParameter("Condition" + i, conList.get(i));
			}
			if (pageRow > 0) {
				q.setFirstResult((currentPage - 1) * pageRow);
				q.setMaxResults(pageRow);
			}
			result = new HashMap();
			List<Area> l = q.list();
			List<Map> r = new ArrayList();
			for (Area s : l) {
				Map m = new HashMap();
				m.put("AreaCd", s.getId());
				m.put("AreaName", s.getAreaName());
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

	public List<Province> provinceList() {
		List<Province> l = this.getHibernateTemplate().find(
				"from Province order by id");
		return l;
	}

	public List<Province> provinceList(String areaCd) {
		List<Province> l = this
				.getHibernateTemplate()
				.find(
						"from Province where id not in (select ProvinceCd from AreaProvinceRef where AreaCd <> ?) order by id",areaCd);
		return l;
	}

	public List<Map> areaProvinceList(String areaCd) {
		List<Object[]> l = this
				.getHibernateTemplate()
				.find(
						"from AreaProvinceRef apr,Province p where apr.ProvinceCd = p.id and apr.AreaCd = ?",
						areaCd);
		if (l == null)
			return null;
		List<Map> r = new ArrayList();
		for (Object[] o : l) {
			AreaProvinceRef apr = (AreaProvinceRef) o[0];
			Province p = (Province) o[1];
			Map m = new HashMap();
			m.put("areaCd", apr.getAreaCd());
			m.put("provinceCd", p.getId());
			m.put("provinceName", p.getProvinceName());
			r.add(m);
		}
		return r;
	}

	public String saveArea(String areaCd, String areaName) {
		List<Area> l = this.getHibernateTemplate().find(
				"from Area where id = ?", areaCd);
		Area a = null;
		if (l != null && l.size() > 0)
			a = l.get(0);
		if (a == null) {
			a = new Area();
			a.setId(areaCd);
			a.setAreaName(areaName);
			a.setCtime(new Date());
			this.getHibernateTemplate().save(a);
		} else {
			a.setAreaName(areaName);
			a.setMtime(new Date());
			this.getHibernateTemplate().update(a);
		}

		return "success";
	}

	public String saveAreaProvince(String areaCd, String provinceIds) {
		Session session = this.getSession();
		// String g = "'"+permissionIds.replaceAll(",", "','")+"'";
		try {
			Query q = session
					.createQuery("from AreaProvinceRef where AreaCd = :AreaCd");
			q.setParameter("AreaCd", areaCd);
			List<AreaProvinceRef> l = q.list();
			Map<String, AreaProvinceRef> m = new HashMap();
			if (l != null) {
				for (AreaProvinceRef s : l) {
					m.put(s.getProvinceCd(), s);
				}
			}
			String[] gs = provinceIds.split(",");
			Date date = new Date();
			Transaction tx = session.beginTransaction();
			for (String s : gs) {
				if (m.get(s) != null) {
					m.remove(s);
					continue;
				}
				AreaProvinceRef apr = new AreaProvinceRef();
				apr.setAreaCd(areaCd);
				apr.setProvinceCd(s);
				session.save(apr);
			}
			if (m.size() > 0) {
				Iterator<String> iter = m.keySet().iterator();
				while (iter.hasNext()) {
					session.delete(m.get(iter.next()));
				}
			}
			tx.commit();
		} catch (HibernateException e) {
			logger.error(e.getMessage());
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return "success";
	}

	public String deleteArea(String areaCd) {
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			Query q1 = session
					.createQuery("delete AreaProvinceRef where AreaCd = :AreaCd");
			Query q2 = session.createQuery("delete Area where id = :AreaCd");
			Query q3 = session
					.createQuery("delete SecurityGroupArea where id.AreaCd = :AreaCd");
			q1.setParameter("AreaCd", areaCd);
			q2.setParameter("AreaCd", areaCd);
			q3.setParameter("AreaCd", areaCd);
			q1.executeUpdate();
			q2.executeUpdate();
			q3.executeUpdate();
			tx.commit();
		} catch (HibernateException e) {
			logger.error(e.getMessage());
		} catch (RuntimeException e) {
			logger.error(e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return "success";
	}

}
