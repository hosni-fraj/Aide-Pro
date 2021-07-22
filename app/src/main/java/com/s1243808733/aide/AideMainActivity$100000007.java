//
// Decompiled by Jadx (from NP Manager)
//
package com.s1243808733.aide;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.util.EscapeUtils;

class AideMainActivity$100000007 implements OnMenuItemClickListener {
    private final Activity val$activity;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        EscapeUtils.showDialog(this.val$activity, (String) null, EscapeUtils.XML);
        return false;
    }

    AideMainActivity$100000007(Activity activity) {
        this.val$activity = activity;
    }
}
