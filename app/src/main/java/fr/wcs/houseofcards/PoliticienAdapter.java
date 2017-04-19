package fr.wcs.houseofcards;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eddy on 04/04/17.
 */

public class PoliticienAdapter extends BaseAdapter implements Filterable {

    private ArrayList<Politicien> elus;
    private int layout;
    private Context context;

    private TextView textViewName;
    private TextView textViewRevenus;
    private TextView textViewBullshitLevel;
    private TextView textViewFonction;

    public PoliticienAdapter(ArrayList<Politicien> elus, int layout, Context context) {
        this.elus = elus;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public int getCount() {
        return elus.size();
    }

    @Override
    public Politicien getItem(int position) {
        return elus.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(layout, parent, false);

            Log.d("PoliticienAdapter","Creating New View");

        }

        backgroundColor(position, convertView);
        textViewBullshitLevel = (TextView) convertView.findViewById(R.id.textViewBullshit);
        textViewFonction = (TextView) convertView.findViewById(R.id.textViewFonction);
        textViewName = (TextView) convertView.findViewById(R.id.textViewName);
        textViewRevenus = (TextView) convertView.findViewById(R.id.textViewRevenu);

        Politicien popol = getItem(position);


        textViewRevenus.setText(String.valueOf(popol.getRevenus()));
        textViewName.setText(popol.getName());
        textViewBullshitLevel.setText(String.valueOf(popol.getBullshitLevel()));
        switch (popol.getFonction()){
            case Politicien.DEPUTE :
                textViewFonction.setText(R.string.deputyText);
                break;
            case Politicien.MINISTRE:
                textViewFonction.setText(R.string.ministreText);
                break;

        }
        return convertView;
    }
    public void backgroundColor(int position, View itemView) {
        int bullshit ;
        int j = 255;


        Politicien popol = getItem(position);
        bullshit = popol.getBullshitLevel();

        j = j - j/20 * bullshit;
        if (j>0){
            itemView.setBackgroundColor(Color.argb(255, 255, j, j));
        }
        else{
            itemView.setBackgroundColor(Color.argb(255,0,0,0));
            textViewBullshitLevel.setTextColor(Color.WHITE);
        }



    }

    private Filter mFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {

            FilterResults results = new FilterResults();
            ArrayList<Politicien> filteredPoliticiens = new ArrayList<Politicien>();
            String constraintString=constraint.toString();

            // perform your search here using the searchConstraint String.

            for (int i = 0; i < elus.size(); i++) {

                    if (constraintString.contains(String.valueOf(elus.get(i).getFonction())))  {
                        filteredPoliticiens.add(elus.get(i));
                    }


                }

            results.values = filteredPoliticiens;
            results.count = filteredPoliticiens.size();


            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {

            elus = (ArrayList<Politicien>) results.values;
            notifyDataSetChanged();
        }


    };

    @Override
    public Filter getFilter() {
        return mFilter;
    }



    public void setElu(ArrayList<Politicien> elus){
        this.elus = elus;
    }
}









