package edu.np.ece.mapg.miniproj3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Feedback extends Activity {

	EditText etName;
	EditText editText1;
	Button btNext;
	Button btBack;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		
		
		
		btNext = (Button) this.findViewById(R.id.btNext);
		etName = (EditText) this.findViewById(R.id.etName);
		editText1 = (EditText)this.findViewById(R.id.editText1);
		btBack = (Button) this.findViewById(R.id.btBack);
		btNext.setOnClickListener(nextListener);
		btBack.setOnClickListener(listener);
	}
	
	
	View.OnClickListener listener = new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			finish();
		}
	};
	View.OnClickListener nextListener = new View.OnClickListener() {
		
		@Override
		public void onClick(View v) {
				Intent email = new Intent(Intent.ACTION_SEND);
				String FeedBack = etName.getText().toString() + "\n\n"+ editText1.getText();
				email.putExtra(Intent.EXTRA_EMAIL, new String[]{"s10140762@connect.np.edu.sg"});		  
				email.putExtra(Intent.EXTRA_SUBJECT, "Service FeedBack");
				email.putExtra(Intent.EXTRA_TEXT, FeedBack);
				email.setType("message/rfc822");
				startActivity(Intent.createChooser(email, "Choose an Email client :"));
		}
	};
	
	
	
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
	}}
