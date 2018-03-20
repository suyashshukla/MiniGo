package Travel;

import android.provider.BaseColumns;

/**
 * Created by Suyash on 3/20/2018.
 */

public class TravelContract {


public static class TravelEntry implements BaseColumns {

    public static final String TABLE_PROFILE = "customer";
    public static final String TABLE_TRAVEL = "travel";


    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TYPE = "type";
    public static final String COLUMN_GENDER = "gender";
    public static final String COLUMN_MOBILE = "mobile";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_FROM = "source";
    public static final String COLUMN_TO = "dest";

    public static final int GENDER_MALE = 1;
    public static final int GENDER_FEMALE = 0;
    public static final String ADMIN_UNAME = "sushandro";
    public static final String ADMIN_PWORD = "8319279074";


}


}
