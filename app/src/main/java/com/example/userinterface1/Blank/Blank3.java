package com.example.userinterface1.Blank;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.userinterface1.R;


public class Blank3 extends Fragment {
    public Blank3() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_item3, container, false);

        Intent i = getActivity().getIntent();
        TextView tv_ju = (TextView) view.findViewById(R.id.tv_ju);
        tv_ju.setText(i.getStringExtra("MATERIAL_NAME"));

        return view;
    }
}