package com.example.food_delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_delivery.db.HelperBD;
import com.google.android.material.textfield.TextInputEditText;

public class EditionActivity extends AppCompatActivity {

    HelperBD helper;

    TextInputEditText password;
    TextInputEditText nombre;
    TextInputEditText apellidos;
    TextInputEditText telefono;
    TextInputEditText direccion;
    String usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);
        helper = new HelperBD(this);
        this.setTitle(getString(R.string.edicion));
        usuario = getIntent().getStringExtra("usuario");
    }

    public void editarCuenta(View view){
        password = (TextInputEditText) findViewById(R.id.passBoxEdit);
        nombre = (TextInputEditText) findViewById(R.id.nameEditBox);
        apellidos = (TextInputEditText) findViewById(R.id.lastnameEditBox);
        direccion = (TextInputEditText) findViewById(R.id.addressEditBox);
        telefono = (TextInputEditText) findViewById(R.id.phoneBox);

        if (password.getText().toString().equals("") || nombre.getText().toString().equals("") ||
                apellidos.getText().toString().equals("") || direccion.getText().toString().equals("") || telefono.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, "Rellena todos los campos", Toast.LENGTH_LONG);
            toast.show();
        } else {
                helper.editarUsuario(usuario, password.getText().toString(), nombre.getText().toString(),
                        apellidos.getText().toString(), direccion.getText().toString(), telefono.getText().toString());
                Toast toast = Toast.makeText(this, "Datos personales modificados", Toast.LENGTH_LONG);
                toast.show();

                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("usuario", usuario);
                startActivity(intent);
            }

    }
}