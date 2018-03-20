package Travel;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import Travel.TravelContract.TravelEntry;

/**
 * Created by Suyash on 3/20/2018.
 */

public class ProfileHelper extends SQLiteOpenHelper {



    public static final String DATABASE_NAME = "profile.db";
    private static final int DATABASE_VERSION = 1;

    private String CREATE_TABLE = "CREATE TABLE "+TravelEntry.TABLE_PROFILE+" ( "+
            TravelEntry.COLUMN_NAME + " TEXT , "+
            TravelEntry.COLUMN_MOBILE+ " INTEGER , "+
            TravelEntry.COLUMN_EMAIL+ " TEXT , "+
            TravelEntry.COLUMN_GENDER+ " INTEGER , "+
            TravelEntry.COLUMN_TYPE+ " INTEGER );";

    private String DROP_TABLE = "DROP TABLE IF EXISTS "+TravelEntry.TABLE_PROFILE;

    public ProfileHelper(Context context){

        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        sqLiteDatabase.execSQL(CREATE_TABLE);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
            sqLiteDatabase.execSQL(DROP_TABLE);
            onCreate(sqLiteDatabase);
    }
}
