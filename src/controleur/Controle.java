package controleur;

import outils.connexion.ServeurSocket;

import javax.swing.JLabel;
import javax.swing.JPanel;

import modele.Jeu;
import modele.JeuClient;
import modele.JeuServeur;
import outils.connexion.AsyncResponse;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;
import vue.Arene;
import vue.ChoixJoueur;
import vue.EntreeJeu;


/**
 * Contr�leur et point d'entr�e de l'applicaton 
 * @author emds
 *
 */
public class Controle implements AsyncResponse, Global {

	private EntreeJeu frmEntreeJeu ;
	private Arene frmArene;
	private ChoixJoueur frmChoixJoueur;
	private Jeu leJeu;
	
	@Override
	public void reception(Connection connection, String ordre, Object info) {
		// TODO Auto-generated method stub
		switch(ordre) {
		case "connexion" :
			if (!(this.leJeu instanceof JeuServeur)) {
				this.leJeu = new JeuClient(this);
				this.leJeu.connexion(connection);
				this.frmEntreeJeu.dispose();
				this.frmArene = new Arene(this, CLIENT);
				this.frmChoixJoueur = new ChoixJoueur(this);
				this.frmChoixJoueur.setVisible(true);			
			} else {
				this.leJeu.connexion(connection);
			}
		break;
		case "r�ception" :
			this.leJeu.reception(connection, info);
		break;
		case "d�connexion" :
			this.leJeu.deconnexion(connection);
		break;
		}
	}

	/**
	 * M�thode de d�marrage
	 * @param args non utilis�
	 */
	public static void main(String[] args) {
		new Controle();
	}
	
	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new EntreeJeu(this) ;
		this.frmEntreeJeu.setVisible(true);
	}
	
	/**
	 * Connexion au client ou au serveur
	 * @param info
	 */
	public void evenementEntreeJeu(String info) {
		// Connexion au serveur
		if (info.equals("serveur")) {
			new ServeurSocket(this, PORT);
			this.leJeu = new JeuServeur(this);
			this.frmEntreeJeu.dispose();
			this.frmArene = new Arene(this, SERVEUR);
			((JeuServeur)this.leJeu).constructionMurs();
			this.frmArene.setVisible(true);			
		}
		else {
			// Connexion au client
			new ClientSocket(this, info, PORT);
		}
	}
	
	/**
	 * Re�oit le Pseudo et le numero de joueur
	 */
	public void evenementChoixJoueur(String pseudo, int numPerso) {
		this.frmChoixJoueur.dispose();
		this.frmArene.setVisible(true);
		((JeuClient)this.leJeu).envoi(PSEUDO + STRINGSEPARE + pseudo + STRINGSEPARE + numPerso);
	}
	
	/**
	 * Demande provenant de JeuServeur
	 * @param ordre
	 * @param info
	 */
	public void evenementJeuServeur(String ordre, Object info) {
		switch (ordre) {
		case AJOUTMUR:
			frmArene.ajoutMurs(info);
			break;
		case AJOUTPANELMURS:
			this.leJeu.envoi((Connection)info, this.frmArene.getJpnMur());
			break;
		case AJOUTJLABELJEU:
			this.frmArene.ajoutJLabelJeu((JLabel)info);
			break;
		case AJOUTPANELJEU:
			this.leJeu.envoi((Connection)info, this.frmArene.getJpnJeu());
			break;
		case AJOUTPHRASE :
			this.frmArene.ajoutChat((String)info);
			((JeuServeur)this.leJeu).envoi(this.frmArene.getTxtChat());
			break;
		}
	}
	
	/**
	 * Demande provenant de JeuClient
	 * @param ordre
	 * @param info
	 */
	public void evenementJeuClient(String ordre, Object info) {
		switch (ordre) {
		case AJOUTPANELMURS:
			this.frmArene.setJpnMur((JPanel)info);
			break;
		case AJOUTPANELJEU:
			this.frmArene.setJpnJeu((JPanel)info);
			break;
		case MODIFCHAT :
			this.frmArene.setTxtChat((String)info);
			break;
		case JOUESON :
			this.frmArene.joueSon((Integer)info);
			break;
		}
	}

	/**
	 * Envoie une info vers l'ordinateur distant
	 * @param connection
	 * @param info
	 */
	public void envoi(Connection connection, Object info) {
		connection.envoi(info);
	}
	
	/**
	 * G�re une information provenant de la vue Arene
	 * @param phrase
	 */
	public void evenementArene(Object info) {
		if(info instanceof String) {
			((JeuClient)this.leJeu).envoi(CHAT + STRINGSEPARE + (String)info);
		}else if(info instanceof Integer){
			((JeuClient)this.leJeu).envoi(ACTION + STRINGSEPARE + info);
		}
		
	}
}
