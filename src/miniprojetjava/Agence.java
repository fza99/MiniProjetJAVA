/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojetjava;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author asus
 */
public class Agence {
    
    
    private int code;
    private String nom;
    private ArrayList<Client> clients=new ArrayList<Client>();

    public Agence(int code, String nom) {
        this.code = code;
        this.nom = nom;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }
    
    public void addClient(int code,String nom)
    {
        clients.add(new Client(code, nom));
    }
    
    
    
    //L'ordre!!
    
    public void printClients()
    {
       
        
        System.out.println("Voila l'ensemble des clients de l'agence:"+this.getNom()+" ordonnees selon leur solde!!\n\n");
        
        
        //Voila le code de l'affichage ordonnee!!
        
        Iterator<Client> clientIterator=clients.iterator();
        int i=0;
        while(clientIterator.hasNext())
        {
            Client c=clientIterator.next();
            
            System.out.println("Le client Num:"+i+"---->nom:"+c.getNom()+", cin:"+c.getCin());
            i++;
        }
        
        //Sorting
        
     //   Collections.sort(clients);
        
        System.out.println("After sorting----------------");
       
        
        
    }
    
    
}
