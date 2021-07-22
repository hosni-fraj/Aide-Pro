//
// Decompiled by Jadx (from NP Manager)
//
package com.s1243808733.aide;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.s1243808733.util.Utils;

class AideMainActivity$100000014 implements OnMenuItemClickListener {
    private final AideMainActivity this$0;
    private final Activity val$activity;

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        LinearLayout linearLayout = new LinearLayout(this.val$activity);
        linearLayout.setPadding(Utils.dp2px((float) 24), Utils.dp2px((float) 10), Utils.dp2px((float) 24), 0);
        EditText editText = new EditText(this.val$activity);
        linearLayout.addView(editText, -1, -2);
        editText.setText(this.this$0.getFilesDir().getAbsolutePath());
        new Builder(this.val$activity).setTitle(menuItem.getTitle()).setView(linearLayout).setPositiveButton(17039370, new AideMainActivity$100000014$100000013(this, editText)).setNegativeButton(17039360, (OnClickListener) null).create().show();
        return false;
    }

    AideMainActivity$100000014(AideMainActivity aideMainActivity, Activity activity) {
        this.this$0 = aideMainActivity;
        this.val$activity = activity;
    }

    static AideMainActivity access$0(AideMainActivity$100000014 aideMainActivity$100000014) {
        return aideMainActivity$100000014.this$0;
    }
}
