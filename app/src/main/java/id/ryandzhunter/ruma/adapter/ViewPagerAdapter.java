package id.ryandzhunter.ruma.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import id.ryandzhunter.ruma.R;
import id.ryandzhunter.ruma.fragment.ViewPagerFragment;


/**
 * Created by ryandzhunter on 10/30/15.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    private final int NUM_PAGES;
    private final int section_number;

    public ViewPagerAdapter(FragmentManager fm, int num, int section_number) {
        super(fm);
        this.NUM_PAGES = num;
        this.section_number = section_number;
    }

    @Override
    public Fragment getItem(int position) {
        ViewPagerFragment tp = null;
        switch (position) {
            case 0:
                tp = ViewPagerFragment.newInstance(R.layout.viewpager, position, section_number);
                break;
            case 1:
                tp = ViewPagerFragment.newInstance(R.layout.viewpager, position, section_number);
                break;
            case 2:
                tp = ViewPagerFragment.newInstance(R.layout.viewpager, position, section_number);
                break;
        }

        return tp;
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}