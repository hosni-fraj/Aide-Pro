package com.hosni.fraj.aide.util;

import android.app.Activity;

public class CodeGenerator {
    
    public static String getBasicActivityCode(String packageName, String className){
		return "package " + packageName + ";"
			+ "\n "
			+ "\nimport android.app.Activity;"
			+ "\nimport android.os.Bundle;"
			+ "\n"
			+ "\npublic class "+ className +" extends Activity { "
			+ "\n     "
			+ "\n    @Override"
			+ "\n    protected void onCreate(Bundle savedInstanceState) {"
			+ "\n        super.onCreate(savedInstanceState);"
			+ "\n        setContentView(R.layout.activity_main);"
			+ "\n        "
			+ "\n    }"
			+ "\n	"
			+ "\n} "
			+ "\n";
	}
	public static String getBasicXMLCode(){
		return "&lt;LinearLayout xmlns:android=&quot;http://schemas.android.com/apk/res/android&quot;"
		+"\nandroid:layout_width=&quot;match_parent&quot;"
		+"\nandroid:layout_height=&quot;match_parent&quot;&gt;"
		+"\n&lt;/LinearLayout&gt;";
	}
    
}
