package com.innov.training.rest.endurancesports.bean.athelete.store;

import com.innov.training.rest.endurancesports.bean.athelete.AtheleteBean;
import com.innov.training.rest.endurancesports.bean.athelete.exception.AtheleteDataStoreException;
import com.innov.training.rest.endurancesports.exception.EnduranceSportsDataStoreException;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Created by user on 10/22/2017.
 */
public class AtheleteDataStore {

  private static Logger logger = Logger.getLogger(AtheleteDataStore.class);

  /*
  The relation is something like:
  activityId : <atheleteId : atheleteBean>
   */
  private static Map<String,Map<String,AtheleteBean>> atheleteDataStore = new HashMap<>();

  private static int atheleteIdSequence = 1;

  private AtheleteDataStore(){

  }


  /**
   * List All endurance sports activities
   *
   *
   * @return
   */
  public static List<AtheleteBean> getAllAtheletesForActivity(String activityid)throws AtheleteDataStoreException{
    List<AtheleteBean> atheleteBeans = new ArrayList<>();
    if(atheleteDataStore.containsKey(activityid)){
      Map<String,AtheleteBean> atheleteBeanMap = atheleteDataStore.get(activityid);
      Iterator<Map.Entry<String,AtheleteBean>> entryIterator = atheleteBeanMap.entrySet().iterator();
      while(entryIterator.hasNext()){
        Map.Entry<String,AtheleteBean> beanEntry = entryIterator.next();
        atheleteBeans.add(beanEntry.getValue());
      }
    }
    else{
      throw new AtheleteDataStoreException("Actvity id = " + activityid + " not found ");
    }
    return atheleteBeans;
  }


  /**
   *
   * @param atheleteBean
   * @return
   */
  public static AtheleteBean addAthelete(String activityId,AtheleteBean atheleteBean){
    if(atheleteBean != null){
      String atheleteId = ""+atheleteIdSequence++;
      atheleteBean.setAtheleteId(atheleteId);
      atheleteBean.setActivityId(activityId);
      if(atheleteDataStore.containsKey(activityId)){
        Map<String,AtheleteBean> atheleteBeanMap = atheleteDataStore.get(activityId);
        atheleteBeanMap.put(atheleteId,atheleteBean);
      }
      else{
        Map<String,AtheleteBean> atheleteBeanMap = new HashMap<>();
        atheleteBeanMap.put(atheleteId,atheleteBean);
        atheleteDataStore.put(activityId,atheleteBeanMap);
      }
    }
    return atheleteBean;
  }


  /**
   * get particular athelete details
   *
   * @param atheleteId
   * @return
   * @throws EnduranceSportsDataStoreException
   */
  public static AtheleteBean getAtheleteDetails(String activityId,String atheleteId)throws AtheleteDataStoreException{
    AtheleteBean atheleteBean = null;
    if(atheleteDataStore.containsKey(activityId)){
      Map<String,AtheleteBean> atheleteBeanMap = atheleteDataStore.get(activityId);
      if(atheleteBeanMap.containsKey(atheleteId)){
        atheleteBean = atheleteBeanMap.get(atheleteId);
      }
      else{
        throw new AtheleteDataStoreException("Athelete id = " + atheleteId + " not found ");
      }
    }
    else{
      throw new AtheleteDataStoreException("Activity id = " + activityId + " not found ");
    }
    return atheleteBean;
  }


  /**
   * Delete a particular athelete
   *
   *
   * @param atheleteId
   * @throws EnduranceSportsDataStoreException
   */
  public static void deleteAtheleteDetails(String activityId,String atheleteId) throws AtheleteDataStoreException {
    if(atheleteDataStore.containsKey(activityId)){
      Map<String,AtheleteBean> atheleteBeanMap = atheleteDataStore.get(activityId);
      if(atheleteBeanMap.containsKey(atheleteId)){
        atheleteBeanMap.remove(atheleteId);
      }
      else{
        throw new AtheleteDataStoreException("Athelete id = " + atheleteId + " not found ");
      }
    }
    else{
      throw new AtheleteDataStoreException("Activity Id = " + activityId + " not found ");
    }
  }


  /**
   *
   * @param atheleteBean
   * @return
   * @throws AtheleteDataStoreException
   */
  public static AtheleteBean updateAtheleteDetails(String activityId,String atheleteId,AtheleteBean atheleteBean)throws AtheleteDataStoreException{
    if(atheleteDataStore.containsKey(activityId)){
      Map<String,AtheleteBean> atheleteBeanMap = atheleteDataStore.get(activityId);
      if(atheleteBeanMap.containsKey(atheleteId)){
        atheleteBeanMap.put(atheleteId,atheleteBean);
      }
      else{
        throw new AtheleteDataStoreException("Athelete Id = " + atheleteId + " not found");
      }
    }
    else{
      throw new AtheleteDataStoreException("Actvity Id = " + activityId + " not found ");
    }
    return atheleteBean;
  }

}
