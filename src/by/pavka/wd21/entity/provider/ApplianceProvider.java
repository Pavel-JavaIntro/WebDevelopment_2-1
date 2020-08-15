package by.pavka.wd21.entity.provider;

import by.pavka.wd21.entity.*;
import by.pavka.wd21.entity.exception.ApplianceException;

import java.util.HashMap;
import java.util.Map;

public class ApplianceProvider {
  private static final ApplianceProvider instance = new ApplianceProvider();

  private final Map<String, Class<? extends Appliance>> repo = new HashMap<>();

  private ApplianceProvider() {
    repo.put("Laptop", Laptop.class);
    repo.put("Oven", Oven.class);
    repo.put("Refrigerator", Refrigerator.class);
    repo.put("Speakers", Speaker.class);
    repo.put("TabletPC", TabletPc.class);
    repo.put("VacuumCleaner", VacuumCleaner.class);
  }

  public static ApplianceProvider getInstance() {
    return instance;
  }

  public Appliance getApplianceFromString(String name) throws ApplianceException {
    try {
      return repo.get(name).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      throw new ApplianceException("Cannot create an instance", e);
    }
  }

  public String getNameForClass(Class<? extends Appliance> clazz) {
    for (String name : repo.keySet()) {
      if (repo.get(name).equals(clazz)) {
        return name;
      }
    }
    return null;
  }

  public boolean containsName(String name) {
    for (String s : repo.keySet()) {
      if (s.equals(name)) {
        return true;
      }
    }
    return false;
  }
}
