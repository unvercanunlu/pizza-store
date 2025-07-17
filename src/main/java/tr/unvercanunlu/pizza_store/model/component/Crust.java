package tr.unvercanunlu.pizza_store.model.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public enum Crust implements Component {

  THIN(2.00),
  REGULAR(1.00),
  THICK(3.00);

  @Getter
  private final double price;

}
