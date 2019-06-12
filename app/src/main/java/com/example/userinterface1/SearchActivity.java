package com.example.userinterface1;

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
                i.putExtra("STORAGE_METHOD", list_item.get(position).getSTORAGE_METHOD());
                i.putExtra("CHART", list_item.get(position).getCHART());
                i.putExtra("ITEM_SEQ", list_item.get(position).getITEN_SEQ());
                startActivity(i);
            }
        });



        new DataLoadTask().execute();
    }

    private class DataLoadTask extends AsyncTask<Void, Void, ArrayList<Item>> {

        @Override
        protected ArrayList<Item> doInBackground(Void... voids) {

            progressBar.setVisibility(View.VISIBLE);



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
                            if (parser.getName().equals("STORAGE_METHOD")) inSTORAGE_METHOD = true;
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
                            if (inSTORAGE_METHOD) {
                                medicial.setSTORAGE_METHOD(parser.getText());
                                inSTORAGE_METHOD = false;
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