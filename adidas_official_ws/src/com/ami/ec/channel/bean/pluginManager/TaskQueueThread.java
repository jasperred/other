package com.ami.ec.channel.bean.pluginManager;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.ami.ec.channel.common.GetBeanServlet;
import com.ami.ec.channel.dao.pluginManager.BatLogMapper;
import com.ami.ec.channel.dao.pluginManager.BatRecordMapper;
import com.ami.ec.channel.dao.pluginManager.ExecTaskMapper;
import com.ami.ec.channel.dao.pluginManager.IfDefineLineMapper;
import com.ami.ec.channel.dao.pluginManager.IfDefineMapper;
import com.ami.ec.channel.dao.pluginManager.TaskDefineMapper;
import com.ami.ec.channel.dao.pluginManager.TaskQueueMapper;
import com.ami.ec.channel.domain.pluginManager.BatLog;
import com.ami.ec.channel.domain.pluginManager.BatRecord;
import com.ami.ec.channel.domain.pluginManager.BatRecordExample;
import com.ami.ec.channel.domain.pluginManager.ExecTask;
import com.ami.ec.channel.domain.pluginManager.IfDefine;
import com.ami.ec.channel.domain.pluginManager.IfDefineLine;
import com.ami.ec.channel.domain.pluginManager.TaskDefine;
import com.ami.ec.channel.domain.pluginManager.TaskQueue;
import com.ami.ec.channel.util.WebUtil;

public class TaskQueueThread extends Thread {
	static Logger logger = Logger.getLogger(TaskQueueThread.class);
	private ExecTaskMapper execTaskMapper;
	private ExecTask execTask;

	public ExecTaskMapper getExecTaskMapper() {
		return execTaskMapper;
	}

	public void setExecTaskMapper(ExecTaskMapper execTaskMapper) {
		this.execTaskMapper = execTaskMapper;
	}

	public ExecTask getExecTask() {
		return execTask;
	}

	public void setExecTask(ExecTask execTask) {
		this.execTask = execTask;
	}

