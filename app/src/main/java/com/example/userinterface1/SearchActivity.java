package com.example.userinterface1;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;

public class SearchActivity extends AppCompatActivity {

    private EditText search;
    private Button button;
    private TextView searchtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        search = (EditText) findViewById(R.id.search);
        button = (Button) findViewById(R.id.button);
        searchtext = (TextView) findViewById(R.id.searchtext);

        StrictMode.enableDefaults();

        boolean initem = false, inITEM_NAME = false;

        String ITEM_NAME = null;

        try {
            URL url = new URL("http://apis.data.go.kr/1471057/MdcinPrductPrmisnInfoService/getMdcinPrductItem?" +
                    "ServiceKey=zKEYnBXq1W2zs1lhfybiaweGiVMgLlXm2GxzxrPj9lozlqgIV9965cXb%2FQ%2B6DdHnOb3vrMC9GJ9aX%2FZ6IcYVGw%3D%3D&" +
                    "numOfRows=100&pageNo=1");
            XmlPullParserFactory parserCreator = XmlPullParserFactory.newInstance();
            XmlPullParser parser = parserCreator.newPullParser();

            parser.setInput(url.openStream(), null);

            int parserEvent = parser.getEventType();
            System.out.println("파싱 시작합니다");

            while (parserEvent != XmlPullParser.END_DOCUMENT){
                switch (parserEvent) {
                    case XmlPullParser.START_TAG:
                        if(parser.getName().equals("ITEM_NAME")){
                            inITEM_NAME = true;
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if(inITEM_NAME){
                            ITEM_NAME = parser.getText();
                            inITEM_NAME = false;
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if(parser.getName().equals("item")){
                            searchtext.setText(searchtext.getText() + "이름 : " + ITEM_NAME + "\n\n");
                            initem = false;
                        }
                        break;
                }
                parserEvent = parser.next();
            }
        }
        catch(Exception e) {
            searchtext.setText("에러가 났습니다.");
        }
    }
}
