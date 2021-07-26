package com.hosni.fraj.aide.project;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import com.aide.common.ab;
import com.s1243808733.aide.util.CreateClassDialog;

public class SelectOptionDialog {
    
	private Activity mActivity;
	private String mCreateDir;
	private ab<String> mAbVar;
	
    public SelectOptionDialog(Activity activity, String str, ab<String> mAb){
		mActivity = activity;
		mCreateDir = str;
		mAbVar = mAb;
	}
	
	public void showDialog(){
		CharSequence[] items = {"New class", "New activity"};
		final AlertDialog dialog = new AlertDialog.Builder(mActivity)
			.setTitle("Action")
			.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dia, int which) {
					if(which == 0){
						new CreateClassDialog(mActivity, mCreateDir, mAbVar).showDialog();
						dia.dismiss();
					} else if (which == 1){
						new SelectTamplateDialog(mActivity, mCreateDir, mAbVar).showDialog();
						dia.dismiss();
					}
					
				}
			})
			.create();
		dialog.show();
	}
    
}
