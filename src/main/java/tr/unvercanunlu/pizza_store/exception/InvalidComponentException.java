package tr.unvercanunlu.pizza_store.exception;

import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.ErrorMessage;

public class InvalidComponentException extends PizzaStoreException {

  @Getter
  private final String component;

  public InvalidComponentException(String component) {
    super(ErrorMessage.COMPONENT_INVALID, component);

    this.component = component;
  }

}
