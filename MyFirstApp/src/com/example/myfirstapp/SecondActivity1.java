package com.example.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity1 extends Activity {

	private TextView tv_qq_name = null;
	private Button bt_close = null;
	private String qq = "";
	private Builder builder = null;
	private Intent intent = null;

	private AlertDialog dialog = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui);

		intent = getIntent();
		qq = intent.getStringExtra("qqnumber");

		tv_qq_name = (TextView) findViewById(R.id.tv_qq_name);
		bt_close = (Button) findViewById(R.id.bt_close);

		builder = new Builder(this);
		builder.setTitle("注销");
		builder.setMessage("是否注销?");
		builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

				setResult(0, intent);
				finish();
			}
		});

		builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});

		dialog = builder.create();
		tv_qq_name.setText("欢迎<" + qq + ">登陆");

		bt_close.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.show();
			}
		});

	}

}
