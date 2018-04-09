package zzl.com.eventbustest.RecyclerView.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import zzl.com.eventbustest.RecyclerView.Fragment.FirstFragment;
import zzl.com.eventbustest.RecyclerView.Fragment.FourthFragment;
import zzl.com.eventbustest.RecyclerView.Fragment.SecondFragment;
import zzl.com.eventbustest.RecyclerView.Fragment.ThirdFragmnet;

/**
 * Created by ZZL on 2018/4/9.
 * Email:gdongxie@gmail.com
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] mTitles = new String[]{"简单使用", "瀑布流", "待定", "待定"};

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 1) {
            return new SecondFragment();
        } else if (position == 2) {
            return new ThirdFragmnet();
        } else if (position == 3) {
            return new FourthFragment();
        }
        return new FirstFragment();
    }

    @Override
    public int getCount() {
        return mTitles.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}
