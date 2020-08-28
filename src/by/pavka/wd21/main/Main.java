package by.pavka.wd21.main;

import by.pavka.wd21.entity.Appliance;
import by.pavka.wd21.entity.criteria.Criterion;
import by.pavka.wd21.service.ApplianceSearcher;
import by.pavka.wd21.service.ApplianceSearcherFactory;
import by.pavka.wd21.service.exception.ApplianceSearcherException;

import java.util.List;

/* Just a primitive testing class */
public class Main {

  public static void main(String[] args) {

    ApplianceSearcherFactory factory = ApplianceSearcherFactory.getInstance();
    ApplianceSearcher searcher = factory.getApplianceSearcher();

    // Valid criteria, returns non-empty list of appliances
    Criterion criterion = new Criterion("Laptop");
    criterion.add("MEMORY_ROM", "8000");
    criterion.add("OS", "Linux");
    List<Appliance> appliances;
    try {
      appliances = searcher.find(criterion);
      for (Appliance appliance : appliances) {
        PrintApplianceInfo.print(appliance);
      }
    } catch (ApplianceSearcherException e) {
      PrintApplianceInfo.print(e);
    }

    // Impossible criteria, throws exception
    Criterion falseCriterion = new Criterion("Unexisting");
    falseCriterion.add("Something", "Nothing");
    List<Appliance> appliances1;
    try {
      appliances1 = searcher.find(falseCriterion);
      for (Appliance appliance : appliances1) {
        PrintApplianceInfo.print(appliance);
      }
    } catch (ApplianceSearcherException e) {
      PrintApplianceInfo.print(e);
    }

    // Valid but returns empty list
    Criterion emptyCriterion = new Criterion("Oven");
    emptyCriterion.add("POWER_CONSUMPTION", "0.001");
    List<Appliance> appliances2;
    try {
      appliances2 = searcher.find(emptyCriterion);
      for (Appliance appliance : appliances2) {
        PrintApplianceInfo.print(appliance);
      }
    } catch (ApplianceSearcherException e) {
      PrintApplianceInfo.print(e);
    }
  }
}
