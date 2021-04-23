package com.example.lesson3_5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.ReceiverCallNotAllowedException;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MainActivity extends AppCompatActivity {

     private RecyclerView rvTask;
     private TaskAdapter adapter;
     private FloatingActionButton btnOpenSecondActivity;
     TextView txtView;

    private final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initOpenSecondActivityButton();
        initRecycler();

//        LOG.d(TAG,"onCreate");
    }

    private void initOpenSecondActivityButton() {
        btnOpenSecondActivity = findViewById(R.id.btn_second_activity);
        btnOpenSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddNewitemActivity.class);
                startActivityForResult(intent,10);
            }
        });
    }


    private void initRecycler(){
        rvTask = findViewById(R.id.rv_item);

        List<String> list = new ArrayList<>();
        list.add("Value 1");
        list.add("Value 2");
        list.add("Value 3");
        list.add("Value 3");
        list.add("Value 3");
        list.add("Value 3");


        adapter = new TaskAdapter(this,list);
        rvTask.setLayoutManager(new LinearLayoutManager(this));
        rvTask.setAdapter(adapter);
     }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        LOG.d(TAG,"onDestroy");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        LOG.d(TAG,"onStop");
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//        LOG.d(TAG,"onStart");
//    }
//    @Override
//    protected void onResume() {
//        super.onResume();
//        LOG.d(TAG,"onResume");
//    }
//
//    @Override
//    protected void onRestart() {
//        super.onRestart();
//        LOG.d(TAG,"onRestart");
//    }
}