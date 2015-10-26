package my.learn.code.generate.creater;

import my.learn.code.generate.archetypes.ClazzUtils;
import my.learn.code.generate.utils.DateUtils;
import my.learn.code.generate.utils.FileUtils;
import my.learn.code.generate.utils.VelocityUtils;
import sun.security.jca.GetInstance;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/23
 * Time: 下午2:21
 */
public class ControllerCreater extends AbstractCreater{


    @Override protected String getFilePath(ClazzUtils clazz) {
        return clazz.getArchetypes().getControllerPath() + "/" + clazz.getClassName() + "Controller.java";
    }

    @Override protected String getTemplate() {
        return "controller.vm";
    }

    public static ControllerCreater getInstance(){
        return new ControllerCreater();
    }

}
