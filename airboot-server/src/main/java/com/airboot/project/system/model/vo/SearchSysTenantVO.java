package com.airboot.project.system.model.vo;

import com.airboot.common.model.vo.BaseSearchVO;
import com.airboot.project.system.model.enums.TenantTypeEnum;
import lombok.Data;

/**
 * 查询租户管理分页条件
 * 
 * @author airboot
 * @date 2020-09-18
 */
@Data
public class SearchSysTenantVO extends BaseSearchVO {

    /**
     * 租户名称
     */
    private String tenantName;

    /**
     * 负责人姓名
     */
    private String personName;

    /**
     * 负责人手机号码
     */
    private String mobile;
    
    /**
     * 租户类型
     */
    private TenantTypeEnum tenantType;

}
