package by.pavka.wd21.main;

import by.pavka.wd21.dao.SerializerFactory;
import by.pavka.wd21.entity.Appliance;

public class PrintApplianceInfo {

  public static void print(Appliance appliance) {
    System.out.println(appliance);
    // I know this looks like a violation of the standard pattern. This is only to check output
    System.out.println(SerializerFactory.getInstance().getSerializer().serializeToString(appliance));

  }

  public static void print(Exception e) {
    System.out.println("THROWN EXCEPTION: ");
    e.printStackTrace();
  }
}
