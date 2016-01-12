package my.learn.code.generate.archetypes;

import my.learn.code.generate.db.Column;
import my.learn.code.generate.db.Table;

/**
 * Desc:
 * Author:zhangxiaowei03
 * Date: 15/10/26
 * Time: 上午9:28
 */
public class ClazzUtils {
  private Archetypes archetypes;
  private Table table;

  private String className;

  private String insertFieldList="";
  private String insertValueList="";

  private String selectFieldList="";

  public ClazzUtils(Archetypes archetypes,Table table){
    this.archetypes = archetypes;
    this.table = table;
    this.className = table.getJavaTableName().substring(0, 1).toUpperCase()+ table.getJavaTableName().substring(1);

    for(Column column : table.getColumns()){
      insertFieldList += "," + column.getDbName();
      if ("update_time".equals(column.getDbName()) || "create_time".equals(column.getDbName())){
        insertValueList += ",now()";
      }else {
        insertValueList += ",#{" + column.getJavaName() + "}";
      }

      selectFieldList += "," + column.getDbName();
    }

    insertFieldList = insertFieldList.substring(1);
    insertValueList = insertValueList.substring(1);
    selectFieldList = selectFieldList.substring(1);


  }

  public  String getClassName(){

    return className;
  }

  public String getDomainPackage(){
    return archetypes.getDefaultJavaPackage() + "." + archetypes.getDomainFolder();
  }
  public String getDaoPackage(){
    return archetypes.getDefaultJavaPackage() + "." + archetypes.getDaoFolder();
  }
  public String getServicePackage(){
    return archetypes.getDefaultJavaPackage() + "." + archetypes.getServiceFolder();
  }
  public String getParamPackage(){
    return archetypes.getDefaultJavaPackage() + "." + archetypes.getParamFolder();
  }
  public String getControllerPackage(){
    return archetypes.getDefaultJavaPackage() + "." + archetypes.getControllerFolder();
  }
  public String getAdvicePackage(){
    return archetypes.getDefaultJavaPackage() + "." + archetypes.getAdviceFolder();
  }
  public String getModelPackage(){
    return archetypes.getDefaultJavaPackage() + "." + archetypes.getModelFolder();
  }


  public Table getTable() {
    return table;
  }

  public Archetypes getArchetypes() {
    return archetypes;
  }

  public String getInsertValueList() {
    return insertValueList;
  }

  public String getInsertFieldList() {
    return insertFieldList;
  }

  public String getSelectFieldList() {
    return selectFieldList;
  }
}
