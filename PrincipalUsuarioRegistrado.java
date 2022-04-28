package com.example.tfg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

public class PrincipalUsuarioRegistrado extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal_usuario_registrado);
        // Ocultar titulo del menu
        Toolbar toolbar = (Toolbar) findViewById(R.id.menu_userRegistred);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.principal_usuario_registrado, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //AdapterView.AdapterContextMenuInfo info= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        switch (item.getItemId()) {
            case R.id.UserDate:
                Intent intentDate = new Intent(PrincipalUsuarioRegistrado.this, UserData.class);
                startActivity(intentDate);
                return true;
            case R.id.Orders:
                Intent intentOrders = new Intent(PrincipalUsuarioRegistrado.this, orders_list.class);
                startActivity(intentOrders);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}
