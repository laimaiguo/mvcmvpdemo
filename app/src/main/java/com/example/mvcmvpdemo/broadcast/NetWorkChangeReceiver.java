package com.example.mvcmvpdemo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * Author GWJ
 * 2021/7/30 16:30
 **/
public class NetWorkChangeReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
//        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
//        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
//        if(networkInfo !=null&& networkInfo.isAvailable()){
//            Toast.makeText(context,"newwork is Available",Toast.LENGTH_SHORT).show();
//        }else {
//            Toast.makeText(context,"newwork is unAvailable",Toast.LENGTH_SHORT).show();
//
//        }

        Toast.makeText(context, "NetWorkChangeReceiver is Available", Toast.LENGTH_SHORT).show();
    }
}
