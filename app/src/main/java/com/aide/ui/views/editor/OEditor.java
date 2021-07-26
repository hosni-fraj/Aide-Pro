package com.aide.ui.views.editor;

import abcd.fm;
import abcd.ru;
import abcd.su;
import abcd.tu;
import abcd.uu;
import abcd.wu;
import abcd.xu;
import android.content.Context;
import android.text.ClipboardManager;
import android.util.AttributeSet;
import java.io.IOException;
import java.io.StringReader;
import java.util.Enumeration;
import java.util.Hashtable;

@xu
public class OEditor extends OConsole {
    @uu
    private static /* synthetic */ boolean IS;
    @ru(field = 4057898148670445547L)
    private static final boolean a5;
    @ru(field = -1281259958890288100L)
    private static String sM = null;
    @tu
    private static /* synthetic */ boolean ys;
    @ru(field = -3106106093426974365L)
    private float AE;
    @ru(field = 4031675545226538716L)
    private boolean An;
    @ru(field = -3945233994630996012L)
    private b BR;
    @ru(field = 2276691099511097185L)
    private Hashtable<c, c> Nh;
    @ru(field = 5236250191966816140L)
    private d Pa;
    @ru(field = -842541237641576313L)
    private boolean Za;
    @ru(field = 239777795788397415L)
    private boolean ce;
    @ru(field = -4358561000006945476L)
    private Hashtable<c, c> gG;

