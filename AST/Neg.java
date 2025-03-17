package AST;

public class Neg extends ExpressionA {

public ExpressionA arg;

public Neg(ExpressionA arg) {
  this.arg = arg;
}

public String toString() {
  return String.format("neg(%1$s)", arg.toString());
}
@Override
        public Double eval(){
            return -arg.eval();
        }


        public String toAssembly(){
          return arg.toAssembly()+"NegaNb\n" ;
      }
      

}	
