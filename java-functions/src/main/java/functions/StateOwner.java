package functions;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class StateOwner {

  private final StateChangeListener<String> listener;
  private Function<String, String> currentOps;
  private String state;

  public StateOwner(StateChangeListener<String> listener) {
    this.listener = listener;
    this.currentOps = listener::onStateChange;
    this.state = "DEFAULT_STATE";
  }

  //intermediate operation
  public StateOwner mutate(UnaryOperator<String> stateMutation) {
    //function composition
    currentOps = currentOps
        .andThen(stateMutation)
        .andThen(listener::onStateChange);
    return this;
  }

  //closing operation
  public void changeState(String newState, Consumer<String> print) {
    currentOps.apply(state);
    this.state = newState;
    print.accept(newState);
  }
}
