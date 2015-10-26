package my.learn.code.generate.utils;

import java.util.Properties;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/23
 * Time: 上午10:52
 */
public class PropertiesUtils {

  private Properties properties;

  public PropertiesUtils(Properties properties){
    this.properties = properties;
  }

  public String get(String key){
    return (String) properties.get(key);
  }


}
