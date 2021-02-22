package higheOrder.condition;

import static higheOrder.condition.Condition._if;
import static higheOrder.condition.Condition.match;

import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
  public static void main(String[] args) {
    Predicate<Product> lessThan10 = p0 -> p0.price < 10.0;
    Predicate<Product> greaterOrEqualThan10 = p0 -> p0.price >= 10.0;
    Predicate<Product> lessThan100 = p0 -> p0.price < 100.0;
    Predicate<Product> greaterThan100 = p0 -> p0.price < 100.0;

    Function<Product, Double> calculateDiscount = p ->
      match(p,
          _if(lessThan10,
              p1 -> p1.price * 0.1),
          _if(greaterOrEqualThan10.and(lessThan100),
              p1 -> p1.price * 0.2),
          _if(greaterThan100,
              p1 -> p1.price * 0.3)
      ).orElse(0.0);

    Double result = calculateDiscount.apply(new Product(10.0));

    System.out.println(result);
  }
}
