package com.innov.training.rest.endurancesports.bean.athelete.store;

import com.innov.training.rest.endurancesports.bean.EnduranceSportBean;
import com.innov.training.rest.endurancesports.exception.EnduranceSportsDataStoreException;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * This class represents the store for current active endurance sports categories
 */
public class EnduranceSportsDataStore {

  private static Logger logger = Logger.getLogger(EnduranceSportsDataStore.class);

   private static Map<String,EnduranceSportBean> enduranceSportsStore = new HashMap<>();

   private static int activityIdSequence = 1;

   private EnduranceSportsDataStore(){

   }

  /**
   * List All endurance sports activities
   *
   *
   * @return
   */
   public static List<EnduranceSportBean> getAllActivities(){
     List<EnduranceSportBean> sportBeans = new ArrayList<>();
     Iterator<Map.Entry<String,EnduranceSportBean>> entryIterator = enduranceSportsStore.entrySet().iterator();
     Map.Entry<String,EnduranceSportBean> entry = null;
     while(entryIterator.hasNext()){
       entry = entryIterator.next();
       sportBeans.add(entry.getValue());
     }
     return sportBeans;
   }


  /**
   *
   * @param enduranceSportBean
   * @return
   */
   public static EnduranceSportBean addEnduranceSportsActivity(EnduranceSportBean enduranceSportBean){
     if(enduranceSportBean != null){
       String activityId = ""+activityIdSequence++;
       enduranceSportBean.setActivityId(activityId);
       enduranceSportsStore.put(activityId,enduranceSportBean);
     }
     return enduranceSportBean;
   }


  /**
   * get particula activity details
   *
   * @param activityId
   * @return
   * @throws EnduranceSportsDataStoreException
   */
   public static EnduranceSportBean getActivityDetails(String activityId)throws EnduranceSportsDataStoreException{
     EnduranceSportBean enduranceSportBean = null;
     if(enduranceSportsStore.containsKey(activityId)){
       enduranceSportBean = enduranceSportsStore.get(activityId);
     }
     else{
       throw new EnduranceSportsDataStoreException("Activity id = " + activityId + " not found ");
     }
     return enduranceSportBean;
   }


  /**
   * Delete a particular activity
   *
   *
   * @param activityId
   * @throws EnduranceSportsDataStoreException
   */
   public static void deleteActivityDetails(String activityId) throws EnduranceSportsDataStoreException {
     if(enduranceSportsStore.containsKey(activityId)){
       enduranceSportsStore.remove(activityId);
     }
     else{
       throw new EnduranceSportsDataStoreException("Activity Id = " + activityId + " not found ");
     }
   }

}
