Spring Cloud Config<br>
Spring Cloud Config项目是一个解决分布式系统的配置管理方案.它包含了Client和Server两个部分,server提供配置文件的存储.以接口的形式将配置文件的内容提供出去,client通过接口获取数据.并依据此数据初始化自己的应用.<br>
Spring Cloud使用git或者svn存放配置文件,**默认情况下使用git.**<br>
仓库中的配置文件会被转换成web接口，访问可以参照以下的规则：<br>
/{application}/{profile}[/{label}]<br>
/{application}-{profile}.yml<br>
/{label}/{application}-{profile}.yml<br>
/{application}-{profile}.properties<br>
/{label}/{application}-{profile}.properties<br>
以neo-config-dev.properties为例子，它的application是neo-config，profile是dev。client会根据填写的参数来选择读取对应的配置。