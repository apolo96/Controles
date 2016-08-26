package com.example.apolo.controles;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ControlText extends AppCompatActivity {
    private int pk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_text);
        final EditText edtDescripcion = (EditText) findViewById(R.id.edtDescripcion);
        edtDescripcion.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Toast.makeText(getApplicationContext(),"onCHANGE",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                String numeroCaracteres = String.valueOf(s.length());
                final TextView txtContador = (TextView) findViewById(R.id.contador);
                txtContador.setText(numeroCaracteres);
            }
        });

        final EditText edtActionKey = (EditText) findViewById(R.id.edtActionKey);
        edtActionKey.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean procesado = false;

                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    // Mostrar mensaje
                    Toast.makeText(getApplicationContext(), "Buscar:" + v.getText().toString(), Toast.LENGTH_SHORT).show();

                    // Ocultar teclado virtual
                    InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                    procesado = true;
                }
                return procesado;
            }

        });
        final EditText edtDesactivado = (EditText) findViewById(R.id.edtDesactivado);
        final EditText edtActionFoco = (EditText) findViewById(R.id.edtActionFoco);
        edtActionFoco.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                edtActionFoco.setEnabled(false);
                if(edtDesactivado.isEnabled() == false){
                    edtDesactivado.setEnabled(true);
                    edtDesactivado.requestFocus();
                    Toast.makeText(getApplicationContext(),"Campo Acivadoa",Toast.LENGTH_SHORT).show();
                }else{
                    edtDesactivado.setEnabled(false);
                    edtActionFoco.setEnabled(true);
                    edtActionFoco.requestFocus();

                }



            }
        });
        Toast.makeText(getApplicationContext(),getPhoneNumber(),Toast.LENGTH_LONG).show();
    }
    private String getPhoneNumber(){
        TelephonyManager mTelephonyManager;
        mTelephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        return mTelephonyManager.getLine1Number();
    }
}
