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
public class Ztransaction extends JDialog {
  private Client zInfo = new Client();
  private boolean sendData;
  private JLabel codeLabel, dateLabel, montantLabel,typeLabel , icon;
 // private JRadioButton tranche1, tranche2, tranche3, tranche4;
  //private JComboBox sexe, cheveux;
  private JTextField codeCompte,date,montant,type;

  public Ztransaction(JFrame parent, String title, boolean modal){
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
   
    

    //Le codeCompte

    JPanel panCode = new JPanel();
    panCode.setBackground(Color.white);
    panCode.setPreferredSize(new Dimension(220, 60));
    codeCompte = new JTextField();
    codeCompte.setPreferredSize(new Dimension(100, 25));
    panCode.setBorder(BorderFactory.createTitledBorder("Code du compte"));
    codeLabel = new JLabel("Saisir un code :");
    panCode.add(codeLabel);
    panCode.add(codeCompte);
   // panNom.setLayout(new BorderLayout());

    //La date
    JPanel panDate = new JPanel();
    panDate.setBackground(Color.white);
    panDate.setPreferredSize(new Dimension(220, 60));
    date = new JTextField();
    date.setPreferredSize(new Dimension(100, 25));
    panDate.setBorder(BorderFactory.createTitledBorder("date de transaction"));
    dateLabel = new JLabel("Saisir la date :");
    panDate.add(dateLabel);
    panDate.add(date);
    
    //Le montant
    
    JPanel panMontant = new JPanel();
    panMontant.setBackground(Color.white);
    panMontant.setPreferredSize(new Dimension(220, 60));
    montant = new JTextField();
    montant.setPreferredSize(new Dimension(100, 25));
    panMontant.setBorder(BorderFactory.createTitledBorder("montant de transaction"));
    montantLabel = new JLabel("Saisir le montant:");
    panMontant.add(montantLabel);
    panMontant.add(montant);
    
    //Le type
    
    JPanel panType = new JPanel();
    panType.setBackground(Color.white);
    panType.setPreferredSize(new Dimension(220, 60));
    type = new JTextField();
    type.setPreferredSize(new Dimension(100, 25));
    panType.setBorder(BorderFactory.createTitledBorder("Le type de la transaction"));
    typeLabel = new JLabel("Saisir le type 0/1:");
    panType.add(typeLabel);
    panType.add(type);
  
  
  //  panCin.setLayout(new FlowLayout());
    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panCode);
    content.add(panDate);
    content.add(panMontant);
    content.add(panType);
    //this.getContentPane().setLayout(new FlowLayout());

    JPanel control = new JPanel();
    JButton okBouton = new JButton("Ajouter");
    
    okBouton.addActionListener(new ActionListener(){
        
   
      @Override 
      public void actionPerformed(ActionEvent arg0) {     
          
          
        try {
            
           
    
             Connection cnx=Base.ConnectDB();
             Statement ps=cnx.createStatement();
             if(Integer.parseInt(type.getText())==0)
             {
             String sql="insert into transaction(codeCompte,date,montant,type) values('"+codeCompte.getText()+"','"+date.getText()+"','"+montant.getText()+"','"+type.getText()+"')";     
             String sql1="update compte set solde=solde-'"+montant.getText()+"' where codeCompte='"+codeCompte.getText()+"'";
             
             ps.executeUpdate(sql);
             ps.executeUpdate(sql1); 
             
             
             PagePrincipale pp1=new PagePrincipale();
         
             pp1.setVisible(true);
             }
             else
             {
             
                 String sql="insert into transaction(codeCompte,date,montant,type) values('"+codeCompte.getText()+"','"+date.getText()+"','"+montant.getText()+"','"+type.getText()+"')";     
                 String sql1="update compte set solde=solde+'"+montant.getText()+"' where codeCompte='"+codeCompte.getText()+"'";
             
             ps.executeUpdate(sql);
             ps.executeUpdate(sql1); 
             
             
             PagePrincipale pp1=new PagePrincipale();
         
             pp1.setVisible(true);
             }
           
           
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
