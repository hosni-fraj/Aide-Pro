package com.s1243808733.aide;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.aide.util.ProjectUtils;
import com.s1243808733.util.BatchReplace;
import java.io.File;

class AideMainActivity$100000008 implements OnMenuItemClickListener {
    private final AideMainActivity this$0;
    private final Activity val$activity;
    private final File val$currentProject;

    AideMainActivity$100000008(AideMainActivity aideMainActivity, File file, Activity activity) {
        this.this$0 = aideMainActivity;
        this.val$currentProject = file;
        this.val$activity = activity;
    }

    static AideMainActivity access$0(AideMainActivity$100000008 aideMainActivity$100000008) {
        return aideMainActivity$100000008.this$0;
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        File main = ProjectUtils.getMain(this.val$currentProject);
        BatchReplace.showDialog(this.val$activity, main == null ? (String) null : main.getAbsolutePath());
        return false;
    }
}
