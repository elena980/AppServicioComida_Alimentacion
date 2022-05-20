package com.example.food_delivery;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.food_delivery.db.HelperBD;
import com.google.android.material.textfield.TextInputEditText;

public class RegistrationActivity extends AppCompatActivity {

    HelperBD helper;

    EditText user, pass, name, surname, phone, address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        helper = new HelperBD(this);
        this.setTitle(getString(R.string.titulo_registro));
    }

    public void createAccount(View view) {
        user = (EditText) findViewById(R.id.userBox);
        pass= (EditText) findViewById(R.id.passwordBox);
        name = (EditText) findViewById(R.id.nameBox);
        surname = (EditText) findViewById(R.id.surnameBox);
        address = (EditText) findViewById(R.id.addressBox);
        phone = (EditText) findViewById(R.id.phoneBox);

        if (user.getText().toString().equals("") || pass.getText().toString().equals("")) {
            Toast toast = Toast.makeText(this, "You must fill in the user and password fields", Toast.LENGTH_SHORT);
            toast.show();
        } else {
            if (helper.booleanUser(user.getText().toString()) == true) {
                Toast toast = Toast.makeText(this, "User in use", Toast.LENGTH_SHORT);
                toast.show();
            } else {
                helper.addUsuario(user.getText().toString(), pass.getText().toString(), name.getText().toString(), surname.getText().toString(), address.getText().toString(),phone.getText().toString());
                Toast toast = Toast.makeText(this, "Account created", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(this, LoginActivity.class);
                //intent.putExtra("usuario", usuario.getText().toString());
                startActivity(intent);
            }
        }
    }
}


