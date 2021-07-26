package com.s1243808733.aide.util;

import android.app.Activity;
import android.content.res.AssetManager;
import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ObjectUtils;
import com.blankj.utilcode.util.StringUtils;
import com.s1243808733.util.Utils;
import java.io.File;
import java.io.InputStream;
import java.util.Locale;

public class ResUtils {
	
    public static Locale getLocale() {
        Activity mainActivity = AIDEUtils.getMainActivity();
        if (mainActivity == null) {
            mainActivity = ActivityUtils.getTopActivity();
        }
        return mainActivity == null ? (Locale) null : mainActivity.getResources().getConfiguration().locale;
    }

    public static File getLocaleFile(File file) {
        if (file == null) {
            return (File) null;
        }
        File file2 = (File) null;
        String absolutePath = file.getAbsolutePath();
        String str = (String) ObjectUtils.getOrDefault(FileUtils.getFileExtension(absolutePath), "");
        absolutePath = (String) ObjectUtils.getOrDefault(FileUtils.getFileNameNoExtension(absolutePath), "");
        Locale locale = getLocale();
        if (locale != null) {
            String language = locale.getLanguage();
            Object country = locale.getCountry();
            StringBuffer stringBuffer = new StringBuffer(absolutePath);
            StringBuffer stringBuffer2 = new StringBuffer(absolutePath);
            if (!StringUtils.isEmpty(language)) {
                stringBuffer.append("-").append(language);
                stringBuffer2.append("-").append(language);
            }
            /*if (!StringUtils.isEmpty(country)) {
                stringBuffer2.append("-r").append(country);
            }*/
            stringBuffer.append(str);
            stringBuffer2.append(str);
            str = stringBuffer2.toString();
            if (FileUtils.isFileExists(str)) {
                file2 = FileUtils.getFileByPath(str);
            }
            str = stringBuffer.toString();
            if (FileUtils.isFileExists(str)) {
                file2 = FileUtils.getFileByPath(str);
            }
        }
        if (file2 != null && file2.exists()) {
            file = file2;
        }
        return file;
    }

    public static InputStream openAssetsLocaleFile(String str) {
        InputStream inputStream = (InputStream) null;
        AssetManager assets = Utils.getApp().getAssets();
        Locale locale = getLocale();
        if (locale != null) {
            String language = locale.getLanguage();
            Object country = locale.getCountry();
            StringBuffer stringBuffer = new StringBuffer(str);
            StringBuffer stringBuffer2 = new StringBuffer(str);
            if (!StringUtils.isEmpty(language)) {
                stringBuffer.append("-").append(language);
                stringBuffer2.append("-").append(language);
            }
            /*if (!StringUtils.isEmpty(country)) {
                stringBuffer2.append("-r").append(country);
            }*/
            if (inputStream == null) {
                try {
                    inputStream = assets.open(stringBuffer2.toString());
                } catch (Throwable th) {
                }
            }
            if (inputStream == null) {
                try {
                    inputStream = assets.open(stringBuffer.toString());
                } catch (Throwable th2) {
                }
            }
        }
        if (inputStream == null) {
            try {
                inputStream = assets.open(str);
            } catch (Throwable th3) {
            }
        }
        return inputStream;
    }
}
