package my.learn.code.generate.file;

import my.learn.code.generate.db.Table;
import my.learn.code.generate.utils.GlobalsParam;
import my.learn.code.generate.utils.VelocityUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class EntityCreater {

	private static String entityFilePath = null;
	static {
		// 初始化目录
		entityFilePath = GlobalsParam.getPreference("outputfolder")
				+ "/"
				+ GlobalsParam.getPreference("basejavafolder").replaceAll(
						"\\.", "/")
				+ "/"
				+ GlobalsParam.getPreference("basepackage").replaceAll("\\.",
						"/") + "/" + "entity";
		//System.out.println("file folder=" + entityFilePath);
		File f = new File(entityFilePath);
		if (!f.exists())
			f.mkdirs();

	}

	public static void createEntity(Table table) {
		try {
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("package", GlobalsParam.getPreference("basepackage"));
			hm.put("table", table);
			String entityjava = VelocityUtils.mergeTemplate(hm,
					"scfentity.vm");
			//System.out.println(entityjava);
			File f = new File(entityFilePath + "/" + table.getUpperCaseName()+"Entity.java");
			if(f.exists()){ //TODO
				return;
			}
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos,
					"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(entityjava);
			bw.flush();
			bw.close();
			fos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public static void createServiceFrame(List<Table> table) {
		try {
			Map<String, Object> hm = new HashMap<String, Object>();
			hm.put("package", GlobalsParam.getPreference("basepackage"));
			hm.put("tablelist", table);
			String entityjava = VelocityUtils.mergeTemplate(hm,
					"serviceframe.vm");
			//System.out.println(entityjava);
			File f = new File(GlobalsParam.getPreference("outputfolder") + "/serviceframe.xml");
			
			if(f.exists()){
				return;
			}
			FileOutputStream fos = new FileOutputStream(f);
			OutputStreamWriter osw = new OutputStreamWriter(fos,
					"UTF-8");
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(entityjava);
			bw.flush();
			bw.close();
			fos.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
}
