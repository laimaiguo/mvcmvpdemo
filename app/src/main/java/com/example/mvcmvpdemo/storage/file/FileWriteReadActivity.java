package com.example.mvcmvpdemo.storage.file;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.example.mvcmvpdemo.R;
import com.example.mvcmvpdemo.databinding.ActivityFileWriteReadBinding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileWriteReadActivity extends AppCompatActivity {

    private ActivityFileWriteReadBinding mBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ActivityFileWriteReadBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        mBinding.fileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = mBinding.fileEdit.getText().toString();
                save(content);
                String inputText = load();
                if (!TextUtils.isEmpty(inputText)){
                    mBinding.fileText.setText(inputText);
                    mBinding.fileText.setSelected(true);
                }
            }
        });
    }

    //写入
    private void save(String content) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out=openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(content);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (writer!=null){
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //读取
    private String load(){
        FileInputStream fileInputStream =null;
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            fileInputStream = openFileInput("data");
            reader = new BufferedReader(new InputStreamReader(fileInputStream));
            String line = "";
            if ((line=reader.readLine())!=null){
                builder.append(line);
            }

        }catch (IOException e){
            e.printStackTrace();

        }finally {
            if (reader!=null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return builder.toString();
    }

}