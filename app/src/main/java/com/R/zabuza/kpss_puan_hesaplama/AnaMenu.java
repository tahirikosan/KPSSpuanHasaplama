package com.R.zabuza.kpss_puan_hesaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AnaMenu extends AppCompatActivity {

    private TextView tv_hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ana_menu);

        tv_hesapla = (TextView)findViewById(R.id.tv_hesapla);

        tv_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AnaMenu.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
