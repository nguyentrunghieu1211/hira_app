package org.buianhthang.apps.hiragana;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;

import org.apache.http.NameValuePair;
import org.buianhthang.apps.Asynctask.MyAsyncTask;
import org.buianhthang.apps.Helper.Hiragana;
import org.buianhthang.apps.Helper.JSONParser;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;




public class MainActivity extends Activity {
	// but ton goi y
	Button btn_goiy1, btn_goiy2, btn_goiy3, btn_goiy4, btn_goiy5, btn_goiy6,
			btn_goiy7, btn_goiy8, btn_goiy9, btn_goiy10, btn_goiy11,
			btn_goiy12, btn_goiy13, btn_goiy14;
	ImageView img_image;
	MyAsyncTask task;

	Bitmap bitmap;
	ProgressDialog pDialog;
	Intent intent;

	// To store all the products

	JSONObject product;

	// Creating JSON Parser object
	JSONParser jParser = new JSONParser();
	public ArrayList<Hiragana> productsList;
	// url to get all products list
	private static String url_all_products = "http://192.168.0.116/Server_Hiragana/v1/hiragana";
	// JSON Node names

	private static final String TAG_PRODUCTS = "hiragana";
	private static final String TAG_PID = "id";
	private static final String TAG_CAUHOI = "cauhoi";
	private static final String TAG_DAPAN = "dapan";

	int cau = 0;
	// products JSONArray
	JSONArray products = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		productsList = new ArrayList<Hiragana>();
		getControl();

		// Loading products in Background Thread
		try {
			productsList = new LoadAllProducts().execute().get();
		} catch (ExecutionException ei) {
			ei.printStackTrace();
			Toast.makeText(MainActivity.this, "Loi", Toast.LENGTH_LONG).show();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Toast.makeText(MainActivity.this, "loi cai thu 2",
					Toast.LENGTH_LONG).show();
		}
		// da lay duoc het cac cau hoi

		// ve cac nut dap an vaf hien image
	//	task = new MyAsyncTask(this);
	//	Hiragana que = productsList.get(cau);
	//	task.execute(que);

