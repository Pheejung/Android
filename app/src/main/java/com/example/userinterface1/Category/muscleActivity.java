package com.example.userinterface1.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userinterface1.R;

public class muscleActivity extends AppCompatActivity {
    //무좀, 피부질환, 두드러기, 가려움증
    static final String[] List_MENU = {"피엠정액","페니라민주사(클로르페니라민말레산염)","페니라민정(클로르페니라민말레산염)",
            "푸라콩주(피프린히드리네이트)","덱사소론정0.75밀리그람(덱사메타손)","덱사코티실정(덱사메타손)","부광덱사메타손정"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List_MENU);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
