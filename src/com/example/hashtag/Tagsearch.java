package com.example.hashtag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeSet;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Tagsearch extends Activity {

	AutoCompleteTextView a;
	Button b;
	UserDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tagsearch);
		a=(AutoCompleteTextView)findViewById(R.id.tagsautoCompleteTextView1);
		b=(Button)findViewById(R.id.tagsbutton1);
		db=new UserDatabase(this);
		String res=db.getAlltags();		
		ArrayList<String> adt = new ArrayList<String>(Arrays.asList(res.split("\\s*,\\s*")));
		TreeSet<String> t=new TreeSet<String>(adt);
		ArrayList<String> ad = new ArrayList<String>(t);
		ArrayAdapter<String> adp=new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, ad);
        a.setAdapter(adp); 
        //a.setBackgroundColor(Color.GRAY);
        a.setThreshold(0);
		b.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "dsfas", Toast.LENGTH_LONG);
				Intent i=new Intent(Tagsearch.this,TagSearchList.class);
				i.putExtra("tag", a.getText().toString().trim());
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tagseaarch, menu);
		return true;
	}

}