		// tao goi y 1
		// getGoiY1();
		// tao goi y 2
		// getGoiY2();

	}

	// tao goi y 1
	private void getGoiY1() {
		// TODO Auto-generated method stub

		Hiragana number = productsList.get(cau);
		int id = number.getId();
		String cauhoi = number.getCauhoi();
		String dapan = number.getDapan();

		String str = number.getDapan().toUpperCase();
		// lay ky tu dau dap an
		char[] str1 = str.substring(0, 1).toCharArray();
		// tao vi tri random
		Random rad = new Random();
		int position = rad.nextInt(7);
		// chen vao chuoi goi y
		String str2 = "PBGCHDE";
		// chuyen sang mang Array
		char[] arr_goiy = str2.toCharArray();
		// chen ky tu vao mang ta duoc chuoi goi y
		for (int i = 0; i < 7; i++) {

			if (i == position)
				arr_goiy[i] = str1[0];
		}
		// duoc chuoi goi y 1 vaf gan vao hang 1

		for (int i = 0; i < 7; i++) {
			switch (i) {

			case 0:
				btn_goiy7.setText(arr_goiy[i] + "");

				break;
			case 1:
				btn_goiy1.setText(arr_goiy[i] + "");

				break;
			case 2:
				btn_goiy2.setText(arr_goiy[i] + "");

				break;
			case 3:
				btn_goiy3.setText(arr_goiy[i] + "");

				break;
			case 4:
				btn_goiy4.setText(arr_goiy[i] + "");

				break;
			case 5:
				btn_goiy5.setText(arr_goiy[i] + "");

				break;
			case 6:
				btn_goiy6.setText(arr_goiy[i] + "");

			}

		}
	}

	private void getGoiY2() {

		Hiragana number = productsList.get(cau);
		int id = number.getId();
		String cauhoi = number.getCauhoi();

		// dap an
		String str = number.getDapan().toUpperCase();

		if (str.length() == 2) {

			// TODO Auto-generated method stub
			// lay dap an cau hoi

			// vi da lay ky tu dau o tren goiy1

			// lay ky tu thu 2 dap an
			// char[] str1 = str.substring(1, 1).toCharArray();
			char ch = str.charAt(1);
			Log.d("gia tri c=bien ch", ch + "");
			// tao vi tri random
			Random rad = new Random();
			int position = rad.nextInt(7);
			// chen vao chuoi goi y
			String str2 = "JUNKMOI";
			// chuyen sang mang Array
			char[] arr_goiy = str2.toCharArray();
			// chen ky tu vao mang ta duoc chuoi goi y
			for (int i = 0; i < 7; i++) {

				if (i == position)
					arr_goiy[i] = ch;
				// arr_goiy[i] = str1[0];
			}

			// den day duoc chuoi goi y 2
			// set vao thoi
			for (int i = 0; i < 7; i++) {
				switch (i) {

				case 0:
					btn_goiy8.setText(arr_goiy[i] + "");

					break;
				case 1:
					btn_goiy9.setText(arr_goiy[i] + "");

					break;
				case 2:
					btn_goiy10.setText(arr_goiy[i] + "");

					break;
				case 3:
					btn_goiy11.setText(arr_goiy[i] + "");

					break;
				case 4:
					btn_goiy12.setText(arr_goiy[i] + "");

					break;
				case 5:
					btn_goiy13.setText(arr_goiy[i] + "");

					break;
				case 6:
					btn_goiy14.setText(arr_goiy[i] + "");

				}
			}

		}

		else if (str.length() == 3) {
			// xuwr lys cai dap an o day

		}

	}

	private void getControl() {
		// TODO Auto-generated method stub
		img_image = (ImageView) findViewById(R.id.img_image);
		btn_goiy1 = (Button) findViewById(R.id.goiy1);
		btn_goiy2 = (Button) findViewById(R.id.goiy2);
		btn_goiy3 = (Button) findViewById(R.id.goiy3);
		btn_goiy4 = (Button) findViewById(R.id.goiy4);
		btn_goiy5 = (Button) findViewById(R.id.goiy5);
		btn_goiy6 = (Button) findViewById(R.id.goiy6);
		btn_goiy7 = (Button) findViewById(R.id.goiy7);
		btn_goiy8 = (Button) findViewById(R.id.goiy8);
		btn_goiy9 = (Button) findViewById(R.id.goiy9);
		btn_goiy10 = (Button) findViewById(R.id.goiy10);
		btn_goiy11 = (Button) findViewById(R.id.goiy11);
		btn_goiy12 = (Button) findViewById(R.id.goiy12);
		btn_goiy13 = (Button) findViewById(R.id.goiy13);
		btn_goiy14 = (Button) findViewById(R.id.goiy14);

	}

	/**
	 * Fetching the products from our server
	 * */
	class LoadAllProducts extends
	AsyncTask<Integer, String, ArrayList<Hiragana>> {

@Override
protected void onPreExecute() {
	// TODO Auto-generated method stub
	super.onPreExecute();
}

@Override
protected ArrayList<Hiragana> doInBackground(Integer... args) {
	// Building Parameters
	

	try {
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		// getting JSON string from URL
		JSONObject json = jParser.makeHttpRequest(url_all_products, "GET",
				params);

		// Check your log cat for JSON reponse
		Log.d("All Products: ", json.toString());
		// Checking for SUCCESS TAG

		// products found
		// Getting Array of Products
		products = json.getJSONArray(TAG_PRODUCTS);

		// looping through All Products
		for (int i = 0; i < products.length(); i++) {
			JSONObject c = products.getJSONObject(i);

			// Storing each json item in variable
			int id = c.getInt(TAG_PID);
			String cauhoi = c.getString(TAG_CAUHOI);
			String dapan = c.getString(TAG_DAPAN);

			Hiragana a = new Hiragana();
			a.setId(id);

			a.setCauhoi(cauhoi);

			a.setDapan(dapan);

			// adding HashList to ArrayList
			productsList.add(a);

		}

	} catch (JSONException e) {
		e.printStackTrace();
	}

	return productsList;
}

@Override
protected void onPostExecute(ArrayList<Hiragana> result) {
	// TODO Auto-generated method stub
	super.onPostExecute(result);

}

@Override
protected void onProgressUpdate(String... values) {
	// TODO Auto-generated method stub
	super.onProgressUpdate(values);
}

}

}
