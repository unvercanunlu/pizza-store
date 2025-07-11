package tr.unvercanunlu.pizza_store.exception.invalid;

import tr.unvercanunlu.pizza_store.config.Config.Description.NotValidError;

public class PizzaNotValid extends RuntimeException {

  public PizzaNotValid(Throwable cause) {
    super(NotValidError.PIZZA, cause);
  }

}
