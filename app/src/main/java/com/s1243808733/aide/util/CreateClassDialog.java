package com.s1243808733.aide.util;
import android.app.Activity;
import com.aide.common.ab;
import com.hosni.fraj.aide.project.SelectOptionDialog;

public class CreateClassDialog 
{
	private final ab<String> mAbVar;
    private final Activity mActivity;
    private final String mCreateInDir;
	
	public CreateClassDialog(Activity activity, String str, ab<String> abVar) {
        this.mActivity = activity;
        this.mCreateInDir = str;
        this.mAbVar = abVar;
    }
	public void showAddClassDialog(){
		
	}
	/* To select between @showAddClassDialog and @showAddActivityDialog */
    public static void showDialog(Activity activity, String str, ab<String> abVar) {
        new SelectOptionDialog(activity, str, abVar).showDialog();
    }

	public void showDialog() {
		
	}
}