	public void run() {
		logger.info("任务开始执行,接口：" + execTask.getIfName());
		Date d = new Date();
		if (execTask.getEndTime() != null && execTask.getEndTime().before(d))
			return;
		logger.info("1,接口：" + execTask.getIfName());
		IfDefineMapper ifDefineMapper = (IfDefineMapper) GetBeanServlet
				.getBean("ifDefineMapper");
		IfDefineLineMapper ifDefineLineMapper = (IfDefineLineMapper) GetBeanServlet
				.getBean("ifDefineLineMapper");
		TaskDefineMapper taskDefineMapper = (TaskDefineMapper) GetBeanServlet
				.getBean("taskDefineMapper");
		TaskQueueMapper taskQueueMapper = (TaskQueueMapper) GetBeanServlet
				.getBean("taskQueueMapper");
		BatLogMapper batLogMapper = (BatLogMapper) GetBeanServlet
				.getBean("batLogMapper");
		BatRecordMapper batRecordMapper = (BatRecordMapper) GetBeanServlet
				.getBean("batRecordMapper");
		logger.info("1.1,接口：" + execTask.getIfName());
		// 日志插入
		IfDefine ifd = ifDefineMapper.selectByPrimaryKey(execTask.getIfId()
				.intValue());
		int batNoCurrent = ifd.getBatNoCurrent();
		logger.info("1.2,接口：" + execTask.getIfName());
		Map ex = new HashMap();
		ex.put("ifId", execTask.getIfId());
		ex.put("batNoCurrent", batNoCurrent + 1);
		execTaskMapper.updateIfDefineBatNoCurrent(ex);
		logger.info("1.3,接口：" + execTask.getIfName());
		String batNo = execTask.getBatNoPre()
				+ WebUtil.addPrefix("" + batNoCurrent, execTask
						.getBatNoLength(), "0");
		BatRecord br = new BatRecord();
		br.setBatNo(batNo);
		br.setStartTime(d);
		br.setIfId(execTask.getIfId().intValue());
		br.setTaskQueueId(execTask.getTaskQueueId());
		br.setOperateTime(d);
		batRecordMapper.insertSelective(br);
		BatRecordExample bre = new BatRecordExample();
		BatRecordExample.Criteria brc = bre.createCriteria();
		brc.andBatNoEqualTo(batNo);
		List<BatRecord> brl = batRecordMapper.selectByExample(bre);
		BatRecord brcurrent = null;
		if (!WebUtil.isNullForList(brl))
			brcurrent = brl.get(0);
		logger.info("2,接口：" + execTask.getIfName());
		Long batRecordId = 0L;
		if (brcurrent == null) {
			logger.error("日志生成失败");
		} else {
			batRecordId = brcurrent.getBatRecordId();
		}
		BatLog bl = new BatLog();

		bl.setBatRecordId(batRecordId);
		bl.setLogTime(d);
		bl.setLogContent(execTask.getIfName() + "开始执行");
		bl.setIsAbnormal(true);
		batLogMapper.insertSelective(bl);

		// 准备更新任务开始时间
		TaskDefine starttd = new TaskDefine();
		starttd.setTaskId(execTask.getTaskId().intValue());
		starttd.setLastStartTime(d);
		taskDefineMapper.updateByPrimaryKeySelective(starttd);
		logger.info("3,接口：" + execTask.getIfName());
		// 执行类
		String beanName = execTask.getTypeInfo();
		Object obj = null;
		try {
			obj = GetBeanServlet.getBean(beanName);
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		logger.info("4,接口：" + execTask.getIfName());
		if (obj == null) {
			logger.error("找不到配置的类");
			starttd.setLastEndTime(new Date());
			starttd.setIsLastSuccess(0);
			taskDefineMapper.updateByPrimaryKeySelective(starttd);
			// if(brcurrent!=null)
			{
				bl.setBatRecordId(batRecordId);
				bl.setLogTime(new Date());
				bl.setLogContent(execTask.getIfName() + "执行失败，【找不到配置的类】");
				bl.setIsAbnormal(true);
				batLogMapper.insertSelective(bl);
			}
			TaskQueue tq = new TaskQueue();
			tq.setTaskQueueId(execTask.getTaskQueueId());
			tq.setIsDealed(1);
			tq.setDealedTime(new Date());
			taskQueueMapper.updateByPrimaryKeySelective(tq);
			return;
		}
		logger.info("5,接口：" + execTask.getIfName());
		String callMethod = execTask.getCallMethod();
		if (WebUtil.isNull(callMethod)) {
			logger.error("找不到配置的方法");
			starttd.setLastEndTime(new Date());
			starttd.setIsLastSuccess(0);
			taskDefineMapper.updateByPrimaryKeySelective(starttd);
			// if(brcurrent!=null)
			{
				bl.setBatRecordId(batRecordId);
				bl.setLogTime(new Date());
				bl.setLogContent(execTask.getIfName() + "执行失败，【找不到配置的方法】");
				bl.setIsAbnormal(true);
				batLogMapper.insertSelective(bl);
			}
			TaskQueue tq = new TaskQueue();
			tq.setTaskQueueId(execTask.getTaskQueueId());
			tq.setIsDealed(1);
			tq.setDealedTime(new Date());
			taskQueueMapper.updateByPrimaryKeySelective(tq);
			return;
		}
		logger.info("6,接口：" + execTask.getIfName());
		Map param = new HashMap();
		param.put("PjId", execTask.getPjId());
		param.put("StoreId", execTask.getStoreId());
		param.put("LastExecTime", execTask.getLastTime());
		//执行时重新得到一些数据，因为在建立任务时的数据后面会有更新
		IfDefine currentIfDefine = ifDefineMapper.selectByPrimaryKey(execTask.getIfId().intValue());
		if(currentIfDefine!=null)
		{
			param.put("IfTime1", currentIfDefine.getIfTime1());
			param.put("IfTime2", currentIfDefine.getIfTime2());
			param.put("IfTime3", currentIfDefine.getIfTime3());
		}
		else
		{
			param.put("IfTime1", execTask.getIfTime1());
			param.put("IfTime2", execTask.getIfTime2());
			param.put("IfTime3", execTask.getIfTime3());
		}		
		param.put("FtpPath", execTask.getFtpPath());
		param.put("FtpPort", execTask.getFtpPort());
		param.put("FtpPassword", execTask.getFtpPwd());
		param.put("FtpUser", execTask.getFtpUid());
		param.put("FtpHost", execTask.getFtpUrl());
		param.put("FileEncoding", execTask.getFileEncoding());
		Map result = null;
		logger.info("7,接口：" + execTask.getIfName());
		Class c = obj.getClass();
		try {
			Method m = c.getMethod(callMethod, Map.class);
			try {
				result = (Map) m.invoke(obj, param);
			} catch (Exception e) {
				logger.error("错误:"+e.getMessage()+","+e.getCause().getMessage());
			}
		} catch (SecurityException e) {
			logger.error(e.getMessage());
		} catch (NoSuchMethodException e) {
			logger.error(e.getMessage());
		}
		logger.info("8,接口：" + execTask.getIfName());
		// 更新任务结束时间和是否成功

		starttd.setLastEndTime(new Date());
		if (result == null || result.get("Flag") == null
				|| !result.get("Flag").equals("success")) {
			starttd.setIsLastSuccess(0);
			// if(brcurrent!=null)
			{
				bl.setBatRecordId(batRecordId);
				bl.setLogTime(new Date());
				bl.setLogContent(execTask.getIfName() + "执行失败,Message:"
						+ result == null ? "" : (String) result.get("Message"));
				bl.setIsAbnormal(true);
				batLogMapper.insertSelective(bl);
			}
		} else {
			starttd.setIsLastSuccess(1);
			bl.setBatRecordId(batRecordId);
			bl.setLogTime(new Date());
			String lc = execTask.getIfName() + "执行成功,Message:" + (result == null ? "" : (String) result.get("Message"));
			bl.setLogContent(lc);
			bl.setIsAbnormal(true);
			batLogMapper.insertSelective(bl);
			// 成功时间
			IfDefineLine idl = new IfDefineLine();
			idl.setIfLineId(execTask.getIfLineId().intValue());
			idl.setLastTime(d);
			ifDefineLineMapper.updateByPrimaryKeySelective(idl);
		}
		logger.info("9,接口：" + execTask.getIfName());
		taskDefineMapper.updateByPrimaryKeySelective(starttd);
		TaskQueue tq = new TaskQueue();
		tq.setTaskQueueId(execTask.getTaskQueueId());
		tq.setIsDealed(1);
		tq.setDealedTime(new Date());
		taskQueueMapper.updateByPrimaryKeySelective(tq);
		logger.info("任务执行结束，接口：" + execTask.getIfName());
	}

}
