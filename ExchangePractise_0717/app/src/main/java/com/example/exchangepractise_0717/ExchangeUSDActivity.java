package com.example.exchangepractise_0717;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
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

        Bundle bundle = this.getIntent().getExtras();
        if(bundle != null) {
            String coin = String.format(bundle.getString("COIN"));
            //Set Name
            TextView title = (TextView) findViewById(R.id.title);
            Button toNTDBtn = (Button) findViewById(R.id.toNTD);
            Button NTDtoBtn = (Button) findViewById(R.id.NTDto);

            if (coin.equals("USD")) {
                title.setText("美金換匯");
                toNTDBtn.setText("美金換台幣");
                NTDtoBtn.setText("台幣換美金");
            } else {
                title.setText("日圓換匯");
                toNTDBtn.setText("日圓換台幣");
                NTDtoBtn.setText("台幣換日圓");
            }
        }

    }

    /*
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
     */


        public void changeCoin(View view) {
            EditText et_amount = (EditText) findViewById(R.id.money_usd);
            EditText et_rate = (EditText) findViewById(R.id.exchange_usd);

            Intent intent = new Intent();

            if(view.getId() == R.id.in){
                intent.putExtra("ACTION","toNTD");
            } else {
                intent.putExtra("ACTION","NTDto");
            }

            intent.putExtra("AMOUNT",Double.parseDouble(et_amount.getText().toString()));
            intent.putExtra("RATE",Double.parseDouble(et_rate.getText().toString()));
            setResult(Activity.RESULT_OK,intent);
            finish();
        }




}