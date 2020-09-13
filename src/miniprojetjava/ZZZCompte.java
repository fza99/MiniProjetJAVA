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
import java.sql.ResultSet;
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
public class ZZZCompte extends JDialog {
  private Client zInfo = new Client();
  private boolean sendData;
  private JLabel codeLabel, soldeLabel , icon;
 // private JRadioButton tranche1, tranche2, tranche3, tranche4;
  //private JComboBox sexe, cheveux;
  private JTextField codeCompte, solde;

  public ZZZCompte(JFrame parent, String title, boolean modal){
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
    JPanel panSolde= new JPanel();
    panSolde.setBackground(Color.white);
    panSolde.setPreferredSize(new Dimension(220, 60));
    solde = new JTextField();
    solde.setPreferredSize(new Dimension(100, 25));
    panSolde.setBorder(BorderFactory.createTitledBorder("Solde Compte"));
    soldeLabel = new JLabel("Le solde :");
    panSolde.add(soldeLabel);
    panSolde.add(solde);
   // panNom.setLayout(new BorderLayout());

    //Le code.
    JPanel panCode= new JPanel();
    panCode.setBackground(Color.white);
    panCode.setPreferredSize(new Dimension(220, 100));
    codeCompte = new JTextField();
    codeCompte.setPreferredSize(new Dimension(100, 25));
    panCode.setBorder(BorderFactory.createTitledBorder("Code compte"));
    codeLabel = new JLabel("Saisir un code :");
    JButton chercher = new JButton("Chercher");
    panCode.add(codeLabel);
    panCode.add(codeCompte);
    panCode.add(chercher);
  
  //  panCin.setLayout(new FlowLayout());
    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panCode);
    content.add(panSolde);
   
    //this.getContentPane().setLayout(new FlowLayout());

    JPanel control = new JPanel();
    JButton okBouton = new JButton("Modifier");
    
    okBouton.addActionListener(new ActionListener(){
        
   
      @Override 
      public void actionPerformed(ActionEvent arg0) {     
          
          
        try {
            
           
    
             Connection cnx=Base.ConnectDB();
             Statement ps=cnx.createStatement();
               String sql="update compte set codeCompte = '"+codeCompte.getText()+"' where solde = "+solde.getText();     	              
               ps.executeUpdate(sql);
              // JOptionPane.showMessageDialog(null,"Connection réussie ! ");          
           
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
    
    chercher.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			try {
				Connection cnx=Base.ConnectDB();
				Statement ps=cnx.createStatement();
				String sql = "select * from compte where codeCompte = "+codeCompte.getText();
				ResultSet result = ps.executeQuery(sql);
				result.next();
                                 
                                
				solde.setText(result.getString(2));
				
				
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            
		}
	});

    control.add(okBouton);
    control.add(cancelBouton);

  //  this.getContentPane().add(panIcon, BorderLayout.WEST);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}
