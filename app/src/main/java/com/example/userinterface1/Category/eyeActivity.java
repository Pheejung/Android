package com.example.userinterface1.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userinterface1.R;

public class eyeActivity extends AppCompatActivity {
    //고칼륨혈증, 심진환, 저혈당, 고혈압, 심질환
    static final String[] List_MENU = {"디크로다이드정(히드로클로로티아지드)","디고신정(디곡신)","아주디곡신주사액",
            "라식스주사(푸로세미드)","중외10%포도당주사액"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List_MENU);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
