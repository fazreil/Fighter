package my.punch.fazreil.fighterdemo.activity;

import my.punch.fazreil.fighterdemo.R;
import my.punch.fazreil.fighterdemo.R.menu;
import my.punch.fazreil.fighterdemo.panel.MoveTestGamePanel;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class MoveDemoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(new MoveTestGamePanel(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo, menu);
		return true;
	}

}
