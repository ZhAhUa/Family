package com.finance.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

	public DBOpenHelper(Context context)
	{
		super(context, "account.db", null, 1);
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub

		db.execSQL("create table OutCostInfo(OutID integer primary key autoincrement,Money decimal,OutTime varchar(20),OutType varchar(10),Aaddress varchar(100),Depict varchar(200))");
		db.execSQL("create table InCostInfo(InID integer primary key autoincrement,Money decimal,InTime varchar(20),InType varchar(10),Source varchar(50),Depict varchar(200)) ");
		db.execSQL("create table FlagInfo(FlagID integer primary key autoincrement,Flag varchar(200))");
		db.execSQL("create table UsersInfo(UserName varchar(20) primary key ,UserPwd varchar(20))");
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub

	}

}
