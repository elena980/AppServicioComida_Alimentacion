package com.example.food_delivery;






import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Payment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
    }
    public void cardPayment(View view){
        LinearLayout ll = (LinearLayout) findViewById(R.id.linearLayout);
        if(ll.getVisibility() == VISIBLE) {
            ll.setVisibility(View.GONE);
        } else {
            ll.setVisibility(VISIBLE);
        }
    }
    public void cashPayment(View view){
        TextView tv = (TextView) findViewById(R.id.cashText);
        if(tv.getVisibility() == VISIBLE) {
            tv.setVisibility(View.GONE);
        } else {
            tv.setVisibility(VISIBLE);
        }
    }
}