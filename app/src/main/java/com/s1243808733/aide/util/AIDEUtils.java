package com.s1243808733.aide.util;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.TextView;
import androidj.support.v4.widget.DrawerLayout;
import com.aide.ui.AIDEEditor;
import com.aide.ui.AIDEEditorPager;
import com.aide.ui.U;
import com.aide.ui.browsers.BrowserPager;
import com.aide.ui.browsers.FileBrowser;
import com.aide.ui.views.CodeEditText;
import com.aide.ui.views.SplitView;
import com.aide.ui.views.editor.OConsole;
import com.aide.ui.views.editor.OEditor;
import com.blankj.utilcode.util.ReflectUtils;
import com.s1243808733.aide.AideMainActivity;
import com.s1243808733.util.Utils;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class AIDEUtils {
    public static void addToEditor(String str) {
        /*int i = 0;
        OEditor oEditorView = getOEditorView();
        if (oEditorView != null) {
            for (int i2 = 0; i2 < str.length(); i2++) {
                if (str.charAt(i2) == '\n') {
                    i++;
                }
            }
            int caretLine = oEditorView.getCaretLine();
            int i3 = i + caretLine;
            oEditorView.getEditorModel().j6(oEditorView.getCaretColumn(), oEditorView.getCaretLine(), oEditorView.tp(), oEditorView.getTabSize(), new StringReader(str), oEditorView);
            oEditorView.gn(caretLine, i3);
        }*/
    }

    public static void appendOpenFile(File file, int i) {
        if (file != null) {
            List currentFiles = getCurrentFiles();
            List arrayList = new ArrayList();
            for (int i2 = 0; i2 < currentFiles.size(); i2++) {
                if (!((File) currentFiles.get(i2)).getAbsolutePath().equals(file.getAbsolutePath())) {
                    arrayList.add((File) currentFiles.get(i2));
                }
            }
            arrayList.add(i, file);
            setCurrentFiles(arrayList);
        }
    }

    public static boolean checkEditorFileName(String str) {
        try {
            return getCurrentEditorFile().getName().equals(str);
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean checkEditorFileNameSuffix(String str) {
        try {
            return getCurrentEditorFile().getName().endsWith(str);
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean checkEditorFileParentName(String str) {
        try {
            return getCurrentEditorFile().getParentFile().getName().startsWith(str);
        } catch (Throwable th) {
            return false;
        }
    }

    public static void closeProjects() {
        U.vy().v5();
        U.J8().Hw();
    }

    public static void closeSplit(boolean z) {
        //ReflectUtils.reflect(getSplitView()).method("closeSplit", new Object[]{new Boolean(z)});
    }

    public static AIDEEditorPager getAIDEEditorPager() {
        return (AIDEEditorPager) getMainActivity().findViewById(2131230961);
    }

    public static BrowserPager getBrowserPager() {
        return (BrowserPager) getMainActivity().findViewById(2131230959);
    }

    public static CodeEditText getCodeEditText() {
        return getCurrentEditor();
    }

    public static Object getCodeEditText_c() {
        try {
            return ReflectUtils.reflect(getCurrentEditor()).method("getOEditorView").get();
        } catch (Throwable th) {
            return null;
        }
    }

    public static String getCurrentAppHome() {
        return getProjectService().getString("CurrentAppHome", (String) null);
    }

    public static AIDEEditor getCurrentEditor() {
        try {
            return (AIDEEditor) ReflectUtils.reflect(getAIDEEditorPager()).method("getCurrentEditor").get();
        } catch (Throwable th) {
            return (AIDEEditor) null;
        }
    }

    public static File getCurrentEditorFile() {
        AIDEEditor currentEditor = getCurrentEditor();
        if (currentEditor == null) {
            return (File) null;
        }
        String filePath = currentEditor.getFilePath();
        return filePath == null ? (File) null : new File(filePath);
    }

    public static List<File> getCurrentFiles() {
        List<File> arrayList = new ArrayList();
        String[] split = getOpenFileService().getString("CurrentFiles", "").split(";");
        for (String str : split) {
            if (str.trim().length() != 0 && str.startsWith("/")) {
                arrayList.add(new File(str));
            }
        }
        return arrayList;
    }

    public static FileBrowser getFileBrowser() {
        return getBrowserPager().getFileBrowser();
    }

    public static String getFileBrowserCurrentDir() {
        try {
            return ((TextView) getFileBrowser().findViewById(2131230741)).getText().toString();
        } catch (Throwable th) {
            return getFileBrowserService().getString("CurrentDir", (String) null);
        }
    }

    public static SharedPreferences getFileBrowserService() {
        return Utils.getSp("FileBrowserService");
    }

    public static AideMainActivity getMainActivity() {
        return (AideMainActivity) Utils.getMainActivity();
    }

    public static DrawerLayout getMainDrawerLayout() {
        return (DrawerLayout) getMainActivity().findViewById(2131231163);
    }

    public static OConsole getOConsole() {
        return (OConsole) ((Object) getOEditorView());
    }

    public static OEditor getOEditorView() {
        return (OEditor) getCodeEditText_c();
    }

    public static SharedPreferences getOpenFileService() {
        return Utils.getSp("OpenFileService");
    }

    public static SharedPreferences getProjectService() {
        return Utils.getSp("ProjectService");
    }

    public static SplitView getSplitView() {
        return (SplitView) getMainActivity().findViewById(2131231012);
    }

    public static void initQuickKey() {
        ReflectUtils.reflect(getMainActivity()).method("FN");
    }

    public static boolean isAddedOpenFile(File file) {
        if (file == null) {
            return false;
        }
        for (File absolutePath : getCurrentFiles()) {
            if (absolutePath.getAbsolutePath().equals(file.getAbsolutePath())) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCurrentEditorIsNull() {
        return getCurrentEditorFile() == null;
    }

    public static boolean isCurrentProjectIsNull() {
        return ProjectUtils.getCurrentProject() == null;
    }

    public static boolean isDrawerOpen() {
        DrawerLayout mainDrawerLayout = getMainDrawerLayout();
        if (mainDrawerLayout == null) {
            return false;
        }
        return ((Boolean) ReflectUtils.reflect(mainDrawerLayout).method("isDrawerOpen", new Object[]{new Integer(8388611)}).get()).booleanValue();
    }

    public static boolean isLightTheme() {
        return isTrainerMode() ? true : Utils.getSp().getBoolean("light_theme", true);
    }

    public static boolean isTrainerMode() {
        return Utils.getApp().getSharedPreferences("TrainerMode", 0).getBoolean("Mode", false);
    }

    public static boolean isUseProguard() {
        return Utils.getSp().getBoolean("use_proguard", false);
    }

    public static void launcherPermissionEditor(Context context, String str) {
        try {
            Intent intent = new Intent(context, Class.forName("com.s1243808733.aide.application.activity.permission.ManifestActivity"));
            intent.putExtra("path", str);
            Utils.startActivity(context, intent);
        } catch (Throwable e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static void notifyThemeChanged() {
        boolean z = true;
        setIsLightTheme(!Utils.getSp().getBoolean("light_theme", true));
        if (Utils.getSp().getBoolean("light_theme", true)) {
            z = false;
        }
        setIsLightTheme(z);
    }

    public static void openFile(File file) {
        ReflectUtils.reflect(getMainActivity()).method("Hw", new Object[]{file.getAbsolutePath()});
    }

    public static void openFile(List<File> list) {
        openFile((File[]) list.toArray(new File[0]));
    }

    public static void openFile(File... fileArr) {
        for (File openFile : fileArr) {
            openFile(openFile);
        }
        if (fileArr.length > 0) {
            openFile(fileArr[0]);
        }
    }

    public static void openProject(String str, List<File> list) {
        File file = new File(str);
        closeProjects();
        if (file.exists() && file.isDirectory()) {
            U.vy().Ws(str);
        }
        setFileBrowserCurrentDir(str);
        if (list != null && !list.isEmpty()) {
            openFile((List) list);
            setCurrentFiles(list);
        }
    }

    public static void openSplit(boolean z) {
        ReflectUtils.reflect(getSplitView()).method("openSplit", new Object[]{new Boolean(z)});
    }

    public static void reLoadFileBrowser() {
        FileBrowser fileBrowser = getFileBrowser();
        if (fileBrowser != null) {
            ReflectUtils.reflect(fileBrowser).method("Zo");
        }
    }

    public static void setCurrentAppHome(String str) {
        getProjectService().edit().putString("CurrentAppHome", str).commit();
    }

    public static void setCurrentFiles(List<File> list) {
        if (list != null) {
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < list.size(); i++) {
                File file = (File) list.get(i);
                if (file.exists() && file.isFile()) {
                    if (i > 0) {
                        stringBuffer.append(";");
                    }
                    stringBuffer.append(file.getAbsolutePath());
                }
            }
            getOpenFileService().edit().putString("CurrentFiles", stringBuffer.toString()).commit();
        }
    }

    public static void setFileBrowserCurrentDir(String str) {
        U.J8().j6(str);
        getFileBrowserService().edit().putString("CurrentDir", str).commit();
    }

    public static void setIsLightTheme(boolean z) {
        Utils.getSp().edit().putBoolean("light_theme", z).commit();
    }

    public static void toggleSplit() {
        if (getMainDrawerLayout() == null) {
            ReflectUtils.reflect(getSplitView()).method("toggleSplit", new Object[]{(Runnable) null});
        } else if (isDrawerOpen()) {
            closeSplit(true);
        } else {
            openSplit(true);
        }
    }

    public static void updateBuild(Object obj, String str) {
        //Utils.runOnUiThread(getMainActivity(), new 100000000(obj, str));
    }
}
