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
public class CompteEpargne extends Compte implements Comparable {
    
    private double tauxInteret;

    public CompteEpargne(double tauxInteret, int cin, double solde) {
        super(cin, solde);
        this.tauxInteret = tauxInteret;
    }

    public double getTauxInteret() {
        return tauxInteret;
    }

    public void setTauxInteret(double tauxInteret) {
        this.tauxInteret = tauxInteret;
    }

    @Override
    public double deposer(double montant)
    {
        this.solde+=montant+(montant*tauxInteret);
        
        return(this.solde);
    }

    @Override
    public String toString() {
        super.toString();
        return "compteEpargne{" + "tauxInteret=" + tauxInteret + '}';
    }
    
    @Override
    public void afficher(){
       // super.afficher();
         System.out.println(" ,tautInteret="+tauxInteret);
     }
    
    @Override
    public int compareTo(Object v)
    {
        int res;
        
        CompteEpargne c=(CompteEpargne)v;
        
        if(this.tauxInteret>c.tauxInteret)
            res=1;
        else if(this.tauxInteret==c.tauxInteret)
            res=0;
        else 
            res=-1;
        
        return res;
    }
    
    
    
}
