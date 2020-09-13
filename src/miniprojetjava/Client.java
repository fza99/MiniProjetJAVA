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
public class Client implements Comparable{
    
    private int cin;
    private String nom;
    private  ArrayList <Compte> comptes= new ArrayList<>();
    

    public Client() {
    }

  
    
    
    
    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(ArrayList<Compte> comptes) {
        this.comptes = comptes;
    }

    public Client(int cin, String nom) {
        this.cin = cin;
        this.nom = nom;
    }
    public void addCompte(double soldeInitial)
    {
        comptes.add(new Compte(this.cin, soldeInitial));
    }
    
    public void printCompte()
    {
        int i=0;
        
        System.out.println("Voila les informations de l'ensemble des comptes du client:"+this.getNom()+"\n\n");
        
        
        for(Compte cp:comptes)
        {
            System.out.println("Voila les infos du compte:"+(i+1)+"--->nom:"
                    +cp.getCin()+", code:"+cp.getCode()+", solde:"+cp.getSolde()+"\n");
            i++;
        }
    }
    
    
    
    
     public String dateActuelle()
    {
          Date actuelle = new Date();
          DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
          String dat = dateFormat.format(actuelle);
          return (dat);
    }
     
     
     
     
     
     
     
     
     
     
     
     
     //L'ordre!!!!
     
     
     
     
     public double sommeSoldes(){
         
       int res=0;
        
        for(Compte cp:comptes)
        {
            res+=cp.getSolde();
        }
        
        return res;
     }
     
     
     
     
    @Override
    public int compareTo(Object v)
    {
        Client c=(Client)v;
        
        
        if(this.sommeSoldes()>c.sommeSoldes())
            return 1;
        else if(this.sommeSoldes()<c.sommeSoldes())
            return -1;
        else 
            return 0;
    }
    
    
}
