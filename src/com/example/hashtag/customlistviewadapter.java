package com.example.hashtag;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class customlistviewadapter extends BaseAdapter  {

	List<String> result1;
	List<String> result2;
	List<String> result3;
	List<Integer> img1;
	LayoutInflater inflater=null;

	public customlistviewadapter(Context context,List<String> t1,List<String> t2,List<String> t3,List<Integer> img ) {
		// TODO Auto-generated constructor stub
		result1 = t1;
		result2 = t2;
		result3 = t3;
		img1 = img;
		inflater = ( LayoutInflater )context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return result1.size();
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	public class Holder{
		TextView t1;
		TextView t2;
		TextView t3;
		ImageView img;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		Holder holder = new Holder();
		View rowView;
		rowView = inflater.inflate(R.layout.customlistview, null);
		holder.t1 = (TextView)rowView.findViewById(R.id.t1);
		holder.t2 = (TextView)rowView.findViewById(R.id.t2);
		holder.t3 = (TextView)rowView.findViewById(R.id.t3);
		holder.img = (ImageView)rowView.findViewById(R.id.img);

		//holder.t1.setText(result1[position]);
		//holder.t2.setText(result2[position]);
		//holder.t3.setText(result3[position]);

		//holder.img.setImageResource(img1[position]);
		
		holder.t1.setText(result1.get(position));
		holder.t2.setText(result2.get(position));
		holder.t3.setText(result3.get(position));
		if(img1.get(position)==0){
			holder.img.setImageResource(R.drawable.fclose);
		}
		else{
			holder.img.setImageResource(R.drawable.file);
		}
		
		return rowView;

	}

}
