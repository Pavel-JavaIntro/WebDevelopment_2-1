package by.pavka.wd21.parser.impl;

import by.pavka.wd21.parser.ApplianceSerializer;
import by.pavka.wd21.entity.*;
import by.pavka.wd21.entity.criteria.Criterion;
import by.pavka.wd21.entity.provider.ApplianceProvider;
import by.pavka.wd21.entity.exception.ApplianceException;

import java.util.Map;

public class ApplianceSerializerImpl implements ApplianceSerializer {
  private static final String NAME_DELIMITER = " : ";
  private static final String PARAMETER_DELIMITER = ", ";
  private static final String ASSIGNMENT_SIGN = "=";

  private final ApplianceProvider applianceProvider = ApplianceProvider.getInstance();

  @Override
  public String serializeToString(Appliance appliance) {
    if (appliance == null) {
      return null;
    }
    StringBuilder stringBuilder =
        new StringBuilder(applianceProvider.getNameForClass(appliance.getClass()) + NAME_DELIMITER);
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

  @Override
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

  @Override
  public boolean conforms(String applianceString, Criterion criterion) {
    if (applianceString == null || criterion == null) {
      return false;
    }
    boolean conforming = true;
    String[] searchCriteria = criterionToStringArray(criterion);
    for (String criteria : searchCriteria) {
      if (!applianceString.contains(criteria)) {
        conforming = false;
        break;
      }
    }
    String applianceName = criterion.getApplianceName();
    if (applianceName == null || !applianceString.contains(applianceName)) {
      conforming = false;
    }
    return conforming;
  }

  private Appliance findApplianceType(String typeString) throws ApplianceException {
    return applianceProvider.getApplianceFromString(typeString);
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

  private String[] criterionToStringArray(Criterion criterion) {
    Map<String, String> criteria = criterion.getCriteria();
    String[] searchCriteria = new String[criteria.size()];
    int i = 0;
    for (Map.Entry<String, String> entry : criteria.entrySet()) {
      searchCriteria[i++] = entry.getKey() + ASSIGNMENT_SIGN + entry.getValue();
    }
    return searchCriteria;
  }
}
