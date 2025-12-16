package com.example.uas_pab;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    ActivityResultLauncher<Intent> verifikasiUserIDPassword = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                if (result.getResultCode() == Activity.RESULT_OK) {
                    Intent dataBalik = result.getData();

                    TextView statusLogin = (TextView) findViewById(R.id.tvStatusLogin);
                    statusLogin.setText(dataBalik.getStringExtra("parRespon"));
                    statusLogin.setVisibility(View.VISIBLE);
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }

    public void panggilVerifikasiSigninActivity(View view) {
        Intent panggilVerifikasiSignin = new Intent(this, VerifikasiSigninActivity.class);

        panggilVerifikasiSignin.putExtra("parUserID", "kailazanita.2005@gmail.com");
        panggilVerifikasiSignin.putExtra("parPassword", "16062005");

        EditText inputUserID = (EditText) findViewById(R.id.etUserID);
        EditText inputPassword = (EditText) findViewById(R.id.etPassword);
        panggilVerifikasiSignin.putExtra("parInputUserID", inputUserID.getText().toString());
        panggilVerifikasiSignin.putExtra("parInputPassword", inputPassword.getText().toString());

        verifikasiUserIDPassword.launch(panggilVerifikasiSignin);
    }
}