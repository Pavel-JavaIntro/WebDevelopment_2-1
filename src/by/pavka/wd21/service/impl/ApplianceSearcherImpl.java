package by.pavka.wd21.service.impl;

import by.pavka.wd21.dao.ApplianceDao;
import by.pavka.wd21.dao.DaoFactory;
import by.pavka.wd21.entity.criteria.Criterion;
import by.pavka.wd21.entity.Appliance;
import by.pavka.wd21.entity.exception.ApplianceException;
import by.pavka.wd21.service.ApplianceSearcher;
import by.pavka.wd21.service.exception.ApplianceSearcherException;
import by.pavka.wd21.service.validation.ApplianceValidator;

import java.util.List;

public class ApplianceSearcherImpl implements ApplianceSearcher {

  @Override
  public List<Appliance> find(Criterion criterion) throws ApplianceSearcherException {

    if (!ApplianceValidator.criteriaValidated(criterion)) {
      throw new ApplianceSearcherException("Request not validated");
    }
    ApplianceDao dao = DaoFactory.getInstance().getApplianceDao();
    try {
      return dao.find(criterion);
    } catch (ApplianceException e) {
      throw new ApplianceSearcherException("Exception while finding", e);
    }
  }
}
