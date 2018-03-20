package com.example.suyash.minigo;

/**
 * Created by Suyash on 2/24/2018.
 */

public class Passenger {

    private String name;
    private String from;
    private String to;

    public Passenger(String mName, String mFrom, String mTo){

        name = mName;
        from = mFrom;
        to = mTo;
    }

    public String getName(){
        return name;
         }

         public String getFrom(){
        return from;
         }

         public String getTo(){
             return to;
         }
}
