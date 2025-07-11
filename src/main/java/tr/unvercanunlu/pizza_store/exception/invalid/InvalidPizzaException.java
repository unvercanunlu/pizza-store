package tr.unvercanunlu.pizza_store.exception.invalid;


import tr.unvercanunlu.pizza_store.exception.ErrorMessage;

public class InvalidPizzaException extends RuntimeException {

  public InvalidPizzaException(Throwable cause) {
    super(ErrorMessage.PIZZA_INVALID.formatted(cause.getMessage()), cause);
  }

}
