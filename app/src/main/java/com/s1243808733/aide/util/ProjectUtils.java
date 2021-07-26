package com.s1243808733.aide.util;

import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import com.blankj.utilcode.util.FileUtils;
import com.blankj.utilcode.util.ImageUtils;
import com.s1243808733.aide.application.App;
import com.s1243808733.util.Utils;
import java.io.File;
import java.io.FileInputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import java.io.IOException;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;

public class ProjectUtils {
    public static final String MANIFEST_MIN_SDK_VERSION = "android:minSdkVersion";
    public static final String MANIFEST_PACKAGE = "package";
    public static final String MANIFEST_TARGET_SDK_VERSION = "android:targetSdkVersion";
    public static final String MANIFEST_VERSION_CODE = "android:versionCode";
    public static final String MANIFEST_VERSION_NAME = "android:versionName";
	
	
	/* 
	* Path of the current project, if there is not opened project it
	* it will @return with 'null'
	*/
    public static File currentProject() {
        return getCurrentProject();
    }
	
	/*
	* @file currentProject
	* return AndroidManifest.xml full path 
	*/
    public static File getAndroidManifest(File file) {
        return getMain(file, "AndroidManifest.xml");
    }
	
	/*
	* @file Current Project
	* @return (Drawable) current project' app icon from manifest 
	*/
    public static Drawable getAppIconFromManifest(File file) {
        Resources resources = null;//App.getApp().getResources();
        if (!file.exists() || !file.isFile()) {
            return (Drawable) null;
        }
        try {
			NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getElementsByTagName("manifest");
		} catch (IOException e) {} catch (SAXException e) {} catch (ParserConfigurationException e) {}
       /* if (elementsByTagName.getLength() == 0) {
            return (Drawable) null;
        }*/
        NodeList childNodes = null;//elementsByTagName.item(0).getChildNodes();
        int i = 0;
        while (i < childNodes.getLength()) {
            try {
                Node item = childNodes.item(i);
                if ("application".equals(item.getNodeName())) {
                    item = item.getAttributes().getNamedItem("android:icon");
                    if (item == null) {
                        return (Drawable) null;
                    }
                    String nodeValue = item.getNodeValue();
                    if (nodeValue.startsWith("@") && nodeValue.contains(":") && nodeValue.contains("/")) {
                        try {
                            return resources.getDrawable(resources.getIdentifier(Utils.subString(nodeValue, "/", (String) null), Utils.subString(nodeValue, ":", "/"), Utils.subString(nodeValue, "@", ":")));
                        } catch (NotFoundException e) {
                        }
                    } else if (!nodeValue.startsWith("@") || !nodeValue.contains("/")) {
                        return (Drawable) null;
                    } else {
                        File file2 = new File(file.getParentFile(), "res");
                        String substring = nodeValue.substring(1);
                        substring = getAppIconFromRes(file2, substring.substring(0, substring.indexOf("/")), nodeValue.substring(nodeValue.indexOf("/") + 1));
                        return substring == null ? (BitmapDrawable) null : new BitmapDrawable(ImageUtils.getBitmap(FileUtils.getFileByPath(substring)));
                    }
                } else {
                    i++;
                }
            } catch (Throwable th) {
            }
        }
        return (Drawable) null;
    }
	
    public static String getAppIconFromRes(File file, String str, String str2) {
        System.out.println(str);
        File[] listFiles = null; //file.listFiles(new 100000000(str));
        if (listFiles != null && listFiles.length > 0) {
            for (File listFiles2 : listFiles) {
               // File[] listFiles3 = listFiles2.listFiles(new 100000001(str2));
                /*if (listFiles3 != null && listFiles3.length > 0) {
                    return listFiles3[0].getAbsolutePath();
                }*/
            }
        }
        return (String) null;
    }

    public static String getAppLabelFromManifest(File file) {
        try {
            if (!file.exists() || !file.isFile()) {
                return (String) null;
            }
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getElementsByTagName("manifest");
            if (elementsByTagName.getLength() == 0) {
                return (String) null;
            }
            NodeList childNodes = elementsByTagName.item(0).getChildNodes();
            int i = 0;
            while (i < childNodes.getLength()) {
                Node item = childNodes.item(i);
                if ("application".equals(item.getNodeName())) {
                    item = item.getAttributes().getNamedItem("android:label");
                    if (item == null) {
                        return (String) null;
                    }
                    String nodeValue = item.getNodeValue();
                    if (nodeValue.startsWith("@android:string/")) {
                        Resources resources = null; /*App.getApp().getResources();*/
                        try {
                            return resources.getString(resources.getIdentifier(nodeValue.substring("@android:string/".length()), "string", "android"));
                        } catch (NotFoundException e) {
                        }
                    } else if (!nodeValue.startsWith("@string/")) {
                        return nodeValue;
                    } else {
                        nodeValue = getAppLabelFromStrings(new File(file.getParentFile(), "res/values/strings.xml"), nodeValue.substring(nodeValue.indexOf("/") + 1));
                        return nodeValue != null ? nodeValue.replace("\\", "") : nodeValue;
                    }
                } else {
                    i++;
                }
            }
            return (String) null;
        } catch (Throwable th) {
        }
		return null;
	}

