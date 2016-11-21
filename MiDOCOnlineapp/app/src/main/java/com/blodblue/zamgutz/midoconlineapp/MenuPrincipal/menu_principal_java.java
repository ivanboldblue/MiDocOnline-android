package com.blodblue.zamgutz.midoconlineapp.MenuPrincipal;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import com.blodblue.zamgutz.midoconlineapp.R;

public class menu_principal_java extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_principal);
        ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    public void onBackPressed(View v) {
        Intent iExp2 = new Intent(menu_principal_java.this, menu_principal_java.class);
        startActivity(iExp2);
        super.onBackPressed();
    }


}