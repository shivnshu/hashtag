package com.example.hashtag;

import java.io.File;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Toast;

public class Addexistingtag extends Activity {
	ListView l;
	UserDatabase db;
	customchecklistadapter adapter1;
	ArrayList<String> ad;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_addexistingtag);
		l=(ListView)findViewById(R.id.addetaglistView1);
		db=new UserDatabase(this);
		String res=db.getAlltags();		
		ArrayList<String> adt = new ArrayList<String>(Arrays.asList(res.split("\\s*,\\s*")));
		TreeSet<String> t=new TreeSet<String>(adt);
		ad = new ArrayList<String>(t);
		//ArrayAdapter<String> a = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,ad);
		//l.setAdapter(a);
		adapter1=new customchecklistadapter(getApplicationContext(), ad);
		l.setAdapter(adapter1);		
		l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View v, int i,
					long arg3) {
				// TODO Auto-generated method stub
				CheckBox cb = (CheckBox) v.findViewById(R.id.cb);
				cb.performClick();
				if (!cb.isChecked()) {
					db.delete(getIntent().getExtras().getString("file_path"), ad.get(i));
				} else  {
					db.addnewtag(getIntent().getExtras().getString("file_path"),ad.get(i));
			    }
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.addexistingtag, menu);
		
		return true;
	}
	@Override  
    public boolean onOptionsItemSelected(MenuItem item) {  
        switch (item.getItemId()) {  
            case R.id.action_settings:  {
            	Toast.makeText(getApplicationContext(),"settings Selected",Toast.LENGTH_LONG).show();  
                return true;  
            }                 
           case R.id.addetagmngtags: {
               finish();
               return true;  
           }                 
              default:  
                return super.onOptionsItemSelected(item);  
        }  
    }  

}
