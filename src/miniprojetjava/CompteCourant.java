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
public class CompteCourant extends Compte implements Comparable{
    
    private double decouvertAutorise;

    public CompteCourant(double decouvertAutorise, int cin, double solde) {
        super(cin, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    
    public double getDecouvertAutorise() {
        return decouvertAutorise;
    }

    public void setDecouvertAutorise(double decouvertAutorise) {
        this.decouvertAutorise = decouvertAutorise;
    }
    
    
    
    @Override
       public double retirer(double montant)
    {
        if(solde+decouvertAutorise>=montant)
             this.solde-=montant;
        else
            System.out.println("Attention!! Votre solde est insuffisant.\n");
        
        return(this.solde);
    }

    @Override
    public String toString() {
        super.toString();
        return "compteCourant{" + "decouvertAutorise=" + decouvertAutorise + '}';
    }

    @Override
    public void afficher(){
       // super.afficher();
         System.out.println(" ,decouvertAutorise="+decouvertAutorise);
     }
    
    
   //Implementation de la fonction compareTo. 
   
    @Override
    public int compareTo(Object v)
    {
        CompteCourant c=(CompteCourant)v;
        int res;
        if(this.decouvertAutorise>c.decouvertAutorise)
               res=1;
        else if(this.decouvertAutorise==c.decouvertAutorise)
            res=0;
        else 
            res=-1;

        return res;
    }
    
    
}
