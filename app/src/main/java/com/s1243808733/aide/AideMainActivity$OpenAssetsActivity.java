package com.s1243808733.aide;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.util.Utils;

class AideMainActivity$OpenAssetsActivity implements OnMenuItemClickListener {
    private final Activity val$activity;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            Utils.startActivity(this.val$activity, Class.forName("com.hosni.fraj.aide.manage.assets.AssetsManagerActivity"));
            return false;
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    AideMainActivity$OpenAssetsActivity(Activity activity) {
        this.val$activity = activity;
    }
}
