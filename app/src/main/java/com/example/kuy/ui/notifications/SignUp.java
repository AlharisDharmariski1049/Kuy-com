package com.example.kuy.ui.notifications;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kuy.MainActivity;
import com.example.kuy.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    EditText email, pass;
    Button btnSignUp;
    TextView tvsignin;
    FirebaseAuth mFirebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mFirebaseAuth = FirebaseAuth.getInstance();
        email= findViewById(R.id.email);
        pass = findViewById(R.id.password);
        btnSignUp=findViewById(R.id.next);
        tvsignin = findViewById(R.id.back);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emails = email.getText().toString();
                String passw = pass.getText().toString();
                if(emails.isEmpty()){
                    email.setError("please enter email ");
                    email.requestFocus();
                }
                else if(passw.isEmpty()){
                    pass.setError("please enter your password");
                    pass.requestFocus();
                }
                else if(emails.isEmpty() && passw.isEmpty()){
                    Toast.makeText(SignUp.this, "Fields Are Empty!", Toast.LENGTH_SHORT).show();
                }
                else if(!(emails.isEmpty() && passw.isEmpty())){
                    mFirebaseAuth.createUserWithEmailAndPassword(emails,passw).addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (!task.isSuccessful()){
                                Toast.makeText(SignUp.this, "SignUp Unsuccessful, Please Try Again", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                startActivity(new Intent(SignUp.this,DaftarFilm.class));
                            }
                        }
                    });
                }
                else {
                    Toast.makeText(SignUp.this, "Error Ocurred", Toast.LENGTH_SHORT).show();
                }
            }
        });

        tvsignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(SignUp.this, LoginActivity.class);
                startActivity(a);
            }
        });



    }
}
