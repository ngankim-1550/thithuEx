package com.example.thithuex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.adapter.MealAdapter;
import com.example.model.Meal;

import java.util.ArrayList;

public class MealActivity extends AppCompatActivity {
    ImageView imvThumb;
    ListView lvDish;
    MealAdapter adapter;
    ArrayList<Meal> mealAnSnag,mealAnTrua;
    String MealTag;
    MyDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meal);
        db= new MyDataBase(MealActivity.this);
        db.createSomeDefaultTasks();
        linkViews();
        getData();
        getDataFromDB();
        initData();

    }

    private void getData() {
        Intent intent= getIntent();
        MealTag= intent.getStringExtra("Meal");

    }

    private void getDataFromDB(){
        mealAnSnag = new ArrayList<>();
        Cursor cursor = db.getData("SELECT * FROM "+MyDataBase.TBL_NAME );

        mealAnSnag.clear();
        while (cursor.moveToNext()){
            mealAnSnag.add(new Meal(cursor.getInt(0), cursor.getInt(1),cursor.getString(2),cursor.getDouble(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6)));
        }
        cursor.close();
        mealAnTrua = new ArrayList<>();
        Cursor cursor1 = db.getData("SELECT * FROM "+MyDataBase.TBL_NAME +" WHERE "+MyDataBase.COL_W_MEAL_TYPE+"='Ặn Trưa'");

        mealAnTrua.clear();
        while (cursor.moveToNext()){
            mealAnTrua.add(new Meal(cursor.getInt(0), cursor.getInt(1),cursor.getString(2),cursor.getDouble(3),cursor.getInt(4),cursor.getString(5),cursor.getString(6)));
        }
        cursor.close();
    }
    private void initData() {
        if(MealTag.equals("Breakfast")) {
            adapter = new MealAdapter(MealActivity.this, mealAnSnag, R.layout.item_layout_main);
            lvDish.setAdapter(adapter);
        }
        else if(MealTag.equals("Lunch")) {
            adapter = new MealAdapter(MealActivity.this, mealAnTrua, R.layout.item_layout_main);
            lvDish.setAdapter(adapter);
        }
    }

    private void linkViews() {
        lvDish=findViewById(R.id.lvDish);
        imvThumb=findViewById(R.id.imvThumb);
    }

}