package com.proyectoandroid7;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;



public class Aplicacion extends Activity {
	
	public final static String NAME_VALUE = "com.android_cat2.NAME_VALUE";
	public final static String PASSWORD_VALUE = "com.android_cat2.PASSWORD_VALUE";
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aplicacion);
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.aplicacion, menu);
		return true;
	}
	
public void addPerfil(View view) { 
		
		Intent i = new Intent(this,Profile.class);
		startActivity(i);

}

public void addFuera(View view) { 
	
	Intent i = new Intent(this,Login.class);
	startActivity(i);

}

public void addSettings(View view) { 
	
	Intent i = new Intent(this,Settings.class);
	startActivity(i);

}


    
}
