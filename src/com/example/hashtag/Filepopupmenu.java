package com.example.hashtag;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Filepopupmenu extends Activity {
	ListView l;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filepopupmenu);
		l=(ListView)findViewById(R.id.listViewpopup);
		ArrayList<String> ad = new ArrayList<String>();
		ad.add("Add a new tag");
		ad.add("Remove tags");
		ad.add("Add an existing tag");
		ad.add("Show Related tags");
		ArrayAdapter<String> a = new ArrayAdapter<String>(
				getApplicationContext(), android.R.layout.simple_list_item_1,
				ad);
		l.setAdapter(a);
		l.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filepopupmenu, menu);
		return true;
	}

}