    static {
        try {
            wu.j6(OEditor.class, -7024141317244897083L, -7024141317244897083L);
            if (ys) {
                wu.j6(2295472096954387232L, null);
            }
            a5 = !System.getProperty("os.name").startsWith("Windows");
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 2295472096954387232L, null);
            }
        }
    }

    public OEditor(Context context) {
        try {
            if (ys) {
                wu.j6(-169470605631496929L, null, context);
            }
            super(context);
            this.ce = false;
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -169470605631496929L, null, context);
            }
        }
    }

    public OEditor(Context context, AttributeSet attributeSet) {
        try {
            if (ys) {
                wu.j6(44764076477090084L, null, context, attributeSet);
            }
            super(context, attributeSet);
            this.ce = false;
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 44764076477090084L, null, context, attributeSet);
            }
        }
    }

    public OEditor(Context context, AttributeSet attributeSet, int i) {
        try {
            if (ys) {
                wu.j6(2249143508846534609L, null, context, attributeSet, new Integer(i));
            }
            super(context, attributeSet, i);
            this.ce = false;
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 2249143508846534609L, null, context, attributeSet, new Integer(i));
            }
        }
    }

    @su(method = -5350217640784703220L)
    private void DW(c cVar, c cVar2) {
        try {
            if (ys) {
                wu.j6(1996124050021295095L, this, cVar, cVar2);
            }
            this.gG.put(cVar, cVar2);
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 1996124050021295095L, this, cVar, cVar2);
            }
        }
    }

    @su(method = 1211841006483610299L)
    private void DW(String str) {
        try {
            if (ys) {
                wu.j6(-31040856291134040L, this, str);
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -31040856291134040L, this, str);
            }
        }
    }

    @su(method = 45522785396176984L)
    private int J0(int i) {
        int i2 = 0;
        try {
            if (ys) {
                wu.j6(600475311532991675L, this, i);
            }
            if (i >= 0) {
                for (int i3 = 0; i3 < getModel().EQ(i); i3++) {
                    char FH = getModel().FH(i3, i);
                    if (FH != '\t') {
                        if (FH != ' ') {
                            break;
                        }
                        i2++;
                    } else {
                        i2 = ((i2 + getTabSize()) / getTabSize()) * getTabSize();
                    }
                }
            }
            return i2;
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 600475311532991675L, this, new Integer(i));
            }
        }
    }

    @su(method = 470971523793072708L)
    private void KD() {
        try {
            if (ys) {
                wu.j6(-420696701264727309L, this);
            }
            this.gG = new Hashtable();
            this.Nh = new Hashtable();
            this.Pa = new d(this, null);
            getEditorModel().j6(this.Pa);
            getEditorModel().j6(new O(this));
            DW(c.j6, new ba(this));
            DW(c.DW, new ka(this));
            DW(c.FH, new la(this));
            DW(c.Hw, new ma(this));
            DW(c.v5, new na(this));
            DW(c.Zo, new oa(this));
            DW(c.VH, new pa(this));
            DW(c.gn, new qa(this));
            DW(c.u7, new E(this));
            DW(c.tp, new F(this));
            DW(c.EQ, new G(this));
            DW(c.we, new H(this));
            DW(c.J0, new I(this));
            j6(c.Ws, new P(this, (a) j6(c.j6)));
            j6(c.QX, new P(this, (a) j6(c.DW)));
            j6(c.XL, new P(this, (a) j6(c.FH)));
            j6(c.aM, new P(this, (a) j6(c.Hw)));
            j6(c.j3, new P(this, (a) j6(c.v5)));
            j6(c.Mr, new P(this, (a) j6(c.Zo)));
            j6(c.U2, new P(this, (a) j6(c.VH)));
            j6(c.a8, new P(this, (a) j6(c.gn)));
            j6(c.lg, new P(this, (a) j6(c.u7)));
            j6(c.rN, new P(this, (a) j6(c.tp)));
            j6(c.er, new P(this, (a) j6(c.EQ)));
            j6(c.yS, new P(this, (a) j6(c.we)));
            j6(c.gW, new P(this, (a) j6(c.J0)));
            DW(c.BT, new J(this));
            DW(c.vy, new K(this));
            DW(c.P8, new L(this));
            DW(c.ei, new M(this));
            j6(c.vJ, new N(this));
            j6(c.g3, new Q(this));
            j6(c.Mz, new S(this));
            j6(c.I, new T(this));
            DW(c.nw, new U(this));
            DW(c.SI, new V(this));
            DW(c.KD, new W(this));
            j6(c.ca, new X(this));
            j6(c.x9, new Y(this));
            dx();
            DW(c.ro, new Z(this));
            DW(c.cn, new aa(this));
            DW(c.sh, new ca(this));
            DW(c.cb, new da(this));
            DW(c.dx, new ea(this));
            DW(c.sG, new fa(this));
            DW(c.ef, new ga(this));
            DW(c.Sf, new ha(this));
            j6(c.ef).setEnabled(getEditorModel().er());
            j6(c.Sf).setEnabled(getEditorModel().rN());
            DW(c.Qq, new ia(this));
            DW(c.sy, new ja(this));
            j6(c.sy).setEnabled(false);
            setMultipleMouseClickSelects(true);
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -420696701264727309L, this);
            }
        }
    }

    @su(method = 423021260445194989L)
    private void SI() {
        try {
            if (ys) {
                wu.j6(91819729474283388L, this);
            }
            getEditorModel().BT();
            int firstSelectedLine = getFirstSelectedLine();
            int lastSelectedLine = getLastSelectedLine();
            if (getLastSelectedColumn() == -1) {
                lastSelectedLine--;
            }
            while (firstSelectedLine <= lastSelectedLine) {
                we(firstSelectedLine, J0(firstSelectedLine) + getTabSize());
                firstSelectedLine++;
            }
            getEditorModel().BT();
            cn();
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 91819729474283388L, this);
            }
        }
    }

    @su(method = -5126038154574816565L)
    private void cb() {
        try {
            if (ys) {
                wu.j6(1433906574812495700L, this);
            }
            int firstSelectedLine = getFirstSelectedLine();
            int lastSelectedLine = getLastSelectedLine();
            if (!J0()) {
                lastSelectedLine = getCaretLine();
                firstSelectedLine = lastSelectedLine;
            } else if (getLastSelectedColumn() == -1) {
                lastSelectedLine--;
            }
            getEditorModel().BT();
            EQ(firstSelectedLine, lastSelectedLine);
            if (getCaretColumn() > getModel().EQ(getCaretLine())) {
                v5(getModel().EQ(getCaretLine()), getCaretLine());
            }
            getEditorModel().BT();
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 1433906574812495700L, this);
            }
        }
    }

    @su(method = -5467086949715536101L)
    private void cn() {
        Object obj = 1;
        try {
            if (ys) {
                wu.j6(-5506919940554184392L, this);
            }
            o model = getModel();
            int firstSelectedLine = getFirstSelectedLine();
            int lastSelectedLine = getLastSelectedLine();
            Object obj2 = getCaretLine() == firstSelectedLine ? 1 : null;
            Object obj3 = getLastSelectedColumn() == -1 ? 1 : null;
            if (lastSelectedLine != model.v5() - 1) {
                obj = null;
            }
            if (obj2 != null) {
                if (obj != null) {
                    DW(model.EQ(lastSelectedLine), lastSelectedLine, true);
                } else if (obj3 == null) {
                    DW(0, lastSelectedLine + 1, true);
                }
                Zo(0, firstSelectedLine);
                v5(0, firstSelectedLine);
            } else {
                DW(0, firstSelectedLine, true);
                if (obj != null) {
                    Zo(model.EQ(lastSelectedLine), lastSelectedLine);
                    v5(model.EQ(lastSelectedLine), lastSelectedLine);
                } else if (obj3 == null) {
                    int i = lastSelectedLine + 1;
                    Zo(0, i);
                    v5(0, i);
                }
            }
            setSelectionVisibility(true);
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -5506919940554184392L, this);
            }
        }
    }

    @su(method = -74179821038104635L)
    private void dx() {
        try {
            if (ys) {
                wu.j6(459553439474085024L, this);
            }
            Enumeration elements = this.Nh.elements();
            while (elements.hasMoreElements()) {
                ((c) elements.nextElement()).setEnabled(J0());
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 459553439474085024L, this);
            }
        }
    }

    @su(method = -2868402634690439520L)
    private void ei() {
        try {
            if (ys) {
                wu.j6(-191440319793066115L, this);
            }
            int firstSelectedLine = getFirstSelectedLine();
            int lastSelectedLine = getLastSelectedLine();
            if (!J0()) {
                lastSelectedLine = getCaretLine();
                firstSelectedLine = lastSelectedLine;
            } else if (getLastSelectedColumn() == -1) {
                lastSelectedLine--;
            }
            getEditorModel().BT();
            tp(firstSelectedLine, lastSelectedLine);
            if (getCaretColumn() > getModel().EQ(getCaretLine())) {
                v5(getModel().EQ(getCaretLine()), getCaretLine());
            }
            getEditorModel().BT();
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -191440319793066115L, this);
            }
        }
    }

    @su(method = -4695250619045529936L)
    private float getIntendedColumnX() {
        try {
            if (ys) {
                wu.j6(1751640118070341081L, this);
            }
            return this.AE;
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 1751640118070341081L, this);
            }
        }
    }

    @su(method = 5924206703994759141L)
    private b getInternalState() {
        try {
            if (ys) {
                wu.j6(-4589530764052017560L, this);
            }
            return this.BR;
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -4589530764052017560L, this);
            }
        }
    }

    @su(method = -1107828819856173723L)
    private void j6(c cVar, c cVar2) {
        try {
            if (ys) {
                wu.j6(-1269952207080367700L, this, cVar, cVar2);
            }
            this.Nh.put(cVar, cVar2);
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -1269952207080367700L, this, cVar, cVar2);
            }
        }
    }

    @su(method = -3221363158360325416L)
    private void j6(String str) {
        try {
            if (ys) {
                wu.j6(-1579337844061100263L, this, str);
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -1579337844061100263L, this, str);
            }
        }
    }

    @su(method = -3851017224114500499L)
    private void nw() {
        try {
            if (ys) {
                wu.j6(-3273628727170242320L, this);
            }
            if (J0()) {
                v5();
                v5(getFirstSelectedColumn(), getFirstSelectedLine());
                getEditorModel().j6(getSelectedRegion(), this);
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -3273628727170242320L, this);
            }
        }
    }

    @su(method = -6223202948700555632L)
    private void ro() {
        int i = 0;
        try {
            if (ys) {
                wu.j6(296634230266445793L, this);
            }
            ClipboardManager clipboardManager = (ClipboardManager) getContext().getSystemService("clipboard");
            if (clipboardManager.hasText()) {
                String charSequence = clipboardManager.getText().toString();
                int i2 = 0;
                while (i < charSequence.length()) {
                    if (charSequence.charAt(i) == '\n') {
                        i2++;
                    }
                    i++;
                }
                int caretLine = getCaretLine();
                int i3 = i2 + caretLine;
                try {
                    getEditorModel().j6(getCaretColumn(), getCaretLine(), tp(), getTabSize(), new StringReader(charSequence), this);
                } catch (IOException e) {
                }
                gn(caretLine, i3);
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 296634230266445793L, this);
            }
        }
    }

    @su(method = -1322057154443266017L)
    private void setIntendedColumnX(float f) {
        try {
            if (ys) {
                wu.j6(718094797800127960L, this, new Float(f));
            }
            this.AE = f;
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 718094797800127960L, this, new Float(f));
            }
        }
    }

    @su(method = -5134628477796030336L)
    private void setInternalState(b bVar) {
        try {
            if (ys) {
                wu.j6(5586934369880274915L, this, bVar);
            }
            if (this.BR != bVar) {
                getEditorModel().BT();
                this.BR = bVar;
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 5586934369880274915L, this, bVar);
            }
        }
    }

    @su(method = 2675857267852210008L)
    private void sh() {
        try {
            if (ys) {
                wu.j6(4491985855273215099L, this);
            }
            getEditorModel().BT();
            int firstSelectedLine = getFirstSelectedLine();
            int lastSelectedLine = getLastSelectedLine();
            if (getLastSelectedColumn() == -1) {
                lastSelectedLine--;
            }
            while (firstSelectedLine <= lastSelectedLine) {
                we(firstSelectedLine, J0(firstSelectedLine) - getTabSize());
                firstSelectedLine++;
            }
            getEditorModel().BT();
            cn();
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 4491985855273215099L, this);
            }
        }
    }

    @su(method = -2086940450594512275L)
    private void we(int i, int i2) {
        int i3 = 0;
        try {
            int i4;
            int i5;
            if (ys) {
                wu.j6(316160746926747840L, this, new Integer(i), new Integer(i2));
            }
            if (i2 < 0) {
                i2 = 0;
            }
            int i6 = 0;
            while (i6 < getModel().EQ(i)) {
                char FH = getModel().FH(i6, i);
                if (FH != '\t' && FH != ' ') {
                    break;
                }
                i6++;
            }
            getEditorModel().j6(0, i, i6, this);
            if (tp()) {
                i4 = 0;
                i5 = i2;
            } else {
                i5 = i2 % getTabSize();
                i4 = i2 / getTabSize();
            }
            char[] cArr = new char[(i5 + i4)];
            for (i6 = 0; i6 < i4; i6++) {
                cArr[i6] = '\t';
            }
            while (i3 < i5) {
                cArr[i3 + i4] = ' ';
                i3++;
            }
            getEditorModel().j6(0, i, cArr, this);
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 316160746926747840L, this, new Integer(i), new Integer(i2));
            }
        }
    }

    public void BT() {
        try {
            if (ys) {
                wu.j6(-5392868336110183548L, this);
            }
            getEditorModel().j6(getSelectedRegion(), this);
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -5392868336110183548L, this);
            }
        }
    }

    public void DW(char c, int i, int i2) {
        try {
            if (ys) {
                wu.j6(-2219637691765926896L, this, new Character(c), new Integer(i), new Integer(i2));
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -2219637691765926896L, this, new Character(c), new Integer(i), new Integer(i2));
            }
        }
    }

    public void EQ(int i, int i2) {
        try {
            if (ys) {
                wu.j6(-165417921625960339L, this, new Integer(i), new Integer(i2));
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -165417921625960339L, this, new Integer(i), new Integer(i2));
            }
        }
    }

    public boolean J2() {
        return getEditorModel().J1() ? J0() : false;
    }

    public void Mr() {
        try {
            if (ys) {
                wu.j6(549574547276637504L, this);
            }
            if (lg()) {
                setInternalState(b.j6);
                getEditorModel().BT();
                nw();
                getEditorModel().BT();
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, 549574547276637504L, this);
            }
        }
    }

    public void P8() {
        try {
            if (ys) {
                wu.j6(-2346598066965667632L, this);
            }
            if (lg()) {
                fm j6 = getEditorModel().j6(this);
                if (j6 != null) {
                    v5(j6.j6(), j6.DW());
                }
            }
        } catch (Throwable th) {
            if (IS) {
                wu.j6(th, -2346598066965667632L, this);
            }
        }
    }

    public void U2() {
        try {
            if (ys) {
                wu.j6(-1544417520886620591L, this);
            }
            setInternalState(b.j6);
            if (lg()) {
                int lastSelectedLine;
                int caretLine = getCaretLine();
                if (J0()) {
                    caretLine = getFirstSelectedLine();
                    lastSelectedLine = getLastSelectedLine();
                    if (getLastSelectedColumn() == -1) {
                        lastSelectedLine--;
                    }
                    setSelectionVisibility(false);
                    int i = caretLine;
                    caretLine = lastSelectedLine;
                    lastSelectedLine = i;
                } else {
                    lastSelectedLine = caretLine;
                }
                getEditorModel().BT();
                for (caretLine = 
/*
Method generation error in method: com.aide.ui.views.editor.OEditor.U2():void
jadx.core.utils.exceptions.CodegenException: Error generate insn: PHI: (r0_7 'caretLine' int) = (r0_6 'caretLine' int), (r0_4 'caretLine' int) binds: {(r0_6 'caretLine' int)=B:12:0x0037, (r0_4 'caretLine' int)=B:39:0x00ae} in method: com.aide.ui.views.editor.OEditor.U2():void
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:230)
	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:184)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:61)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:118)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:57)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:93)
	at jadx.core.codegen.RegionGen.makeTryCatch(RegionGen.java:277)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:63)
	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:87)
	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:53)
	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:183)
	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:328)
	at jadx.core.codegen.ClassGen.addMethods(ClassGen.java:265)
	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:228)
	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:118)
	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:83)
	at jadx.core.codegen.CodeGen.visit(CodeGen.java:19)
	at jadx.core.ProcessClass.process(ProcessClass.java:43)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:286)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
	at jadx.api.JavaClass.getCode(JavaClass.java:48)
Caused by: jadx.core.utils.exceptions.CodegenException: PHI can be used only in fallback mode
	at jadx.core.codegen.InsnGen.fallbackOnlyInsn(InsnGen.java:534)
	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:518)
	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:224)
	... 27 more

*/

                public void VH(int i, int i2) {
                    try {
                        if (ys) {
                            wu.j6(3577208457665686365L, this, new Integer(i), new Integer(i2));
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 3577208457665686365L, this, new Integer(i), new Integer(i2));
                        }
                    }
                }

                public void a8() {
                    try {
                        if (ys) {
                            wu.j6(-495486783251010740L, this);
                        }
                        if (lg()) {
                            setInternalState(b.DW);
                            int caretLine = getCaretLine();
                            int caretColumn = getCaretColumn();
                            if (tp()) {
                                int tabSize = getTabSize();
                                for (int i = 0; i < tabSize; i++) {
                                    getEditorModel().j6(caretColumn, caretLine, ' ', this);
                                }
                                return;
                            }
                            getEditorModel().j6(caretColumn, caretLine, '\t', this);
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -495486783251010740L, this);
                        }
                    }
                }

                public void aM() {
                    int i = 0;
                    try {
                        if (ys) {
                            wu.j6(-3391513026548094864L, this);
                        }
                        setInternalState(b.j6);
                        if (!lg()) {
                            return;
                        }
                        int firstSelectedLine;
                        if (J0()) {
                            getEditorModel().BT();
                            firstSelectedLine = getFirstSelectedLine();
                            i = getLastSelectedLine();
                            if (getLastSelectedColumn() == -1) {
                                i--;
                            }
                            VH(firstSelectedLine, i);
                            getEditorModel().BT();
                            cn();
                            return;
                        }
                        firstSelectedLine = getEditorModel().EQ(getCaretLine());
                        int caretColumn = getCaretColumn();
                        VH(0, getEditorModel().v5() - 1);
                        firstSelectedLine = (getEditorModel().EQ(getCaretLine()) - firstSelectedLine) + caretColumn;
                        if (firstSelectedLine >= 0) {
                            i = firstSelectedLine;
                        }
                        if (i > getModel().EQ(getCaretLine())) {
                            i = getModel().EQ(getCaretLine());
                        }
                        v5(i, getCaretLine());
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -3391513026548094864L, this);
                        }
                    }
                }

                public boolean er() {
                    try {
                        if (ys) {
                            wu.j6(-2463028108655624161L, this);
                        }
                        return getEditorModel().er();
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -2463028108655624161L, this);
                        }
                    }
                }

                public void gW() {
                    try {
                        if (ys) {
                            wu.j6(-2345400446556654528L, this);
                        }
                        if (lg()) {
                            fm yS = getEditorModel().yS();
                            if (yS != null) {
                                v5(yS.j6(), yS.DW());
                            }
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -2345400446556654528L, this);
                        }
                    }
                }

                public g getEditorModel() {
                    try {
                        if (ys) {
                            wu.j6(-4491076168033728084L, this);
                        }
                        return (g) getModel();
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -4491076168033728084L, this);
                        }
                    }
                }

                public void gn(int i, int i2) {
                    try {
                        if (ys) {
                            wu.j6(1479543194302387740L, this, new Integer(i), new Integer(i2));
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 1479543194302387740L, this, new Integer(i), new Integer(i2));
                        }
                    }
                }

                public void j3() {
                    try {
                        if (ys) {
                            wu.j6(-2362432507968482117L, this);
                        }
                        setInternalState(b.j6);
                        getEditorModel().BT();
                        v5();
                        getEditorModel().BT();
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -2362432507968482117L, this);
                        }
                    }
                }

                public c j6(c cVar) {
                    try {
                        if (ys) {
                            wu.j6(175503590832818112L, this, cVar);
                        }
                        if (this.gG.containsKey(cVar)) {
                            return (c) this.gG.get(cVar);
                        }
                        if (this.Nh.containsKey(cVar)) {
                            return (c) this.Nh.get(cVar);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unknown editor action: ");
                        stringBuilder.append(cVar);
                        throw new IllegalArgumentException(stringBuilder.toString());
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 175503590832818112L, this, cVar);
                        }
                    }
                }

                public void j6(char c) {
                    try {
                        if (ys) {
                            wu.j6(1266954593201272640L, this, new Character(c));
                        }
                        if (lg()) {
                            if (J0()) {
                                getEditorModel().BT();
                                v5(getFirstSelectedColumn(), getFirstSelectedLine());
                                BT();
                                setSelectionVisibility(false);
                            }
                            if (getOverwriteMode()) {
                                setInternalState(b.FH);
                                int caretColumn = getCaretColumn();
                                int caretLine = getCaretLine();
                                getEditorModel().DW(caretColumn, caretLine, c, this);
                                v5(caretColumn + 1, caretLine);
                            } else {
                                setInternalState(b.DW);
                                getEditorModel().j6(getCaretColumn(), getCaretLine(), c, this);
                            }
                            DW(c, getCaretLine(), getCaretColumn());
                            j6(c, getCaretLine(), getCaretColumn());
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 1266954593201272640L, this, new Character(c));
                        }
                    }
                }

                public void j6(char c, int i, int i2) {
                    try {
                        if (ys) {
                            wu.j6(14235650406504700L, this, new Character(c), new Integer(i), new Integer(i2));
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 14235650406504700L, this, new Character(c), new Integer(i), new Integer(i2));
                        }
                    }
                }

                public boolean lg() {
                    try {
                        if (ys) {
                            wu.j6(-650726666214649192L, this);
                        }
                        return this.An && getEditorModel().lg();
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -650726666214649192L, this);
                        }
                    }
                }

                public boolean rN() {
                    try {
                        if (ys) {
                            wu.j6(-2834836741070748483L, this);
                        }
                        return getEditorModel().rN();
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -2834836741070748483L, this);
                        }
                    }
                }

                public void setEditable(boolean z) {
                    try {
                        if (ys) {
                            wu.j6(2030379915215878699L, this, z);
                        }
                        this.An = z;
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 2030379915215878699L, this, new Boolean(z));
                        }
                    }
                }

                public void setModel(o oVar) {
                    try {
                        if (ys) {
                            wu.j6(-31739013191968272L, this, oVar);
                        }
                        super.setModel(oVar);
                        KD();
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -31739013191968272L, this, oVar);
                        }
                    }
                }

                public void setMultipleMouseClickSelects(boolean z) {
                    try {
                        if (ys) {
                            wu.j6(-1610522089537736079L, this, z);
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -1610522089537736079L, this, new Boolean(z));
                        }
                    }
                }

                public void tp(int i, int i2) {
                    try {
                        if (ys) {
                            wu.j6(5816467629986461976L, this, new Integer(i), new Integer(i2));
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 5816467629986461976L, this, new Integer(i), new Integer(i2));
                        }
                    }
                }

                public void u7(int i, int i2) {
                    try {
                        if (ys) {
                            wu.j6(-2285980632659812520L, this, new Integer(i), new Integer(i2));
                        }
                        for (int i3 = 0; i3 < getEditorModel().EQ(i); i3++) {
                            char FH = getEditorModel().FH(i3, i);
                            if (FH == '\t') {
                                getEditorModel().j6(i3, i + 1, '\t', this);
                            } else if (FH == ' ') {
                                getEditorModel().j6(i3, i + 1, ' ', this);
                            } else {
                                return;
                            }
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, -2285980632659812520L, this, new Integer(i), new Integer(i2));
                        }
                    }
                }

                public void vy() {
                    try {
                        if (ys) {
                            wu.j6(2569028962822256211L, this);
                        }
                        int v5 = getModel().v5() - 1;
                        int EQ = getModel().EQ(v5);
                        if (EQ != 0 || v5 != 0) {
                            DW(0, 0, true);
                            Zo(EQ, v5);
                            v5(EQ, v5);
                            setSelectionVisibility(true);
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 2569028962822256211L, this);
                        }
                    }
                }

                public void yS() {
                    try {
                        if (ys) {
                            wu.j6(639313292874392829L, this);
                        }
                        setInternalState(b.j6);
                        if (lg()) {
                            getEditorModel().BT();
                            if (J0()) {
                                getEditorModel().BT();
                                BT();
                                setSelectionVisibility(false);
                            }
                            ro();
                            getEditorModel().BT();
                        }
                    } catch (Throwable th) {
                        if (IS) {
                            wu.j6(th, 639313292874392829L, this);
                        }
                    }
                }
            }
