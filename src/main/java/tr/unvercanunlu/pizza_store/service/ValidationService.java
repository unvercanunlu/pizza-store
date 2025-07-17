package tr.unvercanunlu.pizza_store.service;

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

public interface ValidationService {

  void validateSize(Size size) throws InvalidSizeException;

  void validateCrust(Crust crust) throws InvalidComponentException;

  void validateCheese(Cheese cheese) throws InvalidComponentException;

  void validateSauce(Sauce sauce) throws InvalidComponentException;

  void validateTopping(Topping topping) throws InvalidComponentException;

  void validateToppingSize(Pizza pizza) throws TooMuchToppingsException;

  void validatePizza(Pizza pizza) throws InvalidPizzaException;

}
