package fr.wcs.houseofcards;

/**
 * Created by eddy on 04/04/17.
 */

public abstract class Politicien implements Malhonnete {

    private int revenus;
    private boolean casierJudiciaire = false;
    private double patrimoine;
    private int bullshitLevel = 0;
    private Parti parti;
    private String name;
    public final static int MINISTRE = 1;
    public final static int DEPUTE = 2;


    public Politicien(int revenus, double patrimoine, Parti parti, String name) {
        this.revenus = revenus;
        this.patrimoine = patrimoine;
        this.parti = parti;
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public Parti getParti(){
        return parti;
    }

    protected int getEntente(){
        switch (getParti()){
            case EELV:
            case PS :
            case NPA:
            case FI :
                return Loi.GAUCHE;

            case LR :
            case FN:
                return Loi.DROITE;

            case EnMarche:
                return  Loi.CENTRE;
            default:
                return Loi.CENTRE;
        }
    }

    public int getRevenus() {
        return revenus;
    }

    public boolean hasCasierJudiciaire() {
        return casierJudiciaire;
    }

    public double getPatrimoine() {
        return patrimoine;
    }

    public int getBullshitLevel() {
        return bullshitLevel;
    }

    public void setRevenus(int revenus) {
        this.revenus = revenus;
    }

    public void setCasierJudiciaire(boolean casierJudiciaire) {
        this.casierJudiciaire = casierJudiciaire;
    }

    public void setPatrimoine(double patrimoine) {
        this.patrimoine = patrimoine;
    }

    public void setBullshitLevel(int bullshitLevel) {
        this.bullshitLevel = bullshitLevel;
    }

    @Override
    public void bullshit() {
        bullshitLevel++;
    }

    @Override
    public void caughtByMediaPart() {
        casierJudiciaire=true;
    }

    public abstract int getFonction();


}
