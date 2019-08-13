package com.xx.mybatis.generator.code;

import com.xx.mybatis.generator.bean.GeneratorConfig;
import com.xx.mybatis.generator.bean.TableEntity;
import com.xx.mybatis.generator.freemarker.FreemarkerService;

public class SQLXmlGenerator extends AbstractGenerator{

	public SQLXmlGenerator(FreemarkerService freemarkerService, TableEntity tableEntity, GeneratorConfig config) {
		super(freemarkerService, tableEntity, config);
	}

	@Override
	public String getFTL() {
		return "sql_xml";
	}

	@Override
	public String genFileName() {
		return tableEntity.getClassName() + "Mapper.xml";
	}

	@Override
	protected String genFilePath() {
		return config.getXmlLocation();
	}
}
