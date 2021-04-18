package com.airboot.project.system.mapper;

import com.airboot.common.component.MyBaseMapper;
import com.airboot.project.system.model.entity.SysUser;
import com.airboot.project.system.model.vo.SearchSysUserVO;
import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表 数据层
 *
 * @author airboot
 */
public interface SysUserMapper extends MyBaseMapper<SysUser> {
    
    /**
     * 查询用户分页
     *
     * @param search 查询条件
     * @return 分页结果
     */
    IPage<SysUser> findPage(SearchSysUserVO search);
    
    /**
     * 查询用户列表
     *
     * @param search 查询条件
     * @return 用户列表
     */
    List<SysUser> findList(SearchSysUserVO search);
    
    /**
     * 通过登录账号查询用户（忽略多租户ID拼接）
     *
     * @param account 用户登录账号
     * @return 用户对象信息
     */
    @InterceptorIgnore(tenantLine = "true")
    SysUser findByAccount(String account);
    
    /**
     * 根据id查询正常用户（忽略多租户ID拼接）
     *
     * @param id 用户id
     * @return
     */
    @InterceptorIgnore(tenantLine = "true")
    SysUser findNormalById(Long id);
    
    /**
     * 根据手机号查询正常用户（忽略多租户ID拼接）
     *
     * @param mobile 用户手机号
     * @return
     */
    @InterceptorIgnore(tenantLine = "true")
    SysUser findNormalByMobile(String mobile);
    
    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    SysUser findById(Long userId);
    
    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户ID
     * @return 结果
     */
    int deleteUserByIds(Long[] userIds);
    
    /**
     * 校验用户名是否唯一（忽略多租户ID拼接）
     *
     * @param username 用户名
     * @return 结果
     */
    @InterceptorIgnore(tenantLine = "true")
    SysUser checkUsernameUnique(String username);
    
    /**
     * 校验手机号码是否唯一（忽略多租户ID拼接）
     *
     * @param mobile 手机号码
     * @return 结果
     */
    @InterceptorIgnore(tenantLine = "true")
    SysUser checkMobileUnique(String mobile);
    
    /**
     * 校验email是否唯一（忽略多租户ID拼接）
     *
     * @param email 用户邮箱
     * @return 结果
     */
    @InterceptorIgnore(tenantLine = "true")
    SysUser checkEmailUnique(String email);
    
    /**
     * 根据roleKey获取用户列表（忽略多租户ID自动拼接，以传入的tenantId为准）
     *
     * @param roleKey 角色Key
     * @param tenantId 租户ID
     * @return
     */
    @InterceptorIgnore(tenantLine = "true")
    List<SysUser> findListByRoleKey(@Param("roleKey") String roleKey, @Param("tenantId") Long tenantId);
}
