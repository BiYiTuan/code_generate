package my.learn.code.generate;

import java.io.File;
import java.util.List;

import my.learn.code.generate.db.DbUtils;
import my.learn.code.generate.db.Table;
import my.learn.code.generate.file.CreateFolder;
import my.learn.code.generate.file.EntityCreater;
import my.learn.code.generate.utils.GlobalsParam;
import org.apache.log4j.PropertyConfigurator;



import com.bj58.fang.wfproject.creater.myclass.AidCreater;
import com.bj58.fang.wfproject.creater.myclass.BaseEntityDAOCreater;
import com.bj58.fang.wfproject.creater.myclass.ControllerCreater;
import com.bj58.fang.wfproject.creater.myclass.CustomEntityDAO;
import com.bj58.fang.wfproject.creater.myclass.DTOCreater;

import com.bj58.fang.wfproject.creater.myclass.PomCreater;
import com.bj58.fang.wfproject.creater.myclass.ServiceCreater;

public class ScfServer {

	public static void main(String[] args) throws Throwable {
		PropertyConfigurator
				.configure("log4j.properties");
		File f = new File("SystemGlobals.properties");
		GlobalsParam.loadConfig(f);

		// 生成必要的目录结构，同时拷贝必要的文�?
		CreateFolder.createrFolder();

		
		List<Table> tablelist = DbUtils.getAllTableFromDb();
		for (Table td : tablelist) {
			// 生成实体�?
			EntityCreater.createEntity(td);
//			// 生成dao接口
			//com.bj58.fang.wfproject.creater.scfmyclass.CustomEntityDAO.createCustomDao(td);
//			// 生成dao实体
			//com.bj58.fang.wfproject.creater.scfmyclass.CustomEntityDAO.createCustomDaoImpl(td);
//			// 生成DTO
		}

		// 生成工具�?
		com.bj58.fang.wfproject.creater.scfmyclass.AidCreater.createAid();
		// 生成pom文件
		com.bj58.fang.wfproject.creater.scfmyclass.PomCreater.createPom();
		//生成serviceframe.xml
		com.bj58.fang.wfproject.creater.scfmyclass.EntityCreater.createServiceFrame(tablelist);

	}
}
