package by.pavka.wd21.entity;

import by.pavka.wd21.entity.exception.ApplianceException;

public class Speaker extends Appliance {
  private static final String[] parameterNames =
      new String[] {"POWER_CONSUMPTION", "NUMBER_OF_SPEAKERS", "FREQUENCY_RANGE", "CORD_LENGTH"};

  public Speaker() {}

  public Speaker(String... parameterValues) throws ApplianceException {
    super(parameterValues);
  }

  @Override
  public String[] listParameterNames() {
    return parameterNames;
  }
}
