package com.innov.training.rest.heavylifting.taskrunner;

import java.util.Calendar;
import java.util.Random;

/**
 * Thsi class is a simulator for long running task
 */
public class BulDataFetcher {


  /**
  Simulate long running task
   */
  public String bulkFetch(){
    StringBuilder data = new StringBuilder();
    int index = 0;
    Random random = new Random(10L);
    while(index < 10){
      data.append(Calendar.getInstance().getTime() + " " + random.nextLong());
      data.append(System.getProperty("line.separator"));
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      index++;
    }
    return data.toString();
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    //quick test
    BulDataFetcher bulDataFetcher = new BulDataFetcher();
    String data = bulDataFetcher.bulkFetch();
    System.out.println(data);
  }

}
