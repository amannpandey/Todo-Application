package com.symb.task.todo;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class CreateTodo extends AppCompatActivity {

    EditText editText;
    Button btn_save;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_todo);
        btn_save=findViewById(R.id.btn_save);
        editText=findViewById(R.id.todo_items);
        databaseHelper =new  DatabaseHelper(this);

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newEntry = editText.getText().toString();
                if(editText.length()!= 0){
                    AddData(newEntry);
                    editText.setText("");
                }else{
                    Toast.makeText(CreateTodo.this, "You must put something in the ToDo List...!", Toast.LENGTH_LONG).show();
                }

            }
        });
    }
    private void AddData(String newEntry) {

        boolean insertData = databaseHelper.addData(newEntry);

        if(insertData==true){
            Toast.makeText(this, "ToDo Successfully Inserted...!", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "Something Went wrong :(.", Toast.LENGTH_LONG).show();
        }

    }

}