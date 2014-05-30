package com.hfapp.activity;

import com.example.palytogether.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class AddNavActivity extends Activity{
	private Button nextStep;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_nav_layout);
		initView();
	}
	private void initView() {
		// TODO Auto-generated method stub
		nextStep = (Button) findViewById(R.id.next_step);
		nextStep.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(AddNavActivity.this,Smartlink.class);
				startActivity(i);
				finish();
			}
		});
	}
}