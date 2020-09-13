/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojetjava;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author asus
 */
public class Compte {
    
    // private  int code;
    protected int code;
   //public static int cpt=0;
    protected static int cpt=0;
   // private String nom;
    protected int cin;
   // private double solde;
    protected double solde;
    
    //private static final int nbrTran_Max=100;	
    
   // private static transaction Transaction[]=new transaction[nbrTran_Max];
    
    //public static int nbLigneReel=-1;
    
   private static ArrayList<Transaction> Transaction =new ArrayList<>();
            
    public Compte(int cin, double solde) {
        this.cin = cin;
        this.solde = solde;
        this.cpt++;
        this.code=cpt;
        //this.Transaction=new transaction[nbrTran_Max];       
    }

    public Compte() {
    }
    
    

    // La fonction qui permet de recuperer la date actuelle!
    
    public String dateActuelle()
    {
          Date actuelle = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          String dat = dateFormat.format(actuelle);
          return (dat);
    }
    
   
    //public /*static transaction[] */ addTransaction(int type, double montant,String date);
            
    public static void addTransaction(int type, double montant,String date)
    {
        if(type==0)
        {
            //compte.nbLigneReel++;
           // compte.Transaction[nbLigneReel]=new transaction(date,0, montant);
            Transaction.add(new Transaction(date, 0, montant));
            
        }else if(type==1){
            // compte.nbLigneReel++;
           // compte.Transaction[nbLigneReel]=new transaction(date,1, montant);
            Transaction.add(new Transaction(date, 1, montant));
            
        }
       // return compte.Transaction;
    } 
  
    public int getCode() {
        return code;
    }



    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }
    
    
    
    
    public double deposer(double montant)
    {
        this.solde+=montant;
        
        //compte.nbLigneReel++;
       // compte.Transaction[nbLigneReel]=new transaction(this.dateActuelle(),0, montant);
        
        return(this.solde);
    }
    
     public double retirer(double montant)
    {
        if(solde>=montant)
        {
            this.solde-=montant;
             //compte.nbLigneReel++;
            //compte.Transaction[nbLigneReel]=new transaction(this.dateActuelle(),1, montant);
            
        }
             
        else
            System.out.println("Attention!! Votre solde est insuffisant.");
        
        return(this.solde);
    }

    public void afficher(){
         System.out.println("Code="+code+ ", cin="+ cin + ", solde=" + solde);
     }
   // public abstract void afficher();
    
    @Override
    public String toString() {
       return "Code="+ code +", cin=" + cin + ", solde=" + solde ;
    }
     
    
    public static void afficherTransaction()
    {
        /*for(int i=0;i<Transaction.length;i++)
        {
            System.out.println("Voila la transaction numero:"+ (i+1) +"-->date: "+Transaction[i].getDate()+" ,type: "+Transaction[i].getType()+" ,montant:"+Transaction[i].getMontant());
        }*/
        
        int i=0;
        
        for(Transaction tr:Transaction)
        {
            System.out.println("Voila les infos de la transaction Num:"+(i+1)+"--->date:"
                    +tr.getDate()+", type:"+tr.getType()+", montant:"+tr.getMontant());
            i++;
        }
    }      
    
}
