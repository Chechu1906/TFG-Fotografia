package com.example.tfg_fotografia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class LogIn extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        /*//Añadir Datos
        CollectionReference usuario = db.collection("usuario");
        Map<String, Object> user = new HashMap<>();
        user.put("Nombre", "Jesus");
        usuario.document("Chechu").set(user);
        */


        //Ver datos
        TextView prueba = (TextView) findViewById(R.id.textView);

        DocumentReference docRef = db.collection("usuario").document("Chechu");
        docRef.get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    DocumentSnapshot document = task.getResult();

                    Map<String, Object> map = document.getData();

                    prueba.setText(map.get("Nombre").toString());
                }else{

                }
            }
        });

    }
}