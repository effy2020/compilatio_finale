package AST;

public class AndExpression extends ExpressionA_Binaire{
    public AndExpression(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    public AndExpression( ExpressionA droite) {super(null, droite);}
    
    public String symbole() {return "&&";};
    public String toString() {
        if(gauche!=null) {
            return String.format("%s(%s,%s)", symbole(), gauche, droite);
        }
        else{
            return String.format("%s(%s)", "expr", droite);

        }
    }
}
