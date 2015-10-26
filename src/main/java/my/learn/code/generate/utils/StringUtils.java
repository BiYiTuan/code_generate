package my.learn.code.generate.utils;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/26
 * Time: 上午9:46
 */
public class StringUtils {

  public static String firstLetterUpcase(String str){
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }
}
