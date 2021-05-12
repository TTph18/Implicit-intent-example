package com.example.chat;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        final LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear_layout);
        TextView textView = new TextView(MainActivity2.this);
        Bundle bn = getIntent().getExtras();
        String value = bn.getString("user1");
        textView.setText(String.valueOf(value));
        linearLayout.addView(textView);

        EditText _input = findViewById(R.id.text_input_second);
        Button _submit = findViewById(R.id.send_second);
        _submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = _input.getText().toString();
                TextView textView = new TextView(MainActivity2.this);
                textView.setTextColor(Color.parseColor("#4000ff"));
                textView.setText(value);
                linearLayout.addView(textView);

            }
        });
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = _input.getText().toString();
                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                intent.putExtra("user2", value);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}