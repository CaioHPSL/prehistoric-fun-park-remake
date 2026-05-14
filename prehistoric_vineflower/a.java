import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.media.control.VolumeControl;

public final class a implements PlayerListener {
   private static VolumeControl a;
   private Player a;

   public a(String var1, String var2) {
      try {
         InputStream var3 = this.getClass().getResourceAsStream("/sound/" + var1);
         this.a = Manager.createPlayer(var3, var2);
         this.a.realize();
         this.a.addPlayerListener(this);
      } catch (Exception var4) {
      }
   }

   public final void playerUpdate(Player var1, String var2, Object var3) {
      if (var2.equals("endOfMedia") || var2.equals("deviceAvailable")) {
         this.a();
      }

      if (var2.equals("deviceUnavailable")) {
         this.b();
      }
   }

   public final void a() {
      try {
         if (this.a != null) {
            if (this.a.getState() != 400) {
               if (this.a.getState() == 300) {
                  this.a.stop();
               }

               this.a.prefetch();
               this.a.start();
            }
         }
      } catch (Exception var2) {
      }
   }

   public final void b() {
      try {
         if (this.a != null) {
            try {
               this.a.setMediaTime(0L);
            } catch (Exception var2) {
            }

            this.a.stop();
         }
      } catch (Exception var3) {
      }
   }

   public final void c() {
      try {
         if (this.a != null) {
            this.a.close();
         }
      } catch (Exception var2) {
      }
   }

   public final void a(int var1, int var2) {
      try {
         if (this.a != null) {
            a = (VolumeControl)this.a.getControl("VolumeControl");
            if (var1 == 0) {
               this.b();
            } else if (var2 == 0) {
               this.a();
            }

            a.setLevel(var1 * 50);
         }
      } catch (Exception var4) {
      }
   }
}
