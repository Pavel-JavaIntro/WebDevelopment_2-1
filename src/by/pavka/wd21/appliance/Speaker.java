package by.pavka.wd21.appliance;

import by.pavka.wd21.exception.ApplianceException;

public class Speaker extends Appliance{
  private static final String[] parameterNames =
      new String[] {"POWER_CONSUMPTION", "NUMBER_OF_SPEAKERS", "FREQUENCY_RANGE", "CORD_LENGTH"};

  public Speaker(String... parameterValues) throws ApplianceException {
    super(parameterValues);
  }

  @Override
  public String name() {
    return "Speakers";
  }

  @Override
  public String[] listParameterNames() {
    return parameterNames;
  }
}
