package com.ada.servicetest.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ada.servicetest.R;
import com.ada.servicetest.service.MyService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnStart;
    private Button btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart=(Button) findViewById(R.id.btn_start_service);
        btnStop=(Button)findViewById(R.id.btn_stop_service);
        btnStop.setOnClickListener(this);
        btnStart.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        Intent it=new Intent(this, MyService.class);
        switch(view.getId()){
            case R.id.btn_start_service:
                startService(it);
                break;
            case R.id.btn_stop_service:
                stopService(it);
                break;
            default:
                break;
        }
    }
}
