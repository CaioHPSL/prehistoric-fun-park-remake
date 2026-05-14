import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class Park extends MIDlet {
   e a;
   boolean a = false;
   boolean b = false;
   c a;
   f a;
   f b;

   public final void startApp() {
      if (!this.a) {
         this.a = true;

         try {
            if (this.getAppProperty("GameLinkEnabled").toLowerCase().indexOf("true") >= 0) {
               this.b = true;
            }
         } catch (Exception var2) {
         }

         this.a = new c(this);
         this.a = new f(this);
         this.a.a = -2;
         Display.getDisplay(this).setCurrent(this.a);
         this.a.a();
      } else {
         if (this.a != null) {
            this.a.b = false;
            if (this.a.c) {
               this.a.e();
            }
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

   public final void destroyApp(boolean var1) {
      if (this.a != null) {
         this.a.d();
      }
   }
}
