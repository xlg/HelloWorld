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
		builder.setTitle("ע��");
		builder.setMessage("�Ƿ�ע��?");
		builder.setPositiveButton("ȷ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

				setResult(0, intent);
				finish();
			}
		});

		builder.setNegativeButton("ȡ��", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		});

		dialog = builder.create();
		tv_qq_name.setText("��ӭ<" + qq + ">��½");

		bt_close.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				dialog.show();
			}
		});

		rb1 = (RadioButton) findViewById(R.id.radioButton1);

	}

	// ��rb1��ѡ�е�״̬���˳��˵�����Ч��������Ч

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		// ��Ӳ˵���

		menu.add(0, 0, 0, "��Ӻ���");
		menu.add(0, 1, 1, "����");
		menu.add(0, 2, 2, "ɾ�������¼");
		menu.add(0, 3, 3, "����");
		menu.add(0, 4, 4, "�˳�����");
		menu.add(0, 5, 5, "ˢ�º����б�");
		menu.add(0, 6, 6, "����");
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
		if (itemId == 1) {// ����
			// ���������ɼ�
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
