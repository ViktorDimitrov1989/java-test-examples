package currying;

public class CurriedObject {
  //state
  private Short a;
  private Integer b;
  private Long c;

  public CurriedObject(Short a, Integer b, Long c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public Long sum(){
    return (a + b) * c;
  }
}
