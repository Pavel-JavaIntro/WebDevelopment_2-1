package by.pavka.wd21.entity;

import by.pavka.wd21.entity.exception.ApplianceException;

public class Refrigerator extends Appliance {
  private static final String[] parameterNames =
      new String[] {
        "POWER_CONSUMPTION", "WEIGHT", "FREEZER_CAPACITY", "OVERALL_CAPACITY", "HEIGHT", "WIDTH"
      };

  public Refrigerator() {}

  public Refrigerator(String... parameterValues) throws ApplianceException {
    super(parameterValues);
  }

  @Override
  public String[] listParameterNames() {
    return parameterNames;
  }
}
