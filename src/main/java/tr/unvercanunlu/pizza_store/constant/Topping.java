package tr.unvercanunlu.pizza_store.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Topping {

  PEPPERONI(1.00),
  SAUSAGE(3.00),
  BACON(3.00),
  MEAT(5.00),
  MUSHROOM(2.00),
  CHICKEN(2.00),
  BASIL(1.00);

  private final double price;

}
