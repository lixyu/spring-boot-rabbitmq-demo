# spring-boot-rabbitmq-demo

## 
查看ubuntu当前版本命令： cat /etc/issue 
由于rabbitMq需要erlang语言的支持，在安装rabbitMq之前需要安装erlang，执行命令：

sudo apt-get install erlang-nox
 
 安装rabbitMq命令：

sudo apt-get update
sudo apt-get install rabbitmq-server

启动、停止、重启、状态rabbitMq命令：

启动：sudo rabbitmq-server start
关闭： sudo rabbitmq-server stop
重启： sudo rabbitmq-server restart
查看状态：sudo rabbitmqctl status
启用rabbitmq自带的一个web插件，可以用来管理消息队列，命令：

rabbitmq-plugins enable rabbitmq_management
//rabbitmq默认端口号5672，web管理端口号是15672，管理地址为http://ip:15672
创建用户，指定用户名以及密码

rabbitmqctl add_user admin 123456 //用户名admin,密码123456
分配角色,administrator是可以操作和guest本地用户一样的功能，当登录上rabbitmq_management之后，里面的所有功能都可以使用。

rabbitmqctl set_user_tags root administrator
授权，队列的操作管理权限。如果不配置，那么客户端在连接消息队列时会出问题。

rabbitmqctl set_permissions -p / root ".*" ".*" ".*"
最后，附上spring boot整合rabbitmq的源码
   https://github.com/lixyu/spring-boot-rabbitmq-demo.git
