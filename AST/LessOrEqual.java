
package AST;

public class LessOrEqual extends ExpressionA_Binaire{
    public LessOrEqual(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "LoEqlNb";};
      public String toAssembly(){
            return gauche.toAssembly()+ droite.toAssembly() +"LoEqNb\n";
        }  
}
 