package com.proyecto.mychurch;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.MenuItem;
import android.view.View;

import com.proyecto.mychurch.Fragments.Eventos;
import com.proyecto.mychurch.Fragments.Groups;
import com.proyecto.mychurch.Fragments.Home;
import com.proyecto.mychurch.Fragments.Menu;
import com.proyecto.mychurch.ui.main.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private final int[] tabicons = {R.drawable.ic_baseline_house_24, R.drawable.ic_baseline_calendar_today_24, R.drawable.ic_baseline_group_24};
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

        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void setupTabIcons(){
        tabs.getTabAt(0).setIcon(tabicons[0]);
        tabs.getTabAt(1).setIcon(tabicons[1]);
        tabs.getTabAt(2).setIcon(tabicons[2]);
    }

    private void setupViewPager(ViewPager viewPager){
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this, getSupportFragmentManager());
        viewPagerAdapter.addFrag(new Home());
        viewPagerAdapter.addFrag(new Eventos());
        viewPagerAdapter.addFrag(new Groups());
        viewPagerAdapter.addFrag(new Menu());
        viewPager.setAdapter(viewPagerAdapter);
    }
}