package com.example.mymvvm.finInfocom;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.mymvvm.R;
import com.example.mymvvm.finInfocom.db.AppDatabase;
import com.example.mymvvm.finInfocom.model.People;
import com.example.mymvvm.finInfocom.model.PojoItem;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class RcvActivity extends AppCompatActivity {

    private AppDatabase db ;
    private String TAG = "tag11";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rcv);
        db = AppDatabase.getDBInstance(this.getApplicationContext());

        insertDataIntoDatabase();

        List<People> myListData = db.peopleDao().getAllPeople();
        ArrayList<PojoItem> PojoItems = new ArrayList<>();

        for (int i = 0; i < myListData.size(); i++){
            PojoItem pojoItem = new PojoItem();
            pojoItem.setName(myListData.get(i).Name);
            pojoItem.setAge(String.valueOf(myListData.get(i).Age));
            pojoItem.setCity(myListData.get(i).City);
            PojoItems.add(pojoItem);
            Log.d(TAG, "onCreate: " + i + pojoItem.getName()+ pojoItem.getAge() + pojoItem.getCity());
        }

        initRecyclerview(myListData,PojoItems);


    }

    private void initRecyclerview(List<People> myListData, ArrayList<PojoItem> pojoItems) {
        Log.d(TAG, "onCreate: " + myListData.size());
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcv);
        RcvAdapter rcvadapter = new RcvAdapter(this,pojoItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        recyclerView.setAdapter(rcvadapter);
    }

    private void insertDataIntoDatabase() {
        People people = new People();
        people.Name = "Abhishek";
        people.Age = 50;
        people.City = "Mumbai";
        db.peopleDao().insertPeople(people);

        People people1 = new People();
        people1.Name = "Kashinath";
        people1.Age = 60;
        people1.City = "Lucknow";
        db.peopleDao().insertPeople(people1);

        People people2 = new People();
        people2.Name = "Amarnath";
        people2.Age = 40;
        people2.City = "Hyderabad";
        db.peopleDao().insertPeople(people2);

        People people3 = new People();
        people3.Name = "Rahul";
        people3.Age = 35;
        people3.City = "Delhi";
        db.peopleDao().insertPeople(people3);

        People people4 = new People();
        people4.Name = "Avinash";
        people4.Age = 45;
        people4.City = "Chennai";
        db.peopleDao().insertPeople(people4);

        People people5 = new People();
        people5.Name = "Vivek";
        people5.Age = 20;
        people5.City = "Noida";
        db.peopleDao().insertPeople(people5);

        People people6 = new People();
        people6.Name = "Ankit";
        people6.Age = 28;
        people6.City = "Chandigarh";
        db.peopleDao().insertPeople(people6);

        People people7 = new People();
        people7.Name = "Manoj";
        people7.Age = 38;
        people7.City = "Kerala";
        db.peopleDao().insertPeople(people7);

        People people8 = new People();
        people8.Name = "Prakash";
        people8.Age = 34;
        people8.City = "Vijaywada";
        db.peopleDao().insertPeople(people8);

        People people9 = new People();
        people9.Name = "Harsha";
        people9.Age = 42;
        people9.City = "Gulbarga";
        db.peopleDao().insertPeople(people9);

        People people10 = new People();
        people10.Name = "Tej";
        people10.Age = 10;
        people10.City = "Lingampally";
        db.peopleDao().insertPeople(people10);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.name:
                db.peopleDao().deleteAllData();
                insertDataIntoDatabase();
                List<People> myListDataName = db.peopleDao().getPeopleSortByName();
                ArrayList<PojoItem> PojoItems = new ArrayList<>();

                for (int i = 0; i < myListDataName.size(); i++){
                    PojoItem pojoItem = new PojoItem();
                    pojoItem.setName(myListDataName.get(i).Name);
                    pojoItem.setAge(String.valueOf(myListDataName.get(i).Age));
                    pojoItem.setCity(myListDataName.get(i).City);
                    PojoItems.add(pojoItem);
                }

                initRecyclerview(myListDataName,PojoItems);

                return true;
            case R.id.age:
                db.peopleDao().deleteAllData();
                insertDataIntoDatabase();
                List<People> myListDataAge = db.peopleDao().getPeopleSortByAge();
                ArrayList<PojoItem> PojoItemsAge = new ArrayList<>();

                for (int i = 0; i < myListDataAge.size(); i++){
                    PojoItem pojoItem = new PojoItem();
                    pojoItem.setName(myListDataAge.get(i).Name);
                    pojoItem.setAge(String.valueOf(myListDataAge.get(i).Age));
                    pojoItem.setCity(myListDataAge.get(i).City);
                    PojoItemsAge.add(pojoItem);
                }

                initRecyclerview(myListDataAge,PojoItemsAge);


                return true;
            case R.id.city:

                db.peopleDao().deleteAllData();
                insertDataIntoDatabase();
                List<People> myListDataCity = db.peopleDao().getPeopleSortByCity();
                ArrayList<PojoItem> PojoItemsCity = new ArrayList<>();

                for (int i = 0; i < myListDataCity.size(); i++){
                    PojoItem pojoItem = new PojoItem();
                    pojoItem.setName(myListDataCity.get(i).Name);
                    pojoItem.setAge(String.valueOf(myListDataCity.get(i).Age));
                    pojoItem.setCity(myListDataCity.get(i).City);
                    PojoItemsCity.add(pojoItem);
                }

                initRecyclerview(myListDataCity,PojoItemsCity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        db.peopleDao().deleteAllData();
        Log.d("deleteback", "onDestroy: ");
    }
}