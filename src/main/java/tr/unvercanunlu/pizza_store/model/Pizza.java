package tr.unvercanunlu.pizza_store.model;

import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Cheese;
import tr.unvercanunlu.pizza_store.constant.Crust;
import tr.unvercanunlu.pizza_store.constant.Sauce;
import tr.unvercanunlu.pizza_store.constant.Size;
import tr.unvercanunlu.pizza_store.constant.Topping;
import tr.unvercanunlu.pizza_store.validation.Validator;

@Data
@RequiredArgsConstructor
public class Pizza {

  // content
  private Size size;
  private Crust crust;
  private Sauce sauce;
  private Cheese cheese;
  private Set<Topping> toppings = new HashSet<>();

  // price
  public double calculatePrice() {
    Validator.validatePizza(this);

    double price = 0;

    // crust
    price += crust.getPrice();

    // sauce
    if (sauce != null) {
      price += sauce.getPrice();
    }

    // cheese
    if (cheese != null) {
      price += cheese.getPrice();
    }

    // toppings
    if (toppings != null) {
      for (Topping topping : toppings) {
        // topping
        if (topping != null) {
          price += topping.getPrice();
        }
      }
    }

    // size
    price *= size.getMultiple();

    return price;
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
      Validator.validateSelectedCrust(crust);

      pizza.setCrust(crust);

      return this;
    }

    public PizzaBuilder sauce(Sauce sauce) {
      Validator.validateSelectedSauce(sauce);

      pizza.setSauce(sauce);

      return this;
    }

    public PizzaBuilder cheese(Cheese cheese) {
      Validator.validateSelectedCheese(cheese);

      pizza.setCheese(cheese);

      return this;
    }

    public PizzaBuilder size(Size size) {
      Validator.validateSelectedSize(size);

      pizza.setSize(size);

      return this;
    }

    public PizzaBuilder topping(Topping topping) {
      Validator.validateSelectedTopping(topping);

      pizza.getToppings()
          .add(topping);

      Validator.validateToppingSize(pizza);

      return this;
    }

    public PizzaBuilder toppings(Topping... toppings) {
      if (toppings != null) {
        for (Topping topping : toppings) {
          topping(topping);
        }
      }

      return this;
    }

    public Pizza build() {
      return pizza;
    }
  }

}
