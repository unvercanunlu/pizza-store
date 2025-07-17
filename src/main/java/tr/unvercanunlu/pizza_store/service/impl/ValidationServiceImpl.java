package tr.unvercanunlu.pizza_store.service.impl;

import tr.unvercanunlu.pizza_store.config.AppConfig;
import tr.unvercanunlu.pizza_store.exception.InvalidComponentException;
import tr.unvercanunlu.pizza_store.exception.InvalidPizzaException;
import tr.unvercanunlu.pizza_store.exception.InvalidSizeException;
import tr.unvercanunlu.pizza_store.exception.TooMuchToppingsException;
import tr.unvercanunlu.pizza_store.model.Pizza;
import tr.unvercanunlu.pizza_store.model.Size;
import tr.unvercanunlu.pizza_store.model.component.Cheese;
import tr.unvercanunlu.pizza_store.model.component.Crust;
import tr.unvercanunlu.pizza_store.model.component.Sauce;
import tr.unvercanunlu.pizza_store.model.component.Topping;
import tr.unvercanunlu.pizza_store.service.ValidationService;

public class ValidationServiceImpl implements ValidationService {

  @Override
  public void validateSize(Size size) throws InvalidSizeException {
    if (size == null) {
      throw new InvalidSizeException();
    }
  }

  @Override
  public void validateCrust(Crust crust) throws InvalidComponentException {
    if (crust == null) {
      throw new InvalidComponentException(Crust.class.getSimpleName());
    }
  }

  @Override
  public void validateCheese(Cheese cheese) throws InvalidComponentException {
    if (cheese == null) {
      throw new InvalidComponentException(Cheese.class.getSimpleName());
    }
  }

  @Override
  public void validateSauce(Sauce sauce) throws InvalidComponentException {
    if (sauce == null) {
      throw new InvalidComponentException(Sauce.class.getSimpleName());
    }
  }

  @Override
  public void validateTopping(Topping topping) throws InvalidComponentException {
    if (topping == null) {
      throw new InvalidComponentException(Topping.class.getSimpleName());
    }
  }

  @Override
  public void validateToppingSize(Pizza pizza) throws TooMuchToppingsException {
    if (pizza.getToppings().size() > AppConfig.MAX_TOPPINGS) {
      throw new TooMuchToppingsException(pizza.getToppings());
    }
  }

  @Override
  public void validatePizza(Pizza pizza) throws InvalidPizzaException {
    try {

      validateSize(pizza.getSize());
      validateCrust(pizza.getCrust());
      validateToppingSize(pizza);
      validateCheese(pizza.getCheese());
      validateSauce(pizza.getSauce());

      for (Topping topping : pizza.getToppings()) {
        validateTopping(topping);
      }

    } catch (Exception e) {
      throw new InvalidPizzaException(e);
    }
  }

}
