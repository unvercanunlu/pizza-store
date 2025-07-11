package tr.unvercanunlu.pizza_store.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import lombok.Data;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Cheese;
import tr.unvercanunlu.pizza_store.constant.Crust;
import tr.unvercanunlu.pizza_store.constant.Sauce;
import tr.unvercanunlu.pizza_store.constant.Size;
import tr.unvercanunlu.pizza_store.constant.Topping;
import tr.unvercanunlu.pizza_store.validation.PizzaValidator;

@Data
public class Pizza {

  // content
  private Size size;
  private Crust crust;
  private Sauce sauce;
  private Cheese cheese;
  private final Set<Topping> toppings;

  private Pizza() {
    toppings = new HashSet<>();
  }

  // get new instance of builder
  public static PizzaBuilder builder() {
    return new PizzaBuilder();
  }

  // builder
  public static class PizzaBuilder {

    private final Pizza pizza;

    public PizzaBuilder() {
      pizza = new Pizza();

      // default values
      pizza.setSize(Config.Default.SIZE);
      pizza.setCrust(Config.Default.CRUST);
    }

    public PizzaBuilder crust(Crust crust) {
      PizzaValidator.validateSelectedCrust(crust);

      pizza.setCrust(crust);

      return this;
    }

    public PizzaBuilder sauce(Sauce sauce) {
      PizzaValidator.validateSelectedSauce(sauce);

      pizza.setSauce(sauce);

      return this;
    }

    public PizzaBuilder cheese(Cheese cheese) {
      PizzaValidator.validateSelectedCheese(cheese);

      pizza.setCheese(cheese);

      return this;
    }

    public PizzaBuilder size(Size size) {
      PizzaValidator.validateSelectedSize(size);

      pizza.setSize(size);

      return this;
    }

    public PizzaBuilder topping(Topping topping) {
      PizzaValidator.validateSelectedTopping(topping);

      pizza.getToppings().add(topping);

      PizzaValidator.validateToppingSize(pizza);

      return this;
    }

    public PizzaBuilder toppings(Topping... toppings) {
      toppings = Optional.ofNullable(toppings)
          .orElse(new Topping[0]);

      Arrays.stream(toppings)
          .forEach(this::topping);

      return this;
    }

    public Pizza build() {
      PizzaValidator.validatePizza(pizza);

      return pizza;
    }
  }

}
