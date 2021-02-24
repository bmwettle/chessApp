package com.example.final_chess_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.sql.DatabaseMetaData;

public class MainActivity extends AppCompatActivity {

    //private DatabaseReference my_database;
    Button login_button;
    EditText password;
    EditText name;
    Button Registration_button;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        run();
    }
    private void run(){
        makeDataBase();
        makeUI();
        Toast.makeText(this, "hello", Toast.LENGTH_LONG).show();

    }
    private void create(String username,String pass){
        //Toast.makeText(MainActivity.this, "it worked 1", Toast.LENGTH_LONG).show();
        auth= FirebaseAuth.getInstance();

        auth.createUserWithEmailAndPassword(username,pass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {


                if (task.isSuccessful() ){
                    Toast.makeText(MainActivity.this, "it  worked", Toast.LENGTH_LONG).show();

                    //startActivity(new Intent(MainActivity.this, MainActivity.class));

                }else{
                    Toast.makeText(MainActivity.this, "it did not work 2 ", Toast.LENGTH_SHORT).show();
                }

            }
        });
        Toast.makeText(MainActivity.this, username+pass, Toast.LENGTH_LONG).show();
    }
    private void makeUI(){
        password= findViewById(R.id.ETpassword);
        name=  findViewById(R.id.ETname);
        login_button= findViewById(R.id.login_button);

        login_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                verify(name.getText().toString(),password.getText().toString());

            }
        });
        Registration_button= findViewById(R.id.Registration_button);

        Registration_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                register();

            }
        });
    }
    private void verify(String name, String password){
        if (name.equals("ben") && password.equals("1234")){
            Intent intent = new Intent(MainActivity.this, homePageActivity.class);
            startActivity(intent);
        }
    }
    private void makeDataBase(){
       // auth= FirebaseAuth.getInstance();
    }
    private void register(){
       // Intent intent = new Intent(MainActivity.this, new_player.class);
        //startActivity(intent);
        create(name.getText().toString().trim(),password.getText().toString().trim());
    }
}


