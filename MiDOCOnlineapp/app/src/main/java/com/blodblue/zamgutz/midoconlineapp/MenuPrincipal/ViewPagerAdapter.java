package com.blodblue.zamgutz.midoconlineapp.MenuPrincipal;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabtitles[] = new String[] { "Principal", "SegundaPantalla"};
    Context context;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                principal_java fragmenttab1 = new principal_java();
                return fragmenttab1;
            case 1:
                nada_java fragmenttab2 = new nada_java();
                return fragmenttab2;
        }
        return null;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitles[position];
    }
}
