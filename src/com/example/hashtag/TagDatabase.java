package com.example.hashtag;

import java.io.File;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TagDatabase extends SQLiteOpenHelper{
	SQLiteDatabase db;
	public TagDatabase(Context context) {
		// TODO Auto-generated constructor stub
		super(context, "TagDatabaseD", null, 1);
		db = getReadableDatabase();
		db = getWritableDatabase();
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL("Create table if not exists taginfo(tag text,file text)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public void addnewtag(String file1,String tag1) {
		// TODO Auto-generated method stub
		db.execSQL("insert into taginfo values('" + tag1 + "','" + file1 + "')");
	}

}
