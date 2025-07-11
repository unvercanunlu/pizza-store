package tr.unvercanunlu.pizza_store.exception.invalid;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config.Description.NotValidError;
import tr.unvercanunlu.pizza_store.constant.Crust;

public class SelectedCrustNotValidException extends RuntimeException {

  @Getter
  private final Crust crust;

  public SelectedCrustNotValidException(Crust crust) {
    super(NotValidError.CRUST.formatted(Objects.toString(crust, "")));

    this.crust = crust;
  }

}
