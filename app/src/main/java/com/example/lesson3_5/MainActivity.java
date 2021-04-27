package com.example.lesson3_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvTask;
    private TaskAdapter adapter;
    private FloatingActionButton btnOpenSecondActivity;
    private TextView txtView;

    private final int REQUEST_CODE = 10;
    private List<String> list;

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
                Intent intent = new Intent(MainActivity.this, AddNewitemActivity.class);
                //Метод startActivityForResult запускает Activity, ожидая от него данные, то есть результат. Потому метод и назван startActivityFORRESULT
                //Далее код выполняется в AddNewItemActivity
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    private void initRecycler() {
        rvTask = findViewById(R.id.rv_item);

        list = new ArrayList<>();



        adapter = new TaskAdapter(this, list);
        rvTask.setLayoutManager(new LinearLayoutManager(this));
        rvTask.setAdapter(adapter);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Проверяем, тот же requestCode, который ты устаналивал при запуске AddNewItemActivity И(&&) проверяем тот ли у нас статус результата, то есть пришёл ли сюда RESULT_OK
        //Если да, то идём дальше
        if (requestCode == REQUEST_CODE && resultCode == RESULT_OK) {
            //Если объект data не null, то идём дальше
            if (data != null) {
                String text = data.getStringExtra("name"); //Получаем данные, установленные ранее как результат
                list.add(text); //Добавляем данные в список
                adapter.notifyDataSetChanged(); //Обновляем адаптер, который отвечает за отображение списка, чтобы новые данные отобразились
                //Всё :)
            }
        }
    }
}