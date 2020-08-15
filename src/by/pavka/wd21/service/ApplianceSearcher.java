package by.pavka.wd21.service;

import by.pavka.wd21.entity.Appliance;
import by.pavka.wd21.entity.criteria.Criterion;
import by.pavka.wd21.service.exception.ApplianceSearcherException;

import java.util.List;

public interface ApplianceSearcher {
  List<Appliance> find(Criterion criterion) throws ApplianceSearcherException;
}
