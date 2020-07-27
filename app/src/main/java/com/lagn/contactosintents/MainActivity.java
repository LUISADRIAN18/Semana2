package com.lagn.contactosintents;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private    EditText enombre, etelefono, eemail, etdescrip ;
    private TextView sefe;
    private ArrayList<String[]> ayList;
    private Button btguar;
    private Calendar C;
    private DatePickerDialog setdate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enombre= (EditText)findViewById(R.id.nombretxt);
        etelefono= (EditText)findViewById(R.id.telefonotxt);
        eemail= (EditText)findViewById(R.id.emailtxt);
        etdescrip= (EditText)findViewById(R.id.desctxt);
        sefe=(TextView)findViewById(R.id.fecha) ;

        sefe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                C=Calendar.getInstance();
                int day= C.get(Calendar.DAY_OF_MONTH);
                int month= C.get(Calendar.MONTH);
                int year= C.get(Calendar.YEAR);


                setdate= new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int iday, int imonth, int iyear) {

                        sefe.setText(iday + "/" + (imonth+1) +"/"+ iyear  +"/");

                    }
                }, day,month,year);

                setdate.show();

            }
        });



        botton();




    }


    public void botton() {
        btguar=(Button)findViewById(R.id.button5);
       btguar.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

           Intent intt = new Intent(getBaseContext(), DetalleContacto.class);
           intt.putExtra("name",enombre.getText().toString());
           intt.putExtra("telefono",etelefono.getText().toString());
           intt.putExtra("mail",eemail.getText().toString());
           intt.putExtra("descripcion", etdescrip.getText().toString());
           intt.putExtra("fecha",sefe.getText().toString());
           startActivity(intt);





           }
       });











    }


}