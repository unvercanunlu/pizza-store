package tr.unvercanunlu.pizza_store.model.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Sauce implements Component {

  TOMATO(3.00),
  BBQ(6.00);

  private final double price;

  public static String getType() {
    return "sauce";
  }

  @Override
  public double getPrice() {
    return price;
  }

}
