package by.pavka.wd21.entity.exception;

public class ApplianceException extends Exception {
  public ApplianceException() {
  }

  public ApplianceException(String message) {
    super(message);
  }

  public ApplianceException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApplianceException(Throwable cause) {
    super(cause);
  }
}
