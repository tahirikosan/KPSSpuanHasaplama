package com.R.zabuza.kpss_puan_hesaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String GY_NET = "GY_NET";
    public static final String GK_NET = "GK_NET";
    public static final String EGB_NET = "EGB_NET";
    public static final String ALB_NET = "ALB_NET";
    public static final String PUAN1 = "PUAN1";
    public static final String PUAN2 = "PUAN2";
    public static final String PUAN3 = "PUAN3";
    public static final String PUAN10 = "PUAN10";
    public static final String PUAN121 = "PUAN121";


    int gy_dogru_int = 0;
    int gy_yanlis_int = 0;
    float gy_net_fl = 0;
    int gk_dogru_int = 0;
    int gk_yanlis_int = 0;
    float gk_net_fl = 0;
    int egb_dogru_int = 0;
    int egb_yanlis_int = 0;
    float egb_net_fl = 0;
    int alb_dogru_int = 0;
    int alb_yanlis_int = 0;
    float alb_net_fl = 0;

    private EditText gy_dogru;
    private EditText gy_yanlis;
    private EditText gy_net;
    private EditText gk_dogru;
    private EditText gk_yanlis;
    private EditText gk_net;
    private EditText egb_dogru;
    private EditText egb_yanlis;
    private EditText egb_net;
    private EditText alb_dogru;
    private EditText alb_yanlis;
    private EditText alb_net;

    private Button btn_hesapla;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gy_dogru = (EditText)findViewById(R.id.gy_dogru);
        gy_yanlis = (EditText)findViewById(R.id.gy_yanlis);
        gy_net = (EditText)findViewById(R.id.gy_net);
        gk_dogru = (EditText)findViewById(R.id.gk_dogru);
        gk_yanlis = (EditText)findViewById(R.id.gk_yanlis);
        gk_net = (EditText)findViewById(R.id.gk_net);
        egb_dogru = (EditText)findViewById(R.id.egb_dogru);
        egb_yanlis = (EditText)findViewById(R.id.egb_yanlis);
        egb_net = (EditText)findViewById(R.id.egb_net);
        alb_dogru = (EditText)findViewById(R.id.alb_dogru);
        alb_yanlis = (EditText)findViewById(R.id.alb_yanlis);
        alb_net = (EditText)findViewById(R.id.alb_net);

        btn_hesapla = (Button)findViewById(R.id.btn_hesapla);

        btn_hesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                     gy_dogru_int = Integer.valueOf(gy_dogru.getText().toString());
                     gy_yanlis_int = Integer.valueOf(gy_yanlis.getText().toString());
                     gy_net_fl = Float.valueOf(gy_net.getText().toString());

                     gk_dogru_int = Integer.valueOf(gk_dogru.getText().toString());
                     gk_yanlis_int = Integer.valueOf(gk_yanlis.getText().toString());
                     gk_net_fl = Float.valueOf(gk_net.getText().toString());

                     egb_dogru_int = Integer.valueOf(egb_dogru.getText().toString());
                     egb_yanlis_int = Integer.valueOf(egb_yanlis.getText().toString());
                     egb_net_fl = Float.valueOf(egb_net.getText().toString());

                     alb_dogru_int = Integer.valueOf(alb_dogru.getText().toString());
                     alb_yanlis_int = Integer.valueOf(alb_yanlis.getText().toString());
                     alb_net_fl = Float.valueOf(alb_net.getText().toString());

                         if(gy_net_fl == 0){
                             gy_net_fl = NetHesapla(gy_dogru_int, gy_yanlis_int);
                         }
                         if(gk_net_fl == 0){
                             gk_net_fl = NetHesapla(gk_dogru_int, gk_yanlis_int);
                         }
                         if(egb_net_fl == 0){
                             egb_net_fl = NetHesapla(egb_dogru_int, egb_yanlis_int);
                         }
                         if(alb_net_fl == 0){
                             alb_net_fl = NetHesapla(alb_dogru_int, alb_yanlis_int);
                         }

                         double P1 = P1_Hesapla(gy_net_fl, gk_net_fl);
                         double P2 = P2_Hesapla(gy_net_fl, gk_net_fl);
                         double P3 = P3_Hesapla(gy_net_fl, gk_net_fl);
                         double P10 = P10_Hesapla(gy_net_fl, gk_net_fl, egb_net_fl);
                         double P121 = P121_Hesapla(gy_net_fl, gk_net_fl, egb_net_fl, alb_net_fl);

                    Intent intent = new Intent(MainActivity.this, PuanActivity.class);
                    intent.putExtra(GY_NET, gy_net_fl);
                    intent.putExtra(GK_NET, gk_net_fl);
                    intent.putExtra(EGB_NET, egb_net_fl);
                    intent.putExtra(ALB_NET, alb_net_fl);
                    intent.putExtra(PUAN1, P1);
                    intent.putExtra(PUAN2, P2);
                    intent.putExtra(PUAN3, P3);
                    intent.putExtra(PUAN10, P10);
                    intent.putExtra(PUAN121, P121);
                    startActivity(intent);

                }catch (Exception e){
                    Toast.makeText(MainActivity.this, "Lütfen boşluklardaki yerleri düzgün bir şekilde doldurunuz!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

    private float NetHesapla(int dogru, int yanlis){
        float net = 0;
        net = Float.valueOf(dogru) - Float.valueOf(Float.valueOf(yanlis) / 4);
        return net;
    }

    private double P1_Hesapla(float gy_net, float gk_net){
       // double puan = (gy_net * 1.167) + (gk_net * 0.5);
        double puan = (gy_net * 0.7) + (gk_net * 0.3) + 40;
        return puan;
    }

    private double P2_Hesapla(float gy_net, float gk_net){
        double puan = (gy_net * 0.6) + (gk_net * 0.4) + 40;
        return puan;
    }

    private double P3_Hesapla(float gy_net, float gk_net){
        double puan = (gy_net * 0.5) + (gk_net * 0.5) + 40;
        return puan;
    }

    private double P10_Hesapla(float gy_net, float gk_net, float egb_net_fl){
        double puan = (gy_net * 0.5) + (gk_net * 0.5) + (egb_net_fl * 0.5);
        return puan;
    }

    private double P121_Hesapla(float gy_net, float gk_net, float egb_net, float alb_net){
        double puan = (gy_net * 1.6 * 0.15) + (gk_net * 1.6 * 0.15)  + (egb_net * 1.25 * 0.2) + (alb_net * 1.333 * 0.5) + 1.2125;
        return puan;
    }
}
