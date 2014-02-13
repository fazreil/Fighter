package my.punch.fazreil.fighterdemo.activity;

import my.punch.fazreil.fighterdemo.R;
import my.punch.fazreil.fighterdemo.R.array;
import my.punch.fazreil.fighterdemo.R.id;
import my.punch.fazreil.fighterdemo.R.layout;
import my.punch.fazreil.fighterdemo.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class DemoChoiceActivity extends Activity implements OnItemSelectedListener{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_demo_choice);
		
		Spinner selectionSpinner = (Spinner) findViewById(R.id.selectionSpinner1);
		ArrayAdapter<CharSequence> demonameArrayAdapter = ArrayAdapter.createFromResource(this, R.array.demoList, android.R.layout.simple_spinner_item); 
		
		selectionSpinner.setAdapter(demonameArrayAdapter);
		selectionSpinner.setOnItemSelectedListener(this);
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.demo_choice, menu);
		return true;
	}

	void showToast(CharSequence msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }



	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		showToast("selected "+position+ ", id:"+id);
		Log.d("SPINNER", "selected "+position+ ", id:"+id);
		Intent toOpen = new Intent();
		switch(position){
			case(1):{
				toOpen.setClass(this, MoveDemoActivity.class);
				startActivity(toOpen);
			}
			break;
			case(2):{
				toOpen.setClass(this, CollisionDemoActivity.class);
				startActivity(toOpen);
			}
			break;
		}
		
	}



	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		showToast("Nothing Selected, try again");
		Log.d("SPINNER", "Nothing Selected, try again");
		
	}
}
