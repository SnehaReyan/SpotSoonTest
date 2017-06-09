package com.example.dell.spotsoontest;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ViewListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class NavHomeFragment extends Fragment {

    CarouselView customCarouselView;
    private int[] sampleImages={R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4};
    private String[] sampleTitles={"Chain Smoker new album 2016","Chain Smoker new album 2016","Chain Smoker new album 2016","Chain Smoker new album 2016"};

    public NavHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_nav_home, container, false);

        final TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tablayout);
        final ViewPager viewPager = (ViewPager)view.findViewById(R.id.viewpager);

        tabLayout.setupWithViewPager(viewPager);

        TabPagerAdapter tabPagerAdapter = new TabPagerAdapter(getFragmentManager());

        tabPagerAdapter.addfragment(new VideosFragment());
        tabPagerAdapter.addfragment(new ImagesFragment());
        tabPagerAdapter.addfragment(new MileStoneFragment());
        viewPager.setAdapter(tabPagerAdapter);

        tabLayout.getTabAt(0).setIcon(R.drawable.video).setText("Videos");
        tabLayout.getTabAt(1).setIcon(R.drawable.images).setText("Images");
        tabLayout.getTabAt(2).setIcon(R.drawable.milestone).setText("MileStone");
        tabLayout.getTabAt(0).select();


        customCarouselView = (CarouselView) view.findViewById(R.id.customCarouselView);

        customCarouselView.setPageCount(sampleImages.length);
        customCarouselView.setSlideInterval(4000);

        ViewListener viewListener = new ViewListener() {
            @Override
            public View setViewForPosition(int position) {

                View customView = inflater.inflate(R.layout.item_coverflow, null);

                TextView labelTextView = (TextView) customView.findViewById(R.id.label);
                ImageView imageView = (ImageView) customView.findViewById(R.id.image);

                imageView.setImageResource(sampleImages[position]);
                labelTextView.setText(sampleTitles[position]);

                return customView;
            }
        };
        customCarouselView.setViewListener(viewListener);

        return view;
    }

}
