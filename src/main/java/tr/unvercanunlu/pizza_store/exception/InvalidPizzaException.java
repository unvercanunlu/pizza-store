package tr.unvercanunlu.pizza_store.exception;

import tr.unvercanunlu.pizza_store.config.ErrorMessage;

public class InvalidPizzaException extends PizzaStoreException {

  public InvalidPizzaException(Throwable cause) {
    super(ErrorMessage.PIZZA_INVALID.formatted(cause.getMessage()), cause);
  }

}
