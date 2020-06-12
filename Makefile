JC = javac
.SUFFIXES: .java .class
.java.class:
	$(JC) $*.java

CLASSES = \
	Model.java \
	View.java \
	Controller.java \
	SudokuSolver.java

default: classes

classes: $(CLASSES:.java=.class)

clean:
	$(RM) *.class
