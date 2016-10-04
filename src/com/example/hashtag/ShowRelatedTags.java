package com.example.hashtag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class ShowRelatedTags extends Activity {
	UserDatabase db;
	ListView l;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_related_tags);
		l=(ListView)findViewById(R.id.showretagslistview);		
		db=new UserDatabase(this);
		Bundle b=getIntent().getExtras();
		String path=b.getString("file_path");
		String res=db.getfiletags(path);
		ArrayList<String> ad = new ArrayList<String>(Arrays.asList(res.split("\\s*,\\s*")));
		if(ad.size()==0){
			Toast.makeText(getApplicationContext(), "No tags attached to File/Folder", Toast.LENGTH_SHORT).show();
		}
		else{
		ArrayAdapter<String> a = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,ad);
		l.setAdapter(a);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_related_tags, menu);
		return true;
	}

}
