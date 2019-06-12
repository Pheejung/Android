package com.example.userinterface1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.userinterface1.Category.headActivity;
import com.example.userinterface1.Category.muscleActivity;
import com.example.userinterface1.Category.neckActivity;
import com.example.userinterface1.Category.stomachActivity;

public class CategoryActivity extends AppCompatActivity {

    private Button imghead, imgthroat, imgstomach, imgheart;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        context = this;

        imghead = (Button) findViewById(R.id.imghead);
        imgthroat = (Button) findViewById(R.id.imgthroat);
        imgstomach = (Button) findViewById(R.id.imgstomach);
        imgheart = (Button) findViewById(R.id.imgheart);

        imghead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent headi = new Intent(context, headActivity.class);
                startActivity(headi);
            }
        });


        imgthroat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent necki = new Intent(context, neckActivity.class);
                startActivity(necki);
            }
        });


        imgstomach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jointi = new Intent(context, stomachActivity.class);
                startActivity(jointi);
            }
        });

        imgheart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musclei = new Intent(context, muscleActivity.class);
                startActivity(musclei);
            }
        });
    }
}
