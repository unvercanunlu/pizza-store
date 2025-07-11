package tr.unvercanunlu.pizza_store.service.impl;

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;
import tr.unvercanunlu.pizza_store.constant.Cheese;
import tr.unvercanunlu.pizza_store.constant.Crust;
import tr.unvercanunlu.pizza_store.constant.Sauce;
import tr.unvercanunlu.pizza_store.constant.Size;
import tr.unvercanunlu.pizza_store.constant.Topping;
import tr.unvercanunlu.pizza_store.model.Pizza;
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
    double price = 0;

    price += Optional.ofNullable(pizza)
        .map(Pizza::getCrust)
        .map(Crust::getPrice)
        .orElse(0.00);

    price += Optional.ofNullable(pizza)
        .map(Pizza::getSauce)
        .map(Sauce::getPrice)
        .orElse(0.00);

    price += Optional.ofNullable(pizza)
        .map(Pizza::getCheese)
        .map(Cheese::getPrice)
        .orElse(0.00);

    price += Optional.ofNullable(pizza)
        .map(Pizza::getToppings)
        .stream()
        .flatMap(Collection::stream)
        .filter(Objects::nonNull)
        .mapToDouble(Topping::getPrice)
        .sum();

    price *= Optional.ofNullable(pizza)
        .map(Pizza::getSize)
        .map(Size::getMultiple)
        .orElse(1.00);

    return price;
  }

}
