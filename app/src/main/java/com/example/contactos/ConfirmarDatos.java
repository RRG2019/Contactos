package com.example.contactos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ConfirmarDatos extends AppCompatActivity {

    TextView etNombre;
    TextView etFechaNacimiento;
    TextView etTelefono;
    TextView etEmail;
    TextView etDescripcion;
    Button btnEditarContacto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmar_datos);

        final Bundle parametros = getIntent().getExtras();

        String nombre = parametros.getString("Nombre");
        String fecha = parametros.getString("FechaNacimiento");
        String telefono = parametros.getString("Telefono");
        String email = parametros.getString("Email");
        String descripcion = parametros.getString("Descripcion");

        etNombre = findViewById(R.id.etNombre);
        etFechaNacimiento = findViewById(R.id.etFechaNacimiento);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);

        etNombre.setText(nombre);
        etFechaNacimiento.setText("Fecha de Nacimiento: " + fecha);
        etTelefono.setText("Teléfono: " + telefono);
        etEmail.setText("Email: " + email);
        etDescripcion.setText("Descripción: " + descripcion);

        btnEditarContacto = findViewById(R.id.btnEditarContacto);
        btnEditarContacto.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View view) {

                finish();
            }
        });
    }

}