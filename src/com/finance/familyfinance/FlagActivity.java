package com.finance.familyfinance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class FlagActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.flag_main);
		ImageButton imgBtn =(ImageButton)findViewById(R.id.btnAddflag);
		imgBtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(FlagActivity.this,com.finance.show.FlagEdit.class);  
				startActivity(intent);
			}
		});
	}
}
