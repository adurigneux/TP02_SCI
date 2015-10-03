# Simulation centr�e individus - TP

* Antoine Durigneux
* Quentin Warnant

##�Introduction
Dans le cadre du cours de SCI, il nous a �t� demand� de d�velopper un environnement de simulation en Java. 
Cet environnement doit permettre � l'utilisateur de suivre graphiquement l'�volution de population d'agents, 
soit des billes qui s'entre-choquent, soit l'�volution de requins/thons dans un espace clos. 


## Algorithmes
### Billes
L'environnement contenant les billes est un espace 2D non-torique leur permettant de se d�placer en horizontal, diagonal et vertical. 
Lorsque nous g�n�rons les billes, nous leur donnons un sens et une vitesse al�atoire d�termin�s au moment de la cr�ation. 
Notre algorithme fonctionne comme suit : 
si la bille peut se d�placer � sa vitesse (nombre de cases) et dans sa direction sans rencontrer une autre bille ou un bord, 
elle le fait, sinon elle se "rebondit" et nous inversons le sens de son d�placement. 

### Requin (pr�dateur) - Thon (Proie)
L'environnement contenant les requins et les thons est un espace 2D non-torique leur permettant de se d�placer en horizontal, diagonal et vertical.
Lorsque nous g�n�rons les requins, nous leur donnons un temps maximum de vie sans manger et un temps de reproduction. M�me principe pour la g�n�ration
des thons bien qu'ils n'aient pas de temps sans manger. Pour les deux esp�ces, ils vieillissent au fil du temps et nous conservons donc l'�ge de chaque individu
au cours de la simulation. 

A chaque nouvelle �tape de la simulation et pour chaque individu, nous appelons la m�thode d�cide qui fonctionne comme suit :
#### Pour le requin 
* Nous v�rifions si le requin n'a pas mang� depuis trop longtemps : si c'est le cas, il meurt.
* Nous v�rifions apr�s s'il n'est pas en �ge de se reproduire et si il dispose d'une place libre : si c'est le cas, nous cr�ons un nouveau requin dans la grille
* Ensuite, nous regardons dans le voisinage du requin s'il peut manger un poisson 
* Enfin, nous regardons s'il peut se d�placer 
Dans notre algorithme, un requin ne peut faire qu'une seule de ces actions par tour de la simulation.

#### Pour le thon
* Nous v�rifions si le thon est en �ge de se reproduit et s'il dispose d'une place libre, si c'est le cas, nous cr�ons un nouveau thon dans la grille.
* Nous v�rifions s'il peut se d�placer dans la grille
De m�me que pour les requins, le thon ne peut effectuer qu'une seule action � la fois par tour.

## Compilation du projet
* JDK > 1.7 demand� pour la compilation du projet

```bash 
javac *.java
```

##�Ex�cution du projet
### Billes
```bash
java BilleSimulation tailleX tailleY tailleBilleCase nombreBilles nombreTours tempsArret
```
* tailleX, tailleY : la taille en X et Y de la fen�tre de simulation (pixels)
* tailleBileCase : la taille du c�t� d'une case repr�sentant une bille (pixels)
* nombreBilles : le nombre de billes contenues dans la simulation
* nombreTours : le nombre de tours de la simulation avant qu'elle s'arr�te
* tempsArret : le temps en ms entre chaque tour de la simulation

### Requin (pr�dateur) - Thon (Proie) 
```bash
java PoissonSimulation tailleX tailleY tailleCase nombreThon nombreRequins tempsReproductionThon tempsReproductionRequin tempsSansMangerRequin sleepTime
```

* tailleX, tailleY : la taille en X et Y de la fen�tre de simulation (pixels)
* tailleCase : la taille du c�t� d'une case repr�sentant un individu (pixels)
* nombrePoissons : nombre de thons dans la simulation au d�part
* nombreRequins : nombre de requins dans la simulation au d�part
* tempsReproductionThon : temps apr�s lequel un thon se reproduit (en tours de simulation)
* tempsReproductionRequin : temps apr�s lequel un requin se reproduit (en tours de simulation)
* tempsSansMangerRequin : temps apr�s lequel un requin meurt lorsqu'il n'a pas pu manger un thon
* sleepTime : le temps en ms entre chaque tour de la simulation

#### Exemples de configuration
##### En �quilibre 
```bash
java PoissonSimulation 200 200 4 4000 400 8 15 3 100
```

![alt tag](http://a23.imgup.net/Untitled28f0b.png)

##### En non-�quilibre
```bash
java PoissonSimulation 200 200 4 4000 850 8 10 8 100
```
