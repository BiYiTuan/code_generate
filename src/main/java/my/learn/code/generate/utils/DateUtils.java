package my.learn.code.generate.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/23
 * Time: 下午5:06
 */
public class DateUtils {

  public static String format(Date date){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    return sdf.format(date);
  }
  public static String formatYMD(Date date){
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    return sdf.format(date);
  }

  public static String formatHMS(Date date){
    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    return sdf.format(date);
  }

}
