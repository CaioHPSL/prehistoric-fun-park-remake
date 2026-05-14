/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Display
 *  javax.microedition.lcdui.Displayable
 *  javax.microedition.midlet.MIDlet
 */
import java.util.TimerTask;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.midlet.MIDlet;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class f
extends TimerTask {
    Park a;
    byte a;
    boolean a;
    Thread a = false;
    byte b = 0;

    f(Park park) {
        this.a = park;
    }

    public final void a() {
        this.a = true;
        this.a = new Thread(this);
        this.a.start();
    }

    public final void b() {
        this.a = false;
    }

    public final void run() {
        try {
            while (this.a) {
                if (this.a < 2) {
                    this.a.a.a = (byte)(this.a + 1);
                    if (this.a == 1 && this.a.b) {
                        this.a.a.a = (byte)3;
                    }
                    if (this.a == -3 && this.a.b && this.b > 3) {
                        this.a.a.a = (byte)2;
                    }
                    if (this.a == -3 && this.a.b && this.b <= 3) {
                        this.a.a.a = (byte)3;
                    }
                    if (this.a == -3) {
                        this.b = (byte)(this.b + 1);
                    }
                    this.a.a.repaint();
                } else if (this.a == 2) {
                    System.gc();
                    this.a.a = new e(this.a);
                    Display.getDisplay((MIDlet)this.a).setCurrent((Displayable)this.a.a);
                    this.a.a = null;
                    System.gc();
                    this.a.a.a();
                    this.b();
                } else if (this.a == 3) {
                    if (this.a.a != null) {
                        this.a.a.a = (byte)4;
                        this.a.a.g += 5;
                        this.a.a.repaint();
                    } else {
                        this.b();
                    }
                }
                Thread.sleep(700L);
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

