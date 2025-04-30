package AST;


    public class Div extends ExpressionA_Binaire {
        public Div(ExpressionA var1, ExpressionA var2) {
           super(var1, var2);
        }
     
        public String symbole() {
           return "div";
        }

  
public String toAssembly(){
    String resultat = "";
    resultat += gauche.toAssembly();
    if (gauche instanceof Bool) {
        resultat += "BoToNb\n";
    }

    resultat += droite.toAssembly();
    if (droite instanceof Bool) {
        resultat += "BoToNb\n";
    }
    resultat += "DiviNb \n";
 
    return resultat;
    }
    }

 