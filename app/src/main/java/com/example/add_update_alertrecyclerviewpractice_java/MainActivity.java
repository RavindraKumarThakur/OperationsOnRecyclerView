package com.example.add_update_alertrecyclerviewpractice_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatImageButton dialog_box = findViewById(R.id.Dialog_box);
        RecyclerView recyclerView = findViewById(R.id.recyclerPractice);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ContextInfoPractice> arrContact = new ArrayList<>();
        arrContact.add(new ContextInfoPractice(R.drawable.a,"Ravindra","9122186452"));
        arrContact.add(new ContextInfoPractice(R.drawable.b,"Ayush","7858990775"));
        arrContact.add(new ContextInfoPractice(R.drawable.c,"Ankit","9531408862"));
        arrContact.add(new ContextInfoPractice(R.drawable.d,"Birendra","8862995478"));
        arrContact.add(new ContextInfoPractice(R.drawable.e,"Rajan","8580314088"));
        arrContact.add(new ContextInfoPractice(R.drawable.a,"Ravindra","9122186452"));
        arrContact.add(new ContextInfoPractice(R.drawable.b,"Ayush","7858990775"));
        arrContact.add(new ContextInfoPractice(R.drawable.c,"Ankit","9531408862"));
        arrContact.add(new ContextInfoPractice(R.drawable.d,"Birendra","8862995478"));
        arrContact.add(new ContextInfoPractice(R.drawable.e,"Rajan","8580314088"));
        arrContact.add(new ContextInfoPractice(R.drawable.a,"Ravindra","9122186452"));
        arrContact.add(new ContextInfoPractice(R.drawable.b,"Ayush","7858990775"));
        arrContact.add(new ContextInfoPractice(R.drawable.c,"Ankit","9531408862"));
        arrContact.add(new ContextInfoPractice(R.drawable.d,"Birendra","8862995478"));
        arrContact.add(new ContextInfoPractice(R.drawable.e,"Rajan","8580314088"));
        arrContact.add(new ContextInfoPractice(R.drawable.a,"Ravindra","9122186452"));
        arrContact.add(new ContextInfoPractice(R.drawable.b,"Ayush","7858990775"));
        arrContact.add(new ContextInfoPractice(R.drawable.c,"Ankit","9531408862"));
        arrContact.add(new ContextInfoPractice(R.drawable.d,"Birendra","8862995478"));
        arrContact.add(new ContextInfoPractice(R.drawable.e,"Rajan","8580314088"));
        arrContact.add(new ContextInfoPractice(R.drawable.a,"Ravindra","9122186452"));
        arrContact.add(new ContextInfoPractice(R.drawable.b,"Ayush","7858990775"));
        arrContact.add(new ContextInfoPractice(R.drawable.c,"Ankit","9531408862"));
        arrContact.add(new ContextInfoPractice(R.drawable.d,"Birendra","8862995478"));
        arrContact.add(new ContextInfoPractice(R.drawable.e,"Rajan","8580314088"));

        RecyclerPracticeAdapter adapter = new RecyclerPracticeAdapter(MainActivity.this,arrContact);
        recyclerView.setAdapter(adapter);

        dialog_box.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_view_lay);
                dialog.show();
                EditText edtName = dialog.findViewById(R.id.updateName);
                EditText edtNumber = dialog.findViewById(R.id.updateNumber);
                Button actionBtn = dialog.findViewById(R.id.actionBtn);

                actionBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String Name,Number;
                        if (!edtName.getText().toString().equals("") && !edtNumber.getText().toString().equals("")){
                            Name = edtName.getText().toString();
                            Number = edtNumber.getText().toString();
                            arrContact.add(new ContextInfoPractice(R.mipmap.ic_launcher,Name,Number));
                            adapter.notifyItemInserted(arrContact.size()-1);
                            recyclerView.scrollToPosition(arrContact.size()-1);
                        }else if (!edtName.getText().toString().equals("") ){
                            Toast.makeText(MainActivity.this,"Please Enter Name!",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this,"Please Enter Number!",Toast.LENGTH_SHORT).show();

                        }
                        dialog.dismiss();
                    }
                });
            }
        });
    }
}