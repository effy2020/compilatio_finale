package AST;

public class Moins extends ExpressionA_Binaire {

public Moins(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}

public String symbole() {return "moins";}; 
@Override
        public Double eval(){
            return gauche.eval() - droite.eval();
        }
       
        public String toAssembly(){
            return gauche.toAssembly()+ droite.toAssembly() +"SubiNb\n";
        }
}


