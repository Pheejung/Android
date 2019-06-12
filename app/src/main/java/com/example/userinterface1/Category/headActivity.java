package com.example.userinterface1.Category;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.userinterface1.Fragment;
import com.example.userinterface1.R;

import java.util.ArrayList;

public class headActivity extends AppCompatActivity {

    Context context;

    //두통, 어지러움, 빈혈, 이명(머리)
    String[] List_name = new String[] {"판피린정", "뇌신", "신풍아스피린정(수출명:ASPIN Tablets)",
            "종근당아스피린정", "안나카주사액10%(제일벤조산나트륨카페인주)(수출용)", "안나카주사액20%(제일벤조산나트륨카페인주)(수출용)",
            "오페라진정", "광동탕", "피엠정액","페니라민주사(클로르페니라민말레산염)","페니라민정(클로르페니라민말레산염)",
            "푸라콩주(피프린히드리네이트)"};
    String[] List_valid = new String[] {"제조일로부터 60 개월","제조일로부터 36 개월", "제조일로부터 24 개월", "제조일로부터 24 개월", "제조일로부터 36개월",
            "제조일로부터 36개월", "제조일로부터 36 개월", "제조일로부터 24 개월","제조일로부터 24 개월", "제조일로부터 24 개월", "제조일로부터 36 개월", "제조일로부터 36 개월" };

    String[] List_material = new String[] {"이 약 1정(650mg 중)|에텐자미드|KP|100|밀리그램;이 약 1정(650mg 중)|아세트아미노펜|KP|200|밀리그램;" +
            "이 약 1정(650mg 중)|클로르페니라민말레산염|KP|2|밀리그램;이 약 1정(650mg 중)|카페인무수물|KP|30|밀리그램",
            "1포 중 650밀리그램|카페인|KP|50|밀리그램;1포 중 650밀리그램|에텐자미드|KP|120|밀리그램;1포 중 650밀리그램|아세트아미노펜|KP|300|밀리그램"
            ,"정 (600밀리그램)중|아스피린|KP|500|밀리그램", "1정 중 320밀리그램|아스피린|KP|250|밀리그램", "1 mL 중|벤조산나트륨카페인|KP|0.1|그램",
            "1 mL 중|벤조산나트륨카페인|KP|0.2|그램",
            "1정(189밀리그람) 중|염산트리플루오페라진|USP|5.9|밀리그램",
            "100밀리리터 중|광동탕연조엑스|별규|7.04|그램;100밀리리터 중|광동탕연조엑스|별규|7.04|그램;100밀리리터 중|광동탕연조엑스|별규|7.04|그램;" +
                    "100밀리리터 중|광동탕연조엑스|별규|7.04|그램;100밀리리터 중|광동탕연조엑스|별규|7.04|그램;100밀리리터 중|광동탕연조엑스|별규|7.04|그램;" +
                    "100밀리리터 중|광동탕연조엑스|별규|7.04|그램;100밀리리터 중|광동탕연조엑스|별규|7.04|그램", "100mL 중|살리실산|KP|10|그램;100mL 중|페놀|KP|0.5|그램;100mL 중|dl-캄파|KP|0.5|그램",
            "이 약 1ml 중,|클로르페니라민말레산염|KP|2|밀리그램", "1정(약 95mg) 중|클로르페니라민말레산염|KP|2.0|밀리그램",
            "이 약 1앰플(2밀리리터) 중|피프린히드리네이트|KP|3|밀리그램"
    };

    String[] List_chart = new String[] {"황동색 정제", "백색의 산제", "백색 무취의 원형정제",
            "본품은 백색의 정제다", "무색~거의 투명한 액이 든 무색 투명한 앰플주사제", "무색~거의 투명한 액이 든 무색 투명한 앰플주사제",
            "엷은 연두색 원형당의정","특이한 생약취를 가진 흑갈색의 액체로서 약간 혼탁하다", "연한 적색의 방향을 가진 휘발성 액체",
            "무색 투명한 액이 충전된 앰플", "미황색의 원형 정제", "무색투명한 약이 무색투명한 앰플에 든 주사제"};

    String[] List_item = new String[] {"195600001", "195700028", "196200002", "195500004", "195700016", "195700015","196700045", "196400080", "195700033", "196000010", "196000011", "196300044"};

    String[] List_doc_data = new String[] {};

    String[] List_doc_nb = new String[] {};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head);
        context = this;

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List_name);
        final ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(context, Fragment.class);
                i.putExtra("ITEM_NAME", List_name[position]);
                i.putExtra("VALID_TERM", List_valid[position]);
                i.putExtra("MATERIAL_NAME", List_material[position]);
                i.putExtra("CHART", List_chart[position]);
                i.putExtra("ITEM_SEQ", List_item[position]);

                startActivity(i);
            }
        });

    }
}
