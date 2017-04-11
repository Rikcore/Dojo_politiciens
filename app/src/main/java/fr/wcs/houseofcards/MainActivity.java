package fr.wcs.houseofcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView polList;
    private ArrayList<Politicien> arrayPol;
    private PoliticienAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        polList = (ListView) findViewById(R.id.polist);
        arrayPol = new ArrayList<>();


        arrayPol.add(new Ministre(12000, 9999999, Parti.PS, "Valls"));
        arrayPol.add(new Depute(1000, 999, Parti.EELV, true, "Jean Pascal"));
        arrayPol.add(new Ministre(12000, 7837, Parti.PS, "El Khomri"));
        arrayPol.add(new Depute(12000, 9999999, Parti.FN, false, "Marine"));
        arrayPol.add(new Ministre(12000, 9999999, Parti.PS, "Valls"));
        arrayPol.add(new Ministre(12000, 9999999, Parti.PS, "Valls"));

        mAdapter = new PoliticienAdapter(arrayPol, R.layout.politician_item, this);

        polList.setAdapter(mAdapter);

        polList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                arrayPol.get(position).bullshit();
                mAdapter.notifyDataSetChanged();
            }
        });


    }
}
