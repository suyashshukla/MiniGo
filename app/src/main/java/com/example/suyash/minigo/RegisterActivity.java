package com.example.suyash.minigo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.suyash.minigo.TypeSelection;
import Travel.TravelContract.TravelEntry;

import Travel.ProfileHelper;

public class RegisterActivity extends AppCompatActivity {

    ImageView male;
    ImageView female;
    TextView gender;
    Button signup;
    ProfileHelper profileHelper;
    EditText name;
    EditText mobile;
    EditText email;
    public static int sex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        male = findViewById(R.id.male);
        female = findViewById(R.id.female);
        gender = findViewById(R.id.gender);
        signup = findViewById(R.id.signup);
        name = findViewById(R.id.name);
        mobile = findViewById(R.id.mobile);
        email = findViewById(R.id.email);

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gender.setText("Male");
                sex = 1;
            }
        });



            female.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    gender.setText("Female");
                    sex = 0;
                }
            });

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    profileHelper = new ProfileHelper(getApplicationContext());
                    SQLiteDatabase db = profileHelper.getWritableDatabase();

                    ContentValues contentValues = new ContentValues();

                    contentValues.put(TravelEntry.COLUMN_NAME,name.getText().toString());
                    contentValues.put(TravelEntry.COLUMN_EMAIL,email.getText().toString());
                    contentValues.put(TravelEntry.COLUMN_MOBILE,Long.parseLong(mobile.getText().toString()));
                    contentValues.put(TravelEntry.COLUMN_GENDER,sex);
                    contentValues.put(TravelEntry.COLUMN_TYPE,TypeSelection.USER_TYPE);

                    long check = db.insert(TravelEntry.TABLE_PROFILE,null,contentValues);
                    Log.v("Registration Page","Value of check = "+check,null);

                    if(check>=0) {
                        Toast.makeText(getApplicationContext(), "Registration Successsful", Toast.LENGTH_SHORT).show();

                        finish();
                    }


                }
            });

    }
}
