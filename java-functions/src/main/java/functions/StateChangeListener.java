package functions;

public interface StateChangeListener<T> {

  T onStateChange(T state);

}
