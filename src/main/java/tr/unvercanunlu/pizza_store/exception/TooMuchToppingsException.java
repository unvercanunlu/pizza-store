package tr.unvercanunlu.pizza_store.exception;

import java.util.Arrays;
import java.util.Set;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.ErrorMessage;
import tr.unvercanunlu.pizza_store.model.component.Topping;

public class TooMuchToppingsException extends PizzaStoreException {

  @Getter
  private final Set<Topping> toppings;

  public TooMuchToppingsException(Set<Topping> toppings) {
    super(ErrorMessage.TOPPING_TOO_MUCH, toppings);

    this.toppings = toppings;
  }

}
