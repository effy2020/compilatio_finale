package AST;


    public class Div extends ExpressionA_Binaire {
        public Div(ExpressionA var1, ExpressionA var2) {
           super(var1, var2);
        }
     
        public String symbole() {
           return "div";
        }

  
        public String toAssembly(){
            return gauche.toAssembly() + droite.toAssembly()+"DiviNb \n";
        }

 