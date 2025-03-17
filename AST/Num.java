package AST;

public class Num extends ExpressionA {
  public double num;
    
  public Num(double num) {
    this.num =num;
  }
  
  public String toString() {
    return Double.toString(num);
  }
  @Override
  public Double eval(){
      return num;
  }
  public String toAssembly(){
    return "CsteNb "+num +"\n";
}

}
