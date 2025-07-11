package tr.unvercanunlu.pizza_store.exception.invalid;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Size;

public class SelectedSizeNotValidException extends RuntimeException {

  @Getter
  private final Size size;

  public SelectedSizeNotValidException(Size size) {
    super(Config.ErrorDescription.NotValid.SIZE.formatted(Objects.toString(size, "")));

    this.size = size;
  }

}
