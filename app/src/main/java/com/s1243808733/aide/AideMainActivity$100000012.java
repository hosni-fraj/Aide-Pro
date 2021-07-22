//
// Decompiled by Jadx (from NP Manager)
//
package com.s1243808733.aide;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.util.ClassUtils;

class AideMainActivity$100000012 implements OnMenuItemClickListener {
    private final AideMainActivity this$0;
    private final Activity val$activity;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        ClassUtils.showDialog(this.val$activity);
        return false;
    }

    AideMainActivity$100000012(AideMainActivity aideMainActivity, Activity activity) {
        this.this$0 = aideMainActivity;
        this.val$activity = activity;
    }

    static AideMainActivity access$0(AideMainActivity$100000012 aideMainActivity$100000012) {
        return aideMainActivity$100000012.this$0;
    }
}
