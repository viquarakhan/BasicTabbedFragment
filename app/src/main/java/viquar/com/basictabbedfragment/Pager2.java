package viquar.com.basictabbedfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Pager2 extends FragmentPagerAdapter {
    private TAB1 tab1;
    private TAB2 tab2;
    private TAB3 tab3;
    //integer to count number of tabs
    int tabCount;

    //Constructor to the class
    public Pager2(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
        this.tab1=new TAB1();
        this.tab2=new TAB2();
        this.tab3=new TAB3();
    }

    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                return tab1;
            case 1:
                return tab2;
            case 2:
                //TAB3 tab3 =new TAB3();
                return tab3;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }

}
