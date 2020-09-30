package com.proyecto.mychurch.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.proyecto.mychurch.Includes.Mytoolbar;
import com.proyecto.mychurch.Models.Persona;
import com.proyecto.mychurch.R;
import com.proyecto.mychurch.providers.AuthProvider;
import com.proyecto.mychurch.providers.Personaprovider;

public class signup_persona extends AppCompatActivity {

    private Button btn_registarse;
    private TextInputEditText edt_correo;
    private TextInputEditText edt_cumpleanos;
    private TextInputEditText edt_password;
    private TextInputEditText edt_confirmarContra;
    private TextInputEditText edt_nombre;

    AuthProvider mAuthprovider;
    Personaprovider mPersonaprovider;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_persona);

        Mytoolbar.show(signup_persona.this,"Enscribirse",true);

        mAuthprovider       = new AuthProvider();
        mPersonaprovider    = new Personaprovider();

        btn_registarse  = findViewById(R.id.btn_registarse);
        edt_correo      = findViewById(R.id.edt_correo);
        edt_cumpleanos  = findViewById(R.id.edt_cumpleanos);
        edt_password    = findViewById(R.id.edt_password);
        edt_confirmarContra = findViewById(R.id.edt_confirmarContra);
        edt_nombre          = findViewById(R.id.edt_nombre);

        btn_registarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterUser();
            }
        });

    }//end onCreate

    private void RegisterUser() {
        String correo   = edt_correo.getText().toString();
        String cumple   = edt_cumpleanos.getText().toString();
        String contra   = edt_password.getText().toString();
        String confContr=  edt_confirmarContra.getText().toString();
        String nombre   = edt_nombre.getText().toString();

        if(!correo.isEmpty() && !cumple.isEmpty() && !contra.isEmpty() && !confContr.isEmpty() && !nombre.isEmpty()){
            if(contra.length() >= 6){
                if(confContr.equals(confContr)){
                    register(correo,cumple,contra);
                }else{
                    Toast.makeText(signup_persona.this, "No se pudo registrar el usuario ", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(signup_persona.this, "Ingrese todos los datos", Toast.LENGTH_SHORT).show();
            }
        }

    }//end RegisterUser

    private void register(final String email, final String nombre, String contra) {
        mAuthprovider.register(email,contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    String id = FirebaseAuth.getInstance().getCurrentUser().getUid();
                    Persona persona = new Persona(id,email,nombre);
                    createPersona(persona);
                }else{
                    Toast.makeText(signup_persona.this, "No se pudo registrar el usuario" + task.getException(), Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }//end refgister

    private void createPersona(Persona persona) {
        mPersonaprovider.create(persona).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){

                }else {
                    Toast.makeText(signup_persona.this, "No se pudo registrar el usuario", Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }//end create Persona
}