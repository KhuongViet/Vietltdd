package com.example.app_tuan2.tuan22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.app_tuan2.R

class Tuan222MainActivity : AppCompatActivity() {
    var lv:ListView?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tuan222_main)
        lv=findViewById(R.id.tuan222Lv)
        val arr = arrayOf("item 1","item 2","item 3","item 4","item 5","item 6","item 7","item 8")
        val adt=ArrayAdapter(this,android.R.layout.simple_list_item_1,arr)
        lv!!.adapter=adt
    }
}