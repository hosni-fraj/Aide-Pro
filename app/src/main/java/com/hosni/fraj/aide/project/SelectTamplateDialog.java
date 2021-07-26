package com.hosni.fraj.aide.project;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.aide.common.ab;

public class SelectTamplateDialog {



	private Activity mActivity;
	private String mCreateDir;
	private ab<String> mAbVar;

    public SelectTamplateDialog(Activity activity, String str, ab<String> mAb) {
		mActivity = activity;
		mCreateDir = str;
		mAbVar = mAb;
	}

	public void showDialog() {
		CharSequence[] items = {"Basic Activity", "NavigationView Activity", "BottomNavigation Activity", "Fullscreen Activity"};
		final AlertDialog dialog = new AlertDialog.Builder(mActivity)
			.setTitle("Activity Tamplate")
			.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dia, int which) {

					if (which == 0) {
						new AddCustomActivityTemplateDialog(mActivity, mCreateDir, mAbVar, "basic").showDialog();
						dia.dismiss();
					} else if (which == 1) {
						dia.dismiss();
					} else if (which == 2) {
						dia.dismiss();
					} else if (which  == 3) {
						dia.dismiss();
					}

				}
			})
			.create();
		dialog.show();
	}

}
