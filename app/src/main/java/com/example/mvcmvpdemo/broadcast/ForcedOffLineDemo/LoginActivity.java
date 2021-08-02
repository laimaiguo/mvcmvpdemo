package com.example.mvcmvpdemo.broadcast.ForcedOffLineDemo;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.mvcmvpdemo.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity {

    private ActivityLoginBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = mBinding.loginAccout.getText().toString();
                String password = mBinding.loginPassword.getText().toString();
                if (account.equals("admin")&& password.equals("123456")){
                    Intent intent =new Intent(LoginActivity.this,LoginMainActivity.class);
                    startActivity(intent);
                }else {
                    Toast.makeText(LoginActivity.this,"account or password is invalid",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}