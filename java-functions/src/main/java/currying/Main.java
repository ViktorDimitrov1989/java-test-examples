package currying;

import java.util.function.Function;

public class Main {
  public static void main(String[] args) {
    //curried function
    CurriedFunction function = a -> b -> c -> a + b * c;
    CurriedObject object = new CurriedObject((short)1,2,3L);

    System.out.println(function.apply((short) 1).apply(2).apply(3L));
    System.out.println(object.sum());
  }

  interface CurriedFunction extends Function<Short, Function<Integer, Function<Long, Long>>>{

  }
}

