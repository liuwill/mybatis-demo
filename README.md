# mybatis-demo

> 使用IntelliJ IDEA开发的myBatis演示程序

> 该项目使用Gradle进行构建项目，并且简单使用了testNG做单元测试


## 项目说明
为了测试myBatis的数据模型，这里简单的使用的纯Java实现的内存数据库H2，运行之后，首先运行测试，在单元测试中，将会第一次运行是进行需要用到的数据表的创建，并且写入初始数据。

项目用到的mapper类和文件，还有数据模型，是通过mybatisGenerator来生成的，在gradle中进行相应的配置，然后执行就可以。

下载项目之后，运行`gradle idea`生成idea项目

###### 目录说明

`src/main/java/` - 类路径，程序的主要代码，将会编译成项目的class

`src/main/resources/` - 类路径，程序中不需要编译成class的资源文件

`src/test/java/` - 测试类，gradle test默认运行单元测试的类路径

`src/test/resources/` - 测试资源，单元测试特有的类路径

`resources/` - 一些不需要运行到类路径中的额外资源

`build.gradle` - Gradle构建的配置文件，指定如何进行项目构建
