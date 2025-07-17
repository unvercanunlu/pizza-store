package tr.unvercanunlu.pizza_store.exception;

import tr.unvercanunlu.pizza_store.config.ErrorMessage;

public class InvalidSizeException extends PizzaStoreException {

  public InvalidSizeException() {
    super(ErrorMessage.SIZE_INVALID);
  }

}
