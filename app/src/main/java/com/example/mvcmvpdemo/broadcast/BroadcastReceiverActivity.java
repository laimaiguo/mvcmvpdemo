package com.example.mvcmvpdemo.broadcast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import static android.content.ContentValues.TAG;

import com.example.mvcmvpdemo.R;
import com.example.mvcmvpdemo.databinding.ActivityBroadcastReceiverBinding;

public class BroadcastReceiverActivity extends AppCompatActivity {

    private NetWorkChangeReceiver netWorkChangeReceiver;
    private IntentFilter intentFilter;
    private ActivityBroadcastReceiverBinding mBinding;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityBroadcastReceiverBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.mvcmvpdemo.broadcast.NEW_BROADCAST");
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        netWorkChangeReceiver = new NetWorkChangeReceiver();
        localBroadcastManager.registerReceiver(netWorkChangeReceiver, intentFilter);

        mBinding.broadcastBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setAction("com.example.mvcmvpdemo.broadcast.NEWWORK_BROADCAST");
//                intent.setPackage(getPackageName());//安卓8.0以后静态注册需要加上这句才可以接收到广播
//                sendOrderedBroadcast(intent, null);
                Intent intent = new Intent("com.example.mvcmvpdemo.broadcast.NEW_BROADCAST");
                localBroadcastManager.sendBroadcast(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(netWorkChangeReceiver);
    }
}