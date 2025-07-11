package tr.unvercanunlu.pizza_store.util;

import java.util.Objects;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ValueUtil {

  public static String toString(Object o) {
    return Objects.toString(o, "");
  }

}
