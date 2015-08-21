package org.buianhthang.apps.Asynctask;

import java.util.ArrayList;

import org.buianhthang.apps.Helper.Hiragana;

import android.R;
import android.app.Activity;
import android.os.AsyncTask;
import android.os.SystemClock;
import android.webkit.WebView.FindListener;
import android.widget.Button;
import android.widget.LinearLayout;

public class MyAsyncTask extends AsyncTask<Hiragana, Integer, Void> {

	private LinearLayout linear_result,linear_goiy1,linear_goiy2;
	private Activity context;

	public MyAsyncTask(Activity context) {
		this.linear_result = (LinearLayout) context.findViewById(0x7f080003);
		//this.linear_goiy1=(LinearLayout) context.findViewById(0x7f080005);
			//	this.linear_goiy2=(LinearLayout) context.findViewById(0x7f080007);
		this.context = context;

	}

	@Override
	protected Void doInBackground(Hiragana... params) {
		// TODO Auto-generated method stub

		Hiragana number = params[0];
		int id= number.getId();
		String cauhoi= number.getCauhoi();
		String dapan= number.getDapan();
		int num=dapan.length();
		for (int i = 0; i < num; i++) {
			//SystemClock.sleep(100);
			publishProgress(i);

		}
		
		

		return null;
	}

	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);

	}

	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		this.linear_result.removeAllViews();
		

	}

	@Override
	protected void onProgressUpdate(Integer... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
		Integer item = values[0];
		// tạo Button với Text có giá trị là số ngẫu nhiên
		Button btn = new Button(context);
		btn.setWidth(30);
		btn.setHeight(30);
		btn.setText("  ");
	//	btn.setId(1);
		
		
	btn.setBackgroundResource(R.drawable.btn_default_small);
		this.linear_result.addView(btn);

	}

}
