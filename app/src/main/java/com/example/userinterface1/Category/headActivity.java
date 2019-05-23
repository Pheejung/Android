package com.example.userinterface1.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userinterface1.R;

public class headActivity extends AppCompatActivity {

    static final String[] List_MENU = {"판피린정", "뇌신", "솔감탕", "보음보양노소신기강장약흥양자춘원", "신풍아스피린정(수출명:ASPIN Tablets)",
            "종근당아스피린정", "안나카주사액10%(제일벤조산나트륨카페인주)(수출용)", "안나카주사액20%(제일벤조산나트륨카페인주)(수출용)",
            "솔표우황청심원", "오페라진정", "솔표쌍금탕", "광동탕"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List_MENU);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
