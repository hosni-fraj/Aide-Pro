import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.LinearLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import java.io.InputStream;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;


public class MainActivity extends Activity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private LinearLayout hosni;
	private LinearLayout ninjacoder;
	private LinearLayout github;
	private LinearLayout telagram;
	private ImageView imageview1;
	private TextView textview1;
	private TextView textview2;
	private ImageView imageview2;
	private LinearLayout linear5;
	private TextView textview3;
	private TextView textview4;
	private ImageView imageview3;
	private LinearLayout linear7;
	private TextView textview5;
	private TextView textview6;
	private ImageView imageview4;
	private TextView textview7;
	private ImageView imageview5;
	private TextView textview8;
	
	private Intent Telgram_intent = new Intent();
	private Intent Github_intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = (LinearLayout) findViewById(R.id.linear1);
		linear2 = (LinearLayout) findViewById(R.id.linear2);
		linear3 = (LinearLayout) findViewById(R.id.linear3);
		hosni = (LinearLayout) findViewById(R.id.hosni);
		ninjacoder = (LinearLayout) findViewById(R.id.ninjacoder);
		github = (LinearLayout) findViewById(R.id.github);
		telagram = (LinearLayout) findViewById(R.id.telagram);
		imageview1 = (ImageView) findViewById(R.id.imageview1);
		textview1 = (TextView) findViewById(R.id.textview1);
		textview2 = (TextView) findViewById(R.id.textview2);
		imageview2 = (ImageView) findViewById(R.id.imageview2);
		linear5 = (LinearLayout) findViewById(R.id.linear5);
		textview3 = (TextView) findViewById(R.id.textview3);
		textview4 = (TextView) findViewById(R.id.textview4);
		imageview3 = (ImageView) findViewById(R.id.imageview3);
		linear7 = (LinearLayout) findViewById(R.id.linear7);
		textview5 = (TextView) findViewById(R.id.textview5);
		textview6 = (TextView) findViewById(R.id.textview6);
		imageview4 = (ImageView) findViewById(R.id.imageview4);
		textview7 = (TextView) findViewById(R.id.textview7);
		imageview5 = (ImageView) findViewById(R.id.imageview5);
		textview8 = (TextView) findViewById(R.id.textview8);
		
		hosni.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		ninjacoder.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		github.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Github_intent.setAction(Intent.ACTION_VIEW);
				Github_intent.setData(Uri.parse("https://github.com/hosni-fraj/Aide-Pro"));
				startActivity(Github_intent);
			}
		});
		
		telagram.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Telgram_intent.setAction(Intent.ACTION_VIEW);
				Telgram_intent.setData(Uri.parse("https://t.me/aideidepro"));
				startActivity(Telgram_intent);
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	@Override
	protected void onActivityResult(int _requestCode, int _resultCode, Intent _data) {
		super.onActivityResult(_requestCode, _resultCode, _data);
		switch (_requestCode) {
			
			default:
			break;
		}
	}
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}
