# README

起步例子

---

# 技术选型 @stack

- erupt
  - https://www.erupt.xyz/#!/doc

- BeetlSQL3
  - https://beetlsql-doc.vercel.app/start/quick

- easyexcel
  - https://www.yuque.com/easyexcel/doc/easyexcel

---

# 服务部署 @deploy

- 启动服务

```
java  -jar /opt/demo-0.0.1-SNAPSHOT.jar --spring.profiles.active=prod 
```

---

# 代码生成

```java
// src\test\java\com\example\demo\GenCodeTests.java
// 1) 指定要生成的表和位置
String basePackageName = "com.example.demo";

GenOption genOption = new GenOption();
genOption.setNeedEntity(true)
        .setNeedMapperAndController(false)
        .setNeedMenuSQL(false)
        .setNeedDBDoc(false);

if (tableNames.size() > 0) {
    tableNames.stream().forEach(tableName -> {
        // 指定要生成代码的表名
        if (StrUtil.startWith(tableName, "temp_")) {
            // 生成代码与文档
            GenCodeUtil.genCode(sqlManager, basePackageName, tableName, genOption);
        }
    });
}

// 2) 生成代码
@Test
void genCode() {

}

===
// 3) 将生成代码拖拽到合适位置
├─controller
│      UserController.java
│
├─entity
│      User.java
│
└─mapper 
       UserMapper.java
```