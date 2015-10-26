package my.learn.code.generate.archetypes;

import my.learn.code.generate.utils.PropertiesUtils;
import org.apache.commons.lang.StringUtils;

import java.util.Properties;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/15
 * Time: 下午8:43
 */
public class Archetypes {

    private String outputPath;
    private String defaultJavaPackage;
    private String author;

    private String javaFolder = "src.main.java";
    private String resourcesFolder = "src.main.resources";
    private String webappFolder = "src.main.webapp";
    private String testJavaFolder = "src.test.java";
    private String testResourcesFolder = "src.test.resources";

    private String daoFolder = "dao";
    /**
     * 与表映射
     */
    private String domainFolder = "domain";
    /**
     * 返回格式
     */
    private String modelFolder = "model";
    private String serviceFolder = "service";
    private String controllerFolder = "web";
    private String paramFolder = "param";

    public Archetypes(Properties config) {

        PropertiesUtils propertiesUtils = new PropertiesUtils(config);
        this.setOutputPath(propertiesUtils.get("outputFolder"));
        this.defaultJavaPackage = propertiesUtils.get("basePackage");
        this.author = propertiesUtils.get("author");

    }

    private String getOutputPath() {
        return outputPath;
    }

    private void setOutputPath(String outputPath) {
        if (StringUtils.isEmpty(outputPath))
            return;
        this.outputPath = outputPath;
    }

    private String getJavaPath() {
        return this.outputPath + "/" + this.javaFolder;
    }

    public String getResourcesPath() {
        return this.outputPath + "/" + resourcesFolder;
    }

    public String getWebappPath() {
        return this.outputPath + "/" + webappFolder;
    }

    public String getTestJavaPath() {
        return this.outputPath + "/" + testJavaFolder;
    }

    public String getTestResourcesPath() {
        return this.outputPath + "/" + testResourcesFolder;
    }

    private String getDefaultJavaPackagePath() {
        return this.getJavaPath() + "/" + this.defaultJavaPackage;
    }

    public String getDaoPath() {
        return this.getDefaultJavaPackagePath() + "/" + daoFolder;
    }

    public String getDomainPath() {
        return this.getDefaultJavaPackagePath() + "/" + domainFolder;
    }

    public String getModelPath() {
        return this.getDefaultJavaPackagePath() + "/" + modelFolder;
    }

    public String getServicePath() {

        return this.getDefaultJavaPackagePath() + "/" + serviceFolder;
    }

    public String getControllerPath() {

        return this.getDefaultJavaPackagePath() + "/" + controllerFolder;
    }

    public String getMybatisXMLMapperPath() {
        return this.getResourcesPath() + "/base/dao/xmlMapper";
    }

    public String getDefaultJavaPackage() {
        return defaultJavaPackage;
    }

    public String getDaoFolder() {
        return daoFolder;
    }

    public String getDomainFolder() {
        return domainFolder;
    }

    public String getModelFolder() {
        return modelFolder;
    }

    public String getServiceFolder() {
        return serviceFolder;
    }

    public String getControllerFolder() {
        return controllerFolder;
    }

    public String getParamFolder() {
        return paramFolder;
    }

    public String getParamPath() {
        return this.getDefaultJavaPackagePath() + this.paramFolder;
    }

    public String getAuthor() {
        return author;
    }
}
