package com.example.usuario.ejercicio3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener{

    private Intent intent;

    private Button okButton;
    private Button cancelButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        intent=getIntent();
        if(intent!=null) {
            String nombre = intent.getStringExtra("nombreUsuario");
            Toast.makeText(this,"soy "+ nombre,Toast.LENGTH_LONG).show();
        }

        init();


    }

    private void init() {

        okButton=(Button)findViewById(R.id.okButton);
        cancelButton=(Button)findViewById(R.id.cancelButton);
        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.okButton:
                Intent intent =new Intent();
                intent.putExtra("respuesta","la clase ha terminado");


                setResult(Activity.RESULT_OK,intent);

                break;

            case R.id.cancelButton:
                setResult(Activity.RESULT_CANCELED);

                break;
        }

        finish();

    }
}
