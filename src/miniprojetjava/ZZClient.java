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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
public class ZZClient extends JDialog {
  private Client zInfo = new Client();
  private boolean sendData;
  private JLabel nomLabel, cinLabel , icon;
 // private JRadioButton tranche1, tranche2, tranche3, tranche4;
  //private JComboBox sexe, cheveux;
  private JTextField nom, cin;

  public ZZClient(JFrame parent, String title, boolean modal){
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
    nomLabel = new JLabel("Saisir un nom :");
    panNom.add(nomLabel);
    panNom.add(nom);
   // panNom.setLayout(new BorderLayout());

    //Le sexe
    JPanel panCin = new JPanel();
    panCin.setBackground(Color.white);
    panCin.setPreferredSize(new Dimension(220, 100));
    cin = new JTextField();
    cin.setPreferredSize(new Dimension(100, 25));
    panCin.setBorder(BorderFactory.createTitledBorder("Cin du client"));
    cinLabel = new JLabel("Saisir un cin :");
    JButton chercher = new JButton("Chercher");
    panCin.add(cinLabel);
    panCin.add(cin);
    panCin.add(chercher);
  
  //  panCin.setLayout(new FlowLayout());
    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panCin);
    content.add(panNom);
   
    //this.getContentPane().setLayout(new FlowLayout());

    JPanel control = new JPanel();
    JButton okBouton = new JButton("Modifier");
    
    okBouton.addActionListener(new ActionListener(){
        
   
      @Override 
      public void actionPerformed(ActionEvent arg0) {     
          
          
        try {
            
           
    
             Connection cnx=Base.ConnectDB();
             Statement ps=cnx.createStatement();
               String sql="update client set nom = '"+nom.getText()+"' where cin = "+cin.getText();     	              
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
				String sql = "select * from client where cin = "+cin.getText();
				ResultSet result = ps.executeQuery(sql);
				result.next();
				nom.setText(result.getString(2));
				
				
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
