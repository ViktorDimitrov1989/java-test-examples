package higheOrder.condition;

import java.util.function.Function;
import java.util.function.Predicate;

public class Statement<T, R> {

  public Predicate<T> condition;
  public Function<T, R> action;

  public Statement(Predicate<T> condition, Function<T, R> action) {
    this.condition = condition;
    this.action = action;
  }
}
