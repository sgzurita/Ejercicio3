package com.example.usuario.ejercicio3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private EditText nombre;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=(Button)findViewById(R.id.button);
        nombre=(EditText)findViewById(R.id.nombreEditText);
        button.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(MainActivity.this,"es el final",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button:
                Intent intent=new Intent(this,SecondActivity.class);

                intent.putExtra("nombreUsuario",nombre.getText().toString());
                //startActivity(intent);
                startActivityForResult(intent,50);
                break;

        }




    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case 50:

                        if(resultCode==Activity.RESULT_CANCELED) {
                            Toast.makeText(this, "Cancel", Toast.LENGTH_LONG).show();
                        }
                        if(resultCode==Activity.RESULT_OK){
                            Toast.makeText(this, data.getStringExtra("respuesta"), Toast.LENGTH_LONG).show();
                        }

                break;
        }


    }
}
