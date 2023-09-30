package com.example.mymvvm.finInfocom.db;

import com.example.mymvvm.finInfocom.model.People;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface PeopleDao {

    @Query("SELECT * FROM people")
    List<People> getAllPeople();

    @Insert
    void insertPeople(People... people);

    @Delete
    void delete(People people);

    @Query("DELETE FROM people")
    void deleteAllData();

    @Query("SELECT * FROM people ORDER BY name ASC")
    List<People> getPeopleSortByName();

    @Query("SELECT * FROM people ORDER BY age ASC")
    List<People> getPeopleSortByAge();

    @Query("SELECT * FROM people ORDER BY city ASC")
    List<People> getPeopleSortByCity();
}
