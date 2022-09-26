package com.myfirebasedatab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateActivity extends AppCompatActivity {

    EditText edtfn,edtLn;
    Button btnUpdate,btnDelete;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        firebaseDatabase = FirebaseDatabase.getInstance("https://myfirebasedatab-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference("people");

        edtfn=findViewById(R.id.edt_fn);
        edtLn=findViewById(R.id.edt_ln);
        btnUpdate=findViewById(R.id.btn_update);
        btnDelete=findViewById(R.id.btn_delete);


        Intent i = getIntent();
        String strfn = i.getStringExtra("FIRST_NAME");
        String strln = i.getStringExtra("LAST_NAME");
        final String strid = i.getStringExtra("ID");
        edtfn.setText(strfn);
        edtLn.setText(strln);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fn = edtfn.getText().toString();
                String ln = edtLn.getText().toString();

                Bean b = new Bean();
                b.setFirstName(fn);
                b.setLastName(ln);
                b.setId(strid);

                databaseReference.child(strid).setValue(b);
                Intent i = new Intent(UpdateActivity.this, DisplayActivity.class);
                startActivity(i);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.child(strid).removeValue();
                Intent i = new Intent(UpdateActivity.this, DisplayActivity.class);
                startActivity(i);

            }
        });
    }


}