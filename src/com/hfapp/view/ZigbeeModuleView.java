package com.hfapp.view;

import java.util.HashMap;

import com.hf.module.info.GPIO;
import com.hf.module.info.ModuleInfo;
import com.hfapp.activity.ZigbeeModuleInfoActivity;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;

public class ZigbeeModuleView extends BaseModuleView{

	public ZigbeeModuleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
	}

	public ZigbeeModuleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public ZigbeeModuleView(Context context, boolean which) {
		super(context, which);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void updateStatus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initView() {
		// TODO Auto-generated method stub
		super.initView();
		moduleImage.setOnLongClickListener(new OnLongClickListener() {
			
			@Override
			public boolean onLongClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getContext(),ZigbeeModuleInfoActivity.class);
				i.putExtra("mac", m_moduleinfo.getMac());
				getContext().startActivity(i);
				return false;
			}
		});
	}

	@Override
	public void onEvent(String mac, byte[] t2data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCloudLogin(boolean loginstat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onCloudLogout() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onNewDevFind(ModuleInfo mi) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onGPIOEvent(String mac, HashMap<Integer, GPIO> GM) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTimerEvent(String mac, byte[] t2data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUARTEvent(String mac, byte[] userData, boolean chanle) {
		// TODO Auto-generated method stub
		
	}
	
	
}
