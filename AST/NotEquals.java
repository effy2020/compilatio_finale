package AST;

public class NotEquals extends ExpressionA_Binaire {

public NotEquals(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
public String symbole() {return "NotEq";}; 
   public String toAssembly(){
            return gauche.toAssembly()+ droite.toAssembly() +"NotEql\n";
        }   
 
 
}