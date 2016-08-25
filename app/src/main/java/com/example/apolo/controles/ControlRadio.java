package com.example.apolo.controles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;

public class ControlRadio extends AppCompatActivity {
    private View contenedorPersona;
    private View contenedorEmpresa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_radio);
        contenedorPersona = findViewById(R.id.ll_contenedor_particular);
        contenedorEmpresa = findViewById(R.id.ll_contenedor_corporativo);
    }
    public void onRadioButtonClicked(View view) {
        boolean marcado = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rbEmpresa:
                if (marcado) {
                    mostrar(false);
                }
                break;

            case R.id.rbPersona:
                if (marcado) {
                    mostrar(true);
                }
                break;
        }
    }
    private void mostrar(boolean b) {
        contenedorPersona.setVisibility(b ? View.VISIBLE : View.GONE);
        contenedorEmpresa.setVisibility(b ? View.GONE : View.VISIBLE);
    }
}
