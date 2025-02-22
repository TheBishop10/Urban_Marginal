package controleur;

import java.awt.event.KeyEvent;

public interface Global {
	/**
	 * Charact�re de s�paration pour les cha�nes envoy�es
	 */
	String STRINGSEPARE = "~";
	/**
	 * N� de port
	 */
	int PORT = 6666;
	/**
	 * Message pseudo
	 */
	String PSEUDO = "pseudo";
	/**
	 * hauteur de la zone de jeu de l'ar�ne
	 */
	int HAUTEURARENE = 600;
	/**
	 * Permet de d�finir le type d'instance d'ar�ne
	 */
	String SERVEUR = "serveur";
	/**
	 * Permet de d�finir le type d'instance d'ar�ne
	 */
	String CLIENT = "client";
	/**
	 * Message Deconnexion
	 */
	String DECONNEXION = "deconnexion";
	/**
	 * largeur de la zone de heu de l'ar�ne
	 */
	int LARGEURARENE = 800;
	/**
	 * hauteur d'un mur
	 */
	int HAUTEURMUR = 35;
	/**
	 * largeur d'un mur
	 */
	int LARGEURMUR = 34;
	/**
	 * Hauteur d'un personnage
	 */
	int HAUTEURPERSO = (44+41+42)/3;
	/**
	 * Largeur d'un personnage
	 */
	int LARGEURPERSO = (39+34+31)/3;
	/**
	 * Chemin dossier mur
	 */
	String CHEMINMUR = "murs/";
	/**
	 * Chemin dossier boule
	 */
	String CHEMINBOULE = "boules/";
	/**
	 * Chemin dossier sons
	 */
	String CHEMINSONS = "sons/";
	/**
	 * Chemin de l'image boule
	 */
	String BOULE = CHEMINBOULE + "boule.gif";
	/**
	 * Image mur
	 */
	String IMAGEMUR = CHEMINMUR + "mur.gif";
	/**
	 * Son welcome
	 */
	String SONWELCOME = CHEMINSONS + "welcome.wav";
	/**
	 * Son ambiance
	 */
	String SONAMBIANCE = CHEMINSONS + "ambiance.wav";
	/**
	 * Son death
	 */
	String SONDEATH = CHEMINSONS + "death.wav";
	/**
	 * Son fight
	 */
	String SONFIGHT = CHEMINSONS + "fight.wav";
	/**
	 * Son go
	 */
	String SONGO = CHEMINSONS + "go.wav";
	/**
	 * Son hurt
	 */
	String SONHURT = CHEMINSONS + "hurt.wav";
	/**
	 * Son precedent
	 */
	String SONPRECEDENT = CHEMINSONS + "precedent.wav";
	/**
	 * Son suivant
	 */
	String SONSUIVANT = CHEMINSONS + "suivant.wav";
	/**
	 * tableau des sons de la vue Ar�ne
	 */
	String[] SON =  {CHEMINSONS + "fight.wav", CHEMINSONS + "hurt.wav", CHEMINSONS + "death.wav"} ;
	/**
	 * num�ro correspondant au son FIGHT
	 */
	int FIGHT = 0;
	/**
	 * num�ro correspondant au son HURT
	 */
	int HURT = 1;
	/**
	 * num�ro correspondant au son DEATH
	 */
	int DEATH = 2;
	/**
	 * Extension des fichiers des images des personnages
	 */
	/**
	 * Chemin dossier personnages
	 */
	String CHEMINPERSO = "personnages/";
	/**
	 * ordre pour ajouter une phrase au chat
	 */
	String CHAT = "tchat";
	/**
	 * ordre pour ajouter un mur dans l'ar�ne du serveur
	 */
	String AJOUTMUR = "ajout mur";
	/**
	 * ordre pour ajouter un panel de murs dans l'ar�ne du client
	 */
	String AJOUTPANELMURS = "ajout panel murs";
	/**
	 * ordre pour ajouter une phrase sur l'ar�ne du serveur
	 */
	String AJOUTPHRASE = "ajout phrase";
	/**
	 * ordre pour modifier le contenu du chat
	 */
	String MODIFCHAT = "modif chat";
	/**
	 * ordre pour ajouter un panel jeu dans l'ar�ne du client
	 */
	String AJOUTPANELJEU = "ajout panel jeu";
	/**
	 * ordre pour ajouter un jlabel jeu dans l'arene
	 */
	String AJOUTJLABELJEU = "ajout jlabel jeu";
	/**
	 * ordre pour effectuer un mouvement
	 */
	String ACTION = "action";
	/**
	 * Etat du personnage "marche"
	 */
	String MARCHE = "marche";
	/**
	 * ordre pour afficher l'animation touch�
	 */
	String TOUCHE = "touche";
	/**
	 * ordre pour afficher l'animation mort
	 */
	String MORT = "mort";
	/**
	 * ordre pour jouer un son
	 */
	String JOUESON = "joue son";
	/**
	 * vie de d�part pour tous les joueurs
	 */
	int MAXVIE = 10 ;
	/**
	 * gain de points de vie lors d'une attaque
	 */
	int GAIN = 1 ; 
	/**
	 * perte de points de vie lors d'une attaque
	 */
	int PERTE = 2 ;
	/**
	 * position x min pour le placement du mur
	 */
	int XMIN = 10;
	/**
	 * position x max pour le placement du mur
	 */
	int XMAX = 756;
	/**
	 * position y min pour le placement du mur
	 */
	int YMIN = 11;
	/**
	 * position y max pour le placement du mur
	 */
	int YMAX = 554;
	/**
	 * Valeur d'un pas
	 */
	int PAS = 10;
	/**
	 * Hauteur de la boule
	 */
	int HAUTEURBOULE = 17;
	/**
	 * Largeur de la boule
	 */
	int LARGEURBOULE = 17;

}
