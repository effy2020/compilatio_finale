package AST;

public class Affectation extends ExpressionA_Unaire {

    public Affectation(String identifient, ExpressionA exp) {
        super( identifient,exp);
    }

    public String symbole() {
        return "Affect";
    }
    public String toAssembly(){
        String resultat="";
        resultat+=exp.toAssembly();
        resultat+="SetVar "+identifient+"\n";
        resultat+="GetVar "+identifient+"\n";
        return resultat;
    }


}
