package tr.unvercanunlu.pizza_store.model.pizza;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Stream;
import lombok.Getter;
import lombok.ToString;
import tr.unvercanunlu.pizza_store.config.AppConfig;
import tr.unvercanunlu.pizza_store.model.pizza.component.Cheese;
import tr.unvercanunlu.pizza_store.model.pizza.component.Crust;
import tr.unvercanunlu.pizza_store.model.pizza.component.Sauce;
import tr.unvercanunlu.pizza_store.model.pizza.component.Topping;

@ToString
@Getter
public final class Pizza {

  private final Size size;

  // components
  private final Crust crust;
  private final Sauce sauce;
  private final Cheese cheese;
  private final Set<Topping> toppings; // unmodifiable

  private Pizza(Size size, Crust crust, Sauce sauce, Cheese cheese, Set<Topping> toppings) {
    this.size = size;
    this.crust = crust;
    this.sauce = sauce;
    this.cheese = cheese;
    this.toppings = Collections.unmodifiableSet(toppings); // defensive copy
  }

  public static PizzaBuilder builder() {
    return new PizzaBuilder();
  }

  public static class PizzaBuilder {

    private final Set<Topping> toppings;

    private Size size;
    private Crust crust;
    private Sauce sauce;
    private Cheese cheese;

    public PizzaBuilder() {
      this.toppings = new HashSet<>();

      // setting default values
      this.size = AppConfig.DEFAULT_SIZE;
      this.crust = AppConfig.DEFAULT_CRUST;
    }

    public PizzaBuilder crust(Crust crust) {
      this.crust = crust;
      return this;
    }

    public PizzaBuilder sauce(Sauce sauce) {
      this.sauce = sauce;
      return this;
    }

    public PizzaBuilder cheese(Cheese cheese) {
      this.cheese = cheese;
      return this;
    }

    public PizzaBuilder size(Size size) {
      this.size = size;
      return this;
    }

    public PizzaBuilder topping(Topping topping) {
      Optional.ofNullable(topping)
          .ifPresent(this.toppings::add);
      return this;
    }

    public PizzaBuilder toppings(Topping... toppings) {
      Stream.ofNullable(toppings)
          .flatMap(Arrays::stream)
          .forEach(this::topping);
      return this;
    }

    public Pizza build() {
      return new Pizza(size, crust, sauce, cheese, toppings);
    }
  }

}
