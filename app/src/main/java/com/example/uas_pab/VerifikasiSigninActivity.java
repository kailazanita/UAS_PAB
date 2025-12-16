package com.example.uas_pab;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class VerifikasiSigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_verifikasi_signin);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent ambilUserIDPassword = getIntent();
        String userID = ambilUserIDPassword.getStringExtra("parUserID");
        String password = ambilUserIDPassword.getStringExtra("parPassword");
        String inputUserID = ambilUserIDPassword.getStringExtra("parInputUserID");
        String inputPassword = ambilUserIDPassword.getStringExtra("parInputPassword");

        if (inputUserID.equals(userID)) {
            if (inputPassword.equals(password)) {
                Intent kirimResponBerhasil = new Intent(this, ProfilActivity.class);
                startActivity(kirimResponBerhasil);
            }
            else {
                Intent kirimResponGagal = new Intent();
                kirimResponGagal.putExtra("parRespon", "Password Salah");
                setResult(RESULT_OK, kirimResponGagal);
                finish();
            }
        }
        else {
            Intent kirimResponGagal = new Intent();
            kirimResponGagal.putExtra("parRespon", "User ID Salah");
            setResult(RESULT_OK, kirimResponGagal);
            finish();
        }
    }
}
