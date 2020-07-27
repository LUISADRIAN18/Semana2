package com.lagn.contactosintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DetalleContacto extends AppCompatActivity {

    private ListView ListaContactos;

    private ArrayAdapter<String> adaptador;
    private String[] dates;

String nombre="e",telefono="e", mail="e", descrip="e", fecha="e";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);


         ListaContactos= (ListView)findViewById(R.id.lista);
       Bundle parametro = getIntent().getExtras();
       nombre= parametro.getString("name");
       telefono= parametro.getString("telefono");
         mail= parametro.getString("mail");
         descrip= parametro.getString("descripcion");
         fecha=parametro.getString("fecha");


        dates= new String[]{"Nombre: "+nombre, "Telefono: "+telefono, "E-mail: "+mail, "Descripcion: "+descrip,
                "Nacimiento: "+ fecha};
        adaptador= new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dates);
        ListaContactos.setAdapter(adaptador);

    }

    public void boton(View v){

                finish();
            }


}