package com.ami.ec.channel.bean.pluginManager.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.ami.ec.channel.bean.pluginManager.TaskQueueServices;
import com.ami.ec.channel.bean.pluginManager.TaskQueueThread;
import com.ami.ec.channel.dao.pluginManager.ExecTaskMapper;
import com.ami.ec.channel.dao.pluginManager.TaskQueueMapper;
import com.ami.ec.channel.domain.pluginManager.ExecTask;
import com.ami.ec.channel.domain.pluginManager.TaskQueue;
import com.ami.ec.channel.domain.pluginManager.TaskQueueExample;
import com.ami.ec.channel.util.WebUtil;

public class TaskQueueServicesImpl implements TaskQueueServices {

	private ExecTaskMapper execTaskMapper;
	private TaskQueueMapper taskQueueMapper;

	private Long lastTaskQueueId; 
	private ScheduledThreadPoolExecutor taskQueueScheduledThreadPoolExecutor;
	int corePoolSize = 1;

	public ExecTaskMapper getExecTaskMapper() {
		return execTaskMapper;
	}

	public void setExecTaskMapper(ExecTaskMapper execTaskMapper) {
		this.execTaskMapper = execTaskMapper;
	}

	public TaskQueueMapper getTaskQueueMapper() {
		return taskQueueMapper;
	}

	public void setTaskQueueMapper(TaskQueueMapper taskQueueMapper) {
		this.taskQueueMapper = taskQueueMapper;
	}

	public Long getLastTaskQueueId() {
		return lastTaskQueueId;
	}

	public void setLastTaskQueueId(Long lastTaskQueueId) {
		this.lastTaskQueueId = lastTaskQueueId;
	}

	public ScheduledThreadPoolExecutor getTaskQueueScheduledThreadPoolExecutor() {
		return taskQueueScheduledThreadPoolExecutor;
	}

	public void setTaskQueueScheduledThreadPoolExecutor(
			ScheduledThreadPoolExecutor taskQueueScheduledThreadPoolExecutor) {
		this.taskQueueScheduledThreadPoolExecutor = taskQueueScheduledThreadPoolExecutor;
	}

	public int getCorePoolSize() {
		return corePoolSize;
	}

	public void setCorePoolSize(int corePoolSize) {
		this.corePoolSize = corePoolSize;
	}

	public void readTaskQueue() {
		if(taskQueueScheduledThreadPoolExecutor==null)
		{
			taskQueueScheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(corePoolSize);
		}

		// 多线程方式执行
		// 读取任务队列，状态是未执行，并且执行周期内
		Map param = new HashMap();
		
		if (lastTaskQueueId == null||lastTaskQueueId==0) {
		} else
			param.put("TaskQueueId", lastTaskQueueId);
		List<ExecTask> tdl = execTaskMapper.selectTaskQueue(param);
		if (WebUtil.isNullForList(tdl))
			return;
		// 记录最后读取的队列ID
		lastTaskQueueId = tdl.get(tdl.size() - 1).getTaskQueueId();
		// 记录过期的队列ID
		List<Long> failureTaskQueueIds = new ArrayList();
		// 记录执行中的队列ID
		List<Long> taskQueueIds = new ArrayList();
		// 循环队列判断是否可以执行，可以执行先做执行标记，更新队列记录，放到线程中执行
		for (ExecTask et : tdl) {
			Date currentDate = new Date();
			// 判断队列是否有效
			if (et.getEndTime() != null && et.getEndTime().before(currentDate)) {
				failureTaskQueueIds.add(et.getTaskQueueId());
				continue;
			}
			Date start = et.getStartTime();
			if (start == null || start.before(currentDate))
				start = currentDate;
			TaskQueueThread taskQueueThread = new TaskQueueThread();
			taskQueueThread.setExecTask(et);
			taskQueueThread.setExecTaskMapper(execTaskMapper);
			taskQueueScheduledThreadPoolExecutor.schedule(taskQueueThread,
					start.getTime()-currentDate.getTime(),
					TimeUnit.MILLISECONDS);
			taskQueueIds.add(et.getTaskQueueId());
		}
		// 更新队列状态
		if (failureTaskQueueIds.size() > 0) {
			TaskQueue failureTq = new TaskQueue();
			failureTq.setStatus(-1);
			TaskQueueExample failureTqe = new TaskQueueExample();
			TaskQueueExample.Criteria fc = failureTqe.createCriteria();
			fc.andTaskQueueIdIn(failureTaskQueueIds);
			taskQueueMapper.updateByExampleSelective(failureTq, failureTqe);
		}
		if (taskQueueIds.size() > 0) {
			TaskQueue newTq = new TaskQueue();
			newTq.setStatus(1);
			TaskQueueExample newTqe = new TaskQueueExample();
			TaskQueueExample.Criteria fc = newTqe.createCriteria();
			fc.andTaskQueueIdIn(taskQueueIds);
			fc.andStatusEqualTo(0);
			taskQueueMapper.updateByExampleSelective(newTq, newTqe);
		}

		// 线程执行时根据执行结果回写执行情况，如果执行失败判断是否要重试，重试次数及延迟执行时间

	}

}
