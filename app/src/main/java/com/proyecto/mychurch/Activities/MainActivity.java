package com.proyecto.mychurch.Activities;

import android.graphics.PorterDuff;
import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.proyecto.mychurch.Fragments.Eventos;
import com.proyecto.mychurch.Fragments.Groups;
import com.proyecto.mychurch.Fragments.Home;
import com.proyecto.mychurch.Fragments.Menu;
import com.proyecto.mychurch.R;
import com.proyecto.mychurch.ui.main.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private final int[] tabicons = { R.drawable.ic_baseline_house_24, R.drawable.ic_baseline_calendar_today_24, R.drawable.ic_baseline_group_24, R.drawable.ic_baseline_menu_24};
    private final Fragment[] fragmentos = { new Home(), new Eventos(), new Groups(), new Menu() };

    private TabLayout tabs;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.view_pager);
        setupViewPager(viewPager);

        tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        setupTabIcons();

        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);


        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                switch (tab.getPosition()){
                    case 0:
                        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        break;
                    case 1:
                        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        break;
                    case 2:
                        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        break;
                    case 3:
                        tabs.getTabAt(0).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(1).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(2).getIcon().setColorFilter(getResources().getColor(R.color.light_grey), PorterDuff.Mode.SRC_IN);
                        tabs.getTabAt(3).getIcon().setColorFilter(getResources().getColor(R.color.colorAccent), PorterDuff.Mode.SRC_IN);
                        break;
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    private void setupTabIcons(){
       /* tabs.getTabAt(0).setIcon(tabicons[0]);
        tabs.getTabAt(1).setIcon(tabicons[1]);
        tabs.getTabAt(2).setIcon(tabicons[2]);
        tabs.getTabAt(3).setIcon(tabicons[3]);*/


        for(int  i = 0; i < tabicons.length; i++){
            tabs.getTabAt(i).setIcon(tabicons[i]);
        }
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getSupportFragmentManager());

        for(int i = 0; i < fragmentos.length; i ++){
            viewPagerAdapter.addFrag(fragmentos[i]);
        }

       /* viewPagerAdapter.addFrag(new Home());
        viewPagerAdapter.addFrag(new Eventos());
        viewPagerAdapter.addFrag(new Groups());
        viewPagerAdapter.addFrag(new Menu());*/
        viewPager.setAdapter(viewPagerAdapter);
    }
}