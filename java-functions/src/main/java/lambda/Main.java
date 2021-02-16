package lambda;

public class Main {

  public static void main(String[] args) {
    String externalValue = "whatever";
    //before Java8
//     StateOwner oldStateOwner = new StateOwner(new StateChangeListener<String>() {
//      @Override
//      public String onStateChange(String stateMessage) {
//        System.out.println(stateMessage);
//        return stateMessage;
//      }
//    });

    //with Java8 lambda
    StateOwner stateOwner = new StateOwner(Main::defaultStateChange);
    stateOwner
        .mutate(state -> state.concat("_APX"))
        .mutate(state -> state.toLowerCase())
        .mutate(state -> state.split("_")[0])
        .changeState("UPDATED_STATE",
            newState -> System.out.println("|####| and the new state is: |"+newState+"|"));
    //If the lambda expression matches the parameter type (in this case the StateChangeListener interface) ,
    // then the lambda expression is turned into a function that implements the same interface as that parameter.

  }

  private static String defaultStateChange(String state) {
    System.out.println(state);
    return state;
  }
}