    public static String getAppLabelFromProject(File file) {
        return getAppLabelFromManifest(getAndroidManifest(file));
    }

    public static String getAppLabelFromStrings(File file, String str) {
        try {
            if (!file.exists() || !file.isFile()) {
                return (String) null;
            }
            NodeList elementsByTagName = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(file).getElementsByTagName("resources");
            if (elementsByTagName.getLength() == 0) {
                return (String) null;
            }
            NodeList childNodes = elementsByTagName.item(0).getChildNodes();
            for (int i = 0; i < childNodes.getLength(); i++) {
                Node item = childNodes.item(i);
                if ("string".equals(item.getNodeName())) {
                    Node namedItem = item.getAttributes().getNamedItem("name");
                    if (namedItem != null && str.equals(namedItem.getNodeValue())) {
                        String textContent = item.getTextContent();
                        if (!textContent.startsWith("@android:string/")) {
                            return textContent.startsWith("@string/") ? getAppLabelFromStrings(file, textContent.substring(textContent.indexOf("/") + 1)) : textContent;
                        } else {
                            Resources resources = null; // App.getApp().getResources();
                            try {
                                return resources.getString(resources.getIdentifier(textContent.substring("@android:string/".length()), "string", "android"));
                            } catch (NotFoundException e) {
                            }
                        }
                    }
                }
            }
            return (String) null;
        } catch (Throwable th) {
        }
		return null;
	}
	
	/* 
	* @return Projects Path
	*/
    public static File getAppProjects() {
        String string = Utils.getSp().getString("project_home", getDefaultAppProjects().getAbsolutePath());
        if (string == null || !string.startsWith("/")) {
            return getDefaultAppProjects();
        }
        File newFile = newFile(string);
        return newFile == null ? getDefaultAppProjects() : newFile;
    }

    public static File getAssets(File file) {
        return getMain(file, "assets");
    }

    public static File getAssets(File file, String str) {
        return newFile(getAssets(file), str);
    }

    public static File getBin(File file) {
        return isGradleProject(file) ? getBuild(file, "bin") : isEclipseProject(file) ? newFile(file, "bin") : isJavaProject(file) ? newFile(file, "bin") : (File) null;
    }

    public static File getBin(File file, String str) {
        return newFile(getBin(file), str);
    }

    public static File getBinClassesDebug(File file) {
        return getBin(file, "classesdebug");
    }

    public static File getBinClassesDebug(File file, String str) {
        return newFile(getBinClassesDebug(file), str);
    }

    public static File getBinClassesRelease(File file) {
        return getBin(file, "classesrelease");
    }

    public static File getBinClassesRelease(File file, String str) {
        return newFile(getBinClassesRelease(file), str);
    }

    public static File getBinInjectedManifest(File file) {
        return getBin(file, "injected/AndroidManifest.xml");
    }

    public static File getBinJarDex(File file) {
        return getBin(file, "jardex");
    }

    public static File getBinJarDex(File file, String str) {
        return newFile(getBinJarDex(file), str);
    }

    public static File getBinResourcesAp(File file) {
        return getBin(file, "resources.ap_");
    }

    public static File getBuild(File file) {
        return getProjectFile(file, "build");
    }

    public static File getBuild(File file, String str) {
        return newFile(getBuild(file), str);
    }

    public static File getCurrentProject() {
        return newFile(AIDEUtils.getCurrentAppHome());
    }

    public static File getDefaultAppProjects() {
        return newFile(Environment.getExternalStorageDirectory(), "AppProjects");
    }

    public static File getLibs(File file) {
        return getProjectFile(file, "libs");
    }

    public static File getLibs(File file, String str) {
        return newFile(getLibs(file), str);
    }

    public static File getMain(File file) {
        return isGradleProject(file) ? newFile(file, "src/main") : (isEclipseProject(file) || isJavaProject(file)) ? file : (File) null;
    }

