package tr.unvercanunlu.pizza_store.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tr.unvercanunlu.pizza_store.constant.Crust;
import tr.unvercanunlu.pizza_store.constant.Size;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Config {

  public static final int MAX_TOPPING = 10;

  // defaults
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Default {

    public static final Crust CRUST = Crust.REGULAR;
    public static final Size SIZE = Size.MEDIUM;
  }

  // error description
  @NoArgsConstructor(access = AccessLevel.PRIVATE)
  public static class Description {

    // business
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class BusinessError {

      public static final String TOPPING_TOO_MUCH = "Too much topping selected: %s";
      public static final String PIZZA_EMPTY = "Pizza empty: %s";
    }

    // missing
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class MissingError {

      public static final String CRUST = "Crust missing: %s";
      public static final String SIZE = "Size missing: %s";
    }

    // not valid
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class NotValidError {

      public static final String PIZZA = "Selected pizza not valid";
      public static final String CHEESE = "Selected cheese not valid: %s";
      public static final String CRUST = "Selected crust not valid: %s";
      public static final String SAUCE = "Selected sauce not valid: %s";
      public static final String SIZE = "Selected size not valid: %s";
      public static final String TOPPING = "Selected topping not valid: %s";
    }
  }

}
