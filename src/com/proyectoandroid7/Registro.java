package com.proyectoandroid7;



import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.RadioButton;
import android.widget.Toast;

public class Registro extends Activity {
	
	public final static String NAME_VALUE = "com.proyectoandroid7.NAME_VALUE";
	public final static String PASSWORD_VALUE = "com.proyectoandroid7.PASSWORD_VALUE";
	public final static String CORREO_VALUE = "com.proyectoandroid7.CORREO_VALUE";
    public final static String RUT_VALUE ="com.proyectoandroid7.RUT_VALUE";
    public final static String RADIOBUTTON01_VALUE ="com.proyectoandroid7.RADIOBUTTON01_VALUE";
    public final static String RADIOBUTTON02_VALUE ="com.proyectoandroid7.RADIOBUTTON02_VALUE";
    public final static String RATING_VALUE ="com.proyectoandroid7.SEEKBAR_VALUE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_registro);
		
	
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.registro, menu);
		return true;
	}
	
	public void addRegistro(View view) { 
		
		Intent i = new Intent(this,Aplicacion.class);
		
		
		EditText EditNombre = (EditText) findViewById(R.id.editName);
		String name = EditNombre.getText().toString();
		
		EditText EditPass = (EditText) findViewById(R.id.editPass);
		String pass = EditPass.getText().toString();
		
		EditText EditCorreo = (EditText) findViewById(R.id.editCorreo);
		String correo = EditCorreo.getText().toString();
		
		
		EditText EditRut = (EditText) findViewById(R.id.editRut);
		String rut =EditRut.getText().toString();
		
		RadioButton Rb1 = (RadioButton) findViewById(R.id.radioButton1);
		Boolean r1 = Rb1.isChecked();
		
		RadioButton Rb2 = (RadioButton) findViewById(R.id.radioButton2);
		Boolean r2 = Rb2.isChecked();
		
		RatingBar Barra = (RatingBar) findViewById(R.id.ratingBar1);
		Float mibarra = Barra.getRating();
		
		SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("app", Context.MODE_PRIVATE);  
		
		@SuppressWarnings("unused")
		Boolean b = sharedPref.getBoolean("is_registered", false);
		
		SharedPreferences.Editor editor = sharedPref.edit();   
		
		editor.putBoolean("is_registered", true); 
		
		editor.putString(NAME_VALUE, name);        
		editor.putString(PASSWORD_VALUE, pass);
		editor.putString(CORREO_VALUE, correo);
		editor.putString(RUT_VALUE, rut);
		editor.putBoolean(RADIOBUTTON01_VALUE, r1);
		editor.putBoolean(RADIOBUTTON02_VALUE, r2);
		editor.putFloat(RATING_VALUE, mibarra);
		editor.commit();
		
		Toast.makeText(Registro.this,"Registro Correcto", Toast.LENGTH_LONG).show();


		startActivity(i);
}
}
