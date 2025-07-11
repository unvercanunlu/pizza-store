package tr.unvercanunlu.pizza_store.exception.business;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config.Description.BusinessError;
import tr.unvercanunlu.pizza_store.model.Pizza;

public class PizzaEmptyException extends RuntimeException {

  @Getter
  private final Pizza pizza;

  public PizzaEmptyException(Pizza pizza) {
    super(BusinessError.PIZZA_EMPTY.formatted(Objects.toString(pizza, "")));

    this.pizza = pizza;
  }

}
