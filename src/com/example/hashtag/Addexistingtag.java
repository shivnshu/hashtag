package com.example.hashtag;

import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Addexistingtag extends Activity {
	ListView l;
	UserDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addexistingtag);
		l=(ListView)findViewById(R.id.addetaglistView1);
		db=new UserDatabase(this);
		String res=db.getAlltags();		
		ArrayList<String> adt = new ArrayList<String>(Arrays.asList(res.split("\\s*,\\s*")));
		TreeSet<String> t=new TreeSet<String>(adt);
		ArrayList<String> ad = new ArrayList<String>(t);
		ArrayAdapter<String> a = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,ad);
		l.setAdapter(a);
		l.setBackgroundColor(Color.GRAY);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.addexistingtag, menu);
		return true;
	}

}
