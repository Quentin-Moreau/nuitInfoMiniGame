package com.polytech.nuitinfo;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

/**
 Created by alexandre on 08/12/2017.
 */

public class NewsAdapter extends BaseExpandableListAdapter
{
    private Context      context;
    private List<String> headers;
    private List<String> contents;
    
    public NewsAdapter (Context context, List<String> headers, List<String> contents)
    {
        this.context = context;
        this.headers = headers;
        this.contents = contents;
    }
    
    @Override
    public int getGroupCount ()
    {
        return headers.size();
    }
    
    @Override
    public int getChildrenCount (int groupPosition)
    {
        return 1;
    }
    
    @Override
    public Object getGroup (int groupPosition)
    {
        return headers.get(groupPosition);
    }
    
    @Override
    public Object getChild (int groupPosition, int childPosition)
    {
        return contents.get(groupPosition);
    }
    
    @Override
    public long getGroupId (int groupPosition)
    {
        return groupPosition;
    }
    
    @Override
    public long getChildId (int groupPosition, int childPosition)
    {
        return childPosition;
    }
    
    @Override
    public boolean hasStableIds ()
    {
        return false;
    }
    
    @Override
    public View getGroupView (int groupPosition, boolean isExpanded, View convertView, ViewGroup parent)
    {
        String groupTitle = (String) getGroup(groupPosition);
        
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.parent_layout, parent, false);
        }
        
        TextView txtParent = convertView.findViewById(R.id.txtParent);
        txtParent.setTypeface(null, Typeface.BOLD);
        txtParent.setText(groupTitle);
        
        return convertView;
    }
    
    @Override
    public View getChildView (int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent)
    {
        String childTitle = (String) getChild(groupPosition, childPosition);
        
        if(convertView == null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.child_layout, parent, false);
        }
        
        TextView txtChild = convertView.findViewById(R.id.txtChild);
        txtChild.setText(childTitle);
        
        return convertView;
    }
    
    @Override
    public boolean isChildSelectable (int groupPosition, int childPosition)
    {
        return false;
    }
}
