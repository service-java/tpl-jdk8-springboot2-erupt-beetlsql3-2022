package com.example.demo.util;

import com.example.demo.builder.*;
import com.example.demo.option.GenOption;
import com.example.demo.project.SimpleMavenProject;
import lombok.extern.java.Log;
import org.beetl.core.GroupTemplate;
import org.beetl.core.ReThrowConsoleErrorHandler;
import org.beetl.core.resource.FileResourceLoader;
import org.beetl.sql.core.*;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.gen.SourceBuilder;
import org.beetl.sql.gen.SourceConfig;
import org.beetl.sql.gen.simple.BaseTemplateSourceBuilder;

import java.util.ArrayList;
import java.util.List;

@Log
public class GenCodeUtil {

    public static SQLManager getDataSource(String driver, String url, String userName, String password) {
        ConnectionSource source = ConnectionSourceHelper.getSimple(driver, url, userName, password);
        // source是唯一必须的参数，其他参数都有默认值
        SQLManagerBuilder builder = new SQLManagerBuilder(source);
        // 设置NameConversion，这里数据库命名采用下划线风格，使用UnderlinedNameConversion
        builder.setNc(new UnderlinedNameConversion());
        // 设置一个拦截器，输出debug日志，包含了sql语句和执行参数，执行时间
        builder.setInters(new Interceptor[]{new DebugInterceptor()});
        // 设置数据库分隔，必须跟数据库一样
        builder.setDbStyle(new MySqlStyle());
        return builder.build();
    }

    public static void initGroupTemplate(String tplPath) {
        //指定模板文件路径，正常情况下，不需要要指定，默认在classpath:templates，但idea的环境读取不到
        GroupTemplate groupTemplate = BaseTemplateSourceBuilder.getGroupTemplate();
        String root = System.getProperty("user.dir");

        //代码模板在sql-gen，你可以指定自己的模板路径
        String templatePath = root + tplPath;
        FileResourceLoader resourceLoader = new FileResourceLoader(templatePath);
        groupTemplate.setResourceLoader(resourceLoader);
    }

    /**
     * 代码生成，生成实体，mapper代码
     */
    public static void genCode(SQLManager sqlManager, String basePackageName, String tableName, GenOption genOption) {
        List<SourceBuilder> sourceBuilder = new ArrayList<>();

        if (genOption.getNeedEntity()) {
            SourceBuilder entityBuilder = new EntitySourceBuilder();
            sourceBuilder.add(entityBuilder);
        }

        if (genOption.getNeedMapperAndController()) {
            SourceBuilder mapperBuilder = new MapperSourceBuilder();
            SourceBuilder controllerBuilder = new ControllerSourceBuilder(basePackageName);
            SourceBuilder mdSourceBuilder = new MDSourceBuilder();

            sourceBuilder.add(controllerBuilder);
            sourceBuilder.add(mapperBuilder);
            sourceBuilder.add(mdSourceBuilder);
        }

        if (genOption.getNeedMenuSQL()) {
            SourceBuilder menuSQLBuilder = new MenuSQLBuilder();
            sourceBuilder.add(menuSQLBuilder);
        }

        if (genOption.getNeedDBDoc()) {
            SourceBuilder docBuilder = new MDDocBuilder();
            sourceBuilder.add(docBuilder);
        }

        SourceConfig config = new SourceConfig(sqlManager, sourceBuilder);
        // 日期格式指定
        // config.setPreferDateType(SourceConfig.PreferDateType.LocalDate);

        // 如果有错误，抛出异常而不是继续运行
        EntitySourceBuilder.getGroupTemplate().setErrorHandler(new ReThrowConsoleErrorHandler());

        SimpleMavenProject project = new SimpleMavenProject(basePackageName);
        config.gen(tableName, project);
    }






}