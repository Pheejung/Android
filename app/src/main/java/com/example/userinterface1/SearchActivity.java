package com.example.userinterface1;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.userinterface1.Category.headActivity;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.Locale;

public class SearchActivity extends AppCompatActivity {

    ListView listview;
    MyAdapter mMyAdapter;
    EditText search;
    Button button;
    Item medicial;
    Context context;
    ProgressBar progressBar;
    ArrayList<Item> list_item = new ArrayList<>();

    String List_doc_data = new String ("감기 제증상 (콧물, 코막힘, 재채기, 인후통, 오한, 발열, 두통, 관절통, 근육통)의 완화");

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
        setContentView(R.layout.activity_search);

        search = (EditText) findViewById(R.id.search);
        button = (Button) findViewById(R.id.search_button);
        progressBar = (ProgressBar) findViewById(R.id.progressbar);
        context = this;

        listview = (ListView) findViewById(R.id.listview);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(context, Fragment.class);
                i.putExtra("ITEM_NAME", list_item.get(position).getITEM_NAME());
                i.putExtra("VALID_TERM", list_item.get(position).getVALID_TERM());
                i.putExtra("MATERIAL_NAME", list_item.get(position).getMATERIAL_NAME());
                i.putExtra("CHART", list_item.get(position).getCHART());
                i.putExtra("ITEM_SEQ", list_item.get(position).getITEN_SEQ());
                i.putExtra("DOC_DATA", List_doc_data);
                i.putExtra("DOC_NB",List_doc_nb);
                startActivity(i);
            }
        });

        new DataLoadTask().execute();
    }

    private class DataLoadTask extends AsyncTask<Void, Void, ArrayList<Item>> {

        protected ArrayList<Item> doInBackground(Void... voids) {

            try {
                URL url = new URL("http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService/getMdcinPrductItem?" +
                        "ServiceKey=zKEYnBXq1W2zs1lhfybiaweGiVMgLlXm2GxzxrPj9lozlqgIV9965cXb%2FQ%2B6DdHnOb3vrMC9GJ9aX%2FZ6IcYVGw%3D%3D&" +
                        "numOfRows=100&pageNo=1");
                XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
                XmlPullParser parser = parserCreator.newPullParser();

                parser.setInput(url.openStream(), null);

                boolean inITEM_NAME = false, inVALD_TERM = false, inMATERIAL_NAME = false, inSTORAGE_METHOD = false, inCHART = false, inITEM_SEQ = false, inDOC = false;

                int eventType = parser.getEventType();

                while (eventType != XmlPullParser.END_DOCUMENT) {
                    switch (eventType) {

                        case XmlPullParser.START_DOCUMENT:
                            list_item = new ArrayList<Item>();
                            break;
                        case XmlPullParser.END_DOCUMENT:
                            break;
                        case XmlPullParser.END_TAG:
                            if (parser.getName().equals("item") && medicial != null) {
                                list_item.add(medicial);
                            }
                            break;
                        case XmlPullParser.START_TAG:
                            if (parser.getName().equals("item")) {
                                medicial = new Item();
                            }
                            if (parser.getName().equals("ITEM_NAME")) inITEM_NAME = true;
                            if (parser.getName().equals("VALID_TERM")) inVALD_TERM = true;
                            if (parser.getName().equals("MATERIAL_NAME")) inMATERIAL_NAME = true;
                            if (parser.getName().equals("CHART")) inCHART = true;
                            if (parser.getName().equals("ITEM_SEQ")) inITEM_SEQ = true;
                            break;

                        case XmlPullParser.TEXT:
                            if (inITEM_NAME) {
                                medicial.setITEM_NAME(parser.getText());
                                inITEM_NAME = false;
                            }
                            if (inVALD_TERM) {
                                medicial.setVALID_TERM(parser.getText());
                                inVALD_TERM = false;
                            }
                            if (inMATERIAL_NAME) {
                                medicial.setMATERIAL_NAME(parser.getText());
                                inMATERIAL_NAME = false;
                            }
                            if (inCHART) {
                                medicial.setCHART(parser.getText());
                                inCHART = false;
                            }
                            if(inITEM_SEQ) {
                                medicial.setITEN_SEQ(parser.getText());
                                inITEM_SEQ = false;
                            }
                            break;
                    }
                    eventType = parser.next();
                }

                return list_item;

            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(ArrayList<Item> items) {

            super.onPostExecute(items);

            mMyAdapter = new MyAdapter(SearchActivity.this, items);
            listview.setAdapter(mMyAdapter);


            search.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {

                }

                @Override
                public void afterTextChanged(Editable s) {
                    String text = search.getText().toString().toLowerCase(Locale.getDefault());
                    mMyAdapter.filter(text);
                    progressBar.setVisibility(View.INVISIBLE);
                }
            });
        }
    }

}