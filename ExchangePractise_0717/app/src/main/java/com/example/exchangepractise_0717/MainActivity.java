package com.example.exchangepractise_0717;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
private ActivityResultLauncher<Intent> intentActivityResultLanucher;
private double account;
private TextView value;


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

        intentActivityResultLanucher = registerForActivityResult (
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        //寫另一個Activity回傳後，得到回傳的資料之後的做法
                        if(result.getData() != null && result.getResultCode() == Activity.RESULT_OK) {
                            account = result.getData().getDoubleExtra("account",-1);
                            updateAccount();
                        }

                    }
                }
        );
    }

    public void GotoInOutMoney(View view) {
        Intent intent = new Intent(this, WidthdrawActivity.class);

//        if(value != null) {
//            value.setTextColor(Color.parseColor("#000000"));
//            description.setTextColor(Color.parseColor("#000000"));
//        }

        intentActivityResultLanucher.launch(intent);
    }


    public void updateAccount() {
        TextView tv_NTDMoney = (TextView) findViewById(R.id.NTDmoney);
        tv_NTDMoney.setText(String.valueOf(account));

        value = (TextView) findViewById(R.id.NTDmoney);

        String alert = "交易成功";
        //Set Name
        TextView message = (TextView) findViewById(R.id.message);
        message.setText(alert);
        message.setTextColor(Color.parseColor("#00CC00"));

    }


}