package com.R.zabuza.kpss_puan_hesaplama;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PuanActivity extends AppCompatActivity {

    float gy_net_fl = 0;
    float gk_net_fl = 0;
    float egb_net_fl = 0;
    float alb_net_fl = 0;

    double P1 = 0;
    double P2 = 0;
    double P3 = 0;
    double P10 = 0;
    double P121 = 0;


    private TextView tv_gy_net;
    private TextView tv_gk_net;
    private TextView tv_egb_net;
    private TextView tv_alb_net;
    private TextView tv_p1_net;
    private TextView tv_p2_net;
    private TextView tv_p3_net;
    private TextView tv_p10_net;
    private TextView tv_p121_net;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puan);

        Intent intent = getIntent();

        gy_net_fl = intent.getFloatExtra("GY_NET", 0);
        gk_net_fl = intent.getFloatExtra("GK_NET", 0);
        egb_net_fl = intent.getFloatExtra("EGB_NET", 0);
        alb_net_fl = intent.getFloatExtra("ALB_NET", 0);

        P1 = intent.getDoubleExtra("PUAN1", 0);
        P2 = intent.getDoubleExtra("PUAN2", 0);
        P3 = intent.getDoubleExtra("PUAN3", 0);
        P10 = intent.getDoubleExtra("PUAN10", 0);
        P121 = intent.getDoubleExtra("PUAN121", 0);

        tv_gy_net = (TextView)findViewById(R.id.tv_gy_net);
        tv_gk_net = (TextView)findViewById(R.id.tv_gk_net);
        tv_egb_net = (TextView)findViewById(R.id.tv_egb_net);
        tv_alb_net = (TextView)findViewById(R.id.tv_alb_net);
        tv_p1_net = (TextView)findViewById(R.id.tv_p1);
        tv_p2_net = (TextView)findViewById(R.id.tv_p2);
        tv_p3_net = (TextView)findViewById(R.id.tv_p3);
        tv_p10_net = (TextView)findViewById(R.id.tv_p10);
        tv_p121_net = (TextView)findViewById(R.id.tv_p121);

        tv_gy_net.setText(""+gy_net_fl);
        tv_gk_net.setText(""+gk_net_fl);
        tv_egb_net.setText(""+egb_net_fl);
        tv_alb_net.setText(""+alb_net_fl);
        tv_p1_net.setText(""+P1);
        tv_p2_net.setText(""+P2);
        tv_p3_net.setText(""+P3);
        tv_p10_net.setText(""+P10);
        tv_p121_net.setText(""+P121);


        /*
        System.out.println(gy_net_fl);
        System.out.println(gk_net_fl);
        System.out.println(egb_net_fl);
        System.out.println(alb_net_fl);

        System.out.println(P1);
        System.out.println(P2);
        System.out.println(P3);
        System.out.println(P10);
        System.out.println(P121);
        */
    }
}
