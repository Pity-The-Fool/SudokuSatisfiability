JC = javac
DIR = java
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	View.java \
	Model.java \
	Controller.java \
	SudokuSolver.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
