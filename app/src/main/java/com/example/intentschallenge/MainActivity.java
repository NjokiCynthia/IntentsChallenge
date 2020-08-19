package com.example.intentschallenge;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_1;
    Button btn_create;
    ImageView ic_phone, ic_location, ic_web;

    final int create_contact = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_1 = findViewById(R.id.tv_1);
        btn_create = findViewById(R.id.btn_create);

        ic_phone = findViewById(R.id.ic_phone);
        ic_location = findViewById(R.id.ic_location);
        ic_web = findViewById(R.id.ic_web);

        ic_web.setVisibility(View.GONE);
        ic_phone.setVisibility(View.GONE);
        ic_location.setVisibility(View.GONE);


        btn_create.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent  = new Intent(MainActivity.this, com.example.intentschallenge.Details.class);
                startActivityForResult(intent, create_contact);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == create_contact){

        }
    }
}
