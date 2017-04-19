package fr.wcs.houseofcards;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RadioButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity{

    private ListView polList;
    private ArrayList<Politicien> arrayPol;
    private PoliticienAdapter mAdapter;
    private CheckBox mCheckBoxMinistre;
    private CheckBox mCheckBoxDeputes;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        polList = (ListView) findViewById(R.id.polist);
        arrayPol = new ArrayList<>();

        mCheckBoxDeputes = (CheckBox) findViewById(R.id.checkBoxDeputes);
        mCheckBoxDeputes.setChecked(true);
        mCheckBoxMinistre = (CheckBox) findViewById(R.id.checkBoxMinistre);
        mCheckBoxMinistre.setChecked(true);




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




        mCheckBoxDeputes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mAdapter.setElu(arrayPol);
                    mAdapter.getFilter().filter(String.valueOf(Politicien.DEPUTE));
                }
                if(!(isChecked)) {
                    mAdapter.getFilter().filter(String.valueOf(Politicien.MINISTRE));
                }
                else if (mCheckBoxMinistre.isChecked() && mCheckBoxDeputes.isChecked()){
                    mAdapter = new PoliticienAdapter(arrayPol, R.layout.politician_item, MainActivity.this);
                    polList.setAdapter(mAdapter);
                }
            }
        });


        mCheckBoxMinistre.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    mAdapter.setElu(arrayPol);
                    mAdapter.getFilter().filter(String.valueOf(Politicien.MINISTRE));
                }
                if(!(isChecked)){
                    mAdapter.getFilter().filter(String.valueOf(Politicien.DEPUTE));
                }
                else if (mCheckBoxMinistre.isChecked() && mCheckBoxDeputes.isChecked()){
                    mAdapter = new PoliticienAdapter(arrayPol, R.layout.politician_item, MainActivity.this);
                    polList.setAdapter(mAdapter);
                }
            }
        });
    }




    /*@Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

        switch (buttonView.getId()) {

            case (R.id.checkBoxMinistre):
                if(!(isChecked)) {
                    mAdapter.getFilter().filter(String.valueOf(Politicien.DEPUTE));
                }
                else if (isChecked){
                    mAdapter.setElu(arrayPol);
                }
                break;

            case (R.id.checkBoxDeputes):
                if(!(isChecked)) {
                    mAdapter.getFilter().filter(String.valueOf(Politicien.MINISTRE));
                }
                else if (isChecked){
                    mAdapter.setElu(arrayPol);
                }
                break;

        }
    }*/
}
