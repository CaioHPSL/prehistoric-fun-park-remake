import java.util.TimerTask;
import javax.microedition.lcdui.Display;

public final class f extends TimerTask {
   Park a;
   byte a = 0;
   boolean a = false;
   Thread a;
   byte b = 0;

   f(Park var1) {
      this.a = var1;
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
         for (; this.a; Thread.sleep(700L)) {
            if (this.a < 2) {
               this.a.a.a = (byte)(this.a + 1);
               if (this.a == 1 && this.a.b) {
                  this.a.a.a = 3;
               }

               if (this.a == -3 && this.a.b && this.b > 3) {
                  this.a.a.a = 2;
               }

               if (this.a == -3 && this.a.b && this.b <= 3) {
                  this.a.a.a = 3;
               }

               if (this.a == -3) {
                  this.b++;
               }

               this.a.a.repaint();
            } else if (this.a == 2) {
               System.gc();
               this.a.a = new e(this.a);
               Display.getDisplay(this.a).setCurrent(this.a.a);
               this.a.a = null;
               System.gc();
               this.a.a.a();
               this.b();
            } else if (this.a == 3) {
               if (this.a.a != null) {
                  this.a.a.a = 4;
                  this.a.a.g += 5;
                  this.a.a.repaint();
               } else {
                  this.b();
               }
            }
         }
      } catch (Exception var2) {
      }
   }
}
