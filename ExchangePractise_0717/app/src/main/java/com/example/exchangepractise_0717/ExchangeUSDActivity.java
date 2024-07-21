package com.example.exchangepractise_0717;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ExchangeUSDActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exchange_usdactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //美金轉台幣
    public void ChangeUSDtoNTD(View view) {
        EditText money_usd = (EditText) findViewById(R.id.money_usd);
        EditText exchange_usd = (EditText) findViewById(R.id.exchange_usd);

        double m = Double.parseDouble(money_usd.getText().toString());
        double e = Double.parseDouble(exchange_usd.getText().toString());
        double ans = m * e;
        Intent intent = new Intent();
        intent.putExtra("ANS",ans);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    //台幣轉美金
    public void ChangeNTDtoUSA(View view) {
        EditText money_usd = (EditText) findViewById(R.id.money_usd);
        EditText exchange_usd = (EditText) findViewById(R.id.exchange_usd);

        double m = Double.parseDouble(money_usd.getText().toString());
        double e = Double.parseDouble(exchange_usd.getText().toString());
        double ans = m / e;
        Intent intent = new Intent();
        intent.putExtra("ANS",ans);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }


}