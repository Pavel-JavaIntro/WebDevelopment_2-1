package by.pavka.wd21.appliance;

import by.pavka.wd21.exception.ApplianceException;

public class Laptop extends Appliance {
  private static final String[] parameterNames =
      new String[] {
        "BATTERY_CAPACITY", "OS", "MEMORY_ROM", "SYSTEM_MEMORY", "CPU", "DISPLAY_INCHS"
      };

  public Laptop(String... parameterValues) throws ApplianceException {
    super(parameterValues);
  }

  @Override
  public String[] listParameterNames() {
    return parameterNames;
  }
}
