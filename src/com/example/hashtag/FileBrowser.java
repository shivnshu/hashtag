package com.example.hashtag;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FileBrowser extends Activity {

	File currentdir;
	customlistviewadapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_file_browser);
		currentdir=new File("/sdcard/");
		fill(currentdir);
	}

	private void fill(File f) {
		// TODO Auto-generated method stub
	     File[]  dirs = f.listFiles(); 
		 //this.setTitle("Current Dir: "+f.getName());
		 List<String>t1 = new ArrayList<String>();
		 List<String>t2 = new ArrayList<String>();
		 List<String>t3 = new ArrayList<String>();
		 List<String>img = new ArrayList<String>();
		 List<String>t1f = new ArrayList<String>();
		 List<String>t2f = new ArrayList<String>();
		 List<String>t3f = new ArrayList<String>();
		 List<String>imgf = new ArrayList<String>();
		 try{
			 for(File ff: dirs){
				 Date lastModDate = new Date(ff.lastModified()); 
				 DateFormat formater = DateFormat.getDateTimeInstance();
			     String date_modify = formater.format(lastModDate);
			     String name=ff.getName();
			     String path=ff.getAbsolutePath();
			     if(ff.isDirectory()){
			    	 	File[] fbuf = ff.listFiles(); 
						int buf = 0;
						if(fbuf != null){ 
							buf = fbuf.length;
						} 
						else{ 
							buf = 0;
						} 
						String num_item = String.valueOf(buf);
						num_item = num_item + " items";
						String imgi="dir";
						t1.add(name);
						t2.add(num_item);
						t3.add(date_modify);
						img.add(imgi);
				}
				else{		
					String num_item = ff.length()+ " bytes";
					String imgi="file";
					t1f.add(name);
					t2f.add(num_item);
					t3f.add(date_modify);
					imgf.add(imgi);						
				}
			 }
		 }
		 catch(Exception e){			 
		 }
		 Collections.sort(t1);
		 Collections.sort(t2);
		 Collections.sort(t3);
		 Collections.sort(t1f);
		 Collections.sort(t1f);
		 Collections.sort(t1f);
		 Collections.sort(img);
		 Collections.sort(imgf);
		 t1.addAll(t1f);
		 t2.addAll(t2f);
		 t3.addAll(t3f);
		 img.addAll(imgf);
		 adapter = new customlistviewadapter(FileBrowser.this,t1,t2,t3,img);
		 
		// this.setListAdapter(adapter); 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.file_browser, menu);
		return true;
	}

}
