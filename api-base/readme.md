● cache：Redis 缓存相关工具
● config：常见的配置类，主要包括
    ○ 跨域配置
    ○ Jackson 配置
    ○ Redis 配置
    ○ Swagger 配置
● constant：系统中的常量维护
● exception：统一异常处理，主要包括
    ○ 自定义异常类
    ○ 错误码枚举类
    ○ 统一异常处理类
● excel：excel 工具，主要包括
    ○ 日期转换
    ○ excel 读取监听器
    ○ excel 读取数据完成回调
● query：封装公共查询参数
● utils：常用的工具类，主要包括
    ○ IP 工具类
    ○ 地址工具类
    ○ 校验工具类
    ○ 日期格式化工具类
    ○ excel 导入导出工具类
    ○ Json 工具类：对 Java 类和 JsonString 互转
    ○ 分页结果封装类：包含总记录数、列表数据
    ○ 统一响应返回泛型类封装：code、msg、data
    ○ 树节点类：要展现为树形节点的类，均需要继承它
    ○ 树节点工具类：数据转为树形结构