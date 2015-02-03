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

public class News extends Activity {

	ImageButton btST;
	ImageButton btCNA;
	ImageButton imgVT;
	ImageButton imgInfo;
	Button btBack;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_news);

		btST = (ImageButton) this.findViewById(R.id.btST);
		btCNA = (ImageButton) this.findViewById(R.id.btCNA);
		btBack = (Button) this.findViewById(R.id.btBack);
		imgVT = (ImageButton) this.findViewById(R.id.imgVT);
		imgInfo = (ImageButton) this.findViewById(R.id.imgInfo);

		imgInfo.setOnClickListener(listener);
		imgVT.setOnClickListener(listener);
		btST.setOnClickListener(listener);
		btCNA.setOnClickListener(listener);
		btBack.setOnClickListener(listener);
	}

	private View.OnClickListener listener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btST:
				Intent f = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.straitstimes.com/news"));
				startActivity(f);
				break;
			case R.id.btCNA:
				Intent t = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.channelnewsasia.com/"));
				startActivity(t);
				break;
			case R.id.imgVT:
				Intent u = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.veteranstoday.com/"));
				startActivity(u);
				break;
			case R.id.imgInfo:
				Intent g = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.infowars.com/"));
				startActivity(g);
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
		getMenuInflater().inflate(R.menu.news, menu);
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
