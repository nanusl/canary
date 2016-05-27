###Canary

+ Netty：传输实现结果给代理类
+ Cglib：实现动态代理和反射
+ zookeeper(consul)：服务注册与发现
+ spring：spring自定义标签
+ protostuff：java版protobuf协议实现，用于request和response的序列化
+ curator：apache顶级项目，zk的客户端实现

###协议
 + spring配置：
 	+ 总控：
 		canary:application name
 		canary:registry address
	+ 服务端：
		canary:service interface/ref/timeout
	+ 客户端：
		canary:reference id/interface/timeout
	
 + netty格式：
	+ request：
	+ response：


