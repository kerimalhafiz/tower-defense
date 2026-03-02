all:docs classes livrable3a.jar livrable3b.jar 

docs:
	mkdir -p docs
	javadoc -sourcepath src -subpackages TowerDefence -d docs

classes:
	mkdir -p classes
	javac -sourcepath src src/TowerDefence/*.java -d classes
	javac -sourcepath src src/TowerDefence/Balloon/*.java -d classes
	javac -sourcepath src src/TowerDefence/board/*.java -d classes
	javac -sourcepath src src/TowerDefence/paths/*.java -d classes
	javac -sourcepath src src/TowerDefence/tower/*.java -d classes

tests:classes
	javac -classpath junit-console.jar:classes test/TowerDefence/*.java 
	javac -classpath junit-console.jar:classes test/Tour/*.java
	javac -classpath junit-console.jar:classes test/pathsT/*.java
runtests: 
	java -jar junit-console.jar -classpath test:classes -scan-classpath
jar:classes
	jar cvfe livrable3a.jar TowerDefence.Livrable3aMain -C classes .
	jar cvfe livrable3b.jar TowerDefence.Livrable3bMain -C classes .

livrable3a.jar:jar
	java -classpath classes TowerDefence.Livrable3aMain $(ARGS)

livrable3b.jar:jar
	java -classpath classes TowerDefence.Livrable3bMain $(ARGS)

clean:
	rm -rf classes docs livrable3a.jar livrable3b.jar 
