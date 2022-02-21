package com.example.amdroid1_dz_2.ui.mein_aktivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.amdroid1_dz_2.R;

import java.util.ArrayList;

public class SekondActivity2 extends AppCompatActivity {
    ImageView imAvatar;
    TextView tvUserEmail, tvUserPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekond2);
        imAvatar = findViewById(R.id.im_avatar);
        tvUserEmail = findViewById(R.id.tv_user_email);
        tvUserPassword = findViewById(R.id.tv_user_password);
        getData();
    }

    private void getData() {
        Intent intent = getIntent();
        ArrayList<String> info = intent.getStringArrayListExtra("info");
        tvUserPassword.setText(info.get(1));
        tvUserEmail.setText(info.get(0));
        imAvatar.setImageURI(intent.getData());
    }
}