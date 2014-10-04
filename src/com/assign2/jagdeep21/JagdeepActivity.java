/*
 * Created By - Jagdeep Matharu (300710666) -> Assign 2-1
 */
package com.assign2.jagdeep21;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.assign2.jagdeepassign21.R;

public class JagdeepActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		declaringObjects();

	}

	@Override
	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		// TODO Auto-generated method stub
		super.onCreateContextMenu(menu, v, menuInfo);
		menu.setHeaderIcon(R.drawable.ic_launcher);
		menu.setHeaderTitle("Choose your desirable Pizza Shop");
		menu.add(0, v.getId(), 0, "Ginos Pizza");
		menu.add(0, v.getId(), 0, "Pizza Pizza");
		menu.add(0, v.getId(), 0, "Boston Pizza");
		menu.add(0, v.getId(), 0, "Domino's Pizza");
		menu.add(0, v.getId(), 0, "Regino's Pizza");
		menu.add(0, v.getId(), 0, "Pizza Nova");
	}

	@Override
	public boolean onContextItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		if (item.getTitle() == "Ginos Pizza"
				|| item.getTitle() == "Regino's Pizza"
				|| item.getTitle() == "Pizza Pizza"
				|| item.getTitle() == "Boston Pizza"
				|| item.getTitle() == "Domino's Pizza"
				|| item.getTitle() == "Pizza Nova") {
			Intent activityIntent = new Intent(JagdeepActivity.this,
					PizzaShop.class);
			JagdeepActivity.this.startActivity(activityIntent);
		}

		return super.onContextItemSelected(item);

	}

	private void declaringObjects() {
		// TODO Auto-generated method stub
		Button bPress = (Button) findViewById(R.id.butPress);
		bPress.setOnCreateContextMenuListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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
