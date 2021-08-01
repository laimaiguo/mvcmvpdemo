package com.example.mvcmvpdemo.mvp;

import com.example.mvcmvpdemo.bean.Account;

/**
 * Author GWJ
 * 2021/7/23 12:53
 **/
public interface IMVPView {
    String showInput();
    void showSuccessPage(Account account);
    void showFault();
}
