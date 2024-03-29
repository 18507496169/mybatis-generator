package com.xx.mybatis.generator;

import com.xx.mybatis.generator.bean.GeneratorConfig;

public class CodeGenerator {

    public static void main(String[] args) {

        String[] tableList = {"xm_banner_config"};

        for (String tableName : tableList) {
            String DB_URL = "jdbc:mysql://172.16.18.21:3306/xiaoman_saas?createDatabaseIfNotExist=true&useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull&allowMultiQueries=true&connectTimeout=5000&socketTimeout=60000";
            String user = "superman";
            String pwd = "3xBasjDl@iJA3T@$c-u3zLZvZWia49a4";

            GeneratorConfig config = new GeneratorConfig(DB_URL, user, pwd);
            config.setDaoPackage("com.xx.mybatis.generator.mapper");
            config.setDOpackage("com.xx.mybatis.generator.domain");
            config.setXmlLocation("src/main/resources/");
            config.setTableCatalog("xiaoman_saas");
            config.setTableName(tableName);
            config.setTablePrefix("xm");
            config.setModuleName("");

            MybatisGenerator.genCode(config);
        }

    }
}
