package com.example.userinterface1.Blank;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.userinterface1.R;

import org.w3c.dom.Text;


public class Blank1 extends Fragment {
    public Blank1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.detail_item, container, false);
        Intent i = getActivity().getIntent();

        TextView tv_info = (TextView) view.findViewById(R.id.tv_info);
        tv_info.setText(i.getStringExtra("MATERIAL_NAME"));

        TextView tv_storage = (TextView) view.findViewById(R.id.tv_storage);
        tv_storage.setText(i.getStringExtra("STORAGE_METHOD"));

        TextView tv_color = (TextView) view.findViewById(R.id.tv_color);
        tv_color.setText(i.getStringExtra("CHART"));

        TextView tv_barcode = (TextView) view.findViewById(R.id.tv_barcode);
        tv_barcode.setText(i.getStringExtra("ITEM_SEQ"));

        return view;



    }
}
