package com.example.api_t4.tuan42

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.api_t4.R

class Tuan42MainActivity : AppCompatActivity() {
    var btn:Button? =null
    var tvKQ: TextView?=null
    var context:Context=this;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan42_main)
        btn=findViewById(R.id.tuan42Btn)
        tvKQ=findViewById(R.id.tuan42TvKQ)
        val fn=VolleyKotlinFn()
        btn!!.setOnClickListener {
            fn.getJSONArrayObjects(context,tvKQ!!);
        }
    }
}