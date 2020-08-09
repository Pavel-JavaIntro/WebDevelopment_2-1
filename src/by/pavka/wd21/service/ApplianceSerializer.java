package by.pavka.wd21.service;

import by.pavka.wd21.exception.ApplianceException;
import by.pavka.wd21.appliance.*;

public class ApplianceSerializer {
  private static final String NAME_DELIMITER = " : ";
  private static final String PARAMETER_DELIMITER = ", ";
  private static final String ASSIGNMENT_SIGN = "=";

  public String serializeToString(Appliance appliance) {
    if (appliance == null) {
      return null;
    }
    StringBuilder stringBuilder = new StringBuilder(appliance.name() + NAME_DELIMITER);
    String[] parameterNames = appliance.listParameterNames();
    if (parameterNames != null) {
      for (int i = 0; i < parameterNames.length; i++) {
        stringBuilder
            .append(parameterNames[i])
            .append(ASSIGNMENT_SIGN)
            .append(appliance.findValueByName(parameterNames[i]));
        if (i < parameterNames.length - 1) {
          stringBuilder.append(PARAMETER_DELIMITER);
        }
      }
    }
    return stringBuilder.toString();
  }

  public Appliance deserializeFromSpring(String applianceString) throws ApplianceException {
    if (applianceString == null) {
      return null;
    }
    String[] data = applianceString.split(NAME_DELIMITER);
    if (data.length != 2) {
      throw new ApplianceException("Wrong String format");
    }
    Appliance appliance = findApplianceType(data[0]);
    String[] properties = data[1].split(PARAMETER_DELIMITER);
    for (String property : properties) {
      setValue(appliance, property);
    }
    return appliance;
  }

  private Appliance findApplianceType(String typeString) throws ApplianceException {
    switch (typeString) {
      case "Speakers":
        return new Speaker();
      case "TabletPC":
        return new TabletPc();
      case "Laptop":
        return new Laptop();
      case "Oven":
        return new Oven();
      case "Refrigerator":
        return new Refrigerator();
      case "VacuumCleaner":
        return new VacuumCleaner();
      default:
        throw new ApplianceException("Malformed appliance type");
    }
  }

  private void setValue(Appliance appliance, String property) throws ApplianceException {
    String[] data = property.split(ASSIGNMENT_SIGN);
    if (data.length != 2) {
      throw new ApplianceException("Malformed property");
    }
    String parameter = data[0];
    String value = data[1];
    if (!appliance.hasParameter(parameter)) {
      throw new ApplianceException("Wrong parameter in the String");
    }
    appliance.assignValueForName(parameter, value);
  }
}
