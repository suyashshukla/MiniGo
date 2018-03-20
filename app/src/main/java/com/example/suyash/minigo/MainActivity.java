package com.example.suyash.minigo;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import Travel.ProfileHelper;
import Travel.TravelContract;

public class MainActivity extends AppCompatActivity {

TextView register;
Button login;
public static EditText uname;
EditText pword;
ProfileHelper profileHelper;
Cursor c;
int flag;
String columns[] = {TravelContract.TravelEntry.COLUMN_MOBILE};
String selection = TravelContract.TravelEntry.COLUMN_EMAIL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        register = findViewById(R.id.register);
        login = findViewById(R.id.login);
        uname = findViewById(R.id.uname);
        pword = findViewById(R.id.pword);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                profileHelper = new ProfileHelper(getApplicationContext());
                SQLiteDatabase db = profileHelper.getReadableDatabase();


                String query = "SELECT "+ TravelContract.TravelEntry.COLUMN_EMAIL + " FROM "+ TravelContract.TravelEntry.TABLE_PROFILE+";";
                 Cursor cursor = db.rawQuery(query,null);

                 while(cursor.moveToNext()) {

                     if (uname.getText().toString().equals(cursor.getString(cursor.getColumnIndex(TravelContract.TravelEntry.COLUMN_EMAIL)))) {
                         flag = 1;
                         break;
                     }
                 }

                 try {

                     if (flag == 1) {
                         query = "SELECT " + TravelContract.TravelEntry.COLUMN_MOBILE + " FROM " + TravelContract.TravelEntry.TABLE_PROFILE + " WHERE " +
                                 TravelContract.TravelEntry.COLUMN_EMAIL + " = '" + uname.getText().toString() + "' ; ";
                         cursor.close();
                         cursor = db.rawQuery(query, null);
                         cursor.moveToNext();

                         if (Long.parseLong(pword.getText().toString()) == cursor.getLong(cursor.getPosition())) {
                             if(TypeSelection.USER_TYPE==1) {
                                 Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                                 Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                 startActivity(intent);
                             }
                             else if(TypeSelection.USER_TYPE==2){
                                 Intent intent = new Intent(MainActivity.this, Agency.class);
                                 Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                                 startActivity(intent);
                             }

                         } else {
                             Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                             uname.setText("");
                             pword.setText("");

                         }
                     } else
                         Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();

                 }

                 catch (NumberFormatException e) {
                     Toast.makeText(getApplicationContext(), "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                 }





            }

        });

}
}

