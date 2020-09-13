/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miniprojetjava;

/**
 *
 * @author asus
 */
public class Transaction {
    
    private int codeCompte;// le codeCompte du compte sur lequel je veux effectuer la transaction.
    private String date;
    private int type;
    private double montant; //0 pour depot et 1 pour retrait!

    public Transaction(String date, int type, double montant) {
        this.date = date;
        this.type = type;
        this.montant = montant;
    }

    public Transaction(int codeCompte, String date, int type, double montant) {
        this.codeCompte = codeCompte;
        this.date = date;
        this.type = type;
        this.montant = montant;
    }
    
    

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }
    
    
    
    public void Afficher()
    {
        System.out.println("/nVoila la transaction: date:"+this.date+" , type:"+this.type+ " , montant:"+this.montant);
    }
    
    
    
}
