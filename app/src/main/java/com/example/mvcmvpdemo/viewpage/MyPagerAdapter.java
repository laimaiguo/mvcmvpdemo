package com.example.mvcmvpdemo.viewpage;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewpager.widget.PagerAdapter;

import java.util.ArrayList;

/**
 * Author GWJ
 * 2021/7/28 16:07
 **/
public class MyPagerAdapter extends PagerAdapter {

    private ArrayList<View> viewArrayList;

    public MyPagerAdapter(){

    }

    public MyPagerAdapter(ArrayList<View> viewArrayList) {
        super();
        this.viewArrayList = viewArrayList;
    }

    //    public MyPagerAdapter(ArrayList<View> viewArrayList, ArrayList<String> titleList) {
//        super();
//        this.viewArrayList = viewArrayList;
//        this.titleList = titleList;
//    }

    @Override
    public int getCount() {
        return viewArrayList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        container.addView(viewArrayList.get(position));
        return viewArrayList.get(position);
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView(viewArrayList.get(position));
    }

}
