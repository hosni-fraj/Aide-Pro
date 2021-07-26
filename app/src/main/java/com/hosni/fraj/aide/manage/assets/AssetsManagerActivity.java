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
import java.util.Collections;
import java.util.HashMap;
import android.content.ClipboardManager;
import android.widget.Toast;
import android.content.ClipData;

public class AssetsManagerActivity extends BaseActivity implements OnItemClickListener {


	private double postion = 0;
	private String file = "";
	private String last_folder = "";
	private double index = 0;
	private String my_path = "";
	private long firstBackTime;
	private String assets_path;
	private ArrayList<String> string_list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> file_list = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<String> folderList = new ArrayList<>();
	private ArrayList<String> fileList = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> files = new ArrayList<>();

	private ListView list_view;

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
		list_view = new ListView(this);
		check(base_text, base_list);
		getFiles(assets_path);
		list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
				@Override
				public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
					final int _position = _param3;
					if (FileUtil.isDirectory(files.get((int)_position).get("path").toString())) {
						my_path = files.get((int)_position).get("path").toString();
						getFiles(files.get((int)_position).get("path").toString());
					} 
				}
			});

		list_view.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
				@Override
				public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
					final int _position = _param3;
					file = files.get((int)_position).get("path").toString();
					String[] separated = file.split("/assets/");
					if (FileUtil.isDirectory(files.get((int)_position).get("path").toString())) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "file:///android_asset/".concat(separated[1]).concat("/")));
						Toast.makeText(getApplication(), "Built-in file' path copied", Toast.LENGTH_SHORT).show();
					} else {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", "file:///android_asset/".concat(separated[1])));
						Toast.makeText(getApplication(), "Built-in file' path copied", Toast.LENGTH_SHORT).show();
					}
					return true;
				}
			});

		list_view.setChoiceMode(ListView.CHOICE_MODE_NONE);

		base_list.addView(list_view, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		base.addView(base_list, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		return base;
	}
	public void getFiles(final String path) {
		list.clear();
		files.clear();
		folderList.clear();
		fileList.clear();
		FileUtil.listDir(path, list);
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		index = 0;
		for (int _repeat13 = 0; _repeat13 < (int)(list.size()); _repeat13++) {
			if (FileUtil.isDirectory(list.get((int)(index)))) {
				folderList.add(list.get((int)(index)));
			} else {
				fileList.add(list.get((int)(index)));
			}
			index++;
		}
		index = 0;
		for (int _repeat37 = 0; _repeat37 < (int)(folderList.size()); _repeat37++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("path", folderList.get((int)(index)));
				files.add(_item);
			}
			index++;
		}
		index = 0;
		for (int _repeat54 = 0; _repeat54 < (int)(fileList.size()); _repeat54++) {
			{
				HashMap<String, Object> _item = new HashMap<>();
				_item.put("path", fileList.get((int)(index)));
				files.add(_item);
			}
			index++;
		}
		list_view.setAdapter(new Assets(files));
		((BaseAdapter)list_view.getAdapter()).notifyDataSetChanged();
	}

	private void check(LinearLayout base_text, LinearLayout base_list) {
		if (ProjectUtils.getCurrentProject() == null) {
			Toast.makeText(getApplication(), "Open a project first.", Toast.LENGTH_SHORT).show();
			finish();
		} else {
			base_text.setVisibility(View.GONE);
			base_list.setVisibility(View.VISIBLE);

			assets_path = ProjectUtils.getCurrentProject().toString() + "/src/main/assets/";
			if (!FileUtil.isDirectory(assets_path)) {
				FileUtil.makeDir(assets_path);
			}
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

	@Override
	public void onBackPressed() {
		if (my_path.equals(assets_path)) {
			finish();
		} else {
			java.io.File path = new java.io.File(my_path);
			my_path = path.getParent();
			getFiles(my_path);
		}
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
			base.addView(icon, 55, 55);

			TextView title = new TextView(AssetsManagerActivity.this);
			title.setPadding(10, 0, 0, 0);
			title.setTextSize(20f);
			base.addView(title, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
			title.setText(Uri.parse(files.get((int)_position).get("path").toString().toString()).getLastPathSegment());
			if (FileUtil.isDirectory(files.get((int)_position).get("path").toString())) {
				icon.setImageResource(0x7F070049);
			} else {
				icon.setImageResource(0x7F070047);
			}

			return base;
		}


	}


}

