package com.s1243808733.aide;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.util.Utils;

class AideMainActivity$100000011 implements OnMenuItemClickListener {
    private final AideMainActivity this$0;
    private final Activity val$activity;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        try {
            Utils.startActivity(this.val$activity, Class.forName("com.s1243808733.aide.application.activity.androidr.AndroidRActivity"));
            return false;
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    AideMainActivity$100000011(AideMainActivity aideMainActivity, Activity activity) {
        this.this$0 = aideMainActivity;
        this.val$activity = activity;
    }

    static AideMainActivity access$0(AideMainActivity$100000011 aideMainActivity$100000011) {
        return aideMainActivity$100000011.this$0;
    }
}
