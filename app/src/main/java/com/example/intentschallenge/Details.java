package com.example.intentschallenge;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class Details extends AppCompatActivity implements View.OnClickListener {

    EditText et_name, et_phone, et_web, et_location;
    ImageView emoticon, face, mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        et_name = findViewById(R.id.et_name);
        et_phone = findViewById(R.id.et_name);
        et_web = findViewById(R.id.et_web);
        et_location = findViewById(R.id.et_location);

        emoticon = findViewById(R.id.emoticon);
        face = findViewById(R.id.face);
        mood = findViewById(R.id.mood);
    }

    @Override
    public void onClick(View v) {
        if (et_location.getText().toString().trim().isEmpty() || et_web.getText().toString().trim().isEmpty() ||
                et_phone.getText().toString().trim().isEmpty() || et_name.getText().toString().trim().isEmpty()) {
            Toast.makeText(this, "Please enter the required details", Toast.LENGTH_SHORT).show();
        } else {
            Intent intent = new Intent();
            intent.putExtra("name", et_name.getText().toString().trim());
            intent.putExtra("phone", et_phone.getText().toString().trim());
            intent.putExtra("web", et_web.getText().toString().trim());
            intent.putExtra("location", et_location.getText().toString().trim());

            if (v.getId() == R.id.emoticon) {
                intent.putExtra("mood", "happy");
            }
            else if (v.getId() == R.id.face) {
                intent.putExtra("mood", "sad");
            }
            else {
                intent.putExtra("mood", "good");

            }
            setResult(RESULT_OK, intent);
            Details.this.finish();
        }
    }
}
