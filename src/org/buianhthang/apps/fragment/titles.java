package org.buianhthang.apps.fragment;

import org.buianhthang.apps.hiragana.R;
import org.buianhthang.apps.hiragana.R.id;
import org.buianhthang.apps.hiragana.R.layout;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class titles extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.titles, container, false);
	}
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		TextView txt_number=(TextView) getActivity().findViewById(R.id.txt_number);
		Button btn_back=(Button) getActivity().findViewById(R.id.btn_back);
		Button btn_next=(Button) getActivity().findViewById(R.id.btn_next);
		Button btn_shart=(Button) getActivity().findViewById(R.id.btn_shart);
	}

}
