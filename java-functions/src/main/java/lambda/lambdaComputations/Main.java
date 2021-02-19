package lambda.lambdaComputations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

  public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
//
//    int result = 0;
//    for (Integer number : numbers) {
//      if(isEven(number) && isGreaterThan3(number)){
//        result = number;
//        break;
//      }
//    }

    Stream<Integer> result = numbers
        .stream()
        .filter(Main::isEven)
        .filter((Integer num) -> isGreaterThan3(num));
//        .findFirst();
//        .orElse(0);
result.findFirst();
    System.out.println("Result is: " + result);
  }

  private static boolean isEven(int number){
    System.out.println("IS EVEN");
    return number % 2 == 0;
  }

  private static boolean isGreaterThan3(int number){
    System.out.println("IS GREATER THAN 3");
    return number > 3;
  }




}
