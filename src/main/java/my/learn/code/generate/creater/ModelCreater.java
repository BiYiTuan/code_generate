package my.learn.code.generate.creater;

import my.learn.code.generate.archetypes.ClazzUtils;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date:15/11/9
 * Time:下午5:53
 */
public class ModelCreater extends AbstractCreater{

    @Override protected String getFilePath(ClazzUtils clazz) {
        return clazz.getArchetypes().getModelPath() + "/" + clazz.getClassName() + "Model.java";
    }

    @Override protected String getTemplate() {
        return  "model.vm";
    }

    public static ModelCreater getInstance(){
        return new ModelCreater();
    }
}
