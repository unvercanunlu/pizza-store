package tr.unvercanunlu.pizza_store.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessage {

  public static final String TOPPING_TOO_MUCH = "Too much toppings selected: %s";
  public static final String PIZZA_EMPTY = "Pizza empty: %s";
  public static final String PIZZA_INVALID = "Pizza invalid: %s";
  public static final String COMPONENT_INVALID = "Component %s invalid!";
  public static final String SIZE_INVALID = "Size invalid!";

}
