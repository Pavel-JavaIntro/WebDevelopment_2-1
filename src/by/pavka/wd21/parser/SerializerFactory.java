package by.pavka.wd21.parser;

import by.pavka.wd21.parser.impl.ApplianceSerializerImpl;

public final class SerializerFactory {
  private static final SerializerFactory instance = new SerializerFactory();

  private final ApplianceSerializer serializer = new ApplianceSerializerImpl();

  private SerializerFactory() {}

  public static SerializerFactory getInstance() {
    return instance;
  }

  public ApplianceSerializer getSerializer() {
    return serializer;
  }
}
