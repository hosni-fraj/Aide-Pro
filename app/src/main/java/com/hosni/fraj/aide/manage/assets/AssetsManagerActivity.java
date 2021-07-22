package com.hosni.fraj.aide.manage.assets;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TableLayout.LayoutParams;
import android.widget.TextView;
import com.hosni.fraj.aide.util.FileUtil;
import com.s1243808733.aide.util.ProjectUtils;
import com.s1243808733.app.base.BaseActivity;
import java.util.ArrayList;
import java.util.HashMap;

public class AssetsManagerActivity extends BaseActivity implements OnItemClickListener {


	private ArrayList<String> file_list = new ArrayList<>();
	ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	@Override
	public void onItemClick(AdapterView<?> p1, View p2, int p3, long p4) {
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(getContentView());
        getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setTitle("Assets");
    }

	private View getContentView() {
		LinearLayout base = new LinearLayout(this);
		base.setOrientation(0);
		base.setGravity(Gravity.CENTER);
		base.setBackgroundColor(Color.WHITE);
		LinearLayout base_text = new LinearLayout(this);
		base_text.setGravity(Gravity.CENTER);
		base_text.setBackgroundColor(Color.WHITE);
		TextView txt_dev = new TextView(this);

		txt_dev.setAlpha(0.8f);
		txt_dev.setGravity(Gravity.CENTER);
		base_text.addView(txt_dev, LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		base.addView(base_text, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		LinearLayout base_list = new LinearLayout(this);
		base_list.setGravity(Gravity.CENTER);
		base_list.setBackgroundColor(Color.WHITE);
		ListView list = new ListView(this);
		//list.setChoiceMode(ListView.CHOICE_MODE_NONE);
		refreshList(base_text, base_list, list, txt_dev);
		base_list.addView(list, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		base.addView(base_list, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		return base;
	}

	private void refreshList(LinearLayout base_text, LinearLayout base_list, ListView list, TextView txt) {

		if (ProjectUtils.getCurrentProject() == null) {
			txt.setText("No project opened.");
			base_text.setVisibility(View.VISIBLE);
			base_list.setVisibility(View.GONE);
		} else {
			txt.setText("No File Found! \n You can create / import file by clicking the menu icon.");
			FileUtil.listDir(ProjectUtils.getCurrentProject().toString() + "/src/main/assets/", file_list);
			
			int postion = 0;

			for (int _repeat21 = 0; _repeat21 < (int)(file_list.size()); _repeat21++) {
				{
					HashMap<String, Object> _item = new HashMap<>();
					_item.put("key", file_list.get((int)(postion)));
					map.add(_item);
				}

				postion++;
			}

			list.setAdapter(new Assets(map));
			((BaseAdapter)list.getAdapter()).notifyDataSetChanged();
            base_text.setVisibility(View.GONE);
		    base_list.setVisibility(View.VISIBLE);

		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(Menu.NONE, 0, Menu.NONE, "New").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

				@Override
				public boolean onMenuItemClick(MenuItem item) {
					newFile();
					return false;
				}


			});
		menu.add(Menu.NONE, 1, Menu.NONE, "Import").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

				@Override
				public boolean onMenuItemClick(MenuItem item) {
					importFile();
					return false;
				}

			});
		menu.add(Menu.NONE, 1, Menu.NONE, "Refresh").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

				@Override
				public boolean onMenuItemClick(MenuItem item) {
					View v = getContentView();
					return false;
				}

			});
		return true;
	}

	private void importFile() {
	}

	private void newFile() {
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem menuItem) {
		switch (menuItem.getItemId()) {
			case 16908332:
				finish();
				break;
		}
		return super.onOptionsItemSelected(menuItem);
	}


	public class Assets extends BaseAdapter {
		ArrayList<HashMap<String, Object>> _data;
		public Assets(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}

		@Override
		public int getCount() {
			return _data.size();
		}

		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}

		@Override
		public long getItemId(int _index) {
			return _index;
		}
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LinearLayout base = new LinearLayout(AssetsManagerActivity.this);

			base.setOrientation(0);
			base.setBackgroundColor(Color.WHITE);
			base.setGravity(Gravity.CENTER_VERTICAL);
			base.setPadding(7, 7, 7, 7);
			ImageView icon = new ImageView(AssetsManagerActivity.this);
			icon.setScaleType(ImageView.ScaleType.FIT_CENTER);
			base.addView(icon, 40, 40);

			TextView title = new TextView(AssetsManagerActivity.this);
			title.setPadding(10, 0, 0, 0);
			title.setTextSize(17f);
			base.addView(title, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			title.setText(Uri.parse(map.get((int)_position).get("key").toString()).getLastPathSegment());
			if (FileUtil.isDirectory(file_list.get((int)(_position)))) {
				icon.setImageResource(0x7F070049);
			} else {
				icon.setImageResource(0x7F070047);
			}

			return base;
		}


	}


}

