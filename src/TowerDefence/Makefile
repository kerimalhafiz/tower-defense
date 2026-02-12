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
test: compile-tests
	java -jar junit-console.jar -classpath test:classes -scan-classpath
run3a:compile
	java -classpath classes TowerDefence.Livrable3aMain
run3b:compile
	java -classpath classes TowerDefence.Livrable3bMain

livrable3a.jar:compile
	jar cvfe livrable3a.jar TowerDefence.Livrable3aMain -C classes .