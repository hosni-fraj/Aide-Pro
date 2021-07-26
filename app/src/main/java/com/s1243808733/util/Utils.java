package com.s1243808733.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.Menu;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.graphics.ColorUtils;
import com.aide.ui.MainActivity;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ReflectUtils;
import com.s1243808733.aide.util.AIDEUtils;
import com.s1243808733.aide.util.ResUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Locale;

public class Utils {
    public static final String ASSETS_DATA_DIR = "data/";
    public static final File SDCARD_AIDE = new File(Environment.getExternalStorageDirectory(), ".aide");
    public static final File SDCARD_DATA_DIR = new File(SDCARD_AIDE, "data");
    public static Application app;
    public static MainActivity mainActivity;
    static String sArch;
    private static Toast toast;

    public static void copyToClipboard(CharSequence charSequence) {
        copyToClipboard(charSequence, true);
    }

    public static void copyToClipboard(CharSequence charSequence, boolean z) {
        ClipboardUtils.copyText(charSequence);
        if (z) {
            toast(isCN() ? "\u5df2\u590d\u5236\u5230\u526a\u8d34\u677f" : "Clipboard to copied");
        }
    }

    public static int dp2px(float f) {
        return (int) (0.5f + (Resources.getSystem().getDisplayMetrics().density * f));
    }

    public static Spanned fromHtml(String str) {
        return VERSION.SDK_INT >= 24 ? Html.fromHtml(str, 0) : Html.fromHtml(str);
    }

    public static void fullScrollToBottom(AlertDialog alertDialog) {
        if (alertDialog != null) {
            fullScrollToBottom((ScrollView) alertDialog.findViewById(alertDialog.getContext().getResources().getIdentifier("scrollView", "id", "android")));
        }
    }

    public static void fullScrollToBottom(ScrollView scrollView) {
        if (scrollView != null) {
            scrollView.fullScroll(130);
        }
    }

    public static Application getApp() {
        return app;
    }

    public static String getArch() {
        if (sArch == null) {
            sArch = getArch(System.getProperty("os.arch"));
        }
        return sArch;
    }

    public static String getArch(String str) {
        if (str.length() > 0) {
            switch (str.toLowerCase().charAt(0)) {
                case 'a':
                    return str.equals("amd64") ? "x86_64" : str.contains("64") ? "arm64" : "arm";
                case 'i':
                case 'x':
                    return str.contains("64") ? "x86_64" : "x86";
                case 'm':
                    return str.contains("64") ? "mips64" : "mips";
            }
        }
        return "unknown";
    }

    public static String getAssetsConfigFile(String str) {
        return new StringBuffer().append(getAssetsDataFile("config/")).append(str).toString();
    }

    public static String getAssetsDataFile() {
        return ASSETS_DATA_DIR;
    }

    public static String getAssetsDataFile(String str) {
        return new StringBuffer().append(getAssetsDataFile()).append(str).toString();
    }

    public static int getColorAccent(Context context) {
        if (VERSION.SDK_INT < 21) {
            return 0;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843829, typedValue, true);
        return typedValue.data;
    }

    public static int getColorBackground(Context context) {
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16842801, typedValue, true);
        return typedValue.data;
    }

    public static int getColorFromResources(int i) {
        return getApp().getResources().getColor(i);
    }

    public static String getFileNamePrefix(String str) {
        return null;
    }

    public static String getFileNameSuffix(String str) {
        return null;
    }

    public static MainActivity getMainActivity() {
        return null;
    }

    public static View getRootView(View view) {
        return null;
    }

    public static File getSdConfigFile(String str) {
        return null;
    }

    public static File getSdDataFile() {
        return null;
    }

    public static File getSdDataFile(String str) {
        return null;
    }

    public static File getSdDataLocationFile(String str) {
        return null;
    }

    public static SharedPreferences getSp() {
        return null;
    }

    public static SharedPreferences getSp(String str) {
        return null;
    }

    public static String getStackTrace(Throwable th) {
        return null;
    }

    public static boolean isCN() {
       return false;
    }

    public static boolean isLightColor(int i) {
        return true;
    }

    public static void logObject(String str, Object obj) {
        }

    public static void openUrl(String str) {
        }

    public static String read2String(Reader reader) {
        return null;
    }

    public static void runOnUiThread(Activity activity, Runnable runnable) {
        
    }

    public static void setAlertDialogMovementMethod(AlertDialog alertDialog) {
        
    }

    public static void setApp(Application application) {
        
    }

    public static void setMainActivity(MainActivity mainActivity) {
        
    }

    public static void setMessageIsSelectable(AlertDialog alertDialog) {
        
    }

    public static void setMessageIsSelectable(AlertDialog alertDialog, boolean z) {
        
    }

    public static void setOptionalIconsVisible(Menu menu, boolean z) {
        
    }

    public static void setSystemStatusBarLight(Activity activity, boolean z) {
        
    }

    public static void showExDialog(Context context, String str, Throwable th) {
		
    }

    public static void showExDialog(Context context, Throwable th) {
        
    }

    public static void showMsgDialog(Activity activity, String str, String str2) {
        
    }

    public static void startActivity(Context context, Intent intent) {
        
    }

    public static void startActivity(Context context, Class<?> cls) {
        
    }

    public static void startActivity(Context context, Class<?> cls, boolean z) {
        
    }

    public static String subString(String str, String str2, String str3) {
        return null;
    }

    public static String toLowerCaseFirst(String str) {
        return null;
    }

    public static String toUpperCaseFirst(String str) {
        return null;
    }

    public static Toast toast(Object obj) {
        return null;
    }

    public static Toast toast(String str) {
        return null;
    }

    public static Toast toast(Throwable th) {
        return toast(th, false);
    }

    public static Toast toast(Throwable th, boolean z) {
        return null;
    }

    public static Toast toastError(String str) {
        return null;
    }

    public static String tryRead2String(Reader reader) throws IOException {
        return null;
    }
}
