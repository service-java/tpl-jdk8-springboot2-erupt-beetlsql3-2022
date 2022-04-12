package com.example.demo.builder;

import org.beetl.core.Template;
import org.beetl.sql.clazz.kit.StringKit;
import org.beetl.sql.core.engine.template.Beetl;
import org.beetl.sql.core.engine.template.BeetlTemplateEngine;
import org.beetl.sql.gen.BaseProject;
import org.beetl.sql.gen.Entity;
import org.beetl.sql.gen.SourceConfig;
import org.beetl.sql.gen.simple.BaseTemplateSourceBuilder;

import java.io.Writer;

public class MDDocBuilder extends BaseTemplateSourceBuilder {
    public static String mapperTemplate = "pojoDoc.html";

    public MDDocBuilder() {
        super("doc");
    }

    public void generate(BaseProject project, SourceConfig config, Entity entity) {
        Beetl beetl = ((BeetlTemplateEngine) config.getSqlManager().getSqlTemplateEngine()).getBeetl();
        Template template = groupTemplate.getTemplate(mapperTemplate);
        template.binding("tableName", entity.getTableName());
        template.binding("comment", entity.getComment());
        template.binding("colsMap", entity.getTableDesc().getColsDetail());
        template.binding("table", entity.getTableDesc());
        String mdFileName = entity.getName() + ".md";
        Writer writer = project.getWriterByName(this.name, mdFileName);
        template.renderTo(writer);
    }
}
