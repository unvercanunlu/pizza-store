package tr.unvercanunlu.pizza_store.service;

import tr.unvercanunlu.pizza_store.constant.Cheese;
import tr.unvercanunlu.pizza_store.constant.Crust;
import tr.unvercanunlu.pizza_store.constant.Sauce;
import tr.unvercanunlu.pizza_store.constant.Size;
import tr.unvercanunlu.pizza_store.constant.Topping;
import tr.unvercanunlu.pizza_store.exception.invalid.PizzaNotValid;
import tr.unvercanunlu.pizza_store.model.Pizza;

public interface IPizzaService {

  Pizza margarita(Size size) throws PizzaNotValid;

  Pizza custom(Size size, Crust crust, Sauce sauce, Cheese cheese, Topping... toppings) throws PizzaNotValid;

}
