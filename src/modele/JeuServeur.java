package modele;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;

import javax.swing.JLabel;

import controleur.Controle;
import controleur.Global;
import outils.connexion.Connection;

/**
 * Gestion du jeu c�t� serveur
 *
 */
public class JeuServeur extends Jeu implements Global {
	

	/**
	 * Collection de murs
	 */
	private ArrayList<Mur> lesMurs = new ArrayList<Mur>() ;
	/**
	 * Collection de joueurs
	 */
	private Hashtable<Connection, Joueur> lesJoueurs = new Hashtable<Connection, Joueur>() ;
	/**
	 * Retourne la collection de joueurs du serveur
	 * @return lesJoueurs
	 */
	public Collection getLesJoueurs() {
		return lesJoueurs.values();
	}

	private Collection joueurs;
	
	/**
	 * Constructeur
	 */
	public JeuServeur(Controle controle) {
		super.controle = controle;
	}
	
	@Override
	public void connexion(Connection connection) {	
		lesJoueurs.put(connection, new Joueur(this));
	}
	
	@Override
	public void reception(Connection connection, Object info) {
		String[] infos = ((String)info).split(STRINGSEPARE);
		String ordre = infos[0];
		switch (ordre) {
		case PSEUDO :
			this.controle.evenementJeuServeur("ajout panel murs", connection);
			String pseudo = infos[1];
			int numPerso = Integer.parseInt(infos[2]);
			this.lesJoueurs.get(connection).initPerso(pseudo, numPerso, this.lesJoueurs.values(), this.lesMurs);
			String messageConnection = "*** "+this.lesJoueurs.get(connection).getPseudo()+" vient de se connecter ***";
			this.controle.evenementJeuServeur(AJOUTPHRASE, messageConnection);
			break;
		case CHAT :
			String phrase = infos[1];
			phrase = this.lesJoueurs.get(connection).getPseudo()+" > "+phrase;
			this.controle.evenementJeuServeur(AJOUTPHRASE, phrase);
			break;
		case ACTION :
			Integer action = Integer.parseInt(infos[1]);
			this.lesJoueurs.get(connection).action(action, this.lesJoueurs.values(), this.lesMurs);
			break;
		}
	}
	
	@Override
	public void deconnexion(Connection connection) {
		this.lesJoueurs.get(connection).departJoueur();
		this.lesJoueurs.remove(connection);
	}

	/**
	 * Envoi d'une information vers tous les clients
	 * fais appel plusieurs fois � l'envoi de la classe Jeu
	 */
	public void envoi(Object info) {
		for(Connection connection : this.lesJoueurs.keySet()) {
			super.envoi(connection, info);
		}
	}
	
	public void envoiATous() {
		for(Connection connection : this.lesJoueurs.keySet()) {
			this.controle.evenementJeuServeur(AJOUTPANELJEU, connection);
		}
	}

	/**
	 * G�n�ration des murs
	 */
	public void constructionMurs() {
		for(int k = 0; k < 20; k++) {
			this.lesMurs.add(new Mur());
			this.controle.evenementJeuServeur(AJOUTMUR, lesMurs.get(lesMurs.size()-1).getjLabel());
		}
	}

	public void ajoutJLabelJeuArene(JLabel unJLabel) {
		this.controle.evenementJeuServeur("ajout jlabel jeu", unJLabel);
	}
	
}
