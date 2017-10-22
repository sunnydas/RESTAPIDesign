package com.innov.training.rest.users.store;

import com.innov.training.rest.users.bean.SimpleUserBean;
import com.innov.training.rest.users.store.exception.SimpleUserStoreException;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * This class represents a simple user store to be used by the user service.
 */
public class SimpleUserStore {

  private static Logger logger = Logger.getLogger(SimpleUserStore.class);


  /**
   * The actual in memory non durable store
   */
  private static Map<String,SimpleUserBean> simpleUserBackingStore = new HashMap<>();

  private static int userIDSequence = 1;


  private SimpleUserStore(){

  }


  /**
   * Add user to store after generating user id
   *
   *
   * @param simpleUserBean
   * @return
   *
   */
  public static SimpleUserBean addUserToStore(SimpleUserBean simpleUserBean){
    if(simpleUserBean != null){
      String userId = ""+(userIDSequence++);
      simpleUserBean.setUserId(userId);
      simpleUserBackingStore.put(userId,simpleUserBean);
    }
    return simpleUserBean;
  }


  /**
   *  Get all current users in store.
   * @return
   */
  public static List<SimpleUserBean> getAllUsers(){
    List<SimpleUserBean> users = new ArrayList<>();
    Map.Entry<String,SimpleUserBean> simpleUserBeanEntry = null;
    Iterator<Map.Entry<String,SimpleUserBean>> entryIterator = simpleUserBackingStore.entrySet().iterator();
    while(entryIterator.hasNext()){
      simpleUserBeanEntry = entryIterator.next();
      users.add(simpleUserBeanEntry.getValue());
    }
    return users;
  }


  /**
   * get particular user
   *
   *
   * @param userId
   * @return
   */
  public static SimpleUserBean getUser(String userId){
    SimpleUserBean simpleUserBean = null;
    //System.out.println(simpleUserBackingStore);
    logger.info(simpleUserBackingStore);
    if(simpleUserBackingStore.containsKey(userId)){
      simpleUserBean = simpleUserBackingStore.get(userId);
    }
    return simpleUserBean;
  }


  /**
   * Delete a particular user
   *
   * @param userId
   * @throws SimpleUserStoreException
   */
  public static void deleteUser(String userId)throws SimpleUserStoreException{
    if(simpleUserBackingStore.containsKey(userId)){
      simpleUserBackingStore.remove(userId);
    }
    else{
      throw new SimpleUserStoreException("useriD = " + userId + " not found");
    }
  }


  /**
   * Update a particular user
   *
   *
   * @param userId
   * @throws SimpleUserStoreException
   */
  public static SimpleUserBean updateUser(String userId,SimpleUserBean simpleUserBean) throws SimpleUserStoreException {
    if(simpleUserBackingStore.containsKey(userId)){
      simpleUserBackingStore.put(userId,simpleUserBean);
    }
    else{
      throw new SimpleUserStoreException("useriD = " + userId + " not found");
    }
    return simpleUserBean;
  }

}
