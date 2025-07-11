package tr.unvercanunlu.pizza_store.exception.invalid;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Cheese;

public class SelectedCheeseNotValidException extends RuntimeException {

  @Getter
  private final Cheese cheese;

  public SelectedCheeseNotValidException(Cheese cheese) {
    super(Config.ErrorDescription.NotValid.CHEESE.formatted(Objects.toString(cheese, "")));

    this.cheese = cheese;
  }

}
