# Simulation centrée individus - TP

* Antoine Durigneux
* Quentin Warnant

## Introduction
Dans le cadre du cours de SCI, il nous a été demandé de développer un environnement de simulation en Java. 
Cet environnement doit permettre à l'utilisateur de suivre graphiquement l'évolution de population d'agents, 
soit des billes qui s'entre-choquent, soit l'évolution de requins/thons dans un espace clos. 


## Algorithmes
### Billes
L'environnement contenant les billes est un espace 2D non-torique leur permettant de se déplacer en horizontal, diagonal et vertical. 
Lorsque nous générons les billes, nous leur donnons un sens et une vitesse aléatoire déterminés au moment de la création. 
Notre algorithme fonctionne comme suit : 
si la bille peut se déplacer à sa vitesse (nombre de cases) et dans sa direction sans rencontrer une autre bille ou un bord, 
elle le fait, sinon elle se "rebondit" et nous inversons le sens de son déplacement. 

### Requin (prédateur) - Thon (Proie)
L'environnement contenant les requins et les thons est un espace 2D non-torique leur permettant de se déplacer en horizontal, diagonal et vertical.
Lorsque nous générons les requins, nous leur donnons un temps maximum de vie sans manger et un temps de reproduction. Même principe pour la génération
des thons bien qu'ils n'aient pas de temps sans manger. Pour les deux espèces, ils vieillissent au fil du temps et nous conservons donc l'âge de chaque individu
au cours de la simulation. 

A chaque nouvelle étape de la simulation et pour chaque individu, nous appelons la méthode décide qui fonctionne comme suit :
#### Pour le requin 
    * Nous vérifions si le requin n'a pas mangé depuis trop longtemps : si c'est le cas, il meurt.
    * Nous vérifions après s'il n'est pas en âge de se reproduire et si il dispose d'une place libre : si c'est le cas, nous créons un nouveau requin dans la grille
    * Ensuite, nous regardons dans le voisinage du requin s'il peut manger un poisson 
    * Enfin, nous regardons s'il peut se déplacer 
Dans notre algorithme, un requin ne peut faire qu'une seule de ces actions par tour de la simulation.
#### Pour le thon
    * Nous vérifions si le thon est en âge de se reproduit et s'il dispose d'une place libre, si c'est le cas, nous créons un nouveau thon dans la grille.
    * Nous vérifions s'il peut se déplacer dans la grille
De même que pour les requins, le thon ne peut effectuer qu'une seule action à la fois par tour.

## Compilation du projet
* JDK > 1.7 demandé pour la compilation du projet

```bash 
javac *.java
```

## Exécution du projet
### Billes

### Requin (prédateur) - Thon (Proie) 
```bash
java PoissonSimulation 200 200 4 4000 400 8 15 3 100
```

SIMULATION ANTOINE :
200 200 4 4000 850 8 10 8 100
