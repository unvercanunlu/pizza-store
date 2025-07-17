package tr.unvercanunlu.pizza_store;

import tr.unvercanunlu.pizza_store.exception.InvalidComponentException;
import tr.unvercanunlu.pizza_store.exception.InvalidPizzaException;
import tr.unvercanunlu.pizza_store.exception.InvalidSizeException;
import tr.unvercanunlu.pizza_store.exception.TooMuchToppingsException;
import tr.unvercanunlu.pizza_store.model.Pizza;
import tr.unvercanunlu.pizza_store.model.Size;
import tr.unvercanunlu.pizza_store.model.component.Cheese;
import tr.unvercanunlu.pizza_store.model.component.Crust;
import tr.unvercanunlu.pizza_store.model.component.Sauce;
import tr.unvercanunlu.pizza_store.model.component.Topping;
import tr.unvercanunlu.pizza_store.service.PizzaService;
import tr.unvercanunlu.pizza_store.service.ValidationService;
import tr.unvercanunlu.pizza_store.service.impl.PizzaServiceImpl;
import tr.unvercanunlu.pizza_store.service.impl.ValidationServiceImpl;

public class DemoApp {

  public static void main(String[] args) {
    ValidationService validationService = new ValidationServiceImpl();
    PizzaService pizzaService = new PizzaServiceImpl(validationService);

    // === VALIDATION SERVICE TESTS ===
    System.out.println("\n=== VALIDATION SERVICE TESTS ===");
    try {
      validationService.validateSize(null);
    } catch (InvalidSizeException ex) {
      System.out.println("Caught expected InvalidSizeException: " + ex.getMessage());
    }

    try {
      validationService.validateCrust(null);
    } catch (InvalidComponentException ex) {
      System.out.println("Caught expected InvalidComponentException (Crust): " + ex.getMessage());
    }

    try {
      validationService.validateCheese(null);
    } catch (InvalidComponentException ex) {
      System.out.println("Caught expected InvalidComponentException (Cheese): " + ex.getMessage());
    }

    try {
      validationService.validateSauce(null);
    } catch (InvalidComponentException ex) {
      System.out.println("Caught expected InvalidComponentException (Sauce): " + ex.getMessage());
    }

    try {
      validationService.validateTopping(null);
    } catch (InvalidComponentException ex) {
      System.out.println("Caught expected InvalidComponentException (Topping): " + ex.getMessage());
    }

    Pizza tooManyToppingsPizza = Pizza.builder()
        .crust(Crust.THICK)
        .sauce(Sauce.BBQ)
        .cheese(Cheese.CHEDDAR)
        .size(Size.LARGE)
        .toppings(
            Topping.BASIL, Topping.BACON, Topping.CHICKEN, Topping.MEAT, Topping.MUSHROOM,
            Topping.PEPPERONI, Topping.SAUSAGE, Topping.BASIL, Topping.BACON, Topping.CHICKEN, Topping.MEAT
        )
        .build();
    try {
      validationService.validateToppingSize(tooManyToppingsPizza);
    } catch (TooMuchToppingsException ex) {
      System.out.println("Caught expected TooMuchToppingsException: " + ex.getMessage());
    }

    // === PIZZA SERVICE TESTS ===
    System.out.println("\n=== PIZZA SERVICE TESTS ===");

    // 1. Create a Margarita
    try {
      Pizza margarita = pizzaService.createMargarita(Size.MEDIUM);
      System.out.println("Created Margarita: " + margarita);
      double price = pizzaService.calculatePrice(margarita);
      System.out.println("Margarita price: " + price);
    } catch (Exception ex) {
      System.out.println("Unexpected exception for Margarita: " + ex.getMessage());
    }

    // 2. Create a custom pizza (valid)
    try {
      Pizza customPizza = pizzaService.createCustomPizza(
          Size.LARGE,
          Crust.THIN,
          Sauce.BBQ,
          Cheese.GOUDA,
          Topping.BACON, Topping.PEPPERONI, Topping.MEAT
      );
      System.out.println("Created custom pizza: " + customPizza);
      System.out.println("Custom pizza price: " + pizzaService.calculatePrice(customPizza));
    } catch (Exception ex) {
      System.out.println("Unexpected exception for custom pizza: " + ex.getMessage());
    }

    // 3. Create a pizza with invalid size
    try {
      pizzaService.createCustomPizza(
          null, // Invalid size
          Crust.THICK,
          Sauce.TOMATO,
          Cheese.MOZZARELLA,
          Topping.SAUSAGE
      );
    } catch (InvalidPizzaException ex) {
      System.out.println("Caught expected InvalidPizzaException (invalid size): " + ex.getMessage());
    }

    // 4. Create a pizza with null crust
    try {
      pizzaService.createCustomPizza(
          Size.SMALL,
          null, // Invalid crust
          Sauce.TOMATO,
          Cheese.MOZZARELLA,
          Topping.BASIL
      );
    } catch (InvalidPizzaException ex) {
      System.out.println("Caught expected InvalidPizzaException (null crust): " + ex.getMessage());
    }

    // 5. Create a pizza with too many toppings
    try {
      pizzaService.createCustomPizza(
          Size.LARGE,
          Crust.THICK,
          Sauce.BBQ,
          Cheese.CHEDDAR,
          Topping.BASIL, Topping.BACON, Topping.CHICKEN, Topping.MEAT, Topping.MUSHROOM,
          Topping.PEPPERONI, Topping.SAUSAGE, Topping.BASIL, Topping.BACON, Topping.CHICKEN, Topping.MEAT
      );
    } catch (InvalidPizzaException ex) {
      System.out.println("Caught expected InvalidPizzaException (too many toppings): " + ex.getMessage());
    }

    // 6. Try calculating price with null pizza
    System.out.println("Null pizza price: " + pizzaService.calculatePrice(null));

    // 7. Create a pizza with no cheese, sauce or toppings (should throw on validation)
    try {
      Pizza emptyPizza = Pizza.builder()
          .crust(Crust.THICK)
          .size(Size.SMALL)
          .build();
      validationService.validatePizza(emptyPizza);
    } catch (InvalidPizzaException ex) {
      System.out.println("Caught expected InvalidPizzaException (empty pizza): " + ex.getMessage());
    }

    // 8. Create a pizza and add a null topping (should throw)
    try {
      Pizza nullToppingPizza = Pizza.builder()
          .crust(Crust.REGULAR)
          .sauce(Sauce.TOMATO)
          .cheese(Cheese.MOZZARELLA)
          .size(Size.MEDIUM)
          .topping(null) // Intentionally invalid
          .build();
      validationService.validatePizza(nullToppingPizza);
    } catch (InvalidPizzaException ex) {
      System.out.println("Caught expected InvalidPizzaException (null topping): " + ex.getMessage());
    }

    System.out.println("\n=== DEMO COMPLETE ===");
  }

}
