package tr.unvercanunlu.pizza_store.exception;

import java.util.Set;
import java.util.stream.Collectors;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.ErrorMessage;
import tr.unvercanunlu.pizza_store.model.pizza.component.Topping;

public class TooMuchToppingsException extends PizzaStoreException {

  @Getter
  private final Set<Topping> toppings;

  public TooMuchToppingsException(Set<Topping> toppings) {
    super(ErrorMessage.TOPPINGS_TOO_MUCH, toppings.stream().map(Topping::name).collect(Collectors.joining(", ")));

    this.toppings = toppings;
  }

}
