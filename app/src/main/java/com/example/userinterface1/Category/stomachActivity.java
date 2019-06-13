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

public class stomachActivity extends AppCompatActivity {

    Context context;

    //위산과다, 속쓰림, 구토, 식욕감퇴, 소화불량, 변비(위장)
    String[] List_name = new String[] {"핫도리과립", "베스타제당의정", "베스타제정", "씨제이후라시닐정", "보화소합원", "대원황산아트로핀주사액",
            "게루삼정", "삼영단환", "온보왕", "스므스삼중정", "옥시톤주사액5(아이유)옥시토신", "신풍아스피린정", "아네모정"};

    String[] List_material = new String[] {"1포(2.3g)중|탄산수소나트륨|KP|650|밀리그램;1포(2.3g)중|침강탄산칼슘|KP|200|밀리그램;" +
            "1포(2.3g)중|탄산마그네슘|KP|120|밀리그램;1포(2.3g)중|대황가루|생규|100|밀리그램;1포(2.3g)중|감초가루|생규|50|밀리그램;1포(2.3g)중|육계가루|생규|150|밀리그램;1포(2.3g)중|사인가루|생규|400|밀리그램",
            "이 약 1정(495mg) 중|비오디아스타제500|별첨규격(전과동)|75|밀리그램;이 약 1정(495mg) 중|리파제AP6|별첨규격(전과동)|2.8|밀리그램;이 약 1정(495mg) 중|셀룰라제AP3|별첨규격(전과동)|25|밀리그램",
            "이 약 1정(500 mg) 중|비오디아스타제500|별첨규격(전과동)|75|밀리그램;이 약 1정(500 mg) 중|리파제AP6|별첨규격(전과동)|2.8|밀리그램;이 약 1정(500 mg) 중|셀룰라제AP3|별첨규격(전과동)|25|밀리그램",
            "1정(400mg) 중|메트로니다졸|KP|250|밀리그램", "", "이 약 1밀리리터 중|아트로핀황산염수화물|USP|0.5|밀리그램",
            "1정(430mg) 중|건조수산화알루미늄 겔|KP|200.0|밀리그램;1정(430mg) 중|침강탄산칼슘|KP|100.0|밀리그램;1정(430mg) 중|탄산마그네슘|KP|50.0|밀리그램;1정(430mg) 중|탄산수소나트륨|KP|50.0|밀리그램",
            "1포(1.2g, 20환) 중|창출|KP|334|밀리그램;1포(1.2g, 20환) 중|감초|KP|33.4|밀리그램;1포(1.2g, 20환) 중|향부자|KP|334|밀리그램;1포(1.2g, 20환) 중|견우자|KP|183.2|밀리그램;" +
                    "1포(1.2g, 20환) 중|오령지|생규|110|밀리그램;1포(1.2g, 20환) 중|고백반|별첨규격(전과동)|33.4|밀리그램",
            "1포(2.0 그램) 중|인삼|KP|260|밀리그램;1포(2.0 그램) 중|곽향|생규|260|밀리그램;1포(2.0 그램) 중|지실|KP|260|밀리그램;1포(2.0 그램) 중|목향|KP|260|밀리그램;1포(2.0 그램) 중|산사|KP|260|밀리그램;" +
                    "1포(2.0 그램) 중|건강|KP|260|밀리그램;1포(2.0 그램) 중|향부자|KP|260|밀리그램;1포(2.0 그램) 중|육계|KP|260|밀리그램;1포(2.0 그램)중|사인|KP|260|밀리그램;1포(2.0 그램) 중|백출|KP|260|밀리그램;1포(2.0 그램) 중|정향|KP|260|밀리그램;1포(2.0 그램) 중|박하|KP|260|밀리그램;1포(2.0 그램) 중|후추|KP|124|밀리그램;1포(2.0 그램) 중|필발|생규|85|밀리그램;1포(2.0 그램) 중|보두|생규|85|밀리그램;1포(2.0 그램) 중|용뇌|생규|20|밀리그램",
            "1,3층|침강탄산칼슘|KP|160|밀리그램;1,3층|탄산수소나트륨|KP|68|밀리그램;2층|포리아제|별규|40|밀리그램;2층|디아스타제|KP|26.4|밀리그램;2층|스코폴리아엑스산|KP|2.64|밀리그램;" +
                    "2층|감초(조)엑스|KP|10.4|밀리그램;2층|계피유(신나몬유)|KP|0.32|밀리그램;2층|회향유|KP|0.32|밀리그램;2층|정향유|KP|0.32|밀리그램;2층|등피유|별규|0.4|밀리그램;2층|건강틴크|별규|0.48|밀리그램;2층|디엘멘톨|KP|1.04|밀리그램;2층|데히드로콜린산|KP|1.36|밀리그램",
            "1앰플(1mL) 중,|옥시토신|USP|5|아이.유", "1정 (600밀리그램)중|아스피린|KP|500|밀리그램",
            "1정(463.9밀리그램) 중|건조수산화알루미늄겔|KP|90|밀리그램;1정(463.9밀리그램) 중|탄산수소나트륨|KP|90|밀리그램;1정(463.9밀리그램) 중|침강탄산칼슘|KP|40|밀리그램;" +
                    "1정(463.9밀리그램) 중|탄산마그네슘|KP|25|밀리그램;1정(463.9밀리그램) 중|스코폴리아엑스10배산|KP|37.5|밀리그램"};

    String[] List_valid = new String[] {"제조일로부터 36 개월", "제조일로부터 36 개월", "제조일로부터 36 개월", "제조일로부터 60개월", "제조일로부터 24 개월", "제조일로부터 36 개월",
            "제조일로부터 36개월", "제조일로부터 36 개월", "제조일로부터 36 개월",
            ".", "제조일로부터 36 개월", "제조일로부터 24 개월", "제조일로부터 36 개월"};


    String[] List_chart = new String[] {"분홍색과 갈색의 혼합과립", "분홍색의 원형 당의정이다", "담등-적갈색 정제", "백색의 원형정제이다", "적흑색의 유연성의 환상",
            "무색 투명한 액이 충전된 갈색 앰플제로 불쾌한 자극성의 쓴 맛이 있다. 수출용 : 무색 투명한 액이 충전된 앰플제로 불쾌한 자극성의 쓴 맛이 있다",
            "백색의 원형정제", "흑갈색 환제", "담갈색의 과립제이며, 맛은 청량감이 있고 독특한 생약 냄새가 난다", "상하층백색 중간층은 담갈색의 삼중정",
            "무색투명한 액이 무색투명한 앰플에 든 주사제", "백색 무취의 원형정제","백색의 원형필름제피정"};

    String[] List_item = new String[] {"196600085", "196600012", "196600011", "196500004", "196400089", "196400054", "196400046", "196300078", "196300057", "196300011", "196300025", "196200002", "195900043"};

    String List_doc_data = new String ("위산과다, 속쓰림, 위부불쾌감, 위부팽만감, 체함, 구역, 구토, 위통, 신트림, 식욕감퇴(식욕부진), 소화불량, 과식");

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
        setContentView(R.layout.activity_stomach);

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
