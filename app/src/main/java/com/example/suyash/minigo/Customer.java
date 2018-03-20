package com.example.suyash.minigo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Customer extends AppCompatActivity {

    Spinner from;
    Spinner to;
    Button book;
    Spinner agency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer);

        from = findViewById(R.id.from);
        to = findViewById(R.id.to);

        ArrayAdapter fromAdapter = ArrayAdapter.createFromResource(this,R.array.from,android.R.layout.simple_dropdown_item_1line);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);


        ArrayAdapter toAdapter = ArrayAdapter.createFromResource(this,R.array.to,android.R.layout.simple_dropdown_item_1line);
        fromAdapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);




        from.setAdapter(fromAdapter);
        to.setAdapter(toAdapter);

        book = findViewById(R.id.book);


        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Customer.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
