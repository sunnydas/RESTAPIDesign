package com.innov.training.rest.tasktracker.bean.tasktracker.store;

import com.innov.training.rest.tasktracker.bean.Task;
import com.innov.training.rest.tasktracker.bean.TaskStatus;
import com.innov.training.rest.tasktracker.bean.tasktracker.store.exception.TaskStoreException;
import org.apache.log4j.Logger;

import java.util.*;

/**
 * Thsi class represents a simple naive implementation of Task store for the Task tracker service
 */
public class SimpleTaskStore {

  /**
   * logger
   */
  private static Logger logger = Logger.getLogger(SimpleTaskStore.class);


  /*
  We should ideally do this in a database backed manner but this is just an example
   */


  /**
   * This is simple counter to generated taskIds
   */
  private static int taskIdSequence = 1;

  /**
   * Tasks that are in created status
   */
  private static Map<String,Task> tasksCreatedMap = new LinkedHashMap<>();


  /**
   * Tasks that are in progress
   */
  private static Map<String,Task> tasksInProgressMap = new LinkedHashMap<>();


  /**
   * Tasks that have been completed
   */
  private static Map<String,Task> tasksCompletedMap = new LinkedHashMap<>();


  private SimpleTaskStore(){

  }


  /**
   *
   * @param task
   * @return
   */
  public static synchronized Task createTask(Task task)throws TaskStoreException{
    if(task != null){
      if(task.getTaskId() == null){
        String taskId = ""+(taskIdSequence++);
        task.setTaskId(taskId);
        task.setTaskStatus(TaskStatus.CREATED);
        tasksCreatedMap.put(taskId,task);
      }
      else{
        throw new TaskStoreException("Task Id cannot be user generated during add task operation");
      }
    }
    return task;
  }


  /**
   *
   * @param taskId
   * @return
   * @throws TaskStoreException
   */
  public static synchronized Task getTask(String taskId) throws TaskStoreException{
    Task task = null;
    if(taskId != null && !taskId.trim().equals("")){
      boolean mapLocationForTask = false;
      /*
      A task can be in only one map at a partiulcar moment of time
       */
      if(tasksCreatedMap.containsKey(taskId)){
        mapLocationForTask = true;
        task  = tasksCreatedMap.get(taskId);
      }
      else if(tasksInProgressMap.containsKey(taskId)){
        mapLocationForTask = true;
        task = tasksInProgressMap.get(taskId);
      }
      else if(tasksCompletedMap.containsKey(taskId)){
        mapLocationForTask = true;
        task = tasksCompletedMap.get(taskId);
      }
      if(!mapLocationForTask){
        throw new TaskStoreException(" Task for task id = " + taskId + " not found ");
      }
    }
    else{
      throw new TaskStoreException("Invalid Task id ");
    }
    return task;
  }


  /**
   *
   * @param offset
   * @param limit
   * @param taskStatus
   *
   * @return
   */
  public static List<Task> getTasks(int offset,int limit,TaskStatus taskStatus){
    List<Task> tasks = new ArrayList<>();
    Map<String,Task> mapSelected = null;
    if(taskStatus.equals(TaskStatus.CREATED)){
      mapSelected = tasksCreatedMap;
    }
    else if(taskStatus.equals(TaskStatus.IN_PROGRESS)){
      mapSelected = tasksInProgressMap;
    }
    else if(taskStatus.equals(TaskStatus.COMPLETED)){
      mapSelected = tasksCompletedMap;
    }
    if(mapSelected != null){
      Iterator<Map.Entry<String,Task>> entryIterator = mapSelected.entrySet().iterator();
      int count = 0;
      while(entryIterator.hasNext()){
        Map.Entry<String,Task> taskEntry = entryIterator.next();
        if(count < offset){
          continue;
        }
        if(count == limit){
          break;
        }
        if(taskEntry != null) {
          tasks.add(taskEntry.getValue());
        }
        count++;
      }
    }
    return tasks;
  }


  /**
   *
   * @param taskId
   * @throws TaskStoreException
   */
  public static void deleteTask(String taskId)throws TaskStoreException{
    if(taskId != null){
      boolean found = false;
      if(tasksCreatedMap.containsKey(taskId)){
        found = true;
        tasksCreatedMap.remove(taskId);
      }
      else if(tasksInProgressMap.containsKey(taskId)){
        found = true;
        tasksInProgressMap.remove(taskId);
      }
      else if(tasksCompletedMap.containsKey(taskId)){
        found = true;
        tasksCompletedMap.remove(taskId);
      }
      if(!found){
        throw new TaskStoreException("Task for task id = " + taskId + "not found");
      }
    }
    else{
      throw new TaskStoreException("Invalid task Id");
    }
  }


  /**
   *
   * @param taskId
   * @param task
   * @return
   * @throws TaskStoreException
   */
  public static Task updateTask(String taskId,Task task)throws TaskStoreException{
    if(taskId != null && !taskId.trim().equals("")){
      boolean mapLocationForTask = false;
      /*
      A task can be in only one map at a particular moment of time
       */

      if(task.getTaskStatus().equals(TaskStatus.CREATED)){
        mapLocationForTask = true;
        tasksCreatedMap.put(taskId, task);
        if(tasksInProgressMap.containsKey(taskId)){
          tasksInProgressMap.remove(taskId);
        }
        if(tasksCompletedMap.containsKey(taskId)){
          tasksCompletedMap.remove(taskId);
        }
      }
      else if(task.getTaskStatus().equals(TaskStatus.IN_PROGRESS)){
        mapLocationForTask = true;
        tasksInProgressMap.put(taskId, task);
        if(tasksCreatedMap.containsKey(taskId)){
          tasksCreatedMap.remove(taskId);
        }
        if(tasksCompletedMap.containsKey(taskId)){
          tasksCompletedMap.remove(taskId);
        }
      }
      if(task.getTaskStatus().equals(TaskStatus.COMPLETED)){
        mapLocationForTask = true;
        tasksCompletedMap.put(taskId, task);
        if(tasksCreatedMap.containsKey(taskId)){
          tasksCreatedMap.remove(taskId);
        }
        if(tasksInProgressMap.containsKey(taskId)){
          tasksInProgressMap.remove(taskId);
        }
      }
      if(!mapLocationForTask){
        throw new TaskStoreException(" Task for task id = " + taskId + " not found ");
      }
    }
    else{
      throw new TaskStoreException("Invalid Task id ");
    }
    return task;
  }




}
