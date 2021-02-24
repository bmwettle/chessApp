package com.example.final_chess_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class new_player extends AppCompatActivity {
    Button create_button;
    EditText name;
    EditText password;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        name= findViewById(R.id.ET_name);
        password=findViewById(R.id.ET_password);
        create_button=findViewById(R.id.button);

        Toast.makeText(this,"ok",Toast.LENGTH_LONG);

        create_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username= name.getText().toString().trim();
                                String pass = password.getText().toString().trim();
                if(validate(username,pass)){
                    create(username,pass);
                }
            }
        });


    }
    private void create(String username,String pass){
         Toast.makeText(new_player.this, "it worked 1", Toast.LENGTH_LONG).show();
         auth= FirebaseAuth.getInstance();
         auth.createUserWithEmailAndPassword(username,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
           @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful() ){
                     Toast.makeText(new_player.this, "it worked!!", Toast.LENGTH_LONG).show();

                     startActivity(new Intent(new_player.this, MainActivity.class));

                 }else{
                     Toast.makeText(new_player.this, "it did not work 2 ", Toast.LENGTH_LONG).show();
                 }

             }
         });

    }
    private boolean validate(String s1,String s2){
        return(!(s1.isEmpty()||s2.isEmpty()));

    }
}
