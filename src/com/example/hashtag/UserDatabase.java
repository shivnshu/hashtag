package com.example.hashtag;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class UserDatabase extends SQLiteOpenHelper {

	SQLiteDatabase db;

	public UserDatabase(Context context) {
		super(context, "Database139", null, 1);
		db = getReadableDatabase();
		db = getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("Create table if not exists userinfo(tag text,path text)");
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {

	}

	public void addnewtag(String p, String t) {
		// TODO Auto-generated method stub
		db.execSQL("insert into userinfo values('" + t + "','" + p + "')");
	}

	public String getfiletags(String path) {
		// TODO Auto-generated method stub
		String l="";
		Cursor c = db.rawQuery("select tag from userinfo where path='"+path+"'", null);
		while(c.moveToNext()){
			String s=c.getString(c.getColumnIndex("tag"));	
			l=l+s+",";			
		}
		return l;
	}

	public String getAlltags() {
		// TODO Auto-generated method stub
		String l="";
		Cursor c = db.rawQuery("select tag from userinfo", null);
		while(c.moveToNext()){
			String s=c.getString(c.getColumnIndex("tag"));	
			l=l+s+",";			
		}
		return l;
	}
	
	public void delete(String path,String tag){
		db.execSQL("delete from userinfo where path='"+path+"'AND tag='"+tag+"'");
	}

	public String getAllfiles(String tag) {
		// TODO Auto-generated method stub
		String l="";
		Cursor c = db.rawQuery("select path from userinfo where tag='"+tag+"'", null);
		int i=c.getCount();
		while(c.moveToNext()){
			String s=c.getString(c.getColumnIndex("path"));	
			l=l+s+",";			
		}
		return l;
	}
}
