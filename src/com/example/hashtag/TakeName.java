package com.example.hashtag;

import java.io.File;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TakeName extends Activity {
	EditText e;
	Button b1;
	UserDatabase db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_take_name);
		db=new UserDatabase(this);
		Bundle b=getIntent().getExtras();
		final String path=b.getString("file_path");
		//Toast.makeText(getApplicationContext(), path, Toast.LENGTH_SHORT).show();
		e=(EditText)findViewById(R.id.editText1);
		b1=(Button)findViewById(R.id.go);
		b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String s=e.getText().toString().trim();
				db.addnewtag(getIntent().getExtras().getString("file_path"),s);
				//Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.take_name, menu);
		return true;
	}

}
