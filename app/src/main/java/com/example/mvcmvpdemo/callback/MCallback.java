package com.example.mvcmvpdemo.callback;

import com.example.mvcmvpdemo.bean.Account;

/**
 * Author GWJ
 * 2021/7/23 12:35
 **/
public interface MCallback {
    void success(Account account);
    void fault();
}
