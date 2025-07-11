package tr.unvercanunlu.pizza_store.service.impl;

import tr.unvercanunlu.pizza_store.constant.Cheese;
import tr.unvercanunlu.pizza_store.constant.Crust;
import tr.unvercanunlu.pizza_store.constant.Sauce;
import tr.unvercanunlu.pizza_store.constant.Size;
import tr.unvercanunlu.pizza_store.constant.Topping;
import tr.unvercanunlu.pizza_store.exception.invalid.PizzaNotValid;
import tr.unvercanunlu.pizza_store.model.Pizza;
import tr.unvercanunlu.pizza_store.service.IPizzaService;

public class PizzaService implements IPizzaService {

  // predefined pizza
  @Override
  public Pizza margarita(Size size) throws PizzaNotValid {
    try {
      return Pizza.builder()
          .size(size)
          .crust(Crust.REGULAR)
          .sauce(Sauce.TOMATO)
          .cheese(Cheese.MOZZARELLA)
          .topping(Topping.BASIL)
          .build();

    } catch (Exception e) {
      throw new PizzaNotValid(e);
    }
  }

  // custom
  @Override
  public Pizza custom(Size size, Crust crust, Sauce sauce, Cheese cheese, Topping... toppings) throws PizzaNotValid {
    try {
      return Pizza.builder()
          .size(size)
          .crust(crust)
          .sauce(sauce)
          .cheese(cheese)
          .toppings(toppings)
          .build();

    } catch (Exception e) {
      throw new PizzaNotValid(e);
    }
  }

}
