# AngryBirdsS3K5

AngryBirds : Technologies : Java 8, JUnit 4<br/>
<br/>
Toute les sources du programme se trouvent dans le fichier src<br/>
Toute les ressource du programme se trouvent dans le fichier Ressource.ressource<br/>
Tout les test se trouvent dans le fichier test<br/>
L'UML se trouve dans le fichier UML, un fichier par livrable<br/>
<br/>
Pour lancer le jeu il faut éxécuter le main de FenetrePrincipal, dans les sources on peut voir que le main contient 3 lignes, la 1ére lunch lancera le menu, dans ce cas mettez en commentaire les 2 autres lignes. les 2 autres lignes servenet à lancer le jeu sans menu, dans ce cas mettez lunch en commentaire. Il n'y a plus de "main programmeur", il a était enlevé.<br/>
<br/>
Pour modifier les éléments du jeu, il y a une méthode "void iniz()" dans Constante.java qui contient la manjeur parties des paramètre du jeu. Si non lancez le jeu avec le menu, puis dans Option il y a deux trois fonctionnalités pratiques<br/>
Pour afficher les Hitboxs des entités, rajouter cette ligne au "void paint(Graphics)" de AnimationJeu.java : "g = visu.drawAllHitBox(g);"<br/>
Contrairement au Jalon 1, la courbe est plus dur à paramétrer soi même, si vous voulez la paramétrer vous même sachez d'abord comment se construit une courbe ici, la classe Courbe appel un constructeur qui prend 6 paramètres double, le 3e et le 6e sortent du fichier PFAG utilisé, donc modifiez le fichier PFAG -> Oiseau x et y pour modifier ces paramètres. Les quatres autres paramètres sont à modifier dans le KeyPressed de AnimationJeu, je vous déconseille de modifier le 3e et 6e paramètres vous même.<br/>

Le langage PFAG est utilisé en plus du Java, le PFAG est un langage créé pour ce jeu et utilisé pour configurer un lancé, pour plus d'information il y a dans les ressources un fichier destiné à celui qui veut en apprendre plus, la 1ere mise à jour listée dans le document (Projet Avancement) vous donnera quelques détails en plus aussi.<br/>
