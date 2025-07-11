package tr.unvercanunlu.pizza_store.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Size {

  SMALL(1.00),
  MEDIUM(1.50),
  LARGE(2.00);

  private final double multiple;

}
