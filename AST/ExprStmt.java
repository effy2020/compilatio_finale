package AST;


    public class ExprStmt extends ExpressionA_Binaire{
       ExpressionA a;
        //Constructeur pour une affectation
        public ExprStmt(ExpressionA a) {
            super(null, null);
            this.a=a;
        }


        public String symbole() {return "ExprStmt";};
        public String toString() {
            return String.format("%1$s(%2$s)", symbole(), a);
        }
}
