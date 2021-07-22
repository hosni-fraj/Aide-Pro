//
// Decompiled by Jadx (from NP Manager)
//
package com.s1243808733.aide;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.util.JavaEscape;

class AideMainActivity$100000006 implements OnMenuItemClickListener {
    private final Activity val$activity;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        JavaEscape.showDialog(this.val$activity, (String) null);
        return false;
    }

    AideMainActivity$100000006(Activity activity) {
        this.val$activity = activity;
    }
}
