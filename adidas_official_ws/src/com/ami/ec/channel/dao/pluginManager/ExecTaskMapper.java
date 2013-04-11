package com.ami.ec.channel.dao.pluginManager;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.ami.ec.channel.domain.pluginManager.ExecTask;
import com.ami.ec.channel.domain.pluginManager.IfDefine;
import com.ami.ec.channel.domain.pluginManager.TaskDefine;
import com.ami.ec.channel.domain.pluginManager.TaskQueue;

public interface ExecTaskMapper {
   
    List<ExecTask> selectTaskQueue(java.util.Map param);

    int updateIfDefineBatNoCurrent(java.util.Map example);
}