package com.airboot.project.system.service;

import com.airboot.project.system.model.entity.SysTenant;
import com.airboot.project.system.model.vo.SearchSysTenantVO;
import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;

/**
 * 租户管理Service接口
 * 
 * @author airboot
 */
public interface ISysTenantService {

    /**
     * 查询租户管理分页
     *
     * @param search 查询条件
     * @return 分页结果
     */
    IPage<SysTenant> getPage(SearchSysTenantVO search);

    /**
     * 查询租户管理列表
     * 
     * @param search 查询条件
     * @return 租户管理集合
     */
    List<SysTenant> getList(SearchSysTenantVO search);

    /**
     * 查询租户管理
     *
     * @param id 租户管理ID
     * @return 租户管理
     */
    SysTenant getById(Long id);

    /**
     * 新增或修改租户管理
     * 
     * @param sysTenant 租户管理
     * @return 结果
     */
    void saveOrUpdate(SysTenant sysTenant);

    /**
     * 删除租户管理信息
     *
     * @param id 租户管理ID
     * @return 结果
     */
    int deleteById(Long id);

    /**
     * 批量删除租户管理
     * 
     * @param idList 需要删除的租户管理ID
     * @return 结果
     */
    int deleteByIds(List<Long> idList);

}
