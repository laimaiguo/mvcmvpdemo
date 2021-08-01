package com.example.mvcmvpdemo.mvp;

import com.example.mvcmvpdemo.bean.Account;
import com.example.mvcmvpdemo.callback.MCallback;

/**
 * Author GWJ
 * 2021/7/23 12:58
 **/
public class MVPPresenter {
    private MVPModule mvpModule;
    private IMVPView imvpView;

    public MVPPresenter(IMVPView mView){
        this.imvpView = mView;
        mvpModule = new MVPModule();
    }

    public void getData(String accountName) {
        mvpModule.getAccountData(accountName, new MCallback() {
            @Override
            public void success(Account account) {
                imvpView.showSuccessPage(account);
            }

            @Override
            public void fault() {
                imvpView.showFault();
            }
        });
    }
}
