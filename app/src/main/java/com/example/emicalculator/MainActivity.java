package com.example.emicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText amt, intrest, time;
    Button calculate, clear;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // making application name disappear
        requestWindowFeature(Window.FEATURE_NO_TITLE); // helps to hide title
        getSupportActionBar().hide(); // hides title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); // enables full screen

        setContentView(R.layout.activity_main);

        amt = findViewById(R.id.etxtAmount);
        intrest = findViewById(R.id.etxtIntrest);
        time = findViewById(R.id.etxtTime);

        calculate = findViewById(R.id.btnCal);
        clear = findViewById(R.id.btnClear);

        result =findViewById(R.id.txtRes);


        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calculate();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amt.setText("");
                intrest.setText("");
                time.setText("");
                result.setText("");
            }
        });
    }

    public void Calculate(){
        DecimalFormat df = new DecimalFormat("#.00");

        if(Validate()){
            Double P = Double.parseDouble(amt.getText().toString());
            Double R = Double.parseDouble(intrest.getText().toString());
            Double N = Double.parseDouble(time.getText().toString());

            R = R / (12 * 100);
            N = N * 12;

            Formula f = new Formula(P, R, N);
            result.setText("Monthly Installment = " + df.format(f.getEmiCal())) ;
        }
        else {
            Toast.makeText(this, "Empty Fields", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean Validate(){
        if(amt.getText().toString().trim().isEmpty() || intrest.toString().trim().isEmpty() || time.toString().trim().isEmpty())
            return false;
        else
            return true;
    }
}
