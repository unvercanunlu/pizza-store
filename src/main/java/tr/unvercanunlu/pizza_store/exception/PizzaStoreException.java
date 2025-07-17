package tr.unvercanunlu.pizza_store.exception;

public abstract class PizzaStoreException extends RuntimeException {

  protected PizzaStoreException(String message, Object... o) {
    super(message.formatted(o));
  }

}
