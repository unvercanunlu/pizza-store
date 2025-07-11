package tr.unvercanunlu.pizza_store.exception.business;

import java.util.Objects;
import java.util.Set;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Topping;

public class TooMuchToppingsException extends RuntimeException {

  @Getter
  private final Set<Topping> toppings;

  public TooMuchToppingsException(Set<Topping> toppings) {
    super(Config.ErrorDescription.Business.TOPPING_TOO_MUCH.formatted(Objects.toString(toppings, "")));

    this.toppings = toppings;
  }

}
