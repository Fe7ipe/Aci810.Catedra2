package com.proyectoandroid7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {
	public final static String NAME_VALUE = "com.proyectoandroid7.NAME_VALUE";
	public final static String PASSWORD_VALUE = "com.proyectoandroid7.PASSWORD_VALUE";
	private String nombre;
	private String pass;
	

	private Button botonLogin;
	private EditText nameText, passText;
	SharedPreferences sharedPreferences;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences("app", Context.MODE_PRIVATE);   
	
		 nombre = sharedPreferences.getString(NAME_VALUE,"");
	      pass = sharedPreferences.getString(PASSWORD_VALUE,"");
	
	      nameText = (EditText) findViewById(R.id.editnameLog);
	      passText = (EditText) findViewById(R.id.editpassLog);
	 
	      botonLogin = (Button) findViewById(R.id.iniciarLogin);
	      
	      botonLogin.setOnClickListener(new View.OnClickListener(){
	    	  
	          public void onClick(View view){	 
	          if(checkeoCorrecto()){
	             Toast toast1 = Toast.makeText(getApplicationContext(),"User/pass correctos", Toast.LENGTH_SHORT);
	             toast1.show();
	             Intent i = new Intent(Login.this,Aplicacion.class);
	             startActivity(i);
	          }else{
	             Toast toast1 = Toast.makeText(getApplicationContext(),"User/pass incorrectos", Toast.LENGTH_SHORT);
	             toast1.show();
	          }
	        
	        }

			private boolean checkeoCorrecto()  {
			boolean ok = false;
		      String nt, pt;
		      
		      nt = nameText.getText().toString();
		      pt = passText.getText().toString();
		      Log.d("onlclick",nt + " " + pt);
		      Log.d("onlclick",nombre + " " + pass);
		      Toast toast1 = Toast.makeText(getApplicationContext(),nombre + " " + pass, Toast.LENGTH_SHORT);
		      toast1.show();
		      if((nombre != "")&&(pass != "")&&(nt.equals(nombre)&&pt.equals(pass))){
		         ok = true;
		      }
		      return ok;
		    }
	     });
	      
	    
	
	
	
	}
	
}



