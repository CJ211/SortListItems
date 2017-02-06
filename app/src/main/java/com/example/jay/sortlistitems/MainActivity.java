package com.example.jay.sortlistitems;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static android.R.attr.onClick;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    private ArrayList<String> mMonths;
    private Button mAscButton, mDescButton;
    private MyAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = (ListView) findViewById(R.id.lv_main);

        mMonths = new ArrayList<>();

        mMonths.add("JANUARY");
        mMonths.add("FEBRUARY");
        mMonths.add("MARCH");
        mMonths.add("APRIL");
        mMonths.add("MAY");
        mMonths.add("JUNE");
        mMonths.add("JULY");
        mMonths.add("AUGUST");
        mMonths.add("SEPTEMBER");
        mMonths.add("OCTOBER");
        mMonths.add("NOVEMBER");
        mMonths.add("DECEMBER");


        mListAdapter = new MyAdapter();
        mAscButton = (Button) findViewById(R.id.asc);
        mDescButton = (Button) findViewById(R.id.desc);


        mAscButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                Collections.sort(mMonths);
                mListAdapter.notifyDataSetChanged();
            }
        });

        mDescButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){

                Collections.sort(mMonths);
                Collections.reverse(mMonths);
                mListAdapter.notifyDataSetChanged();
            }


        });


        mListView.setAdapter(mListAdapter);


    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mMonths.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup parent) {

            View rowview;

            if (convertView != null) {
                rowview = convertView;
            } else {
                rowview = getLayoutInflater().inflate(R.layout.months_row_view, parent, false);
            }

            TextView monthname = (TextView) rowview.findViewById(R.id.month_list);
            monthname.setText(mMonths.get(i));

            return rowview;
        }
    }
}
