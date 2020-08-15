package by.pavka.wd21.main;

import by.pavka.wd21.entity.Appliance;

public class PrintApplianceInfo {

  public static void print(Appliance appliance) {
    System.out.println(appliance);
  }

  public static void print(Exception e) {
    e.printStackTrace();
  }
}
