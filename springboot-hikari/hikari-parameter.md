| name | 描述 | 构造器默认值 | 默认配置validate之后的值 | validate重置 |
| :-----| :----| :----| :----| :----|
|autoCommit|	自动提交从池中返回的连接|true|	|true|	|-
|connectionTimeout|	等待来自池的连接的最大毫秒数|	SECONDS.toMillis(30) = 30000|	30000|	如果小于250毫秒，则被重置回30秒
|idleTimeout|	连接允许在池中闲置的最长时间|	MINUTES.toMillis(10) = 600000|	600000|	如果idleTimeout+1秒>maxLifetime 且 maxLifetime>0，则会被重置为0（代表永远不会退出）；如果idleTimeout!=0且小于10秒，则会被重置为10秒
|maxLifetime|	池中连接最长生命周期|	MINUTES.toMillis(30) = 1800000|	1800000|	如果不等于0且小于30秒则会被重置回30分钟
|connectionTestQuery|	如果您的驱动程序支持JDBC4，我们强烈建议您不要设置此属性|	null|	null|	-
|minimumIdle|	池中维护的最小空闲连接数|	-1|	10|	minIdle<0或者minIdle>maxPoolSize,则被重置为maxPoolSize
|maximumPoolSize|	池中最大连接数，包括闲置和使用中的连接|	-1|	10|	如果maxPoolSize小于1，则会被重置。当minIdle<=0被重置为DEFAULT_POOL_SIZE则为10;如果minIdle>0则重置为minIdle的值
|metricRegistry|	该属性允许您指定一个 Codahale / Dropwizard MetricRegistry 的实例，供池使用以记录各种指标|	null|	null|	-
|healthCheckRegistry|	该属性允许您指定池使用的Codahale / Dropwizard HealthCheckRegistry的实例来报告当前健康信息|	null|	null|	-
|poolName|	连接池的用户定义名称，主要出现在日志记录和JMX管理控制台中以识别池和池配置|	null|	HikariPool-1|	-
|initializationFailTimeout|	如果池无法成功初始化连接，则此属性控制池是否将 fail fast|	1|	1|	-
|isolateInternalQueries|	是否在其自己的事务中隔离内部池查询，例如连接活动测试|	false|	false|	-
|allowPoolSuspension|	控制池是否可以通过JMX暂停和恢复|	false|	false|	-
|readOnly|	从池中获取的连接是否默认处于只读模式|	false|	false|	-
|registerMbeans|	是否注册JMX管理Bean（MBeans）|	false|	false|	-
|catalog|	为支持 catalog 概念的数据库设置默认 catalog|	driver default|	null|	-
|connectionInitSql|	该属性设置一个SQL语句，在将每个新连接创建后，将其添加到池中之前执行该语句。|	null|	null|	-
|driverClassName|	HikariCP将尝试通过仅基于jdbcUrl的DriverManager解析驱动程序，但对于一些较旧的驱动程序，还必须指定driverClassName|	null|	null|	-
|transactionIsolation|	控制从池返回的连接的默认事务隔离级别|	null|	null|	-
|validationTimeout|	连接将被测试活动的最大时间量|	SECONDS.toMillis(5) = 5000|	5000|	如果小于250毫秒，则会被重置回5秒
|leakDetectionThreshold|	记录消息之前连接可能离开池的时间量，表示可能的连接泄漏|	0|	0|	如果大于0且不是单元测试，则进一步判断：(leakDetectionThreshold < SECONDS.toMillis(2) or (leakDetectionThreshold > maxLifetime && maxLifetime > 0)，会被重置为0 . 即如果要生效则必须>0，而且不能小于2秒，而且当maxLifetime > 0时不能大于maxLifetime
|dataSource|	这个属性允许你直接设置数据源的实例被池包装，而不是让HikariCP通过反射来构造它|	null|	null|	-
|schema|	该属性为支持模式概念的数据库设置默认模式|	driver default|	null|	-
|threadFactory|	此属性允许您设置将用于创建池使用的所有线程的java.util.concurrent.ThreadFactory的实例。|	null|	null|	-
|scheduledExecutor|	此属性允许您设置将用于各种内部计划任务的java.util.concurrent.ScheduledExecutorService实例|	null|	null|	-
