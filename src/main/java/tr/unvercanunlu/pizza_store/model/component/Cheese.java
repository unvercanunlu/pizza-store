package tr.unvercanunlu.pizza_store.model.component;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
public enum Cheese implements Component {

  MOZZARELLA(5.00),
  CHEDDAR(2.00),
  YELLOW(1.00),
  PARMESAN(3.00),
  GOUDA(4.00);

  private final double price;

  public static String getType() {
    return "cheese";
  }

  @Override
  public double getPrice() {
    return price;
  }

}
