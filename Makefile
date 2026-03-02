all:docs classes livrable3a.jar livrable3b.jar 

docs:
	mkdir -p docs 

javadoc:
	mkdir -p docs
	javadoc -sourcepath src -subpackages TowerDefence -d docs

classes:
	mkdir -p classes

compile:
	mkdir -p classes
	javac -sourcepath src src/TowerDefence/Livrable3aMain.java -d classes
	javac -sourcepath src src/TowerDefence/Livrable3bMain.java -d classes

compile-tests:compile
	javac -classpath junit-console.jar:classes test/TowerDefence/*.java 
	javac -classpath junit-console.jar:classes test/Tour/*.java
	javac -classpath junit-console.jar:classes test/pathsT/*.java

test: compile-tests
	java -jar junit-console.jar -classpath test:classes -scan-classpath
run3a:compile
	java -classpath classes TowerDefence.Livrable3aMain $(ARGS)
run3b:compile
	java -classpath classes TowerDefence.Livrable3bMain $(ARGS)
livrable3a.jar:compile
	jar cvfe livrable3a.jar TowerDefence.Livrable3aMain -C classes .
livrable3b.jar:compile
	jar cvfe livrable3b.jar TowerDefence.Livrable3bMain -C classes .
runjar3a:livrable3a.jar 
	java -jar livrable3a.jar $(ARGS)
runjar3b:livrable3b.jar 
	java -jar livrable3b.jar $(ARGS)
clean:
	rm -rf classes docs livrable3a.jar livrable3b.jar $(ARGS)
