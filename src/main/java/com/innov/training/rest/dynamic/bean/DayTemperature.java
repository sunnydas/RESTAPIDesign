package com.innov.training.rest.dynamic.bean;

import java.util.Date;
import java.util.GregorianCalendar;

/**
 * This bean represents a rapidly changing bean
 */
public class DayTemperature {

   private String currentTemperatureInCelsius = "27";

   private GregorianCalendar lastModifiedDate;

   public String getCurrentTemperatureInCelsius() {
      return currentTemperatureInCelsius;
   }

   public void setCurrentTemperatureInCelsius(String currentTemperatureInCelsius) {
      this.currentTemperatureInCelsius = currentTemperatureInCelsius;
   }

   public GregorianCalendar getLastModifiedDate() {
      return lastModifiedDate;
   }

   @Override
   public String toString() {
      return "DayTemperature{" +
          "currentTemperatureInCelsius='" + currentTemperatureInCelsius + '\'' +
          ", lastModifiedDate=" + lastModifiedDate +
          '}';
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      DayTemperature that = (DayTemperature) o;

      if (getCurrentTemperatureInCelsius() != null ? !getCurrentTemperatureInCelsius().equals(that.getCurrentTemperatureInCelsius()) : that.getCurrentTemperatureInCelsius() != null)
         return false;
      return !(getLastModifiedDate() != null ? !getLastModifiedDate().equals(that.getLastModifiedDate()) : that.getLastModifiedDate() != null);

   }

   @Override
   public int hashCode() {
      int result = getCurrentTemperatureInCelsius() != null ? getCurrentTemperatureInCelsius().hashCode() : 0;
      result = 31 * result + (getLastModifiedDate() != null ? getLastModifiedDate().hashCode() : 0);
      return result;
   }

   public void setLastModifiedDate(GregorianCalendar lastModifiedDate) {
      this.lastModifiedDate = lastModifiedDate;
   }
}
