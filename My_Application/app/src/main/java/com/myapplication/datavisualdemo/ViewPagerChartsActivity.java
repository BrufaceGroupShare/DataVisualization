package com.myapplication.datavisualdemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import lecho.lib.hellocharts.gesture.ContainerScrollType;
import lecho.lib.hellocharts.gesture.ZoomType;
import lecho.lib.hellocharts.model.Axis;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.LineChartData;
import lecho.lib.hellocharts.model.PointValue;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.LineChartView;

public class ViewPagerChartsActivity extends AppCompatActivity {


    static List<PointValue> values;



    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every loaded fragment in memory. If this becomes too
     * memory intensive, it may be best to switch to a {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager_charts);

        // Set up the action bar.
        final ActionBar actionBar = getSupportActionBar();
        //actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        // When swiping between different sections, select the corresponding
        // tab. We can also use ActionBar.Tab#select() to do this if we have
        // a reference to the Tab.
        mViewPager.setOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                //actionBar.setSelectedNavigationItem(position);
            }
        });

        // For each of the sections in the app, add a tab to the action bar.
        for (int i = 0; i < mSectionsPagerAdapter.getCount(); i++) {
            // Create a tab with text corresponding to the page title defined by
            // the adapter. Also specify this Activity object, which implements
            // the TabListener interface, as the callback (listener) for when
            // this tab is selected.
            //actionBar.addTab(actionBar.newTab().setText(mSectionsPagerAdapter.getPageTitle(i)).setTabListener(this));
        }

        ////////////Read file///////////////
        /*


        // write text to file

        // add-write text into file
        try {
            FileOutputStream fileout=openFileOutput("mytextfile.txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write("Data to write");
            outputWriter.close();

            //display file saved message
            Toast.makeText(getBaseContext(), "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        } catch (Exception e) {
            e.printStackTrace();
        }
        */



        //reading text from file
        /*
        int READ_BLOCK_SIZE = 100;
        try {
            FileInputStream fileIn=openFileInput("data.txt");
            InputStreamReader InputRead= new InputStreamReader(fileIn);

            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
                Toast.makeText(getBaseContext(), s, Toast.LENGTH_SHORT).show();
                ///ADD READ DATA TO VALUES ARRAYS///



            }
            InputRead.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            */

        /*
        try {
            FileInputStream fileIn=openFileInput("data.txt");
            BufferedReader myReader = new BufferedReader(new InputStreamReader(fileIn));

            String s="";
            String aDataRow = "";
            long numValues = 0;

            while ((aDataRow = myReader.readLine()) != null) {
                // char to string conversion
                //s += aDataRow;
                //Toast.makeText(getBaseContext(), aDataRow, Toast.LENGTH_SHORT).show();
                ///ADD READ DATA TO VALUES ARRAYS///
                numValues = fileIn.getChannel().size();
                //Toast.makeText(getBaseContext(), Long.toString(numValues), Toast.LENGTH_SHORT).show();

                values = new ArrayList<>();
                for (int i = 0; i < numValues; ++i) {
                    values.add(new PointValue(i, (float) Math.random() * 100f));
                }

            }

            myReader.close();
            Toast.makeText(getBaseContext(), Long.toString(numValues), Toast.LENGTH_SHORT).show();
            values = new ArrayList<>();
            for (int i = 0; i < numValues; ++i) {
                values.add(new PointValue(i, (float) Math.random() * 100f));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        */
        values = new ArrayList<>();
        for (int i = 0; i < 14000; ++i) {
            values.add(new PointValue(i, (float) Math.random() * 100f));
        }





    }
    /*
    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        // When the given tab is selected, switch to the corresponding page in
        // the ViewPager.
        mViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
    }
    */

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_view_pager_charts, container, false);
            RelativeLayout layout = (RelativeLayout) rootView;
            int sectionNum = getArguments().getInt(ARG_SECTION_NUMBER);
            switch (sectionNum) {
                case 1:
                    LineChartView lineChartView = new LineChartView(getActivity());
                    lineChartView.setLineChartData(generateLineChartData());
                    lineChartView.setZoomType(ZoomType.HORIZONTAL);

                    /** Note: Chart is within ViewPager so enable container scroll mode. **/
                    lineChartView.setContainerScrollEnabled(true, ContainerScrollType.HORIZONTAL);

                    layout.addView(lineChartView);
                    break;

            }

            return rootView;
        }

        private LineChartData generateLineChartData() {

            /*
            int numValues = 20;

            List<PointValue> values = new ArrayList<PointValue>();
            for (int i = 0; i < numValues; ++i) {
                values.add(new PointValue(i, (float) Math.random() * 100f));
            }
            */

            Line line = new Line(values);
            line.setColor(ChartUtils.COLOR_GREEN);

            List<Line> lines = new ArrayList<Line>();
            lines.add(line);

            LineChartData data = new LineChartData(lines);
            data.setAxisXBottom(new Axis().setName("Axis X"));
            data.setAxisYLeft(new Axis().setName("Axis Y").setHasLines(true));
            return data;

        }



    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 5;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "LineChart";

            }
            return null;
        }
    }
}
