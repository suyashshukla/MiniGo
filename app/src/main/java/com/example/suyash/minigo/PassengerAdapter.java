package com.example.suyash.minigo;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Suyash on 2/24/2018.
 */

public class PassengerAdapter extends ArrayAdapter<Passenger> {

    public PassengerAdapter(Activity context, ArrayList<Passenger> pList){

        super(context,0,pList);

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View pView = convertView;

        Passenger passenger = getItem(position);

        if(pView==null) {
            pView = LayoutInflater.from(getContext()).inflate(R.layout.passenger_name, parent, false);
        }

        TextView source = pView.findViewById(R.id.source);
        source.setText(passenger.getFrom());

        TextView sink = pView.findViewById(R.id.sink);
        sink.setText(passenger.getTo());

        TextView name = pView.findViewById(R.id.name);
        name.setText(passenger.getName());


         return pView;
    }
}
