package com.finance.show;

import java.util.Calendar;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.finance.dao.InCostDAO;
import com.finance.familyfinance.R;
import com.finance.model.M_InCost;

public class InCostEdit extends Activity {
	
	private EditText txtInMoney;
	private EditText txtTime;
	private Spinner txtType;
	private EditText txtResouce;
	private EditText txtDepict;
	private Button BtnSave;
	private Button BtnCancel;
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
		BtnSave = (Button)findViewById(R.id.btnInSave);
		BtnCancel = (Button)findViewById(R.id.btnInCancel);
		
		//保存按钮
		BtnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				M_InCost mIncost = new M_InCost();
				InCostDAO Indao = new InCostDAO(InCostEdit.this);
				if(!txtInMoney.getText().toString().isEmpty())
				{
					mIncost.setMoney(Double.parseDouble(txtInMoney.getText().toString()));
					mIncost.setInTime(txtTime.getText().toString());
					mIncost.setSource(txtResouce.getText().toString());
					mIncost.setInType(txtType.getSelectedItem().toString());
					mIncost.setDepict(txtDepict.getText().toString());
					Indao.ADD(mIncost);
					//弹出提示信息
					Toast.makeText(InCostEdit.this, "新增收入信息成功！", Toast.LENGTH_SHORT).show();
				}
				else
				{
					//弹出提示信息
					Toast.makeText(InCostEdit.this, "请输入收金额！", Toast.LENGTH_SHORT).show();
				}	
			}
		});
		
		//取消按钮
		BtnCancel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				txtInMoney.setText("");
				txtInMoney.setHint("0.00");
				txtResouce.setText("");
				txtDepict.setText("");
				Intent intent = new Intent(InCostEdit.this,com.finance.familyfinance.IndexActivity.class);
				startActivity(intent);
			}
		});
		
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
