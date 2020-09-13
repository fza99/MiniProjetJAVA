/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojetjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author asus
 */
public class ZcompteEpargne extends JDialog {
  private Client zInfo = new Client();
  private boolean sendData;
  private JLabel nomLabel, codeLabel, cinLabel ,soldeLabel ,tauxLabel , icon;
 // private JRadioButton tranche1, tranche2, tranche3, tranche4;
  //private JComboBox sexe, cheveux;
  private JTextField nom, code, solde, cin, tauxInteret;

  public ZcompteEpargne(JFrame parent, String title, boolean modal){
    super(parent, title, modal);
    this.setSize(550, 270);
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
    this.initComponent();
  }

  public Client showZDialog(){
    this.sendData = false;
    this.setVisible(true);      
    return this.zInfo;      
  }

  private void initComponent(){
   
      //Les informations de l'agence bancaire!
      
      //Le code!
      //Le nom!

    //Le nom
    JPanel panNom = new JPanel();
    panNom.setBackground(Color.white);
    panNom.setPreferredSize(new Dimension(220, 60));
    nom = new JTextField();
    nom.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("Nom du client"));
    nomLabel = new JLabel("le nom du client:");
    panNom.add(nomLabel);
    panNom.add(nom);
   // panNom.setLayout(new BorderLayout());

    //Le code
    JPanel panCode = new JPanel();
    panCode.setBackground(Color.white);
    panCode.setPreferredSize(new Dimension(220, 60));
    code = new JTextField();
    code.setPreferredSize(new Dimension(100, 25));
    panCode.setBorder(BorderFactory.createTitledBorder("Code du compte"));
    codeLabel = new JLabel("Saisir un code :");
    panCode.add(codeLabel);
    panCode.add(code);
    
    //Le solde
    JPanel panSolde = new JPanel();
    panSolde.setBackground(Color.white);
    panSolde.setPreferredSize(new Dimension(220, 60));
    solde = new JTextField();
    solde.setPreferredSize(new Dimension(100, 25));
    panSolde.setBorder(BorderFactory.createTitledBorder("Solde du compte"));
    codeLabel = new JLabel("Saisir un solde :");
    panSolde.add(codeLabel);
    panSolde.add(solde);
    
     JPanel panCin = new JPanel();
    panCin.setBackground(Color.white);
    panCin.setPreferredSize(new Dimension(220, 60));
    cin = new JTextField();
    cin.setPreferredSize(new Dimension(100, 25));
    panCin.setBorder(BorderFactory.createTitledBorder("Cin du client"));
    cinLabel = new JLabel("Saisir un cin :");
    panCin.add(cinLabel);
    panCin.add(cin);
    
    
    //Le tauxInteret
    JPanel pantaux = new JPanel();
    pantaux.setBackground(Color.white);
    pantaux.setPreferredSize(new Dimension(220, 60));
    tauxInteret = new JTextField();
    tauxInteret.setPreferredSize(new Dimension(100, 25));
    pantaux.setBorder(BorderFactory.createTitledBorder("le taux d'Interet:"));
    tauxLabel = new JLabel("le taux d'interet:");
    pantaux.add(tauxLabel);
    pantaux.add(tauxInteret);
  
  
  //  panCin.setLayout(new FlowLayout());
    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);
    content.add(panCin);
    content.add(panCode);
    content.add(panSolde);
    content.add(pantaux);
    //this.getContentPane().setLayout(new FlowLayout());

    JPanel control = new JPanel();
    JButton okBouton = new JButton("Ajouter");
    
    okBouton.addActionListener(new ActionListener(){
        
   
      @Override 
      public void actionPerformed(ActionEvent arg0) {     
          
          
        try {
            
           
    
             Connection cnx=Base.ConnectDB();
             Statement ps=cnx.createStatement();
             String sql="insert into compteepargne(code,solde,cin,tauxInteret) values('"+code.getText()+"','"+solde.getText()+"','"+cin.getText()+"','"+tauxInteret.getText()+"')"; 
             String sql1="insert into client(cin,nom) values('"+cin.getText()+"','"+nom.getText()+"')";             
             ps.executeUpdate(sql);
             ps.executeUpdate(sql1);
             
             JOptionPane.showMessageDialog(null,"le compteEpargne est bien Ajoute! ");
               
             
             
            // PagePrincipale pp1=new PagePrincipale();
         
            // pp1.setVisible(true);
           
           
        } 
        
       
        catch (Exception ex) {
                JOptionPane.showMessageDialog(null,ex);
        }
      }});


     

  
    JButton cancelBouton = new JButton("Annuler");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
             System.exit(0);
          
       // setVisible(true);
      }      
    });

    control.add(okBouton);
    control.add(cancelBouton);

  //  this.getContentPane().add(panIcon, BorderLayout.WEST);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}
