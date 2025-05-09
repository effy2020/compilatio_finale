package AST;


public class Expr_Pt_Virg extends CommandA{
    private ExpressionA exp;


    public Expr_Pt_Virg(ExpressionA exp) {
        this.exp = exp;
    }

    public String toString() {
    return  exp.toString() + ";";
    }
//genere drop a la fin de chaque instruction (une seule)
  // Version avec paramètre booléen

    public String toAssembly(boolean isLastCommand) {
        String asm = "";
        if (!(exp instanceof Affectation)) {
            asm = exp.toAssembly() + "Drop\n"; //cas le setVar enleve le sommet de la pile
        } else {
            asm = exp.toAssembly(); // Cas où c'est une Affectation
        }

        if (isLastCommand) {
            asm += "Halt\n";
        }

        return asm;
    }

 
// Version sans paramètre (optionnelle)
public String toAssembly() {
    return toAssembly(false); // Par défaut sans Halt
}
}
 

 
