package com.sunmw.web.bean.login;

import java.util.List;
import java.util.Map;

import com.sunmw.web.entity.SecurityGroup;
import com.sunmw.web.entity.SecurityPermission;
import com.sunmw.web.entity.UserLogin;

public interface SecurityPermissionServices {
	/**
	 * 根据用户ID得到菜单列表 支持多级菜单
	 * 
	 * @param userLoginId
	 * @return
	 */
	public List getLoginMenu(int userId);

	/**
	 * 检查用户权限
	 * 
	 * @param userLoginId
	 * @param permissionId
	 * @return
	 */
	public String checkPermission(int userId, String permissionId);
	
	/**
	 * 权限组列表
	 * @return
	 */
	public List<SecurityGroup> securityGroupList(UserLogin ul);
	
	/**
	 * 权限列表
	 * @return
	 */
	public List<SecurityPermission> securityPermissionList();
	
	/**
	 * 权限组的权限
	 * @param groupId
	 * @return
	 */
	public List<Map> securityGroupPermissionList(String groupId);
	
	
	/**
	 * 权限组的区域
	 * @param groupId
	 * @return
	 */
	public List<Map> securityGroupAreaList(String groupId);
	
	/**
	 * 用户的权限组列表
	 * @param userName
	 * @return
	 */
	public List<Map> userLoginSecurityGroupList(int userId);
	
	/**
	 * 保存用户的权限组
	 * @param userName
	 * @param groupIds
	 * @return
	 */
	public String saveUserSecurityGroup(int userId,String groupIds);
	
	/**
	 * 保存权限组
	 * @param groupId
	 * @param groupName
	 * @return
	 */
	public String saveSecurityGroup(String groupId,String groupName,int level);
	
	/**
	 * 保存权限组的权限
	 * @param groupId
	 * @param permissionIds
	 * @return
	 */
	public String saveSecurityGroupPermission(String groupId,String permissionIds);
	
	/**
	 * 保存权限组的区域
	 * @param groupId
	 * @param permissionIds
	 * @return
	 */
	public String saveSecurityGroupArea(String groupId,String areaIds);
	
	/**
	 * 查询权限组
	 * @param param
	 * @param currentPage
	 * @param pageRow
	 * @return
	 */
	public Map searchSecurityGroup(Map param, int currentPage, int pageRow);
}
