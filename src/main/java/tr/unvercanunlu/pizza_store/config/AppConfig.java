package tr.unvercanunlu.pizza_store.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tr.unvercanunlu.pizza_store.model.pizza.Size;
import tr.unvercanunlu.pizza_store.model.pizza.component.Crust;
import tr.unvercanunlu.pizza_store.model.pizza.component.Topping;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AppConfig {

  public static final int MAX_TOPPINGS = Topping.values().length;
  public static final Crust DEFAULT_CRUST = Crust.REGULAR;
  public static final Size DEFAULT_SIZE = Size.MEDIUM;

}
