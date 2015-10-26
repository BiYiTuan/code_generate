package my.learn.code.generate.utils;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/23
 * Time: 下午6:05
 */
public class FileUtils {

  public static File getFile(String path) throws FileNotFoundException {
    int end = path.lastIndexOf(".");
   path =  path.substring(0,end).replaceAll("\\.", "/") + path.substring(end);

    return new File(path);

  }

}
