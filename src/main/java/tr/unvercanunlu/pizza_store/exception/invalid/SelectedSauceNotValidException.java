package tr.unvercanunlu.pizza_store.exception.invalid;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config.Description.NotValidError;
import tr.unvercanunlu.pizza_store.constant.Sauce;

public class SelectedSauceNotValidException extends RuntimeException {

  @Getter
  private final Sauce sauce;

  public SelectedSauceNotValidException(Sauce sauce) {
    super(NotValidError.SAUCE.formatted(Objects.toString(sauce, "")));

    this.sauce = sauce;
  }

}
