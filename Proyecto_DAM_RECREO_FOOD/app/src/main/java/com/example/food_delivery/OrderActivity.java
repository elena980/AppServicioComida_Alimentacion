package com.example.food_delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {
        String usuario;
        ListView lista;
        TextView total;

        ActivityStore activityStore = new ActivityStore();


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_order);
            this.setTitle("Pedido realizado");
            usuario = getIntent().getStringExtra("usuario");

            // Se instancia XML a JAVA
            lista = activityStore.getLista();
            lista = (ListView) findViewById(R.id.lista_order);
            total = activityStore.getTotal();
            total = (TextView) findViewById(R.id.txt_total_order);
            //Llamado al método definirLista()
            ActivityStore.definirLista();
        }

        public void finalizar (View view) {
            Intent intent = new Intent(this, MainActivity.class);
            Toast toast = Toast.makeText(this, "Disfruta de tu comida", Toast.LENGTH_LONG);
            toast.show();
            startActivity(intent);
        }

}


