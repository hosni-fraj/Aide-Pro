//
// Decompiled by Jadx (from NP Manager)
//
package com.s1243808733.aide;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.aide.util.ConverProject;
import java.io.File;

class AideMainActivity$100000010 implements OnMenuItemClickListener {
    private final AideMainActivity this$0;
    private final Activity val$activity;
    private final File val$currentProject;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        ConverProject.showDialog(this.val$activity, this.val$currentProject);
        return false;
    }

    AideMainActivity$100000010(AideMainActivity aideMainActivity, Activity activity, File file) {
        this.this$0 = aideMainActivity;
        this.val$activity = activity;
        this.val$currentProject = file;
    }

    static AideMainActivity access$0(AideMainActivity$100000010 aideMainActivity$100000010) {
        return aideMainActivity$100000010.this$0;
    }
}
