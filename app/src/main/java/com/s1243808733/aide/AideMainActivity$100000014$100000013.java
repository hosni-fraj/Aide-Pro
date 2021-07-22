//
// Decompiled by Jadx (from NP Manager)
//
package com.s1243808733.aide;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.s1243808733.aide.AideMainActivity$100000014;
import com.s1243808733.aide.util.AIDEUtils;

class AideMainActivity$100000014$100000013 implements OnClickListener {
    private final AideMainActivity$100000014 this$0;
    private final EditText val$et;

    @Override
    public void onClick(DialogInterface dialogInterface, int i) {
        AIDEUtils.setFileBrowserCurrentDir(this.val$et.getText().toString());
    }

    AideMainActivity$100000014$100000013(AideMainActivity$100000014 a, EditText editText) {
        this.this$0 = a;
        this.val$et = editText;
    }

    static AideMainActivity$100000014 access$0(AideMainActivity$100000014$100000013 aideMainActivity$100000014$100000013) {
        return aideMainActivity$100000014$100000013.this$0;
    }
}
