package AST;

public class Bool extends ExpressionA {
  public boolean b;
    
  public Bool(Boolean boolValue) {  // Attend un String
    this.b = boolValue;
}
  
  public String toString() {
    return Boolean.toString(b);
}



 
}