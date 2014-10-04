/*
 * Created By - Jagdeep Matharu (300710666) -> Assign 2-1
 */
package com.assign2.jagdeep21;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.assign2.jagdeepassign21.R;

public class Checkout extends Activity {
	Context context = this;

	private SharedPreferences PizzaTypeprefsPrivate, PizzaSizeprefsPrivate,
			PizzaToppingprefsPrivate;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jagdeep_checkout_activity);

		PizzaTypeprefsPrivate = getSharedPreferences(PizzaShop.PREFS_PRIVATE,
				Context.MODE_PRIVATE);
		TextView txtPizzaType = (TextView) findViewById(R.id.txtPizzaType);
		txtPizzaType.setText("Pizza Type : "
				+ PizzaTypeprefsPrivate.getString(PizzaShop.KEY_PRIVATE, "NA"));

		PizzaSizeprefsPrivate = getSharedPreferences(PizzaShop.PREFS_PRIVATE1,
				Context.MODE_PRIVATE);
		TextView txtPizzaSize = (TextView) findViewById(R.id.txtPizzaSize);
		txtPizzaSize
				.setText("Pizza Size : "
						+ PizzaSizeprefsPrivate.getString(
								PizzaShop.KEY_PRIVATE1, "NA"));

		PizzaToppingprefsPrivate = getSharedPreferences(
				PizzaShop.PREFS_PRIVATE2, Context.MODE_PRIVATE);
		TextView txtPizzaTopping = (TextView) findViewById(R.id.txtPizzaTopping);
		txtPizzaTopping.setText("Pizza Toppings : "
				+ PizzaToppingprefsPrivate.getString(PizzaShop.KEY_PRIVATE2,
						"NA"));

		TextView txtName = (TextView) findViewById(R.id.txtName);
		String tname = getIntent().getStringExtra("name");
		txtName.setText("Name : " + tname);

		TextView txtEmail = (TextView) findViewById(R.id.txtEmail);
		String temail = getIntent().getStringExtra("email");
		txtEmail.setText("Email : " + temail);

		TextView txtAddress = (TextView) findViewById(R.id.txtAddress);
		String taddress = getIntent().getStringExtra("address");
		txtAddress.setText("Address : " + taddress);

		TextView txtCity = (TextView) findViewById(R.id.txtCity);
		String tcity = getIntent().getStringExtra("city");
		txtCity.setText("City : " + tcity);

		TextView txtPhone = (TextView) findViewById(R.id.txtPhone);
		String tphone = getIntent().getStringExtra("ph");
		txtPhone.setText("Phone : " + tphone);

		TextView txtCredit = (TextView) findViewById(R.id.txtCredit);
		String tcredit = getIntent().getStringExtra("credit");
		txtCredit.setText("Credit : " + tcredit);

	}

	public void checkout(View view) {
		DialogInterface.OnClickListener dialog = new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				switch (which) {
				case DialogInterface.BUTTON_POSITIVE:
					Intent activityIntent = new Intent(Checkout.this,
							JagdeepActivity.class);
					Checkout.this.startActivity(activityIntent);
					break;

				case DialogInterface.BUTTON_NEGATIVE:
					break;
				}

			}
		};
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Are you sure?")
				.setPositiveButton("Confirm", dialog)
				.setNegativeButton("Back", dialog).show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.checkout, menu);
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
