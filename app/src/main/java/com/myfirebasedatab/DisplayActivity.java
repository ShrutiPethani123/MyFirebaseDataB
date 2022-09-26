package com.myfirebasedatab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class DisplayActivity extends AppCompatActivity {

    ListView listView;
    DatabaseReference databaseReference;
    FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        listView=findViewById(R.id.list_view);
        firebaseDatabase = FirebaseDatabase.getInstance("https://myfirebasedatab-default-rtdb.asia-southeast1.firebasedatabase.app/");
        databaseReference = firebaseDatabase.getReference("people");
        ArrayList<Bean> beanrraylist = new ArrayList<Bean>();
    databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {

            for(DataSnapshot dataSnapshot : snapshot.getChildren() ){
                Bean bean = dataSnapshot.getValue(Bean.class);
                beanrraylist.add(bean);


            }
            MyBaseAdapter myBaseAdapter = new MyBaseAdapter(DisplayActivity.this,beanrraylist);
            listView.setAdapter(myBaseAdapter);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    }) ;




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id1) {

                String fName=beanrraylist.get(position).getFirstName() ;
                String lName=beanrraylist.get(position).getLastName();
                String id = beanrraylist.get(position).getId();
//                Toast.makeText(DisplayActivity.this,fName,Toast.LENGTH_SHORT).show();


                Intent i1 = new Intent(DisplayActivity.this,UpdateActivity.class);
                i1.putExtra("FIRST_NAME",fName);
                i1.putExtra("LAST_NAME",lName);
                i1.putExtra("ID",id);
                startActivity(i1);

            }
        });
    }
}