package com.innov.training.rest.dynamic.resource;

import com.innov.training.rest.dynamic.bean.DayTemperature;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

class DayTemperatureFluctuationSimulator implements Runnable{

  public DayTemperatureFluctuationSimulator(DayTemperature dayTemperature) {
    this.dayTemperature = dayTemperature;
  }

  private DayTemperature dayTemperature;


  @Override
  public void run() {
    Random random = new Random();
    boolean flip = false;
    while(true){
      int fluctuation = random.nextInt(5);
      int temperature = Integer.parseInt(dayTemperature.getCurrentTemperatureInCelsius());
      if(!flip){
        temperature += fluctuation;
        flip = true;
      }
      else{
        temperature -= fluctuation;
        flip = false;
      }
      dayTemperature.setCurrentTemperatureInCelsius(""+temperature);
      dayTemperature.setLastModifiedDate(new GregorianCalendar());
      try {
        Thread.sleep(120000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
/**
 * This class looks up the current daya temperature and also simulates the changes in temperature
 */
public class DayTemperatureLookUpresource {



   private static DayTemperature dayTemperature = new DayTemperature();

   private static boolean simulatorRunning;


  /**
   *
   * @return
   */
   public static DayTemperature getCurrentTemperature(){
     if(!simulatorRunning){
       dayTemperature.setLastModifiedDate(new GregorianCalendar());
       DayTemperatureFluctuationSimulator dayTemperatureFluctuationSimulator = new DayTemperatureFluctuationSimulator(dayTemperature);
       Thread tempFluctator = new Thread(dayTemperatureFluctuationSimulator);
       tempFluctator.start();
       simulatorRunning = true;
     }
     return dayTemperature;
   }





}
