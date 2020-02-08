package com.example.project1_slots;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        count = 5;
    }

    public void onReset(View view) {
        count = 5;
        TextView newtext = findViewById(R.id.textView4);
        newtext.setText("$" + count);

    }

    public void onGo(View view) {
        count--;
        TextView newtext = findViewById(R.id.textView4);
        newtext.setText("$" + count);
        ImageView image = findViewById(R.id.imageView4);
        image.setImageResource(R.drawable.tmp);
    }

}
