
package AST;

public class LessThen extends ExpressionA_Binaire{
    public LessThen(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "LoStlNb";}; 
}
 