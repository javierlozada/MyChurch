package com.proyecto.mychurch.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.proyecto.mychurch.Includes.Mytoolbar;
import com.proyecto.mychurch.R;

public class Login extends AppCompatActivity {
     private Button btn_iniciar_sesion;
     private TextView txt_enscribirse;
     private TextInputEditText edt_correo;
     private TextInputEditText edt_password;

     private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Mytoolbar.show(Login.this,"MyChurch",false);

        btn_iniciar_sesion  = findViewById(R.id.btn_iniciar_sesion);
        txt_enscribirse     = findViewById(R.id.txt_enscribirse);
        edt_correo          = findViewById(R.id.edt_correo);
        edt_password        = findViewById(R.id.edt_password);

        mAuth = FirebaseAuth.getInstance();

        txt_enscribirse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, signup_persona.class);
                startActivity(intent);
            }
        });

        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });
    }//end oncreate

    private void login() {
        String email        = edt_correo.getText().toString();
        String contrasena   = edt_password.getText().toString();

        if(!email.isEmpty() && !contrasena.isEmpty()){
            if(contrasena.length() >= 6){
                mAuth.signInWithEmailAndPassword(email,contrasena).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent intent = new Intent(Login.this, MainActivity.class);
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(intent);

                            Toast.makeText(Login.this, "Se logueo satisfactoriamente",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(Login.this, "El correo o la contraseña  son incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }// end onComplete
                }); //end signInWithEmailAndPassword
            }else{
                Toast.makeText(Login.this, "La contraseña debe de tener mas de 6 caracteres", Toast.LENGTH_SHORT).show();
            }
        }else{
            Toast.makeText(Login.this, "La contraseña y el correo son obligatorios", Toast.LENGTH_SHORT).show();
        }
    }// end login
}