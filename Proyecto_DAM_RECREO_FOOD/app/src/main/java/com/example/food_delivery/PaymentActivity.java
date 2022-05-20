package com.example.food_delivery;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_delivery.db.HelperBD;

public class PaymentActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        //nameCard = (EditText) findViewById(R.id.nameCard);
        //numberCard = (EditText) findViewById(R.id.numberCard);
        //expirateDate = (EditText) findViewById(R.id.expirate_date);
        //csv = (EditText) findViewById(R.id.csv);
        this.setTitle("Método de pago");

    }

}
    /*
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
                    Toast.makeText(getApplicationContext(),"cash payment" ,Toast.LENGTH_LONG).show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
*/

