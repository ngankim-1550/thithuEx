package com.example.thithuex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.adapter.ServiceAdapter;
import com.example.model.Service;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imvAnSang, imvAnTrua, imvAnChieu, imvAnToi;
    RecyclerView rcvService;

    ArrayList<Service> services;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        initData();

        configRecyclerView();
        addEvent();

    }

    private void addEvent() {
        imvAnSang.setOnClickListener(myClick);
        imvAnTrua.setOnClickListener(myClick);
    }


    private void linkViews() {
        rcvService=findViewById(R.id.rcvService);
        imvAnSang=findViewById(R.id.imvAnSang);
        imvAnTrua=findViewById(R.id.imvAnTrua);
        imvAnChieu=findViewById(R.id.imvAnChieu);
        imvAnToi=findViewById(R.id.imvAnToi);

    }
    private void configRecyclerView() {
        LinearLayoutManager manager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rcvService);
        // set a GridLayoutManager with 3 number of columns , horizontal gravity and false value for reverseLayout to show the items from start to end
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2, LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        //  call the constructor of CustomAdapter to send the reference and data to Adapter
        ServiceAdapter customAdapter = new ServiceAdapter(MainActivity.this,services);
        recyclerView.setAdapter(customAdapter); // set the Adapter to RecyclerView
    }
    private void initData() {
        services= new ArrayList<>();
        services.add(new Service("Cà phê",R.drawable.ca_phe));
        services.add(new Service("Sinh tố",R.drawable.sinh_to));
        services.add(new Service("Trà sữa",R.drawable.tra_sua));
        services.add(new Service("Bánh ngọt",R.drawable.banh_ngot));
        services.add(new Service("Ẩm thực Việt",R.drawable.am_thuc_viet));
        services.add(new Service("Spa",R.drawable.spa));
        services.add(new Service("Thời trang nữ",R.drawable.thoi_trang_nu));
        services.add(new Service("Thời trang nam",R.drawable.thoi_trang_nam));
        services.add(new Service("Phụ kiện",R.drawable.phu_kien));
        services.add(new Service("Mẹ và bé",R.drawable.me_va_be));

    }
    View.OnClickListener myClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.imvAnSang) {
                Intent intent = new Intent(MainActivity.this, MealActivity.class);
                intent.putExtra("Meal", "Breakfast");

                //startActivity(intent);
                startActivity(intent);
            } else if (v.getId() == R.id.imvAnTrua) {
                Intent intent = new Intent(MainActivity.this, MealActivity.class);
                intent.putExtra("Meal", "Lunch");

                //startActivity(intent);
                startActivity(intent);
            }
        }


    };

}