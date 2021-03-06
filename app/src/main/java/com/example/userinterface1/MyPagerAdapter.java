package com.example.userinterface1;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.userinterface1.Blank.Blank1;
import com.example.userinterface1.Blank.Blank2;
import com.example.userinterface1.Blank.Blank3;

public class MyPagerAdapter extends FragmentPagerAdapter {
        int mNumOfTabs; //tab의 갯수

        public MyPagerAdapter(FragmentManager fm, int numOfTabs) {
            super(fm);
            this.mNumOfTabs = numOfTabs;
        }

        @Override
        public Fragment getItem(int position) {

            switch (position) {
                case 0:
                    Blank1 tab1 = new Blank1();
                    return tab1;
                case 1:
                    Blank2 tab2 = new Blank2();
                    return tab2;
                case 2:
                    Blank3 tab3 = new Blank3();
                    return tab3;
                default:
                    return null;
            }
            //return null;
        }

        @Override
        public int getCount() {
            return mNumOfTabs;
        }
}
