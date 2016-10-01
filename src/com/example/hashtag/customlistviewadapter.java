package com.example.hashtag;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

public class customlistviewadapter extends BaseAdapter  {

	String [] result1;
	String [] result2;
	String [] result3;
	int [] img1;

	public customlistviewadapter(Context context,List<String> t1,List<String> t2,List<String> t3,List<String> img ) {
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
		return result1.length;
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
		holder.img = (TextView)rowView.findViewById(R.id.img);

		holder.t1.setText(result1[position]);
		holder.t2.setText(result2[position]);
		holder.t3.setText(result3[position]);

		holder.img.setImageResource(img1[position]);

		return rowView;

	}

}
