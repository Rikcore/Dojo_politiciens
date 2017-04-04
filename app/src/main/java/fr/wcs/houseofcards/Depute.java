package fr.wcs.houseofcards;

/**
 * Created by eddy on 04/04/17.
 */

public class Depute extends Politicien {
    private boolean assiduite;

    public Depute(int revenus, double patrimoine, Parti parti, boolean assiduite) {
        super(revenus, patrimoine, parti);
        this.assiduite = assiduite;
    }

    public boolean vote(Loi loi){
        return loi.getOrientation() == this.getEntente();
    }

    public boolean estAssidu(){
        return this.assiduite;
    }


}
