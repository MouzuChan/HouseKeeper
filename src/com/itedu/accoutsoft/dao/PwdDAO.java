package com.itedu.accoutsoft.dao;

import com.itedu.accoutsoft.entity.Tb_Pwd;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PwdDAO {
	private DBOpenHelper db;
	public PwdDAO(Context context){
		db=new DBOpenHelper(context);
	}
	
	public Tb_Pwd find(){
		SQLiteDatabase sd=
				db.getWritableDatabase();
		
		Cursor cursor
				=sd.rawQuery("select * from tb_pwd", null);
		
		while(cursor.moveToNext()){
			String mPwd=cursor.getString(0);
			return new Tb_Pwd(mPwd);
		}
		return null;
	}
}
