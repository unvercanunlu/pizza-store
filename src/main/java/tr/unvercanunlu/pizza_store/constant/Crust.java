package tr.unvercanunlu.pizza_store.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Crust {

  THIN(2.00),
  REGULAR(1.00),
  THICK(3.00);

  private final double price;

}
