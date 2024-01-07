package com.example.api_t4.tuan42

import android.content.Context
import android.widget.TextView
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley

class VolleyKotlinFn {
    var strJSON="";
    fun getJSONArrayObjects(context: Context,textview:TextView){
        //1.Tao request
        val queue=Volley.newRequestQueue(context)
        val url="https://batdongsanabc.000webhostapp.com/thanglong/array_json_new.json?fbclid=IwAR23RBipF8KTcJqRO1fcXfH1UpWJkz-SE8QYQITaZSg8gz0Yx25fa5BHCVI"

        //2.Url
        //3.goi request(mang cua cac doi tuong)
        val request=JsonArrayRequest(url,
            Response.Listener {
                response ->
                              for(i in 0 until response.length()){
                                  val person=response.getJSONObject(i)
                                  val id=person.getString("id")
                                  val name=person.getString("name")
                                  val email=person.getString("email")
                                  strJSON+="id: $id\n"
                                  strJSON+="name: $name\n"
                                  strJSON+="email: $email\n"
                              }
                textview.text=strJSON
            },
            Response.ErrorListener {
                error ->  textview.text= error.message
            })
        //4.Goi request
        queue.add(request)

    }
}