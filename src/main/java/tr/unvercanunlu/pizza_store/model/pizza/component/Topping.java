package tr.unvercanunlu.pizza_store.model.pizza.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public enum Topping implements Component {

  PEPPERONI(1.00),
  SAUSAGE(3.00),
  BACON(3.00),
  MEAT(5.00),
  MUSHROOM(2.00),
  CHICKEN(2.00),
  BASIL(1.00);

  @Getter
  private final double price;

}
