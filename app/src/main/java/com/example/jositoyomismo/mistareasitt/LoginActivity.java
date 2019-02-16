package com.example.jositoyomismo.mistareasitt;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();


    }
    // Crear un toast
    public void crearNotificacion (View view){

        Toast notificacion = Toast.makeText(this, "Funcionalidad no disponible", Toast.LENGTH_LONG );
        notificacion.show();
    }
    //Funcionalidad del botón

    public void pushbutton (View view) {

        TextInputEditText user = (TextInputEditText) findViewById(R.id.cajaUsuario);
        TextInputEditText password = (TextInputEditText) findViewById(R.id.cajaPassword);

        if (user.getText().toString().equalsIgnoreCase("JOSE LUIS") && password.getText().toString().equalsIgnoreCase("1234")) {
            ;

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);

        } else {

            Toast notificacion = Toast.makeText(this, "Usuario y/o contraseña inválidos", Toast.LENGTH_LONG);
            notificacion.show();

        }
    }
}
