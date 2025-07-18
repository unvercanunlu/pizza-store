package tr.unvercanunlu.pizza_store.model.pizza.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@RequiredArgsConstructor
public enum Sauce implements Component {

  TOMATO(3.00),
  BBQ(6.00);

  @Getter
  private final double price;

}
