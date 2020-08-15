package by.pavka.wd21.entity;

import by.pavka.wd21.entity.exception.ApplianceException;

public class Oven extends Appliance {
  private static final String[] parameterNames =
      new String[] {"POWER_CONSUMPTION", "WEIGHT", "CAPACITY", "DEPTH", "HEIGHT", "WIDTH"};

  public Oven() {}

  public Oven(String... params) throws ApplianceException {
    super(params);
  }

  @Override
  public String[] listParameterNames() {
    return parameterNames;
  }
}
