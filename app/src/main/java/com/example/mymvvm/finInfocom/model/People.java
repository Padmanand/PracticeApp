package com.example.mymvvm.finInfocom.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class People {

    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "name")
    public String Name;

    @ColumnInfo(name = "age")
    public Integer Age;

    @ColumnInfo(name = "city")
    public String City;

}
