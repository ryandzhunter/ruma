package id.ryandzhunter.ruma.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import id.ryandzhunter.ruma.R;

public class ViewPagerFragment extends Fragment {

    final static String LAYOUT_ID = "layoutid";
    private static final String POSITION = "position";
    private static final String ARG_SECTION_NUMBER = "section_number";
    private static int position;

    public static ViewPagerFragment newInstance(int layoutId, int position, int section_number) {
        ViewPagerFragment.position = position;
        ViewPagerFragment pane = new ViewPagerFragment();
        Bundle args = new Bundle();
        args.putInt(LAYOUT_ID, layoutId);
        args.putInt(POSITION, position);
        args.putInt(ARG_SECTION_NUMBER, section_number);
        pane.setArguments(args);
        return pane;
    }
 
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final int resource = getArguments().getInt(LAYOUT_ID, -1);
        ViewGroup rootView = (ViewGroup) inflater.inflate(resource, container, false);

        int sectionNumber = getArguments().getInt(ARG_SECTION_NUMBER);

        int position = getArguments().getInt(POSITION);

        String text = "";

        if (sectionNumber == 1){
            if (position == 0){
                text = "A";
            } else if (position == 1){
                text = "B";
            } else if (position == 2){
                text = "C";
            }
        } else if (sectionNumber == 2){
            if (position == 0){
                text = "D";
            } else if (position == 1){
                text = "E";
            }
        } else if (sectionNumber == 3){
            text = "F";
        }

        TextView textView = (TextView) rootView.findViewById(R.id.textViewPager);
        textView.setText(text);

        return rootView;
    }
}