package com.example.hashtag;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.List;



import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

public class Filebrowserselect extends Activity {
	File currentdir;
	customcheckviewadapter adapter;
	ListView l;
	List<String>t1 = new ArrayList<String>();
	List<String>t2 = new ArrayList<String>();
	List<String>t3 = new ArrayList<String>();
	List<String>path = new ArrayList<String>();
	List<Integer>img = new ArrayList<Integer>();
	List<String>t1f = new ArrayList<String>();
	List<String>t2f = new ArrayList<String>();
	List<String>t3f = new ArrayList<String>();
	List<Integer>imgf = new ArrayList<Integer>();
	List<String>pathf = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_filebrowserselect);
		l=(ListView)findViewById(R.id.listView2);
		Bundle b=getIntent().getExtras();		
		String path=b.getString("path");
		currentdir=new File(path);		
		fill(currentdir);
	}
	private void fill(File f) {
		// TODO Auto-generated method stub
	     File[]  dirs = f.listFiles(); 
	     //Toast.makeText(getApplicationContext(),"jj "+dirs.length,Toast.LENGTH_LONG).show();
		 //this.setTitle("Current Dir: "+f.getName());
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
		 try{		     
			 for(File ff: dirs){				 
				 Date lastModDate = new Date(ff.lastModified()); 
				 DateFormat formater = DateFormat.getDateTimeInstance();
			     String date_modify = formater.format(lastModDate);			     
			     String name=ff.getName();			     
			     String p=ff.getAbsolutePath();
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
						int imgi=0;
						t1.add(name);
						t2.add(num_item);
						t3.add(date_modify);
						img.add(imgi);
						path.add(p);
				}
				else{		
					String num_item = ff.length()+ " bytes";
					int imgi=1;
					t1f.add(name);
					t2f.add(num_item);
					t3f.add(date_modify);
					imgf.add(imgi);	
					pathf.add(p);
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
		 adapter = new customcheckviewadapter(Filebrowserselect.this,t1,t2,t3,img);		 
		 l.setAdapter(adapter);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.filebrowserselect, menu);
		return true;
	}
	@Override  
    public boolean onOptionsItemSelected(MenuItem item) {  
        switch (item.getItemId()) {  
            case R.id.action_settings:  
              Toast.makeText(getApplicationContext(),"settings Selected",Toast.LENGTH_LONG).show();  
            return true;     
           case R.id.manage_tags: /*{
        	   PopupMenu p = new PopupMenu(Filebrowserselect.this, l);
				p.getMenuInflater().inflate(R.menu.manage_tags_menu, p.getMenu());
				p.setOnMenuItemClickListener(new OnMenuItemClickListener() {

					@Override
					public boolean onMenuItemClick(MenuItem arg0) {
						// TODO Auto-generated method stub
						if (arg0.getTitle().equals("add_tags")) {
							Toast.makeText(getApplicationContext(),
									"item 1 selected", Toast.LENGTH_LONG)
									.show();
						}
						if (arg0.getTitle().equals("remove_tags")) {
							Toast.makeText(getApplicationContext(),
									"item 2 selected", Toast.LENGTH_LONG)
									.show();
						}
						return false;
					}
				});
				p.show();*/
        	   Toast.makeText(getApplicationContext(),"mange tags Selected",Toast.LENGTH_LONG).show();  
		
               return true; 
                             
              default:  
                return super.onOptionsItemSelected(item);  
        }  
    }  

}
