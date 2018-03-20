import android.app.Fragment;
import android.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;

/**
 * Created by Suyash on 2/23/2018.
 */

public class BusAdapter extends android.support.v4.app.FragmentPagerAdapter {

public BusAdapter(android.support.v4.app.FragmentManager fm){

    super(fm);
}

    @Override
    public android.support.v4.app.Fragment getItem(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return 0;
    }
}

