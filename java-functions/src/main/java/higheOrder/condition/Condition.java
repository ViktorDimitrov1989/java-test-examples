package higheOrder.condition;

import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Condition {

  public static <T> Statement<T> _if(Supplier<Boolean> condition, Supplier<T> action){
    return new Statement<>(condition, action);
  }

  public static <T> Optional<Supplier<T>> match(Statement<T>... statements){
    return Stream.of(statements)
        .filter(s -> s.condition.get())
        .findFirst()
        .map(s -> s.action);
  }
}
