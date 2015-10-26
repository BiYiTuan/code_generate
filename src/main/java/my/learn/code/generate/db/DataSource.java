package my.learn.code.generate.db;

import my.learn.code.generate.utils.PropertiesUtils;

import java.util.Properties;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/23
 * Time: 上午11:57
 */
public class DataSource {

  private String connetionURL;
  private String driversClass;
  private String userName;
  private String password;
  private String database;

  public DataSource(Properties properties){
    PropertiesUtils propertiesUtils = new PropertiesUtils(properties);
    this.connetionURL = propertiesUtils.get("connetionURL");
    this.driversClass = propertiesUtils.get("driversClass");
    this.userName = propertiesUtils.get("userName");
    this.password = propertiesUtils.get("password");
    this.database = propertiesUtils.get("database");
  }

  public String getConnetionURL() {
    return connetionURL;
  }

  public String getDriversClass() {
    return driversClass;
  }

  public String getUserName() {
    return userName;
  }

  public String getPassword() {
    return password;
  }

  public String getDatabase() {
    return database;
  }
}
