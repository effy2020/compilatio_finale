package AST;


    public class Div extends ExpressionA_Binaire {
        public Div(ExpressionA var1, ExpressionA var2) {
           super(var1, var2);
        }
     
        public String symbole() {
           return "div";
        }

        /*@Override
        public Double eval(){
            if(droite.eval()==0){
                throw new ArithmeticException("Division par zero");
            }
            return gauche.eval()/droite.eval();
        }*/
        
}
 