package edu.np.ece.mapg.miniproj3;

import android.app.Activity;
import android.content.ContentUris;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	ImageView imageView2;
	ImageView imageView1;
	TextView textView1;
	private String[] navMenu;
	private DrawerLayout drawerLayout;
	private ListView naviDrawerList;
	private ActionBarDrawerToggle drawerListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		imageView2 = (ImageView) findViewById(R.id.imageView2);
		imageView1 = (ImageView) findViewById(R.id.imageView1);
		textView1 = (TextView) findViewById(R.id.textView1);
		navMenu = getResources().getStringArray(R.array.menulist);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		naviDrawerList = (ListView) findViewById(R.id.left_drawer);

		naviDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, navMenu));
		naviDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		drawerListener = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.navidrawer, R.string.drawer_open,
				R.string.drawer_close) {

			@Override
			public void onDrawerOpened(View drawerView) {
				Toast.makeText(MainActivity.this, "Select your options",
						Toast.LENGTH_SHORT).show();
			}

		};
		drawerLayout.setDrawerListener(drawerListener);
		getActionBar().setHomeButtonEnabled(true);
		getActionBar().setDisplayHomeAsUpEnabled(true);

	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView parent, View view, int position,
				long id) {
			switch (position) {
			case 0: {
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				break;
			}

			case 1: {
				Intent i = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://www.np.edu.sg"));
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(i);
				break;
			}
			case 2: {
				Intent a = new Intent(getBaseContext(), SocialActivity.class);
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(a);
				break;
			}
			case 3: {
				Intent a = new Intent(getBaseContext(), News.class);
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(a);
			}
				break;
			case 4: {
				long startMillis = System.currentTimeMillis();
				Uri.Builder builder = CalendarContract.CONTENT_URI.buildUpon();
				builder.appendPath("time");
				ContentUris.appendId(builder, startMillis);
				Intent c = new Intent(Intent.ACTION_VIEW).setData(builder
						.build());
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(c);
				break;
			}
			case 5: {
				Intent calendarIntent = new Intent(Intent.ACTION_EDIT);
				calendarIntent.setType("vnd.android.cursor.item/event");
				calendarIntent.putExtra("title", "Title");
				String startTimeMillis = null;
				calendarIntent.putExtra("beginTime", startTimeMillis);
				String endTimeMillis = null;
				calendarIntent.putExtra("endTime", endTimeMillis);
				calendarIntent.putExtra("description", "Description");
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(calendarIntent);

			}
				break;

			case 6: {
				Intent a = new Intent(getBaseContext(), MusicActivity.class);
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(a);
			}
				break;
			case 7: {
				Intent a = new Intent(getBaseContext(), Photography.class);
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(a);
			}
				break;

			case 8: {
				Intent i = new Intent(Intent.ACTION_VIEW,
						Uri.parse("http://outlook.com/connect.np.edu.sg"));
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(i);
				break;
			}
			case 9: {
				Intent j = new Intent(getBaseContext(), Feedback.class);
				textView1.setVisibility(View.INVISIBLE);
				imageView1.setVisibility(View.VISIBLE);
				imageView2.setVisibility(View.INVISIBLE);
				startActivity(j);
				break;

			}

			case 10: {

				textView1.setVisibility(View.VISIBLE);
				imageView1.setVisibility(View.INVISIBLE);
				imageView2.setVisibility(View.VISIBLE);

			}
				break;

			default:
				break;
			}
			selectItem(position);
		}
	}

	/** Swaps fragments in the main content view */
	private void selectItem(int position) {
		// Create a new fragment and specify the planet to show based on
		// position

		// Highlight the selected item, update the title, and close the drawer
		naviDrawerList.setItemChecked(position, true);
		setTitle(navMenu[position]);
		drawerLayout.closeDrawer(naviDrawerList);
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
		if (drawerListener.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
