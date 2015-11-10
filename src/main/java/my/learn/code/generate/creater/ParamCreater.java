package my.learn.code.generate.creater;

import my.learn.code.generate.archetypes.ClazzUtils;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/11/9
 * Time:下午6:02
 */
public class ParamCreater extends AbstractCreater{

    @Override protected String getFilePath(ClazzUtils clazz) {
        return clazz.getArchetypes().getParamPath() + "/" + clazz.getClassName() + "Param.java";
    }

    @Override protected String getTemplate() {
        return  "param.vm";
    }

    public static ParamCreater getInstance(){
        return new ParamCreater();
    }
}
