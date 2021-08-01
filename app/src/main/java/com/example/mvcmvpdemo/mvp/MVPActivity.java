package com.example.mvcmvpdemo.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.mvcmvpdemo.MVCModule;
import com.example.mvcmvpdemo.R;
import com.example.mvcmvpdemo.bean.Account;
import com.example.mvcmvpdemo.databinding.ActivityMainBinding;

public class MVPActivity extends AppCompatActivity implements View.OnClickListener, IMVPView {

    private ActivityMainBinding mBinding;
    private MVPPresenter mvpPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.btn.setOnClickListener(this);
        mvpPresenter = new MVPPresenter(this);

    }

    @Override
    public void onClick(View v) {
        mvpPresenter.getData(showInput());
    }

    @Override
    public String showInput() {
        return mBinding.edit.getText().toString();

    }

    @Override
    public void showSuccessPage(Account account) {
        mBinding.text.setText("用户名字：" + account.getName() + "用户等级：" + account.getLevel());
    }

    @Override
    public void showFault() {
        mBinding.text.setText("获取数据失败");
    }
}