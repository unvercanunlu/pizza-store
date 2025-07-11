package tr.unvercanunlu.pizza_store.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Cheese {

  MOZZARELLA(5),
  CHEDDAR(2),
  YELLOW(1),
  PARMESAN(3),
  GOUDA(4);

  private final double price;

}
