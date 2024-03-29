package com.airboot.common.core.constant;

/**
 * 通用常量信息
 *
 * @author airboot
 */
public class Constants {
    
    /**
     * 生产环境profile名称
     */
    public static final String PROFILE_PROD = "prod";
    
    /**
     * 测试环境profile名称
     */
    public static final String PROFILE_TEST = "test";
    
    /**
     * UTF-8 字符集
     */
    public static final String UTF8 = "UTF-8";
    
    /**
     * GBK 字符集
     */
    public static final String GBK = "GBK";
    
    /**
     * http请求
     */
    public static final String HTTP = "http://";
    
    /**
     * https请求
     */
    public static final String HTTPS = "https://";
    
    /**
     * redis key前缀
     */
    public static final String REDIS_PREFIX = "airboot:";
    
    /**
     * 验证码 redis key
     */
    public static final String REDIS_CAPTCHA_CODE_KEY = REDIS_PREFIX + "captcha_code:";
    
    /**
     * 登录用户 redis key
     */
    public static final String REDIS_LOGIN_KEY = REDIS_PREFIX + "login_user:";
    
    /**
     * 验证码有效期（分钟）
     */
    public static final Integer CAPTCHA_EXPIRATION_MINUTES = 2;
    
    /**
     * 令牌前缀
     */
    public static final String TOKEN_PREFIX = "Bearer ";
    
    /**
     * JWT UUID
     */
    public static final String JWT_UUID = "uuid";
    
    /**
     * JWT UserKey
     */
    public static final String JWT_USER_KEY = "airboot";
    
    /**
     * 资源映射路径 前缀
     */
    public static final String RESOURCE_PREFIX = "/profile";
    
    /**
     * Layout组件标识
     */
    public final static String LAYOUT = "Layout";
    
    /**
     * 不拦截的路径
     */
    public static final String[] EXCLUDE_PATH_PATTERNS = {"/login", "/needCaptcha", "/captchaImage", RESOURCE_PREFIX + "/**", "/common/download**", "/common/download/resource**",
        "/system/config/unauth-key/*",
        "/*.html", "/**/*.html", "/**/*.css", "/**/*.js", "/**/*.ttf", "/**/*.png", "/**/*.gif", "/**/*.ico", "/**/*.jpg",
        "/swagger-ui.html", "/**/v2**", "/swagger-resources/**", "/webjars/**", "/*/api-docs", "/druid/**",
        "/actuator**", "/error"};
    
    /**
     * 允许展示给前端的枚举列表
     */
    public static final String[] FRONT_SHOW_ENUMS = {"status", "success", "device", "cardType", "gender"};
    
    /**
     * 不走多租户拦截器的表
     */
    public static final String[] IGNORE_TENANT_TABLE = {"tables", "columns", "gen_table", "gen_table_column",
        "sys_job", "sys_job_log", "sys_menu", "sys_tenant",
        "sys_user_post", "sys_user_role", "sys_role_dept", "sys_role_menu"};
    
    /**
     * 超级租户管理员用户ID
     */
    public static final Long TENANT_ADMIN_USER_ID = 1L;
    
    /**
     * 超级租户管理员角色ID
     */
    public static final Long TENANT_ADMIN_ROLE_ID = 1L;
    
    /**
     * 管理平台租户ID
     */
    public static final Long ADMIN_TENANT_ID = 1L;
    
}
