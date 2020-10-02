package com.example.contactos;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import java.util.Calendar;
import android.view.View;


public class MainActivity extends AppCompatActivity {

    DatePickerDialog picker;
    EditText fecha;
    Button boton;
    EditText nombre;
    EditText telefono;
    EditText eMail;
    EditText descripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fecha = findViewById(R.id.etFechaNacimiento);
        fecha.setInputType(InputType.TYPE_NULL);
        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                fecha.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });

        boton = findViewById(R.id.btSiguiente);
        nombre = findViewById(R.id.etNombre);
        descripcion = findViewById(R.id.etDescripcion);
        telefono = findViewById(R.id.etTelefono);
        eMail = findViewById(R.id.etEmail);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this, ConfirmarDatos.class);
                i.putExtra("Nombre",nombre.getText().toString());
                i.putExtra("FechaNacimiento", fecha.getText().toString());
                i.putExtra("Telefono", telefono.getText().toString());
                i.putExtra("Email", eMail.getText().toString());
                i.putExtra("Descripcion", descripcion.getText().toString());
                startActivity(i);
            }
        });
    }
}