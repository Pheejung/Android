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

public class neckActivity extends AppCompatActivity {

    Context context;

    //코감기 위주
    String[] List_name = new String[] {"판피린정", "뇌신", "종근당염산에페드린정", "자모", "테라싸이클린캡슐250밀리그람(염산테트라싸이클린)",
            "용각산", "푸라콩정", "푸라콩주", "대원아미노필린주사액(아미노필린수화물)", "대원염산에페드린주사액(수출명:에린주사(에페드린염산염))",
            "페니라민주사", "아세아메티마졸정","제일에페드린염산염주사액4%"};

    String[] List_valid  = new String[] {"제조일로부터 60 개월","제조일로부터 36 개월","제조일로부터 36 개월", "제조일로부터 36 개월",
            "제조일로부터 24 개월", "(내수용) 제조일로부터 60개월, (수출용) 제조일로부터 72개월",
            "제조일로부터 60 개월", "제조일로부터 36 개월", "제조일로부터 36 개월", "제조일로부터 36 개월", "제조일로부터 24 개월",
            "제조일로부터 개월", "제조일로부터 36개월"};

    String[] List_material = new String[] {"이 약 1정(650mg 중)|에텐자미드|KP|100|밀리그램;이 약 1정(650mg 중)|아세트아미노펜|KP|200|밀리그램;이 약 1정(650mg 중)|클로르페니라민말레산염|KP|2|밀리그램;" +
            "이 약 1정(650mg 중)|카페인무수물|KP|30|밀리그램"
            ,"1포 중 650밀리그램|카페인|KP|50|밀리그램;1포 중 650밀리그램|에텐자미드|KP|120|밀리그램;1포 중 650밀리그램|아세트아미노펜|KP|300|밀리그램",
            "1정 중 80밀리그램|염산에페드린|KP|25|밀리그램",
            "1회량(10그램) 중|마황|KP|0.67|그램;1회량(10그램) 중|인삼|KP|0.2|그램;1회량(10그램) 중|원지|KP|0.17|그램;1회량(10그램) 중|길경|KP|0.3|그램;1회량(10그램) 중|구아이페네신|KP|0.07|그램",
            "1캡슐 중 280밀리그램|테트라사이클린염산염|KP|250|밀리그램", "1회 (0.3g)중|길경가루|생규|11.7|밀리그램;1회 (0.3g)중|세네가가루|생규|0.5|밀리그램;1회 (0.3g)중|행인|KP|0.83|밀리그램;" +
            "1회 (0.3g)중|감초가루|생규|8.3|밀리그램;1회 (0.3g)중|길경행인가루|별첨규격(전과동)|12.5|밀리그램;1회 (0.3g)중|세네가가루|JP|0.5|밀리그램;1회 (0.3g)중|감초가루|JP|8.3|밀리그램",
            "1정(100밀리그램)중|피프린히드리네이트||3|밀리그램", "이 약 1앰플(2밀리리터) 중|피프린히드리네이트|KP|3|밀리그램",
            "1밀리리터 중|아미노필린수화물|USP|25|밀리그램", "1밀리리터 중|에페드린염산염|KP|40|밀리그램", "이 약 1ml 중,|클로르페니라민말레산염|KP|2|밀리그램",
            "1정중100밀리그람|메티마졸|USP|5|밀리그램", "1 mL 중|에페드린염산염|KP|40|밀리그램"};

    String[] List_chart = new String[] {"황동색 정제", "백색의 산제" ,"본품은 백색의 정제다", "적갈색의 감미가 있는 연조엑스제이다",
            "황색의 결정 또는 결정성 가루가 들어 있는 상부는 갈색, 하부는 담회색의 캅셀이다","백색의 미세한 가루로서 특유의 방향과 맛이 있다", "분홍색의 정제임",
            "무색투명한 약이 무색투명한 앰플에 든 주사제", "무색의 맑은 액으로 맛은 약간 쓰다", "무색투명한 액이 든 갈색앰플제 수출용 : 무색투명한 액이 든 앰플제",
            "무색 투명한 액이 충전된 앰플", "백색의 정제", "무색 투명한 액이 든 갈색 투명한 앰플주사제"};

    String[] List_item = new String[] {"1956000001", "195700028", "195500002", "195900045", "196000001", "196600062", "196200043", "196300044", "195800019", "195800018", "196000010", "196400056", "195700013"};

    String List_doc_data = new String ("1. 다음 질환에서의 기침 : 기관지천식, 감기, 급•만성기관지염, 상기도염\n" + "2. 비점막의 충혈·종창");

    String List_doc_nb = new String ("(1) 경고 \n" +
            "매일 세잔 이상 정기적으로 술을 마시는 사람이 이 약이나 다른 해열진통제를 복용해야 할 경우 반드시 의사 또는 약사와 상의해야한다. 이러한 사람이 이 약을 복용하면 간 손상이 유발될 수 있다.\n" +
            "(2) 다음 환자에는 신중히 투여할 것\n" +
            "이 약은 황색 4호(타르트라진)를 함유하고 있으므로 이 성분에 과민하거나 알레르기 병력이 있는 환자에는 신중히 투여한다\n" +
            "(3) 이 약을 복용하는 동안 다음의 약을 복용하지 말 것\n" +
            "진해거담제, 다른 감기약, 해열진통제, 진정제, 항히스타민제를 함유하는 내복약(비염용 경구제, 멀미약, 알레르기용약)\n" +
            "(4) 저장상의 주의사항\n" +
            "1) 어린이의 손에 닿지 않는 장소에 보관할 것\n" +
            "2) 직사광선을 피하고 될 수 있는 한 습기가 적은 서늘한 곳에 보관할 것\n" +
            "3) 오용을 막고 품질의 보존을 위하여 다른 용기에 바꾸어 넣지 말 것\n" );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_neck);

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
                i.putExtra("DOC_DATA",List_doc_data);
                i.putExtra("DOC_NB",List_doc_nb);

                startActivity(i);
            }
        });
    }
}
