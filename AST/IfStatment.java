package AST;

import java.util.List;

public class IfStatment extends ExpressionA {
    private ExpressionA condition;
    private List<Expr_Pt_Virg> thenBranch;
    private List<Expr_Pt_Virg> elseBranch;
    public static Integer labelJump=0;


    public IfStatment(ExpressionA condition, List<Expr_Pt_Virg> thenBranch, List<Expr_Pt_Virg> elseBranch) {
        this.condition = condition;
        this.thenBranch = thenBranch;
        this.elseBranch = elseBranch;
    }

    public String symbole() {
        return "IfThenElse";
    }

    public String toString() {
        return String.format("%s(%s,%s,%s)",
                symbole(),
                condition != null ? "condition(" + condition.toString() + ")" : "null",
                thenBranch != null ? "then(" + thenBranch.toString()  + ")": "null",
                elseBranch != null ?  "else(" + elseBranch.toString()  + ")" : "null");


    }
    public String toAssembly() {
        Integer ifLabel = labelJump++;
        Integer elseLabel = labelJump++;
        String resultat = "";


        resultat += condition.toAssembly();
        if (condition instanceof Num || condition instanceof Neg || condition instanceof Plus
                || condition instanceof Moins || condition instanceof Mult || condition instanceof Div) {
            resultat += "NbToBe\n";
        }


        resultat += "CondJump u" + elseLabel + "\n";


        for (Expr_Pt_Virg expr : thenBranch) {
            resultat += expr.toAssembly();
        }
        resultat += "Jump fin" + ifLabel + "\n";


        resultat += "u" + elseLabel + ": CsteBo False\n";

        
        if (elseBranch != null && !elseBranch.isEmpty()) {
            for (Expr_Pt_Virg expr : elseBranch) {
                resultat += expr.toAssembly();
            }
        }


        resultat += "fin" + ifLabel + ": ";

        return resultat;
    }


}