package com.maple.coupondisplayview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list);
        BaseAdapter arrayAdapter = new ArrayAdapter(this,R.layout.item_list,R.id.name,
                Arrays.asList("美食劵","活动劵","优惠劵","团购劵","外卖劵"));
        mListView.setAdapter(arrayAdapter);
    }
}
