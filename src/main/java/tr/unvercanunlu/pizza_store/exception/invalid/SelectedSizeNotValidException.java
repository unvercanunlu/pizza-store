package tr.unvercanunlu.pizza_store.exception.invalid;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config.Description.NotValidError;
import tr.unvercanunlu.pizza_store.constant.Size;

public class SelectedSizeNotValidException extends RuntimeException {

  @Getter
  private final Size size;

  public SelectedSizeNotValidException(Size size) {
    super(NotValidError.SIZE.formatted(Objects.toString(size, "")));

    this.size = size;
  }

}
