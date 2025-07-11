package tr.unvercanunlu.pizza_store.config;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tr.unvercanunlu.pizza_store.model.Size;
import tr.unvercanunlu.pizza_store.model.component.Crust;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Config {

  public static final int MAX_TOPPINGS = 10;
  public static final Crust DEFAULT_CRUST = Crust.REGULAR;
  public static final Size DEFAULT_SIZE = Size.MEDIUM;

}
