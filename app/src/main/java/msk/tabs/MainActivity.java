package msk.tabs;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.main_tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.main_pager);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        sectionsPagerAdapter.addFragment(new PageOne(), "Page One", android.R.drawable.ic_lock_lock);
        sectionsPagerAdapter.addFragment(new PageTwo(), "", android.R.drawable.ic_popup_sync);
        sectionsPagerAdapter.addFragment(new PageThree(), "Page Three", android.R.drawable.ic_media_play);
        sectionsPagerAdapter.addFragment(new PageFour(), "", android.R.drawable.ic_popup_disk_full);
        sectionsPagerAdapter.addFragment(new PageFive(), "Page Five", android.R.drawable.ic_input_get);

        pager.setAdapter(sectionsPagerAdapter);
        pager.setOffscreenPageLimit(pager.getAdapter().getCount());

        tabLayout.setupWithViewPager(pager);

        for (int i = 0; i < pager.getAdapter().getCount(); i++)
            tabLayout.getTabAt(i).setIcon(sectionsPagerAdapter.getPageIcon(i));
    }

    private class SectionsPagerAdapter
            extends FragmentPagerAdapter { // FragmentStatePagerAdapter will not keep fragments in memory

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        private final List<Integer> mFragmentIconList = new ArrayList<>();

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        void addFragment(Fragment fragment, String title, int icon) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
            mFragmentIconList.add(icon);
        }

        int getPageIcon(int position) { return mFragmentIconList.get(position); }
    }
}
