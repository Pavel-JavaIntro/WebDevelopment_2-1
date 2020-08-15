package by.pavka.wd21.dao;

import by.pavka.wd21.entity.Appliance;
import by.pavka.wd21.entity.criteria.Criterion;
import by.pavka.wd21.entity.exception.ApplianceException;

import java.util.List;

public interface ApplianceDao {

  List<Appliance> find(Criterion criterion) throws ApplianceException;
}
