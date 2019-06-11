package com.example.userinterface1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.userinterface1.Category.headActivity;
import com.example.userinterface1.Category.jointActivity;
import com.example.userinterface1.Category.muscleActivity;
import com.example.userinterface1.Category.neckActivity;

public class CategoryActivity extends AppCompatActivity {

    private Button head, neck, joint, muscle;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        context = this;

        /*head = (Button) findViewById(R.id.head);
        neck = (Button) findViewById(R.id.neck);
        joint = (Button) findViewById(R.id.joint);
        muscle = (Button) findViewById(R.id.muscle);*/

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent headi = new Intent(context, headActivity.class);
                startActivity(headi);
            }
        });


        neck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent necki = new Intent(context, neckActivity.class);
                startActivity(necki);
            }
        });


        joint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent jointi = new Intent(context, jointActivity.class);
                startActivity(jointi);
            }
        });

        muscle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent musclei = new Intent(context, muscleActivity.class);
                startActivity(musclei);
            }
        });
    }
}
