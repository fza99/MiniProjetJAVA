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
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author asus
 */
public class ZzzAllclient extends JDialog {
  private Client zInfo = new Client();
  private boolean sendData;
  private JLabel nomLabel, cinLabel , icon;
 // private JRadioButton tranche1, tranche2, tranche3, tranche4;
  //private JComboBox sexe, cheveux;
  private JTextField nom, cin;

  public ZzzAllclient(JFrame parent, String title, boolean modal){
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
	  ResultSet result = null;
	  int i = 0;
	  try {
		  Connection cnx=Base.ConnectDB();
			Statement ps = cnx.createStatement();
			String sql = "select * from client";
			result = ps.executeQuery(sql);
			while(result.next()) {
			      i++;
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  
	  
	 
	  
	  
	  Object[][] donnees = new Object[i][2];
	  boolean cont=false;
	  try {
		cont=result.first();
	} catch (SQLException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	  try {
		 int a=0;
		while(cont) {
		     donnees[a][0]=result.getInt(1);
		     donnees[a][1]=result.getString(2);
		     a++;
		     cont=result.next();
		  }
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	    

      String[] entetes = {"CIN", "Nom"};

      JTable tableau = new JTable(donnees, entetes);
   
     
  //  panCin.setLayout(new FlowLayout());
      
      
 
    JPanel content = new JPanel();
    content.setBackground(Color.pink);
    content.add(tableau);
    
    

   
    //this.getContentPane().setLayout(new FlowLayout());

    JPanel control = new JPanel();



     

  
    JButton cancelBouton = new JButton("Fermer");
    cancelBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {
             System.exit(0);
          
       // setVisible(true);
      }      
    });
    
    control.add(cancelBouton);

  //  this.getContentPane().add(panIcon, BorderLayout.WEST);
    this.getContentPane().add(content, BorderLayout.CENTER);
    this.getContentPane().add(control, BorderLayout.SOUTH);
  }  
}
