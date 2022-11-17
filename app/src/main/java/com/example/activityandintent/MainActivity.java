package com.example.activityandintent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 1;
    private TextView tvYoutube, tvGoogle, tvWhatsApp;
    private EditText etInput;
    private Button btnTransition;
    private ImageView ivImage;

    // Активность создается
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvYoutube = findViewById(R.id.tv_youtube);
        tvGoogle = findViewById(R.id.tv_google);
        tvWhatsApp = findViewById(R.id.tv_whatsapp);
        etInput = findViewById(R.id.et_input);
        ivImage = findViewById(R.id.iv_image);
        btnTransition = findViewById(R.id.btn_transition);

        tvYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Неявный intent
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.youtube.com/"));
                startActivity(intent);
            }
        });

        tvGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Неявный intent
                // ACTION_VIEW просмотр чего-либо
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.google.com/search?q=" + etInput.getText().toString().trim()));
                startActivity(intent);
            }
        });

        tvWhatsApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Неявный intent
                // ACTION_VIEW просмотр чего-либо
                String phoneNumber = "+996708498094";
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://api.whatsapp.com/send?phone=" + phoneNumber));
                startActivity(intent);
            }
        });

        btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = etInput.getText().toString().trim();
                if (text.isEmpty()) {
                    etInput.setError("Поле должно быть заполнено!");
                } else {
                    // Явный intent
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    intent.putExtra("text", text);
                    startActivity(intent);
                }
            }
        });

        ivImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent, "Select Picture"), PICK_IMAGE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                ivImage.setImageURI(data.getData());
            }
        }
    }

    // Активность запускается и становиться видимой
    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Lifecycle", "onStart");
    }

    // Метод для сохранения состояния активности(например - при повороте экрана)
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.e("Lifecycle", "onSaveInstanceState");
    }

    // Активиность работатет и имеет фокус
    @Override
    protected void onResume() {
        super.onResume();
    }

    // Активность теряет фокус(передний план), но все еще видимо
    @Override
    protected void onPause() {
        super.onPause();
    }

    // Активность приостанавливается и больше не видимо
    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Lifecycle", "onStop");
    }

    // Срабатывает если после onStop() метода, пользователь обратно переходит к этой активности
    // И в этот метод, снова запускает onStart() метод
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("Lifecycle", "onRestart");
    }

    // Активность уничтожается
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}