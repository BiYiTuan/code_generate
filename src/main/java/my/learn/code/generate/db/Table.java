package my.learn.code.generate.db;

import java.util.ArrayList;
import java.util.List;

public class Table {

	private String javaTableName;
	
	private String dbTableName;
	
//	private String pkJavaType;
//
//	public String getPkJavaType() {
//		return pkJavaType;
//	}
//
//	public void setPkJavaType(String pkJavaType) {
//		this.pkJavaType = pkJavaType;
//	}

	public String getDbTableName() {
		return dbTableName;
	}

	public void setDbTableName(String dbTableName) {
		this.dbTableName = dbTableName;
	}

	private List<Column> columns=new ArrayList<Column>();

	public String getJavaTableName() {
		return javaTableName;
	}

	public void setJavaTableName(String javaTableName) {
		this.javaTableName = javaTableName;
	}

	public List<Column> getColumns() {
		return columns;
	}




	
//	public String getUpperCaseName(){
//		return javaTableName.substring(0,1).toUpperCase()+ javaTableName.substring(1);
//	}
	

}
