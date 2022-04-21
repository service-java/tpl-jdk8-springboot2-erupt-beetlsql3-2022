package com.example.demo;


import cn.hutool.core.util.StrUtil;
import com.example.demo.mapper.UserMapper;
import com.example.demo.option.GenOption;
import com.example.demo.util.GenCodeUtil;
import lombok.extern.java.Log;
import org.beetl.sql.core.SQLManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.Arrays;
import java.util.List;

@Log
@SpringBootTest
class GenCodeTests {

    @Value("${spring.datasource.driver-class-name}")
    String driver;
    @Value("${spring.datasource.url}")
    String url;
    @Value("${spring.datasource.username}")
    String userName;
    @Value("${spring.datasource.password}")
    String password;

    String dbName = "demo-dev";
    String tplPath = "/src/test/resources/templates/";
    String basePackageName = "com.example.demo";
//    String basePackageName = "com.beetlsqlcodegen.demo";

    @Autowired
    private UserMapper userMapper;

    @Test
    void genCode() {
        SQLManager sqlManager = GenCodeUtil.getDataSource(driver, url, userName, password);
        GenCodeUtil.initGroupTemplate(tplPath);

        List<String> tableNames = userMapper.listAllTables(dbName);

        // 指定要生成的内容
        GenOption genOption = new GenOption();
        genOption.setNeedEntity(true)
                .setNeedMapperAndController(true)
                .setNeedMenuSQL(true)
                .setNeedDBDoc(true);

        if (tableNames.size() > 0) {
            tableNames.stream().forEach(tableName -> {
                // 指定要生成代码的表名
                if (StrUtil.startWith(tableName, "temp")) {
                    // 生成代码与文档
                    GenCodeUtil.genCode(sqlManager, basePackageName, tableName, genOption);
                }
            });
        }

    }

}
