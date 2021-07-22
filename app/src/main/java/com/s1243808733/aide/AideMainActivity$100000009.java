
package com.s1243808733.aide;

import android.app.Activity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.s1243808733.util.Json2Bean;

class AideMainActivity$100000009 implements OnMenuItemClickListener {
    private final AideMainActivity this$0;
    private final Activity val$activity;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        Json2Bean.showDialog(this.val$activity, (String) null);
        return false;
    }

    AideMainActivity$100000009(AideMainActivity aideMainActivity, Activity activity) {
        this.this$0 = aideMainActivity;
        this.val$activity = activity;
    }

    static AideMainActivity access$0(AideMainActivity$100000009 aideMainActivity$100000009) {
        return aideMainActivity$100000009.this$0;
    }
}
