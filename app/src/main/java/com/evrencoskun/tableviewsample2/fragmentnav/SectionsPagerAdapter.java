package com.evrencoskun.tableviewsample2.fragmentnav;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.evrencoskun.tableviewsample2.R;

/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    enum TabType {
        QR_SCAN,
        MATCH_STRATEGY,
        MATCH_PREDICTION,
        RAW_DATA_VISUALIZATION,
        PIT_DATA_VISUALIZATION,
        QUALITATIVE_DATA_VISUALIZATION,
        PICK_LIST
    }
    @StringRes
    private static final int[] TAB_TITLES = new int[] {R.string.tab_text_1, R.string.tab_text_2, R.string.tab_text_3, R.string.tab_text_4, R.string.tab_text_5, R.string.tab_text_6, R.string.tab_text_7};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        TabType tabType = TabType.values()[position];
        switch (tabType) {
            case QR_SCAN:
                return QRScanFragment.newInstance();
            case MATCH_STRATEGY:
                return PlaceholderFragment.newInstance(1);
            case MATCH_PREDICTION:
                return PlaceholderFragment.newInstance(2);
            case RAW_DATA_VISUALIZATION:
                return PlaceholderFragment.newInstance(3);
            case PIT_DATA_VISUALIZATION:
                return PlaceholderFragment.newInstance(4);
            case QUALITATIVE_DATA_VISUALIZATION:
                return PlaceholderFragment.newInstance(5);
            case PICK_LIST:
                return PlaceholderFragment.newInstance(6);
        }
        return QRScanFragment.newInstance();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 4 total pages.
        return 4;
    }
}