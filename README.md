# Airboot-SaaS

### 多租户动态数据源版本现已重磅发布！请前往 <a href="https://github.com/air-software/airboot-saas-datasource" target="_blank">Airboot-SaaS-DataSource</a> 。

### 注意：如需非多租户版本请移步至 <a href="https://github.com/air-software/airboot" target="_blank">Airboot</a> 。

---

## 介绍

Airboot-SaaS是一个轻量级通用多租户管理系统。在主要功能上将与 <a href="https://github.com/air-software/airboot" target="_blank">Airboot</a> 保持一致，但是会兼容多租户的模式。

- 前端使用 Vue + Element
- 后端使用 Spring Boot + Mybatis-Plus
- 缓存使用 Redis，数据库使用 MySQL
- 登录验证使用 JWT，支持切换唯一登录
- 使用代码生成器可以一键生成前后端代码

本系统初期基于 <a href="https://gitee.com/y_project/RuoYi-Vue" target="_blank">若依（RuoYi-Vue）</a> 二次开发，启动开发时对应的若依版本在2.2至2.3之间，之后的功能路线与若依不同，基本没有再合并若依的更新。

若依本身是一个优秀的开源项目，我根据**个人开发习惯**做了一些架构和细节上的改动，其中后端改动较大，前端改动较小，UI风格没有变化（若依也是直接采用了vue-admin-element），总的来说也谈不上什么优化，欢迎有**类似开发习惯**的小伙伴们尝试使用。

主要改动如下：

