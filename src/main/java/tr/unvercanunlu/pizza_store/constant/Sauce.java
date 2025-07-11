package tr.unvercanunlu.pizza_store.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Sauce {

  TOMATO(3),
  BBQ(6);

  private final double price;

}
