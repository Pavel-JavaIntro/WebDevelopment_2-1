package by.pavka.wd21.service.exception;

public class ApplianceSearcherException extends Exception {
  public ApplianceSearcherException() {
  }

  public ApplianceSearcherException(String message) {
    super(message);
  }

  public ApplianceSearcherException(String message, Throwable cause) {
    super(message, cause);
  }

  public ApplianceSearcherException(Throwable cause) {
    super(cause);
  }
}
