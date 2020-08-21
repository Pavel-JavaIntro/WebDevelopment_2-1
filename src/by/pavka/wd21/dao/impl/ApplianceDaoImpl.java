package by.pavka.wd21.dao.impl;

import by.pavka.wd21.dao.ApplianceDao;
import by.pavka.wd21.dao.ApplianceSerializer;
import by.pavka.wd21.dao.SerializerFactory;
import by.pavka.wd21.entity.Appliance;
import by.pavka.wd21.entity.criteria.Criterion;
import by.pavka.wd21.entity.exception.ApplianceException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ApplianceDaoImpl implements ApplianceDao {
  private final String database = ResourceBundle.getBundle("appliance")
          .getString("pathname");

  @Override
  public List<Appliance> find(Criterion criterion) throws ApplianceException {
    List<Appliance> appliances = new ArrayList<>();
    ApplianceSerializer applianceSerializer = SerializerFactory.getInstance().getSerializer();
    try(InputStream is = getClass().getResourceAsStream(database); BufferedReader bufferedReader =
            new BufferedReader(new InputStreamReader(is))) {
        String line;
        while ((line = bufferedReader.readLine()) != null) {
          if (applianceSerializer.conforms(line, criterion)) {
            appliances.add(applianceSerializer.deserializeFromSpring(line));
          }
        }
    } catch (FileNotFoundException e) {
      throw new ApplianceException("The file not found", e);
    } catch (IOException e) {
      throw new ApplianceException("The file cannot be read", e);
    }
    return appliances;
  }
}
