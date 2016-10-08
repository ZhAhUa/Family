package com.finance.show;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import com.finance.familyfinance.R;

public class InCostEdit extends Activity {
	
	private EditText txtInMoney;
	private EditText txtTime;
	private Spinner txtType;
	private EditText txtResouce;
	private EditText txtDepict;
	private int mYear;
	private int mMonth;
	private int mDay;
	protected static final int DATE_DIALOG_ID =0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.incostedit);
		
		//获取文本框
		txtInMoney = (EditText)findViewById(R.id.txtInMoney);
		txtTime = (EditText)findViewById(R.id.txtInTime);
		txtResouce = (EditText)findViewById(R.id.txtResouce);
		txtDepict = (EditText)findViewById(R.id.txtDepict);
		txtType = (Spinner)findViewById(R.id.txtIntype);
		
		txtTime.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				showDialog(DATE_DIALOG_ID);
			}
		});
		final Calendar c = Calendar.getInstance();
		mYear = c.get(Calendar.YEAR);
		mMonth = c.get(Calendar.MONTH);
		mDay = c.get(Calendar.DAY_OF_MONTH);
		updateDisplag();
	}
	
	private void updateDisplag()
	{
		txtTime.setText(new StringBuilder().append(mYear).append("-").append(mMonth + 1).append("-").append(mDay));
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch(id)
		{
		case DATE_DIALOG_ID:
			return new DatePickerDialog(this, mDateSetListener, mYear, mMonth, mDay);
		}
		return null;
	}
	
	private DatePickerDialog.OnDateSetListener mDateSetListener = new OnDateSetListener() {
		
		@Override
		public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				mYear = year;
				mMonth = monthOfYear;
				mDay = dayOfMonth;
				updateDisplag();
		}
	};
	

}
