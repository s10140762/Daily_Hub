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

public class MusicActivity extends Activity {

	ImageButton imDeezer;
	ImageButton imSpotify;
	ImageButton imMog;
	Button btBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_music);

		imDeezer = (ImageButton) this.findViewById(R.id.imDeezer);
		imSpotify = (ImageButton) this.findViewById(R.id.imSpotify);
		imMog = (ImageButton) this.findViewById(R.id.imMog);
		btBack = (Button) this.findViewById(R.id.btBack);

		imDeezer.setOnClickListener(listener);
		imSpotify.setOnClickListener(listener);
		imMog.setOnClickListener(listener);
		btBack.setOnClickListener(listener);
	}

	private View.OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.imDeezer:
				Intent f = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.deezer.com/en/"));
				startActivity(f);
				break;
			case R.id.imSpotify:
				Intent t = new Intent(Intent.ACTION_VIEW,
						Uri.parse("https://www.spotify.com/sg-en/"));
				startActivity(t);
				break;
			case R.id.imMog:
				Intent i = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.mog.com/"));
				startActivity(i);
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
		getMenuInflater().inflate(R.menu.music, menu);
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
