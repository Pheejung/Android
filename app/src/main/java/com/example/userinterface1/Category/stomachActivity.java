package com.example.userinterface1.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userinterface1.R;

public class stomachActivity extends AppCompatActivity {

    static final String[] List_MENU = {"핫도리과립", "통쾌한", "베스타제당의정", "베스타제정", "씨제이후라시닐정", "보화소합원", "대원황산아트로핀주사액",
            "게루삼정", "삼영단환", "온보왕", "스므스삼중정", "옥시톤주사액5(아이유)옥시토신", "신풍아스피린정", "아네모정", ""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stomach);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List_MENU);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
