package by.pavka.wd21.service;

import by.pavka.wd21.exception.ApplianceException;
import by.pavka.wd21.appliance.Appliance;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplianceSearcher {
  private final File database = new File("src/resources/appliances_db.txt");

  public List<Appliance> findAppliancesByParameters(
      String applianceStr, String parameterName, String parameterValue) throws ApplianceException {
    List<Appliance> appliances = new ArrayList<>();
    ApplianceSerializer serializer = new ApplianceSerializer();
    try (FileReader fileReader = new FileReader(database);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        if (line.contains(applianceStr)
            && line.contains(parameterName)
            && line.contains(parameterValue)) {
          Appliance appliance = serializer.deserializeFromSpring(line);
          appliances.add(appliance);
        }
      }
    } catch (FileNotFoundException e) {
      throw new ApplianceException("The file not found", e);
    } catch (IOException e) {
      throw new ApplianceException("The file cannot be read", e);
    }
    return appliances;
  }

  public List<Appliance> findAppliancesByParameters(String parameterName, String parameterValue)
      throws ApplianceException {
    List<Appliance> appliances = new ArrayList<>();
    ApplianceSerializer serializer = new ApplianceSerializer();
    try (FileReader fileReader = new FileReader(database);
        BufferedReader bufferedReader = new BufferedReader(fileReader)) {
      String line;
      while ((line = bufferedReader.readLine()) != null) {
        if (line.contains(parameterName) && line.contains(parameterValue)) {
          Appliance appliance = serializer.deserializeFromSpring(line);
          appliances.add(appliance);
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
