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

public class Blank2 extends Fragment {
    public Blank2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.detail_item2, container, false);

        Intent i = getActivity().getIntent();
        TextView tv_hyo = (TextView) view.findViewById(R.id.tv_hyo);
        tv_hyo.setText(i.getStringExtra("MATERIAL_NAME"));

        return view;
    }
}
