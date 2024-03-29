package com.airboot.project.system.controller;

import com.airboot.common.component.BaseController;
import com.airboot.common.core.aspectj.lang.annotation.Log;
import com.airboot.common.core.utils.poi.ExcelUtil;
import com.airboot.common.model.vo.AjaxResult;
import com.airboot.common.security.annotation.PreAuthorize;
import com.airboot.project.monitor.model.enums.OperationTypeEnum;
import com.airboot.project.system.model.entity.SysTenant;
import com.airboot.project.system.model.vo.SearchSysTenantVO;
import com.airboot.project.system.service.ISysTenantService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

/**
 * 租户管理Controller
 * 
 * @author airboot
 */
@Slf4j
@RestController
@RequestMapping("/system/tenant")
public class SysTenantController extends BaseController {

    @Resource
    private ISysTenantService sysTenantService;

    /**
     * 查询租户管理分页
     */
    @PreAuthorize("system:tenant:page")
    @GetMapping("/page")
    public AjaxResult page(SearchSysTenantVO search) {
        IPage<SysTenant> page = sysTenantService.getPage(search);
        return success(page);
    }

    /**
     * 查询租户管理列表
     */
    @PreAuthorize("system:tenant:page")
    @GetMapping("/list")
    public AjaxResult list(SearchSysTenantVO search) {
        List<SysTenant> list = sysTenantService.getList(search);
        return success(list);
    }

    /**
     * 导出租户管理列表
     */
    @PreAuthorize("system:tenant:export")
    @Log(title = "租户管理", operationType = OperationTypeEnum.导出)
    @GetMapping("/export")
    public AjaxResult export(SearchSysTenantVO search) {
        List<SysTenant> list = sysTenantService.getList(search);
        ExcelUtil<SysTenant> util = new ExcelUtil<>(SysTenant.class);
        return util.exportExcel(list, "tenant");
    }

    /**
     * 获取租户管理详细信息
     */
    @PreAuthorize("system:tenant:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(sysTenantService.getById(id));
    }

    /**
     * 新增租户管理
     */
    @PreAuthorize("system:tenant:add")
    @Log(title = "租户管理", operationType = OperationTypeEnum.新增)
    @PostMapping
    public AjaxResult add(@RequestBody SysTenant sysTenant) {
        sysTenantService.saveOrUpdate(sysTenant);
        return success();
    }

    /**
     * 修改租户管理
     */
    @PreAuthorize("system:tenant:edit")
    @Log(title = "租户管理", operationType = OperationTypeEnum.修改)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTenant sysTenant) {
        sysTenantService.saveOrUpdate(sysTenant);
        return success();
    }

    /**
     * 删除租户管理
     */
    @PreAuthorize("system:tenant:remove")
    @Log(title = "租户管理", operationType = OperationTypeEnum.删除)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysTenantService.deleteByIds(Arrays.asList(ids)));
    }
}
