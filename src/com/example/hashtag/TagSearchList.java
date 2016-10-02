package com.example.hashtag;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class TagSearchList extends Activity {
	static int i=1;
	ListView l;
	UserDatabase db;
	customlistviewadapter adapter;
	ArrayList<String> ad;
	List<String>t1 = new ArrayList<String>();
	List<String>t2 = new ArrayList<String>();
	List<String>t3 = new ArrayList<String>();
	List<String>path = new ArrayList<String>();
	List<File>filearg = new ArrayList<File>();
	List<Integer>img = new ArrayList<Integer>();
	List<String>t1f = new ArrayList<String>();
	List<String>t2f = new ArrayList<String>();
	List<String>t3f = new ArrayList<String>();
	List<Integer>imgf = new ArrayList<Integer>();
	List<String>pathf = new ArrayList<String>();
	List<File>fileargf = new ArrayList<File>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tag_search_list);
		l=(ListView)findViewById(R.id.tagsearchlistView1);
		db=new UserDatabase(this);
		String res=db.getAllfiles(getIntent().getExtras().getString("tag"));	
		Toast.makeText(getApplicationContext(), res, Toast.LENGTH_LONG).show();
		ArrayList<String> adt = new ArrayList<String>(Arrays.asList(res.split("\\s*,\\s*")));
		if(adt.size()!=0){
			File[] fi=new File[adt.size()];
			for(int i=0;i<adt.size();i++){
				fi[i]=new File(adt.get(i).toString().trim());
			}
			fill(fi);
		}
	}

	private void fill(File[] dirs) {
		  t1.clear();
		  t2.clear();
		  t3.clear();
		  t1f.clear();
		  t2f.clear();
		  t3f.clear();
		  img.clear();
		  imgf.clear();	
		  path.clear();
		  pathf.clear();
		  filearg.clear();
		  fileargf.clear();
		 try{		     
			 for(File ff: dirs){				 
				 Date lastModDate = new Date(ff.lastModified()); 
				 DateFormat formater = DateFormat.getDateTimeInstance();
			     String date_modify = formater.format(lastModDate);			     
			     String name=ff.getName();			     
			     String p=ff.getAbsolutePath();
			     File fp=ff;
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
						
						t1.add(name);
						t2.add(num_item);
						t3.add(date_modify);
						img.add(0);
						path.add(p);
						filearg.add(fp);
				}
				else{		
					String num_item = ff.length()+ " bytes";
					t1f.add(name);
					t2f.add(num_item);
					t3f.add(date_modify);
					imgf.add(1);	
					pathf.add(p);
					fileargf.add(fp);
				}
			 }
		 }
		 catch(Exception e){			 
		 }
		 t1.addAll(t1f);
		 t2.addAll(t2f);
		 t3.addAll(t3f);
		 img.addAll(imgf);
		 path.addAll(pathf);
		 filearg.addAll(fileargf);
		 if(i!=1){
			File f=new File(dirs[0].getParent());
		 if(!f.getName().equalsIgnoreCase("sdcard0")){
			 t1.add(0,"back");
			 t2.add(0,"..");
			 t3.add(0,"..");
			 img.add(0,2);
			 path.add(0,f.getParent());
		 }
		 }
		 i++;
		 adapter = new customlistviewadapter(TagSearchList.this,t1,t2,t3,img);		 
		 l.setAdapter(adapter); 
		 l.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
			   if(img.get(arg2)==0||img.get(arg2)==2){
					File currentdir = new File(path.get(arg2));
					fill(currentdir.listFiles());
					//Toast.makeText(getApplicationContext(), arg2, Toast.LENGTH_LONG).show();
				}
				else{
					Toast.makeText(getApplicationContext(), t1.get(arg2).toString(), Toast.LENGTH_LONG).show();
				}
			}
			 
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tag_search_list, menu);
		return true;
	}

}
