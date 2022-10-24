package com.example.newsclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    TabItem thome,tStyle,tSport,tTech,tBusiness,tScience,tMagazine;
    PagerAdapter pagerAdapter;
    Toolbar ttoolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWidget();

    }

    public void getWidget(){
        ttoolbar = findViewById(R.id.toolbar);
        setSupportActionBar(ttoolbar);

        thome=findViewById(R.id.home);
        tStyle=findViewById(R.id.style);
        tSport=findViewById(R.id.sport);
        tTech =findViewById(R.id.tech);
        tBusiness=findViewById(R.id.business);
        tScience=findViewById(R.id.science);
        tMagazine=findViewById(R.id.magazine);

        ViewPager viewPager = findViewById(R.id.container);
        tabLayout=findViewById(R.id.included);

        pagerAdapter= new PagerAdapter(getSupportFragmentManager(),7);
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0||tab.getPosition()==1||tab.getPosition()==2||tab.getPosition()==3||tab.getPosition()==4||tab.getPosition()==5||tab.getPosition()==6)
                {
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}