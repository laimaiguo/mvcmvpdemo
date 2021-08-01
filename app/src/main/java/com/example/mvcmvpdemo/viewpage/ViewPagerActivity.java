package com.example.mvcmvpdemo.viewpage;

import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.example.mvcmvpdemo.R;
import com.example.mvcmvpdemo.databinding.ViewPageOneBinding;
import com.example.mvcmvpdemo.databinding.ViewPagerBinding;

import java.util.ArrayList;

/**
 * Author GWJ
 * 2021/7/28 16:20
 **/
public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener, ViewPager.OnPageChangeListener {
    private MyPagerAdapter myPagerAdapter;
    private ViewPagerBinding mBinding;
    private ArrayList<View> arrayList;
    private ArrayList<String> titleList;

    private int offset = 0;//移动条图片的偏移量
    private int currIndex = 0;//当前页面的编号
    private int bmpWidth;// 移动条图片的长度
    private int one = 0; //移动条滑动一页的距离
    private int two = 0; //滑动条移动两页的距离
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = ViewPagerBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());
        initData();

    }

    private void initData() {
        //下划线动画的相关设置：
        bmpWidth = BitmapFactory.decodeResource(getResources(), R.mipmap.line).getWidth();// 获取图片宽度
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int screenW = dm.widthPixels;// 获取分辨率宽度
        offset = (screenW / 3 - bmpWidth) / 2;// 计算偏移量
        Matrix matrix = new Matrix();
        matrix.postTranslate(offset, 0);
        mBinding.line.setImageMatrix(matrix);// 设置动画初始位置
        //移动的距离
        one = offset * 2 + bmpWidth;// 移动一页的偏移量,比如1->2,或者2->3
        two = one * 2;// 移动两页的偏移量,比如1直接跳3

        arrayList = new ArrayList<>();
        LayoutInflater li = getLayoutInflater();
        arrayList.add(li.inflate(R.layout.view_page_one,null,false));
        arrayList.add(li.inflate(R.layout.view_page_two,null,false));
        arrayList.add(li.inflate(R.layout.view_page_three,null,false));

        myPagerAdapter = new MyPagerAdapter(arrayList);
        mBinding.viewPager.setAdapter(myPagerAdapter);
        mBinding.viewPager.setCurrentItem(0);

        mBinding.textOne.setOnClickListener(this);
        mBinding.textTwo.setOnClickListener(this);
        mBinding.textThree.setOnClickListener(this);
        mBinding.viewPager.addOnPageChangeListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.text_one:
                mBinding.viewPager.setCurrentItem(0);
                break;
            case R.id.text_two:
                mBinding.viewPager.setCurrentItem(1);
                break;
            case R.id.text_three:
                mBinding.viewPager.setCurrentItem(2);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Animation animation = null;
        switch (position) {
            case 0:
                if (currIndex == 1) {
                    animation = new TranslateAnimation(one, 0, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(two, 0, 0, 0);
                }
                break;
            case 1:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, one, 0, 0);
                } else if (currIndex == 2) {
                    animation = new TranslateAnimation(two, one, 0, 0);
                }
                break;
            case 2:
                if (currIndex == 0) {
                    animation = new TranslateAnimation(offset, two, 0, 0);
                } else if (currIndex == 1) {
                    animation = new TranslateAnimation(one, two, 0, 0);
                }
                break;
        }
        currIndex = position;
        animation.setFillAfter(true);// true表示图片停在动画结束位置
        animation.setDuration(300); //设置动画时间为300毫秒
        mBinding.line.startAnimation(animation);//开始动画
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
