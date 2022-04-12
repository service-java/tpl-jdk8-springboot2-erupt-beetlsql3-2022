package com.example.demo.project;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.beetl.sql.gen.BaseProject;

public class SimpleMavenProject extends BaseProject {
    String basePackage = null;

    public SimpleMavenProject(String basePackage) {
        this.basePackage = basePackage;
    }

    public SimpleMavenProject() {
        this.basePackage = "com.beetlsqlcodegen.demo";
    }

    public Writer getWriterByName(String sourceBuilderName, String targetName) {
        String home = this.root;
        FileWriter writer = null;
        String src;
        String output;
        if (sourceBuilderName.equals("mdsql") || sourceBuilderName.equals("db/migration") || sourceBuilderName.equals("doc")) {
            src = this.root + File.separator + "src/main/resources/" + sourceBuilderName;
            output = src + File.separator + targetName;

            try {
                this.checkFile(output);
                writer = new FileWriter(new File(output));
            } catch (IOException var11) {
                throw new IllegalArgumentException(output);
            }
        } else {
            src = this.root + File.separator + "src/main/java";
            output = this.getBasePackage(sourceBuilderName);
            String subPath = output.replace('.', File.separatorChar);
            output = src + File.separator + subPath + File.separator + targetName;

            try {
                this.checkFile(output);
                writer = new FileWriter(new File(output));
            } catch (IOException var10) {
                throw new IllegalArgumentException(output, var10);
            }
        }

        return writer;
    }

    public String getBasePackage(String sourceBuilerName) {
        return this.basePackage + "." + sourceBuilerName;
    }

    protected void checkFile(String filePath) throws IOException {
        File file = new File(filePath);
        File fileParent = file.getParentFile();
        if (!fileParent.exists()) {
            fileParent.mkdirs();
        }

        if (!file.exists()) {
            file.createNewFile();
        }

    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
