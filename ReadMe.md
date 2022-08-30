[toc]
### 权限管理系统

#### 1、功能
- 管理员登录
- 用户模块
  - 管理员添加用户
  - 管理员删除用户
  - 分配角色
- 角色模块
  - 管理员添加角色
  - 管理员删除角色
  - 分配权限
- 权限模块
  - 管理员添加权限
  - 管理员删除权限
  - 管理员修改权限信息

![权限管理系统](C:\Users\Administrator\Downloads\权限管理系统.png)

#### 2、技术选型

- SpringBoot
- Mybatis-Plus
- Shiro
- Mysql
- Jwt

#### 3、项目目录结构

![image-20220830210539126](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220830210539126.png)

#### 4、pom依赖

```xml
	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.projectlombok</groupId>
			<artifactId>lombok</artifactId>
			<optional>true</optional>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.apache.shiro</groupId>
			<artifactId>shiro-spring</artifactId>
			<version>1.9.0</version>
		</dependency>
		<dependency>
			<groupId>com.alibaba</groupId>
			<artifactId>fastjson</artifactId>
			<version>1.2.73</version>
		</dependency>
		<dependency>
			<groupId>com.baomidou</groupId>
			<artifactId>mybatis-plus-boot-starter</artifactId>
			<version>3.5.2</version>
		</dependency>
		<dependency>
			<groupId>mysql</groupId>
			<artifactId>mysql-connector-java</artifactId>
			<version>8.0.29</version>
		</dependency>
		<dependency>
			<groupId>com.10duke.client.jwt</groupId>
			<artifactId>jjwt</artifactId>
			<version>1.1.0</version>
		</dependency>
	</dependencies>
```

#### 5、运行效果

![image-20220830210840458](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220830210840458.png)

![image-20220830210912218](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20220830210912218.png)

#### 6、项目地址

前端地址

```java
https://github.com/Negen9527/springboot-shiro-tutorial-front-end.git
```

后端地址：

```java
https://github.com/Negen9527/springboot-shiro-tutorial.git
```

