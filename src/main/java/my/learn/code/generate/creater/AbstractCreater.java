package my.learn.code.generate.creater;

import my.learn.code.generate.archetypes.ClazzUtils;
import my.learn.code.generate.utils.DateUtils;
import my.learn.code.generate.utils.FileUtils;
import my.learn.code.generate.utils.StringUtils;
import my.learn.code.generate.utils.VelocityUtils;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Desc:
 * ------------------------------------
 * Author:zhangxiaowei03@meituan.com
 * Date: 15/10/26
 * Time: 下午8:14
 */
public abstract class AbstractCreater {

    public  void create(ClazzUtils clazz) {
        try {
            Map<String, Object> hm = new HashMap<String, Object>();

            hm.put("table", clazz.getTable());
            hm.put("date", DateUtils.formatYMD(new Date()));
            hm.put("time", DateUtils.formatHMS(new Date()));
            hm.put("clazz",clazz);
            hm.put("StringUtils",new StringUtils());


            String str = VelocityUtils.mergeTemplate(hm, getTemplate());



            File f = FileUtils
                    .getFile(getFilePath(clazz));
            if(f.exists()){ //TODO
//                   return;
            }

            org.apache.commons.io.FileUtils.write(f,str,"UTF-8");


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected abstract String getFilePath(ClazzUtils clazz);
    protected abstract String getTemplate();

}
