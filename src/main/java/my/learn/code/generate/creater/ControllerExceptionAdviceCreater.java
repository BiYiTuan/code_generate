package my.learn.code.generate.creater;

import my.learn.code.generate.archetypes.ClazzUtils;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/23
 * Time: 下午2:21
 */
public class ControllerExceptionAdviceCreater extends AbstractCreater{


    @Override protected String getFilePath(ClazzUtils clazz) {
        return clazz.getArchetypes().getAdivcePath() + "/" + "ControllerExceptionAdvice.java";
    }

    @Override protected String getTemplate() {
        return "controllerExceptionAdvice.vm";
    }

    public static ControllerExceptionAdviceCreater getInstance(){
        return new ControllerExceptionAdviceCreater();
    }

}
