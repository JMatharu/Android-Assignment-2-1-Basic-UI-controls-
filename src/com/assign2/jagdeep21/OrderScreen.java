/*
 * Created By - Jagdeep Matharu (300710666) -> Assign 2-1
 */
package com.assign2.jagdeep21;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.assign2.jagdeepassign21.R;

public class OrderScreen extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jagdeep_order_screen_activity);

		EditText etName;

		etName = (EditText) findViewById(R.id.etName);
		etName.requestFocus();
	}

	@SuppressLint("NewApi")
	public void order(View view) {
		EditText etName, etAddress, etEmail, etCredit, etCity, etPhone;

		etName = (EditText) findViewById(R.id.etName);
		etEmail = (EditText) findViewById(R.id.etEmail);
		etAddress = (EditText) findViewById(R.id.etAddress);
		etCity = (EditText) findViewById(R.id.etCity);
		etPhone = (EditText) findViewById(R.id.etPhone);
		etCredit = (EditText) findViewById(R.id.etCredit);

		if (etName.getText().toString().isEmpty()) {
			Toast.makeText(this, "Name cannot be left blank", Toast.LENGTH_LONG)
					.show();
			etName.requestFocus();
		} else if (etEmail.getText().toString().isEmpty()) {
			Toast.makeText(this, "Email cannot be left blank",
					Toast.LENGTH_LONG).show();
			etEmail.requestFocus();
		} else if (etAddress.getText().toString().isEmpty()) {
			Toast.makeText(this, "Address cannot be left blank",
					Toast.LENGTH_LONG).show();
			etAddress.requestFocus();
		} else if (etCity.getText().toString().isEmpty()) {
			Toast.makeText(this, "City cannot be left blank", Toast.LENGTH_LONG)
					.show();
			etCity.requestFocus();
		} else if (etPhone.getText().toString().isEmpty()) {
			Toast.makeText(this, "Phone number cannot be left blank",
					Toast.LENGTH_LONG).show();
			etPhone.requestFocus();
		} else if (etCredit.getText().toString().isEmpty()) {
			Toast.makeText(this, "Credit Card Info cannot be left blank",
					Toast.LENGTH_LONG).show();
			etCredit.requestFocus();
		} else {
			Intent activityIntent = new Intent(OrderScreen.this, Checkout.class);
			activityIntent.putExtra("name", etName.getText().toString());
			activityIntent.putExtra("email", etEmail.getText().toString());
			activityIntent.putExtra("address", etAddress.getText().toString());
			activityIntent.putExtra("city", etCity.getText().toString());
			activityIntent.putExtra("ph", etPhone.getText().toString());
			activityIntent.putExtra("credit", etCredit.getText().toString());
			OrderScreen.this.startActivity(activityIntent);
		}

	}

	public void back(View view) {
		Intent activityIntent = new Intent(OrderScreen.this, PizzaShop.class);
		OrderScreen.this.startActivity(activityIntent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.order_screen, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
