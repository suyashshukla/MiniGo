package com.example.suyash.minigo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Travel.ProfileHelper;
import Travel.TravelContract;
import Travel.TravelHelper;

public class LoginActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Spinner from;
    Spinner to;
    ListView listView;
    Button submit;
    TextView name;
    ImageView pic;
    TravelHelper travelHelper;
    ProfileHelper profileHelper;
    String source;
    String destination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        profileHelper = new ProfileHelper(getApplicationContext());
        SQLiteDatabase db = profileHelper.getReadableDatabase();

        String query = "SELECT * FROM " + TravelContract.TravelEntry.TABLE_PROFILE + " WHERE " +
                TravelContract.TravelEntry.COLUMN_EMAIL + " = '" + MainActivity.uname.getText().toString() + "' ; ";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToNext();
        drawerLayout = findViewById(R.id.drawer);
        navigationView = findViewById(R.id.navigation);
        from = findViewById(R.id.from);
        to = findViewById(R.id.to);
        submit = findViewById(R.id.fetch);
        name = findViewById(R.id.name);
        pic = findViewById(R.id.pic);

        int g = cursor.getInt(cursor.getColumnIndex(TravelContract.TravelEntry.COLUMN_GENDER));


        to.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                destination = (String)to.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        from.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                source = (String)from.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        /*if (g == 1) {
            pic.setImageResource(R.drawable.male);
        } else {
            pic.setImageResource(R.drawable.female);
        }*/

       // name.setText(cursor.getString(cursor.getColumnIndex(TravelContract.TravelEntry.COLUMN_NAME)));

        ArrayAdapter fromAdapter = ArrayAdapter.createFromResource(this,R.array.from,android.R.layout.simple_dropdown_item_1line);
        fromAdapter.setDropDownViewResource(android.R.layout.expandable_list_content);


        ArrayAdapter toAdapter = ArrayAdapter.createFromResource(this,R.array.to,android.R.layout.simple_dropdown_item_1line);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);


        from.setAdapter(fromAdapter);
        to.setAdapter(toAdapter);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getTitle().equals("My Profile")){
                    Intent intent = new Intent(LoginActivity.this,UserProfile.class);
                    startActivity(intent);
                }
                else if(item.getTitle().equals("Sign Out")){
                    finish();
                }
                item.setChecked(true);
                drawerLayout.closeDrawers();
                return true;
            }
        });

        ArrayList<String> bus_route = new ArrayList<>();
        bus_route.add("Tekanpur to Gwalior         08:00 AM");
        bus_route.add("Tekanpur to Gwalior         09:10 AM");
        bus_route.add("Tekanpur to Gwalior         02:15 PM");
        bus_route.add("Tekanpur to Gwalior         03:00 PM");
        bus_route.add("Gwalior to Tekanpur         07:00 AM");
        bus_route.add("Gwalior to Tekanpur         12:30 PM");
        bus_route.add("Gwalior to Tekanpur         05:00 PM");
        bus_route.add("Gwalior to Tekanpur         07:30 PM");


        listView = findViewById(R.id.list);
        final ArrayAdapter<String> bus = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,bus_route);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                travelHelper = new TravelHelper(getApplicationContext());
                SQLiteDatabase db = travelHelper.getWritableDatabase();

                ContentValues contentValues = new ContentValues();

                contentValues.put(TravelContract.TravelEntry.COLUMN_NAME,(MainActivity.uname).getText().toString());
                contentValues.put(TravelContract.TravelEntry.COLUMN_FROM,source);
                contentValues.put(TravelContract.TravelEntry.COLUMN_TO,destination);

                db.insert(TravelContract.TravelEntry.TABLE_TRAVEL,null,contentValues);


                listView.setAdapter(bus);
            }
        });




    }
}
