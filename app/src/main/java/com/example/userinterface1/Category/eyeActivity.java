package com.example.userinterface1.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userinterface1.R;

public class eyeActivity extends AppCompatActivity {

    static final String[] List_MENU = {};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eye);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List_MENU);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
