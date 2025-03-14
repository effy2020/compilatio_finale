JAVAC = javac
JAVA = java
TARGET = Main

all: $(TARGET).class

$(TARGET).class: $(TARGET).java
	$(JAVAC) $(TARGET).java

clean:
	rm -f *.class

run: all
	$(JAVA) $(TARGET)
