package tr.unvercanunlu.pizza_store.exception.invalid;

import lombok.Getter;
import tr.unvercanunlu.pizza_store.exception.ErrorMessage;
import tr.unvercanunlu.pizza_store.model.component.Component;
import tr.unvercanunlu.pizza_store.util.ValueUtil;

public class InvalidComponentException extends RuntimeException {

  @Getter
  private final Component component;

  public InvalidComponentException(String name, Component component) {
    super(ErrorMessage.COMPONENT_INVALID.formatted(name, ValueUtil.toString(component)));

    this.component = component;
  }

}
