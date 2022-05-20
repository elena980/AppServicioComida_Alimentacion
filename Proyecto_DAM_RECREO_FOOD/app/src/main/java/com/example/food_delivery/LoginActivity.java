package com.example.food_delivery;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.food_delivery.db.EstructuraBD;
import com.example.food_delivery.db.HelperBD;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

    HelperBD helper;
    TextInputEditText usuario;
    TextInputEditText pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = new HelperBD(this);
        this.setTitle(getString(R.string.titulo_login_registro));

        Typeface miFuente = Typeface.createFromAsset(getAssets(), "little.otf");
        TextView titulo = (TextView) findViewById(R.id.titulo01);

        titulo.setTypeface(miFuente);
    }

    public void login(View view){
        usuario = (TextInputEditText) findViewById(R.id.cajaUser);
        pass = (TextInputEditText) findViewById(R.id.cajaPass);

        if (usuario.getText().toString().equals("") || pass.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, "Rellena Usuario y/o Contraseña", Toast.LENGTH_LONG);
            toast.show();
        } else {
            if (helper.booleanUser(usuario.getText().toString()) == true && helper.booleanPass(pass.getText().toString()) == true) {
                Toast toast = Toast.makeText(this, "Acceso correcto", Toast.LENGTH_LONG);
                toast.show();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("usuario", usuario.getText().toString());
                startActivity(intent);
            }else{
                Toast toast = Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_LONG);
                toast.show();
            }
        }
    }

    public void registrationActivity(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);

    }

}
