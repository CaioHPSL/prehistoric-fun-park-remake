/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class Park
extends MIDlet {
    e a;
    boolean a;
    boolean b;
    c a;
    f a = false;
    f b = false;

    public final void startApp() {
        if (!this.a) {
            this.a = true;
            try {
                if (this.getAppProperty("GameLinkEnabled").toLowerCase().indexOf("true") >= 0) {
                    this.b = true;
                }
            }
            catch (Exception exception) {}
            this.a = new c(this);
            this.a = new f(this);
            this.a.a = (byte)-2;
            Display.getDisplay((MIDlet)this).setCurrent((Displayable)this.a);
            this.a.a();
            return;
        }
        if (this.a != null) {
            this.a.b = false;
            if (this.a.c) {
                this.a.e();
            }
        }
    }

    public final void pauseApp() {
        if (this.a != null) {
            if (this.a.c) {
                this.a.a.b();
            }
            this.a.b = true;
        }
    }

    public final void destroyApp(boolean bl) {
        if (this.a != null) {
            this.a.d();
        }
    }
}

