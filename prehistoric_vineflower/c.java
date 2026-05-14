import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class c extends Canvas {
   Park a;
   byte a = 0;
   int a = 0;
   int b = 0;
   int c;
   int d;
   int e;
   int f;
   int g = 10;
   int h = 60;
   int i = 7;
   int j = 5;
   int[][] a = new int[][]{{0, 15662897, 16762897, 16691973, 0}, {0, 8940804, 8928768, 8859904, 0}};
   int[] a = new int[]{(240 - this.h) / 2, 0, (240 + this.h) / 2};

   c(Park var1) {
      this.a = var1;
      this.setFullScreenMode(true);
   }

   protected final void paint(Graphics var1) {
      if (this.a < 0) {
         this.a = 0;
      }

      if (this.a <= 3) {
         var1.setColor(16777215);
         var1.fillRect(0, 0, this.getWidth(), this.getHeight());

         try {
            Image var2 = Image.createImage("/splash" + this.a + ".png");
            this.a = var2.getHeight();
            this.b = var2.getWidth();
            this.c = this.getWidth() / 2 - this.b / 2;
            this.d = this.getHeight() / 2 - this.a / 2;
            var1.drawImage(var2, this.c, this.d, 20);
         } catch (IOException var4) {
         }
      }

      if (this.a >= 2 && this.a != 3) {
         this.a[1] = (240 - this.h) / 2 + this.g * this.h / 100;

         for (this.e = 0; this.e < 2; this.e++) {
            for (this.f = 0; this.f < this.j; this.f++) {
               var1.setColor(this.a[this.e][this.f]);
               var1.drawLine(this.a[this.e], 320 - this.i + this.f, this.a[this.e + 1], 320 - this.i + this.f);
            }
         }

         for (this.e = 0; this.e < 2; this.e++) {
            var1.setColor(0);
            var1.drawLine(this.a[this.e * 2], 320 - this.i, this.a[this.e * 2], 320 - this.i + this.j - 1);
         }
      }

      if (this.a < 2) {
         this.a.a.a++;
      }

      if (this.a == 2) {
         this.a.a.a = 3;
         this.a.b = new f(this.a);
         this.a.b.a = 2;
         this.a.b.a();
      }

      if (this.a == 3) {
         this.a.a.a = -3;
      }
   }
}
