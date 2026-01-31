# l2s4-projet-2026

Vous devez *forker* ce projet dans votre espace de travail Gitlab (bouton `Fork`) et vidéo sur le [portail](https://www.fil.univ-lille.fr/portail/index.php?dipl=L&sem=S4&ue=Projet&label=Documents)
Un unique fork doit être réalisé par équipe.

Une fois cela réalisé, supprimer ces premières lignes et remplir les noms des membres de votre équipe.
N'oubliez pas d'ajouter les autres membres de votre équipe aux membres du projet, ainsi que votre enseignant·e (statut Maintainer).

# Equipe 1

- IBRAHIMA DIALLO
- ALPHA ABDOULAYE DIALLO
- KERIM ABDOULAYE MAHAMAT ALHAFIZ 
- THIERNO ABDOULAYE DIALLO

# Sujet

[Le sujet 2026](https://www.fil.univ-lille.fr/~varre/portail/l2s4-projet/sujet2026.pdf)

# Livrables

Les paragraphes concernant les livrables doivent être remplis avant la date de rendu du livrable. A chaque fois on décrira l'état du projet par rapport aux objectifs du livrable. Il est attendu un texte de plusieurs lignes qui explique la modélisation choisie, et/ou les algorithmes choisis et/ou les modifications apportées à la modélisation du livrable précédent.

Un lien vers une image de l'UML doit être fourni (une photo d'un diagramme UML fait à la main est suffisant).

## Livrable 1
### INSTRUCTIONS PRECISES :
### COMPILATION DU PROGRAMME
Pour compiler notre  programme, il faut executer cette commande:
```javac -sourcepath src src/TowerDefence/*.java -d classes ``` 

 
### GENERERATION DU DOC :
Pour generer la documentation il faut executer cette commande :
```javadoc -sourcepath src -subpackages TowerDefence -d docs ```
 

### COMPILATION Des tests:
Pour compiler et executer  qui m'ont ete demandes de resoudre dans ce tp il faut executer cette commande :
```javac -classpath "junit-console.jar;classes" test\TowerDefence\*.java``


### EXECUTION DU PROGRAMME :
Il peut se faire en deux etapes soit :sans jar executable soit avec .
### Pour exécuter le programme sans le jar exécutable 
Pour exécuter le  programme de  il suffit de taper la commande ci apres :
### Pour le livrable1a: 
 ``` java -classpath classes TowerDefence.Livrable1aMain   ```
 NB:Ensuite juste apres Livrable1a.Main rajouter les coordonnées que vous vouliez pour votre grille .
### Pour le livrable1b:
``` java -classpath classes TowerDefence.Livrable1bMain   ```
NB:Ensuite juste devant Livrable1b.Main rajouter les coordonnées que vous vouliez pour votre grille et le nombre total  de  chemin que vous souhaitez.(longueur,largeur,nbchemins).


###  Pour exécuter le programme avec le jar exécutable 
Celui la aussi se fait soit avec un fichier manifeste soit sans fichier manifeste :
## sans fichier manifeste :
Il faut compiler cette commande : 
### Pour le livrable1a:
``` jar cvfe Livrable1a.jar TowerDefence.Livrable1aMain -C classes TowerDefence  ```

Ensuite pour l'executer : ``` java -jar Livrable1a.jar   ```
NB:Ensuite juste devant Livrable1a.jar rajouter les coordonnées que vous vouliez pour votre grille(Longueur,Largeur).

### Pour le livrable1b:
``` jar cvfe Livrable1b.jar TowerDefence.Livrable1bMain -C classes TowerDefence  ```

Ensuite pour l'executer : ``` java -jar Livrable1b.jar   ```
NB:Ensuite juste devant Livrable1b.Main rajouter les coordonnées que vous vouliez pour votre grille et le nombre total  de  chemin que vous souhaitez.(longueur,largeur,nbchemins).

## Avec fichier manifeste :
### Pour le livrable1a:
il faut d'abord creer un fichier manifeste nous  ici on a creer   le fichier " TowerDefence" comme manifeste puis à l'interieur on a  mis "Main-Class: TowerDefence.Livrable1aMain
NB: dans ce fichier il doit y avoir 2 lignes a l'interieur.(la seconde est vide)

 Ensuite il faut taper la commande : ``` jar cvfm Livrable1a.jar TowerDefence-manifest -C classes TowerDefence ```

 Et enfin l'exécuter : ``` java -jar Livrable1a.jar  ```
 NB:Ensuite juste devant Livrable1a.jar rajouter les coordonnées que vous vouliez pour votre grille(Longueur,Largeur).

 ### Pour le livrable1b:
 il faut d'abord creer un fichier manifeste nous  ici on a creer   le fichier " TowerDefence1" comme manifeste puis à l'interieur on a  mis "Main-Class: TowerDefence.Livrable1bMain
 NB: dans ce fichier il doit y avoir 2 lignes a l'interieur.(la seconde est vide)

 Ensuite il faut taper la commande : ``` jar cvfm Livrable1b.jar TowerDefence-manifest -C classes TowerDefence ```

 Et enfin l'exécuter : ``` java -jar Livrable1b.jar  ```
 NB:Ensuite juste devant Livrable1b.Main rajouter les coordonnées que vous vouliez pour votre grille et le nombre total  de  chemin que vous souhaitez.(longueur,largeur,nbchemins).






### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 2

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 3

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 4

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 5

### Atteinte des objectifs

### Difficultés restant à résoudre

## Livrable 6

### Atteinte des objectifs

### Difficultés restant à résoudre

# Journal de bord

Le journal de bord doit être rempli à la fin de chaque séance encadrée, et **avant** de quitter la salle. 

Pour chaque semaine on y trouvera :
- ce qui a été réalisé, les difficultés rencontrées et comment elles ont été surmontées (on attend du contenu, pas uniquement une phrase du type "tous les objectifs ont été atteints")
- la liste des objectifs à réaliser d'ici à la prochaine séance encadrée
Apres avoir reçu votre mail nous nous sommes rendu compte qu il fallait des modification  afin d'avoir le resultat demandé
Tout d'abord nous avons ajoute une classe Position ce qui a entraine la modification de Cell . Nous avons aussi modifie findpath de Path desormais il prends une grille en parrametre au lieu d un board et il renvoit la liste des Positions sur laquel passe le chemin.
et nous avons aussi creer BoardOne et BoardTwo pour representé les deux table ;elles heritent d'une classe abstraite Board.
Nous avons aussi finalement décidé de stocker les ballons dans le Board au lieu des cell nous pensont que a partir du board on a plus de maarge de manoeuvre.

## Semaine 1

### Ce qui a été réalisé
- reflexion sur la création des chemins
- definissions d'une interface chemin de laquelle tout les chemins heriteront.
### Difficultés rencontrées
- reflechions sur les possibilites d ajouter plyus tars des chemins

### Objectifs pour la semaine et répartition du travail par membre
- Diallo Thierno cheminGrise
- Diallo Ibrahima Chemin2
- Kerim Definissions de l'interface
- Diallo Alpha Abdoulaye creation de la class plateau sans code et assistance pour les autres

## Semaine 2

### Ce qui a été réalisé
la semaine dernière n'ayant pas pu finaliser nos objectifs et ayant rencontrés beaucoup de soucis et des discussions houleuses entre nous,nous avons decider de rereflchir sur les chemins. 
- Nous avons realise le diagramme [Diagramme UML](diagramme.png)

 concernat les chemins.Notre reflexion est de créer: 
# une interface Path 
- qui aura une methode findPath(Board b)qui prend en parametre un plateau et trouver   "aleatoirement" un chemin, ce chemin retournera une liste de Cellule rangé en ordre selon le trajet.
- la premiere case étant la case de depart et la derniere celle de sortie.
- Enf fonction de nos deux modes de jeu actuelle nous créerons pour un debut  2 classes qui implementeront cette interface
- la mise en place de cette interface est justifie par la possibilte de plutard pouvoir avoir d'autres chemins dans le but de l'ouverture du jeu à des extentions
# la premier PathOne() 
- trouvera un chemin correspondant au premier mode de jeu le chemin ne sera pas une ligne droite mais aura au minimun un tournant.
# La deuxieme PathTwo()
- trouvera un chemin en ligne droite selon la rentré du balon il ira à droite ou ira à gauche,en bas ou en haut
- cas special de les 4 cases des extremités ont la possibilité d'aller horizontalement ou verticalement par exemple la case [0][0]
# divers
- afin de coder ces premières casse nous mettons pour le moment deux classes Board et Cell juste pour pouvoir tester la validité de notre code (ces deux classes progresseront surement au fils du temps)



### Difficultés rencontrées
- dans certains cas les ballons peuvent se rencontre "comment gerer cela ?"

### Objectifs pour la semaine et répartition du travail par membre
- Thierno Abdoulaye Diallo Board
- Diallo Alpha Abdoulaye PathOne
- Diallo Ibrahima PathTwo
- Kerim Abdoulaye Mahamat Cell et Interface Path 


## Semaine 3

### Ce qui a été réalisé
réflexion sur la construction du ballon et la gestion des ballon selon la vitesse et la résistance , donc on va gére le ballon  comme une classe abstraite  avec   deux méthodes abstraite dont l'une elle va s'occuper d'avancement du ballon en fonction de chaque classe puisque nous auront  4 classe autre qui hériterons de la classe ballon dont chaque classe va gérer le ballon avec la vitesse souhaité et la résistance. la dernière classe  est une classe qui s'occupe  de la situation ou le ballon sera glacé dont on  remet la vitesse des ballon glacé à 0  pour un certains durée mais tout en conservant leurs position actuelle  après la durée est écouler, la vitesse reprendre sa vitesse normal et sa position 

### Difficultés rencontrées
le problème est que quand le Ballon est glacé on sait pas encore si la résistance doit diminuer ou pas si le joueur il tire sur le ballon , le  déplacement du Ballon à l'intérieur d'une cellule et le mot avancement d'une tic d'horloge   


### Objectifs pour la semaine et répartition du travail par membre
- kerim abdoulaye mahamat alhafiz classe  abtraite du ballon et livrable
- Diallo Alpha Abdoulaye  class ballon1 et la classe de glace
- Diallo Ibrahima classe Ballon 2 livrable
- Diallo Alpha Abdoulaye BAllon 3 et la livrable

### Modification et difficulte livrable1
Apres avoir reçu votre mail nous nous sommes rendu compte qu il fallait des modification  afin d'avoir le resultat demandé
Tout d'abord nous avons ajoute une classe Position ce qui a entraine la modification de Cell . Nous avons aussi modifie findpath de Path desormais il prends une grille en parrametre au lieu d un board et il renvoit la liste des Positions sur laquel passe le chemin.
et nous avons aussi creer BoardOne et BoardTwo pour representé les deux table ;elles heritent d'une classe abstraite Board.
Nous avons aussi finalement décidé de stocker les ballons dans le Board au lieu des cell nous pensont que a partir du board on a plus de maarge de manoeuvre.
# Commande Livrable1
-javac -d ../bin board/*.java paths/*.java mains/*.java (compiler à partir de src)
-javadoc -d ../doc board/*.java paths/*.java mains/*.java (documentation a partir de src)


## Semaine 4

### Ce qui a été réalisé
reflexion sur le deplacement du ballon.On a reflechi sur plusieurs methodes concernant comment faire avancer le ballon dans une cellule  .et on sait dit qu'il faut diviser la cellule en plusieurs sous cellules tout en respectant un nombre precis (par exemple en 3 ou 4 sous-cellules ) notamment pour toutes les cellules. Nous avons eu l'idée de gerer la resistance et la vitesse comme etant deux choses en lien , c'est-à-dire on a des types de ballons , par exemple des ballons de resistance 1,2,3,4, celles de vitesse 1 avancent a chaque tic d'horloge en respectant la vitesse , on peut deplacer le ballon d'une seule case sur ce cas .Celle de vitesse 2 , on peut l'avancer de 2 sous-cellules , celle de vitesse  3 doit doit être avancer de 3 sous-cellules . On sait par contre que la vitesse peut aussi être un floatant par exemple 1/2,1/3,1/4 , donc sur ce cas ,notre cellule peut etre diviser par 4 sous-cellules.

### Difficultés rencontrées
les difficultés rencontrées sont le fait de pouvoir avancer un le choix de modelisation de  du ballon comme class abtract ,ou une class simple ou interface mais on  va choisir  l bonne maniere, autres difficultés c'est l implementation de la methode move() qui fait avancer le ballon donc c'est un peu compliquer pour nous la division des cases .les autres diffultés sont de type mineurs .
### Objectifs pour la semaine et répartition du travail par membre
- kerim abdoulaye mahamat alhafiz classe  abtraite du ballon et livrable
- Diallo Alpha Abdoulaye  class ballon1 et la classe de glace et le lirable1
- Diallo Ibrahima classe Ballon 2 livrable
- Diallo Thierno Abdoulaye BAllon 3 et la livrable

## Semaine 5

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 6

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 7

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 8

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 9

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 10

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 11

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour la semaine et répartition du travail par membre

## Semaine 12

### Ce qui a été réalisé

### Difficultés rencontrées

### Objectifs pour finaliser le projet et répartition du travail par membre
