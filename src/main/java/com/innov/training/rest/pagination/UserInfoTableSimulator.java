package com.innov.training.rest.pagination;

import com.innov.training.rest.pagination.hateoas.UserInfoDataHateoasHelper;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * This class simulates the UserInfor db table
 */
public class UserInfoTableSimulator {

  private org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(UserInfoTableSimulator.class);
  private UserInfoTable userInfoTable;

  private static UserInfoTableSimulator userInfoTableSimulator = new UserInfoTableSimulator();

  private static boolean warmedup;

  private UserInfoTableSimulator(){
    this.userInfoTable = new UserInfoTable();
  }


  public static List<UserInfoBean> getUserInfoData(int offset,int limit){
    if(!warmedup){
      userInfoTableSimulator.warmup();
      warmedup = true;
    }
    List<UserInfoBean> userInfoRows = new ArrayList<>();
    int size = Math.min(offset+limit,userInfoTableSimulator.userInfoTable.getRows().size() - 1);
    for(int i = offset ; i <= size ; i++){
      userInfoRows.add(userInfoTableSimulator.userInfoTable.getRows().get(i));
    }
    return userInfoRows;
  }



  public static UserInfoDataHateoasHelper getUserInfoHateoas(int offset,int limit){
    UserInfoDataHateoasHelper userInfoDataHateoasHelper = new UserInfoDataHateoasHelper();
    if(!warmedup){
      userInfoTableSimulator.warmup();
      warmedup = true;
    }
    List<UserInfoBean> userInfoRows = new ArrayList<>();
    int size = Math.min(offset+limit,userInfoTableSimulator.userInfoTable.getRows().size() - 1);
    for(int i = offset ; i <= size ; i++){
      userInfoRows.add(userInfoTableSimulator.userInfoTable.getRows().get(i));
    }
    userInfoDataHateoasHelper.setUserInfoBeans(userInfoRows);
    userInfoDataHateoasHelper.setSelf("?offset=" + offset + "&limit=" + limit);
    int prevOffset = Math.max(0,(offset - limit));
    int prevSize = Math.min((prevOffset + limit),offset);
    userInfoDataHateoasHelper.setPrev("?offset=" + prevOffset + "&limit=" + limit);
    int nextLimit = Math.min((size + limit),(userInfoTableSimulator.userInfoTable.getRows().size() - 1));
    int nextOffset = size;
    userInfoDataHateoasHelper.setNext("?offset="+nextOffset+"&limit="+limit);
    userInfoDataHateoasHelper.setTotalSize(userInfoTableSimulator.userInfoTable.getRows().size());
    userInfoDataHateoasHelper.setRowCount(userInfoRows.size());
    return userInfoDataHateoasHelper;
  }


  /**
   * Pre loads user data into memory
   *
   */
  public  void warmup(){
    ClassLoader classLoader = getClass().getClassLoader();
    //File file = new File(classLoader.getResource("/users.csv").getFile());
    //FileReader fileReader = null;
    BufferedReader bufferedReader = null;
    try {
      //fileReader = new FileReader(file);
      InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.csv");
      bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
      String line = null;
      while((line = bufferedReader.readLine()) != null){
        UserInfoBean userInfoBean = new UserInfoBean();
        userInfoBean.setRow(line);
        userInfoTable.getRows().add(userInfoBean);
      }
    } catch (IOException e){
      logger.error(e);
    } finally{
      if(bufferedReader != null){
        try {
          bufferedReader.close();
        } catch (IOException e) {
          logger.error(e);
        }
      }
      /*if(fileReader != null){
        try {
          fileReader.close();
        } catch (IOException e) {
          logger.error(e);
        }
      }*/
    }
  }

  public static void main(String[] args) {
    //quick test
    System.out.println(getUserInfoData(0,980));
  }


}
