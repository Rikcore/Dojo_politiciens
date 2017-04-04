package fr.wcs.houseofcards;

/**
 * Created by eddy on 04/04/17.
 */

public class Loi {

    public static final int DROITE = 1;
    public static final int GAUCHE = 2;
    public static final int CENTRE = 3;

    private String text;
    private int orientation;

    public Loi (String text, int orientation){

        this.text = text;
        this.orientation = orientation;
    }

    public String getText() {
        return text;
    }

    public int getOrientation() {
        return orientation;
    }
}
