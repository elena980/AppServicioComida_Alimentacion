package com.example.food_delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_delivery.db.HelperBD;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    HelperBD helper;

    TextInputEditText usuario;
    TextInputEditText password;
    TextInputEditText nombre;
    TextInputEditText apellidos;
    TextInputEditText telefono;
    TextInputEditText direccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        helper = new HelperBD(this);
        this.setTitle(getString(R.string.titulo_registro));
    }

    public void crearCuenta(View view) {
        usuario = (TextInputEditText) findViewById(R.id.userBox);
        password = (TextInputEditText) findViewById(R.id.passwordBox);
        nombre = (TextInputEditText) findViewById(R.id.nameBox);
        apellidos = (TextInputEditText) findViewById(R.id.surnameBox);
        direccion = (TextInputEditText) findViewById(R.id.addressBox);
        telefono = (TextInputEditText) findViewById(R.id.phoneBox);



        if (usuario.getText().toString().equals("") || password.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, "Rellena Usuario y/o Contraseña", Toast.LENGTH_LONG);
            toast.show();
        } else {
            if (helper.booleanUser(usuario.getText().toString()) == true) {
                Toast toast = Toast.makeText(this, "Usuario en uso", Toast.LENGTH_LONG);
                toast.show();
            } else {
                helper.addUsuario(usuario.getText().toString(), password.getText().toString(), nombre.getText().toString(), apellidos.getText().toString(), direccion.getText().toString(), telefono.getText().toString());
                Toast toast = Toast.makeText(this, "Cuenta creada", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(this, LoginActivity.class);
                intent.putExtra("usuario", usuario.getText().toString());
                startActivity(intent);
            }
        }
    }
}


