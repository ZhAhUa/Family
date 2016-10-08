package com.finance.show;

import com.finance.familyfinance.HomeActivity;
import com.finance.familyfinance.MessageActivity;
import com.finance.familyfinance.R;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.RadioGroup;
import android.widget.TabHost;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class TotalData extends TabActivity {
	
	private TabHost tabHost;  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);  
		 setContentView(R.layout.totaldata);
		 
		 tabHost=this.getTabHost();  
	        TabHost.TabSpec spec;  
	        Intent intent;  
	  
	        intent=new Intent().setClass(this, Total_InList.class);  
	        spec=tabHost.newTabSpec("收入统计").setIndicator("收入统计").setContent(intent);  
	        tabHost.addTab(spec);  
	          
	        intent=new Intent().setClass(this,Total_OutList.class);  
	        spec=tabHost.newTabSpec("支出统计").setIndicator("支出统计").setContent(intent);  
	        tabHost.addTab(spec);  
	        tabHost.setCurrentTab(1);  
	          
	        RadioGroup radioGroup=(RadioGroup) this.findViewById(R.id.main_tab_group); 
	        radioGroup.setOnCheckedChangeListener(new OnCheckedChangeListener() {  
	        @Override  
            public void onCheckedChanged(RadioGroup group, int checkedId) {  
                // TODO Auto-generated method stub  
                switch (checkedId) {  
                case R.id.Total_In://收入统计
                    tabHost.setCurrentTabByTag("收入统计");  
                    break;  
                case R.id.Total_Out://支出统计
                    tabHost.setCurrentTabByTag("支出统计");  
                    break;  
                default:  
                    tabHost.setCurrentTabByTag("收入统计");  
                    break;  
                }  
            }  
        });  
	}
}
