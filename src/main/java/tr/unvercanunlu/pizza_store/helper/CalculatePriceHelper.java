package tr.unvercanunlu.pizza_store.helper;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import tr.unvercanunlu.pizza_store.model.pizza.Pizza;
import tr.unvercanunlu.pizza_store.model.pizza.Size;
import tr.unvercanunlu.pizza_store.model.pizza.component.Component;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CalculatePriceHelper {

  public static double calculate(Pizza pizza) {
    if (pizza == null) {
      return 0.00;
    }

    double basePrice = Stream.of(
            Optional.ofNullable(pizza.getCrust()),
            Optional.ofNullable(pizza.getSauce()),
            Optional.ofNullable(pizza.getCheese())
        ).filter(Optional::isPresent)
        .map(Optional::get)
        .mapToDouble(Component::getPrice)
        .sum();

    double toppingsPrice = pizza.getToppings()
        .stream()
        .filter(Objects::nonNull)
        .mapToDouble(Component::getPrice)
        .sum();

    return (basePrice + toppingsPrice) * Optional.ofNullable(pizza.getSize())
        .map(Size::getPriceMultiplier)
        .orElse(1.00);
  }

}
