package com.finance.familyfinance;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class SelfActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.self_main);
		ListView  listview = (ListView)findViewById(R.id.listview);
        int[] imageld = new int[] {
        		R.drawable.vv1,R.drawable.vv2,R.drawable.vv3,R.drawable.vv4,R.drawable.vv1
        };
        List<Map<String,Object>> listitems= new ArrayList<Map<String,Object>>();
        String [] title = new String[]{"新增收入","新增支出","我的收入","我的支出","数据管理"};
        for(int i= 0; i < imageld.length;i++){
        	Map<String,Object> map = new HashMap<String,Object>();
        	map.put("image", imageld[i]);
        	map.put("title", title[i]);
        	listitems.add(map);
        }
        
        SimpleAdapter adapter = new SimpleAdapter(this,listitems, R.layout.self_items, new String[]
        		{"title","image"},new int[] {
        		R.id.title,R.id.image
        		});
        listview.setAdapter(adapter);
	}
}
