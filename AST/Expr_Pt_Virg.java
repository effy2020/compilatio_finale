package AST;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Expr_Pt_Virg extends CommandA{

    public ExpressionA exp;
    public String importCmd;

public Expr_Pt_Virg(ExpressionA exp) {
  this.exp = exp;
  this.importCmd = null;
}
public Expr_Pt_Virg(String importCmd) {
  this.exp = null;
  this.importCmd = importCmd;
}

public String toString() {
return importCmd != null ? importCmd + ";" : String.format("exp(%1$s)", exp.toString() + ";") ;
}
//genere drop a la fin de chaque instruction (une seule)
  // Version avec paramètre booléen
  public String toAssembly(boolean isLastCommand) {
    String asm,nomfichier;
    if(this.importCmd!=null){
      nomfichier=this.importCmd.replace("import ","").trim()+".jsm"; //pour recuperer le nom du fichier 
      try {
            Path filePath = Paths.get(nomfichier); //recuperer le lien relatif du fichier 
            String contenuFichier = new String(Files.readAllBytes(filePath));
            contenuFichier=contenuFichier.trim();
            //supprimer le Halt s'il est a la fin de notre fichier
            if (contenuFichier.endsWith("Halt")) {
              contenuFichier = contenuFichier.substring(0, contenuFichier.length() - 4).trim();
          }
          //enlever le commentaire si on a une erreur
            // asm = "\n Contenu importé depuis " +nomfichier + ":\n" +
            // contenuFichier + "\n" +
            //       "Fin de l'import\n";
            asm=contenuFichier+"\n";
        } catch (IOException e) {
            asm = "Erreur lors de la lecture du fichier " + nomfichier+ "\n";
        }
  
    }
    else{
      asm = exp.toAssembly() + "Drop\n";
      if (isLastCommand) {
          asm += "Halt\n";
      }
    }
   
    return asm;
 
}

// Version sans paramètre (optionnelle)
public String toAssembly() {
    return toAssembly(false); // Par défaut sans Halt
}
}
 

 