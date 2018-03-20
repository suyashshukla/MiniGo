package com.example.suyash.minigo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

import Travel.TravelContract;
import Travel.TravelHelper;

public class Agency extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agency);


    ArrayList<Passenger> passengers = new ArrayList<>();

        TravelHelper travelHelper = new TravelHelper(getApplicationContext());
        SQLiteDatabase db = travelHelper.getReadableDatabase();

        String query = "SELECT * FROM "+ TravelContract.TravelEntry.TABLE_TRAVEL+";";

        Cursor c = db.rawQuery(query,null);

        while(c.moveToNext()){

            passengers.add(new Passenger(c.getString(c.getColumnIndex(TravelContract.TravelEntry.COLUMN_NAME)),c.getString(c.getColumnIndex(TravelContract.TravelEntry.COLUMN_FROM)),c.getString(c.getColumnIndex(TravelContract.TravelEntry.COLUMN_TO))));
        }


    ListView list_data = findViewById(R.id.list_data);

    PassengerAdapter passengerAdapter = new PassengerAdapter(this,passengers);

    list_data.setAdapter(passengerAdapter);

    list_data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            CheckBox checkBox = (CheckBox)view;

            if(checkBox.isChecked()){

            }
        }
    });

    }






}
