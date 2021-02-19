package functions;

import java.util.function.Predicate;

public class Main {

  public static void main(String[] args) {
    //with Java8 lambda
    StateOwner stateOwner = new StateOwner((state) -> {
      System.out.println(state);
      return state;
    });

    stateOwner
        .mutate(state -> state.concat("_APX"))
        .mutate(String::toLowerCase)
        .mutate(state -> state.split("_")[0])
        .changeState("UPDATED_STATE",
            newState -> System.out.println("|####| and the new state is: |"+newState+"|"));

    Predicate<String> predicate = s -> s.contains("a");
    System.out.println(predicate.test("alabala"));
  }
}
