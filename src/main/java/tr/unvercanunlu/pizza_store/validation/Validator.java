package tr.unvercanunlu.pizza_store.validation;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Cheese;
import tr.unvercanunlu.pizza_store.constant.Crust;
import tr.unvercanunlu.pizza_store.constant.Sauce;
import tr.unvercanunlu.pizza_store.constant.Size;
import tr.unvercanunlu.pizza_store.constant.Topping;
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
public class Validator {

  public static void validateSelectedSize(Size size) {
    if (size == null) {
      throw new SelectedSizeNotValidException(size);
    }
  }

  public static void validateSelectedCrust(Crust crust) {
    if (crust == null) {
      throw new SelectedCrustNotValidException(crust);
    }
  }

  public static void validateSelectedCheese(Cheese cheese) {
    if (cheese == null) {
      throw new SelectedCheeseNotValidException(cheese);
    }
  }

  public static void validateSelectedSauce(Sauce sauce) {
    if (sauce == null) {
      throw new SelectedSauceNotValidException(sauce);
    }
  }

  public static void validateSelectedTopping(Topping topping) {
    if (topping == null) {
      throw new SelectedToppingNotValidException(topping);
    }
  }

  public static void validateToppingSize(Pizza pizza) {
    if (pizza.getToppings().size() > Config.MAX_TOPPING) {
      throw new TooMuchToppingsException(pizza.getToppings());
    }
  }

  public static void validateSize(Size size) {
    if (size == null) {
      throw new SizeMissingException(size);
    }
  }

  public static void validateCrust(Crust crust) {
    if (crust == null) {
      throw new CrustMissingException(crust);
    }
  }

  public static void validatePizza(Pizza pizza) {
    try {
      validateSize(pizza.getSize());
      validateCrust(pizza.getCrust());
      validateToppingSize(pizza);

    } catch (Exception e) {
      throw new PizzaNotValid(e);
    }
  }

}
