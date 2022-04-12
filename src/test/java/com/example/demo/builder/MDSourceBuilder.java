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

public class MDSourceBuilder extends BaseTemplateSourceBuilder {
    public static String mapperTemplate = "mapperSql.html";

    public MDSourceBuilder() {
        super("mdsql");
    }

    public void generate(BaseProject project, SourceConfig config, Entity entity) {
        Beetl beetl = ((BeetlTemplateEngine) config.getSqlManager().getSqlTemplateEngine()).getBeetl();
        Template template = groupTemplate.getTemplate(mapperTemplate);
        template.binding("tableName", entity.getTableName());
        template.binding("entityClass", entity.getName());
        template.binding("cols", entity.getCols());
        template.binding("nc", config.getSqlManager().getNc());
        template.binding("PS", beetl.getPs().getProperty("DELIMITER_PLACEHOLDER_START"));
        template.binding("PE", beetl.getPs().getProperty("DELIMITER_PLACEHOLDER_END"));
        template.binding("SS", beetl.getPs().getProperty("DELIMITER_STATEMENT_START"));
        template.binding("SE", beetl.getPs().getProperty("DELIMITER_STATEMENT_END"));
        String mdFileName = StringKit.toLowerCaseFirstOne(entity.getName()) + ".md";
        Writer writer = project.getWriterByName(this.name, mdFileName);
        template.renderTo(writer);
    }
}

