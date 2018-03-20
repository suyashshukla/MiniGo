package com.example.suyash.minigo;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.suyash.minigo.RegisterActivity;

import Travel.ProfileHelper;
import Travel.TravelContract;

public class UserProfile extends AppCompatActivity {

    ImageView dp;
    TextView name;
    ProfileHelper profileHelper;
    String username;
    TextView email;
    TextView mobile;
    TextView type;
    TextView gender;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        profileHelper = new ProfileHelper(getApplicationContext());
        username = (MainActivity.uname).getText().toString();
        SQLiteDatabase db = profileHelper.getReadableDatabase();

        String query = "SELECT * FROM " + TravelContract.TravelEntry.TABLE_PROFILE + " WHERE " +
                TravelContract.TravelEntry.COLUMN_EMAIL + " = '" + username + "' ; ";

        Cursor cursor = db.rawQuery(query, null);

        cursor.moveToNext();

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        mobile = findViewById(R.id.mobile);
        gender = findViewById(R.id.gender);
        type = findViewById(R.id.type);
        dp = findViewById(R.id.dp);

        email.setText(cursor.getString(cursor.getColumnIndex(TravelContract.TravelEntry.COLUMN_EMAIL)));
        mobile.setText(cursor.getString(cursor.getColumnIndex(TravelContract.TravelEntry.COLUMN_MOBILE)));
        int g = cursor.getInt(cursor.getColumnIndex(TravelContract.TravelEntry.COLUMN_GENDER));
        int t = cursor.getInt(cursor.getColumnIndex(TravelContract.TravelEntry.COLUMN_TYPE));
        name.setText(cursor.getString(cursor.getColumnIndex(TravelContract.TravelEntry.COLUMN_NAME)));

        if (g == 1) {
            dp.setImageResource(R.drawable.male);
            gender.setText("Male");
        } else {
            dp.setImageResource(R.drawable.female);
            gender.setText("Female");
        }

        if (t == 1)
            type.setText("Customer");
        else if (t == 2)
            type.setText("Agency");
        else
            type.setText("Admin");




    }

}
