package com.finance.familyfinance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.finance.show.InCostEdit;
import com.finance.show.OutCostEdit;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class SelfActivity extends Activity {

	
	private SimpleAdapter adapter=null;
	private  List<Map<String,Object>> listitems= new ArrayList<Map<String,Object>>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.self_main);
		ListView  listview = (ListView)findViewById(R.id.listview);
        int[] imageld = new int[] {
        		R.drawable.vv1,R.drawable.vv2,R.drawable.vv1,R.drawable.vv2,R.drawable.vv1
        };
       
        String [] title = new String[]{"新增收入","新增支出","我的收入","我的支出","数据管理"};
        for(int i= 0; i < imageld.length;i++){
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.put("image", imageld[i]);
        	map.put("title", title[i]);
        	listitems.add(map);
        }
        
         adapter = new SimpleAdapter(this,listitems, R.layout.self_items, new String[]
        		{"title","image"},new int[] {
        		R.id.title,R.id.image
        		});
        listview.setAdapter(adapter);
     
        
        listview.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				// TODO Auto-generated method stub
				
				if(arg2 == 0)
				{
					 Intent intent0 = new Intent(SelfActivity.this,com.finance.show.InCostEdit.class);
				 startActivity(intent0);
				}

				if(arg2 == 1)
				{
					Intent  intent1 = new Intent(SelfActivity.this,com.finance.show.OutCostEdit.class);
					 startActivity(intent1);
				}
				if(arg2 == 2)
				{
					Intent  intent2 = new Intent(SelfActivity.this,com.finance.show.InCostList.class);
					 startActivity(intent2);
				}
				if(arg2 == 3)
				{
					Intent intent3 = new Intent(SelfActivity.this,com.finance.show.OutCostList.class);
					 startActivity(intent3);
				}
				if(arg2 == 4)
				{
					Intent intent4 = new Intent(SelfActivity.this,com.finance.show.TotalData.class);
					 startActivity(intent4);
				}
//				 switch(arg2)
//			        {
//				 case 0:  //新增收入
//					 Intent intent0 = new Intent(SelfActivity.this,com.finance.show.InCostEdit.class);
//					 startActivity(intent0);
//				 case 1:  //新增支出
//					 Intent  intent1 = new Intent(SelfActivity.this,com.finance.show.OutCostEdit.class);
//					 startActivity(intent1);
//				 case 2: //我的收入
//					 Intent  intent2 = new Intent(SelfActivity.this,com.finance.show.InCostList.class);
//					 startActivity(intent2);
//				 case 3:  //我的支出
//					 Intent intent3 = new Intent(SelfActivity.this,com.finance.show.OutCostList.class);
//					 startActivity(intent3);
//				 case 4: //数据管理
//					 Intent intent4 = new Intent(SelfActivity.this,com.finance.show.TotalData.class);
//					 startActivity(intent4);
//			        }
				   
			}
		});
	}

}
