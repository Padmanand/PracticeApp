package com.example.mymvvm.vm.db;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.mymvvm.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    RecyclerView recyclerView;
    List<StudentsViewModel> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        StudentsViewModel studentsViewModel = new StudentsViewModel();
        studentsViewModel.name  = "abcd";
        studentsViewModel.email = "abcd@gmail.com";
        data.add(studentsViewModel);

        StudentsViewModel studentsViewModel1 = new StudentsViewModel();
        studentsViewModel1.name  = "xyz";
        studentsViewModel1.email = "xyz@gmail.com";
        data.add(studentsViewModel1);

        StudentsViewModel studentsViewModel2 = new StudentsViewModel();
        studentsViewModel2.name  = "eats";
        studentsViewModel2.email = "eats@gmaial.com";
        data.add(studentsViewModel2);

        StudentsAdapter studentsAdapter = new StudentsAdapter(data, MainActivity.this);
        recyclerView.setAdapter(studentsAdapter);

        Log.d("size", "onCreate: "+ data.size());

    }

}