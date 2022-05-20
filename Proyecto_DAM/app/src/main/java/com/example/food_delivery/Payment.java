package com.example.food_delivery;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

import androidx.appcompat.app.AppCompatActivity;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    AlertDialog.Builder builder;
    EditText nameCard, numberCard, expirateDate, csv;
    RadioButton indexCard, indexCash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        nameCard = (EditText) findViewById(R.id.nameCard);
        numberCard = (EditText) findViewById(R.id.numberCard);
        expirateDate = (EditText) findViewById(R.id.expirate_date);
        csv = (EditText) findViewById(R.id.csv);
        indexCard = (RadioButton) findViewById(R.id.card);
        indexCash = (RadioButton) findViewById(R.id.cash);

    }
    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.card:
                if (checked)
                    nameCard.setVisibility(VISIBLE);
                numberCard.setVisibility(VISIBLE);
                expirateDate.setVisibility(VISIBLE);
                csv.setVisibility(VISIBLE);
                break;
            case R.id.cash:
                if (checked)
                    nameCard.setVisibility(GONE);
                numberCard.setVisibility(GONE);
                expirateDate.setVisibility(GONE);
                csv.setVisibility(GONE);
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }

    public void finallyPaymant(View view){
        if(indexCard.isChecked()){
            Toast.makeText(getApplicationContext(),"order paid by credit card" ,Toast.LENGTH_SHORT).show();
        }
        if(indexCash.isChecked()){
            Toast.makeText(getApplicationContext(),"order paid by cash" ,Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(),"Please select a payment method" ,Toast.LENGTH_SHORT).show();
        }

    }

}