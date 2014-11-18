package com.antonytime.twitterunfollowers.activity;

import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import com.antonytime.twitterunfollowers.R;
import com.antonytime.twitterunfollowers.fragment.LoginFragment;

public class MainActivity extends Activity {
	
	SharedPreferences pref;
	   
    private static String CONSUMER_KEY = "EMQYqZ1YhX438DBI0mp2K1Ljz";
    private static String CONSUMER_SECRET = "xAraL9FQd3JfbiYXotV0ZUq6TGEh44biISfab3OfTDBXBVPpNQ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_layout);

        pref = getPreferences(0);
        SharedPreferences.Editor edit = pref.edit();
        edit.putString("CONSUMER_KEY", CONSUMER_KEY);
        edit.putString("CONSUMER_SECRET", CONSUMER_SECRET);
        edit.commit();  

		Fragment login = new LoginFragment();
        FragmentTransaction ft = getFragmentManager().beginTransaction();	              
        ft.replace(R.id.content_frame, login);
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        ft.addToBackStack(null);
        ft.commit();
	}
}
