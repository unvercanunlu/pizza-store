package tr.unvercanunlu.pizza_store.service.impl;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import tr.unvercanunlu.pizza_store.model.Pizza;
import tr.unvercanunlu.pizza_store.model.Size;
import tr.unvercanunlu.pizza_store.model.component.Cheese;
import tr.unvercanunlu.pizza_store.model.component.Component;
import tr.unvercanunlu.pizza_store.model.component.Crust;
import tr.unvercanunlu.pizza_store.model.component.Sauce;
import tr.unvercanunlu.pizza_store.model.component.Topping;
import tr.unvercanunlu.pizza_store.service.IPizzaService;

public class PizzaService implements IPizzaService {

  @Override
  public Pizza margarita(Size size) {
    return Pizza.builder()
        .size(size)
        .crust(Crust.REGULAR)
        .sauce(Sauce.TOMATO)
        .cheese(Cheese.MOZZARELLA)
        .topping(Topping.BASIL)
        .build();
  }

  @Override
  public Pizza custom(Size size, Crust crust, Sauce sauce, Cheese cheese, Topping... toppings) {
    return Pizza.builder()
        .size(size)
        .crust(crust)
        .sauce(sauce)
        .cheese(cheese)
        .toppings(toppings)
        .build();
  }

  @Override
  public double calculatePrice(Pizza pizza) {
    if (pizza == null) {
      return 0.00;
    }

    double basePrice = Stream.of(
            Optional.ofNullable(pizza.getCrust()),
            Optional.ofNullable(pizza.getSauce()),
            Optional.ofNullable(pizza.getCheese())
        ).filter(Optional::isPresent)
        .map(Optional::get)
        .mapToDouble(Component::getPrice)
        .sum();

    double toppingsPrice = pizza.getToppings()
        .stream()
        .filter(Objects::nonNull)
        .mapToDouble(Component::getPrice)
        .sum();

    return (basePrice + toppingsPrice) * Optional.ofNullable(pizza.getSize())
        .map(Size::getPriceMultiplier)
        .orElse(1.00);
  }

}
