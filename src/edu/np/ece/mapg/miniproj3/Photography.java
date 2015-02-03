package edu.np.ece.mapg.miniproj3;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Photography extends Activity {
	ImageButton imgFlickr;
	ImageButton imgImgur;
	ImageButton imgInsta;
	Button btBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_photography);
		
		imgFlickr = (ImageButton) this.findViewById(R.id.imgFlickr);
		imgImgur = (ImageButton) this.findViewById(R.id.imgImgur);
		imgInsta = (ImageButton) this.findViewById(R.id.imgInsta);
		btBack = (Button) this.findViewById(R.id.btBack);

		imgFlickr.setOnClickListener(listener);
		imgImgur.setOnClickListener(listener);
		imgInsta.setOnClickListener(listener);
		btBack.setOnClickListener(listener);
	}

	private View.OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.imgFlickr:
				Intent t = new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://www.flickr.com/explore"));
				startActivity(t);
				break;
			case R.id.imgImgur:
				Intent u = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://imgur.com/"));
				startActivity(u);
				break;
			case R.id.imgInsta:
				Intent y = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://instagram.com/"));
				startActivity(y);
				break;
			case R.id.btBack:
				finish();

				break;
			}

		}

	};

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.photography, menu);
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
