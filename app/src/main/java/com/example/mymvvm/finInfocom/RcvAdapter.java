package com.example.mymvvm.finInfocom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mymvvm.R;
import com.example.mymvvm.finInfocom.model.People;
import com.example.mymvvm.finInfocom.model.PojoItem;

import java.util.ArrayList;
import java.util.List;

import androidx.recyclerview.widget.RecyclerView;


public class RcvAdapter extends RecyclerView.Adapter<RcvAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<PojoItem> contactList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTvName;
        TextView mTvAge;
        TextView mTvCity;

        public MyViewHolder(View view) {
            super(view);
            mTvName = view.findViewById(R.id.textName);
            mTvAge = view.findViewById(R.id.textAge);
            mTvCity = view.findViewById(R.id.textCity);
        }

    }

    public RcvAdapter(Context context, ArrayList<PojoItem> contactList){
        this.context = context;
        this.contactList = contactList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.single_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        final PojoItem mPeople_Object = contactList.get(position);

        holder.mTvName.setText(mPeople_Object.getName());
        holder.mTvAge.setText(mPeople_Object.getAge());
        holder.mTvCity.setText(mPeople_Object.getCity());

    }


    @Override
    public int getItemCount() {
        return contactList.size();
    }


}
