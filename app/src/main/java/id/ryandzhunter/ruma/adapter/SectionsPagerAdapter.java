package id.ryandzhunter.ruma.adapter;

/**
 * Created by ryandzhunter on 5/16/16.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import id.ryandzhunter.ruma.fragment.PartFragment;

/**
 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        switch (position) {
            case 0:
                return PartFragment.newInstance(position + 1, 3);
            case 1:
                return PartFragment.newInstance(position + 1, 2);
            case 2:
                return PartFragment.newInstance(position + 1, 1);
        }
        return PartFragment.newInstance(position + 1, 3);
    }

    @Override
    public int getCount() {
        // Show 3 total pages.
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "PART 1";
            case 1:
                return "PART 2";
            case 2:
                return "PART 3";
        }
        return null;
    }
}