package my.learn.code.generate.creater;

import my.learn.code.generate.archetypes.ClazzUtils;
import my.learn.code.generate.utils.DateUtils;
import my.learn.code.generate.utils.FileUtils;
import my.learn.code.generate.utils.VelocityUtils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/23
 * Time: 下午2:20
 */
public class DaoCreater extends AbstractCreater{

  @Override protected String getFilePath(ClazzUtils clazz) {
    return clazz.getArchetypes().getDaoPath() + "/" + clazz.getClassName() + "Dao.java";
  }

  @Override protected String getTemplate() {
    return  "dao.vm";
  }

  public static DaoCreater getInstance(){
    return new DaoCreater();
  }
}
