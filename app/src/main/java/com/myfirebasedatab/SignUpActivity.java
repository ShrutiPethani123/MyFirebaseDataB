package com.myfirebasedatab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class SignUpActivity extends AppCompatActivity {

    Button btnsignup , btnLogin;
    EditText edtFn,edtLn,edtemail,edtpass;

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        firebaseAuth = FirebaseAuth.getInstance();
        btnsignup=findViewById(R.id.btn_signup);
        btnLogin=findViewById(R.id.btn_login);
        edtFn=findViewById(R.id.edt_fn);
        edtLn = findViewById(R.id.edt_ln);
        edtemail=findViewById(R.id.edt_email);
        edtpass=findViewById(R.id.edt_password);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = edtFn.getText().toString();
                String ln = edtLn.getText().toString();
                String strEmail=edtemail.getText().toString();
                String strPass = edtpass.getText().toString();

                firebaseAuth.createUserWithEmailAndPassword(strEmail,strPass).addOnCompleteListener(SignUpActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if(task.isSuccessful())
                        {
                            String uid=firebaseAuth.getUid();
                            Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
                            startActivity(i);
                        }

                    }
                });



            }
        });


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SignUpActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}