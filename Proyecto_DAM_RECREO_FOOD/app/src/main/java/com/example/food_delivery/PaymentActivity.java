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

    String usuario;
    TextView total;

    ActivityStore activityStore = new ActivityStore();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment02);
        usuario = getIntent().getStringExtra("usuario");
        total = activityStore.getTotal();
        total = (TextView) findViewById(R.id.txt_total_order);
        this.setTitle("Método de pago");

    }

    public void confirmar(View view) {
        Intent intent = new Intent(this, OrderActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    public void onRadioButtonClicked(View view) {

        boolean checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.radio_tarjeta:
                if (checked)
                    Toast.makeText(getApplicationContext(),"card payment" ,Toast.LENGTH_LONG).show();
                break;
            case R.id.radio_efectivo:
                if (checked)
                    Toast.makeText(getApplicationContext(),"cash payment" ,Toast.LENGTH_LONG).show();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}

