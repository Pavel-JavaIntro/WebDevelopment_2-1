package by.pavka.wd21.dao;

import by.pavka.wd21.dao.impl.ApplianceDaoImpl;

public final class DaoFactory {
  private static final DaoFactory instance = new DaoFactory();

  private final ApplianceDao applianceDAO = new ApplianceDaoImpl();

  private DaoFactory() {}

  public ApplianceDao getApplianceDao() {
    return applianceDAO;
  }

  public static DaoFactory getInstance() {
    return instance;
  }
}
