package com.example.amdroid1_dz_2.ui.mein_aktivity;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.amdroid1_dz_2.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ImageView imAva;
    private final int numberElement = 2;
    Button btnLogin;
    EditText etEmail, etPassword;
    Uri imUri;
    private ArrayList<String> profile = new ArrayList<>(numberElement);

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
        imAva.setOnClickListener(view -> {
            resultLauncher.launch("im/*");
        });
        btnLogin.setOnClickListener(view -> {
            String password = etPassword.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            Intent intent = new Intent(MainActivity.this, SekondActivity2.class);
            intent.putStringArrayListExtra("info",profile);
            intent.setData(imUri);
            if (email.length() == 0 || password.length() == 0){
                etPassword.setError("Password");
                etEmail.setError("Email");
            }else {
                profile.add(0,email);
                profile.add(1,password);
                startActivity(intent);

            }
        });
    }

    ActivityResultLauncher<String> resultLauncher = registerForActivityResult(new ActivityResultContracts.GetContent(),
            new ActivityResultCallback<Uri>() {
                @Override
                public void onActivityResult(Uri result) {
                    imUri = result;
                    imAva.setImageURI(imUri);

                }
            });
}

