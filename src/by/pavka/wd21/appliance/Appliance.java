package by.pavka.wd21.appliance;

import by.pavka.wd21.exception.ApplianceException;

import java.util.HashMap;
import java.util.Map;

public abstract class Appliance {
  private final Map<String, String> parameters = new HashMap<>();

  Appliance(String... parameterValues) throws ApplianceException {
    if (parameterValues == null || parameterValues.length == 0) {
      for (String name : listParameterNames()) {
        parameters.put(name, "");
      }
    } else {
      if (listParameterNames().length != parameterValues.length) {
        throw new ApplianceException("Values number does not match parameters number");
      }
      for (int i = 0; i < parameterValues.length; i++) {
        parameters.put(listParameterNames()[i], parameterValues[i]);
      }
    }
  }

  public String name() {
    return getClass().getSimpleName();
  }

  public abstract String[] listParameterNames();

  public boolean hasParameter(String parameterName) {
    for (String name : listParameterNames()) {
      if (name.equals(parameterName)) {
        return true;
      }
    }
    return false;
  }

  public String findValueByName(String parameterName) {
    return parameters.get(parameterName);
  }

  public void assignValueForName(String parameterName, String parameterValue)
      throws ApplianceException {
    if (!parameters.containsKey(parameterName)) {
      throw new ApplianceException("Parameter name does not exist");
    }
    parameters.put(parameterName, parameterValue);
  }
}
