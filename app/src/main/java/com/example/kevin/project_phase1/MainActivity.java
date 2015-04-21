package com.example.kevin.project_phase1;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ListFragment;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends ListActivity {
    ListView colors;
    String inputSize;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colors = (ListView)findViewById(android.R.id.list);
        ArrayList<String> val = new ArrayList<String>();
        for(int i=0;i<11;i++)
            val.add(String.valueOf(i));
        colorAdapter<String> ad = new colorAdapter<String>(this, val);
        colors.setAdapter(ad);

        //Set OnItemClick
        colors.setOnItemClickListener((new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int itemPosition = position;
                String itemValue = (String)colors.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(),
                        "Position: "+ itemPosition, Toast.LENGTH_SHORT).show();
            }
        }
        ));
    }



}
