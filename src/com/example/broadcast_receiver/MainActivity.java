package com.example.broadcast_receiver;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	private Context context;//定义 Context 上下文对象
	private Button btn;
	private EditText et;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;

		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new TestClickListener());
		
		et = (EditText)findViewById(R.id.et);
	}

	private class TestClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			String content = et.getText().toString().trim();
			if(content.length()<1)
			{
				Toast.makeText(context, et.getHint(), 1).show();
				return;
			}
			
			Intent intent = new Intent();
			intent.setAction("com.yanis.action.Test");
			intent.putExtra("content", content);
			sendBroadcast(intent);
		}
	}

}
