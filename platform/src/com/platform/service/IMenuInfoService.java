package com.platform.service;

import java.util.List;
import java.util.Map;

import com.platform.entity.MenuInfo;
import com.platform.entity.MenuUser;

import dbengine.util.Page;


/**
 * 菜单权限信息接口
 * @author hshzh
 *
 */
public interface IMenuInfoService {
	/**
	 * 保存或修改菜单信息
	 * @param mi
	 * @return
	 */
	public boolean saveOrUpMenu(String sourceId,boolean closeConn,MenuInfo mi);
	
	/**
	 * 删除菜单信息
	 * @param menuUUID
	 * @return
	 */
	public boolean deleteMenu(String sourceId,boolean closeConn,String menuUUID);
	/**
	 * 查询菜单信息
	 * @param menuUUID
	 * @return
	 */
	public MenuInfo findMenu(String sourceId,boolean closeConn,String menuUUID);
	/**
	 * 查菜单列表
	 * @param unitUUID
	 * @param menuType 菜单类型（0顶级菜单，1级菜单，2二级菜单,3三级菜单 ）
	 * @param menuParentCode 父级菜单编码（不为空则查对应的下级菜单）
	 * @return
	 */
	public List<MenuInfo> findMenuList(String sourceId,boolean closeConn,Page page, Map<String, String> findMap);
	
    /**
     * 获取该节点的一个未使用的节点编号
     * @param menuParentCode
     * @return
     */
    public String getMenuCodeNext(String sourceId,boolean closeConn,String menuParentCode);
    
    /**
     * 删除用户关联的所有菜单权限
     * @param sourceId
     * @param closeConn
     * @param userUUID
     * @return
     */
    public boolean deleteMenuUser(String sourceId,boolean closeConn,String userUUID);
    
    /**
     * 保存用户菜单权限关联信息
     * @param sourceId
     * @param closeConn
     * @param info
     * @return
     */
    public boolean saveMenuUser(String sourceId,boolean closeConn,MenuUser info);
    
    public MenuInfo findMenuByID(String sourceId,boolean closeConn,String unitUUID, String id);
    
    public MenuInfo findMenuByMenuMark(String sourceId,boolean closeConn,String menuMark);

}
