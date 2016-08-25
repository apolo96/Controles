package com.example.apolo.controles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class ControlSpinner extends AppCompatActivity {
    private Spinner spCiudad;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_spinner);
        spCiudad = (Spinner) findViewById(R.id.spCiudad);
        List<String> list = new ArrayList<String>();
        list.add("Neiva");
        list.add("Medellin");
        list.add("Bogota");
        list.add("Cali");
        list.add("Cartagena");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item,list);

        dataAdapter.setDropDownViewResource
                (android.R.layout.simple_spinner_dropdown_item);

        spCiudad.setAdapter(dataAdapter);

    }
}
