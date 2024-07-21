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

public class ExchangeJPYActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_exchange_jpyactivity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    //日幣轉台幣
    public void ChangeJPYtoNTD(View view) {
        EditText J_money = (EditText) findViewById(R.id.J_money);
        EditText J_exchange = (EditText) findViewById(R.id.J_exchange);

        double m = Double.parseDouble(J_money.getText().toString());
        double e = Double.parseDouble(J_exchange.getText().toString());
        double ans = m * e;
        Intent intent = new Intent();
        intent.putExtra("ANS",ans);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }

    //台幣轉日幣
    public void ChangeNTDtoJPY(View view) {
        EditText J_money = (EditText) findViewById(R.id.J_money);
        EditText J_exchange = (EditText) findViewById(R.id.J_exchange);

        double m = Double.parseDouble(J_money.getText().toString());
        double e = Double.parseDouble(J_exchange.getText().toString());
        double ans = m / e;
        Intent intent = new Intent();
        intent.putExtra("ANS",ans);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }


}