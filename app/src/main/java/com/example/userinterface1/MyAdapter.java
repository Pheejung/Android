package com.example.userinterface1;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

public class MyAdapter extends BaseAdapter {

    Context context;
    ArrayList<Item> list_item;
    TextView ITEM_NAME;
    ArrayList<Item> arrayList;

    public MyAdapter (Context context, ArrayList<Item> list_item) {
        this.context = context;
        this.list_item = list_item;
        this.arrayList = new ArrayList<Item>();
        this.arrayList.addAll(list_item);
    }


    @Override
    public int getCount() {
        return list_item.size();
    }

    @Override
    public Object getItem(int position) {
        return list_item.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if(convertView==null) {
        convertView = LayoutInflater.from(context).inflate(R.layout.item,null);

        ITEM_NAME = (TextView) convertView.findViewById(R.id.ITEM_NAME);
//        }

        ITEM_NAME.setText(list_item.get(position).getITEM_NAME());

        return convertView;
    }

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        list_item.clear();

        if(charText.length() == 0) {
            list_item.addAll(arrayList);
        } else {
            for (Item item:arrayList) {
                String name = item.ITEM_NAME;
                if(name.toLowerCase().contains(charText)) {
                    list_item.add(item);
                }
            }
        }
        notifyDataSetChanged();
    }
}