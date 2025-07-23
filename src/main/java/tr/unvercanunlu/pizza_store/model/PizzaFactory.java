package tr.unvercanunlu.pizza_store.model;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import tr.unvercanunlu.pizza_store.model.pizza.Pizza;
import tr.unvercanunlu.pizza_store.model.pizza.Size;
import tr.unvercanunlu.pizza_store.model.pizza.component.Cheese;
import tr.unvercanunlu.pizza_store.model.pizza.component.Crust;
import tr.unvercanunlu.pizza_store.model.pizza.component.Sauce;
import tr.unvercanunlu.pizza_store.model.pizza.component.Topping;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class PizzaFactory {

  public static Pizza margarita(Size size) {
    return Pizza.builder()
        .size(size)
        .crust(Crust.REGULAR)
        .sauce(Sauce.TOMATO)
        .cheese(Cheese.MOZZARELLA)
        .topping(Topping.BASIL)
        .build();
  }

  public static Pizza pepperoni(Size size) {
    return Pizza.builder()
        .size(size)
        .crust(Crust.REGULAR)
        .sauce(Sauce.TOMATO)
        .cheese(Cheese.MOZZARELLA)
        .topping(Topping.PEPPERONI)
        .build();
  }

  public static Pizza custom(Size size, Crust crust, Sauce sauce, Cheese cheese, Topping... toppings) {
    return Pizza.builder()
        .size(size)
        .crust(crust)
        .sauce(sauce)
        .cheese(cheese)
        .toppings(toppings)
        .build();
  }

}
