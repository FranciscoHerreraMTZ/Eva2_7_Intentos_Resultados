package com.example.spart.eva2_7_intentos_resultados;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
TextView    tvResul;
Intent inContactos;
Intent inImagen;
Uri uContactos;
Uri uImagen;
final int Buscar_contactos = 1000;
    final int Buscar_imagenes = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResul = findViewById(R.id.tvResu);
        uContactos = ContactsContract.Contacts.CONTENT_URI;
        inContactos = new Intent(Intent.ACTION_PICK, uContactos);
        uImagen = Uri.parse("content://media/external/images/media");
        inImagen = new Intent(Intent.ACTION_PICK,uImagen);
    }
    public void click(View v){
        startActivityForResult(inContactos,Buscar_contactos);
    }
    public void clickImagen(View v){
        startActivityForResult(inImagen,Buscar_imagenes);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode){
            case Buscar_contactos:
                if (resultCode== Activity.RESULT_OK){
                    String sResu = data.getDataString();
                    tvResul.setText(sResu);
                }
                break;
            case Buscar_imagenes:
                break;
        }
    }
}






