package by.pavka.wd21.entity;

import by.pavka.wd21.entity.exception.ApplianceException;

public class TabletPc extends Appliance {
  private static final String[] parameterNames =
      new String[] {
        "BATTERY_CAPACITY", "DISPLAY_INCHES", "MEMORY_ROM", "FLASH_MEMORY_CAPACITY", "COLOR"
      };

  public TabletPc() {}

  public TabletPc(String... parameterValues) throws ApplianceException {
    super(parameterValues);
  }

  @Override
  public String[] listParameterNames() {
    return parameterNames;
  }
}
