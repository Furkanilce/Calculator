package com.example.hesapmakinesi;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.NumbersKt;
import kotlin.Result;

public class MainActivity extends AppCompatActivity {
EditText NumberText;
EditText NumberText2;
TextView ResultText;
SharedPreferences record;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        NumberText = findViewById(R.id.NumberText);
        NumberText2 = findViewById(R.id.NumberText2);
        ResultText = findViewById(R.id.ResultText);
        record = this.getSharedPreferences("com.example.hesapmakinesi", Context.MODE_PRIVATE);

        int give = record.getInt("rec",0);
        if(give == 0) {
            ResultText.setText("Result: ");
        }else {
            ResultText.setText("Result: " + give);
        }
    }
    public void sum(View view) {
        int result = 0;
        if(NumberText.getText().toString().matches("") || NumberText2.getText().toString().matches("")) {
            ResultText.setText("EnterNumber");
        }else {
            int num1 = Integer.parseInt(NumberText.getText().toString());
            int num2 = Integer.parseInt(NumberText2.getText().toString());

            result = num1 + num2;

            ResultText.setText("Result: " + result);
        }
        record.edit().putInt("rec",result).apply();

    }
    public void sub(View view) {
        int result = 0;
        if(NumberText.getText().toString().matches("") || NumberText2.getText().toString().matches("")) {
            ResultText.setText("EnterNumber");
        }else {
            int num1 = Integer.parseInt(NumberText.getText().toString());
            int num2 = Integer.parseInt(NumberText2.getText().toString());

            result = num1 - num2;
            ResultText.setText("Resul: " + result);
        }
        record.edit().putInt("rec",result).apply();
    }
    public void mul(View view) {
        int result = 0;
        if(NumberText.getText().toString().matches("") || NumberText2.getText().toString().matches("")) {
            ResultText.setText("EnterNumber");
        }else {
            int num1 = Integer.parseInt(NumberText.getText().toString());
            int num2 = Integer.parseInt(NumberText2.getText().toString());

            result = num1 * num2;
            ResultText.setText("Result: " + result);
        }
        record.edit().putInt("rec",result).apply();
    }
    public void div(View view) {
        int result = 0;
        if(NumberText.getText().toString().matches("") || NumberText2.getText().toString().matches("")) {
            ResultText.setText("EnterNumber");
        }else {
            int num1 = Integer.parseInt(NumberText.getText().toString());
            int num2 = Integer.parseInt(NumberText2.getText().toString());

            result = num1 / num2;
            ResultText.setText("Result: " + result);
        }
        record.edit().putInt("rec",result);
    }
    public void del(View view) {
        int delete = record.getInt("rec",0);

        if(delete != 0) {
            record.edit().remove("rec").apply();
            ResultText.setText("Result: ");
        }
    }


}