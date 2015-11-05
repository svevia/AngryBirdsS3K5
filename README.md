# AngryBirdsS3K5

AngryBirds : Technologies : Java 8, JUnit 4

Toute les sources du programme se trouve dans le fichier src
Tout les test se trouve dans le fichier test
L'UML se trouve dans le fichier UML, un fichier par livrable

Pour lancer le jeu il faut éxécuter le main de LivOne, le deuxième main est un main qui permet de lancer le jeu en "administrateur", seul la fonction pause a été implémentée sur ce main.

Pour modifier les éléments du jeu, il y a une méthode "void iniz()" dans Constante.java qui contient la manjeur parties des paramètre du jeu.
Pour afficher les Hitboxs des entités, rajouter cette ligne au "void paint(Graphics)" de AnimationOiseau.java : "g = visu.drawAllHitBox(g);"
Pour générer sa propre courbe, remplacer dans le "void run()" de LivOne.java : "gf = new GameFrame(i + 1, n, generateCourbe());" par "gf = new GameFrame(i + 1, n, new Courbe(a, b, c));" en remplacer a, b et c par vos paramètres.
Pour modifier le nombre de lancer, modifier le chiffre se trouvant dans "p = new LivOne(10);" du main dans LivOne.java
Pour régler la vitesse du jeu, modifier le chiffre dans "core = new Thread(new HeartCore(4, this));" de l'initializer de AnimationOiseau.java


