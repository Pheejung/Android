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

public class muscleActivity extends AppCompatActivity {

    Context context;
    //무좀, 피부질환, 두드러기, 가려움증(1번째줄~)
    //위산과다, 속쓰림, 구토, 식욕감퇴, 소화불량, 변비(위장) (3번째줄~)

    String[] List_name = new String[] {"피엠정액","페니라민주사(클로르페니라민말레산염)","페니라민정(클로르페니라민말레산염)",
            "푸라콩주(피프린히드리네이트)","덱사소론정0.75밀리그람(덱사메타손)","덱사코티실정(덱사메타손)","부광덱사메타손정",
            "온보왕", "스므스삼중정", "옥시톤주사액5(아이유)옥시토신", "신풍아스피린정", "아네모정"};

    String[] List_valid  = new String[]
            {"제조일로부터 24 개월", "제조일로부터 24 개월", "제조일로부터 36 개월", "제조일로부터 36 개월", "제조일로부터 36 개월",
                    "제조일로부터 60 개월", "제조일로부터 60 개월",  "제조일로부터 36 개월", "제조일로부터 36 개월",
                    ".", "제조일로부터 36 개월", "제조일로부터 24 개월", "제조일로부터 36 개월"};

    String[] List_material = new String[] {"100mL 중|살리실산|KP|10|그램;100mL 중|페놀|KP|0.5|그램;100mL 중|dl-캄파|KP|0.5|그램", "이 약 1ml 중,|클로르페니라민말레산염|KP|2|밀리그램",
            "1정(약 95mg) 중|클로르페니라민말레산염|KP|2.0|밀리그램", "이 약 1앰플(2밀리리터) 중|피프린히드리네이트|KP|3|밀리그램", "이 약 1정(140mg)중|덱사메타손|KP|0.75|밀리그램" ,
            "1정 중 196밀리그램|덱사메타손|KP|0.75|밀리그램", "이 약 1정9180밀리그램) 중|덱사메타손|KP|0.75|밀리그램",
            "1포(1.2g, 20환) 중|창출|KP|334|밀리그램;1포(1.2g, 20환) 중|감초|KP|33.4|밀리그램;1포(1.2g, 20환) 중|향부자|KP|334|밀리그램;1포(1.2g, 20환) 중|견우자|KP|183.2|밀리그램;" +
                    "1포(1.2g, 20환) 중|오령지|생규|110|밀리그램;1포(1.2g, 20환) 중|고백반|별첨규격(전과동)|33.4|밀리그램",
            "1포(2.0 그램) 중|인삼|KP|260|밀리그램;1포(2.0 그램) 중|곽향|생규|260|밀리그램;1포(2.0 그램) 중|지실|KP|260|밀리그램;1포(2.0 그램) 중|목향|KP|260|밀리그램;1포(2.0 그램) 중|산사|KP|260|밀리그램;" +
                    "1포(2.0 그램) 중|건강|KP|260|밀리그램;1포(2.0 그램) 중|향부자|KP|260|밀리그램;1포(2.0 그램) 중|육계|KP|260|밀리그램;1포(2.0 그램)중|사인|KP|260|밀리그램;1포(2.0 그램) 중|백출|KP|260|밀리그램;1포(2.0 그램) 중|정향|KP|260|밀리그램;1포(2.0 그램) 중|박하|KP|260|밀리그램;1포(2.0 그램) 중|후추|KP|124|밀리그램;1포(2.0 그램) 중|필발|생규|85|밀리그램;1포(2.0 그램) 중|보두|생규|85|밀리그램;1포(2.0 그램) 중|용뇌|생규|20|밀리그램",
            "1,3층|침강탄산칼슘|KP|160|밀리그램;1,3층|탄산수소나트륨|KP|68|밀리그램;2층|포리아제|별규|40|밀리그램;2층|디아스타제|KP|26.4|밀리그램;2층|스코폴리아엑스산|KP|2.64|밀리그램;" +
                    "2층|감초(조)엑스|KP|10.4|밀리그램;2층|계피유(신나몬유)|KP|0.32|밀리그램;2층|회향유|KP|0.32|밀리그램;2층|정향유|KP|0.32|밀리그램;2층|등피유|별규|0.4|밀리그램;2층|건강틴크|별규|0.48|밀리그램;2층|디엘멘톨|KP|1.04|밀리그램;2층|데히드로콜린산|KP|1.36|밀리그램",
            "1앰플(1mL) 중,|옥시토신|USP|5|아이.유", "1정 (600밀리그램)중|아스피린|KP|500|밀리그램",
            "1정(463.9밀리그램) 중|건조수산화알루미늄겔|KP|90|밀리그램;1정(463.9밀리그램) 중|탄산수소나트륨|KP|90|밀리그램;1정(463.9밀리그램) 중|침강탄산칼슘|KP|40|밀리그램;" +
                    "1정(463.9밀리그램) 중|탄산마그네슘|KP|25|밀리그램;1정(463.9밀리그램) 중|스코폴리아엑스10배산|KP|37.5|밀리그램"};

    String[] List_chart = new String[] {"연한 적색의 방향을 가진 휘발성 액체", "무색 투명한 액이 충전된 앰플", "미황색의 원형 정제", "무색투명한 약이 무색투명한 앰플에 든 주사제", "황색의 원형정제", "백색정제",
            "백색의 정제", "담갈색의 과립제이며, 맛은 청량감이 있고 독특한 생약 냄새가 난다", "상하층백색 중간층은 담갈색의 삼중정",
            "무색투명한 액이 무색투명한 앰플에 든 주사제", "백색 무취의 원형정제","백색의 원형필름제피정"};

    String[] List_item = new String[] {"195700033", "196000010", "196000011", "196300044", "196000003", "196300043", "196300064", "196300057", "196300011", "196300025", "196200002", "195900043"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muscle);

        context = this;

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, List_name);
        ListView listView = (ListView) findViewById(R.id.list);
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
