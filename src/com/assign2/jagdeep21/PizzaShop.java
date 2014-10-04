/*
 * Created By - Jagdeep Matharu (300710666) -> Assign 2-1
 */
package com.assign2.jagdeep21;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.assign2.jagdeepassign21.R;

public class PizzaShop extends Activity {

	Button bBack, bNext;

	RadioGroup rgPizzaType, rgPizzaSize;

	public static final String PREFS_PRIVATE = "PREFS_PRIVATE";
	public static final String KEY_PRIVATE = "KEY_PRIVATE";
	private SharedPreferences prefsPizzaType;

	public static final String PREFS_PRIVATE1 = "PREFS_PRIVATE1";
	public static final String KEY_PRIVATE1 = "KEY_PRIVATE1";
	private SharedPreferences prefsPizzaSize;

	public static final String PREFS_PRIVATE2 = "PREFS_PRIVATE2";
	public static final String KEY_PRIVATE2 = "KEY_PRIVATE2";
	private SharedPreferences prefsPizzaTopping;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jagdeep_pizza_shop_activity);

	}

	public void back(View view) {
		Intent activityIntent = new Intent(PizzaShop.this,
				JagdeepActivity.class);
		PizzaShop.this.startActivity(activityIntent);
	}

	public void next(View view) {

		Boolean test;
		CheckBox cT1, cT2, cT3, cT4, cT5, cT6, cT7, cT8, cT9, cT10, cT11, cT12;
		RadioButton rPT1, rPT2, rPT3, rPT4, rPT5, rPT6, rPS1, rPS2, rPS3, rPS4, rPS5;

		cT1 = (CheckBox) findViewById(R.id.cT1);
		cT2 = (CheckBox) findViewById(R.id.cT2);
		cT3 = (CheckBox) findViewById(R.id.cT3);
		cT4 = (CheckBox) findViewById(R.id.cT4);
		cT5 = (CheckBox) findViewById(R.id.cT5);
		cT6 = (CheckBox) findViewById(R.id.cT6);
		cT7 = (CheckBox) findViewById(R.id.cT7);
		cT8 = (CheckBox) findViewById(R.id.cT8);
		cT9 = (CheckBox) findViewById(R.id.cT9);
		cT10 = (CheckBox) findViewById(R.id.cT10);
		cT11 = (CheckBox) findViewById(R.id.cT11);
		cT12 = (CheckBox) findViewById(R.id.cT12);
		rPT1 = (RadioButton) findViewById(R.id.rPT1);
		rPT2 = (RadioButton) findViewById(R.id.rPT2);
		rPT3 = (RadioButton) findViewById(R.id.rPT3);
		rPT4 = (RadioButton) findViewById(R.id.rPT4);
		rPT5 = (RadioButton) findViewById(R.id.rPT5);
		rPT6 = (RadioButton) findViewById(R.id.rPT6);
		rPS1 = (RadioButton) findViewById(R.id.rPS1);
		rPS2 = (RadioButton) findViewById(R.id.rPS2);
		rPS3 = (RadioButton) findViewById(R.id.rPS3);
		rPS4 = (RadioButton) findViewById(R.id.rPS4);
		rPS5 = (RadioButton) findViewById(R.id.rPS5);

		// Pizza Type
		if (rPT1.isChecked() || rPT2.isChecked() || rPT3.isChecked()
				|| rPT4.isChecked() || rPT5.isChecked() || rPT6.isChecked()) {
			test = true;
		} else {
			Toast.makeText(this, "Select One of the Pizza Type",
					Toast.LENGTH_SHORT).show();
			test = false;
			return;
		}

		// Pizza Toppings
		if (rPS1.isChecked() || rPS2.isChecked() || rPS3.isChecked()
				|| rPS4.isChecked() || rPS5.isChecked()) {
			test = true;
		} else {
			Toast.makeText(this, "Select One of the Pizza Size",
					Toast.LENGTH_SHORT).show();
			test = false;
			return;
		}

		// Pizza Toppings
		if (cT1.isChecked() || cT2.isChecked() || cT3.isChecked()
				|| cT4.isChecked() || cT5.isChecked() || cT6.isChecked()
				|| cT7.isChecked() || cT8.isChecked() || cT9.isChecked()
				|| cT10.isChecked() || cT11.isChecked() || cT12.isChecked()) {
			test = true;
		} else {
			Toast.makeText(this, "Select One of the Pizza Toppings",
					Toast.LENGTH_SHORT).show();
			test = false;
			return;
		}

		if (test == true) {
			Intent activityIntent = new Intent(PizzaShop.this,
					OrderScreen.class);
			PizzaShop.this.startActivity(activityIntent);
		} else {

		}

		// int rbPT = rgPizzaType.getCheckedRadioButtonId();
		// View ptView = (View)findViewById(rbPT);

		// Saving data Pizza Type
		String testRgPizzaType = null;
		if (rPT1.isChecked()) {
			testRgPizzaType = "BP Originals";
		} else if (rPT2.isChecked()) {
			testRgPizzaType = "The Classics";
		} else if (rPT3.isChecked()) {
			testRgPizzaType = "Veggie";
		} else if (rPT4.isChecked()) {
			testRgPizzaType = "International";
		} else if (rPT5.isChecked()) {
			testRgPizzaType = "GlutenWise™‡";
		} else if (rPT6.isChecked()) {
			testRgPizzaType = "Calzones";
		}

		prefsPizzaType = getSharedPreferences(PizzaShop.PREFS_PRIVATE,
				Context.MODE_PRIVATE);
		Editor PizzaTypeEdit = prefsPizzaType.edit();
		PizzaTypeEdit.putString(PizzaShop.KEY_PRIVATE, testRgPizzaType);
		PizzaTypeEdit.commit();

		// Saving data Pizza Size
		String testRgPizzaSize = null;
		if (rPS1.isChecked()) {
			testRgPizzaSize = "Small - 12″";
		} else if (rPS2.isChecked()) {
			testRgPizzaSize = "Medium - 14″";
		} else if (rPS3.isChecked()) {
			testRgPizzaSize = "Large - 16″";
		} else if (rPS4.isChecked()) {
			testRgPizzaSize = "Extra Large - 18″";
		} else if (rPS5.isChecked()) {
			testRgPizzaSize = "Party Size - 15″ x 21″";
		}

		prefsPizzaSize = getSharedPreferences(PizzaShop.PREFS_PRIVATE1,
				Context.MODE_PRIVATE);
		Editor PizzaSizeEdit = prefsPizzaSize.edit();
		PizzaSizeEdit.putString(PizzaShop.KEY_PRIVATE1, testRgPizzaSize);
		PizzaSizeEdit.commit();

		// Saving Data for Pizza Toppings
		String testCbPizzaTopping = null;

		if (cT1.isChecked()) {
			testCbPizzaTopping = "Mushrooms";
		} else if (cT2.isChecked()) {
			testCbPizzaTopping = "Onions";
		} else if (cT3.isChecked()) {
			testCbPizzaTopping = "Olives";
		} else if (cT4.isChecked()) {
			testCbPizzaTopping = "Green Pepper";
		} else if (cT5.isChecked()) {
			testCbPizzaTopping = "Anchovies";
		} else if (cT6.isChecked()) {
			testCbPizzaTopping = "Salmon";
		} else if (cT7.isChecked()) {
			testCbPizzaTopping = "Bacon";
		} else if (cT8.isChecked()) {
			testCbPizzaTopping = "BBQ Chicken";
		} else if (cT9.isChecked()) {
			testCbPizzaTopping = "Ham";
		} else if (cT10.isChecked()) {
			testCbPizzaTopping = "Pepperoni";
		} else if (cT11.isChecked()) {
			testCbPizzaTopping = "Tuna";
		} else if (cT12.isChecked()) {
			testCbPizzaTopping = "Duck";
		}

		prefsPizzaTopping = getSharedPreferences(PizzaShop.PREFS_PRIVATE2,
				Context.MODE_PRIVATE);
		Editor PizzaToppingEdit = prefsPizzaTopping.edit();
		PizzaToppingEdit.putString(PizzaShop.KEY_PRIVATE2, testCbPizzaTopping);
		PizzaToppingEdit.commit();
	}
}
