package com.example.courserasemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText nombre;
    private TextInputEditText telefono;
    private TextInputEditText email;
    private TextInputEditText descripcion;
    private DatePicker fecha;

    private String nom;
    private String tel;
    private String em;
    private String descr;
    private String fec;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre      = (TextInputEditText) findViewById(R.id.etNombre);
        telefono    = (TextInputEditText) findViewById(R.id.etTelefono);
        email       = (TextInputEditText) findViewById(R.id.etEmail);
        descripcion = (TextInputEditText) findViewById(R.id.etDescripcion);
        fecha       = (DatePicker) findViewById(R.id.dpFecha);

        MaterialButton btnSiguiente = (MaterialButton) findViewById(R.id.siguiente);
        btnSiguiente.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                nom    = nombre.getText().toString();
                tel    = telefono.getText().toString();
                em     = email.getText().toString();
                descr  = descripcion.getText().toString();
                fec    = getFecha();

                Intent i = new Intent(MainActivity.this, Activity2.class);
                i.putExtra(getResources().getString(R.string.et_nombre), nom);
                i.putExtra(getResources().getString(R.string.et_fecha), fec);
                i.putExtra(getResources().getString(R.string.et_telefono), tel);
                i.putExtra(getResources().getString(R.string.et_email), em);
                i.putExtra(getResources().getString(R.string.et_descripcion), descr);
                startActivity(i);
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        final String nombre     = extras.getString(getResources().getString(R.string.et_nombre));
        final String telefono   = extras.getString(getResources().getString(R.string.et_telefono));
        final String email      = extras.getString(getResources().getString(R.string.et_email));
        final String descripcion= extras.getString(getResources().getString(R.string.et_descripcion));
        final String fecha      = extras.getString(getResources().getString(R.string.et_fecha));

        this.nombre.setText(nombre);
        this.telefono.setText(telefono);
        this.email.setText(email);
        this.descripcion.setText(descripcion);

    }
    //método para obtener la fecha
    private String getFecha() {
        StringBuilder fechaSeleccionada = new StringBuilder();
        fechaSeleccionada.append("Fecha Nacimiento: "+fecha.getDayOfMonth()+"/"+fecha.getMonth()+"/"+fecha.getYear());
        return fechaSeleccionada.toString();
    }

}