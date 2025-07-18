package tr.unvercanunlu.pizza_store.model.pizza;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public enum Size {

  SMALL(1.00),
  MEDIUM(1.50),
  LARGE(2.00);

  @Getter
  private final double priceMultiplier;

}
