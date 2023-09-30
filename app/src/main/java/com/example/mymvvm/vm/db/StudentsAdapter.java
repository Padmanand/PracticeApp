package com.example.mymvvm.vm.db;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.mymvvm.databinding.StudentBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentsAdapter extends RecyclerView.Adapter<StudentsAdapter.ViewHolder> {

    public static final String TAG = StudentsAdapter.class.getSimpleName();
    List<StudentsViewModel> data;
    Context context;
    private LayoutInflater inflater;

    public StudentsAdapter(List<StudentsViewModel> data, Context context){
        Log.d(TAG, "constructor: " + data.size());
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(inflater == null){
            inflater = LayoutInflater.from(parent.getContext());
        }
        StudentBinding studentBinding = StudentBinding.inflate(inflater,parent,false);
        return new ViewHolder(studentBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentsAdapter.ViewHolder holder, int position) {
        StudentsViewModel studentsModel = data.get(position);
        Log.d(TAG, data.get(position).name + " " +
                data.size() + "pos=" + position + "onBindViewHolder");
        holder.bind(studentsModel);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: "+ data.size());
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private StudentBinding studentBinding;

        public ViewHolder(StudentBinding studentBinding) {
            super(studentBinding.getRoot());
            this.studentBinding = studentBinding;
        }

        public void bind(StudentsViewModel studentsViewModel) {
            this.studentBinding.setViewModel(studentsViewModel);
        }

        public StudentBinding getStudentBinding() {
            return studentBinding;
        }

    }

}
