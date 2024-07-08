package com.example.easycounter_0708;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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
    }

    public void plus(View view) {
        EditText num1Text = (EditText)findViewById(R.id.num1);
        EditText num2Text = (EditText)findViewById(R.id.num2);
        TextView result = (TextView)findViewById(R.id.ans);

        int input1 = Integer.parseInt(num1Text.getText().toString());
        int input2 = Integer.parseInt(num2Text.getText().toString());
        int answer = input1 + input2;

        result.setText(String.valueOf(answer));
    }

    public void minus(View view) {
        EditText num1Text = (EditText)findViewById(R.id.num1);
        EditText num2Text = (EditText)findViewById(R.id.num2);
        TextView result = (TextView)findViewById(R.id.ans);

        int input1 = Integer.parseInt(num1Text.getText().toString());
        int input2 = Integer.parseInt(num2Text.getText().toString());
        int answer = input1 - input2;

        result.setText(String.valueOf(answer));
    }

    public void multiply(View view) {
        EditText num1Text = (EditText)findViewById(R.id.num1);
        EditText num2Text = (EditText)findViewById(R.id.num2);
        TextView result = (TextView)findViewById(R.id.ans);

        int input1 = Integer.parseInt(num1Text.getText().toString());
        int input2 = Integer.parseInt(num2Text.getText().toString());
        int answer = input1 * input2;

        result.setText(String.valueOf(answer));
    }

    public void divide(View view) {
        EditText num1Text = (EditText)findViewById(R.id.num1);
        EditText num2Text = (EditText)findViewById(R.id.num2);
        TextView result = (TextView)findViewById(R.id.ans);

        int input1 = Integer.parseInt(num1Text.getText().toString());
        int input2 = Integer.parseInt(num2Text.getText().toString());
        double answer = input1 / input2;

        result.setText(String.valueOf(answer));
    }



}