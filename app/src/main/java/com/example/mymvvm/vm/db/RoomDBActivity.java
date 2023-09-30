package com.example.mymvvm.vm.db;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.mymvvm.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RoomDBActivity extends AppCompatActivity {

    private UserListAdapter userListAdapter;
    List<User> userList = new ArrayList<>();
    private AppDatabase db ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maindb);
        db = AppDatabase.getDBInstance(this.getApplicationContext());

        Button addNewUserButton = findViewById(R.id.addNewUserButton);
        addNewUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(
                        new Intent(RoomDBActivity.this, AddNewUserActivity.class), 100);
            }
        });

        initRecyclerView();
        loadUserList();

    }

    private void initRecyclerView() {
        RecyclerView recyclerView =findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(this);
        recyclerView.setAdapter(userListAdapter);
    }


    public void loadUserList() {
        List<User> userl = db.userDao().getAllUsers();
        userListAdapter.setUserList(userl);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
     if(requestCode == 100){
         loadUserList();
     }


        super.onActivityResult(requestCode, resultCode, data);
    }


}