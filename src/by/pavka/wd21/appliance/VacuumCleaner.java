package by.pavka.wd21.appliance;

import by.pavka.wd21.exception.ApplianceException;

public class VacuumCleaner extends Appliance {
  private static final String[] parameterNames =
      new String[] {
        "POWER_CONSUMPTION",
        "FILTER_TYPE",
        "BAG_TYPE",
        "WAND_TYPE",
        "MOTOR_SPEED_REGULATION",
        "CLEANING_WIDTH"
      };

  public VacuumCleaner(String... parameterValues) throws ApplianceException {
    super(parameterValues);
  }

  @Override
  public String[] listParameterNames() {
    return parameterNames;
  }
}
