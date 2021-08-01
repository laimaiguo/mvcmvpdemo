package com.example.mvcmvpdemo.mvp;

import com.example.mvcmvpdemo.bean.Account;
import com.example.mvcmvpdemo.callback.MCallback;

import java.util.Random;

/**
 * Author GWJ
 * 2021/7/23 12:57
 * 数据的获取
 **/
public class MVPModule {
    public void getAccountData(String accountName, MCallback callback){
        Random random = new Random();
        boolean isSuccess = random.nextBoolean();
        if (isSuccess){
            Account account = new Account();
            account.setName(accountName);
            account.setLevel(100);
            callback.success(account);
        }else {
            callback.fault();
        }
    }
}
