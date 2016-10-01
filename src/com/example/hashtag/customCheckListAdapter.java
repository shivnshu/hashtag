package com.example.shivnshu.hashtag;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shivnshu.test.MainActivity;
import com.example.shivnshu.test.R;

import static com.example.shivnshu.test.MainActivity.prgmImages;

public class customCheckListAdapter extends BaseAdapter {

    String [] result;
    private static LayoutInflater inflater=null;
    public customCheckListAdapter(MainActivity context, String[] prgmNameList) {
        // TODO Auto-generated constructor stub
        result=prgmNameList;

        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public class Holder
    {
        TextView tv;
        CheckBox cb;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.customCheckList, null);
        holder.tv=(TextView) rowView.findViewById(R.id.textView);
        holder.cb = (CheckBox)rowView.findViewById(R.id.cb);

        holder.tv.setText(result[position]);
        holder.cb.setChecked(false);

        return rowView;
    }

}