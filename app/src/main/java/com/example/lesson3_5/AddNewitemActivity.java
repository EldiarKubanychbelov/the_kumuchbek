package com.example.lesson3_5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewitemActivity extends AppCompatActivity {

    private Button addTaskBtn;
    private EditText txtEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_newitem);

        addTaskBtn = findViewById(R.id.add_new_task_btn);
        txtEdit = findViewById(R.id.task_title_et);

        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra("name", txtEdit.getText().toString()); //Установил данные
                setResult(RESULT_OK, intent); //Сообщил, что данные для результата установлены
                finish(); //Закрыл Activity. Далее код сработает вonActivityResult
            }
        });
    }
}