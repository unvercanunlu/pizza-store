package tr.unvercanunlu.pizza_store.validation;

import java.util.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.exception.business.EmptyPizzaException;
import tr.unvercanunlu.pizza_store.exception.business.TooMuchToppingsException;
import tr.unvercanunlu.pizza_store.exception.invalid.InvalidComponentException;
import tr.unvercanunlu.pizza_store.exception.invalid.InvalidPizzaException;
import tr.unvercanunlu.pizza_store.exception.invalid.InvalidSizeException;
import tr.unvercanunlu.pizza_store.model.Pizza;
import tr.unvercanunlu.pizza_store.model.Size;
import tr.unvercanunlu.pizza_store.model.component.Cheese;
import tr.unvercanunlu.pizza_store.model.component.Crust;
import tr.unvercanunlu.pizza_store.model.component.Sauce;
import tr.unvercanunlu.pizza_store.model.component.Topping;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PizzaValidator {

  public static void checkSize(Size size) {
    Optional.ofNullable(size)
        .orElseThrow(() -> new InvalidSizeException(size));
  }

  public static void checkCrust(Crust crust) {
    Optional.ofNullable(crust)
        .orElseThrow(() -> new InvalidComponentException(Crust.getType(), crust));
  }

  public static void checkCheese(Cheese cheese) {
    Optional.ofNullable(cheese)
        .orElseThrow(() -> new InvalidComponentException(Cheese.getType(), cheese));
  }

  public static void checkSauce(Sauce sauce) {
    Optional.ofNullable(sauce)
        .orElseThrow(() -> new InvalidComponentException(Sauce.getType(), sauce));
  }

  public static void checkTopping(Topping topping) {
    Optional.ofNullable(topping)
        .orElseThrow(() -> new InvalidComponentException(Topping.getType(), topping));
  }

  public static void checkToppingSize(Pizza pizza) {
    if ((pizza != null) && (pizza.getToppings().size() > Config.MAX_TOPPINGS)) {
      throw new TooMuchToppingsException(pizza.getToppings());
    }
  }

  public static void checkPizzaEmpty(Pizza pizza) {
    if ((pizza != null) && (pizza.getCheese() == null) && (pizza.getSauce() == null) && pizza.getToppings().isEmpty()) {
      throw new EmptyPizzaException(pizza);
    }
  }

  public static void checkPizza(Pizza pizza) {
    try {
      checkSize(pizza.getSize());
      checkCrust(pizza.getCrust());
      checkPizzaEmpty(pizza);
      checkToppingSize(pizza);

    } catch (Exception e) {
      throw new InvalidPizzaException(e);
    }
  }

}
