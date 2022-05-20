package com.example.food_delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_delivery.db.HelperBD;
import com.google.android.material.textfield.TextInputEditText;

public class EditionActivity extends AppCompatActivity {

    // HelperBD helper;

    TextInputEditText usuario;
    TextInputEditText password;
    TextInputEditText nombre;
    TextInputEditText apellidos;
    TextInputEditText telefono;
    TextInputEditText direccion;
    String usuario01;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);
        //helper = new HelperBD(this);
        this.setTitle(getString(R.string.edicion));
        usuario01 = getIntent().getStringExtra("usuario");
    }

    public void editarCuenta(View view){
        Toast toast = Toast.makeText(this, "Datos personales modificados", Toast.LENGTH_SHORT);
        toast.show();
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("usuario", usuario01);
        startActivity(intent);

    }
}