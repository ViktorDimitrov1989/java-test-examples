package higheOrder.condition;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Condition {

  public static <T, R> Statement<T, R> _if(Predicate<T> condition, Function<T, R> action){
    return new Statement<>(condition, action);
  }

  @SafeVarargs
  public static <T, R> Optional<R> match(T candidate, Statement<T, R>... statements){
    return Stream.of(statements)
        .filter(s -> s.condition.test(candidate))
        .findFirst()
        .map(s -> s.action.apply(candidate));
  }
}
