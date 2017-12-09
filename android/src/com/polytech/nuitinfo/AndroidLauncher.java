package com.polytech.nuitinfo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

public class AndroidLauncher extends AndroidApplication {
	@Override
	protected void onCreate (Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
		initialize(new miniMain(), config);
	}

	@Override
	public void onBackPressed() {
		Toast.makeText(this,"Ne conduit pas si tu galères à faire un bon score!!",Toast.LENGTH_LONG).show();
		Intent intent = new Intent(this,Accueil.class);
		startActivity(intent);
		finish();
	}
}
