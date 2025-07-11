package tr.unvercanunlu.pizza_store.exception.invalid;

import tr.unvercanunlu.pizza_store.config.Config;

public class PizzaNotValid extends RuntimeException {

  public PizzaNotValid(Throwable cause) {
    super(Config.ErrorDescription.NotValid.PIZZA, cause);
  }

}
