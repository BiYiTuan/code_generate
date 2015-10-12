package my.learn.code.generate.file;

import java.io.File;

import my.learn.code.generate.utils.GlobalsParam;
import org.apache.commons.lang.StringUtils;


public class CreateFolder {

	public static void createrFolder() throws Exception {
       String outputfolder = GlobalsParam.getPreference("outputfolder");
        String basepackage= GlobalsParam.getPreference("basepackage");

        if (StringUtils.isBlank(outputfolder) || StringUtils.isBlank(basepackage)) return;

        String basejavafolder = GlobalsParam.getPreference("basejavafolder");
        String baseresourcesfolder= GlobalsParam.getPreference("baseresourcesfolder");
        String basewebappfolder= GlobalsParam.getPreference("basewebappfolder");
        String basetestjavafolder = GlobalsParam.getPreference("basetestjavafolder");
        String basetestresourcesfolder= GlobalsParam.getPreference("basetestresourcesfolder");

        createrFolderIfNotExist(outputfolder+"/"+basejavafolder+"/"+basejavafolder+"/"+basepackage);
        createrFolderIfNotExist(outputfolder+"/"+baseresourcesfolder);
        createrFolderIfNotExist(outputfolder+"/"+basetestjavafolder);
        createrFolderIfNotExist(outputfolder+"/"+basetestresourcesfolder);

        if (StringUtils.isNotBlank(basewebappfolder)){
            createrFolderIfNotExist(outputfolder+"/"+basewebappfolder);
        }

	}

    private static void createrFolderIfNotExist(String path) {
        String folder=path.replaceAll("\\.", "/");

        File f = new File(folder);
        if (!f.exists())
            f.mkdirs();
    }


}
