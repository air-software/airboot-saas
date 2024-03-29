package com.airboot.common.core.constant;

/**
 * 代码生成通用常量
 *
 * @author airboot
 */
public class GenConstants {
    
    /**
     * 单表（增删改查）
     */
    public static final String TPL_CRUD = "crud";
    
    /**
     * 树表（增删改查）
     */
    public static final String TPL_TREE = "tree";
    
    /**
     * 树编码字段
     */
    public static final String TREE_CODE = "treeCode";
    
    /**
     * 树父编码字段
     */
    public static final String TREE_PARENT_CODE = "treeParentCode";
    
    /**
     * 树名称字段
     */
    public static final String TREE_NAME = "treeName";
    
    /**
     * 上级菜单ID字段
     */
    public static final String PARENT_MENU_ID = "parentMenuId";
    
    /**
     * 上级菜单名称字段
     */
    public static final String PARENT_MENU_NAME = "parentMenuName";
    
    /**
     * 是否自动生成 Mybatis的 ResultMap
     */
    public static final String AUTO_RESULT_MAP = "autoResultMap";
    
    /**
     * 是否需要生成Service的Interface，如果业务不复杂且确定未来不会用到多态，则可以不生成Interface，直接使用Service，方便应对需求变更
     */
    public static final String INTERFACE_SERVICE = "interfaceService";
    
    /**
     * 代码生成时是否使用前端全局$enums枚举变量来配置下拉菜单等组件，如开启使用，请确保你在系统中已建好枚举，并配置到了Constants.FRONT_SHOW_ENUMS中
     */
    public static final String GLOBAL_ENUMS = "globalEnums";
    
    /**
     * 数据库字符串类型
     */
    public static final String[] COLUMNTYPE_STR = {"char", "varchar", "narchar", "varchar2", "tinytext", "text", "mediumtext", "longtext"};
    
    /**
     * 数据库时间类型
     */
    public static final String[] COLUMNTYPE_TIME = {"datetime", "time", "date", "timestamp"};
    
    /**
     * 数据库数字类型
     */
    public static final String[] COLUMNTYPE_NUMBER = {"mediumint", "int", "number", "integer", "bigint", "float", "double", "decimal"};
    
    /**
     * 数据库枚举类型
     */
    public static final String[] COLUMNTYPE_ENUM = {"tinyint", "smallint"};
    
    /**
     * 数据库布尔类型
     */
    public static final String[] COLUMNTYPE_BOOLEAN = {"bit"};
    
    /**
     * 页面不需要编辑字段
     */
    public static final String[] COLUMNNAME_NOT_EDIT = {"id", "creator_id", "creator_info", "create_time", "updater_id", "updater_info", "update_time", "ext_json", "deleted", "version", "tenant_id"};
    
    /**
     * 页面不需要显示的列表字段
     */
    public static final String[] COLUMNNAME_NOT_LIST = {"id", "creator_id", "creator_info", "create_time", "updater_id", "updater_info", "update_time", "ext_json", "deleted", "version", "tenant_id"};
    
    /**
     * 页面不需要查询字段
     */
    public static final String[] COLUMNNAME_NOT_QUERY = {"id", "creator_id", "creator_info", "create_time", "updater_id", "updater_info", "update_time", "ext_json", "deleted", "version", "tenant_id"};
    
    /**
     * Entity基类字段
     */
    public static final String[] BASE_ENTITY = {"id", "creatorId", "creatorInfo", "createTime", "updaterId", "updaterInfo", "updateTime", "extJson", "deleted", "version", "tenantId"};
    
    /**
     * Tree基类字段
     */
    public static final String[] TREE_ENTITY = {"parentName", "parentId", "orderNum", "ancestors", "children"};
    
    /**
     * 文本框
     */
    public static final String HTML_INPUT = "input";
    
    /**
     * 文本域
     */
    public static final String HTML_TEXTAREA = "textarea";
    
    /**
     * 下拉框
     */
    public static final String HTML_SELECT = "select";
    
    /**
     * 单选框
     */
    public static final String HTML_RADIO = "radio";
    
    /**
     * 复选框
     */
    public static final String HTML_CHECKBOX = "checkbox";
    
    /**
     * 日期控件
     */
    public static final String HTML_DATETIME = "datetime";
    
    /**
     * 字符串类型
     */
    public static final String TYPE_STRING = "String";
    
    /**
     * 整型
     */
    public static final String TYPE_INTEGER = "Integer";
    
    /**
     * 长整型
     */
    public static final String TYPE_LONG = "Long";
    
    /**
     * 浮点型
     */
    public static final String TYPE_DOUBLE = "Double";
    
    /**
     * 高精度计算类型
     */
    public static final String TYPE_BIGDECIMAL = "BigDecimal";
    
    /**
     * 时间类型
     */
    public static final String TYPE_DATE = "Date";
    
    /**
     * 枚举类型
     */
    public static final String TYPE_ENUM = "Enum";
    
    /**
     * 布尔类型
     */
    public static final String TYPE_BOOLEAN = "Boolean";
    
    /**
     * 模糊查询
     */
    public static final String QUERY_LIKE = "LIKE";
    
}
