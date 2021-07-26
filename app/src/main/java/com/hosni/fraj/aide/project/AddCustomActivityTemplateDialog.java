package com.hosni.fraj.aide.project;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aide.common.ab;
import com.hosni.fraj.aide.util.CodeGenerator;
import com.hosni.fraj.aide.util.FileUtil;
import com.s1243808733.aide.util.AIDEUtils;
import com.s1243808733.aide.util.ProjectUtils;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class AddCustomActivityTemplateDialog {

    private Activity mActivity;
	private String mCreateDir;
	private ab<String> mAbVar;
	private String mTamplate;
	private String getPackage;
    private String getPackageManifest;
    private String importPackageR;

	private LinearLayout base;
	private EditText mActivityName;
	private EditText mXmlName;
	private EditText mLabelName;

    public AddCustomActivityTemplateDialog(Activity activity, String str, ab<String> mAb, String tamplate) {
		mActivity = activity;
		mCreateDir = str;
		mAbVar = mAb;
		mTamplate = tamplate;
	}

	public void showDialog() {
		AlertDialog dialog = new AlertDialog.Builder(mActivity)
			.setTitle("Adjust Activity")

			.setView(getContentView())
			.setNeutralButton("Help", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dia, int which) {
					AlertDialog dialog = new AlertDialog.Builder(mActivity)
						.setTitle("Help")
						.setMessage("You must set titles without extension e.g. myactivity")
						.setPositiveButton("Ok", new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dia, int which) {

							}
						})
						//.setNegativeButton("Cancel", null)
						.create();
                    dialog.show();
				}
			})

			.setPositiveButton("Add", new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dia, int which) {
					if (mActivityName.getText().toString().equals("")) {
						mActivityName.setError("Empty");
					} else if (mXmlName.getText().toString().equals("")) {
						mXmlName.setError("Empty");
					} else if (mLabelName.getText().toString().equals("")) {
						mLabelName.setError("Empty");
					} else {
						try {
							androidManifest(mActivityName.getText().toString(), mLabelName.getText().toString());
						} catch (Exception e) {
							Toast.makeText(mActivity, e.toString(), Toast.LENGTH_SHORT).show();
						}
						FileUtil.writeFile(ProjectUtils.getRes(ProjectUtils.getCurrentProject()).toString() + "/layout/" + mXmlName.getText().toString() + ".xml", LoadData("templates/basicxml.xml"));
						FileUtil.writeFile(mCreateDir + "/" + mActivityName.getText().toString() + ".java", CodeGenerator.getBasicActivityCode(getPackage, mActivityName.getText().toString()));
						AIDEUtils.openFile(new File(ProjectUtils.getRes(ProjectUtils.getCurrentProject()).toString() + "/" + mXmlName.getText().toString()));
						AIDEUtils.openFile(new File(mCreateDir + "/" + mActivityName.getText().toString()));
						AIDEUtils.reLoadFileBrowser();
						dia.dismiss();
					}
				}
			})
			.setNegativeButton("Cancel", null)

			.create();
		dialog.show();
    }
	public String LoadData(String inFile) {
        String tContents = "";

		try {
			InputStream stream = mActivity.getAssets().open(inFile);

			int size = stream.available();
			byte[] buffer = new byte[size];
			stream.read(buffer);
			stream.close();
			tContents = new String(buffer);
		} catch (IOException e) {
			// Handle exceptions here
		}

		return tContents;

	}

	public View getContentView() {
		base = new LinearLayout(mActivity);
		base.setPadding(dp2px((float) 24), dp2px((float) 10), dp2px((float) 24), 0);
		base.setOrientation(1);
		base.addView(getTextView("Activity Name"), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		mActivityName = new EditText(mActivity);
		//mActivityName.setPadding(7, 7, 7, 7);
		mActivityName.setHint("Activity Name");
		mActivityName.setTextSize(18f);
		mActivityName.setSingleLine(true);
		base.addView(mActivityName, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		base.addView(getTextView("Xml file name"), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		mXmlName = new EditText(mActivity);
		//mXmlName.setPadding(7, 7, 7, 7);
		mXmlName.setHint("Xml File Name");
		mXmlName.setTextSize(18f);
		mXmlName.setSingleLine(true);
		base.addView(mXmlName, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		base.addView(getTextView("Label"), LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		mLabelName = new EditText(mActivity);
		//mLabelName.setPadding(7, 7, 7, 7);
		mLabelName.setHint("Label");
		mLabelName.setTextSize(18f);
		mLabelName.setSingleLine(true);
		base.addView(mLabelName, LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		return base;
	}
	public TextView getTextView(String title) {
		TextView txt = new TextView(mActivity);
		txt.setText(title + ":");
		txt.setTextSize(18f);
		txt.setPadding(7, 7, 7 , 11);
		return txt;
	}
	private void androidManifest(String var1, String var2) throws Exception {
		String var3 = FileUtil.readFile(ProjectUtils.getCurrentProject().toString() + "/src/main/AndroidManifest.xml");
		this.getPackageManifest = var3.split("package=\"")[1].split("\"")[0];
		this.getPackage = (mCreateDir.replace("/", ".") + "end").split("java.")[1].split("end")[0];
		this.importPackageR = "\nimport " + this.getPackageManifest + ".R;";
		String var4 = this.strSpace(8) + "<activity%n" + this.strSpace(12) + "android:name=\"%s\"%n" + this.strSpace(12) + "android:label=\"%s\"/>%n" + this.strSpace(4) + "</application>";
		String[] var5 = var3.split("\n");
		StringBuilder var6 = new StringBuilder();

		for (int var7 = 0; var7 < var5.length; ++var7) {
			var3 = var5[var7];
			if (var3.contains("</application>")) {
				if (!this.getPackage.equals(this.getPackageManifest) && this.getPackage.contains(this.getPackageManifest)) {
					var3 = this.getPackage.split(this.getPackageManifest)[1];
					var3 = String.format(var4, new Object[]{var3 + "." + var1, var2});
				} else if (this.getPackage.equals(this.getPackageManifest)) {
					var3 = String.format(var4, new Object[]{"." + var1, var2});
				} else {
					var3 = String.format(var4, new Object[]{this.getPackage + "." + var1, var2});
				}

				var6.append(var3 + System.lineSeparator());
			} else {
				var6.append(var3 + System.lineSeparator());
			}
		}

		FileUtil.writeFile(ProjectUtils.getCurrentProject() + "/src/main/AndroidManifest.xml", var6.toString());
	}
	public static int dp2px(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

	private String strSpace(int var1) {
		String var2 = "";

		for (int var3 = 0; var3 < var1; ++var3) {
			var2 = var2 + " ";
		}

		return var2;
	}


}
