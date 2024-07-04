package com.example.tempturecounter_0703;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

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


    public void ChangCtoF(View view) {
        EditText temperEditText = (EditText)findViewById(R.id.temper);
        TextView changtempTextView = (TextView)findViewById(R.id.changtemp);

        int temper = Integer.parseInt(temperEditText.getText().toString());
        int changtemp = Integer.parseInt(changtempTextView.getText().toString());

        changtemp = temper*5/9-32*5/9;
        changtempTextView.setText(String.valueOf(changtemp));

    }

    public void ChangFtoC(View view) {
        EditText temperEditText = (EditText)findViewById(R.id.temper);
        TextView changtempTextView = (TextView)findViewById(R.id.changtemp);

        int temper = Integer.parseInt(temperEditText.getText().toString());
        int changtemp = Integer.parseInt(changtempTextView.getText().toString());

        changtemp = temper*9/5+32;
        changtempTextView.setText(String.valueOf(changtemp));
    }


}