package com.example.mvcmvpdemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.example.mvcmvpdemo.bean.Account;
import com.example.mvcmvpdemo.callback.MCallback;
import com.example.mvcmvpdemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ActivityMainBinding mBinding;
    private MVCModule mvcModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.btn.setOnClickListener(this);
        mvcModule = new MVCModule();
    }

    @Override
    public void onClick(View v) {
        mvcModule.getAccountData(showInput(), new MCallback() {
            @Override
            public void success(Account account) {
                showSuccessPage(account);
            }

            @Override
            public void fault() {
                showFault();
            }
        });
    }

    //展示用户输入
    private String showInput() {
        return mBinding.edit.getText().toString();
    }

    private void showSuccessPage(Account account) {
        mBinding.text.setText("用户名字：" + account.getName() + "用户等级：" + account.getLevel());
    }

    private void showFault() {
        mBinding.text.setText("获取数据失败");

    }


}