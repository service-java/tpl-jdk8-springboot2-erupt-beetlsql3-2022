package com.example.demo.builder;

import java.io.Writer;
import java.util.ArrayList;

import com.example.demo.util.ExtractFieldFnUtil;
import com.example.demo.util.LowerFirstFnUtil;
import org.beetl.core.Template;
import org.beetl.sql.gen.Attribute;
import org.beetl.sql.gen.BaseProject;
import org.beetl.sql.gen.Entity;
import org.beetl.sql.gen.SourceConfig;
import org.beetl.sql.gen.simple.BaseTemplateSourceBuilder;

public class EntitySourceBuilder extends BaseTemplateSourceBuilder {
    public static String pojoPath = "pojo.html";
    public static String pojoAliasPath = "pojoAlias.html";
    private boolean alias = false;

    public EntitySourceBuilder() {
        super("entity");
    }

    public EntitySourceBuilder(boolean alias) {
        super("entity");
        this.alias = alias;
    }

    public void generate(BaseProject project, SourceConfig config, Entity entity) {
        Template template = this.alias ? groupTemplate.getTemplate(pojoAliasPath) : groupTemplate.getTemplate(pojoPath);

        // 注册方法
        groupTemplate.registerFunction("extractField", new ExtractFieldFnUtil());

        template.binding("attrs", entity.getList());
        template.binding("className", entity.getName());
        template.binding("table", entity.getTableName());
        if (!config.isIgnoreDbCatalog()) {
            template.binding("catalog", entity.getCatalog());
        }

        template.binding("package", project.getBasePackage(this.name));
        template.binding("imports", entity.getImportPackage());
        template.binding("colsMap", entity.getTableDesc().getColsDetail());
        template.binding("comment", entity.getComment());

        ArrayList<Attribute> attrList = entity.getList();
        boolean hasLogicDel = attrList.stream().anyMatch(p -> "isDeleted".equals(p.getName()));
        template.binding("hasLogicDel", hasLogicDel);

        Writer writer = project.getWriterByName(this.name, entity.getName() + ".java");
        template.renderTo(writer);
    }
}
