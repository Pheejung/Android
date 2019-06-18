package com.example.userinterface1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

   ViewFlipper vflip;
   Button bsearch, bcategory;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bsearch = findViewById(R.id.bsearch);
        bcategory = findViewById(R.id.bcategory);
        context = this;

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

        int images[] = {
            R.drawable.main1,
            R.drawable.main2,
            R.drawable.main3
        };

        vflip = findViewById(R.id.imgslide);
        for(int image : images) {
            flipimages(image);
        }

    }

       public void flipimages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        vflip.addView(imageView);
        vflip.setFlipInterval(3000);
        vflip.setAutoStart(true);

        vflip.setInAnimation(this, android.R.anim.slide_in_left);
        vflip.setOutAnimation(this,android.R.anim.slide_out_right);
    }
}
