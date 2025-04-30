package AST;

public class GreaterOrEqual extends ExpressionA_Binaire{
    public GreaterOrEqual(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "GrEqlNb";}; 
       public String toAssembly(){
            return gauche.toAssembly()+ droite.toAssembly() +"GrEqNb\n";
        }
}
 