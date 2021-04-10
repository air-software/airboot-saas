package com.airboot.common.core.aspectj.lang.annotation;

import java.lang.annotation.*;

/**
 * 数据权限过滤注解
 *
 * @author airboot
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataScope {
    
    /**
     * 部门表的别名
     */
    String deptAlias() default "";
    
    /**
     * 用户表的别名
     */
    String userAlias() default "";
}
