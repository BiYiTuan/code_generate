package my.learn.code.generate;

import java.io.File;
import java.util.Properties;

import my.learn.code.generate.creater.*;
import my.learn.code.generate.db.DataSource;
import my.learn.code.generate.db.DbUtils;
import my.learn.code.generate.db.Table;
import my.learn.code.generate.archetypes.*;

import org.apache.velocity.texen.util.PropertiesUtil;

public class Main {

	public static void main(String[] args) throws Throwable {


		System.out.println(new File("log4j").getAbsolutePath());


//		PropertyConfigurator.configure("log4j.properties");

		PropertiesUtil propertiesUtil = new PropertiesUtil();
		Properties config = propertiesUtil.load("config.properties");


		Archetypes archetypes = new Archetypes(config);

		// 生成必要的目录结构
		ArchetypesCreater.createrFolder(archetypes);

		DataSource db= new DataSource(config);

		Table table = DbUtils.getTableByName("dss_notice",db);

		ClazzUtils clazz = new ClazzUtils(archetypes,table);

		DomainCreater.getInstance().create(clazz);
		DaoCreater.getInstance().create(clazz);
		MybatisXMLMapperCreater.getInstance().create(clazz);
		ServiceCreater.getInstance().create(clazz);
		ServiceImplCreater.getInstance().create(clazz);
		ControllerCreater.getInstance().create(clazz);





	}
}
