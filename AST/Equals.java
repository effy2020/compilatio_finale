package AST;

public class Equals extends ExpressionA_Binaire{
    public Equals(ExpressionA gauche,ExpressionA droite) {super(gauche, droite);}
    
    public String symbole() {return "Eq";}; 

     public String toAssembly(){
         return gauche.toAssembly()+ droite.toAssembly() +"Equals\n";
        
}
}
 