1. 将`Mybatis`替换为 <a href="https://baomidou.com/" target="_blank">Mybatis-Plus</a> ，简化了Mapper代码；
2. 去掉了`字典管理`功能，全部改为枚举实现。这东西见仁见智，只是我个人更习惯用枚举，没有绝对的好坏。非要说原因的话，请看：[为什么去掉字典管理？](#为什么去掉字典管理)
3. 去掉了较重的`Spring-Security`，改为自定义拦截器实现，原因请看：[为什么去掉Spring-Security？](#为什么去掉Spring-Security)
4. 添加多租户支持，采用【**共享数据库，共享数据表**】的模式（即通过表内的`tenant_id`来区分租户）。后期可能会再添加【**共享数据库，独立Schema**】的模式，以适应不同需求；
5. 其他细节改动，如代码风格、框架配置、工具类封装、代码生成等等。

**详细的使用文档**会在近期放出。

---

## 如何开始

### 环境准备

- JDK 8+
- Node.js 10+
- MySQL 5.5+
- Redis

### 后端启动

1. 在MySQL中新建一个数据库（字符集utf8mb4），随后将`airboot-server/sql/init.sql`导入数据库中建表；
2. 检查`application.yml`及`application-dev.yml`中各项配置，尤其MySQL和Redis的链接地址；
3. 在IDE中启动开发调试，观察日志输出，启动成功后会出现`Airboot Server启动成功！`的提示。

### 前端启动

在`airboot-web`目录下打开命令行：

```
# 使用淘宝源来加快下载速度
npm config set registry http://registry.npm.taobao.org/

# 解决node-sass可能下载出错的问题
npm config set sass_binary_site https://npm.taobao.org/mirrors/node-sass/

# 安装依赖
npm install

# 启动服务
npm run dev
```

启动成功后浏览器访问 http://localhost/

管理员账号 admin，密码 admin123

---

## 演示截图

![登录页](https://air-software.github.io/static/image/airboot-saas/login.png)

![首页](https://air-software.github.io/static/image/airboot-saas/index.png)

![租户管理](https://air-software.github.io/static/image/airboot-saas/tenant.png)

![用户管理](https://air-software.github.io/static/image/airboot-saas/user.png)

![表单构建](https://air-software.github.io/static/image/airboot-saas/form-generator.png)

![代码生成](https://air-software.github.io/static/image/airboot-saas/gen.png)

![代码生成-字段编辑](https://air-software.github.io/static/image/airboot-saas/gen-column.png)

![代码生成-生成信息](https://air-software.github.io/static/image/airboot-saas/gen-info.png)

![代码生成-预览](https://air-software.github.io/static/image/airboot-saas/gen-preview.png)

---

## FAQ

### 为什么去掉字典管理？

1. 字典看起来灵活，能够随时新增和修改，但如果没有业务关联就是没有意义的数据。而如果想要做业务关联，大部分情况下还是要去修改代码的，**字典并没有减轻你的工作**。比如在 <a href="https://gitee.com/y_project/RuoYi-Vue" target="_blank">RuoYi-Vue</a> 的源代码中，虽然字典定义了`0`是正常状态，`1`是停用状态，但依然要在代码里用常量类 <a href="https://gitee.com/y_project/RuoYi-Vue/blob/0a75dcdd85c2c4921c7f3997f8c90214f5202a25/ruoyi-common/src/main/java/com/ruoyi/common/constant/UserConstants.java" target="_blank">UserConstants.java</a> 来为`0`和`1`赋予具体的业务含义，然后再拿来比对用户或部门的状态等，其实是比添加和使用枚举更繁琐了一点。
2. 我认为最适合使用字典的是像`新闻类别`这样的数据，只要我预先写好代码，就可以动态增改新闻类别，因为处理逻辑都是一样的。但要注意，像这样的字典，**恰恰不应该放进像`字典管理`这样统一的功能中**。原因如下：
   1. 首先从权限上就不好控制，我想授权一个人管理新闻类别，但不想让他看到其他的字典，这是很正常的权限需求，但如果所有字典数据全都放在`字典管理`里，这个权限就很难控制，<a href="https://gitee.com/y_project/RuoYi-Vue" target="_blank">RuoYi-Vue</a> 并没有在字典管理上实现这种权限细分，而如果你想自己实现也是很繁琐的。
   2. 其次，我的`新闻类别`不一定是只要有`字典名称`和`字典值`这两个字段就能满足了，我可能还需要其他属性，但我总不能去给字典表随便添加字段吧？
   
   所以正确的做法是：单独建一张`新闻类别表`，单独加一个`新闻类别管理`功能，这样不但业务清晰，也便于管理。
   
3. 如果我们在系统中大量使用字典，就意味着我们在所有用到字典数据的地方都需要去后端获取，否则用户会无法使用查询条件，列表数据里的字典值也无法转义。这在请求量少的时候没多大问题，但如果请求非常多，**对数据库的压力是显而易见的**。可如果把字典数据拉到缓存里，又会面临缓存和数据库双写的问题。或者我们可以设置一个按钮来手动刷新缓存，但也会存在忘记刷新的风险。

   而如果我们使用枚举，这些问题都是不会存在的。

4. `字典管理`如果想要做的完善，还需要考虑很多细节。比如是否需要对修改和删除进行控制，如果不控制，那**字典值修改或删除后，使用到此字典值的旧数据怎么办**？如果要控制，那就需要遍历可能用到字典值的数据表，并作出相应处理。在 <a href="https://gitee.com/y_project/RuoYi-Vue" target="_blank">RuoYi-Vue</a> 的源代码中是直接就可以修改和删除的，并没有做控制处理，而如果我们自己实现的话也需要花很多时间和精力。相比之下枚举就不存在这样的问题。

综上所述，我并非反对使用字典，而是认为使用字典一定要有合适的情况和明确的目的（比如单独的`新闻类别管理`是合适且明确的），像统一的`字典管理`其实是没有必要的。


### 为什么去掉Spring-Security？

`Spring-Security`的确是功能强大的权限框架，但一方面是较重，不符合Airboot-SaaS轻量级的理念。另一方面，如果想要用好`Spring-Security`的强大功能，需要对其有一定的熟练度，**这无疑会给想使用Airboot-SaaS进行二次开发的人设置了门槛**，所以我将其替换成了更易于理解和改造的自定义拦截器。

我个人认为，权限这个东西，说通用也通用，说不通用也不通用，很多公司在权限上其实都会有自己的特殊需求。除非你的目的是做一个庞大且复杂的管理系统，否则没有必要考虑用`Spring-Security`。

### 为什么本项目中的枚举几乎都是中文？

1. 增加了代码的可读性，尤其对于业务类枚举来说（在某些专业领域的业务中更是如此），不必再绞尽脑汁想合适的专业英文翻译或拼音简写。除非你所在的项目团队有外国开发人员，或者你的开发/部署环境不支持中文字符；
2. 中文枚举可以直接返回给前端作为字符串展示，大部分情况下不需要再次翻译给用户看。

综上所述，我一直推荐使用中文来命名业务相关的枚举、常量或局部变量，但对于类似实体类的属性等不推荐使用中文，因为会导致getter和setter的方法名看起来很怪。
