package tr.unvercanunlu.pizza_store.exception.missing;

import java.util.Objects;
import lombok.Getter;
import tr.unvercanunlu.pizza_store.config.Config.Description.MissingError;
import tr.unvercanunlu.pizza_store.constant.Crust;

public class CrustMissingException extends RuntimeException {

  @Getter
  private final Crust crust;

  public CrustMissingException(Crust crust) {
    super(MissingError.CRUST.formatted(Objects.toString(crust, "")));

    this.crust = crust;
  }

}