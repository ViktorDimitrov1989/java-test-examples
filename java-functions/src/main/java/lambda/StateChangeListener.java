package lambda;

public interface StateChangeListener<T> {

  T onStateChange(T state);

}
