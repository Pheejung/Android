package com.example.userinterface1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CategoryActivity extends AppCompatActivity {

    private Button head, eye, neck, stomach, joint, muscle;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        context = this;

        head = (Button) findViewById(R.id.head);
        eye = (Button) findViewById(R.id.eye);
        neck = (Button) findViewById(R.id.neck);
        stomach = (Button) findViewById(R.id.stomach);
        joint = (Button) findViewById(R.id.joint);
        muscle = (Button) findViewById(R.id.muscle);

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
    }
}
