//
// Decompiled by Jadx (from NP Manager)
//
package com.s1243808733.aide;

import android.app.Activity;
import android.content.Intent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.util.Utils;

class AideMainActivity$100000005 implements OnMenuItemClickListener {
    private final Activity val$activity;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            Utils.startActivity(this.val$activity, new Intent(this.val$activity, Class.forName("com.s1243808733.aide.highlight.HighlightActivity")).putExtra("title", menuItem.getTitle()));
            return false;
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    AideMainActivity$100000005(Activity activity) {
        this.val$activity = activity;
    }
}
