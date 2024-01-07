package com.example.api_t4.tuan41;

import android.content.Context;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Tuan41VolleyFn {
    String strJSON="";
    public void getJSONArrayOfObject(Context context, TextView textView){
        //1.Tao request
        RequestQueue queue= Volley.newRequestQueue(context);
        //2.Url
        String url="https://batdongsanabc.000webhostapp.com/thanglong/array_json_new.json?fbclid=IwAR23RBipF8KTcJqRO1fcXfH1UpWJkz-SE8QYQITaZSg8gz0Yx25fa5BHCVI";
        //3.Goi request
        //JsonArrayRequest(url,thanhcong,thatbai)
        JsonArrayRequest request = new JsonArrayRequest(url,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        //chuyen mang sang cac doi tuong
                        for (int i=0;i<response.length();i++){
                            try {
                                JSONObject person=response.getJSONObject(i); // lay tung doi tuong
                                String id=person.getString("id");
                                String name=person.getString("name");
                                String email= person.getString("email");
                                //
                                strJSON+="id: "+id+"\n";
                                strJSON+="name: "+name+"\n";
                                strJSON+="email: "+email+"\n";
                            } catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                            textView.setText(strJSON);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(error.getMessage());
            }
        });
        //4. Thuc thi request
        queue.add(request);
    }
}
