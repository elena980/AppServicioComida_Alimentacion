package com.example.food_delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Toast;

import com.example.food_delivery.db.HelperBD;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    private ArrayAdapter<String> miAdapter;

    HelperBD helper;
    EditText usuario, pass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        helper = new HelperBD(this);
        this.setTitle(getString(R.string.titulo_login_registro));


    }

    public void login(View view){
        usuario = (EditText) findViewById(R.id.cajaUser);
        pass = (EditText) findViewById(R.id.cajaPass);

        if (usuario.getText().toString().equals("") || pass.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, "Rellena Usuario y/o Contraseña", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            if (helper.booleanUser(usuario.getText().toString()) == true && helper.booleanPass(pass.getText().toString()) == true) {
                Toast toast = Toast.makeText(this, "Acceso correcto", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("usuario", usuario.getText().toString());
                startActivity(intent);
            }else{
                Toast toast = Toast.makeText(this, "Credenciales inválidas", Toast.LENGTH_SHORT);
                toast.show();
            }
        }
    }

    public void registrationActivity(View view){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);

    }

}
