package com.example.myapplicationtuan1.tuan11;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplicationtuan1.R;

public class Tuan11MainActivity extends AppCompatActivity {
    //Khai bao cac control
    EditText txt1,txt2;
    Button btn1;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan11_main);

        txt1=findViewById(R.id.demo11txt1);
        txt2=findViewById(R.id.demo11txt2);
        btn1=findViewById(R.id.demo11Btn1);
        tv1=findViewById(R.id.demo11Tv1);
        //Xu ly su kien
        btn1.setOnClickListener(v->{
            //Goi ham tinh tong
            tinhTong();
        });
    }

    //Dinh nghia ham tinh tong
    private void tinhTong() {

        String str1=txt1.getText().toString();
        float so1=Float.parseFloat(str1);

        String str2=txt2.getText().toString();
        float so2=Float.parseFloat(str2);
        //tinh tong
        float tong= so1 + so2;

        tv1.setText(String.valueOf(tong));
    }
}