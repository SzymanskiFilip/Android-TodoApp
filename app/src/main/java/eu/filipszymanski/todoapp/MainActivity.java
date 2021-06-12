package eu.filipszymanski.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<String> todos = new ArrayList<String>();






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton addActivity = (FloatingActionButton) findViewById(R.id.switchToAddActivity);
        addActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddActivity();
            }
        });

        loadTodos();




    }

    public void loadTodos(){
        ListView todosList = findViewById(R.id.listView);
        ArrayAdapter<String> itemsAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, todos);
        todosList.setAdapter(itemsAdapter);

        todosList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                todos.remove(position);
                loadTodos();
            }
        });
    }

    public void addTodo(String newTodo){
        todos.add(newTodo);
    }

    public void openAddActivity(){
        Intent intent = new Intent(this, AddActivity.class);
        startActivity(intent);
    }


}