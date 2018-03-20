package com.example.suyash.minigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.example.suyash.minigo.R;

public class TypeSelection extends AppCompatActivity {

    public static int USER_TYPE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type_selection);

        LinearLayout customer = findViewById(R.id.customer);
        LinearLayout agency = findViewById(R.id.agency);
        LinearLayout admin = findViewById(R.id.admin);

        customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER_TYPE = 1;
                Intent intent = new Intent(TypeSelection.this,MainActivity.class);

                startActivity(intent);
            }
        });

        agency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER_TYPE = 2;
                Intent intent = new Intent(TypeSelection.this,MainActivity.class);

                startActivity(intent);
            }
        });

        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                USER_TYPE = 3;
                Intent intent = new Intent(TypeSelection.this,MainActivity.class);

                startActivity(intent);
            }
        });


    }






}
