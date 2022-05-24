package com.airboot.project.system.service.impl;

import com.airboot.project.system.mapper.SysTenantMapper;
import com.airboot.project.system.model.entity.SysTenant;
import com.airboot.project.system.model.vo.SearchSysTenantVO;
import com.airboot.project.system.service.ISysTenantService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 租户管理Service业务层处理
 * 
 * @author airboot
 */
@Slf4j
@Service
public class SysTenantServiceImpl implements ISysTenantService {

    @Resource
    private SysTenantMapper sysTenantMapper;

    /**
     * 查询租户管理分页
     *
     * @param search 查询条件
     * @return 分页结果
     */
    @Override
    public IPage<SysTenant> getPage(SearchSysTenantVO search) {
        return sysTenantMapper.findPage(search);
    }

    /**
     * 查询租户管理列表
     * 
     * @param search 查询条件
     * @return 租户管理
     */
    @Override
    public List<SysTenant> getList(SearchSysTenantVO search) {
        return sysTenantMapper.findList(search);
    }

    /**
     * 查询租户管理
     *
     * @param id 租户管理ID
     * @return 租户管理
     */
    @Override
    public SysTenant getById(Long id) {
        return sysTenantMapper.selectById(id);
    }

    /**
     * 新增或修改租户管理
     * 
     * @param sysTenant 租户管理
     * @return 结果
     */
    @Override
    public void saveOrUpdate(SysTenant sysTenant) {
        sysTenantMapper.saveOrUpdate(sysTenant);
    }

    /**
     * 删除租户管理信息
     *
     * @param id 租户管理ID
     * @return 结果
     */
    @Override
    public int deleteById(Long id) {
        return sysTenantMapper.deleteById(id);
    }

    /**
     * 批量删除租户管理
     * 
     * @param idList 需要删除的租户管理ID
     * @return 结果
     */
    @Override
    public int deleteByIds(List<Long> idList) {
        return sysTenantMapper.deleteBatchIds(idList);
    }

}
