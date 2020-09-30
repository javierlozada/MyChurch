package com.proyecto.mychurch.Includes;

import com.proyecto.mychurch.R;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Mytoolbar {

    public static void show(AppCompatActivity activity, String title, boolean button){
        Toolbar mtoolbar  = activity.findViewById(R.id.toolbar);
        activity.setSupportActionBar(mtoolbar);
        activity.getSupportActionBar().setTitle(title);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(button);

    }
}
