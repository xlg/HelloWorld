package com.example.myfirstapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {

	private TextView tv_qq_name = null;
	private Button bt_close = null;
	private String qq = "";
	private Builder builder = null;
	private Intent intent = null;

	private AlertDialog dialog = null;
	private int index = 0;
	private final int FIRST_ITEM = index++;
	private final int SECOND_ITEM = index++;
	private final int THIRD_ITEM = index++;
	private final int FOUR_ITEM = index++;

	private RadioButton rb1;

	private EditText edt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ui);
		edt = (EditText) findViewById(R.id.edt);
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

		rb1 = (RadioButton) findViewById(R.id.radioButton1);

	}

	// 当rb1是选中的状态，退出菜单项无效；否则，有效

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// 添加菜单项

		menu.add(0, 0, 0, "添加好友");
		menu.add(0, 1, 1, "搜索");
		menu.add(0, 2, 2, "删除聊天记录");
		menu.add(0, 3, 3, "设置");
		menu.add(0, 4, 4, "退出程序");
		menu.add(0, 5, 5, "刷新好友列表");
		menu.add(0, 6, 6, "关于");
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		boolean isC = rb1.isChecked();
		MenuItem mi = menu.getItem(3);
		if (isC) {
			mi.setEnabled(false);
		} else {
			mi.setEnabled(true);
		}

		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int itemId = item.getItemId();
		if (itemId == 1) {// 收索
			// 设置输入框可见
			edt.setVisibility(View.VISIBLE);
		} else if (itemId == 4) {
			finish();
		} else if (itemId == 6) {
			Intent intent = new Intent(SecondActivity.this, ThirdActivity.class);
			startActivity(intent);
		}

		return super.onOptionsItemSelected(item);
	}
}
