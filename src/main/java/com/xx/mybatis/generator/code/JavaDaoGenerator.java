package com.xx.mybatis.generator.code;

import com.xx.mybatis.generator.bean.GeneratorConfig;
import com.xx.mybatis.generator.bean.TableEntity;
import com.xx.mybatis.generator.freemarker.FreemarkerService;
import com.xx.mybatis.generator.utils.PathUtils;

public class JavaDaoGenerator extends AbstractGenerator{

	public JavaDaoGenerator(FreemarkerService freemarkerService, TableEntity tableEntity, GeneratorConfig config) {
		super(freemarkerService, tableEntity, config);
	}

	@Override
	public String getFTL() {
		return "java_dao";
	}

	@Override
	public String genFileName() {
		return tableEntity.getClassName() + "Mapper.java";
	}

	@Override
	protected String genFilePath() {
		return PathUtils.getPathByPackage(config.getDaoPackage(), config);
	}
}
