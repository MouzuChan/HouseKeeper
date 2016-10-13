package com.itedu.accoutsoft.dao;

import android.database.sqlite.SQLiteDatabase;
import android.test.AndroidTestCase;

public class TestCase extends AndroidTestCase {
	
	public void yes(){
		DBOpenHelper sb=new DBOpenHelper(getContext());
		SQLiteDatabase sd= sb.getWritableDatabase();
	}
	
	public void insert(){
		DBOpenHelper sb=new DBOpenHelper(getContext());
		SQLiteDatabase sd=sb.getWritableDatabase();
		
		sd.execSQL("insert into tb_pwd(password) values (?)", 
				new Object[]{"123"});
	}
	
	public void testSelect(){
		DBOpenHelper sb=new DBOpenHelper(getContext());
		SQLiteDatabase sd=sb.getWritableDatabase();
		PwdDAO pd=new PwdDAO(getContext());
		String password=pd.find().getPassword();
		System.out.println(password);
	}

}
