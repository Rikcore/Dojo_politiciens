package fr.wcs.houseofcards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by eddy on 04/04/17.
 */

public class PoliticienAdapter extends BaseAdapter {

    private ArrayList<Politicien> elus;
    private int layout;
    private Context context;

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
    public Object getItem(int position) {
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
        }
        return null;
    }
}
