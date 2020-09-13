/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojetjava;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JRadioButtonMenuItem;

/**
 *
 * @author asus
 */
public class PagePrincipale extends JFrame {

	private JMenuBar menuBar = new JMenuBar();
	private JMenu test1 = new JMenu("Fichier");
	private JMenu test1_2 = new JMenu("Sous ficher");
	private JMenu test2 = new JMenu("Client");
	private JMenu test3 = new JMenu("Compte");
	private JMenu test3_33 = new JMenu("Ajouter");
	private JMenu test4 = new JMenu("Agence");
	private JMenu test5 = new JMenu("Transaction");

	private JMenuItem item1_1 = new JMenuItem("Nouveau");
	private JMenuItem item1 = new JMenuItem("Ouvrir");
	private JMenuItem item2 = new JMenuItem("Quitter");

	private JMenuItem item3_1 = new JMenuItem("Ajouter");
	private JMenuItem item4 = new JMenuItem("Modifier");
	private JMenuItem item5 = new JMenuItem("Rechercher");
	private JMenuItem itemS5_1 = new JMenuItem("Supprimer");
	private JMenuItem item6 = new JMenuItem("Afficher All");

	private JMenuItem item33 = new JMenuItem("Compte Normal");
	private JMenuItem item333 = new JMenuItem("Compte Epargne");
	private JMenuItem item3333 = new JMenuItem("Compte Courant");
	private JMenuItem item4_1 = new JMenuItem("Modifier");
	private JMenuItem item5_1 = new JMenuItem("Rechercher");
	private JMenuItem item6_1 = new JMenuItem("Afficher All");

	private JMenuItem item3_2 = new JMenuItem("Ajouter");
	private JMenuItem item4_2 = new JMenuItem("Modifier");
	private JMenuItem item5_2 = new JMenuItem("Rechercher");
	private JMenuItem item6_2 = new JMenuItem("Afficher All");

	private JMenuItem item3_3 = new JMenuItem("Ajouter");
	
	private JMenuItem item5_3 = new JMenuItem("Rechercher");
	private JMenuItem item6_3 = new JMenuItem("Afficher All");

	private JCheckBoxMenuItem jcmi1 = new JCheckBoxMenuItem("Choix 1");
	private JCheckBoxMenuItem jcmi2 = new JCheckBoxMenuItem("Choix 2");

	private JRadioButtonMenuItem jrmi1 = new JRadioButtonMenuItem("Radio 1");
	private JRadioButtonMenuItem jrmi2 = new JRadioButtonMenuItem("Radio 2");

	/*
	 * public static void main(String[] args){ InterfaceGraphique zFen = new
	 * InterfaceGraphique(); }
	 */

	public PagePrincipale() {

		this.setTitle("                             Gestion des clients.");
		this.setSize(550, 270);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);

		// On initialise nos menus
		this.test1.add(item1_1);
		this.test1.add(item1);
		this.test1.add(item2);
		this.test1.addSeparator();

		// On ajoute les éléments dans notre sous-menu
		this.test1_2.add(jcmi1);
		this.test1_2.add(jcmi2);
		// Ajout d'un séparateur
		this.test1_2.addSeparator();
		// On met nos radios dans un ButtonGroup
		ButtonGroup bg = new ButtonGroup();
		bg.add(jrmi1);
		bg.add(jrmi1);
		// On présélectionne la première radio
		jrmi1.setSelected(true);

		this.test1_2.add(jrmi1);
		this.test1_2.add(jrmi2);

		// Ajout du sous-menu dans notre menu
		this.test1.add(this.test1_2);
		// Ajout d'un séparateur

		// Activation du bouton quitter!
		item2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});

		this.test2.add(item3_1);
		this.test2.add(itemS5_1);
		this.test2.add(item4);
		this.test2.add(item5);
		this.test2.add(item6);

		this.test3_33.add(item33);
		this.test3_33.add(item333);
		this.test3_33.add(item3333);
		this.test3.add(this.test3_33);
		this.test3.add(item4_1);
		this.test3.add(item5_1);
		this.test3.add(item6_1);

		this.test4.add(item3_2);
		this.test4.add(item4_2);
		this.test4.add(item5_2);
		this.test4.add(item6_2);

		this.test5.add(item3_3);
		
		this.test5.add(item5_3);
		this.test5.add(item6_3);
		// L'ordre d'ajout va déterminer l'ordre d'apparition dans le menu de
		// gauche à droite
		// Le premier ajouté sera tout à gauche de la barre de menu et
		// inversement pour le dernier
		this.menuBar.add(test1);
		this.menuBar.add(test2);
		this.menuBar.add(test3);
		this.menuBar.add(test4);
		this.menuBar.add(test5);

		this.setJMenuBar(menuBar);
		// this.setVisible(true);

		// JButton bouton1 = new JButton("Appel à la ZDialog");

		// this.getContentPane().add(bouton1);

		item3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Zclient zd = new Zclient(null, "Ajouter un client", true);
				Client zInfo = zd.showZDialog();
				// JOptionPane jop = new JOptionPane();
				// jop.showMessageDialog(null, zInfo.toString(), "Informations
				// personnage", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		 item4.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZZClient zd = new ZZClient(null, "Modifier un client", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
		 
		 item5.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZZZChercherClient zd = new ZZZChercherClient(null, "Chercher un client", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
		 
		 itemS5_1.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZDeleteClient zd = new ZDeleteClient(null, "Supprimer un client", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
		 
		 item6.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZzzAllclient zd = new ZzzAllclient(null, "Liste des clients", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
		 
		 
  //*************************************************************************************************************
                 
                 item33.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Zcompte zd = new Zcompte(null, "Ajouter un compte Normal!!", true);
				Client zInfo = zd.showZDialog();
				// JOptionPane jop = new JOptionPane();
				// jop.showMessageDialog(null, zInfo.toString(), "Informations personnage", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		 item333.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZcompteEpargne zd = new ZcompteEpargne(null, "Ajouter un compte Epargne!!", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
		 
		 item3333.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZcompteCourant zd = new ZcompteCourant(null, "Ajouter un compte Courant!!", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
		 
		 
		 item4_1.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZZZCompte zd = new ZZZCompte(null, "Modifier un compte!!", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
		 
		 item5_1.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZZZchercherCompte zd = new ZZZchercherCompte(null, "Rechercher un compte!!", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
                 item6_1.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZzzAllcompte zd= new ZzzAllcompte(null, "La liste des comptes!!", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
                 
 //***************************************************************************************************************
                 
                 
		item3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Ztransaction zd = new Ztransaction(null, "Ajouter une transaction!!", true);
				Client zInfo = zd.showZDialog();
				// JOptionPane jop = new JOptionPane();
				// jop.showMessageDialog(null, zInfo.toString(), "Informations
				// personnage", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		

		 
		 item5_3.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZZZChercherTransaction zd = new ZZZChercherTransaction(null, "Chercher une transaction!!", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
		 
		
		 
		 item6_3.addActionListener(new ActionListener(){
		        public void actionPerformed(ActionEvent arg0) {
		        	ZzzAlltransaction zd = new ZzzAlltransaction(null, "Liste des transactions!!", true);
					Client zInfo = zd.showZDialog();
		      }         
		    });
                 
                 
                 
                 
                 
                 

	}

	@Override
	public void setVisible(boolean bln) {
		super.setVisible(true); // To change body of generated methods, choose
								// Tools | Templates.
	}

}
