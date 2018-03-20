package com.example.suyash.minigo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by Suyash on 2/23/2018.
 */

public class SMS extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

String action = intent.getAction();



if(action.equals("ACTION_SENDTO")){

    Toast.makeText(context,"OTP has been sent to your Mobile Number",Toast.LENGTH_SHORT).show();
}

    }
}


