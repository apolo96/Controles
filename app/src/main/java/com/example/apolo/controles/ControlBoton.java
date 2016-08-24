package com.example.apolo.controles;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class ControlBoton extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_boton);
        ImageButton imgBoton = (ImageButton) findViewById(R.id.imgButton);
        imgBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Snackbar.make(v, "Click ImageButton", Snackbar.LENGTH_LONG).show();
            }
        });
        Button btnAceptar = (Button) findViewById(R.id.btnAceptar);
        btnAceptar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Snackbar.make(v,"Long click button",Snackbar.LENGTH_SHORT).show();
                return true;
            }
        });
    }
    public void verTexto(View v){
        Toast.makeText(getApplicationContext(),"Button action",Toast.LENGTH_SHORT).show();
    }
}
