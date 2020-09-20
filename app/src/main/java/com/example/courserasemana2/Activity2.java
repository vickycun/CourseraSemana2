package com.example.courserasemana2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class Activity2 extends AppCompatActivity {

    private TextView tvNombre;
    private TextView tvFecha;
    private TextView tvTelefono;
    private TextView tvEmail;
    private TextView tvDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        //para obtener los datos transferidos desde MainActivity
        Bundle extras = getIntent().getExtras();
        final String nombre     = extras.getString(getResources().getString(R.string.et_nombre));
        final String telefono   = extras.getString(getResources().getString(R.string.et_telefono));
        final String email      = extras.getString(getResources().getString(R.string.et_email));
        final String descripcion= extras.getString(getResources().getString(R.string.et_descripcion));
        final String fecha            = extras.getString(getResources().getString(R.string.et_fecha));

        tvNombre        = (TextView) findViewById(R.id.tvNombre);
        tvFecha         = (TextView) findViewById(R.id.tvFechaNac);
        tvTelefono      = (TextView) findViewById(R.id.tvTelefono);
        tvEmail         = (TextView) findViewById(R.id.tvEmail);
        tvDescripcion   = (TextView) findViewById(R.id.tvDescripcion);

        tvNombre.setText(nombre);
        tvFecha.setText(fecha);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        //botón Editar para regresar al MainActivity
        MaterialButton btnEditarDatos = (MaterialButton) findViewById(R.id.btnEditar);
        btnEditarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Activity2.this, MainActivity.class);
                i.putExtra(getResources().getString(R.string.et_nombre), nombre);
                i.putExtra(getResources().getString(R.string.et_fecha), fecha);
                i.putExtra(getResources().getString(R.string.et_telefono), telefono);
                i.putExtra(getResources().getString(R.string.et_email), email);
                i.putExtra(getResources().getString(R.string.et_descripcion), descripcion);
                startActivity(i);
                finish();

            }
        });

    }
}