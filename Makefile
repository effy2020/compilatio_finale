# Règle par défaut : compile puis exécute
# Générer et compiler les fichiers Java
compile:
	javacc Compilateur.jj
	javac Compilateur.java
	javac -cp .:lib/junit-jupiter-api-5.10.0.jar:lib/junit-platform-console-standalone-1.10.0.jar Compilateur.java TEST/CompilateurTest.java
# Exécuter le parser
run:
	java Compilateur

# Exécuter les tests avec JUnit
test: compile
	java -cp .:lib/junit-jupiter-api-5.10.0.jar:lib/junit-platform-console-standalone-1.10.0.jar:TEST org.junit.platform.console.ConsoleLauncher execute --scan-classpath

# Nettoyer les fichiers générés
clean:
	rm -f *.class *.java TEST/*.class


 
