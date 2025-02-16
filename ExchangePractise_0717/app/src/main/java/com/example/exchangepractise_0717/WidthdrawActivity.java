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

public class WidthdrawActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_widthdraw);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    /*
    public void InMoney(View view) {
        EditText money = (EditText) findViewById(R.id.money);

        double m1 = Double.parseDouble(money.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("account",m1);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }


    public void OutMoney(View view) {
        EditText money = (EditText) findViewById(R.id.money);

        double m2 = Double.parseDouble(money.getText().toString());
        Intent intent = new Intent();
        intent.putExtra("account",-m2); // 回傳負數表示提款
        setResult(Activity.RESULT_OK,intent);
        finish();
    }
     */


    public void GoTOMoney(View view) {
        EditText money = (EditText) findViewById(R.id.money);
        double m2 = Double.parseDouble(money.getText().toString());

        Intent intent = new Intent();

        if(view.getId() == R.id.in){
            intent.putExtra("ACTION","in"); // 回傳負數表示提款
        } else {
            intent.putExtra("ACTION","out");
        }

        intent.putExtra("ACTION",m2);
        setResult(Activity.RESULT_OK,intent);
        finish();
    }






}