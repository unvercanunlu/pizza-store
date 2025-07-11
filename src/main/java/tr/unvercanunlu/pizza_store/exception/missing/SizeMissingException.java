package tr.unvercanunlu.pizza_store.exception.missing;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config;
import tr.unvercanunlu.pizza_store.constant.Size;

public class SizeMissingException extends RuntimeException {

  @Getter
  private final Size size;

  public SizeMissingException(Size size) {
    super(Config.ErrorDescription.Missing.SIZE.formatted(Objects.toString(size, "")));

    this.size = size;
  }

}
