/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojetjava;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author asus
 */
public class InterfaceConnexion extends JDialog{
    
    
    
    
    
  private Client zInfo = new Client();
  private boolean sendData;
  private JLabel nomLabel, cinLabel , icon;
 // private JRadioButton tranche1, tranche2, tranche3, tranche4;
  //private JComboBox sexe, cheveux;
 protected JTextField login, password;

    public InterfaceConnexion() {
    }

 
 
  public InterfaceConnexion(JFrame parent, String title, boolean modal){
      
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
    login = new JTextField();
    login.setPreferredSize(new Dimension(100, 25));
    panNom.setBorder(BorderFactory.createTitledBorder("User login!"));
    nomLabel = new JLabel("Saisir un login :");
    panNom.add(nomLabel);
    panNom.add(login);
   // panNom.setLayout(new BorderLayout());

   
    JPanel panCin = new JPanel();
    panCin.setBackground(Color.white);
    panCin.setPreferredSize(new Dimension(220, 60));
    password = new JTextField();
    password.setPreferredSize(new Dimension(100, 25));
    panCin.setBorder(BorderFactory.createTitledBorder("User password!"));
    cinLabel = new JLabel("Saisir un MdP:");
    panCin.add(cinLabel);
    panCin.add(password);
  
  
  //  panCin.setLayout(new FlowLayout());
    JPanel content = new JPanel();
    content.setBackground(Color.white);
    content.add(panNom);
    content.add(panCin);
    //this.getContentPane().setLayout(new FlowLayout());

    JPanel control = new JPanel();
    JButton okBouton = new JButton("Valider");
    
  /*  okBouton.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent arg0) {        
        zInfo = new Client(Integer.parseInt(password.getText()),login.getText());
        setVisible(true);
      }});*/


     okBouton.addActionListener(new ValiderListener());
    

  
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
    


    @Override
    public void setVisible(boolean bln) {
        super.setVisible(bln); //To change body of generated methods, choose Tools | Templates.
    }
    

    //valider.addActionListener(new ValiderListener());
   
    
  

class ValiderListener extends JFrame implements ActionListener {

/**
 * 
 */
    
    //Connection cnx=null;
    ResultSet Rs=null;
    PreparedStatement ps=null;
    
    Connection cnx=Base.ConnectDB();
    
private static final long serialVersionUID = 1L;

@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
try {
        String sql="select id_user from utilisateur where login='"+login.getText()+"' and password='"+password.getText()+"'";
       	
        ps=cnx.prepareStatement(sql);
        Rs=ps.executeQuery();
        if(Rs.next())
        {
            System.out.println("Voila l'id_user:"+Rs.getInt(1));
            
            
            //JOptionPane.showMessageDialog(null,"Connection réussie ! ");
           
            //this.dispose();
            
            PagePrincipale pp1=new PagePrincipale();
         
            pp1.setVisible(true);
            
            
        
        }
        else {
                    JOptionPane.showMessageDialog(null,"Connection échoué! ");
        }
        
       
      }
catch (Exception ex) {
      JOptionPane.showMessageDialog(null,e);
    }
}
}
}