package AST;

public class AndExpression extends ExpressionA_Binaire{
    public static Integer labelJump=0;
    public AndExpression(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

    
    public String symbole() {return "&&";};

    public String toAssembly(){
        Integer etiquette=labelJump++;
        String resultat="";
        resultat+=gauche.toAssembly();
        if(gauche instanceof Num || gauche instanceof Neg || gauche instanceof Plus
               || gauche instanceof Moins
                || gauche instanceof Mult || gauche instanceof Div){
            resultat+="NbToBe \n";
        }
        resultat+="CondJump "+ "u"+etiquette +"\n";
        resultat+= droite.toAssembly();
        if(droite instanceof Num || droite instanceof Neg || droite instanceof Plus
                || droite instanceof Moins
                || droite instanceof Mult || droite instanceof Div){
            resultat+="NbToBe \n"; //ici on donne le resultat finale de notre expression
        }
        resultat+="Jump "+"fin"+etiquette +"\n";
        resultat+= "u"+etiquette+" : CsteBo False\n";
        resultat+="fin"+etiquette +" : ";
        return resultat;
    }



    public String toString() {
            return String.format("%s(%s,%s)", symbole(), gauche, droite);
    }

}
