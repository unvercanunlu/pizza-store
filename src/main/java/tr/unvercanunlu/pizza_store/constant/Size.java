package tr.unvercanunlu.pizza_store.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Size {

  SMALL(1),
  MEDIUM(1.5),
  LARGE(2);

  private final double multiple;

}
