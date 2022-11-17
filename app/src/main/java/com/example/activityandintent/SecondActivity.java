package com.example.activityandintent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvText = findViewById(R.id.tv_text);

        Bundle argument = getIntent().getExtras();
        if (argument != null) {
            String text = argument.getString("text");
            tvText.setText(text);
        }

        tvText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SecondActivity.this, tvText.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}