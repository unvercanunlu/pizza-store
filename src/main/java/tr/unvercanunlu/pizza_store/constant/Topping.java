package tr.unvercanunlu.pizza_store.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Topping {

  PEPPERONI(1),
  SAUSAGE(3),
  BACON(3),
  MEAT(5),
  MUSHROOM(2),
  CHICKEN(2),
  BASIL(1);

  private final double price;

}