    public static File getMain(File file, String str) {
        return newFile(getMain(file), str);
    }
    
    public static String getManifestAttributeValueByName(File file, String str, String str2) {
        XmlPullParser newPullParser = null;//XmlPullParserFactory.newInstance().newPullParser();
      //  newPullParser.setInput(new FileInputStream(file), "utf-8");
        while (true/*newPullParser.next() != 1*/) {
            int i;
            if ("manifest".equals(newPullParser.getName())) {
                if (str == null) {
                    i = 0;
                    while (i < newPullParser.getAttributeCount()) {
                        try {
                            if (str2.equals(newPullParser.getAttributeName(i))) {
                                return newPullParser.getAttributeValue(i);
                            }
                            i++;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                } else {
                    //newPullParser.next();
                }
            } else if (str != null && str.equals(newPullParser.getName())) {
                for (i = 0; i < newPullParser.getAttributeCount(); i++) {
                    if (str2.equals(newPullParser.getAttributeName(i))) {
                        return newPullParser.getAttributeValue(i);
                    }
                }
            }
           // newPullParser.next();
        }
        
    }

    public static String getManifestValue(File file, String str) {
        return (MANIFEST_PACKAGE.equals(str) || MANIFEST_VERSION_CODE.equals(str) || MANIFEST_VERSION_NAME.equals(str)) ? getManifestAttributeValueByName(file, (String) null, str) : (MANIFEST_MIN_SDK_VERSION.equals(str) || MANIFEST_TARGET_SDK_VERSION.equals(str)) ? getManifestAttributeValueByName(file, "uses-sdk", str) : (String) null;
    }

    public static String getPackageName(File file) {
        String packageNameFromManifest = getPackageNameFromManifest(getAndroidManifest(file));
        return packageNameFromManifest != null ? packageNameFromManifest : getPackageNameFromManifest(getBinInjectedManifest(file));
    }

    public static String getPackageNameFromManifest(File file) {
        return getManifestValue(file, MANIFEST_PACKAGE);
    }

    public static File getProguardFile(File file) {
        File newFile = newFile(file, "proguard-rules.pro");
        if (isExists(newFile)) {
            return newFile;
        }
        newFile = newFile(file, "proguard-project.txt");
        return !isExists(newFile) ? (File) null : newFile;
    }

    public static File getProjectFile(File file, String str) {
        return newFile(file, str);
    }

    public static File getRes(File file) {
        return getMain(file, "res");
    }

    public static File getRes(File file, String str) {
        return newFile(getRes(file), str);
    }

    public static File getSrcJava(File file) {
        return isGradleProject(file) ? getMain(file, "java") : isEclipseProject(file) ? newFile(file, "src") : isJavaProject(file) ? newFile(file, "src") : (File) null;
    }

    public static File getSrcJava(File file, String str) {
        return newFile(getSrcJava(file), str);
    }

    public static File getSrcJavaPkg(File file) {
        String packageName = getPackageName(file);
        return packageName == null ? (File) null : newFile(getSrcJava(file), packageName.replace(".", "/"));
    }

    public static String getVersionName(File file) {
        String versionNameFromManifest = getVersionNameFromManifest(getAndroidManifest(file));
        return versionNameFromManifest != null ? versionNameFromManifest : getVersionNameFromManifest(getBinInjectedManifest(file));
    }

    public static String getVersionNameFromManifest(File file) {
        return getManifestValue(file, MANIFEST_VERSION_NAME);
    }

    public static boolean isAndroidProject(File file) {
        return isGradleProject(file) || isEclipseProject(file);
    }

    public static boolean isEclipseProject(File file) {
        return file != null && newFile(file, "AndroidManifest.xml").exists() && newFile(file, "src").exists();
    }

    private static boolean isExists(File file) {
        return file != null && file.exists();
    }

    public static boolean isGradleProject(File file) {
        return file != null && new File(file, "build.gradle").exists() && new File(file, "src").exists();
    }

    public static boolean isJavaProject(File file) {
        File newFile = newFile(file, ".classpath");
        File newFile2 = newFile(file, "src");
        return file != null && !isAndroidProject(file) && newFile.exists() && newFile2.exists() && newFile2.isDirectory();
    }

    private static File newFile(File file, String str) {
        if (!(file == null || str == null || str.length() == 0)) {
            try {
                return new File(file, str);
            } catch (Throwable th) {
            }
        }
        return (File) null;
    }

    private static File newFile(String str) {
        try {
            return new File(str);
        } catch (Throwable th) {
            return (File) null;
        }
    }
}
