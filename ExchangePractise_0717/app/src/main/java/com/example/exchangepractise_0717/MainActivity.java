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
private TextView tv_NTDMoney;
private TextView message;


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
                                    // 檢查回傳資料和結果碼
                        if(result.getData() != null && result.getResultCode() == Activity.RESULT_OK) {
                            // 從回傳資料中提取 "account" 資料
                            double transactionAmount = result.getData().getDoubleExtra("account",-1);
                            //更新帳戶金額
                            account += transactionAmount;
                            // 更新帳戶顯示
                            updateAccount(); //方法，寫在下面。
                        }
                    }
                }
        );

    }

    public void GotoInOutMoney(View view) {
        Intent intent = new Intent(this, WidthdrawActivity.class);
        intentActivityResultLanucher.launch(intent);
    }


    public void updateAccount() {
        TextView tv_NTDMoney = (TextView) findViewById(R.id.NTDmoney);
        TextView message = (TextView) findViewById(R.id.message);

        if(account >= 0) {
            tv_NTDMoney.setText(String.valueOf(account));
            //Set message Name
            message.setText("交易成功");
            message.setTextColor(Color.parseColor("#00CC00"));
        } else {
            tv_NTDMoney.setText(String.valueOf(account));
            //Set message Name
            message.setText("餘額不足，交易失敗");
            message.setTextColor(Color.parseColor("#CC0000"));
        }

    }



}