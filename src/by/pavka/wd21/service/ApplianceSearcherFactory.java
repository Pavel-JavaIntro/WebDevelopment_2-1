package by.pavka.wd21.service;

import by.pavka.wd21.service.impl.ApplianceSearcherImpl;

public class ApplianceSearcherFactory {
  private static final ApplianceSearcherFactory instance = new ApplianceSearcherFactory();

  private final ApplianceSearcher applianceSearcher = new ApplianceSearcherImpl();

  private ApplianceSearcherFactory() {}

  public static ApplianceSearcherFactory getInstance() {
    return instance;
  }

  public ApplianceSearcher getApplianceSearcher() {
    return applianceSearcher;
  }
}
