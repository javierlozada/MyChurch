package com.proyecto.mychurch.providers;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.proyecto.mychurch.Models.Persona;

import java.util.HashMap;
import java.util.Map;

public class Personaprovider {
    DatabaseReference mDatabase;

    public Personaprovider(){
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Personas");
    }

    public Task<Void> create(Persona persona){
        Map<String, Object> map = new HashMap<>();
        map.put("Name",persona.getName());
        map.put("email",persona.getEmail());
        return mDatabase.child(persona.getId()).setValue(map);
    }


    public DatabaseReference getPersona(String idPersona){
        return mDatabase.child(idPersona);
    }


    public Task<Void> update(Persona persona){
        Map<String, Object> map = new HashMap<>();
        map.put("name",persona.getName());
        map.put("image", persona.getImage());
        return mDatabase.child(persona.getId()).updateChildren(map);
    }


}
