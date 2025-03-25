
package AST;

public class LoEqlNb extends ExpressionA_Binaire{
    public LoEqlNb(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "LoEqlNb";}; 
}
 