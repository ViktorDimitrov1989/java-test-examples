package lambda.variableCapture;

import java.util.Comparator;

public class Main {

  private static Integer STATIC_VAR = 9;

  public static void main(String[] args) {
    Pesho pesho = new Pesho(15);

    Integer i = 1;
    Comparator<Integer> c = (a, b) -> i.compareTo(a);
  }

  public static class Pesho{
    private Integer age;

    public Pesho(Integer age){
      age = age;
    }

    public Integer getAge(){
      return age;
    }
  }
}
