package tr.unvercanunlu.pizza_store.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorMessage {

  public static final String TOPPING_TOO_MUCH = "Too much topping selected: %s";
  public static final String PIZZA_EMPTY = "Pizza empty: %s";
  public static final String PIZZA_INVALID = "Selected pizza not valid: %s";
  public static final String COMPONENT_INVALID = "Selected %s not valid: %s";
  public static final String SIZE_INVALID = "Selected size not valid: %s";

}
