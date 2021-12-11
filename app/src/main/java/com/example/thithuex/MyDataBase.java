package com.example.thithuex;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {
    public  static  final int DB_VERSION =1;
    public  static  final String DB_NAME="dish.sqlite";
    public  static  final String TBL_NAME= "Dish";
    public  static  final String COL_W_ID="Id";
    public  static  final String COL_W_IMAGE="Image";
    public  static  final String COL_W_NAME="Name";
    public  static  final String COL_W_RATE="Rate";
    public  static  final String COL_W_RATE_COUNT="Rate_Count";
    public  static  final String COL_W_ADDRESS="Address";
    public  static  final String COL_W_MEAL_TYPE="Meal_Type";


    public MyDataBase(@Nullable Context context) {
        super(context,DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="CREATE TABLE IF NOT EXISTS "+TBL_NAME + "("+ COL_W_ID+ " INTEGER PRIMARY KEY AUTOINCREMENT, "+COL_W_IMAGE+" INT, "+
                COL_W_NAME+" VARCHAR(100), "+COL_W_RATE+ " DOUBLE, "+COL_W_RATE_COUNT+" INT, "+COL_W_ADDRESS+" VARCHAR(200), "+COL_W_MEAL_TYPE+" VARCHAR(80))";
        sqLiteDatabase.execSQL(sql);


    }
    public  int getCount(){
        SQLiteDatabase db= getReadableDatabase();
        Cursor cursor= db.rawQuery("SELECT * FROM "+TBL_NAME, null);
        int count = cursor.getCount();
        cursor.close();
        return  count;
    }
    public  void  createSomeDefaultTasks() {
        int count = getCount();
        Log.i("test", count + "");
        if (count == 0) {
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, "+R.drawable.bf_bepnhaxuquang+",'Bếp nhà xứ Quảng',4.5,16,'16 Trần Cao Vân, P. Đa Kao, Q. 1,n Tp.HCM','Ăn Sáng')");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, "+R.drawable.bf_comquemuoikho+",'Cơm Quê Mười Khó',4.8,35,'27 Trần Quốc Thảo, P. 6, Q. 3, Tp.HCM','Ăn Sáng')");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, "+R.drawable.bf_beardpapa+",'Beard Papa',5.0,28,'72 Lê Thánh Tôn, P. Bến Nghé, Q. 1,Tp.HCM','Ăn Sáng')");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, "+R.drawable.bf_danhdacuadily+",'Bánh Đa Cua Dì Lý',4.3,45,'103 Đồng Khởi, P. Bến Nghé, Q. 1, Tp.HCM','Ăn Sáng')");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, "+R.drawable.lunch_elgaucho+",'EL GauCho',4.5,16,'16 Trần Cao Vân, P. Đa Kao, Q. 1,n Tp.HCM','Ăn Trưa')");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, "+R.drawable.lunch_hotpot+",'HotPot',4.8,35,'27 Trần Quốc Thảo, P. 6, Q. 3, Tp.HCM','Ăn Trưa')");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, "+R.drawable.lunch_kingbbq_alacarte+",'KingBBQ Alacarte',5.0,28,'72 Lê Thánh Tôn, P. Bến Nghé, Q. 1,Tp.HCM','Ăn Trưa')");
            execSql("INSERT INTO " + TBL_NAME + " VALUES(null, "+R.drawable.lunch_kingbbq_buffet+",'KingBBQ Buffet',4.3,45,'103 Đồng Khởi, P. Bến Nghé, Q. 1, Tp.HCM','Ăn Trưa')");

        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TBL_NAME);
        onCreate(sqLiteDatabase);

    }
    public void  queryExec(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase db= getReadableDatabase();
        return db.rawQuery(sql, null);
    }

    public void  execSql(String sql){
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL(sql);
    }

}
