package com.s1243808733.aide;

import android.app.Activity;
import android.view.SubMenu;
import com.aide.ui.MainActivity;
import com.s1243808733.aide.util.ProjectUtils;
import com.s1243808733.util.Utils;
import java.io.File;

public class AideMainActivity extends MainActivity {
	
    protected void addOthorToolMenu(Activity activity, SubMenu subMenu) {
        File currentProject = ProjectUtils.getCurrentProject();
        SubMenu addSubMenu = subMenu.addSubMenu("Other...");
        addSubMenu.add("Batch replacement").setOnMenuItemClickListener(new AideMainActivity$100000008(this, currentProject, activity));
        addSubMenu.add("Json2Bean").setOnMenuItemClickListener(new AideMainActivity$100000009(this, activity));
        if (ProjectUtils.isGradleProject(currentProject)) {
            addSubMenu.add("Conversion project").setOnMenuItemClickListener(new AideMainActivity$100000010(this, activity, currentProject));
        }
        addSubMenu.add("View system resources").setOnMenuItemClickListener(new AideMainActivity$100000011(this, activity));
        addSubMenu.add("Specify class analysis").setOnMenuItemClickListener(new AideMainActivity$100000012(this, activity));
        addSubMenu.add("Goto to dir").setOnMenuItemClickListener(new AideMainActivity$100000014(this, activity));
    }
	
	protected static void addMainToolMenu(Activity activity, SubMenu subMenu) {
        subMenu.add("Icon Library").setOnMenuItemClickListener(new AideMainActivity$100000004(activity));
		subMenu.add("Asset Manager").setOnMenuItemClickListener(new AideMainActivity$OpenAssetsActivity(activity));
        subMenu.add("Code highlight").setOnMenuItemClickListener(new AideMainActivity$100000005(activity));
        SubMenu addSubMenu = subMenu.addSubMenu("Code escape");
        addSubMenu.add("Java").setOnMenuItemClickListener(new AideMainActivity$100000006(activity));
        addSubMenu.add("XML").setOnMenuItemClickListener(new AideMainActivity$100000007(activity));
    }
}
