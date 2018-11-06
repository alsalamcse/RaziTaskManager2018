package razimograbi.razitaskmanager2018;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import razimograbi.razitaskmanager2018.taskfragments.MyTasksFragment;
import razimograbi.razitaskmanager2018.taskfragments.ProfileFragment;
import razimograbi.razitaskmanager2018.taskfragments.TasksHistoryFragment;
import razimograbi.razitaskmanager2018.taskfragments.dummy.AddTaskActivity;

public class MainTabsActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;


    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_tabs);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        // build adapter
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        // viewpager = shows the pages of the fragments
        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
                Intent i = new Intent(getApplicationContext() , AddTaskActivity.class);
                startActivity(i);
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_tabs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main_tabs, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    // build the FragmentAdapter class that extends FragmentPagerAdapter

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        MyTasksFragment myTasksFragment;
        TasksHistoryFragment historyFragment;
        ProfileFragment profileFragment;

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // for every adpater there is a get the get returns the object 7sb the position
        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            if (position == 0){
                if (myTasksFragment == null){
                    myTasksFragment = new MyTasksFragment(title, text, date, skbImportant.getProgress(), skbNecessary.getProgress());
                }

                return myTasksFragment;
            }
            if (position == 1){
                if (historyFragment == null){
                    historyFragment = new TasksHistoryFragment();
                }
                return historyFragment;
            }
            if (position == 2){
                if (profileFragment == null){
                    profileFragment = new ProfileFragment();
                }
                return profileFragment;
            }
            return PlaceholderFragment.newInstance(position + 1);
        }
        // returns fragment number
        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        //returns 3nwan every fragment
        @Override
        public CharSequence getPageTitle(int position) {
            if (position == 0){
                return "Tasks";
            }
            if (position == 1){
                return "History";
            }
            if (position == 2){
                return "Profile";
            }
            return "NoName";
        }
    }
}
