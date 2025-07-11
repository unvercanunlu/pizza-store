package tr.unvercanunlu.pizza_store.exception.invalid;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Topping;

public class SelectedToppingNotValidException extends RuntimeException {

  @Getter
  private final Topping topping;

  public SelectedToppingNotValidException(Topping topping) {
    super(Config.ErrorDescription.NotValid.TOPPING.formatted(Objects.toString(topping, "")));

    this.topping = topping;
  }

}
