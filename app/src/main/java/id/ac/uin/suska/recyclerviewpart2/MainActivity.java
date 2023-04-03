package id.ac.uin.suska.recyclerviewpart2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private MyAdapter.RecyclerViewClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        usersList = new ArrayList<>();
        setUserInfo();
        setAdapter();
    }

    private void setAdapter() {
        setOnClickListener();
        MyAdapter adapter = new MyAdapter(usersList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListener() {
        listener = new MyAdapter.RecyclerViewClickListener() {
            @Override
            public void onClick(View v, int possition) {
                Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
                intent.putExtra("username", usersList.get(possition).getUsername());
                startActivity(intent);
            }
        };
    }

    private void setUserInfo() {
        usersList.add(new User("Kirisu"));
        usersList.add(new User("Reirisu"));
        usersList.add(new User("Ucup"));
        usersList.add(new User("Sopo"));
        usersList.add(new User("WohKAGet"));
    }
}