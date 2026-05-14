/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.media.Manager
 *  javax.microedition.media.Player
 *  javax.microedition.media.PlayerListener
 *  javax.microedition.media.control.VolumeControl
 */
import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.control.VolumeControl;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class a
implements PlayerListener {
    private static VolumeControl a;
    private Player a;

    public a(String string, String string2) {
        try {
            InputStream inputStream = this.getClass().getResourceAsStream("/sound/" + string);
            this.a = Manager.createPlayer((InputStream)inputStream, (String)string2);
            this.a.realize();
            this.a.addPlayerListener((PlayerListener)this);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void playerUpdate(Player player, String string, Object object) {
        if (string.equals("endOfMedia") || string.equals("deviceAvailable")) {
            this.a();
        }
        if (string.equals("deviceUnavailable")) {
            this.b();
        }
    }

    public final void a() {
        try {
            if (this.a == null) {
                return;
            }
            if (this.a.getState() == 400) {
                return;
            }
            if (this.a.getState() == 300) {
                this.a.stop();
            }
            this.a.prefetch();
            this.a.start();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void b() {
        try {
            if (this.a == null) {
                return;
            }
            try {
                this.a.setMediaTime(0L);
            }
            catch (Exception exception) {}
            this.a.stop();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void c() {
        try {
            if (this.a == null) {
                return;
            }
            this.a.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public final void a(int n, int n2) {
        try {
            if (this.a == null) {
                return;
            }
            a = (VolumeControl)this.a.getControl("VolumeControl");
            if (n == 0) {
                this.b();
            } else if (n2 == 0) {
                this.a();
            }
            a.setLevel(n * 50);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

