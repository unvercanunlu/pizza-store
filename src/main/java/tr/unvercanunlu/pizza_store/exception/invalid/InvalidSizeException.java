package tr.unvercanunlu.pizza_store.exception.invalid;

import lombok.Getter;
import tr.unvercanunlu.pizza_store.exception.ErrorMessage;
import tr.unvercanunlu.pizza_store.model.Size;
import tr.unvercanunlu.pizza_store.util.ValueUtil;

public class InvalidSizeException extends RuntimeException {

  @Getter
  private final Size size;

  public InvalidSizeException(Size size) {
    super(ErrorMessage.SIZE_INVALID.formatted(ValueUtil.toString(size)));

    this.size = size;
  }

}
