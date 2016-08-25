package com.example.apolo.controles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class ControlCheck extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_control_check);

    }
    public void onCheckboxClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        EditText edtPass = (EditText)findViewById(R.id.edtPass);
        int cursor = edtPass.getSelectionEnd();
        switch(view.getId()) {
            case R.id.chShowPass:
                if (checked)
                    edtPass.setInputType(InputType.TYPE_CLASS_TEXT
                            | InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD);
                else
                    edtPass.setInputType(InputType.TYPE_CLASS_TEXT
                            | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                break;
            case R.id.chGuardarSession:
                Toast.makeText(getApplicationContext(),"OK session",Toast.LENGTH_SHORT).show();
                break;
        }
        edtPass.setSelection(cursor);
    }
}
