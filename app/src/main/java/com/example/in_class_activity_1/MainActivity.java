package com.example.in_class_activity_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtreminder;
    private Spinner spinner;
    private RadioGroup rdGroup;
    private Button btnadd;
    private TextView txtresult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }
    private void setUpViews(){
        edtreminder= findViewById(R.id.edtreminder);
        rdGroup= findViewById(R.id.rdGroup);
        spinner= findViewById(R.id.spinner);
        txtresult= findViewById(R.id.txtresult);
        btnadd= findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = "";
                String reminder = edtreminder.getText().toString();
                if(!reminder.isEmpty()) {
                    msg += "\n" + reminder;

                }
                int id = rdGroup.getCheckedRadioButtonId();
                if(id != -1) {
                    RadioButton rd = findViewById(id);
                    msg += ",\n" + rd.getText().toString();
                }

                String item = spinner.getSelectedItem().toString();
                msg += ",\n" + item;

                txtresult.setText(msg);
            }
        });
    }
}