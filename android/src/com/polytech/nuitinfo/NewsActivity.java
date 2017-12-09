package com.polytech.nuitinfo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import java.util.Arrays;

/**
 Created by alexandre on 07/12/2017.
 */

public class NewsActivity extends AppCompatActivity
{
    @Override
    protected void onCreate (Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
    
        String[] headers = getResources().getStringArray(R.array.Headers);
        String[] contents = getResources().getStringArray(R.array.Content);
        
        NewsAdapter adapter = new NewsAdapter(this, Arrays.asList(headers), Arrays.asList(contents));
        
        ExpandableListView listView = findViewById(R.id.expandListView);
        listView.setAdapter(adapter);
        
    }
}
