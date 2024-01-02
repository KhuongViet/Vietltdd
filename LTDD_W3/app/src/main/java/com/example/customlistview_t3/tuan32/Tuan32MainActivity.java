package com.example.customlistview_t3.tuan32;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.customlistview_t3.R;

import java.util.ArrayList;

public class Tuan32MainActivity extends AppCompatActivity {
    ListView lv;
    T32Adapter adapter;
    ArrayList<T32Contact> ls=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan32_main);
        lv=findViewById(R.id.tuan32Lv);
        //tao nguon du lieu
        ls.add(new T32Contact("Nguyen Van A","18",R.drawable.kimtaehee));
        ls.add(new T32Contact("Khuong Van V","19",R.drawable.hancock));
        ls.add(new T32Contact("Nguyen Dinh E","22",R.drawable.shank));
        ls.add(new T32Contact("Nguyen Thi H","25",R.drawable.kimheesun));
        ls.add(new T32Contact("Nguyen Viet H","16",R.drawable.kimnamjoo));
        ls.add(new T32Contact("Dinh Van H","7",R.drawable.kimsoeun));

        //tao adapter
        adapter=new T32Adapter(ls,this);
        lv.setAdapter(adapter);
    }
}