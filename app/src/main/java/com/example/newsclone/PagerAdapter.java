package com.example.newsclone;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.newsclone.FragmentClass.BusinessFragment;
import com.example.newsclone.FragmentClass.HomeFragment;
import com.example.newsclone.FragmentClass.MaganizeFragment;
import com.example.newsclone.FragmentClass.ScienceFragment;
import com.example.newsclone.FragmentClass.SportFragment;
import com.example.newsclone.FragmentClass.StyleFragment;
import com.example.newsclone.FragmentClass.TechFragment;

public class PagerAdapter extends FragmentPagerAdapter {

    int tabCount;

    public PagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
        tabCount = behavior;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new HomeFragment();
            case 1:
                return new StyleFragment();
            case 2:
                return new SportFragment();
            case 3:
                return new TechFragment();
            case 4:
                return new BusinessFragment();
            case 5:
                return new ScienceFragment();
            case 6:
                return new MaganizeFragment();

            default:
                return  null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}
