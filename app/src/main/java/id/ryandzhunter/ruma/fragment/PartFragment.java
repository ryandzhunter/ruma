package id.ryandzhunter.ruma.fragment;

/**
 * Created by ryandzhunter on 5/16/16.
 */

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import id.ryandzhunter.ruma.R;
import id.ryandzhunter.ruma.adapter.ViewPagerAdapter;

/**
 * A placeholder fragment containing a simple view.
 */
public class PartFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static final String ARG_NUM_PAGES = "num_pages";
    private int NUM_PAGES = 0;
    private ViewPager pager;
    private LinearLayout circles;
    private boolean isOpaque;
    //    private CustomPagerAdapter pagerAdapter;
    private ViewPagerAdapter pagerAdapter;

    public PartFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static PartFragment newInstance(int sectionNumber, int i) {
        PartFragment fragment = new PartFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        args.putInt(ARG_NUM_PAGES, i);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);
        NUM_PAGES = getArguments().getInt(ARG_NUM_PAGES);
        pagerAdapter = new ViewPagerAdapter(getChildFragmentManager(), NUM_PAGES, sectionNumber);
//        pagerAdapter = new CustomPagerAdapter(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        setParallaxBanner(rootView);

        if (NUM_PAGES > 1)
            buildCircles(rootView);
        return rootView;
    }

    private void setParallaxBanner(View rootView) {

        pager = (ViewPager) rootView.findViewById(R.id.pager);
        pager.setAdapter(pagerAdapter);
        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                if (position == NUM_PAGES && positionOffset > 0) {
                    if (isOpaque) {
                        pager.setBackgroundColor(Color.TRANSPARENT);
                        isOpaque = false;
                    }
                } else {
                    if (!isOpaque) {
                        pager.setBackgroundColor(ContextCompat.getColor(getActivity(), R.color.primary_material_light));
                        isOpaque = true;
                    }
                }
            }

            @Override
            public void onPageSelected(int position) {
                setIndicator(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void buildCircles(View rootView) {
        circles = LinearLayout.class.cast(rootView.findViewById(R.id.circles));

        float scale = getResources().getDisplayMetrics().density;
        int padding = (int) (5 * scale + 0.5f);

        for (int i = 0; i < NUM_PAGES; i++) {
            ImageView circle = new ImageView(getActivity());
            circle.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.circle_select));
            circle.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            circle.setAdjustViewBounds(true);
            circle.setPadding(padding, 0, padding, 0);
            circles.addView(circle);
        }

        setIndicator(0);
    }

    private void setIndicator(int index) {
        if (index < NUM_PAGES) {
            for (int i = 0; i < NUM_PAGES; i++) {
                ImageView circle = (ImageView) circles.getChildAt(i);
                if (i == index) {
                    circle.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.circle_select));
                } else {
                    circle.setImageDrawable(ContextCompat.getDrawable(getActivity(), R.drawable.circle_unselect));
                }
            }
        }
    }
}
