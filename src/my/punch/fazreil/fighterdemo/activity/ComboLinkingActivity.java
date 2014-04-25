package my.punch.fazreil.fighterdemo.activity;

import my.punch.fazreil.fighterdemo.R;
import my.punch.fazreil.fighterdemo.R.layout;
import my.punch.fazreil.fighterdemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ComboLinkingActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_combo_linking);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.combo_linking, menu);
		return true;
	}

}
