package com.airboot.common.model.vo;

import com.airboot.common.model.enums.SearchStatusEnum;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * 分页VO基本类
 *
 * @author airboot
 */
@Data
public class BaseSearchVO<T> extends Page<T> {
    
    /**
     * 查询ID
     */
    private Long id;
    
    /**
     * 租户ID
     * 注意：为保障数据安全，如果在sql查询条件中需要用到tenantId，则不应取前端传递的值，而应在后端根据情况在controller或service层赋值。写在此处是为了方便mapper里直接用到SearchVO的tenantId，并不代表要接受前端传过来的tenantId。
     */
    @JsonIgnore
    private Long tenantId;
    
    /**
     * 开始时间
     */
    private String beginTime;
    
    /**
     * 结束时间
     */
    private String endTime;
    
    /**
     * 数据权限
     */
    private String dataScopeSql;
    
    /**
     * 状态
     */
    private SearchStatusEnum status;
    
    /**
     * 查询类型，用于支持复杂查询条件
     */
    private String queryType;
    
    /**
     * 每页显示条数，由于所有查询条件都继承此VO，为避免查询list时受分页影响，因此条数默认为 100000
     * 具体分页时则以前端传入为准
     */
    private long size = 100000;
    
    @Override
    public Page<T> setSize(long size) {
        this.size = size;
        return this;
    }
    
}
