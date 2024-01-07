package com.example.api_t4.tuan41;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.api_t4.R;

public class Tuan41MainActivity extends AppCompatActivity {
    Button btnGetData;
    TextView tvKQ;
    Context context=this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tuan41_main);
        Tuan41VolleyFn volleyFn=new Tuan41VolleyFn();
        tvKQ=findViewById(R.id.tuan41TvKQ);
        btnGetData=findViewById(R.id.tuan41Btn);
        btnGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                volleyFn.getJSONArrayOfObject(context,tvKQ);
            }
        });
    }
}