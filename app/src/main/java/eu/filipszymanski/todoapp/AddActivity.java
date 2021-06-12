package eu.filipszymanski.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Button button = (Button) findViewById(R.id.addButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewTodo();
            }
        });
    }

    public void addNewTodo(){
        EditText todoInput = findViewById(R.id.newTodoInput);
        String newTodo = todoInput.getText().toString();
        MainActivity.todos.add(newTodo);

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}