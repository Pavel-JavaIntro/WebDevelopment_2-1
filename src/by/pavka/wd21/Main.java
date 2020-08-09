package by.pavka.wd21;

import by.pavka.wd21.appliance.Appliance;
import by.pavka.wd21.exception.ApplianceException;
import by.pavka.wd21.service.ApplianceSearcher;
import by.pavka.wd21.service.ApplianceSerializer;

import java.util.List;

/* Just a primitive testing class */
public class Main {

  public static void main(String[] args) throws ApplianceException {
    ApplianceSearcher searcher = new ApplianceSearcher();

    List<Appliance> appliances =
        searcher.findAppliancesByParameters("TabletPC", "MEMORY_ROM", "8000");
    System.out.println("List of TabletPCs with MEMORY_ROM = 8000:");
    ApplianceSerializer serializer = new ApplianceSerializer();
    for (Appliance appliance : appliances) {
      System.out.println(serializer.serializeToString(appliance));
    }
    System.out.println();

    appliances = searcher.findAppliancesByParameters("BATTERY_CAPACITY", "3");
    System.out.println("List of Appliances with BATTERY_CAPACITY = 3:");
    for (Appliance appliance : appliances) {
      System.out.println(serializer.serializeToString(appliance));
    }
    System.out.println();

    appliances = searcher.findAppliancesByParameters("Unexisting parameter", "Nothing");
    System.out.println("List of Appliances with unexisting parameters:");
    for (Appliance appliance : appliances) {
      System.out.println(serializer.serializeToString(appliance));
    }
  }
}
