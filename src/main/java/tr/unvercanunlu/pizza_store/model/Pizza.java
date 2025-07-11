package tr.unvercanunlu.pizza_store.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;
import lombok.Data;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.model.component.Cheese;
import tr.unvercanunlu.pizza_store.model.component.Crust;
import tr.unvercanunlu.pizza_store.model.component.Sauce;
import tr.unvercanunlu.pizza_store.model.component.Topping;
import tr.unvercanunlu.pizza_store.validation.PizzaValidator;

@Data
public class Pizza {

  private Size size;
  private Crust crust;
  private Sauce sauce;
  private Cheese cheese;
  private final Set<Topping> toppings;

  private Pizza() {
    toppings = new HashSet<>();
  }

  public static PizzaBuilder builder() {
    return new PizzaBuilder();
  }

  public static class PizzaBuilder {

    private final Pizza pizza;

    public PizzaBuilder() {
      pizza = new Pizza();

      // default values
      pizza.setSize(Config.DEFAULT_SIZE);
      pizza.setCrust(Config.DEFAULT_CRUST);
    }

    public PizzaBuilder crust(Crust crust) {
      PizzaValidator.checkCrust(crust);
      pizza.setCrust(crust);
      return this;
    }

    public PizzaBuilder sauce(Sauce sauce) {
      PizzaValidator.checkSauce(sauce);
      pizza.setSauce(sauce);
      return this;
    }

    public PizzaBuilder cheese(Cheese cheese) {
      PizzaValidator.checkCheese(cheese);
      pizza.setCheese(cheese);
      return this;
    }

    public PizzaBuilder size(Size size) {
      PizzaValidator.checkSize(size);
      pizza.setSize(size);
      return this;
    }

    public PizzaBuilder topping(Topping topping) {
      PizzaValidator.checkTopping(topping);
      pizza.getToppings().add(topping);
      PizzaValidator.checkToppingSize(pizza);
      return this;
    }

    public PizzaBuilder toppings(Topping... toppings) {
      Stream.ofNullable(toppings)
          .flatMap(Arrays::stream)
          .forEach(this::topping);
      return this;
    }

    public Pizza build() {
      PizzaValidator.checkPizza(pizza);
      return pizza;
    }
  }

}
