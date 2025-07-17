package tr.unvercanunlu.pizza_store.service;

import tr.unvercanunlu.pizza_store.model.Pizza;
import tr.unvercanunlu.pizza_store.model.Size;
import tr.unvercanunlu.pizza_store.model.component.Cheese;
import tr.unvercanunlu.pizza_store.model.component.Crust;
import tr.unvercanunlu.pizza_store.model.component.Sauce;
import tr.unvercanunlu.pizza_store.model.component.Topping;

public interface PizzaService {

  Pizza createMargarita(Size size);

  Pizza createCustomPizza(Size size, Crust crust, Sauce sauce, Cheese cheese, Topping... toppings);

  double calculatePrice(Pizza pizza);

}
