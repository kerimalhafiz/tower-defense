all:docs classes livrable3a.jar livrable3b.jar livrable4a.jar livrable4b.jar livrable5.jar
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
	javac -classpath junit-console.jar:classes test/Joueur/*.java
	javac -classpath junit-console.jar:classes test/inputtest/*.java



runtests: 
	java -jar junit-console.jar -classpath test:classes -scan-classpath
jar:classes
	jar cvfe livrable3a.jar TowerDefence.Livrable3aMain -C classes .
	jar cvfe livrable3b.jar TowerDefence.Livrable3bMain -C classes .
	jar cvfe livrable4a.jar TowerDefence.Livrable4aMain -C classes .
	jar cvfe livrable4b.jar TowerDefence.Livrable4bMain -C classes .
	jar cvfe livrable5.jar TowerDefence.Livrable5Main -C classes .
	jar cvfe towerdefense-a-random.jar TowerDefence.LivrableFinalMaina_random -C classes .
	jar cvfe towerdefense-a-interactive.jar TowerDefence.LivrableFinalMaina_itera -C classes .
	jar cvfe towerdefense-b-random.jar TowerDefence.LivrableFinalMainb_random -C classes .
	jar cvfe towerdefense-b-interactive.jar TowerDefence.LivrableFinalMainb_iter -C classes .

livrable3a.jar:jar
	java -classpath classes TowerDefence.Livrable3aMain $(ARGS)

livrable3b.jar:jar
	java -classpath classes TowerDefence.Livrable3bMain $(ARGS)
livrable4a.jar:jar
	java -classpath classes TowerDefence.Livrable4aMain $(ARGS)

livrable4b.jar:jar
	java -classpath classes TowerDefence.Livrable4bMain $(ARGS)

livrable5.jar:jar
	java -classpath classes TowerDefence.Livrable5Main $(ARGS)	
clean:
	rm -rf classes docs livrable3a.jar livrable3b.jar livrable4a.jar livrable4b.jar livrable5.jar towerdefense-a-interactive.jar towerdefense-b-interactive.jar towerdefense-a-random.jar towerdefense-b-random.jar
