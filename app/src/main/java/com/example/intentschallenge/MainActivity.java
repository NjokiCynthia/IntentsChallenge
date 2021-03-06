package com.example.intentschallenge;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv_1;
    Button btn_create;
    ImageView ic_phone, ic_location, ic_web, ic_moods;

    final int create_contact = 1;

    String number="", name="", web="", map="";

    String mood="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1 = findViewById(R.id.tv_1);
        btn_create = findViewById(R.id.btn_create);

        ic_phone = findViewById(R.id.ic_phone);
        ic_location = findViewById(R.id.ic_location);
        ic_web = findViewById(R.id.ic_web);
        ic_moods = findViewById(R.id.ic_moods);

        ic_web.setVisibility(View.GONE);
        ic_phone.setVisibility(View.GONE);
        ic_location.setVisibility(View.GONE);
        ic_moods.setVisibility(View.GONE);


        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, com.example.intentschallenge.Details.class);
                startActivityForResult(intent, create_contact);

            }
        });

        ic_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(number));
                startActivity(intent);
            }
        });

        ic_web.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://" + web));
                startActivity(intent);

            }
        });

        ic_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=" + map));
                startActivity(intent);

            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == create_contact){
            if (resultCode == RESULT_OK){
                ic_web.setVisibility(View.VISIBLE);
                ic_phone.setVisibility(View.VISIBLE);
                ic_location.setVisibility(View.VISIBLE);
                ic_moods.setVisibility(View.VISIBLE);

                name = data.getStringExtra("name");
                number = data.getStringExtra("number");
                web = data.getStringExtra("web");
                map = data.getStringExtra("map");
                mood = data.getStringExtra("mood");

                if (mood.equals("happy"))
                {
                    ic_moods.setImageResource(R.drawable.ic_emoticon);
                }
               else if (mood.equals("sad")){
                    ic_moods.setImageResource(R.drawable.ic_face);
                }
                else {
                    ic_moods.setImageResource(R.drawable.ic_mood);
                }
            }
            else
            {
                Toast.makeText(this, "No data was parsed", Toast.LENGTH_SHORT).show();
            }

        }
    }
}
