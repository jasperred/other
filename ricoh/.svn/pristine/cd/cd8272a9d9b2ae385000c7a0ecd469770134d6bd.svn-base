package com.sunmw.web.bean.machine.impl;

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

import com.sunmw.web.bean.machine.MachineImportServices;
import com.sunmw.web.entity.Company;
import com.sunmw.web.entity.CompanyMachineTypeRef;
import com.sunmw.web.entity.CompanyMachineTypeRefPK;
import com.sunmw.web.entity.Machine;
import com.sunmw.web.entity.MachineType;
import com.sunmw.web.entity.TempCompanyMachineTypeRef;
import com.sunmw.web.entity.TempExceed;
import com.sunmw.web.entity.TempServicePayment;
import com.sunmw.web.entity.UserLogin;
import com.sunmw.web.util.WebUtil;

public class MachineImportServicesImpl extends HibernateDaoSupport implements
		MachineImportServices {

	static Logger logger = Logger.getLogger(MachineImportServicesImpl.class);

	public List<String> importTempExceed(Map param) {
		List<String[]> exceedList = (List) param.get("ExceedList");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<String> result = new ArrayList<String>();
		result.add("EXCEED导入临时表,共" + exceedList.size() + "条数据");
		logger.info("EXCEED导入临时表,共" + exceedList.size() + "条数据");
		int i = 1;// 记录第几条
		int q = 0;// 记录成功条数
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			boolean b = false;// 判断内容是否缺失
			Date date = new Date();
			// 导入前删除以前成功导入的记录
			session.createQuery("delete TempExceed where Flag = 'OLD'")
					.executeUpdate();
			for (String[] str : exceedList) {
				i++;// 从第2条开始,表头算第1条
				if (str.length != 8) {
					result.add("第" + i + "条文件格式错误");
					logger.error("第" + i + "条文件格式错误");
					break;
				}
				String s = "第" + i + "条记录:";
				if (WebUtil.isNull(str[1]))// 出库日期
				{
					s += "出库日期为空";
					b = true;
				}
				if (WebUtil.toDateForString(str[1], "yyyy-MM-dd HH:mm:ss") == null)// 出库日期
				{
					s += "出库日期格式错误";
					b = true;
				}
				if (WebUtil.isNull(str[2]))// 外部订单号(PPS)
				{
					s += "外部订单号为空";
					b = true;
				}
				if (WebUtil.isNull(str[5]))// 商品编码
				{
					s += "商品编码为空";
					b = true;
				}
				if (WebUtil.isNull(str[6]))// 商品名称
				{
					s += "商品名称为空";
					b = true;
				}
				if (WebUtil.isNull(str[7]))// 机器序列号
				{
					s += "机器序列号为空";
					b = true;
				}
				if (b)// 有错误不导入
				{
					result.add(s);
					logger.error(s);
					break;
				}
				TempExceed te = new TempExceed();
				te.setExceedDbid(str[0].trim());
				te.setEditDate(WebUtil.toDateForString(str[1].trim(),
						"yyyy-MM-dd HH:mm:ss"));
				te.setExternOrderKey(str[2].trim());
				te.setCustomerNo(str[3].trim());
				te.setCustomerName(str[4].trim());
				te.setItemNo(str[5].trim());
				te.setItemDescription(str[6].trim());
				te.setSerialNo(str[7].trim());
				te.setFlag("NEW");
				te.setWriterTime(date);
				te.setImportUser(ul.getUserName());
				session.save(te);
				q++;
			}

			tx.commit();
			result.add("EXCEED导入临时表,导入成功" + q + "条数据");
			logger.info("EXCEED导入临时表,导入成功" + q + "条数据");
		} catch (HibernateException e) {
			result.add("EXCEED导入临时表失败,错误信息:" + e.getMessage());
			logger.error("EXCEED导入临时表失败,错误信息:" + e.getMessage());
		} catch (RuntimeException e) {
			result.add("EXCEED导入临时表失败,错误信息:" + e.getMessage());
			logger.error("EXCEED导入临时表失败,错误信息:" + e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public List<String> importExceed() {
		List<String> result = new ArrayList<String>();
		Session session = this.getSession();
		try {

			List<Long> ll = session.createQuery(
					"select count(*) from TempExceed where Flag = 'NEW'").list();
			int count = ll.get(0).intValue();
			result.add("EXCEED从临时表导入,共" + count + "条数据");
			logger.info("EXCEED从临时表导入,共" + count + "条数据");
			Date date = new Date();
			int q = 0;
			int current = 1;
			int row = 1000;
			while(true)
			{

				Query q2 = session.createQuery(
				"from TempExceed where Flag = 'NEW'");
				q2.setFirstResult((current - 1) * row);
				q2.setMaxResults(row);
				List<TempExceed> l = q2.list();
				current++;
				if(WebUtil.isNullForList(l))
					break;
				for (TempExceed te : l) {

					Transaction tx = session.beginTransaction();
					String serialNo = te.getSerialNo();
					String itemNo = te.getItemNo();
					String itemDesc = te.getItemDescription();
					// 此处如果机型不存在如何处理,是新增还是报错
					MachineType mt = null;
					List<MachineType> mtList = session.createQuery(
							"from MachineType where MachineCd = '" + itemNo + "'")
							.list();
					if (WebUtil.isNullForList(mtList)) {
						result.add("EXCEED导入失败,机号[" + serialNo + "],机型不存在");
						logger.error("EXCEED导入失败,机号[" + serialNo + "],机型不存在");
						tx.rollback();
						continue;
					}
					mt = mtList.get(0);
					if (mt == null || mt.getId() == null) {
						result.add("EXCEED导入失败,机号[" + serialNo + "],机型不存在");
						logger.error("EXCEED导入失败,机号[" + serialNo + "],机型不存在");
						tx.rollback();
						continue;
					}
					List<Machine> mList = session.createQuery(
							"from Machine where MachineNo = '" + serialNo + "'")
							.list();
					Machine m = null;
					if (WebUtil.isNullForList(mList)) {
						m = new Machine();
						m.setCtime(date);
						m.setCuser(te.getImportUser());
						m.setStatus("NORMAL");
						m.setMachineNo(serialNo);
					} else
						m = mList.get(0);
					//如果新导入的机号是换货状态，并且出库日期大于最后维修日期，那么状态改为正常使用中
					if(m.getId()!=null&&m.getStatus().equals("CHANGE"))
					{
						if(m.getLastTime()==null||(te.getEditDate()!=null&&te.getEditDate().getTime()>m.getLastTime().getTime()))
						{
							m.setStatus("NORMAL");
							//清空最后维修日期和特约店
							m.setInvoiceDate(null);
							m.setLastCompanyId(null);
							m.setLastTime(null);
						}
					}
					m.setMachineTypeId(mt.getId());
					m.setMachineCd(te.getItemNo());
					m.setOutDate(te.getEditDate());
					m.setPpsNo(te.getExternOrderKey());
					m.setCustomerNo(te.getCustomerNo());
					m.setCustomerName(te.getCustomerName());
					m.setOrigin("IMPORT");// 来源-导入
					if (m.getId() == null)
						session.save(m);
					else
						session.update(m);
					// 更新临时表
					te.setReaderTime(date);
					te.setFlag("OLD");
					session.update(te);

					tx.commit();
					if(q%100==0)
					{
						System.gc();
						System.gc();
					}
					q++;
				}
			}

			result.add("EXCEED从临时表导入,导入成功" + q + "条数据");
			logger.info("EXCEED从临时表导入,导入成功" + q + "条数据");
		} catch (HibernateException e) {
			result.add("EXCEED导入临时表失败,错误信息:" + e.getMessage());
			logger.error("EXCEED导入临时表失败,错误信息:" + e.getMessage());
		} catch (RuntimeException e) {
			result.add("EXCEED导入临时表失败,错误信息:" + e.getMessage());
			logger.error("EXCEED导入临时表失败,错误信息:" + e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public List<String> importTempServiceRate(Map param) {
		List<String[]> serviceRateList = (List) param.get("ServiceRateList");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<String> result = new ArrayList<String>();
		result.add("服务费导入临时表,共" + serviceRateList.size() + "条数据");
		logger.info("服务费导入临时表,共" + serviceRateList.size() + "条数据");
		int i = 1;// 记录第几条
		int q = 0;// 记录成功条数
		Session session = this.getSession();
		Transaction tx = session.beginTransaction();
		try {
			boolean b = false;// 判断内容是否缺失
			Date date = new Date();
			// 导入前删除以前成功导入的记录
			session.createQuery("delete TempServicePayment").executeUpdate();

			for (String[] str : serviceRateList) {
				i++;// 从第2条开始,表头算第1条
				if (str.length != 7) {
					result.add("第" + i + "条文件格式错误");
					logger.error("第" + i + "条文件格式错误");
					break;
				}
				String s = "第" + i + "条记录:";
				if (WebUtil.isNull(str[0]))// 机号
				{
					s += "机号为空;";
					b = true;
				}
				if (WebUtil.isNull(str[1]))// 保修期起始日
				{
					s += "保修期起始日为空;";
					b = true;
				}
				if (WebUtil.toDateForString(str[1], "yyyy-MM-dd") == null)// 保修期起始日
				{
					s += "保修期起始日格式错误;";
					b = true;
				}
				if (WebUtil.isNull(str[2]))// 服务费已支付
				{
					s += "服务费已支付为空;";
					b = true;
				}
				if (WebUtil.isNull(str[3]))// 服务费支付公司
				{
					s += "服务费支付公司为空;";
					b = true;
				}
				if (WebUtil.isNull(str[4]))// 服务费支付公司代码
				{
					s += "服务费支付公司代码为空;";
					b = true;
				}
				if (WebUtil.isNull(str[5]))// 机服务费支付日期
				{
					s += "服务费支付日期为空;";
					b = true;
				}
				if (WebUtil.toDateForString(str[5], "yyyy-MM-dd") == null)// 机服务费支付日期
				{
					s += "服务费支付日期格式错误;";
					b = true;
				}
				if (WebUtil.isNull(str[6]))// 服务费支付金额
				{
					s += "服务费支付金额为空;";
					b = true;
				}
				if (b)// 有错误不导入
				{
					result.add(s);
					logger.error(s);
					break;
				}
				TempServicePayment tsp = new TempServicePayment();
				tsp.setMachineNo(str[0].trim());
				tsp.setServiceFromDate(WebUtil.toDateForString(str[1].trim(),
						"yyyy-MM-dd"));
				tsp.setPaymentStatus(str[2].trim());
				tsp.setPaymentCompany(str[3].trim());
				tsp.setPaymentCompanyCd(str[4].trim());
				tsp.setPaymentDate(WebUtil.toDateForString(str[5].trim(),
						"yyyy-MM-dd"));
				tsp.setPaymentAmt(new BigDecimal(str[6].trim()));
				tsp.setFlag("NEW");
				tsp.setWriterTime(date);
				tsp.setImportUser(ul.getUserName());
				session.save(tsp);
				q++;
			}

			tx.commit();
			result.add("服务费导入临时表,导入成功" + q + "条数据");
			logger.info("服务费导入临时表,导入成功" + q + "条数据");
		} catch (HibernateException e) {
			result.add("服务费导入临时表失败,错误信息:" + e.getMessage());
			logger.error("服务费导入临时表失败,错误信息:" + e.getMessage());
			tx.rollback();
		} catch (RuntimeException e) {
			result.add("服务费导入临时表失败,错误信息:" + e.getMessage());
			logger.error("服务费导入临时表失败,错误信息:" + e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public List<String> importServiceRate() {
		List<String> result = new ArrayList<String>();
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			List<TempServicePayment> l = session.createQuery(
					"from TempServicePayment where Flag = 'NEW'").list();
			result.add("服务费从临时表导入,共" + l.size() + "条数据");
			logger.info("服务费从临时表导入,共" + l.size() + "条数据");
			Date date = new Date();
			int q = 0;
			for (TempServicePayment tsp : l) {
				String machineNo = tsp.getMachineNo();

				List<Machine> mList = session.createQuery(
						"from Machine where MachineNo = '" + machineNo + "'")
						.list();
				if (WebUtil.isNullForList(mList)) {
					result.add("服务费导入失败,机号管理表中无法找到机号[" + machineNo + "]信息");
					logger.error("服务费导入失败,机号管理表中无法找到机号[" + machineNo + "]信息");
					continue;
				}
				Machine m = mList.get(0);
				m.setServiceFromDate(tsp.getServiceFromDate());
				m.setPaymentStatus(tsp.getPaymentStatus());
				m.setPaymentAmt(tsp.getPaymentAmt());
				m.setPaymentCompany(tsp.getPaymentCompany());
				m.setPaymentCompanyCd(tsp.getPaymentCompanyCd());
				m.setPaymentDate(tsp.getPaymentDate());
				m.setMuser(tsp.getImportUser());
				session.update(m);
				// 更新临时表
				tsp.setReaderTime(date);
				tsp.setFlag("OLD");
				session.update(tsp);
				q++;
			}

			tx.commit();
			result.add("服务费从临时表导入,导入成功" + q + "条数据");
			logger.info("服务费从临时表导入,导入成功" + q + "条数据");
		} catch (HibernateException e) {
			result.add("服务费导入临时表失败,错误信息:" + e.getMessage());
			logger.error("服务费导入临时表失败,错误信息:" + e.getMessage());
		} catch (RuntimeException e) {
			result.add("服务费导入临时表失败,错误信息:" + e.getMessage());
			logger.error("服务费导入临时表失败,错误信息:" + e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public List<String> importTempCompanyMachineTypeRef(Map param) {
		List<String[]> cmtrList = (List) param.get("CmtrList");
		UserLogin ul = (UserLogin) param.get("UserLogin");
		List<String> result = new ArrayList<String>();
		result.add("维修能力导入临时表,共" + cmtrList.size() + "条数据");
		logger.info("维修能力导入临时表,共" + cmtrList.size() + "条数据");
		int i = 1;// 记录第几条
		int q = 0;// 记录成功条数
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			boolean b = false;// 判断内容是否缺失
			Date date = new Date();
			// 导入前删除临时表
			session.createQuery("delete TempCompanyMachineTypeRef")
					.executeUpdate();
			tx.commit();
			tx.begin();
			for (String[] str : cmtrList) {
				i++;// 从第2条开始,表头算第1条
				if (str.length != 5) {
					result.add("第" + i + "条文件格式错误");
					logger.error("第" + i + "条文件格式错误");
					break;
				}
				String s = "第" + i + "条记录:";
				// if(WebUtil.isNull(str[0]))//特约维修店可服务商品表ID
				// {
				// s+="特约维修店可服务商品表ID为空;";
				// b=true;
				// }
				if (WebUtil.isNull(str[1]))// 系统用户公司ID
				{
					s += "系统用户公司ID为空;";
					b = true;
				}
				// if(WebUtil.isNull(str[2]))//系统用户公司名称
				// {
				// s+="系统用户公司名称为空;";
				// b=true;
				// }
				if (WebUtil.isNull(str[3]))// 能维修机型商品编号
				{
					s += "能维修机型商品编号为空;";
					b = true;
				}
				if (WebUtil.isNull(str[4]))// 能维修机型
				{
					s += "能维修机型为空;";
					b = true;
				}
				// List<MachineType> mtList =
				// session.createQuery("from MachineType where Status = 'NORMAL' and MachineCd = '"+str[3].trim()+"'").list();
				// if(WebUtil.isNullForList(mtList))
				// {
				// result.add("维修能力导入失败,公司["+str[1]+","+str[2]+"]维修机型表中无法找到商品编号["+str[3]+"]信息");
				// logger.info("维修能力导入失败,公司["+str[1]+","+str[2]+"]维修机型表中无法找到商品编号["+str[3]+"]信息");
				// b=true;
				// }
				if (b)// 有错误不导入
				{
					result.add(s);
					logger.error(s);
					break;
				}
				TempCompanyMachineTypeRef tcmtr = new TempCompanyMachineTypeRef();
				tcmtr.setTempNo(str[0].trim());
				tcmtr.setCompanyNo(str[1].trim());
				tcmtr.setCompanyName(str[2].trim());
				tcmtr.setMachineCd(str[3].trim());
				tcmtr.setMachineType(str[4].trim());
				tcmtr.setFlag("NEW");
				tcmtr.setWriterTime(date);
				tcmtr.setImportUser(ul.getUserName());
				session.save(tcmtr);
				q++;
			}

			tx.commit();
			result.add("维修能力导入临时表,导入成功" + q + "条数据");
			logger.info("维修能力导入临时表,导入成功" + q + "条数据");
		} catch (HibernateException e) {
			result.add("维修能力导入临时表失败,错误信息:" + e.getMessage());
			logger.error("维修能力导入临时表失败,错误信息:" + e.getMessage());
		} catch (RuntimeException e) {
			result.add("服务费导入临时表失败,错误信息:" + e.getMessage());
			logger.error("服务费导入临时表失败,错误信息:" + e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

	public List<String> importCompanyMachineTypeRef() {
		List<String> result = new ArrayList<String>();
		Session session = this.getSession();
		try {
			Transaction tx = session.beginTransaction();
			List<TempCompanyMachineTypeRef> l = session.createQuery(
					"from TempCompanyMachineTypeRef where Flag = 'NEW'").list();
			result.add("维修能力从临时表导入,共" + l.size() + "条数据");
			logger.info("维修能力从临时表导入,共" + l.size() + "条数据");
			Date date = new Date();
			int q = 0;
			StringBuffer cnos = new StringBuffer();
			for (TempCompanyMachineTypeRef tcmtr : l) {
				if (cnos.length() > 0)
					cnos.append(",");
				cnos.append("'" + tcmtr.getCompanyNo() + "'");
			}
			List<Company> cList = session.createQuery(
					"from Company where CompanyNo in (" + cnos
							+ ") and Status = 'NORMAL'").list();
			if (WebUtil.isNullForList(cList)) {
				result.add("维修能力导入临时表失败,错误信息:公司信息未找到");
				logger.error("维修能力导入临时表失败,错误信息:公司信息未找到");
				return result;
			}
			StringBuffer cids = new StringBuffer();
			Map<String, Integer> cMap = new HashMap();
			for (Company c : cList) {
				cMap.put(c.getCompanyNo(), c.getId());
				if (cids.length() > 0)
					cids.append(",");
				cids.append(c.getId());
			}
			// 先删除已存在数据
			// session.createQuery("delete from CompanyMachineTypeRef where id.CompanyId in ("+cids.toString()+")").executeUpdate();
			// 记录重复数据
			Map<String, String> mm = new HashMap<String, String>();
			int i = 0;
			for (TempCompanyMachineTypeRef tcmtr : l) {
				i++;
				if (mm.get(tcmtr.getCompanyNo() + tcmtr.getMachineCd()) == null) {
					mm.put(tcmtr.getCompanyNo() + tcmtr.getMachineCd(), tcmtr
							.getCompanyNo()
							+ tcmtr.getMachineCd());
				} else {
					result.add("维修能力导入失败,第" + i + "条数据重复");
					logger.info("维修能力导入失败,第" + i + "条数据重复");
					continue;
				}
				if (cMap.get(tcmtr.getCompanyNo()) == null) {
					result.add("维修能力导入失败,公司信息表中无法找到公司ID["
							+ tcmtr.getCompanyNo() + "]信息,第" + i + "条数据");
					logger.info("维修能力导入失败,公司信息表中无法找到公司ID["
							+ tcmtr.getCompanyNo() + "]信息第" + i + "条数据");
					continue;
				}
				MachineType mt = null;
				List<MachineType> mtList = session.createQuery(
						"from MachineType where Status = 'NORMAL' and MachineCd = '"
								+ tcmtr.getMachineCd() + "'").list();
				if (WebUtil.isNullForList(mtList)) {
					result.add("维修能力导入失败,维修机型表中无法找到商品编号["
							+ tcmtr.getMachineCd() + "]信息,第" + i + "条数据");
					logger.info("维修能力导入失败,维修机型表中无法找到商品编号["
							+ tcmtr.getMachineCd() + "]信息,第" + i + "条数据");
					continue;
				}
				mt = mtList.get(0);
				CompanyMachineTypeRef cm = new CompanyMachineTypeRef();
				CompanyMachineTypeRefPK cmpk = new CompanyMachineTypeRefPK();
				cmpk.setCompanyId(cMap.get(tcmtr.getCompanyNo()));
				cmpk.setMachineTypeId(mt.getId());
				cm.setId(cmpk);
				cm.setCtime(date);
				cm.setCuser(tcmtr.getImportUser());
				cm.setMachineCd(tcmtr.getMachineCd());
				session.merge(cm);
				// 更新临时表
				tcmtr.setReaderTime(date);
				tcmtr.setFlag("OLD");
				session.update(tcmtr);
				q++;

			}

			tx.commit();
			result.add("维修能力从临时表导入,导入成功" + q + "条数据");
			logger.info("维修能力从临时表导入,导入成功" + q + "条数据");
		} catch (HibernateException e) {
			result.add("维修能力导入临时表失败,错误信息:" + e.getMessage());
			logger.error("维修能力导入临时表失败,错误信息:" + e.getMessage());
		} catch (RuntimeException e) {
			result.add("服务费导入临时表失败,错误信息:" + e.getMessage());
			logger.error("服务费导入临时表失败,错误信息:" + e.getMessage());
		} finally {
			if (session != null && session.isOpen())
				session.close();
		}
		return result;
	}

}
