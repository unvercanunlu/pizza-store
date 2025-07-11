package tr.unvercanunlu.pizza_store.exception.business;

import lombok.Getter;
import tr.unvercanunlu.pizza_store.exception.ErrorMessage;
import tr.unvercanunlu.pizza_store.model.Pizza;
import tr.unvercanunlu.pizza_store.util.ValueUtil;

public class EmptyPizzaException extends RuntimeException {

  @Getter
  private final Pizza pizza;

  public EmptyPizzaException(Pizza pizza) {
    super(ErrorMessage.PIZZA_EMPTY.formatted(ValueUtil.toString(pizza)));

    this.pizza = pizza;
  }

}
