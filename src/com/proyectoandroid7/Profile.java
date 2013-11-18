package com.proyectoandroid7;




import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RatingBar;
import android.widget.Toast;


public class Profile extends Activity {

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
		setContentView(R.layout.activity_profile);
	
		 SharedPreferences sharedPref = getSharedPreferences("me", Context.MODE_PRIVATE);        
	     
	     String name = sharedPref.getString(Registro.NAME_VALUE, "");        
	     String correo = sharedPref.getString(Registro.PASSWORD_VALUE, "");
	     String pass= sharedPref.getString(Registro.CORREO_VALUE, "");
	     String  rut = sharedPref.getString(Registro.RUT_VALUE, "");
	     Boolean  r1 = (Boolean) sharedPref.getBoolean(Registro.RADIOBUTTON01_VALUE, true);
	     Boolean r2 = (Boolean) sharedPref.getBoolean(Registro.RADIOBUTTON02_VALUE, true);
	     Float miBarra= sharedPref.getFloat(Registro.RATING_VALUE, 0);

	     EditText nameTextView = (EditText) findViewById(R.id.profileName);
	     nameTextView.setText(name);
	     
	     EditText correoTextView = (EditText) findViewById(R.id.profileCorreo);
	     correoTextView.setText(correo);

	     EditText passTextView = (EditText) findViewById(R.id.profilePass);
	     passTextView.setText(pass);
	     
	     EditText rutTextView = (EditText) findViewById(R.id.profileRut);
	     rutTextView.setText(rut);

	     
	     RadioButton radiobutton01  = (RadioButton) findViewById(R.id.radioButtonprofile1);
	     radiobutton01.setChecked(r1);
	     

	     RadioButton radiobutton02  = (RadioButton) findViewById(R.id.radioButtonprofile2);
	     radiobutton02.setChecked(r2);
	     
	     RatingBar ratingview  = (RatingBar) findViewById(R.id.ratingBarprofile);
	     ratingview.setRating(miBarra);
	     
	   
	    
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.profile, menu);
		return true;
	}
	 @Override
     public boolean onOptionsItemSelected(MenuItem item) {
             switch (item.getItemId()) {
             case android.R.id.home:
                     
                     NavUtils.navigateUpFromSameTask(this);
                     return true;
             }
             return super.onOptionsItemSelected(item);
     }
	 public void savePerfil(View view) { 
			
			
		    EditText EditNombre = (EditText) findViewById(R.id.profileName);
			String name = EditNombre.getText().toString();
			
			EditText EditPass = (EditText) findViewById(R.id.profilePass);
			String pass = EditPass.getText().toString();
			
			EditText EditCorreo = (EditText) findViewById(R.id.profileCorreo);
			String correo = EditCorreo.getText().toString();
			
			
			EditText EditRut = (EditText) findViewById(R.id.profileRut);
			String rut =EditRut.getText().toString();
			
			RadioButton Rb1 = (RadioButton) findViewById(R.id.radioButton1);
			Boolean r1 = Rb1.isChecked();
			
			RadioButton Rb2 = (RadioButton) findViewById(R.id.radioButton2);
			Boolean r2 = Rb2.isChecked();
			
			RatingBar Barra = (RatingBar) findViewById(R.id.progressBar1);
			Float mibarra = Barra.getRating();
			
			SharedPreferences sharedPref = getApplicationContext().getSharedPreferences("app", Context.MODE_PRIVATE);  
			
			
			
			
			SharedPreferences.Editor editor = sharedPref.edit();   
			
			
			
			editor.putString(NAME_VALUE, name);        
			editor.putString(PASSWORD_VALUE, pass);
			editor.putString(CORREO_VALUE, correo);
			editor.putString(RUT_VALUE, rut);
			editor.putBoolean(RADIOBUTTON01_VALUE, r1);
			editor.putBoolean(RADIOBUTTON02_VALUE, r2);
			editor.putFloat(RATING_VALUE, mibarra);
			
			editor.commit();
			
		
			
			Toast.makeText(Profile.this,"Actualizado Correctamente", Toast.LENGTH_LONG).show();
			
			

			
				
				
			
			}
		
	}
		



