package by.pavka.wd21.entity.criteria;

import java.util.HashMap;
import java.util.Map;

public class Criterion {
  private String applianceName;
  private Map<String, String> criteria = new HashMap<>();

  public Criterion(String name) {
    applianceName = name;
  }

  public String getApplianceName() {
    return applianceName;
  }

  public Map<String, String> getCriteria() {
    return criteria;
  }

  public void add(String searchCriteria, String value) {
    criteria.put(searchCriteria, value);
  }
}
