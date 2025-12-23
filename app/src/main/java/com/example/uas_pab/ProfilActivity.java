package com.example.uas_pab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfilActivity extends AppCompatActivity {

    private FragmentPendidikan objFragmentPendidikan;
    private FragmentKeahlian objFragmentKeahlian;
    private FragmentPengalaman objFragmentPengalaman;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profil);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        objFragmentPendidikan = new FragmentPendidikan();
        objFragmentKeahlian = new FragmentKeahlian();
        objFragmentPengalaman = new FragmentPengalaman();

        Button tombolFragmentPendidikan = (Button) findViewById(R.id.btnFragmentPendidikan);
        Button tombolFragmentKeahlian = (Button) findViewById(R.id.btnFragmentKeahlian);
        Button tombolFragmentPengalaman = (Button) findViewById(R.id.btnFragmentPengalaman);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frameLayout, objFragmentPendidikan)
                .commit();

        tombolFragmentPendidikan.setEnabled(false);

        tombolFragmentPendidikan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, objFragmentPendidikan)
                        .commit();
                tombolFragmentPendidikan.setEnabled(false);
                tombolFragmentKeahlian.setEnabled(true);
                tombolFragmentPengalaman.setEnabled(true);
            }
        });

        tombolFragmentKeahlian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, objFragmentKeahlian)
                        .commit();
                tombolFragmentPendidikan.setEnabled(true);
                tombolFragmentKeahlian.setEnabled(false);
                tombolFragmentPengalaman.setEnabled(true);
            }
        });

        tombolFragmentPengalaman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frameLayout, objFragmentPengalaman)
                        .commit();
                tombolFragmentPendidikan.setEnabled(true);
                tombolFragmentKeahlian.setEnabled(true);
                tombolFragmentPengalaman.setEnabled(false);
            }
        });
    }
}