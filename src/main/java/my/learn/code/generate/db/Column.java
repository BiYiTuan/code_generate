package my.learn.code.generate.db;

public class Column {

	private String javaName;

	private String dbName;

	private String javaType;

	private String dbType;
	
	private String desc;

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getJavaType() {
		return javaType;
	}

	public String getJavaName() {
		return javaName;
	}

	public void setJavaName(String javaName) {
		this.javaName = javaName;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

//	private String pk = "0";
//
//
//
//
//	public String getPk() {
//		return pk;
//	}
//
//	public void setPk(String pk) {
//		this.pk = pk;
//	}
//
//	public String getUpperCol(String col){
//		return col.substring(0,1).toUpperCase()+col.substring(1);
//	}

}
