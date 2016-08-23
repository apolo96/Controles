package com.example.apolo.controles;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    private ListView list01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list01 = (ListView) findViewById(R.id.controlList);
        listEventClick();
    }

    private void listEventClick(){
        list01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String itemSelected = adapterView.getItemAtPosition(i).toString();
                selectedActivity(i);
            }
        });
    }

    private void selectedActivity(int itemClass){
        Intent objIntent = null;
        switch (itemClass){
            case 0 :
                objIntent = new Intent(getApplicationContext(),ControlText.class);
                break;
            case 1:
                objIntent = new Intent(getApplicationContext(),ControlBoton.class);
                break;
            case 2:
                objIntent = new Intent(getApplicationContext(), ControlDialogo.class);
                break;
            case 3:
                objIntent = new Intent(getApplicationContext(), ControlCheck.class);
                break;
            case 4:
                objIntent = new Intent(getApplicationContext(), ControlRadio.class);
                break;
            case 5:
                objIntent = new Intent(getApplicationContext(), ControlSpinner.class);
                break;
        }
        if(objIntent != null)startActivity(objIntent);

    }



}
