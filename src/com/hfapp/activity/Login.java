package com.hfapp.activity;
/**
 * ������������ ������������������ ����������
 */
import com.example.config.Userconfig;
import com.example.palytogether.R;
import com.hf.module.ModuleConfig;
import com.hfapp.work.InitThread;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends Activity implements OnClickListener{
	private EditText userName;
	private EditText userPswd;
	private ImageButton forgotPswd;
	private ImageButton regist;
	private Button loginBtn;
	private TextView config;
	private Handler hand = new Handler(){
		public void handleMessage(android.os.Message msg) {
			switch (msg.what) {
			case 0:
				Toast.makeText(Login.this, "login err", Toast.LENGTH_SHORT).show();
				break;
			case 5: //��������������
				//Toast.makeText(Login.this, "", Toast.LENGTH_SHORT).show();
				break;
			case 2: //��������
				//Toast.makeText(Login.this, "��������", Toast.LENGTH_SHORT).show();
				break;
			case 3: //��������
				startModuleListActivity();
				Toast.makeText(Login.this, "login ok", Toast.LENGTH_SHORT).show();
				break;
			case 4: //��������
//				startModuleListActivity();
				//Toast.makeText(Login.this, "����������", Toast.LENGTH_SHORT).show();
				break;
			case -103:
				//Toast.makeText(Login.this, "������������", Toast.LENGTH_SHORT).show();
				break;
			case -101:
				//Toast.makeText(Login.this, "��������", Toast.LENGTH_SHORT).show();
				break;
			default:
				break;
			}
		};
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_layout);
		initView();
	}
	
	private void initView(){
		userName = (EditText) findViewById(R.id.user_name);
		userPswd = (EditText) findViewById(R.id.user_pswd);
		forgotPswd = (ImageButton) findViewById(R.id.forget_pswd);
		regist = (ImageButton) findViewById(R.id.regist);
		loginBtn = (Button) findViewById(R.id.login_btn);
		config = (TextView) findViewById(R.id.configconfig);
		forgotPswd.setOnClickListener(this);
		regist.setOnClickListener(this);
		loginBtn.setOnClickListener(this);
		config.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i = new Intent(Login.this,ConfigSetting.class);
				startActivity(i);
			}
		});
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if(v.getId() == R.id.forget_pswd){
			doForgotPswd();
		}else if(v.getId() == R.id.regist){
			doRegist();
		}else if(v.getId() == R.id.login_btn){
			doLogin();
		}
	}
	
	
	private void doLogin(){
		ModuleConfig.cloudUserName = userName.getText().toString().trim();
		ModuleConfig.cloudPassword = userPswd.getText().toString().trim();
		if(checkInPut()){
			new Thread(new InitThread(hand)).start();
		}
	}
	
	private boolean checkInPut(){
			if(ModuleConfig.cloudUserName == null||ModuleConfig.cloudUserName.length()<4){
				hand.sendEmptyMessage(5);
				return false;
			}else if(ModuleConfig.cloudPassword == null||ModuleConfig.cloudPassword.length()<4){
				hand.sendEmptyMessage(2);
				return false;
			}
		return true;
	}
	private void doRegist(){
		Intent i = new Intent(this, Regist.class);
		startActivity(i);
		overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
		finish();
		
	}
	
	private void doForgotPswd(){
		
	}
	
	private void startModuleListActivity(){
		Intent i = new Intent(this,ModuleList.class);
		startActivity(i);
		overridePendingTransition(R.anim.in_from_right, R.anim.out_to_left);
		finish();
	}
}
