package com.example.userinterface1.Category;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userinterface1.R;

public class muscleActivity extends AppCompatActivity {
    //무좀, 피부질환, 두드러기, 가려움증(1번째줄~)
    //위산과다, 속쓰림, 구토, 식욕감퇴, 소화불량, 변비(위장) (3번째줄~)
    static final String[] List_MENU = {"피엠정액","페니라민주사(클로르페니라민말레산염)","페니라민정(클로르페니라민말레산염)",
            "푸라콩주(피프린히드리네이트)","덱사소론정0.75밀리그람(덱사메타손)","덱사코티실정(덱사메타손)","부광덱사메타손정",
            "핫도리과립", "통쾌한", "베스타제당의정", "베스타제정", "씨제이후라시닐정", "보화소합원", "대원황산아트로핀주사액",
            "게루삼정", "삼영단환", "온보왕", "스므스삼중정", "옥시톤주사액5(아이유)옥시토신", "신풍아스피린정", "아네모정"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List_MENU);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);
    }
}
