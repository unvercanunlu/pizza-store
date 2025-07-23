package tr.unvercanunlu.pizza_store;

import tr.unvercanunlu.pizza_store.helper.CalculatePriceHelper;
import tr.unvercanunlu.pizza_store.model.PizzaFactory;
import tr.unvercanunlu.pizza_store.model.pizza.Pizza;
import tr.unvercanunlu.pizza_store.model.pizza.Size;
import tr.unvercanunlu.pizza_store.model.pizza.component.Cheese;
import tr.unvercanunlu.pizza_store.model.pizza.component.Crust;
import tr.unvercanunlu.pizza_store.model.pizza.component.Sauce;
import tr.unvercanunlu.pizza_store.model.pizza.component.Topping;
import tr.unvercanunlu.pizza_store.service.ValidationService;
import tr.unvercanunlu.pizza_store.service.impl.ValidationServiceImpl;

public class DemoApp {

  public static void main(String[] args) {
    ValidationService validator = new ValidationServiceImpl();

    // create predefined pizzas
    Pizza margarita = PizzaFactory.margarita(Size.MEDIUM);
    Pizza pepperoni = PizzaFactory.pepperoni(Size.LARGE);

    // create a custom pizza
    Pizza customPizza = PizzaFactory.custom(
        Size.LARGE,
        Crust.THICK,
        Sauce.BBQ,
        Cheese.CHEDDAR,
        Topping.PEPPERONI, Topping.CHICKEN, Topping.BASIL
    );

    // validate and print all
    validateAndPrint(margarita, validator);
    validateAndPrint(pepperoni, validator);
    validateAndPrint(customPizza, validator);
  }

  private static void validateAndPrint(Pizza pizza, ValidationService validator) {
    try {
      validator.validatePizza(pizza);

      double price = CalculatePriceHelper.calculate(pizza);

      System.out.println(
          String.format("pizza=%s price=%.2f", pizza, price)
      );

    } catch (Exception e) {
      System.out.println("Invalid pizza: " + e.getMessage());
    }
  }

}
