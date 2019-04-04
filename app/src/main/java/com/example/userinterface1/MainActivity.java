package com.example.userinterface1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button binfo;
    private Button bsearch;
    private Button bcategory;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        binfo = (Button) findViewById(R.id.binfo);
        bsearch = (Button) findViewById(R.id.bsearch);
        bcategory = (Button) findViewById(R.id.bcategory);
        context = this;

        binfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, InfoActivity.class);
                startActivity(i);
            }
        });

        bsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent a = new Intent(context, SearchActivity.class);
                startActivity(a);
            }
        });

        bcategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(context, CategoryActivity.class);
                startActivity(b);
            }
        });

    }
}
