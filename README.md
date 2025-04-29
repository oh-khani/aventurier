# Projet aventurier

## Fonctionnement

Le programme prend en entrée un fichier texte :
 - la première ligne contient les coordonnées initiales du personnage sous la forme : `x,y`
 - la deuxième ligne contient la séquence de déplacements du personnage :
   - **N** : Nord
   - **S** : Sud
   - **E** : Est
   - **O** : Ouest   

Le personnage se déplace en prenant en compte les obstacles présents sur la carte, notamment les cases boisées, qu’il ne peut pas traverser. Les déplacements suivent un repère cartésien où l’axe `x` s’étend horizontalement (vers la droite) et l’axe `y` verticalement (vers le bas), contrairement à un repère de type matrice.

Le programme révèle les coordonnées de la position finale du personnage.

## Remarques

J'ai supposé pour ce projet que les fichiers en entrée étaient valides (bon format des coordonnées, coordonnées initiales à l'intérieur des limites de la carte et sur une case vide, la séquence ne contient que les caractères des directions cardinales), mais il aurait bien sûr était possible d'implémenter des vérifications.
