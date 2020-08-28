package by.pavka.wd21.service.validation;

import by.pavka.wd21.entity.criteria.Criterion;
import by.pavka.wd21.entity.provider.ApplianceProvider;
import by.pavka.wd21.entity.exception.ApplianceException;
import by.pavka.wd21.service.exception.ApplianceSearcherException;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class ApplianceValidator {

  private ApplianceValidator() {}

  // I do think the static method here will not cause problems because Criterion is not a shared
  // resource and all threads will call this method independently
  public static boolean criteriaValidated(Criterion criterion) throws ApplianceSearcherException {
    ApplianceProvider provider = ApplianceProvider.getInstance();
    String name = criterion.getApplianceName();
    if (!provider.containsName(name)) {
      return false;
    }
    List<String> parameterNames;
    try {
      parameterNames = Arrays.asList(provider.getApplianceFromString(name).listParameterNames());
    } catch (ApplianceException e) {
      throw new ApplianceSearcherException("Cannot get parameter list", e);
    }
    Set<String> searchNames = criterion.getCriteria().keySet();
    return parameterNames.containsAll(searchNames);
  }
}
