package tr.unvercanunlu.pizza_store.validation;

import java.util.Optional;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Cheese;
import tr.unvercanunlu.pizza_store.constant.Crust;
import tr.unvercanunlu.pizza_store.constant.Sauce;
import tr.unvercanunlu.pizza_store.constant.Size;
import tr.unvercanunlu.pizza_store.constant.Topping;
import tr.unvercanunlu.pizza_store.exception.business.PizzaEmptyException;
import tr.unvercanunlu.pizza_store.exception.business.TooMuchToppingsException;
import tr.unvercanunlu.pizza_store.exception.invalid.PizzaNotValid;
import tr.unvercanunlu.pizza_store.exception.invalid.SelectedCheeseNotValidException;
import tr.unvercanunlu.pizza_store.exception.invalid.SelectedCrustNotValidException;
import tr.unvercanunlu.pizza_store.exception.invalid.SelectedSauceNotValidException;
import tr.unvercanunlu.pizza_store.exception.invalid.SelectedSizeNotValidException;
import tr.unvercanunlu.pizza_store.exception.invalid.SelectedToppingNotValidException;
import tr.unvercanunlu.pizza_store.exception.missing.CrustMissingException;
import tr.unvercanunlu.pizza_store.exception.missing.SizeMissingException;
import tr.unvercanunlu.pizza_store.model.Pizza;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PizzaValidator {

  public static void validateSelectedSize(Size size) {
    Optional.ofNullable(size)
        .orElseThrow(() -> new SelectedSizeNotValidException(size));
  }

  public static void validateSelectedCrust(Crust crust) {
    Optional.ofNullable(crust)
        .orElseThrow(() -> new SelectedCrustNotValidException(crust));
  }

  public static void validateSelectedCheese(Cheese cheese) {
    Optional.ofNullable(cheese)
        .orElseThrow(() -> new SelectedCheeseNotValidException(cheese));
  }

  public static void validateSelectedSauce(Sauce sauce) {
    Optional.ofNullable(sauce)
        .orElseThrow(() -> new SelectedSauceNotValidException(sauce));
  }

  public static void validateSelectedTopping(Topping topping) {
    Optional.ofNullable(topping)
        .orElseThrow(() -> new SelectedToppingNotValidException(topping));
  }

  public static void validateSize(Size size) {
    Optional.ofNullable(size)
        .orElseThrow(() -> new SizeMissingException(size));
  }

  public static void validateCrust(Crust crust) {
    Optional.ofNullable(crust)
        .orElseThrow(() -> new CrustMissingException(crust));
  }

  public static void validateToppingSize(Pizza pizza) {
    if ((pizza != null) && (pizza.getToppings().size() > Config.MAX_TOPPING)) {
      throw new TooMuchToppingsException(pizza.getToppings());
    }
  }

  public static void validatePizzaEmpty(Pizza pizza) {
    if ((pizza != null) && (pizza.getCheese() == null) && (pizza.getSauce() == null) && pizza.getToppings().isEmpty()) {
      throw new PizzaEmptyException(pizza);
    }
  }

  public static void validatePizza(Pizza pizza) {
    try {
      validateSize(pizza.getSize());
      validateCrust(pizza.getCrust());
      validateToppingSize(pizza);
      validatePizzaEmpty(pizza);

    } catch (Exception e) {
      throw new PizzaNotValid(e);
    }
  }

}
