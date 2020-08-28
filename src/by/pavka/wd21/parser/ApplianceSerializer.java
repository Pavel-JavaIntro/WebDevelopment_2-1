package by.pavka.wd21.parser;

import by.pavka.wd21.entity.Appliance;
import by.pavka.wd21.entity.criteria.Criterion;
import by.pavka.wd21.entity.exception.ApplianceException;

public interface ApplianceSerializer {
  String serializeToString(Appliance appliance);
  Appliance deserializeFromSpring(String applianceString) throws ApplianceException;
  boolean conforms(String applianceString, Criterion criterion);
}
