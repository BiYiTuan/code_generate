package my.learn.code.generate.creater;

import my.learn.code.generate.archetypes.Archetypes;

import java.io.File;


public class ArchetypesCreater {

	public static void createrFolder(Archetypes archetypes) throws Exception {

    createResourcesFolder(archetypes);
    createWebappFolder(archetypes);
    createTestJavaFolder(archetypes);
    createTestResourcesFolder(archetypes);
    createMybatisXMLMapperFolder(archetypes);
    
    createControllerFolder(archetypes);
    createDaoFolder(archetypes);
    createDomainFolder(archetypes);
    createModelFolder(archetypes);
    createServiceFolder(archetypes);

	}

  private static void createMybatisXMLMapperFolder(Archetypes archetypes) {
    createFolderIfNotExist(archetypes.getMybatisXMLMapperPath());

  }

  private static void createServiceFolder(Archetypes archetypes) {
    createFolderIfNotExist(archetypes.getServicePath());
    createFolderIfNotExist(archetypes.getServicePath() + "/" + "impl");
  }

  private static void createModelFolder(Archetypes archetypes) {
    createFolderIfNotExist(archetypes.getModelPath());
  }

  private static void createDomainFolder(Archetypes archetypes) {
    createFolderIfNotExist(archetypes.getDomainPath());
  }

  private static void createDaoFolder(Archetypes archetypes) {
    createFolderIfNotExist(archetypes.getDaoPath());
  }

  private static void createControllerFolder(Archetypes archetypes) {
    createFolderIfNotExist(archetypes.getControllerPath());
  }


  private static void createResourcesFolder(Archetypes archetypes){
    createFolderIfNotExist(archetypes.getResourcesPath());
  }
  private static void createWebappFolder(Archetypes archetypes){
    createFolderIfNotExist(archetypes.getWebappPath());
  }
  private static void createTestJavaFolder(Archetypes archetypes){
    createFolderIfNotExist(archetypes.getTestJavaPath());
  }
  private static void createTestResourcesFolder(Archetypes archetypes){
    createFolderIfNotExist(archetypes.getTestResourcesPath());
  }
  

    private static void createFolderIfNotExist(String path) {
        String folder=path.replaceAll("\\.", "/");

        File f = new File(folder);
        if (!f.exists())
            f.mkdirs();
    }


}
