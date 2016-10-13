package com.itedu.accoutsoft;

import com.itedu.accoutsoft.dao.PwdDAO;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	
	EditText et_login;
	Button btn_ok,btn_cancel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		et_login =(EditText) findViewById(R.id.et_login);
		btn_ok =(Button) findViewById(R.id.btn_ok);
		btn_cancel =(Button) findViewById(R.id.btn_cancel);
		
		btn_cancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
		
		btn_ok.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String etText = et_login.getText().toString();
				PwdDAO pwd=new PwdDAO(LoginActivity.this);
				if("".equals(etText)){
					Toast.makeText(LoginActivity.this,
							"√‹¬ÎŒ™ø’£¨≤ªƒ‹µ«¬º£¨«Î ‰»Î√‹¬Î£°", 0).show();
					return ;
					}
				if(!etText.equals(pwd.find().getPassword())){
					Toast.makeText(LoginActivity.this,
							"√‹¬Î¥ÌŒÛ£°", 0).show();
					return ;
				}
				if(etText.equals(pwd.find().getPassword())){
					Toast.makeText(LoginActivity.this,
							"√‹¬Î’˝»∑£¨πßœ≤ƒ„£°", 0).show();
					Intent intent =new Intent(LoginActivity.this,MainActivity.class);
					startActivity(intent);
				}
			   }
			});
		}
	}
