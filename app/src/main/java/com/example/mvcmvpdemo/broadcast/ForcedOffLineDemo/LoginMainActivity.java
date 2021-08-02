package com.example.mvcmvpdemo.broadcast.ForcedOffLineDemo;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.mvcmvpdemo.databinding.ActivityLoginMainBinding;

public class LoginMainActivity extends BaseActivity {

    private ActivityLoginMainBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.loginMainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("com.example.mvcmvpdemo.broadcast.demo.OFFLINE_BROADCAST");
                sendBroadcast(intent);
            }
        });
    }
}