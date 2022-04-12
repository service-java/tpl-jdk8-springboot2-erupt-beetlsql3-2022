package com.example.demo.builder;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.example.demo.util.ExtractFieldUtil;
import org.beetl.core.Template;
import org.beetl.sql.core.engine.template.Beetl;
import org.beetl.sql.core.engine.template.BeetlTemplateEngine;
import org.beetl.sql.gen.BaseProject;
import org.beetl.sql.gen.Entity;
import org.beetl.sql.gen.SourceConfig;
import org.beetl.sql.gen.simple.BaseTemplateSourceBuilder;
import xyz.erupt.core.util.Erupts;

import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MenuSQLBuilder extends BaseTemplateSourceBuilder {
    public static String mapperTemplate = "menuSql.html";

    public MenuSQLBuilder() {
        super("db/migration");
    }

    public void generate(BaseProject project, SourceConfig config, Entity entity) {
        Beetl beetl = ((BeetlTemplateEngine) config.getSqlManager().getSqlTemplateEngine()).getBeetl();

        List<String> codeList = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            codeList.add(Erupts.generateCode());
        }

        Template template = groupTemplate.getTemplate(mapperTemplate);
        template.binding("entityClass", entity.getName());
        template.binding("tableName", entity.getTableName());
        template.binding("codeList", codeList);
        template.binding("currentDate", DateUtil.format(new Date(), "yyyy-MM-dd HH:mm:ss"));
        template.binding("comment", StrUtil.isNotEmpty(entity.getComment()) ? ExtractFieldUtil.call(entity.getComment()) : entity.getName());

        String mdFileName = "V" + DateUtil.format(new Date(), "yyyyMMddHHmmss.SSS") + "__insert_menu_" + entity.getTableName() + ".sql";
        Writer writer = project.getWriterByName(this.name, mdFileName);
        template.renderTo(writer);
    }
}
