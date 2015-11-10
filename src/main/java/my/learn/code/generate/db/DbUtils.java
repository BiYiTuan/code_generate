package my.learn.code.generate.db;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;



public class DbUtils {
	private static Log log = LogFactory.getLog(DbUtils.class);

	public static Table getTableByName(String tableName,DataSource db){
		Connection conn=null;
		PreparedStatement pstmt =null;
		ResultSet rs = null;
		try {
			Class.forName(db.getDriversClass());
			 conn = DriverManager.getConnection(db.getConnetionURL(), db.getUserName(),db.getPassword());
			 pstmt = conn.prepareStatement("select column_name,data_type,column_comment from information_schema.columns where table_name =?  and TABLE_SCHEMA=?");


			pstmt.setString(1,tableName);
			pstmt.setString(2,db.getDatabase());
			Table tb = new Table();

			// System.out.println(Table.getFormatTablename(tableName));
			tb.setJavaTableName(convertName(tableName.replace("dss_","")));
			tb.setDbTableName(tableName);

			 rs = pstmt.executeQuery();


			while (rs.next()){
				Column cn = new Column();
				String dbType = rs.getString("data_type");
				cn.setDbType(dbType);
				cn.setJavaType(mysqlType2JavaType(cn.getDbType()));

				String dbName = rs.getString("column_name").toLowerCase();
				cn.setJavaName(convertName(dbName));
				cn.setDbName(dbName);

				cn.setDesc(rs.getString("column_comment"));
//				if (pkmap.containsKey(cn.getDbName())) {
//					cn.setPk("1");
//					tb.setPkJavaType(cn.getJavaType());
//				}
				tb.getColumns().add(cn);
			}

			return tb;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (pstmt != null){
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}


		return null;
	}

	private static String convertName(String column){
		String[] cls=column.split("_");
		StringBuffer sb=new StringBuffer(cls[0]);
		
		int l=cls.length;
		for(int i=1;i<l ;i++){
			sb.append(my.learn.code.generate.utils.StringUtils.firstLetterUpcase(cls[i]));
		}
		return sb.toString();
	}

	private static String mysqlType2JavaType(String mysqlType) {
		if (StringUtils.isBlank(mysqlType))
			return "";
		if ("VARCHAR".equalsIgnoreCase(mysqlType))
			return String.class.getSimpleName();
		else if ("CHAR".equalsIgnoreCase(mysqlType))
			return String.class.getSimpleName();
		else if ("BLOB".equalsIgnoreCase(mysqlType))
			return byte[].class.getSimpleName();
		else if ("TEXT".equalsIgnoreCase(mysqlType))
			return String.class.getSimpleName();
		else if ("LONGTEXT".equalsIgnoreCase(mysqlType))
			return String.class.getSimpleName();
		else if ("INT".equalsIgnoreCase(mysqlType))
			return int.class.getSimpleName();
		else if ("INTEGER".equalsIgnoreCase(mysqlType))
			return int.class.getSimpleName();
		else if ("TINYINT".equalsIgnoreCase(mysqlType))
			return short.class.getSimpleName();
		else if ("SMALLINT".equalsIgnoreCase(mysqlType))
			return int.class.getSimpleName();
		else if ("MEDIUMINT".equalsIgnoreCase(mysqlType))
			return int.class.getSimpleName();
		else if ("BIT".equalsIgnoreCase(mysqlType))
			return boolean.class.getSimpleName();
		else if ("BIGINT".equalsIgnoreCase(mysqlType))
			return long.class.getSimpleName();
		else if ("FLOAT".equalsIgnoreCase(mysqlType))
			return float.class.getSimpleName();
		else if ("DOUBLE".equalsIgnoreCase(mysqlType))
			return double.class.getSimpleName();
		else if ("DECIMAL".equalsIgnoreCase(mysqlType))
			return double.class.getSimpleName();
		else if ("BOOLEAN".equalsIgnoreCase(mysqlType))
			return short.class.getSimpleName();
		else if ("ID".equalsIgnoreCase(mysqlType))
			return long.class.getSimpleName();
		else if ("DATE".equalsIgnoreCase(mysqlType))
			return Date.class.getSimpleName();
		else if ("TIME".equalsIgnoreCase(mysqlType))
			return Date.class.getSimpleName();
		else if ("DATETIME".equalsIgnoreCase(mysqlType))
			return Date.class.getSimpleName();
		else if ("TIMESTAMP".equalsIgnoreCase(mysqlType))
			return Date.class.getSimpleName();
		else if ("YEAR".equalsIgnoreCase(mysqlType))
			return Date.class.getSimpleName();
		else if ("MEDIUMTEXT".equalsIgnoreCase(mysqlType)){
			return String.class.getSimpleName();
		}
		else
			return "";

	}


}
