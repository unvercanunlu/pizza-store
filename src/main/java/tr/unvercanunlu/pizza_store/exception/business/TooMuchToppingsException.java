package tr.unvercanunlu.pizza_store.exception.business;

import java.util.Set;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.exception.ErrorMessage;
import tr.unvercanunlu.pizza_store.model.component.Topping;
import tr.unvercanunlu.pizza_store.util.ValueUtil;

public class TooMuchToppingsException extends RuntimeException {

  @Getter
  private final Set<Topping> toppings;

  public TooMuchToppingsException(Set<Topping> toppings) {
    super(ErrorMessage.TOPPING_TOO_MUCH.formatted(ValueUtil.toString(toppings)));

    this.toppings = toppings;
  }

}
