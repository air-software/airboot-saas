package com.airboot.common.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * 租户Tree基类
 *
 * @author airboot
 */
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class TenantTreeEntity extends TreeEntity {
    
    private static final long serialVersionUID = 1L;
    
    /**
     * 租户ID
     * 为保障数据安全，不接收前端传递的tenantId值
     */
    @JsonIgnore
    private Long tenantId;
    
}
