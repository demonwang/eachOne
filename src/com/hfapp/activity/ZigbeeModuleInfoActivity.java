package com.hfapp.activity;

import com.example.palytogether.R;
import com.hf.module.impl.LocalModuleInfoContainer;
import com.hf.module.info.ModuleInfo;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class ZigbeeModuleInfoActivity extends Activity implements OnClickListener{
	private ImageView icon;
	private ImageView scene_ctrl;
	private ImageView light_ctrl;
	private ImageView sys_ctrl;
	private ImageView help;
	private ModuleInfo mi;
	private String mac;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zigbee_info_activity);
		mac = getIntent().getStringExtra("mac");
		mi = LocalModuleInfoContainer.getInstance().get(mac);
		initActionbar();
		initView();
	}
	
	private void initActionbar() {
		// TODO Auto-generated method stub
		ActionBar bar = getActionBar();
		bar.setCustomView(R.layout.layout_actionbar);
		bar.setDisplayShowCustomEnabled(true);
		bar.setDisplayShowHomeEnabled(false);
		bar.setDisplayShowTitleEnabled(false);
		ImageView backBtn = (ImageView) findViewById(R.id.back);
		ImageView okBtn = (ImageView) findViewById(R.id.ok);
		TextView title = (TextView) findViewById(R.id.tv_title);
		title.setText(R.string.moduleinfo);
		okBtn.setVisibility(View.INVISIBLE);
		backBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				finish();
			}
		});
	}
	
	public void initView(){
		icon = (ImageView) findViewById(R.id.zigbee_icon);
		scene_ctrl = (ImageView) findViewById(R.id.scene_ctrl);
		light_ctrl = (ImageView) findViewById(R.id.light_ctrl);
		sys_ctrl = (ImageView) findViewById(R.id.sys_ctrl);
		help = (ImageView) findViewById(R.id.helper);
		icon.setOnClickListener(this);
		scene_ctrl.setOnClickListener(this);
		light_ctrl.setOnClickListener(this);
		sys_ctrl.setOnClickListener(this);
		help.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		Intent i = new Intent();
		i.putExtra("mac", mi.getMac());
		switch (v.getId()) {
		case R.id.zigbee_icon:
			break;
		case R.id.scene_ctrl:
			break;
		case R.id.light_ctrl:
			i.setClass(this, LightCtrl.class);
			startActivity(i);
			break;
		case R.id.sys_ctrl:
			i.setClass(this, SystemCtrl.class);
			startActivity(i);
			break;
		case R.id.helper:
			break;
		default:
			break;
		}
	}
}
