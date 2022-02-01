package com.example.amdroid1_dz_2.ui.mein_aktivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.amdroid1_dz_2.R;

public class MainActivity extends AppCompatActivity {
    ImageView imAva;
    Button btnLogin;
    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initialization();
        setupListener();

    }

    private void initialization() {
        imAva = findViewById(R.id.im_ava);
        etEmail = findViewById(R.id.et_email);
        etPassword = findViewById(R.id.tv_Password);
        btnLogin = findViewById(R.id.tv_login);

    }

    private void setupListener() {
        imAva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bitmap bitmap =
                String Email = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Image Description", null);
                Uri uri = Uri.parse(path);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, uri);
                startActivity(Intent.createChooser(intent, "Share Image"));
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SekondActivity2.class);
                startActivity(intent);
            }
        });


    }


}