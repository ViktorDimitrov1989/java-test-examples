package higheOrder.condition;

import java.util.function.Function;
import java.util.function.Supplier;

public class Main {
  public static void main(String[] args) {
    Function<Product, Supplier<Double>> calculateDiscount = p ->
      Condition.match(
          Condition._if(() -> p.price < 10.0, () -> p.price * 0.1),
          Condition._if(() -> p.price >= 10.0 && p.price < 100.0, () -> p.price * 0.2),
          Condition._if(() -> p.price > 100.0, () -> p.price * 0.3)
      ).orElse(() -> 0.0);

    Supplier<Double> result = calculateDiscount.apply(new Product(10.0));

    System.out.println(result.get());
  }
}
