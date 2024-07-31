package com.example.practiseeven_0731;

import android.os.Bundle;
import android.service.autofill.OnClickAction;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View

        .OnClickListener {

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

        Button btn_big = (Button) findViewById(R.id.btn_big);
        Button btn_small = (Button) findViewById(R.id.btn_small);
        btn_big.setOnClickListener(this);
        btn_small.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        TextView tv_text = (TextView) findViewById(R.id.tv_text);
        TextView tv_textSize = (TextView) findViewById(R.id.tv_textsize);

        float currentSizeSp = tv_text.getTextSize() / getResources().getDisplayMetrics().scaledDensity; //Density密度；scale縮放
        if(view.getId() == R.id.btn_big){
            tv_text.setTextSize(currentSizeSp + 5);
            tv_textSize.setText(String.valueOf(currentSizeSp + 5));
        } else {
            tv_text.setTextSize(currentSizeSp - 5);
            tv_textSize.setText(String.valueOf(currentSizeSp - 5));
        }
    }




}