package com.proyecto.mychurch.providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AuthProvider {
    FirebaseAuth mAuth;

    public AuthProvider(){
        mAuth = FirebaseAuth.getInstance();
    }

    public Task<AuthResult> register(String email, String password){
        return mAuth.createUserWithEmailAndPassword(email,password);
    }

    public void Signout(){
        mAuth.signOut();
    }

    public String getID(){
        return mAuth.getUid();
    }


    public boolean existSession(){
        boolean exist = false;
        if(mAuth.getCurrentUser() != null){
            exist = true;
        }
        return exist;
    }


}
