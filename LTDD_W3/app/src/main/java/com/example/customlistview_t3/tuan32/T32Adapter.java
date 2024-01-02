package com.example.customlistview_t3.tuan32;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.customlistview_t3.R;

import java.util.ArrayList;

public class T32Adapter extends BaseAdapter {
    private ArrayList<T32Contact> ls;
    private Context context;

    public T32Adapter(ArrayList<T32Contact> ls, Context context) {
        this.ls = ls;
        this.context = context;
    }

    // lay ve so luong item
    @Override
    public int getCount() {
        return ls.size();
    }

    //lay ve item
    @Override
    public Object getItem(int position) {
        return ls.get(position);
    }

    //lay ve id
    @Override
    public long getItemId(int position) {
        return position;
    }
    //Tao view
    //Gan du lieu
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //b1-tao view
        ViewAX vax;
        //neu chua co view thi ta tao view moi
        if(convertView==null){
            vax=new ViewAX();//tao view moi
            //anh xa lay out
            convertView= LayoutInflater.from(context).inflate(R.layout.tuan32_listview_item,null);
            //anh xa tung thanh phan trong layout
            vax.img_hinh=convertView.findViewById(R.id.t32ItemHinh);
            vax.tv_ten=convertView.findViewById(R.id.t32ItemTen);
            vax.tv_tuoi=convertView.findViewById(R.id.t32ItemTuoi);
            //tao template de lan sau su dung
            convertView.setTag(vax);
        }
        //neu da co view -> su dung lai view cu
        else{
            vax=(ViewAX) convertView.getTag();//lay view cu
        }
        //gan du lieu cho layout
        vax.img_hinh.setImageResource(ls.get(position).getHinh());
        vax.tv_ten.setText(ls.get(position).getTen());
        vax.tv_tuoi.setText(ls.get(position).getTuoi());
        return convertView;
    }

    //dinh nghia view
    class ViewAX{
        ImageView img_hinh;
        TextView tv_ten,tv_tuoi;
    }

}
