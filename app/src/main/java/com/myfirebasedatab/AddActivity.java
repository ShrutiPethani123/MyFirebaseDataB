package com.myfirebasedatab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddActivity extends AppCompatActivity {

    Button btnAdd , btnDisplay;
    EditText edtFn,edtLn;

    FirebaseDatabase firebaseDatabase ;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        firebaseDatabase = FirebaseDatabase.getInstance("https://myfirebasedatab-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference("people");

        btnAdd=findViewById(R.id.btn_add);
        btnDisplay=findViewById(R.id.btn_display);
        edtFn=findViewById(R.id.edt_fn);
        edtLn = findViewById(R.id.edt_ln);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = edtFn.getText().toString();
                String ln = edtLn.getText().toString();
                String id=databaseReference.push().getKey();

                Bean b = new Bean();
                b.setFirstName(fn);
                b.setLastName(ln);
                b.setId(id);

                databaseReference.child(id).setValue(b);
                edtFn.setText(" ");
                edtLn.setText(" ");



            }
        });


        btnDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AddActivity.this,DisplayActivity.class);
                startActivity(i);
                finish();
            }
        });

    }
}