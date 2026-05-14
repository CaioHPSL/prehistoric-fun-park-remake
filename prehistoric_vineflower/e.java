import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.rms.RecordStore;

public final class e extends GameCanvas implements Runnable {
   boolean a = false;
   Park a;
   boolean b = false;
   boolean c = false;
   boolean d = false;
   String a = "GameUrl-";
   String[] a = new String[]{"en", "de", "fr", "es", "it"};
   Thread a;
   Graphics a = this.getGraphics();
   Image a;
   Graphics b;
   byte a = 0;
   Graphics[] a;
   Random a;
   long a;
   long b;
   int a;
   byte[] a;
   byte b;
   byte c;
   boolean e;
   boolean f;
   boolean g;
   boolean h;
   boolean i;
   boolean j;
   byte d;
   byte e;
   byte f;
   byte g;
   byte h;
   byte i;
   byte j;
   boolean k;
   byte k;
   byte l;
   byte m;
   byte n;
   byte o;
   byte p;
   byte q;
   byte r;
   byte s;
   byte t;
   byte u;
   byte v;
   byte w;
   int b;
   int c;
   int d;
   int e;
   int f;
   int g;
   int h;
   final int[][] a;
   final int[][] b;
   final int[][][] a;
   final int[][][] b;
   byte x;
   byte y;
   byte z;
   byte A;
   byte B;
   byte C;
   int i;
   byte[] b;
   byte D;
   byte E;
   byte F;
   byte G;
   byte H;
   byte I;
   byte J;
   byte K;
   byte L;
   byte M;
   byte N;
   boolean l;
   byte O;
   byte P;
   byte Q;
   byte R;
   byte S;
   byte T;
   final byte[] c;
   final byte[] d;
   final byte[] e;
   final byte[] f;
   final byte[] g;
   final byte[] h;
   final byte[] i;
   final byte[] j;
   final byte[] k;
   final byte[] l;
   final byte[] m;
   final byte[] n;
   final byte[] o;
   final byte[] p;
   final byte[] q;
   final byte[] r;
   final byte[] s;
   final byte[] t;
   final byte[] u;
   final byte[][] a;
   byte[] v;
   final byte[] w;
   byte[] x;
   byte[] y;
   boolean m;
   boolean n;
   boolean o;
   boolean p;
   byte U;
   int j;
   int[][] c;
   int[][] d;
   final short[] a;
   int[][] e;
   byte V;
   int k;
   int l;
   int m;
   byte W;
   byte X;
   Image[] a;
   Image[] b;
   Image[] c;
   Image[] d;
   Image[][] a;
   Image[] e;
   byte[][] b;
   byte[][] c;
   short[][] a;
   byte Y;
   byte Z;
   byte[][] d;
   byte aa;
   int n;
   boolean q;
   byte ab;
   byte[] z;
   int[] a;
   int[][] f;
   short a;
   byte ac;
   byte[] A;
   byte[] B;
   byte[] C;
   byte[] D;
   byte[] E;
   byte[] F;
   byte[] G;
   byte[] H;
   byte[][] e;
   byte[] I;
   byte[] J;
   byte[] K;
   byte[][] f;
   byte[] L;
   short[] b;
   byte[] M;
   byte[] N;
   byte[] O;
   byte[] P;
   byte[] Q;
   byte[] R;
   byte[] S;
   byte[] T;
   byte[] U;
   byte[] V;
   byte ad;
   byte ae;
   byte[] W;
   byte[][] g;
   short[][] b;
   byte af;
   short b;
   byte[][] h;
   byte[] X;
   short[] c;
   short[][] c;
   short[] d;
   short[][] d;
   short c;
   short[] e;
   byte ag;
   byte[][] i;
   byte[] Y;
   byte[][] j;
   byte[][][] a;
   byte ah;
   byte[][] k;
   byte ai;
   byte[] Z;
   byte[] aa;
   byte[][] l;
   byte[][] m;
   byte[][] n;
   byte[] ab;
   byte[] ac;
   short[][] e;
   byte[] ad;
   byte[] ae;
   short[][] f;
   byte[] af;
   byte[] ag;
   byte[] ah;
   byte[] ai;
   byte[] aj;
   boolean[] a;
   boolean[] b;
   boolean[] c;
   byte aj;
   byte ak;
   byte[] ak;
   boolean[] d;
   boolean[] e;
   boolean[] f;
   boolean[] g;
   byte[] al;
   short[] f;
   byte[] am;
   byte[] an;
   byte[] ao;
   byte[] ap;
   byte[] aq;
   byte[] ar;
   byte[] as;
   byte[] at;
   byte[] au;
   byte[] av;
   byte[] aw;
   byte[] ax;
   byte[] ay;
   byte[] az;
   byte[] aA;
   byte[] aB;
   byte[] aC;
   byte[] aD;
   byte al;
   byte[][] o;
   short[][] g;
   byte[] aE;
   short[] g;
   boolean[] h;
   byte[] aF;
   byte[] aG;
   byte[] aH;
   byte[][] p;
   short[][] h;
   boolean[][] a;
   int o;
   byte[] aI;
   short[] h;
   final byte[] aJ;
   byte[][] q;
   byte[] aK;
   byte[][] r;
   int p;
   int q;
   int r;
   int s;
   int t;
   int u;
   int v;
   int w;
   short d;
   int x;
   int y;
   int z;
   int A;
   int B;
   int C;
   int[] b;
   byte am;
   byte an;
   byte ao;
   byte ap;
   byte aq;
   byte ar;
   byte as;
   byte at;
   byte au;
   byte av;
   byte[] aL;
   byte[] aM;
   boolean r;
   boolean s;
   short e;
   byte aw;
   byte ax;
   byte[] aN;
   short[] i;
   byte[] aO;
   short[] j;
   byte[] aP;
   short[] k;
   byte[][] s;
   short[][] i;
   String[] b;
   int D;
   int E;
   byte ay;
   byte az;
   byte[][] t;
   byte[][] u;
   int[] c;
   int[] d;
   int[] e;
   int[] f;
   int[] g;
   short[] l;
   short[] m;
   int F;
   int G;
   byte aA;
   byte aB;
   byte aC;
   int H;
   boolean[] i;
   byte aD;
   boolean[] j;
   byte aE;
   byte aF;
   byte aG;
   byte[][] v;
   byte[][] w;
   int[] h;
   int[] i;
   int[] j;
   int[] k;
   int[] l;
   byte aH;
   byte[][] x;
   byte[] aQ;
   byte[] aR;
   byte[] aS;
   byte aI;
   short f;
   short g;
   short h;
   short i;
   short j;
   short k;
   byte[] aT;
   String b;
   StringBuffer a;
   InputStream a;
   ByteArrayOutputStream a;
   DataOutputStream a;
   DataInputStream a;
   RecordStore a;
   int I;
   int J;
   int K;
   int[][] g;
   int[] m;
   a a;
   byte aJ;
   int L;
   int M;
   byte aK;
   byte aL;
   byte aM;
   byte aN;
   int N;
   int O;
   int P;
   boolean t;
   boolean u;
   int Q;
   int R;
   int S;
   int T;
   int U;
   int V;
   int W;
   String[] c;
   int X;
   int Y;
   int Z;
   int aa;
   int ab;
   int ac;
   int ad;
   short l;
   short m;
   short n;
   short o;
   int ae;
   int[] n;
   byte aO;
   byte aP;
   byte[] aU;
   byte[] aV;
   byte aQ;
   byte aR;
   byte aS;
   int af;
   int ag;
   int ah;
   int ai;
   byte[] aW;
   byte[] aX;
   int aj;
   boolean v;
   byte[] aY;
   int ak;
   int al;
   int am;
   int an;
   int ao;
   int ap;
   byte aT;
   byte aU;
   byte aV;
   int[] o;
   byte aW;
   byte aX;
   byte aY;
   byte aZ;
   byte ba;
   int aq;
   int ar;
   int as;
   int[] p;
   int[] q;
   int at;
   int au;
   int av;
   int aw;
   int ax;
   int ay;
   int az;
   int aA;
   int aB;
   int aC;
   int aD;
   int aE;
   int aF;
   int aG;
   int aH;
   int aI;
   boolean w;
   int[][] h;
   int aJ;
   int aK;
   int aL;
   int aM;
   byte bb;
   int aN;
   int aO;
   int aP;
   int aQ;
   int aR;
   int aS;
   int aT;
   int aU;
   byte bc;
   byte bd;
   byte be;
   boolean x;
   short p;
   short q;
   byte[] aZ;
   int aV;
   int aW;
   int aX;
   int aY;
   byte bf;
   byte bg;
   int aZ;
   byte bh;
   byte bi;
   int ba;
   byte bj;
   int bb;
   int bc;
   byte bk;
   int bd;
   int be;
   int bf;
   int bg;
   int bh;
   int bi;
   int bj;
   int bk;
   int bl;
   int bm;
   int bn;
   int bo;
   int bp;
   int bq;
   int br;
   int bs;
   int bt;
   int bu;
   int bv;
   int bw;
   int bx;
   int by;
   int bz;
   long c;
   boolean y;
   String c;

   public e(Park var1) {
      super(false);
      this.a = new Graphics[]{this.a, this.b};
      this.a = new Random();
      this.a = 0L;
      this.b = 0L;
      this.a = 0;
      this.a = new byte[]{0, 2, 0, -2};
      this.b = 3;
      this.f = -1;
      this.i = -1;
      this.k = 24;
      this.l = 100;
      this.m = 4;
      this.n = 4;
      this.o = 15;
      this.p = 20;
      this.q = 20;
      this.r = 30;
      this.s = 10;
      this.t = (byte)(this.m * 10);
      this.u = 10;
      this.v = 45;
      this.a = new int[][]{{500, 400, 500, 600, 650, 700}, {500, 300, 350, 400, 450, 500}};
      this.b = new int[][]{{700}, {600}};
      this.a = new int[][][]{
         {{100, 2, 5}, {750, 5, 40}, {1500, 6, 80}, {3000, 7, 120}, {6000, 8, 150}, {10000, 9, 170}},
         {{100, 2, 5}, {1500, 6, 60}, {3000, 7, 100}, {5000, 8, 150}, {10000, 9, 180}, {15000, 9, 190}}
      };
      this.b = new int[][][]{this.b, this.a};
      this.x = 7;
      this.b = new byte[19];
      this.E = 1;
      this.F = -1;
      this.G = -1;
      this.H = -1;
      this.I = -1;
      this.J = -1;
      this.N = 0;
      this.P = 0;
      this.R = 9;
      this.c = new byte[]{1, 0, 2, 3, 95, 40};
      this.d = new byte[]{21, 4, 6, 2, 3, 5};
      this.e = new byte[]{8, 9};
      this.f = new byte[]{10, 11};
      this.g = new byte[]{12, 11};
      this.h = new byte[]{13};
      this.i = new byte[]{10, 12, 11};
      this.j = new byte[]{12};
      this.k = new byte[]{14, 15, 16, 17, 18, 99};
      this.l = new byte[]{112};
      this.m = new byte[]{21, 22};
      this.n = new byte[]{94, 24, 25, 26, 27, 28};
      this.o = new byte[]{30, 31, 16, 32, 33};
      this.p = new byte[]{35};
      this.q = new byte[]{36};
      this.r = new byte[]{37};
      this.s = new byte[]{115, 116, 117, 118, 119};
      this.t = new byte[]{96, 97};
      this.u = new byte[]{100, 101, 102, 103, 104};
      this.a = new byte[][]{
         this.c,
         this.d,
         new byte[0],
         new byte[0],
         this.l,
         new byte[0],
         this.m,
         this.t,
         this.n,
         this.s,
         new byte[0],
         this.o,
         {39},
         {34},
         this.p,
         this.q,
         this.r,
         this.e,
         this.f,
         this.g,
         this.h,
         this.i,
         this.j,
         new byte[0],
         new byte[0],
         this.u,
         this.k
      };
      this.v = new byte[]{6, 6, 0, 0, 1, 0, 2, 2, this.E, 5, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 3, 1, 0, 0, 0, 6, 0};
      this.w = new byte[]{109, 110, 3, 95, 2, 20, -1, -1, 23, 114, 0, 29, -1, -1, -1, -1, -1, 7, 0, 0, 0, 0, 0, 19, 38, 98, 0};
      this.x = new byte[3];
      this.y = new byte[3];
      this.o = false;
      this.p = false;
      this.c = new int[8][d.k[4] + 2];
      this.d = new int[][]{{0, 500}, {0, 10}, {0, 10}, {0, 50}};
      this.a = new short[]{40, 100, 250, 150, 300, 200, 350, 50, 200, 400, 250, 500, 300, 600};
      this.e = new int[3][2];
      this.l = 240;
      this.m = 320;
      this.a = new Image[11];
      this.b = new Image[13];
      this.c = new Image[6];
      this.d = new Image[6];
      this.a = new Image[][]{this.a, this.b, this.c, this.d};
      this.e = new Image[4];
      this.b = new byte[30][30];
      this.c = new byte[30][30];
      this.a = new short[6][6];
      this.d = new byte[10][10];
      this.aa = 5;
      this.n = 0;
      this.q = true;
      this.z = new byte[4];
      this.a = new int[2];
      this.f = new int[4][2];
      this.A = new byte[222];
      this.B = new byte[222];
      this.C = new byte[222];
      this.D = new byte[222];
      this.E = new byte[222];
      this.F = new byte[222];
      this.G = new byte[222];
      this.H = new byte[222];
      this.e = new byte[][]{this.G, this.H};
      this.I = new byte[222];
      this.J = new byte[222];
      this.K = new byte[]{0, 1, 0, 2};
      this.f = new byte[3][200];
      this.L = new byte[200];
      this.b = new short[200];
      this.M = new byte[200];
      this.N = new byte[200];
      this.O = new byte[200];
      this.P = new byte[200];
      this.Q = new byte[200];
      this.R = new byte[200];
      this.S = new byte[200];
      this.T = new byte[200];
      this.U = new byte[200];
      this.V = new byte[200];
      this.ad = 6;
      this.ae = 7;
      this.W = new byte[222];
      this.g = new byte[][]{this.P, this.Q, this.R, this.S, this.T, this.U, this.V, this.W, this.L};
      this.b = new short[][]{{20, 20, 25, 25, 20, 350, 50}, {12, 12, 16, 16, 12, 150, 25}};
      this.af = 20;
      this.b = 2000;
      this.h = new byte[3][222];
      this.X = new byte[222];
      this.c = new short[222];
      this.c = new short[30][30];
      this.d = new short[222];
      this.d = new short[2][200];
      this.e = new short[b.j[3] + 1];
      this.i = new byte[30][2];
      this.Y = new byte[30];
      this.j = new byte[30][20];
      this.a = new byte[30][20][2];
      this.k = new byte[15][2];
      this.Z = new byte[42];
      this.aa = new byte[42];
      this.l = new byte[2][42];
      this.m = new byte[2][42];
      this.n = new byte[2][42];
      this.ab = new byte[42];
      this.ac = new byte[42];
      this.e = new short[42][12];
      this.ad = new byte[42];
      this.ae = new byte[42];
      this.f = new short[42][10];
      this.af = new byte[42];
      this.ag = new byte[42];
      this.ah = new byte[42];
      this.ai = new byte[42];
      this.aj = new byte[42];
      this.a = new boolean[42];
      this.b = new boolean[42];
      this.c = new boolean[42];
      this.aj = 0;
      this.ak = new byte[90];
      this.d = new boolean[90];
      this.e = new boolean[90];
      this.f = new boolean[90];
      this.g = new boolean[24];
      this.al = new byte[24];
      this.f = new short[24];
      this.am = new byte[24];
      this.an = new byte[24];
      this.ao = new byte[24];
      this.ap = new byte[24];
      this.aq = new byte[24];
      this.ar = new byte[24];
      this.as = new byte[24];
      this.at = new byte[24];
      this.au = new byte[24];
      this.av = new byte[24];
      this.aw = new byte[24];
      this.ax = new byte[24];
      this.ay = new byte[24];
      this.az = new byte[24];
      this.aA = new byte[24];
      this.aB = new byte[24];
      this.aC = new byte[24];
      this.aD = new byte[25];
      this.al = 114;
      this.o = new byte[24][];
      this.g = new short[24][42];
      this.aE = new byte[27];
      this.g = new short[6];
      this.h = new boolean[27];
      this.aF = new byte[27];
      this.aG = new byte[27];
      this.aH = new byte[27];
      this.p = new byte[27][];
      this.h = new short[27][16];
      this.a = new boolean[][]{this.g, this.h};
      this.h = new short[177];
      this.aJ = new byte[]{24, 27};
      this.q = new byte[][]{{5, 6}, {34}, {7, 8}};
      this.aK = new byte[]{9, 10};
      this.r = new byte[][]{{2, 3, 3, 2}, {3, 2, 2, 3}};
      this.b = new int[2];
      this.aL = new byte[2];
      this.aM = new byte[2];
      this.aN = new byte[1150];
      this.i = new short[500];
      this.aO = new byte[3200];
      this.j = new short[50];
      this.aP = new byte[7200];
      this.k = new short[50];
      this.s = new byte[][]{this.aP, this.aO, this.aN, this.aO};
      this.i = new short[][]{this.k, this.j, this.i, this.j};
      this.b = new String[]{"helptext.da", "warntext.da", "text.da"};
      this.ay = 20;
      this.az = 0;
      this.t = new byte[this.ay][80];
      this.u = new byte[this.ay][80];
      this.c = new int[this.ay];
      this.d = new int[this.ay];
      this.e = new int[this.ay];
      this.f = new int[this.ay];
      this.g = new int[this.ay];
      this.l = new short[250];
      this.m = new short[250];
      this.aB = -1;
      this.i = new boolean[32];
      this.aD = 2;
      this.j = new boolean[this.aD];
      this.aE = 12;
      this.aF = 100;
      this.aG = 0;
      this.v = new byte[this.aF][2];
      this.w = new byte[this.aF][5];
      this.h = new int[this.aF];
      this.i = new int[this.aF];
      this.j = new int[this.aF];
      this.k = new int[this.aF];
      this.l = new int[this.aF];
      this.aH = 20;
      this.x = new byte[this.aH][2];
      this.aQ = new byte[this.aH];
      this.aR = new byte[this.aH];
      this.aS = new byte[this.aH];
      this.aI = -60;
      this.j = 0;
      this.aT = new byte[2];
      this.a = new StringBuffer(50);
      this.a = null;
      this.I = 60;
      this.J = 7;
      this.K = 5;
      this.g = new int[][]{{0, 15662897, 16762897, 16691973, 0}, {0, 8940804, 8928768, 8859904, 0}};
      this.m = new int[]{(240 - this.I) / 2, 0, (240 + this.I) / 2};
      this.aJ = 0;
      this.aK = 0;
      this.Q = 0;
      this.c = new String[]{"arrsi.dat", "arr.dat"};
      this.n = new int[3];
      this.aU = new byte[4];
      this.aV = new byte[2];
      this.aW = new byte[4];
      this.aX = new byte[]{0, 1, 1, 2};
      this.aY = new byte[6];
      this.o = new int[4];
      this.p = new int[2];
      this.q = new int[2];
      this.h = new int[2][this.u.length];
      this.aZ = new byte[2];
      this.a = var1;
      this.setFullScreenMode(true);
   }

   final void a() {
      try {
         this.b[0] = Image.createImage("/splash2.png");
         this.a.drawImage(this.b[0], 0, 0, 20);
         this.b[0] = null;
      } catch (Exception var2) {
      }

      this.a(15);
      System.gc();
      this.t();
      System.gc();
      this.dH();
      this.a(60);

      for (this.L = 0; this.L < 32; this.L++) {
         this.i[this.L] = false;
      }

      for (this.L = 0; this.L < this.aD; this.L++) {
         this.j[this.L] = false;
      }

      System.gc();
      this.a = new a("entry.mid", "audio/midi");
      this.dU();
      this.a(80);
      this.b();
      this.e[0] = this.c[2];
      this.e[1] = this.c[2];
      this.e[2] = this.a[0];
      this.e[3] = this.c[2];

      for (this.L = 0; this.L < 10; this.L++) {
         for (this.M = 0; this.M < 10; this.M++) {
            this.d[this.L][this.M] = (byte)(-1 - (this.a.nextInt() & 65535) % 12);
         }
      }

      this.a[0][this.v[0] - 1] = 40;
      this.cu();
      this.a(100);
      this.c();
   }

   final void b() {
      try {
         for (this.L = 0; this.L < 4; this.L++) {
            System.gc();
            this.a = this.getClass().getResourceAsStream("/gpack" + this.L + ".dat");
            if (this.a != null) {
               for (this.M = 0; this.M < this.a[this.L].length; this.M++) {
                  System.gc();
                  this.u = this.a.read();
                  this.v = this.a.read();
                  int var2;
                  if ((var2 = this.v * 256 + this.u) != 0) {
                     byte[] var1 = new byte[var2];
                     this.a.read(var1, 0, var2);
                     this.a[this.L][this.M] = Image.createImage(var1, 0, var2);
                  }
               }
            }

            this.a.close();
            this.a = null;
            this.a(82 + this.L * 5);
         }

         System.gc();
         this.a = Image.createImage(this.l, this.m);
         this.b = this.a.getGraphics();
         this.a[1] = this.b;
         this.b[7] = this.a[10];
      } catch (IOException var3) {
      }
   }

   final void a(int var1) {
      this.m[1] = (240 - this.I) / 2 + var1 * this.I / 100;

      for (this.q = 0; this.q < 2; this.q++) {
         for (this.r = 0; this.r < this.K; this.r++) {
            this.a.setColor(this.g[this.q][this.r]);
            this.a.drawLine(this.m[this.q], 320 - this.J + this.r, this.m[this.q + 1], 320 - this.J + this.r);
         }
      }

      for (this.q = 0; this.q < 2; this.q++) {
         this.a.setColor(0);
         this.a.drawLine(this.m[this.q * 2], 320 - this.J, this.m[this.q * 2], 320 - this.J + this.K - 1);
      }

      this.flushGraphics(0, 0, this.l, this.m);
   }

   public final void c() {
      this.c = true;
      this.a = new Thread(this);
      this.a.start();
   }

   public final void d() {
      this.dT();
      this.c = false;
      if (this.a != null) {
         this.a.c();
      }

      this.a.notifyDestroyed();
   }

   public final void hideNotify() {
      if (this.c) {
         if (this.aJ > 0) {
            this.br();
            this.aK = 1;
         }

         if (this.a != null) {
            this.a.c();
         }
      }

      this.b = true;
   }

   public final void showNotify() {
      if (this.c) {
         if (this.b) {
            this.b = false;
            this.e();
         }

         this.a = null;
         System.gc();
         this.a = new a("entry.mid", "audio/midi");
      } else {
         this.b = false;
      }
   }

   final void e() {
      if (this.b != 3 || this.R != 16) {
         this.i = -1;
         this.q = true;
         this.aL = this.b;
         this.aM = this.R;
         this.aN = this.aA;
         this.b = 3;
         this.R = 16;
         this.cv();
         this.aa = 5;
      }
   }

   final void f() {
      this.b = this.aL;
      this.R = this.aM;
      this.aA = this.aN;
      this.aJ = this.aK;
      if (this.b == 3) {
         this.cv();
      }

      if (this.b == 2) {
         this.cp();
      }

      if (this.b != 1 && this.b != 4 && this.b != 5) {
         this.aa = 5;
      } else {
         this.aL = this.b;
         this.b = 0;
         this.a = 1;
         this.aa = 5;
         this.x();
         this.al();
         this.a = 0;
         this.b = this.aL;
         this.aa = 0;
      }

      if ((this.b != 3 || this.R != 9 && this.R != 15) && this.aJ > 0) {
         this.a.a(this.aJ, 0);
      }
   }

   final void g() {
      this.h();
      this.i();
      this.j();
      this.e = 0;
      this.g = 0;
      this.f = -1;
      this.h = -1;

      for (this.N = 0; this.N < this.aD; this.N++) {
         this.j[this.N] = false;
      }

      this.k = this.b[this.K][this.M][this.L];
      this.e[0][0] = this.k;
      this.e[1][0] = 0;
      this.e[2][0] = 0;

      for (this.N = 0; this.N < 8; this.N++) {
         if (this.N < 3) {
            this.c[this.N][0] = this.e[this.N][0];
         } else {
            this.c[this.N][0] = 0;
         }

         this.c[this.N][d.k[4]] = 1;
      }

      this.b = 0;
      this.c = 0;
      this.d = 0;
      this.e = 0;
      this.f = 0;
      this.g = 0;
      this.w = -1;
      this.V = 0;
      this.b[this.ab][0] = 0;
   }

   final void h() {
      if (this.K == 1) {
         this.O = this.aI[this.h[134] + this.L];

         for (this.N = 0; this.N < 2; this.N++) {
            for (this.O = 0; this.O < this.aJ[this.N]; this.O++) {
               if (this.aI[this.h[40 + this.N] + this.aJ[this.N] * this.L + this.O] == 1) {
                  this.a[this.N][this.O] = true;
               } else {
                  this.a[this.N][this.O] = false;
               }
            }
         }

         for (this.N = 0; this.N < this.b.length; this.N++) {
            this.b[this.N] = 0;
         }

         this.D = 0;
         this.e[0][1] = this.a[this.M][this.L][0];
         this.e[1][1] = this.a[this.M][this.L][1];
         this.e[2][1] = this.a[this.M][this.L][2];
      } else if (this.K == 0) {
         for (this.N = 0; this.N < 2; this.N++) {
            for (this.O = 0; this.O < this.a[this.N].length; this.O++) {
               this.a[this.N][this.O] = true;
            }
         }

         this.O = 30;
      }

      this.ab = (byte)(this.O / 2);
      this.a[0] = this.ab;
      this.a[1] = 0;
      this.r();
   }

   final void i() {
      for (this.N = 0; this.N < this.O; this.N++) {
         for (this.O = 0; this.O < this.O; this.O++) {
            if ((this.a.nextInt() & 65535) % 20 == 0) {
               this.b[this.N][this.O] = (byte)(-1 - (this.a.nextInt() & 65535) % 12);
            } else {
               this.b[this.N][this.O] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
            }

            this.c[this.N][this.O] = 0;
            this.c[this.N][this.O] = -1;
            if (((this.N + 1) % 5 == 0 || this.N + 1 == this.O) && ((this.O + 1) % 5 == 0 || this.O + 1 == this.O)) {
               this.Y = (byte)(this.N / 5);
               this.Z = (byte)(this.O / 5);
               this.cH();
            }
         }
      }

      for (this.N = 0; this.N < 222; this.N++) {
         this.d[this.N] = -1;
         this.B[this.N] = -1;
      }

      for (this.N = 0; this.N < 42; this.N++) {
         this.l[0][this.N] = -1;
      }

      for (this.N = 0; this.N < 90; this.N++) {
         this.ak[this.N] = -1;
      }

      for (this.N = 0; this.N < 30; this.N++) {
         this.i[this.N][0] = -1;
      }

      for (this.N = 0; this.N < 15; this.N++) {
         this.k[this.N][0] = -1;
      }
   }

   final void j() {
      for (this.N = 0; this.N < this.aF; this.N++) {
         this.l[this.N] = this.o;
      }

      for (this.N = 0; this.N < this.aH; this.N++) {
         this.x[this.N][0] = -1;
      }

      for (this.N = 0; this.N < 24; this.N++) {
         this.al[this.N] = (byte)(this.aA[this.N] / b.au[0]);
         this.o = this.N;
         this.cI();
         this.aD[this.N] = 0;
      }

      this.aD[24] = 0;

      for (this.N = 0; this.N < 6; this.N++) {
         this.aE[this.N] = b.aq[this.N];
      }

      for (this.N = 0; this.N < 27; this.N++) {
         if (this.aI[this.h[57] + this.N] >= 0) {
            this.o = this.N;
            this.cJ();
         }
      }

      this.ai = 0;
      this.ak = 0;
      this.c[2][d.k[4] + 1] = this.a = 0;
      this.ac = 0;

      for (this.N = 0; this.N < b.j[3] + 1; this.N++) {
         this.e[this.N] = 0;
      }

      for (this.N = 0; this.N < 4; this.N++) {
         this.aW[this.N] = 0;
      }

      this.y = 0;
      this.d = -1;
      this.W = 0;
      this.X = 0;
      this.e = false;
      this.g = false;
      this.h = false;
   }

   public final void run() {
      this.a.a = null;
      this.a.b = null;
      System.gc();

      try {
         while (this.c) {
            if (this.b) {
               Thread.sleep(30L);
            } else {
               Thread.sleep(1L);
               this.b = System.currentTimeMillis();
               if (this.b > this.a + 100L) {
                  this.aS();
                  this.k();
                  this.a = 1;
                  if (this.aa != 0) {
                     this.x();
                  }

                  this.a = 0;
                  this.a[this.a].drawImage(this.a, 0, 0, 20);
                  if (this.i >= 0) {
                     this.i++;
                  }

                  if (this.i >= this.s) {
                     this.i = -1;
                  }

                  if (this.b == 0) {
                     this.l();
                     this.m();
                     this.n();
                     if (this.b == 3) {
                        continue;
                     }
                  } else {
                     this.o();
                  }

                  this.p();
                  this.a = this.b;
               }
            }
         }
      } catch (Exception var2) {
      }
   }

   final void k() {
      if (this.b == 0) {
         if (this.e % (this.m * 2) == 0 && this.a < 200 - (30 - this.O - 5) * 10 && this.a < 200) {
            this.cS();
         }

         this.e++;
         if (this.e >= this.t) {
            this.e = 0;
            this.g++;
            if (this.g >= 16) {
               this.g = 0;
            }
         }

         this.cL();
         this.cK();
         this.cU();
         if (this.h) {
            if (this.d >= 0) {
               this.d++;
            }

            if (this.d >= 2) {
               this.d = -1;
            }
         }

         if ((this.g || !this.e) && !this.h) {
            if (this.d >= 0) {
               this.d++;
               if (this.d < this.n) {
                  this.W = b.m[this.d];
                  this.X = b.n[this.d];
                  this.aa = 5;
               } else {
                  this.d = -1;
               }
            }

            if (this.g && this.d >= 3) {
               this.cc();
               this.cn();
               this.g = false;
            }
         }

         for (this.q = 0; this.q < this.aF; this.q++) {
            if (this.l[this.q] < this.o) {
               this.l[this.q]++;
               if (this.l[this.q] == this.o) {
                  this.aG--;
               }
            }
         }

         this.dF();
      }
   }

   final void l() {
      this.aj++;
      if (this.aj >= 3) {
         this.aj = 0;
      }

      if (!this.e) {
         this.a[this.a]
            .drawRegion(
               this.c[1],
               0,
               0,
               b.B[0] - 2,
               b.B[1],
               0,
               (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W,
               (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X,
               20
            );
      } else if (this.aX == 1 && this.aW == 26) {
         this.K();
      }

      this.al();
   }

   final void m() {
      if (this.e) {
         this.x = (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W;
         this.y = (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) - this.C / 2 * b.B[1] + this.X;
         if (this.j >= 0) {
            this.y = (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) - this.o[this.aW][this.g[this.aW][0] + 1] / 2 * b.B[1] + this.X;
         }

         if (this.aX == 2) {
            this.x = this.x + (b.B[0] / 2 - this.aI[this.h[51] + this.C] / 2);
            this.y = this.y + (b.B[1] / 2 - this.aI[this.h[52] + this.C]);
         }

         this.af();
         if (this.aX < 2) {
            this.a[this.a].drawRegion(this.c[2], b.C[1], b.D[1], b.E[1], b.F[1], 0, this.x + this.z / 2 - b.G[1], this.y + b.H[1], 20);
         }

         if (this.aX == 2) {
            this.a[this.a].drawRegion(this.c[2], b.C[2], b.D[2], b.E[2], b.F[2], 0, this.x + this.z / 2 - b.G[2], this.y - b.H[2], 20);
         }

         this.d++;
         if (this.d >= this.k) {
            this.d = 0;
            return;
         }
      } else {
         if (this.h) {
            if (this.d < 0) {
               this.q = 0;
            } else {
               this.q = this.d;
            }

            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  b.I[this.q],
                  b.J[this.q],
                  b.K[this.q],
                  b.L[this.q],
                  0,
                  (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + b.M[this.q],
                  (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + b.N[this.q],
                  20
               );
            return;
         }

         if (this.c[this.a[0]][this.a[1]] > -1
            || this.b[this.a[0]][this.a[1]] > 3 && this.b[this.a[0]][this.a[1]] <= 13
            || this.b[this.a[0]][this.a[1]] <= -15 && this.b[this.a[0]][this.a[1]] >= -28) {
            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  b.C[0],
                  b.D[0],
                  b.E[0],
                  b.F[0],
                  0,
                  (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + b.G[0],
                  (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + b.H[0],
                  20
               );
         }
      }
   }

   final void n() {
      this.aR();
      if (this.e == 1 && this.g == 0 && this.b == 0 && this.K == 1 && this.L == 0 && this.D == 0) {
         this.q();
      }

      if (this.e == 0) {
         this.u = false;
         if (this.k > 0 && this.w > -1) {
            this.w = -1;
         }

         if (this.k < -50 && this.w == -1) {
            this.w = 0;
            this.f = 0;
            this.aC = 1;
            this.aA = 20;
            this.aB = this.aA;
            this.dI();
            this.u = true;
         }

         if (this.k < 0 && this.w > -1) {
            this.w++;
            if (this.w >= 48) {
               this.b(13);
            }
         }

         this.ad();
         if (this.K == 1
            && (this.e[0][0] >= this.e[0][1] && this.e[1][0] >= this.e[1][1] && this.e[2][0] >= this.e[2][1] && this.L != 0 || this.L == 0 && this.D >= 8)) {
            this.b(12);
         }

         if (this.Q >= 1) {
            if (this.Q < 8) {
               this.Q++;
            } else {
               this.Q = 0;
            }
         } else if (this.K == 1 && this.L == 0 && this.D < 8) {
            this.t = true;

            for (this.P = this.aI[this.h[142] + this.D]; this.P < this.aI[this.h[142] + this.D + 1]; this.P++) {
               if (this.b[this.P] == 0) {
                  this.t = false;
                  break;
               }
            }

            if (this.t) {
               this.q();
            }
         }

         if (this.g == 0) {
            this.b++;
            if (this.e[b.j[3]] > 0) {
               this.ab();
               if (!this.u) {
                  this.f = 0;
                  this.aC = 1;
                  this.aA = 9;
                  this.aB = this.aA;
                  this.dI();
               }
            }

            this.ac();
            if (this.K == 1 && this.c < this.aI[this.h[161] + this.L] && this.aI[this.h[156 + this.L - 1] + this.c * 3] == this.b) {
               this.aZ = this.aX;
               this.aY = this.aW;
               this.ba = this.at;
               this.aX = this.aI[this.h[156 + this.L - 1] + this.c * 3 + 1];
               this.aW = this.aI[this.h[156 + this.L - 1] + this.c * 3 + 2];
               this.a[this.aX][this.aW] = true;
               this.c++;
               this.b(24);
            }

            if (this.K == 0 && this.b % 12 == 0) {
               this.b(25);
               if (this.h[0][0] == 0) {
                  this.V++;
               } else {
                  this.V = 0;
               }
            }
         }
      }

      this.dQ();
      if (this.f >= 0) {
         if (this.aC != 1 || this.aA != this.aB) {
            this.aC = 1;
            this.aA = this.aB;
            this.dI();
         }

         this.E();
         this.f++;
         if (this.f >= this.p) {
            this.f = -1;
         }
      }
   }

   final void o() {
      if (this.b == 1) {
         this.S();
      } else if (this.b == 2) {
         this.ak();
      } else if (this.b == 3) {
         this.L();
      } else if (this.b == 4) {
         this.T();
      } else {
         if (this.b == 5) {
            this.E();
            this.Q();
         }
      }
   }

   final void p() {
      if (this.b != 3 || this.R > 17) {
         this.cG();
         this.ar();
      }

      if (this.b == 0 || this.b == 1) {
         this.cF();
      }

      this.dP();
      this.aq();
      this.flushGraphics(0, 0, this.l, this.m);
   }

   final void b(int var1) {
      this.b = 3;
      this.R = (byte)var1;
      this.cu();
      this.aa = 5;
      this.i = 0;
   }

   final void q() {
      this.a = 1;
      this.al();
      this.a = 0;
      this.b = 5;
      this.aa = 0;
      this.aC = 1;
      this.aA = (byte)(30 + this.D);
      this.dI();
      this.D++;
      if (this.D == 7) {
         this.Q = 1;
      }

      this.i = 0;
      this.u = true;
   }

   final void r() {
      this.f[0][0] = this.a[0] - this.m / 2 / b.B[1] - this.l / 2 / b.B[0];
      this.f[0][1] = this.a[1] + this.m / 2 / b.B[1] - this.l / 2 / b.B[0];
      this.f[1][0] = this.f[0][0] + this.l / b.B[0] - 1;
      this.f[1][1] = this.f[0][1] + this.l / b.B[0] - 1;
      this.f[2][0] = this.f[0][0] + this.l / b.B[0] - 1 + this.m / b.B[1] - 1;
      this.f[2][1] = this.f[0][1] + this.l / b.B[0] - this.m / b.B[1];
      this.f[3][0] = this.f[0][0] + this.m / b.B[1] - 1;
      this.f[3][1] = this.f[0][1] + 1 - this.m / b.B[1];
   }

   final void s() {
      this.a[0] = (this.f[0][0] + this.f[1][0] + this.f[2][0] + this.f[3][0]) / 4;
      this.a[1] = (this.f[0][1] + this.f[1][1] + this.f[2][1] + this.f[3][1]) / 4;
   }

   final void t() {
      this.a = null;

      try {
         for (this.T = 0; this.T < 2; this.T++) {
            System.gc();
            this.a = this.getClass().getResourceAsStream(this.c[this.T]);
            if (this.a != null) {
               this.u();
               this.v();
               this.w();
            }

            this.a.close();
            this.a = null;
            System.gc();
            this.a(20 + this.T * 20);
         }
      } catch (IOException var2) {
      }
   }

   final void u() {
      try {
         for (this.R = 0; this.R < 24; this.R++) {
            if (this.T == 0) {
               this.am[this.R] = (byte)this.a.read();
               this.as[this.R] = (byte)this.a.read();
               this.at[this.R] = (byte)this.a.read();
               this.an[this.R] = (byte)this.a.read();
               this.ap[this.R] = (byte)this.a.read();
               this.ao[this.R] = (byte)this.a.read();
               this.aq[this.R] = (byte)this.a.read();
               this.au[this.R] = (byte)this.a.read();
               this.ar[this.R] = (byte)this.a.read();
               this.av[this.R] = (byte)this.a.read();
               this.aw[this.R] = (byte)this.a.read();
               this.ax[this.R] = (byte)this.a.read();
               this.ay[this.R] = (byte)this.a.read();
               this.az[this.R] = (byte)this.a.read();
               this.aA[this.R] = (byte)this.a.read();
               this.aB[this.R] = (byte)this.a.read();
               this.aC[this.R] = (byte)this.a.read();
               this.U = this.a.read() & 0xFF;
               this.V = this.a.read() & 0xFF;
               this.o[this.R] = new byte[this.V * 256 + this.U];
            } else {
               this.g[this.R][0] = 0;

               for (this.S = 0; this.S < 42; this.S++) {
                  this.U = this.a.read() & 0xFF;
                  this.V = this.a.read() & 0xFF;
                  this.W = this.V * 256 + this.U;
                  if (this.S < 41) {
                     this.g[this.R][this.S + 1] = (short)(this.g[this.R][this.S] + this.W);
                  }

                  if (this.W > 0) {
                     this.a.read(this.o[this.R], this.g[this.R][this.S], this.W);
                  }
               }
            }
         }
      } catch (IOException var2) {
      }
   }

   final void v() {
      try {
         for (this.R = 0; this.R < 27; this.R++) {
            if (this.T == 0) {
               this.aH[this.R] = (byte)this.a.read();
               this.aF[this.R] = (byte)this.a.read();
               this.aG[this.R] = (byte)this.a.read();
               this.U = this.a.read() & 0xFF;
               this.V = this.a.read() & 0xFF;
               this.p[this.R] = new byte[this.V * 256 + this.U];
            } else {
               this.h[this.R][0] = 0;

               for (this.S = 0; this.S < 16; this.S++) {
                  this.U = this.a.read() & 0xFF;
                  this.V = this.a.read() & 0xFF;
                  this.W = this.V * 256 + this.U;
                  if (this.S < 15) {
                     this.h[this.R][this.S + 1] = (short)(this.h[this.R][this.S] + this.W);
                  }

                  if (this.W > 0) {
                     this.a.read(this.p[this.R], this.h[this.R][this.S], this.W);
                  }
               }
            }
         }
      } catch (IOException var2) {
      }
   }

   final void w() {
      try {
         if (this.T == 0) {
            this.U = this.a.read() & 0xFF;
            this.V = this.a.read() & 0xFF;
            this.aI = new byte[this.V * 256 + this.U];
         } else {
            this.h[0] = 0;

            for (this.R = 0; this.R < 177; this.R++) {
               this.U = this.a.read() & 0xFF;
               this.V = this.a.read() & 0xFF;
               this.W = this.V * 256 + this.U;
               if (this.R < 176) {
                  this.h[this.R + 1] = (short)(this.h[this.R] + this.W);
               }

               if (this.W > 0) {
                  this.a.read(this.aI, this.h[this.R], this.W);
               }
            }
         }
      } catch (IOException var2) {
      }
   }

   final void x() {
      if (this.b == 0) {
         if (this.aa != 0) {
            this.a[this.a].setColor(0);
            this.a[this.a].fillRect(0, 0, this.l, this.m);
            this.a(0, -(b.B[1] / 2), this.l, this.m);
         }
      } else if (this.b == 2 || this.b == 3) {
         this.y();
         this.z();
      }

      this.aa = 0;
   }

   final void y() {
      this.a[this.a].setColor(d.a[0][0], d.a[0][1], d.a[0][2]);
      this.a[this.a].fillRect(0, 0, this.l, this.m / 2);

      for (this.q = 0; this.q < this.m / 4; this.q++) {
         this.u = d.a[0][0] - (d.a[0][0] - d.a[1][0]) * this.q / (this.m / 4);
         this.v = d.a[0][1] - (d.a[0][1] - d.a[1][1]) * this.q / (this.m / 4);
         this.w = d.a[0][2] - (d.a[0][2] - d.a[1][2]) * this.q / (this.m / 4);
         this.a[this.a].setColor(this.u, this.v, this.w);
         this.a[this.a].drawLine(0, this.m / 2 + this.q, this.l, this.m / 2 + this.q);
      }

      this.a[this.a].setColor(d.a[1][0], d.a[1][1], d.a[1][2]);
      this.a[this.a].fillRect(0, this.m * 3 / 4, this.l, this.m / 4);
      this.a[this.a].setColor(14734447);

      for (this.q = 0; this.q < 2; this.q++) {
         for (this.r = 0; this.r < 7; this.r++) {
            if (this.q == 1) {
               this.a[this.a].fillRect(22 + d.c[0][this.r], d.c[this.r], d.c[1][this.r] - 22 - d.c[0][this.r], this.m - d.c[this.r]);
            }

            this.a[this.a].drawRegion(this.d[2], b.p[this.q], 0, 22, 42, 0, d.c[this.q][this.r], d.c[this.r], 20);
         }
      }

      for (this.q = 0; this.q < 5; this.q++) {
         this.a[this.a].drawRegion(this.d[5], d.b[this.q], d.c[this.q], d.d[this.q], d.e[this.q], 0, d.d[this.q], d.f[this.q], 20);
      }
   }

   final void z() {
      this.w = 0;
      this.ac = 0;
      this.ac = 15;

      for (this.q = 0; this.q < 2; this.q++) {
         for (this.r = 0; this.r < 2; this.r++) {
            this.a[this.a].drawRegion(this.d[3], b.a[this.q][this.r], b.r[this.r], b.q[this.r], b.s[this.r], 0, b.b[this.q][this.r], 0 - this.ac, 20);
         }
      }

      if ((this.b == 2 || this.b == 3 && ((this.R == 19 || this.R == 21 || this.R == 22) && this.n || this.R == 20 || this.R == 23 || this.R == 24)) && !this.p
         )
       {
         if (this.b == 2) {
            if (this.aX == 2) {
               this.ab = 1;
            } else {
               this.ab = 0;
            }
         } else {
            this.ab = (byte)(this.R - 19 + 2);
         }

         this.A();
      }
   }

   final void a(int var1, int var2, int var3, int var4) {
      for (this.X = var2 + this.X; this.X < var4; this.X = this.X + b.B[1] / 2) {
         if ((this.X - this.X) % b.B[1] == 0) {
            this.Y = var1 + this.W;
         } else {
            this.Y = var1 - b.B[0] / 2 + this.W;
         }

         while (this.Y < var3) {
            this.F();
            this.J();
            this.Y = this.Y + b.B[0];
         }
      }
   }

   final void A() {
      for (this.q = 0; this.q < 4; this.q++) {
         for (this.r = 0; this.r < d.a[d.g[this.ab]][this.q / 2]; this.r++) {
            this.a[this.a]
               .drawRegion(
                  this.d[4],
                  d.a[d.g[this.ab]][this.q / 2][this.r],
                  d.b[d.g[this.ab]][this.q / 2][this.r],
                  d.c[d.g[this.ab]][this.q / 2][this.r],
                  d.d[d.g[this.ab]][this.q / 2][this.r],
                  0,
                  d.a[d.g[this.ab]][this.q][this.r] + d.g[this.ab],
                  d.b[d.g[this.ab]][this.q][this.r] + d.h[this.ab],
                  20
               );
         }
      }
   }

   final void B() {
      if (this.b == 2 && this.aX == 2) {
         this.ad = 176 - this.aI[this.h[119] + this.r] / 2;
      } else {
         this.ad = 196;
      }

      if ((this.b == 2 || this.b == 3 && this.R == 26 && !this.d) && !this.o) {
         for (this.r = 0; this.r < 2; this.r++) {
            this.a[this.a]
               .drawRegion(
                  this.d[1],
                  this.aI[this.h[116] + this.r],
                  this.aI[this.h[117] + this.r],
                  this.aI[this.h[118] + this.r],
                  this.aI[this.h[119] + this.r],
                  0,
                  d.e[this.r] + this.a[(this.a + this.r * 2) % 4],
                  this.ad,
                  20
               );
         }
      }
   }

   final void C() {
      if (this.b == 3 && this.w[this.R] >= 0 && this.aI[this.h[93] + this.R] == 0 || this.b == 2) {
         for (this.s = 0; this.s < 2; this.s++) {
            for (this.t = 0; this.t < b.u[0]; this.t++) {
               this.a[this.a].drawRegion(this.d[5], b.t[this.s], b.b[0][this.t], 50, b.c[0][this.t], 0, d.i[this.s], d.f[2][0] + b.d[0][this.t], 20);
            }
         }
      }
   }

   final void D() {
      this.a[this.a].setColor(14734447);
      this.a[this.a].fillRect(d.F[0], this.H + d.F[1], d.F[2], d.F[3]);

      for (this.r = 0; this.r < 11; this.r++) {
         this.a[this.a].drawRegion(this.d[5], d.m[this.r], d.n[this.r], d.o[this.r], d.p[this.r], 0, d.D[this.r], this.H + d.E[this.r], 20);
      }

      for (this.q = 0; this.q < 2; this.q++) {
         for (this.r = 0; this.r < 3; this.r++) {
            this.a[this.a].drawRegion(this.d[2], b.p[this.q], d.k[this.r], 22, d.l[this.r], 0, d.g[this.q][this.r], this.H + d.C[this.r], 20);
         }
      }
   }

   final void E() {
      this.D();
      if (this.b != 1 || this.z == 0) {
         this.dR();
      }
   }

   final void F() {
      this.Z = ((this.X - this.X) / (b.B[1] / 2) + (this.Y - this.W) / (b.B[0] / 2)) / 2 + this.f[0][0];
      this.aa = ((this.Y - this.W) / (b.B[0] / 2) - (this.X - this.X) / (b.B[1] / 2)) / 2 + this.f[0][1];
      if (this.Z >= 0 && this.aa >= 0 && this.Z < this.O && this.aa < this.O) {
         if (this.b[this.Z][this.aa] != 0
            && this.e
            && this.ah > 0
            && (this.aX == 0 && this.o[this.aW][this.g[this.aW][4] + 3] == 1 || this.aX == 1 && this.aW == 26)) {
            for (this.u = 0; this.u < 15; this.u++) {
               if (this.k[this.u][0] >= 0
                  && this.d[this.c[this.k[this.u][0]][this.k[this.u][1]]]
                  && this.Z >= this.k[this.u][0] - b.j[0][0]
                  && this.Z <= this.k[this.u][0] + b.j[0][1]
                  && this.aa >= this.k[this.u][1] - b.j[1][0]
                  && this.aa <= this.k[this.u][1] + b.j[1][1]) {
                  this.a[this.a].drawRegion(this.c[1], 0, b.B[1] * 2, b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
                  return;
               }
            }
         }

         if (this.b[this.Z][this.aa] == 0) {
            this.a[this.a].drawRegion(this.b[2], b.O[this.c[this.Z][this.aa] / 4], b.P[this.c[this.Z][this.aa] / 4], b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
         } else if (this.b[this.Z][this.aa] > 0) {
            this.G();
         } else {
            this.H();
         }
      } else {
         this.I();
      }
   }

   final void G() {
      if (this.b[this.Z][this.aa] > 3 && this.b[this.Z][this.aa] <= 12) {
         this.an = 0;
         this.aI();
         if (this.b[this.Z][this.aa] == 7) {
            this.an = 11;
            this.aI();
         }

         if (this.b[this.Z][this.aa] == 8) {
            this.an = 14;
            this.aI();
         }

         if (this.b[this.Z][this.aa] == 5) {
            this.an = 13;
            this.aI();
         }

         if (this.b[this.Z][this.aa] == 6) {
            this.an = 12;
            this.aI();
            return;
         }
      } else if (this.b[this.Z][this.aa] <= 3) {
         this.a[this.a].drawRegion(this.c[0], 0, b.B[1] * (this.b[this.Z][this.aa] - 1), b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
      }
   }

   final void H() {
      if (this.b[this.Z][this.aa] < 0 && this.b[this.Z][this.aa] >= -27) {
         if (this.aI[this.h[89] + -1 - this.b[this.Z][this.aa]] == 0) {
            this.a[this.a].drawRegion(this.b[2], b.O[0], b.P[0], b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
         } else {
            this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
         }
      } else {
         this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
      }
   }

   final void I() {
      if (this.Z == this.ab && this.aa < 0) {
         this.a[this.a].drawRegion(this.b[2], b.O[0], b.P[0], b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
         this.aw();
      } else {
         this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
      }

      if (this.Z != -1 && this.aa != -1 && this.Z != this.O && this.aa != this.O && (this.Z != this.ab || this.aa > 0)) {
         if ((this.Z == this.ab - 1 || this.Z == this.ab + 1) && this.aa < 0) {
            this.an = -11;
         } else if (this.aa == -2 && this.Z >= 0 && this.Z < this.O) {
            this.an = -12;
         } else {
            this.an = this.d[(this.Z & 65535) % 10][(this.aa & 65535) % 10];
         }

         this.aG();
      }
   }

   final void J() {
      this.Z = ((this.X - this.X) / (b.B[1] / 2) + (this.Y - this.W) / (b.B[0] / 2)) / 2 + this.f[0][0];
      this.aa = ((this.Y - this.W) / (b.B[0] / 2) - (this.X - this.X) / (b.B[1] / 2)) / 2 + this.f[0][1];

      for (this.u = 0; this.u < 4; this.u++) {
         if ((this.Z == this.aI[this.h[39] + this.u * 6] || this.Z == this.O && this.aI[this.h[39] + this.u * 6] == 30)
            && (this.aa == this.aI[this.h[39] + this.u * 6 + 1] || this.aa == this.O && this.aI[this.h[39] + this.u * 6 + 1] == 30)) {
            for (this.v = 0; this.v < 2; this.v++) {
               this.a[this.a]
                  .drawRegion(
                     this.b[2],
                     this.aI[this.h[65] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]],
                     this.aI[this.h[66] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]],
                     this.aI[this.h[67] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]],
                     this.aI[this.h[68] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]],
                     0,
                     this.Y + this.aI[this.h[69] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2 + 1]],
                     this.X + this.aI[this.h[70] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2 + 1]],
                     20
                  );
            }
         }
      }

      if (this.Z == -1 && this.aa >= 0 && this.aa < this.O) {
         this.an = 0;
         this.ao = 0;
         this.aJ();
      }

      if (this.aa == this.O && this.Z >= 0 && this.Z < this.O) {
         this.an = 1;
         this.ao = 1;
         this.aJ();
      }

      if (this.Z == this.O && this.aa >= 0 && this.aa < this.O) {
         this.an = 0;
         this.ao = 2;
         this.aJ();
      }

      if (this.aa == -1 && this.Z >= 0 && this.Z < this.O && this.Z != this.ab) {
         this.an = 1;
         this.ao = 3;
         this.aJ();
      }
   }

   final void K() {
      for (this.q = -b.j[0][0]; this.q <= b.j[0][1]; this.q++) {
         if (this.a[0] + this.q >= 0) {
            if (this.a[0] + this.q >= this.O) {
               return;
            }

            for (this.r = -b.j[1][0]; this.r <= b.j[1][1]; this.r++) {
               if (this.a[1] + this.r >= 0) {
                  if (this.a[1] + this.r >= this.O) {
                     break;
                  }

                  if (this.b[this.a[0] + this.q][this.a[1] + this.r] != 0) {
                     this.Y = (this.a[0] + this.q + this.a[1] + this.r - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W;
                     this.X = (this.a[0] + this.q - this.a[1] - this.r - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X;
                     if (this.Y < this.l && this.Y + b.B[0] >= 0 && this.X < this.m && this.X + b.B[1] >= 0) {
                        this.a[this.a].drawRegion(this.c[1], 0, b.B[1] * 2, b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
                     }
                  }
               }
            }
         }
      }
   }

   final void L() {
      try {
         this.C();
         this.M();
         this.N();
         this.O();
         this.B();
         if (this.R == 26) {
            switch (this.P) {
               case 0:
               case 1:
               case 2:
                  this.a(this.P, 1, 10);
                  break;
               case 3:
                  for (this.r = 0; this.r < b.j[3]; this.r++) {
                     this.a[this.a]
                        .drawRegion(
                           this.a[this.aI[this.h[154] + this.r]],
                           this.aI[this.h[49] + this.r],
                           this.aI[this.h[50] + this.r],
                           this.aI[this.h[51] + this.r],
                           this.aI[this.h[52] + this.r],
                           0,
                           d.t[this.r],
                           d.u[this.r] - this.aI[this.h[52] + this.r] / 2,
                           20
                        );
                  }

                  this.a[this.a]
                     .drawRegion(
                        this.c[2],
                        this.aI[this.h[71] + 10],
                        this.aI[this.h[72] + 10],
                        this.aI[this.h[73] + 10],
                        this.aI[this.h[74] + 10],
                        0,
                        d.t[this.r],
                        d.u[this.r] - this.aI[this.h[74] + 10] / 2,
                        20
                     );
                  break;
               case 4:
                  for (this.r = 0; this.r < 3; this.r++) {
                     this.a[this.a]
                        .drawRegion(
                           this.e[this.r],
                           this.aI[this.h[98] + this.r],
                           this.aI[this.h[99] + this.r],
                           this.aI[this.h[100] + this.r],
                           this.aI[this.h[101] + this.r],
                           0,
                           63 - this.aI[this.h[100] + this.r],
                           d.z[this.r] - this.aI[this.h[101] + this.r] / 2,
                           20
                        );
                     if (this.e[this.r][0] >= this.e[this.r][1]) {
                        this.q = 0;
                     } else {
                        this.q = 1;
                     }

                     this.a[this.a]
                        .drawRegion(
                           this.c[2],
                           b.f[this.q][0],
                           b.f[this.q][1],
                           b.f[this.q][2],
                           b.f[this.q][3],
                           0,
                           this.f[this.r + 2] + this.d[this.r + 2] + 6,
                           d.z[this.r] - b.f[this.q][3] / 2,
                           20
                        );
                  }
                  break;
               case 5:
                  this.a(3, 5, 0);
            }
         }

         this.P();
      } catch (Exception var2) {
      }
   }

   final void M() {
      if (this.v[this.R] > 0 && this.R != 26 && !this.p) {
         for (this.r = 0; this.r < 2; this.r++) {
            this.q = this.P;
            if (this.w && this.P > 1) {
               this.q--;
            }

            if (this.r == 0) {
               if (this.a[this.R][this.P] == 11) {
                  this.v = 55 - this.aI[this.h[118]];
               } else if (this.a[this.R][this.P] == 12 && this.n) {
                  this.v = 70 - this.aI[this.h[118]];
               } else {
                  this.v = (this.l - this.d[this.q + this.aI[this.h[94] + this.R]]) / 2 - 12 - this.aI[this.h[118]];
               }

               this.v = this.v + this.a[this.a % 4];
               if (this.a[this.R][this.P] != 11 && this.a[this.R][this.P] != 10 && this.a[this.R][this.P] != 112) {
                  this.u = 1;
               } else {
                  this.u = 0;
               }
            }

            if (this.r == 1) {
               if (this.a[this.R][this.P] == 11) {
                  this.v = this.l - 55;
               } else if (this.a[this.R][this.P] == 12 && this.n) {
                  this.v = this.l - 70;
               } else {
                  this.v = (this.l + this.d[this.q + this.aI[this.h[94] + this.R]]) / 2 + 12;
               }

               this.v = this.v - this.a[this.a % 4];
               if (this.a[this.R][this.P] != 11 && this.a[this.R][this.P] != 10 && this.a[this.R][this.P] != 112) {
                  this.u = 0;
               } else {
                  this.u = 1;
               }
            }

            if (this.a[this.R][this.P] == 11) {
               this.w = d.e[this.R][this.aI[this.h[92] + this.R] - 1] - this.aI[this.h[119]] / 2;
            } else if (this.a[this.R][this.P] == 12) {
               this.w = d.p[this.R] + 2;
            } else {
               this.w = d.d[this.R][0] + d.d[this.R][1] * this.P + 2;
            }

            if (this.w) {
               if (this.P < 1) {
                  this.w = this.w + d.d[this.R][1] / 2;
               } else {
                  this.w = this.w - d.d[this.R][1] / 2;
               }
            }

            this.a[this.a]
               .drawRegion(
                  this.d[1],
                  this.aI[this.h[116] + this.u],
                  this.aI[this.h[117] + this.u],
                  this.aI[this.h[118] + this.u],
                  this.aI[this.h[119] + this.u],
                  0,
                  this.v,
                  this.w,
                  20
               );
         }
      }
   }

   final void N() {
      if (!this.p) {
         for (this.r = 0; this.r < this.aI[this.h[92] + this.R]; this.r++) {
            this.l = this.x[this.r];
            this.m = d.e[this.R][this.r];
            this.n = d.h[1];
            this.o = this.y[this.r];
            this.R();
         }
      }

      if (this.R != 2 || this.aA != 29) {
         for (this.r = 0; this.r < this.aI[this.h[93] + this.R] && (!this.p || this.r <= 0); this.r++) {
            this.u = this.aI[this.h[144] + this.aI[this.h[145] + this.R] + this.r];

            for (this.s = 0; this.s < 2; this.s++) {
               for (this.t = 0; this.t < b.u[this.u]; this.t++) {
                  this.a[this.a]
                     .drawRegion(
                        this.d[5], b.t[this.s], b.b[this.u][this.t], 50, b.c[this.u][this.t], 0, d.i[this.s], d.f[this.R][this.r] + b.d[this.u][this.t], 20
                     );
               }
            }
         }
      }

      if (!this.p && ((this.R == 19 || this.R == 21 || this.R == 22) && this.n || this.R == 20)) {
         this.a[this.a]
            .drawRegion(
               this.a[this.aI[this.h[154] + this.U]],
               this.aI[this.h[49] + this.U],
               this.aI[this.h[50] + this.U],
               this.aI[this.h[51] + this.U],
               this.aI[this.h[52] + this.U],
               0,
               (this.l - this.aI[this.h[51] + this.U]) / 2,
               d.q[this.ab - 2] - this.aI[this.h[52] + this.U] / 2,
               20
            );
      }
   }

   final void O() {
      if (this.R == 23) {
         this.a[this.a]
            .drawRegion(
               this.a[this.U],
               this.aI[this.h[1] + this.U * 12],
               this.aI[this.h[19] + this.U * 4],
               this.aI[this.h[2] + this.U * 12],
               this.aI[this.h[20] + this.U * 4],
               0,
               d.x[2] - this.aI[this.h[2] + this.U * 12] / 2,
               d.y[2] - this.aI[this.h[20] + this.U * 4] / 2,
               20
            );
         this.b(this.j, d.x[2], d.y[2] - this.aI[this.h[20] + this.U * 4] / 2);

         for (this.r = 0; this.r < 2; this.r++) {
            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  this.aI[this.h[71] + b.aj[this.r]],
                  this.aI[this.h[72] + b.aj[this.r]],
                  this.aI[this.h[73] + b.aj[this.r]],
                  this.aI[this.h[74] + b.aj[this.r]],
                  0,
                  d.x[this.r] - this.aI[this.h[73] + b.aj[this.r]] - 7,
                  d.y[this.r] - this.aI[this.h[74] + b.aj[this.r]] / 2,
                  20
               );
         }
      }

      if (this.R == 2 || this.R == 5 || this.p || this.R == 3) {
         this.dR();
         this.Q();
      }

      if (this.R == 12 || this.R == 13) {
         this.a[this.a]
            .drawRegion(
               this.c[this.R - 12 + 4],
               0,
               0,
               b.c[this.R - 12][0],
               b.c[this.R - 12][1],
               0,
               (this.l - b.c[this.R - 12][0]) / 2,
               (this.m - b.c[this.R - 12][1]) / 2,
               20
            );
      }
   }

   final void a(int var1, int var2, int var3) {
      this.ab = 8;
      this.A();
      this.a[this.a]
         .drawRegion(
            this.e[var1],
            this.aI[this.h[98] + var1],
            this.aI[this.h[99] + var1],
            this.aI[this.h[100] + var1],
            this.aI[this.h[101] + var1],
            0,
            d.i[0] - this.aI[this.h[100] + var1],
            d.j[0],
            20
         );

      for (this.r = 0; this.r < 2; this.r++) {
         this.a[this.a]
            .drawRegion(
               this.c[3],
               this.aI[this.h[13] + 8 + this.r],
               this.aI[this.h[14] + 8 + this.r],
               this.aI[this.h[15] + 8 + this.r],
               this.aI[this.h[16] + 8 + this.r],
               0,
               d.i[1] - this.aI[this.h[15]] + this.aI[this.h[17] + 8 + this.r],
               d.j[1] + this.aI[this.h[18] + 8 + this.r],
               20
            );
      }

      for (this.q = var2 - 1; this.q >= 0; this.q--) {
         for (this.r = this.c[var1 + this.q][d.k[4]] - 1; this.r > 0; this.r--) {
            this.s = d.k[1] - this.c[var1 + this.q][this.r] * d.k[2] / this.d[var1][0];
            this.t = d.k[1] - this.c[var1 + this.q][this.r - 1] * d.k[2] / this.d[var1][0];
            if (d.k[3] > Math.abs(this.s - this.t)) {
               this.a[this.a].setColor(b.a[var3 + this.q * 2 + 1]);
               this.a[this.a]
                  .drawLine(
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - 1 - this.r) + 1,
                     this.s + 1,
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - this.r),
                     this.t + 1
                  );
               this.a[this.a]
                  .drawLine(
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - 1 - this.r) + 1,
                     this.s - 1,
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - this.r),
                     this.t - 1
                  );
               this.a[this.a].setColor(b.a[var3 + this.q * 2]);
               this.a[this.a]
                  .drawLine(
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - 1 - this.r) + 1,
                     this.s,
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - this.r),
                     this.t
                  );
            } else {
               this.a[this.a].setColor(b.a[var3 + this.q * 2 + 1]);
               this.a[this.a]
                  .drawLine(
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - 1 - this.r) + 2,
                     this.s,
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - this.r) + 1,
                     this.t
                  );
               this.a[this.a]
                  .drawLine(
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - 1 - this.r),
                     this.s,
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - this.r) - 1,
                     this.t
                  );
               this.a[this.a].setColor(b.a[var3 + this.q * 2]);
               this.a[this.a]
                  .drawLine(
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - 1 - this.r) + 1,
                     this.s,
                     d.k[0] + d.k[3] * (this.c[var1 + this.q][d.k[4]] - this.r),
                     this.t
                  );
            }
         }
      }
   }

   final void P() {
      if (this.R == 10) {
         if (this.K == 1) {
            for (this.r = 0; this.r < 3; this.r++) {
               this.a[this.a]
                  .drawRegion(
                     this.e[this.r],
                     this.aI[this.h[98] + this.r],
                     this.aI[this.h[99] + this.r],
                     this.aI[this.h[100] + this.r],
                     this.aI[this.h[101] + this.r],
                     0,
                     this.l / 2 - 7 - this.aI[this.h[100] + this.r],
                     d.d[this.R][0] + (this.r + 1) * d.d[this.R][1] - (this.aI[this.h[101] + this.r] - b.b[0]) / 2,
                     20
                  );
            }
         } else {
            this.dR();
            this.Q();
         }
      }

      if (this.R == 20) {
         this.a[this.a]
            .drawRegion(
               this.c[2],
               this.aI[this.h[71] + 10],
               this.aI[this.h[72] + 10],
               this.aI[this.h[73] + 10],
               this.aI[this.h[74] + 10],
               0,
               d.n[0] - this.aI[this.h[73] + 10],
               d.e[this.R][0] - this.aI[this.h[74] + 10] / 2,
               20
            );
      }

      if (this.R == 25) {
         for (this.r = 0; this.r < this.u.length; this.r++) {
            this.q = (this.l - d.A[3]) / 2 + 10 - this.aI[this.h[73] + b.al[this.h[0][this.r]]];
            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  this.aI[this.h[71] + b.al[this.h[0][this.r]]],
                  this.aI[this.h[72] + b.al[this.h[0][this.r]]],
                  this.aI[this.h[73] + b.al[this.h[0][this.r]]],
                  this.aI[this.h[74] + b.al[this.h[0][this.r]]],
                  0,
                  this.q,
                  d.d[this.R][0] + d.d[this.R][1] * this.r - (this.aI[this.h[74] + b.al[this.h[0][this.r]]] - b.b[0]) / 2,
                  20
               );
            if (this.h[0][this.r] == 0) {
               this.a[this.a]
                  .drawRegion(
                     this.d[1],
                     this.aI[this.h[116] + 1],
                     this.aI[this.h[117] + 1],
                     this.aI[this.h[118] + 1],
                     this.aI[this.h[119] + 1],
                     0,
                     this.q - 4 - this.aI[this.h[118] + 1],
                     d.d[this.R][0] + d.d[this.R][1] * this.r - (this.aI[this.h[119] + 1] - b.b[0]) / 2,
                     20
                  );
            }
         }
      }

      if (this.R == 24) {
         this.a.setClip(d.f[0], d.f[1], d.f[2], d.f[3]);
         this.af();
         this.a.setClip(0, 0, this.l, this.m);
      }

      if (!this.p) {
         this.cE();
         if ((this.R > 17 || this.R == 10 && this.K == 1) && (this.i[this.aI[this.h[171 + this.b] + this.aJ]] || this.a / this.m % 2 == 0)) {
            this.a[this.a].drawRegion(this.d[5], 0, 12, 55, 13, 0, (this.l - 55) / 2, this.m - 2 - 13, 20);
         }
      }
   }

   final void Q() {
      if (this.F > 0) {
         this.a[this.a].drawRegion(this.d[5], b.x[0], b.y[0], b.z[0], b.A[0], 0, d.r[this.aC], d.s[this.aC * 2], 20);
      }

      if (this.F + d.j[this.aC] < this.G) {
         this.a[this.a].drawRegion(this.d[5], b.x[1], b.y[1], b.z[1], b.A[1], 0, d.r[this.aC], d.s[this.aC * 2 + 1], 20);
      }
   }

   final void R() {
      try {
         if (this.l == 0 && this.R == 23) {
            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  this.aI[this.h[71] + 5 - (this.o - 1) / 2],
                  this.aI[this.h[72] + 5 - (this.o - 1) / 2],
                  this.aI[this.h[73] + 5 - (this.o - 1) / 2],
                  this.aI[this.h[74] + 5 - (this.o - 1) / 2],
                  0,
                  87 - this.aI[this.h[73] + 5 - (this.o - 1) / 2],
                  this.m - this.aI[this.h[74] + 5 - (this.o - 1) / 2] / 2,
                  20
               );
         } else {
            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  this.aI[this.h[112] + this.l],
                  this.aI[this.h[113] + this.l],
                  this.aI[this.h[114] + this.l],
                  this.aI[this.h[115] + this.l],
                  0,
                  87 - this.aI[this.h[114] + this.l],
                  this.m - this.aI[this.h[115] + this.l] / 2,
                  20
               );
         }

         this.a[this.a].drawRegion(this.d[4], d.a[0][0][0], d.b[0][0][0], 30, d.d[0][0][0], 0, 90, this.m - d.d[0][0][0] / 2, 20);
         this.a[this.a].drawRegion(this.d[4], d.c[0][0][0] - 30, d.b[0][0][0], 30, d.d[0][0][0], 0, 120, this.m - d.d[0][0][0] / 2 + 1, 20);

         for (this.s = 0; this.s < this.o; this.s++) {
            if (this.l != 2) {
               if (this.l != 3 && this.l != 4) {
                  this.ae = this.o - 1;
               } else {
                  this.ae = 10 - this.o;
               }

               if (this.l == 0 && this.R != 23) {
                  this.ae = 9;
               }

               this.a[this.a]
                  .drawRegion(
                     this.c[2], b.v[this.aI[this.h[91] + this.ae]], b.w[this.aI[this.h[91] + this.ae]], 4, 10, 0, d.h[0] + this.n * this.s, this.m - 5, 20
                  );
            } else {
               this.a[this.a].drawRegion(this.c[2], 63, 11, 8, 8, 0, d.h[0] + this.n * this.s, this.m - 4, 20);
            }
         }
      } catch (Exception var2) {
      }
   }

   final void S() {
      for (this.q = 0; this.q < this.x; this.q++) {
         if (this.q == 0 && this.z == 0) {
            this.r = 0;
         } else {
            this.r = 1;
         }

         this.a[this.a].drawRegion(this.d[1], b.e[this.r], b.f[this.r], b.g[this.r], b.h[this.r], 0, d.a[this.z][this.q], d.b[this.z][this.q], 20);
         this.r = (this.y + this.q) % this.x;
         this.a[this.a]
            .drawRegion(
               this.d[1],
               this.aI[this.h[120] + this.r],
               this.aI[this.h[121] + this.r],
               this.aI[this.h[122] + this.r],
               this.aI[this.h[123] + this.r],
               0,
               d.a[this.z][this.q] + this.aI[this.h[124] + this.r],
               d.b[this.z][this.q] + this.aI[this.h[125] + this.r],
               20
            );
      }

      this.a[this.a]
         .drawRegion(
            this.d[1],
            this.aI[this.h[116] + 2],
            this.aI[this.h[117] + 2],
            this.aI[this.h[118] + 2],
            this.aI[this.h[119] + 2],
            0,
            106,
            25 + this.a[this.a % 4],
            20
         );
      this.E();
   }

   final void T() {
      for (this.q = 0; this.q < this.O; this.q++) {
         for (this.r = 0; this.r < this.O; this.r++) {
            if (this.b[this.q][this.r] > 0 && this.b[this.q][this.r] <= 3) {
               this.s = 0;
            } else if (this.b[this.q][this.r] < 0 && this.b[this.q][this.r] > -15) {
               this.s = 1;
            } else if (this.b[this.q][this.r] > 3) {
               this.s = 2;
            } else if (this.b[this.q][this.r] <= -15) {
               this.s = 3;
            } else if (this.b[this.q][this.r] == 0) {
               this.s = 4;
            }

            this.a[this.a]
               .drawRegion(
                  this.b[4],
                  b.d[0] + b.d[2] * this.s,
                  b.d[1],
                  b.d[2],
                  b.d[3],
                  0,
                  this.n[this.aO] + (this.q + this.r) * (b.d[2] / 2 + 1),
                  this.m / 2 + (this.q - this.r - 1) * (b.d[3] / 2),
                  20
               );
         }
      }

      this.a[this.a].setColor(0);
      this.a[this.a]
         .drawLine(this.n[this.aO] - 1, this.m / 2 - 1, this.n[this.aO] + this.O * (b.d[2] / 2 + 1) - 1, this.m / 2 - (this.O + 1) * (b.d[3] / 2) + 1);
      this.a[this.a].drawLine(this.n[this.aO] - 1, this.m / 2, this.n[this.aO] + this.O * (b.d[2] / 2 + 1) - 1, this.m / 2 + this.O * (b.d[3] / 2));
      this.a[this.a]
         .drawLine(
            this.n[this.aO] + this.O * (b.d[2] + 2) - 2,
            this.m / 2 - 1,
            this.n[this.aO] + this.O * (b.d[2] / 2 + 1) - 1,
            this.m / 2 - (this.O + 1) * (b.d[3] / 2) + 1
         );
      this.a[this.a]
         .drawLine(this.n[this.aO] + this.O * (b.d[2] + 2) - 2, this.m / 2, this.n[this.aO] + this.O * (b.d[2] / 2 + 1), this.m / 2 + this.O * (b.d[3] / 2) - 1);
   }

   final void U() {
      if (this.aX == 0) {
         this.an = this.o[this.aW][this.g[this.aW][37]
            + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1]
            + this.aa];
      } else if (this.aX == 1) {
         this.an = this.aI[this.h[89] + this.aW];
      } else if (this.aX == 3) {
         this.an = (byte)(this.aW + this.av);
      }

      if (this.aX == 3 && this.an == 13) {
         this.au();
      }

      if (this.aX != 3 || this.an == 13) {
         this.V();
      } else if ((this.an & 2) != 0) {
         this.an = 19;
         this.aK();
      } else if ((this.an & 1) != 0) {
         this.an = 20;
         this.aK();
      } else {
         this.a[this.a].drawRegion(this.b[2], b.O[this.an / 4], b.P[this.an / 4], b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
      }

      if (this.aX == 3 && this.an != 2 && this.an != 1) {
         if (this.an != 13) {
            this.au();
         }

         this.av();
      }
   }

   final void V() {
      if (this.an == 0) {
         this.a[this.a].drawRegion(this.b[2], b.O[0], b.P[0], b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
      } else {
         if (this.an > 0) {
            if (this.an > 3 && this.an <= 12) {
               this.an = 0;
               this.aI();
               if (this.an == 7) {
                  this.an = 11;
                  this.aI();
               }

               if (this.an == 8) {
                  this.an = 14;
                  this.aI();
               }

               if (this.an == 5) {
                  this.an = 13;
                  this.aI();
               }

               if (this.an == 6) {
                  this.an = 12;
                  this.aI();
                  return;
               }
            } else {
               if (this.an <= 3) {
                  this.a[this.a].drawRegion(this.c[0], 0, b.B[1] * (this.an - 1), b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
                  return;
               }

               if (this.an == 13) {
                  this.a[this.a].drawRegion(this.b[5], 0, 0, b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
               }
            }
         }
      }
   }

   final void W() {
      this.v = false;
      if (this.b[this.a[0] + this.Z][this.a[1] + this.aa] >= -13 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] <= 3) {
         if (this.aX == 0 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] != 0) {
            if (this.a[0] + this.B <= this.O - 1
               && this.at == 1
               && (
                  this.o[this.aW][this.g[this.aW][37]
                              + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1]
                              + this.aa]
                           != 5
                        && this.o[this.aW][this.g[this.aW][37]
                              + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1]
                              + this.aa]
                           != 7
                     || this.b[this.a[0] + this.Z + 1][this.a[1] + this.aa] != 0
                     || (this.c[this.a[0] + this.Z + 1][this.a[1] + this.aa] & 2) == 0
               )) {
               this.v = true;
            }

            if (this.a[1] > 0
               && this.at == 0
               && (
                  this.o[this.aW][this.g[this.aW][37]
                              + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1]
                              + this.aa]
                           != 6
                        && this.o[this.aW][this.g[this.aW][37]
                              + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1]
                              + this.aa]
                           != 8
                     || this.b[this.a[0] + this.Z][this.a[1] + this.aa - 1] != 0
                     || (this.c[this.a[0] + this.Z][this.a[1] + this.aa - 1] & 1) == 0
               )) {
               this.v = true;
            }

            if (this.o[this.aW][this.g[this.aW][37]
                  + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1]
                  + this.aa]
               == 13) {
               this.aP = 1;
               this.aa();
            }
         } else {
            this.X();
         }
      }

      this.Y();
      if (this.v) {
         this.a[this.a].drawRegion(this.c[1], 0, 0, b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
      } else {
         this.f = false;
         this.a[this.a].drawRegion(this.c[1], 0, b.B[1], b.B[0] - 2, b.B[1], 0, this.Y, this.X, 20);
      }
   }

   final void X() {
      if (this.aX == 1 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] != 0) {
         this.v = true;
         if (this.aW != 26 && this.aW >= 14) {
            if (this.a[0] < this.O - 1) {
               if (this.aI[this.h[163] - 1 - this.au] == 1 && this.b[this.a[0] + 1][this.a[1]] == 0 && (this.c[this.a[0] + 1][this.a[1]] & 2) != 0) {
                  this.v = false;
               }
            } else if (this.aI[this.h[163] - 1 - this.au] == 1 && this.aI[this.h[164] - 1 - this.au] == 0) {
               this.v = false;
            }

            if (this.a[1] > 0) {
               if (this.aI[this.h[164] - 1 - this.au] == 1 && this.b[this.a[0]][this.a[1] - 1] == 0 && (this.c[this.a[0]][this.a[1] - 1] & 1) != 0) {
                  this.v = false;
                  return;
               }
            } else if (this.aI[this.h[164] - 1 - this.au] == 1 && this.aI[this.h[163] - 1 - this.au] == 0) {
               this.v = false;
               return;
            }
         } else if (this.au >= -13 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] < 0) {
            this.v = false;
            return;
         }
      } else if (this.aX == 3) {
         if (this.aW % 4 == 0) {
            this.Z();
            return;
         }

         if (this.aW == 13 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] != 0) {
            this.aP = 2;
            this.aa();
         }
      }
   }

   final void Y() {
      if (this.aX == 0
         && this.aW != 22
         && this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa]
            == 1) {
         this.v = true;
      }

      if (this.aX == 3 && this.b[this.a[0]][this.a[1]] == 0) {
         if (this.aW + this.av == 2 && (this.c[this.a[0]][this.a[1]] & 2) == 0) {
            this.v = true;
            if (this.a[0] > 0) {
               if (this.b[this.a[0] - 1][this.a[1]] <= -15
                  && this.b[this.a[0] - 1][this.a[1]] >= -27
                  && this.aI[this.h[163] - 1 - this.b[this.a[0] - 1][this.a[1]]] == 1) {
                  this.v = false;
               }

               if (this.b[this.a[0] - 1][this.a[1]] == 5 || this.b[this.a[0] - 1][this.a[1]] == 7 || this.b[this.a[0] - 1][this.a[1]] == 0) {
                  this.v = false;
                  return;
               }
            }
         } else if (this.aW + this.av == 1 && (this.c[this.a[0]][this.a[1]] & 1) == 0) {
            this.v = true;
            if (this.a[1] < this.O - 1) {
               if (this.b[this.a[0]][this.a[1] + 1] <= -15
                  && this.b[this.a[0]][this.a[1] + 1] >= -27
                  && this.aI[this.h[164] - 1 - this.b[this.a[0]][this.a[1] + 1]] == 1) {
                  this.v = false;
               }

               if (this.b[this.a[0]][this.a[1] + 1] == 6 || this.b[this.a[0]][this.a[1] + 1] == 8 || this.b[this.a[0]][this.a[1] + 1] == 0) {
                  this.v = false;
               }
            }
         }
      }
   }

   final void Z() {
      if (this.b[this.a[0]][this.a[1]] >= -13 && this.b[this.a[0]][this.a[1]] <= 3) {
         this.v = true;
         if (this.b[this.a[0]][this.a[1]] == 0 && this.aW <= this.c[this.a[0]][this.a[1]]) {
            this.v = false;
         }

         if (this.a[0] < this.O - 1 && this.b[this.a[0] + 1][this.a[1]] == 0 && (this.c[this.a[0] + 1][this.a[1]] & 2) != 0) {
            this.v = false;
         }

         if (this.a[1] > 0 && this.b[this.a[0]][this.a[1] - 1] == 0 && (this.c[this.a[0]][this.a[1] - 1] & 1) != 0) {
            this.v = false;
         }
      }
   }

   final void aa() {
      if (this.b[this.a[0] + this.Z][this.a[1] + this.aa] >= -13
         && this.b[this.a[0] + this.Z][this.a[1] + this.aa] != 0
         && this.b[this.a[0] + this.Z][this.a[1] + this.aa] <= 3) {
         this.v = true;
         this.aV[0] = (byte)(this.a[0] + this.Z);
         this.aV[1] = (byte)(this.a[1] + this.aa);
         this.aR = 0;

         for (this.aQ = 0; this.aQ < 4; this.aQ++) {
            if (this.aV[0] + this.aI[this.h[31] + this.aQ * 2] < this.O
               && this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1] < this.O
               && this.aV[0] + this.aI[this.h[31] + this.aQ * 2] >= 0
               && this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1] >= 0) {
               this.aU[this.aQ] = this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]];
               if ((this.aU[this.aQ] == 7 || this.aU[this.aQ] == 5) && this.aQ == 1
                  || (this.aU[this.aQ] == 8 || this.aU[this.aQ] == 6) && this.aQ == 0
                  || this.aU[this.aQ] == 13) {
                  this.aR++;
               }
            } else {
               this.aU[this.aQ] = 1;
            }
         }

         if (this.aR > this.aP) {
            this.v = false;
            return;
         }

         for (this.aS = 0; this.aS < 4; this.aS++) {
            if (this.aU[this.aS] == 13) {
               this.aV[0] = (byte)(this.a[0] + this.Z + this.aI[this.h[31] + this.aS * 2]);
               this.aV[1] = (byte)(this.a[1] + this.aa + this.aI[this.h[31] + this.aS * 2 + 1]);
               this.aR = 0;

               for (this.aQ = 0; this.aQ < 4; this.aQ++) {
                  if (this.aV[0] + this.aI[this.h[31] + this.aQ * 2] < this.O
                     && this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1] < this.O
                     && this.aV[0] + this.aI[this.h[31] + this.aQ * 2] >= 0
                     && this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1] >= 0
                     && (
                        (
                                 this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 7
                                    || this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 5
                              )
                              && this.aQ == 1
                           || (
                                 this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 8
                                    || this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 6
                              )
                              && this.aQ == 0
                           || this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 13
                     )) {
                     this.aR++;
                  }
               }

               if (this.aR > 1) {
                  this.v = false;
                  return;
               }
            }
         }
      }
   }

   final void ab() {
      this.k = this.k - this.e[b.j[3]];
      this.e = this.e + this.e[b.j[3]];

      for (this.af = 200; this.af < 222; this.af++) {
         if (this.B[this.af] >= 0) {
            this.aT[0] = this.B[this.af];
            this.aT[1] = this.C[this.af];
            this.h = (short)(b.B[0] / 2);
            this.i = 0;
            this.a.delete(0, this.a.length());
            this.a.append("-");
            this.a.append(this.aI[this.h[131] + this.A[this.af] - 8]);
            this.b = this.a.toString();
            this.dM();
         }
      }
   }

   final void ac() {
      for (this.ag = 0; this.ag < 8; this.ag++) {
         for (this.ah = 0; this.ah < d.k[4] - 1; this.ah++) {
            this.c[this.ag][d.k[4] - 1 - this.ah] = this.c[this.ag][d.k[4] - 2 - this.ah];
         }

         this.c[this.ag][0] = this.c[this.ag][d.k[4] + 1];
         if (this.c[this.ag][d.k[4]] < d.k[4]) {
            this.c[this.ag][d.k[4]]++;
         }

         if (this.c[this.ag][0] < 0) {
            this.c[this.ag][0] = 0;
         }
      }

      this.g = this.g + this.c[1][0];
      this.c[3][0] = 0;

      for (this.ag = 0; this.ag < this.O / 5; this.ag++) {
         for (this.ah = 0; this.ah < this.O / 5; this.ah++) {
            this.c[3][0] = this.c[3][0] + this.a[this.ag][this.ah];
         }
      }

      this.c[3][0] = this.c[3][0] / 10;
      this.c[3][0] = this.c[3][0] + this.aD[24] + this.ai * 2 + this.ak + this.a;
      this.c[3][0] = this.c[3][0] * this.c[1][0];
      this.c[3][0] = this.c[3][0] / 9;

      for (this.ag = 4; this.ag < 8; this.ag++) {
         if (this.b % 3 == 0) {
            if (this.c[this.ag][1] < this.a[this.M * 7 + this.aX[this.ag - 4] * 2 + 1]) {
               this.aW[this.ag - 4] = (byte)((this.a.nextInt() & 65535) % 4);
            } else if (this.c[this.ag][1] > this.a[this.M * 7 + this.aX[this.ag - 4] * 2 + 2]) {
               this.aW[this.ag - 4] = (byte)((this.a.nextInt() & 65535) % 4 + 4);
            } else {
               this.aW[this.ag - 4] = (byte)((this.a.nextInt() & 65535) % 8);
            }
         }

         if ((this.a.nextInt() & 65535) % 5 == 0) {
            this.aX[this.ag - 4] = (byte)((this.a.nextInt() & 65535) % 3);
         }

         this.ah = (this.a.nextInt() & 65535) % this.a[this.M * 7];
         this.ai = this.a[this.M * 7] / 2;
         this.c[this.ag][0] = this.c[this.ag][1] + this.aI[this.h[176] + this.aW[this.ag - 4] * 3 + this.b % 3] + this.ah - this.ai;
         if (this.c[this.ag][0] < 0) {
            this.c[this.ag][0] = 0;
         }
      }
   }

   final void ad() {
      for (this.ag = 0; this.ag < 3; this.ag++) {
         switch (this.ag) {
            case 0:
               this.c[this.ag][d.k[4] + 1] = this.k;
               break;
            case 1:
               if (this.a <= 0) {
                  this.c[this.ag][d.k[4] + 1] = 0;
                  break;
               }

               this.c[this.ag][d.k[4] + 1] = 0;
               this.ah = 0;

               for (; this.ah < 200; this.ah++) {
                  if (this.B[this.ah] >= 0) {
                     this.c[this.ag][d.k[4] + 1] = this.c[this.ag][d.k[4] + 1] + this.P[this.ah];
                  }
               }

               this.c[this.ag][d.k[4] + 1] = this.c[this.ag][d.k[4] + 1] / this.a;
               this.c[this.ag][d.k[4] + 1] = this.c[this.ag][d.k[4] + 1] / 10;
               break;
            case 2:
               this.c[this.ag][d.k[4] + 1] = this.a;
         }
      }

      for (this.ag = 0; this.ag < 3; this.ag++) {
         this.e[this.ag][0] = this.c[this.ag][d.k[4] + 1];
      }
   }

   final void ae() {
      this.a[this.a]
         .drawRegion(
            this.b[2],
            this.aI[this.h[106] + this.d],
            this.aI[this.h[107] + this.d],
            this.aI[this.h[108] + this.d],
            this.aI[this.h[109] + this.d],
            0,
            this.Y + this.aI[this.h[110] + this.an] - this.aI[this.h[108] + this.d] / 2,
            this.X + this.aI[this.h[111] + this.an] - this.aI[this.h[109] + this.d] / 2,
            20
         );
   }

   final void af() {
      try {
         if (this.aX != 2) {
            this.aL[0] = 0;
            this.aL[1] = 0;
            this.aM[0] = 1;
            this.aM[1] = 1;
            if (this.aX == 0) {
               this.ar = this.aW;

               for (this.aM[0] = 0; this.aM[0] < this.o[this.ar][this.g[this.ar][0]]; this.aM[0]++) {
                  this.aM[1] = 0;

                  while (
                     this.aM[1] < this.o[this.ar][this.g[this.ar][0] + 1]
                        && this.o[this.ar][this.g[this.ar][37]
                              + (this.at * this.o[this.ar][this.g[this.ar][0]] + this.aM[0]) * this.o[this.ar][this.g[this.ar][0] + 1]
                              + this.aM[1]]
                           != 10
                  ) {
                     this.aM[1]++;
                  }

                  if (this.aM[1] < this.o[this.ar][this.g[this.ar][0] + 1]) {
                     break;
                  }
               }
            }

            this.f = true;
            this.ag();
            this.ah();
         } else {
            this.aj();
            if (this.f && this.b == 0) {
               this.a[this.a].drawRegion(this.c[2], 52, 32, 7, 7, 0, this.x + b.k[this.d % 3] + this.aI[this.h[51] + this.C], this.y + b.l[this.d % 3], 20);
            }
         }
      } catch (Exception var2) {
      }
   }

   final void ag() {
      for (this.X = this.y; this.X <= this.y + this.A - b.B[1]; this.X = this.X + b.B[1] / 2) {
         if ((this.X - this.y) % b.B[1] == 0) {
            this.Y = this.x;
         } else {
            this.Y = this.x + b.B[0] / 2;
         }

         for (; this.Y <= this.x + this.z - b.B[0]; this.Y = this.Y + b.B[0]) {
            this.Z = ((this.X - this.y) / (b.B[1] / 2) + (this.Y - this.x) / (b.B[0] / 2)) / 2 + this.b[0];
            this.aa = ((this.Y - this.x) / (b.B[0] / 2) - (this.X - this.y) / (b.B[1] / 2)) / 2 + this.b[1];
            if ((this.j != 1 || this.b != 0 || this.Z >= b.a[this.at][this.j][0] && this.aa >= b.b[this.at][this.j][0])
               && this.Z >= 0
               && this.aa >= 0
               && this.Z < this.B
               && this.aa < this.C) {
               if (this.g) {
                  if (this.Z == 0) {
                     this.an = 0;
                     this.ae();
                  }

                  if (this.Z == this.B - 1) {
                     this.an = 1;
                     this.ae();
                  }

                  if (this.aa == 0) {
                     this.an = 2;
                     this.ae();
                  }

                  if (this.aa == this.C - 1) {
                     this.an = 3;
                     this.ae();
                  }
               }

               if (this.b == 0 && !this.g) {
                  this.W();
               } else {
                  this.U();
               }
            }
         }
      }
   }

   final void ah() {
      if ((this.b != 0 || this.d / this.m % 2 == 0) && (this.b == 0 || this.aX != 3)) {
         for (this.X = this.y; this.X <= this.y + this.A - b.B[1]; this.X = this.X + b.B[1] / 2) {
            if ((this.X - this.y) % b.B[1] == 0) {
               this.Y = this.x;
            } else {
               this.Y = this.x + b.B[0] / 2;
            }

            for (; this.Y <= this.x + this.z - b.B[0]; this.Y = this.Y + b.B[0]) {
               this.Z = ((this.X - this.y) / (b.B[1] / 2) + (this.Y - this.x) / (b.B[0] / 2)) / 2 + this.b[0];
               this.aa = ((this.Y - this.x) / (b.B[0] / 2) - (this.X - this.y) / (b.B[1] / 2)) / 2 + this.b[1];
               if ((this.j != 1 || this.b != 0 || this.Z >= b.a[this.at][this.j][0] && this.aa >= b.b[this.at][this.j][0])
                  && this.Z >= 0
                  && this.aa >= 0
                  && this.Z < this.B
                  && this.aa < this.C) {
                  if (this.aX < 2) {
                     if (this.aX == 0) {
                        this.an = this.o[this.aW][this.g[this.aW][37]
                           + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1]
                           + this.aa];
                     } else if (this.b != 0) {
                        this.an = (byte)(-1 - this.aW);
                     } else {
                        this.an = this.au;
                     }

                     if (this.an > 3) {
                        this.ai();
                     } else {
                        if (this.aW == 26) {
                           this.an = b.i[this.Z][this.aa];
                        }

                        if (this.an < 0 && this.an >= -27) {
                           this.aq = 0;
                           if (this.b != 0) {
                              this.r = true;
                           } else {
                              this.r = false;
                           }

                           if (this.b != 0) {
                              this.s = false;
                           } else {
                              this.s = true;
                           }

                           this.aH();
                        }
                     }
                  } else {
                     this.U();
                  }
               }
            }
         }
      }
   }

   final void ai() {
      this.as = 0;
      this.am = this.o[this.ar][this.g[this.ar][38]
         + (this.at * this.o[this.ar][this.g[this.ar][0]] + this.Z) * this.o[this.ar][this.g[this.ar][0] + 1]
         + this.aa];
      this.a(true);
      if (this.an == 10) {
         this.aD();
         if (this.o[this.ar][this.g[this.ar][4] + 3] == 1 && this.b != 0) {
            for (this.q = 0; this.q < b.am[2]; this.q++) {
               this.a[this.a]
                  .drawRegion(
                     this.d[1],
                     this.aI[this.h[165] + b.an[2] + this.q],
                     this.aI[this.h[166] + b.an[2] + this.q],
                     this.aI[this.h[167] + b.an[2] + this.q],
                     this.aI[this.h[168] + b.an[2] + this.q],
                     0,
                     d.a[0][3][0] + b.o[0] + this.aI[this.h[169] + b.an[2] + this.q],
                     d.b[0][0][0] + b.o[1] + this.aI[this.h[170] + b.an[2] + this.q],
                     20
                  );
            }
         }
      }

      if (this.an == 9 || this.an == 11 || this.an == 12) {
         this.aD();
      }

      if (this.an == 11) {
         this.ao = 1;
      } else {
         this.ao = 0;
      }

      if (this.an == 12) {
         this.ap = 1;
      } else {
         this.ap = 0;
      }

      this.b(true);
   }

   final void aj() {
      if (this.b == 0) {
         this.s = this.y;
      } else {
         this.s = 176 - this.aI[this.h[52] + this.C] / 2;
      }

      this.a[this.a]
         .drawRegion(
            this.a[this.aW],
            this.aI[this.h[49] + this.C],
            this.aI[this.h[50] + this.C],
            this.aI[this.h[51] + this.C],
            this.aI[this.h[52] + this.C],
            0,
            this.x,
            this.s,
            20
         );
      this.f = false;
      switch (this.C) {
         case 0:
         case 1:
            if (this.b[this.a[0]][this.a[1]] == 0) {
               this.f = true;
               return;
            }
            break;
         case 2:
            if (this.b[this.a[0]][this.a[1]] > 3 && this.Z[this.c[this.a[0]][this.a[1]]] == 23 && !this.a[this.c[this.a[0]][this.a[1]]]) {
               this.f = true;
               return;
            }
            break;
         case 3:
         case 4:
         case 5:
            if (this.b[this.a[0]][this.a[1]] < 0 && this.aI[this.h[56] + -1 - this.b[this.a[0]][this.a[1]]] == this.C && !this.d[this.c[this.a[0]][this.a[1]]]) {
               this.f = true;
            }
      }
   }

   final void ak() {
      if (!this.p) {
         for (this.aj = 0; this.aj < this.aI[this.h[132] + this.aX * 2]; this.aj++) {
            this.a[this.a]
               .drawRegion(
                  this.e[this.aj],
                  this.aI[this.h[98] + this.aj],
                  this.aI[this.h[99] + this.aj],
                  this.aI[this.h[100] + this.aj],
                  this.aI[this.h[101] + this.aj],
                  0,
                  d.n[this.aI[this.h[132] + this.aX * 2 + 1] + this.aj * 2] - this.aI[this.h[100] + this.aj],
                  105,
                  20
               );
         }

         if (this.aX < 2) {
            this.a.setClip(d.f[0], d.f[1], d.f[2], d.f[3]);
         }

         this.af();
         if (this.aX < 2) {
            this.a.setClip(0, 0, this.l, this.m);
         }
      } else {
         this.dR();
      }

      this.B();
      this.C();
      if (!this.p) {
         this.cE();
         if (this.i[this.aI[this.h[171 + this.b] + this.aJ]] || this.a / this.m % 2 == 0) {
            this.a[this.a].drawRegion(this.d[5], 0, 12, 55, 13, 0, (this.l - 55) / 2, this.m - 2 - 13, 20);
         }
      }
   }

   final void al() {
      for (this.X = -(b.B[1] / 2) - 1 * b.B[1] + this.X; this.X < this.m + 4 * b.B[1]; this.X = this.X + b.B[1] / 2) {
         if ((this.X - this.X) % b.B[1] == 0) {
            this.Y = -1 * b.B[0] + this.W;
         } else {
            this.Y = -(b.B[0] / 2) - 1 * b.B[0] + this.W;
         }

         for (; this.Y < this.l + 1 * b.B[0]; this.Y = this.Y + b.B[0]) {
            this.Z = ((this.X - this.X) / (b.B[1] / 2) + (this.Y - this.W) / (b.B[0] / 2)) / 2 + this.f[0][0];
            this.aa = ((this.Y - this.W) / (b.B[0] / 2) - (this.X - this.X) / (b.B[1] / 2)) / 2 + this.f[0][1];
            if (this.Z == this.ab - 1 && this.aa == -1) {
               this.as();
            }

            if (this.Z == this.ab + 1 && this.aa == -1) {
               this.at();
            }

            if (this.Z >= 0 && this.aa >= 0 && this.Z < this.O && this.aa < this.O) {
               this.an = this.b[this.Z][this.aa];
               if (this.an != 0 && this.an <= 3) {
                  this.an();
               } else {
                  this.am();
                  this.ap();
                  this.ao();
               }
            }
         }
      }
   }

   final void am() {
      if (this.an != 0 && this.an <= 12) {
         this.ar = this.Z[this.c[this.Z][this.aa]];
         this.as = this.ab[this.c[this.Z][this.aa]];
         this.aL[0] = this.l[0][this.c[this.Z][this.aa]];
         this.aL[1] = this.l[1][this.c[this.Z][this.aa]];
         this.aM[0] = this.m[0][this.c[this.Z][this.aa]];
         this.aM[1] = this.m[1][this.c[this.Z][this.aa]];
         this.ao = 0;
         if (this.an == 11
            && (this.ag[this.c[this.Z][this.aa]] != 1 && this.ag[this.c[this.Z][this.aa]] != 0 || this.aa != this.ae[this.c[this.Z][this.aa]])
            && (this.ag[this.c[this.Z][this.aa]] != 2 || this.aa != this.n[1][this.c[this.Z][this.aa]])) {
            this.ao = 1;
         }

         this.ap = 0;
         if (this.an == 12
            && (this.ag[this.c[this.Z][this.aa]] != 1 && this.ag[this.c[this.Z][this.aa]] != 0 || this.Z != this.ae[this.c[this.Z][this.aa]])
            && (this.ag[this.c[this.Z][this.aa]] != 2 || this.Z != this.n[0][this.c[this.Z][this.aa]])) {
            this.ap = 1;
         }

         if (this.ar != 22) {
            this.am = this.o[this.ar][this.g[this.ar][38]
               + (this.aa[this.c[this.Z][this.aa]] * this.o[this.ar][this.g[this.ar][0]] + this.Z - this.l[0][this.c[this.Z][this.aa]])
                  * this.o[this.ar][this.g[this.ar][0] + 1]
               + this.aa
               - this.l[1][this.c[this.Z][this.aa]]];
            return;
         }

         if (this.an == 6 || this.an == 8) {
            this.am = 74;
         }

         if (this.an == 5 || this.an == 7) {
            this.am = -123;
         }
      }
   }

   final void an() {
      if (this.an < 0 && this.an >= -27) {
         if (this.an <= -15) {
            this.aq = this.ak[this.c[this.Z][this.aa]];
            this.r = this.d[this.c[this.Z][this.aa]];
            this.s = this.e[this.c[this.Z][this.aa]];
         }

         this.aH();
         if (this.an <= -15
            && this.e / this.m % 2 != 0
            && (this.f[this.c[this.Z][this.aa]] || this.aI[this.h[56] + -1 - this.an] >= 0 && !this.d[this.c[this.Z][this.aa]])) {
            if (this.aI[this.h[163] - 1 - this.an] == 1) {
               this.q = 1;
            } else {
               this.q = 0;
            }

            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  this.aI[this.h[165] + b.an[this.q]],
                  this.aI[this.h[166] + b.an[this.q]],
                  this.aI[this.h[167] + b.an[this.q]],
                  this.aI[this.h[168] + b.an[this.q]],
                  0,
                  this.Y + this.aI[this.h[169] + b.an[this.q]],
                  this.X + this.aI[this.h[170] + b.an[this.q]],
                  20
               );
         }

         if (this.an <= -15
            && this.g == 0
            && this.e == 0
            && this.ak[this.c[this.Z][this.aa]] >= 0
            && this.aI[this.h[56] + -1 - this.an] >= 0
            && this.d[this.c[this.Z][this.aa]]) {
            this.aT[0] = (byte)this.Z;
            this.aT[1] = (byte)this.aa;
            this.h = (short)(b.B[0] / 2);
            this.i = 0;
            this.a.delete(0, this.a.length());
            this.a.append("-");
            this.a.append(this.aI[this.h[131] + this.aI[this.h[56] + -1 - this.an]]);
            this.b = this.a.toString();
            this.dM();
         }
      }
   }

   final void ao() {
      if (this.an == 9 || this.an == 11 || this.an == 12) {
         this.aD();
      }

      this.aL();
      if (this.X < this.m && this.Y + b.B[0] > 0 && this.Y < this.l) {
         if (this.an == 0) {
            this.aC();
         } else if (this.an <= 12) {
            this.b(false);
            if ((this.an == 5 || this.an == 6) && this.e / this.m % 2 != 0) {
               if (!this.a[this.c[this.Z][this.aa]]) {
                  if (this.an == 5) {
                     this.q = 1;
                  }

                  if (this.an == 6) {
                     this.q = 0;
                  }

                  this.a[this.a]
                     .drawRegion(
                        this.c[2],
                        this.aI[this.h[165] + b.an[this.q]],
                        this.aI[this.h[166] + b.an[this.q]],
                        this.aI[this.h[167] + b.an[this.q]],
                        this.aI[this.h[168] + b.an[this.q]],
                        0,
                        this.Y + this.aI[this.h[169] + b.an[this.q]],
                        this.X + this.aI[this.h[170] + b.an[this.q]],
                        20
                     );
               } else if (!this.c[this.c[this.Z][this.aa]]) {
                  for (this.r = 0; this.r < b.am[3]; this.r++) {
                     this.a[this.a]
                        .drawRegion(
                           this.d[1],
                           this.aI[this.h[165] + b.an[3] + this.r],
                           this.aI[this.h[166] + b.an[3] + this.r],
                           this.aI[this.h[167] + b.an[3] + this.r],
                           this.aI[this.h[168] + b.an[3] + this.r],
                           0,
                           this.Y + this.aI[this.h[169] + b.an[3] + this.r],
                           this.X + this.aI[this.h[170] + b.an[3] + this.r],
                           20
                        );
                  }
               }
            }
         }

         this.aB();
      }
   }

   final void ap() {
      if (this.X < this.m && this.Y + b.B[0] > 0 && this.Y < this.l) {
         if (this.an == 0) {
            this.ax();
         } else if (this.an <= 12) {
            this.a(false);
         }

         this.az();
      }

      if (this.an == 10) {
         this.aD();
         if (!this.b[this.c[this.Z][this.aa]] && this.e / this.m % 2 == 0) {
            for (this.q = 0; this.q < b.am[2]; this.q++) {
               this.a[this.a]
                  .drawRegion(
                     this.d[1],
                     this.aI[this.h[165] + b.an[2] + this.q],
                     this.aI[this.h[166] + b.an[2] + this.q],
                     this.aI[this.h[167] + b.an[2] + this.q],
                     this.aI[this.h[168] + b.an[2] + this.q],
                     0,
                     this.Y + this.aI[this.h[169] + b.an[2] + this.q],
                     this.X + this.aI[this.h[170] + b.an[2] + this.q],
                     20
                  );
            }
         }

         if (this.ah[this.c[this.Z][this.aa]] < 10 && this.e / this.m % 2 == 1) {
            for (this.q = 0; this.q < b.am[4]; this.q++) {
               this.a[this.a]
                  .drawRegion(
                     this.c[2],
                     this.aI[this.h[165] + b.an[4] + this.q],
                     this.aI[this.h[166] + b.an[4] + this.q],
                     this.aI[this.h[167] + b.an[4] + this.q],
                     this.aI[this.h[168] + b.an[4] + this.q],
                     0,
                     this.Y + this.aI[this.h[169] + b.an[4] + this.q],
                     this.X + this.aI[this.h[170] + b.an[4] + this.q],
                     20
                  );
            }
         }
      }
   }

   final void aq() {
      if (this.b == 0 && !this.e && !this.h) {
         this.a[this.a]
            .drawRegion(
               this.d[0],
               this.aI[this.h[126] + 0],
               this.aI[this.h[127] + 0],
               this.aI[this.h[128] + 0],
               this.aI[this.h[129] + 0],
               0,
               0,
               this.m - this.aI[this.h[129] + 0],
               20
            );
         this.a[this.a]
            .drawRegion(
               this.d[0],
               this.aI[this.h[126] + 1],
               this.aI[this.h[127] + 1],
               this.aI[this.h[128] + 1],
               this.aI[this.h[129] + 1],
               0,
               this.l - this.aI[this.h[128] + 1],
               this.m - this.aI[this.h[129] + 1],
               20
            );
      } else {
         if (this.b == 0 && this.e) {
            if (this.aX != 2 && this.B != 4 && (this.aX != 1 || this.aI[this.h[162] - 1 - this.au] != 0)) {
               this.a[this.a]
                  .drawRegion(
                     this.d[0],
                     this.aI[this.h[126] + 4],
                     this.aI[this.h[127] + 4],
                     this.aI[this.h[128] + 4],
                     this.aI[this.h[129] + 4],
                     0,
                     0,
                     this.m - this.aI[this.h[129] + 4],
                     20
                  );
            }
         } else if ((this.b != 3 || this.aI[this.h[143] + this.R] != 2 && (this.R != 5 || this.aA != 40) || this.d && this.R == 26) && !this.p && this.b != 4) {
            this.a[this.a]
               .drawRegion(
                  this.d[0],
                  this.aI[this.h[126] + 2],
                  this.aI[this.h[127] + 2],
                  this.aI[this.h[128] + 2],
                  this.aI[this.h[129] + 2],
                  0,
                  0,
                  this.m - this.aI[this.h[129] + 2],
                  20
               );
         }

         if ((
               this.b != 3
                  || this.aI[this.h[143] + this.R] != 0 && (this.R != 5 || this.aA != 18 && this.aA != 19 && this.aA != 38 && this.aA != 39)
                  || this.R == 0 && this.c[this.v[0] - 1] == 107
            )
            && (!this.d || this.R != 26)
            && this.b != 5) {
            this.a[this.a]
               .drawRegion(
                  this.d[0],
                  this.aI[this.h[126] + 3],
                  this.aI[this.h[127] + 3],
                  this.aI[this.h[128] + 3],
                  this.aI[this.h[129] + 3],
                  0,
                  this.l - this.aI[this.h[128] + 3],
                  this.m - this.aI[this.h[129] + 3],
                  20
               );
         }
      }
   }

   final void ar() {
      for (this.q = 0; this.q < 2; this.q++) {
         this.a[this.a]
            .drawRegion(
               this.c[3],
               this.aI[this.h[13] + this.g * 2 + this.q],
               this.aI[this.h[14] + this.g * 2 + this.q],
               this.aI[this.h[15] + this.g * 2 + this.q],
               this.aI[this.h[16] + this.g * 2 + this.q],
               0,
               this.l - this.aI[this.h[15]] - 2 + this.aI[this.h[17] + this.g * 2 + this.q],
               2 + this.aI[this.h[18] + this.g * 2 + this.q],
               20
            );
      }
   }

   final void as() {
      for (this.u = 0; this.u < b.Q[0]; this.u++) {
         this.a[this.a].drawRegion(this.b[6], 0, 112, 15, 12, 0, this.Y + this.aI[this.h[37] + this.u], this.X + this.aI[this.h[38] + this.u], 20);
      }
   }

   final void at() {
      for (this.u = 0; this.u < b.Q[1]; this.u++) {
         this.a[this.a].drawRegion(this.b[6], 0, 112, 15, 12, 0, this.Y + this.aI[this.h[37] + 3 + this.u], this.X + this.aI[this.h[38] + 3 + this.u], 20);
      }

      for (this.u = 0; this.u < b.V.length; this.u++) {
         this.a[this.a].drawRegion(this.b[2], b.R[this.u], b.S[this.u], b.T[this.u], b.U[this.u], 0, this.Y + b.V[this.u], this.X + b.W[this.u], 20);
      }
   }

   final void au() {
      if (this.an != 13) {
         this.an = 22;
         this.aK();
         this.an = 21;
         this.aK();
      } else {
         if (this.an == 13) {
            this.an = 2;
            this.aK();
            this.an = 1;
            this.aK();
         }
      }
   }

   final void av() {
      if (this.an != 13) {
         this.an = 23;
         this.aK();
         this.an = 24;
         this.aK();
      } else {
         if (this.an == 13) {
            this.an = 18;
            this.aK();
            this.an = 17;
            this.aK();
         }
      }
   }

   final void aw() {
      this.an = 21;
      this.aK();
      this.an = 24;
      this.aK();
   }

   final void ax() {
      if (this.aa == this.O - 1) {
         this.v = true;
      } else if (this.b[this.Z][this.aa + 1] != 0
         && this.b[this.Z][this.aa + 1] != 6
         && this.b[this.Z][this.aa + 1] != 8
         && this.b[this.Z][this.aa + 1] != -17
         && this.b[this.Z][this.aa + 1] != -19
         && this.b[this.Z][this.aa + 1] != -22
         && this.b[this.Z][this.aa + 1] != -20
         && this.b[this.Z][this.aa + 1] != -23
         && this.b[this.Z][this.aa + 1] != -24
         && this.b[this.Z][this.aa + 1] != -25
         && this.b[this.Z][this.aa + 1] != -26) {
         this.v = true;
      } else {
         this.v = false;
      }

      if (this.v) {
         this.an = 22;
         this.aK();
      }

      if (this.Z == 0) {
         this.v = true;
      } else if (this.b[this.Z - 1][this.aa] != 0
         && this.b[this.Z - 1][this.aa] != 5
         && this.b[this.Z - 1][this.aa] != 7
         && this.b[this.Z - 1][this.aa] != -15
         && this.b[this.Z - 1][this.aa] != -16
         && this.b[this.Z - 1][this.aa] != -18
         && this.b[this.Z - 1][this.aa] != -21
         && this.b[this.Z - 1][this.aa] != -20
         && this.b[this.Z - 1][this.aa] != -24
         && this.b[this.Z - 1][this.aa] != -25
         && this.b[this.Z - 1][this.aa] != -26) {
         this.v = true;
      } else {
         this.v = false;
      }

      if (this.v) {
         this.an = 21;
         this.aK();
      }
   }

   final void a(boolean var1) {
      if ((this.am & 64) != 0) {
         this.an = 2;
         this.aK();
      }

      if ((this.am & 4) != 0) {
         this.an = 8;
         this.aK();
      }

      if ((this.am & 128) != 0) {
         this.an = 1;
         this.aK();
      }

      if ((this.am & 8) != 0) {
         this.an = 7;
         this.aK();
      }

      if ((this.am & 74) == 74) {
         this.an = 15;
         this.aK();
      }

      if ((this.am & 133) == 133) {
         this.an = 16;
         this.aK();
      }

      this.ay();
   }

   final void ay() {
      if (this.an == 9 && this.ar == 23) {
         for (this.u = 0; this.u < 1; this.u++) {
            this.a[this.a]
               .drawRegion(
                  this.b[this.aI[this.h[88] + 3 + this.u]],
                  this.aI[this.h[80] + 3 + this.u],
                  this.aI[this.h[81] + 3 + this.u],
                  this.aI[this.h[82] + 3 + this.u],
                  this.aI[this.h[83] + 3 + this.u],
                  0,
                  this.Y + this.aI[this.h[84] + 3 + this.u],
                  this.X + this.aI[this.h[85] + 3 + this.u],
                  20
               );
         }
      }

      if (this.an == 4 && this.ar == 23) {
         for (this.u = 0; this.u < 1; this.u++) {
            this.a[this.a]
               .drawRegion(
                  this.b[this.aI[this.h[88] + 6 + this.u]],
                  this.aI[this.h[80] + 6 + this.u],
                  this.aI[this.h[81] + 6 + this.u],
                  this.aI[this.h[82] + 6 + this.u],
                  this.aI[this.h[83] + 6 + this.u],
                  0,
                  this.Y + this.aI[this.h[84] + 6 + this.u + 3 * (this.Z - this.aL[0])],
                  this.X + this.aI[this.h[85] + 6 + this.u + 3 * (this.Z - this.aL[0])],
                  20
               );
         }

         if (this.b == 0) {
            for (this.u = 0; this.u < 2; this.u++) {
               this.v = this.c[this.Z][this.aa];
               if (this.v < 0) {
                  return;
               }

               for (this.c = 0; this.v >= 0; this.c++) {
                  if (this.H[this.v] == this.u && this.W[this.v] == 12) {
                     this.a[this.a]
                        .drawRegion(
                           this.a[this.A[this.v]],
                           this.aI[this.h[21] + this.A[this.v] * 2 + 1],
                           this.aI[this.h[42] + this.A[this.v]],
                           this.aI[this.h[43] + this.A[this.v]],
                           this.aI[this.h[44] + this.A[this.v]],
                           0,
                           this.Y + this.aI[this.h[27] + (this.Z - this.aL[0]) * 4 + this.u] - this.aI[this.h[43] + this.A[this.v]] / 2,
                           this.X + this.aI[this.h[28] + (this.Z - this.aL[0]) * 4 + this.u] - this.aI[this.h[44] + this.A[this.v]],
                           20
                        );
                     break;
                  }

                  this.v = this.d[this.v];
               }
            }
         }
      }
   }

   final void az() {
      if (this.an == 13) {
         this.v = false;
         if (this.aa == this.O - 1) {
            this.v = true;
         } else if (this.b[this.Z][this.aa + 1] != 13) {
            this.v = true;
         }

         if (this.v) {
            this.an = 2;
            this.aK();
         }

         this.aA();
      }

      if (this.an == 0 && this.c[this.Z][this.aa] > 0) {
         if ((this.c[this.Z][this.aa] & 2) != 0) {
            this.an = 19;
            this.aK();
         }

         if ((this.c[this.Z][this.aa] & 1) != 0) {
            this.an = 20;
            this.aK();
         }
      }
   }

   final void aA() {
      this.v = false;
      if (this.Z == 0) {
         this.v = true;
      } else if (this.b[this.Z - 1][this.aa] != 13) {
         this.v = true;
      }

      if (this.v) {
         this.an = 1;
         this.aK();
      }

      this.a[this.a].drawRegion(this.b[5], 0, (b.B[1] - 1) * this.aj, b.B[0] - 2, b.B[1], 0, this.Y + 0, this.X + -1, 20);
      if (this.aa > 0 && this.c[this.Z][this.aa] == -1 && this.b[this.Z][this.aa - 1] == 6) {
         this.a[this.a]
            .drawRegion(
               this.b[1],
               40,
               0,
               12,
               9,
               0,
               this.Y + (this.o[22][this.g[22][21] + 33 + this.as[22]] + this.o[22][this.g[22][22] + 33 + this.as[22]]) / b.Y[0] + -6,
               this.X + b.B[1] / 2 + (this.o[22][this.g[22][21] + 33 + this.as[22]] - this.o[22][this.g[22][22] + 33 + this.as[22]]) / b.Y[1] + -11,
               20
            );
      }

      if (this.Z < this.O - 1 && this.c[this.Z][this.aa] == -1 && this.b[this.Z + 1][this.aa] == 5) {
         this.a[this.a]
            .drawRegion(
               this.b[1],
               40,
               0,
               12,
               9,
               0,
               this.Y + (this.o[22][this.g[22][21] + 22 + this.as[22]] + this.o[22][this.g[22][22] + 22 + this.as[22]]) / b.Y[0] + -6,
               this.X + b.B[1] / 2 + (this.o[22][this.g[22][21] + 22 + this.as[22]] - this.o[22][this.g[22][22] + 22 + this.as[22]]) / b.Y[1] + -11,
               20
            );
      }
   }

   final void aB() {
      if (this.an == 13) {
         this.v = false;
         if (this.aa == 0) {
            this.v = true;
         } else if (this.b[this.Z][this.aa - 1] != 13) {
            this.v = true;
         }

         if (this.v) {
            this.an = 18;
            this.aK();
         }

         this.v = false;
         if (this.Z == this.O - 1) {
            this.v = true;
         } else if (this.b[this.Z + 1][this.aa] != 13) {
            this.v = true;
         }

         if (this.v) {
            this.an = 17;
            this.aK();
         }
      }
   }

   final void aC() {
      if (this.aa != 0 || this.Z != this.ab) {
         if (this.aa == 0) {
            this.v = true;
         } else if (this.b[this.Z][this.aa - 1] != 0) {
            this.v = true;
         } else {
            this.v = false;
         }

         if (this.v) {
            this.an = 23;
            this.aK();
         }
      }

      if (this.Z == this.O - 1) {
         this.v = true;
      } else if (this.b[this.Z + 1][this.aa] != 0) {
         this.v = true;
      } else {
         this.v = false;
      }

      if (this.v) {
         this.an = 24;
         this.aK();
      }
   }

   final void b(boolean var1) {
      if (this.an == 4 && this.ar == 23) {
         for (this.u = 0; this.u < 2; this.u++) {
            this.a[this.a]
               .drawRegion(
                  this.b[this.aI[this.h[88] + 4 + this.u]],
                  this.aI[this.h[80] + 4 + this.u],
                  this.aI[this.h[81] + 4 + this.u],
                  this.aI[this.h[82] + 4 + this.u],
                  this.aI[this.h[83] + 4 + this.u],
                  0,
                  this.Y + this.aI[this.h[84] + 4 + this.u + 3 * (this.Z - this.aL[0])],
                  this.X + this.aI[this.h[85] + 4 + this.u + 3 * (this.Z - this.aL[0])],
                  20
               );
         }

         if (this.b == 0) {
            for (this.u = 2; this.u < 4; this.u++) {
               this.v = this.c[this.Z][this.aa];
               if (this.v < 0) {
                  break;
               }

               for (this.c = 0; this.v >= 0; this.c++) {
                  if (this.H[this.v] == this.u && this.W[this.v] == 12) {
                     this.a[this.a]
                        .drawRegion(
                           this.a[this.A[this.v]],
                           this.aI[this.h[1] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]],
                           this.aI[this.h[19] + this.A[this.v] * 4 + this.F[this.v]],
                           this.aI[this.h[2] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]],
                           this.aI[this.h[20] + this.A[this.v] * 4 + this.F[this.v]] - 7,
                           0,
                           this.Y
                              + this.aI[this.h[27] + (this.Z - this.aL[0]) * 4 + this.u]
                              - this.aI[this.h[2] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]] / 2,
                           this.X + this.aI[this.h[28] + (this.Z - this.aL[0]) * 4 + this.u] - this.aI[this.h[20] + this.A[this.v] * 4 + this.F[this.v]],
                           20
                        );
                     break;
                  }

                  this.v = this.d[this.v];
               }
            }
         }
      }

      if ((this.am & 16) != 0) {
         this.an = 18;
         this.aK();
      }

      this.c(var1);
   }

   final void c(boolean var1) {
      if ((this.am & 1) != 0) {
         this.an = 10;
         this.aK();
      }

      if ((this.am & 32) != 0) {
         this.an = 17;
         this.aK();
      }

      if ((this.am & 2) != 0) {
         this.an = 9;
         this.aK();
      }

      if (this.an == 5) {
         this.an = 3;
         this.aK();
      }

      if (this.an == 6) {
         this.an = 4;
         this.aK();
      }

      if (this.ao == 1) {
         this.an = 6;
         this.aK();
      }

      if (this.ap == 1) {
         this.an = 5;
         this.aK();
      }
   }

   final void aD() {
      this.aE();
      this.aF();
      if (this.Z - this.o[this.ar][this.g[this.ar][36]] == this.aM[0] && this.aa - this.o[this.ar][this.g[this.ar][36] + 1] == this.aM[1]) {
         for (this.u = 0; this.u < this.aq[this.ar]; this.u++) {
            if ((this.o[this.ar][this.g[this.ar][4] + 2] != 0 || this.u % 2 == 0)
               && (
                  this.X + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 1] < this.m
                     || this.X + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 3] < this.m
               )) {
               this.a[this.a].setColor(b.b[this.ar][this.u]);
               this.a[this.a]
                  .drawLine(
                     this.Y + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2],
                     this.X + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 1],
                     this.Y + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 2],
                     this.X + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 3]
                  );
            }
         }
      }

      this.w = 0;

      for (this.u = 0; this.u < this.ar[this.ar]; this.u++) {
         if (this.u > 0) {
            this.w = this.w + this.o[this.ar][this.g[this.ar][1] + (this.u - 1) * 2 + 1] - this.o[this.ar][this.g[this.ar][1] + (this.u - 1) * 2] + 1;
         }

         if (this.as % this.at[this.ar] >= this.o[this.ar][this.g[this.ar][1] + this.u * 2]
            && this.as % this.at[this.ar] <= this.o[this.ar][this.g[this.ar][1] + this.u * 2 + 1]) {
            this.aY[0] = this.o[this.ar][this.g[this.ar][30] + this.w + this.as % this.at[this.ar] - this.o[this.ar][this.g[this.ar][1] + this.u * 2]];
            this.aY[1] = this.o[this.ar][this.g[this.ar][31] + this.w + this.as % this.at[this.ar] - this.o[this.ar][this.g[this.ar][1] + this.u * 2]];
            if (this.X + this.aY[1] < this.m && this.Y + this.aY[0] + this.o[this.ar][this.g[this.ar][27] + this.u] > 0 && this.Y + this.aY[0] < this.l) {
               this.v = false;
               if (this.o[this.ar][this.g[this.ar][3] + 3] == 1) {
                  this.v = 0;
               } else {
                  this.v = this.as % this.at[this.ar];
               }

               if (this.Z == this.aM[0] + this.o[this.ar][this.g[this.ar][36] + this.v * 2]
                  && this.aa == this.aM[1] + this.o[this.ar][this.g[this.ar][36] + this.v * 2 + 1]) {
                  this.v = true;
               }

               if (this.v) {
                  this.a[this.a]
                     .drawRegion(
                        this.b[this.o[this.ar][this.g[this.ar][29] + this.u]],
                        this.o[this.ar][this.g[this.ar][25] + this.u],
                        this.o[this.ar][this.g[this.ar][26] + this.u],
                        this.o[this.ar][this.g[this.ar][27] + this.u],
                        this.o[this.ar][this.g[this.ar][28] + this.u],
                        0,
                        this.Y + this.aY[0],
                        this.X + this.aY[1],
                        20
                     );
               }
            }
         }
      }
   }

   final void aE() {
      this.am = (this.Z - this.aL[0]) * (this.o[this.ar][this.g[this.ar][0] + 1] - 1) + this.aa - this.aL[1] - 1;
      this.ak = this.o[this.ar][this.g[this.ar][33] + this.am];
      this.al = this.o[this.ar][this.g[this.ar][33] + this.am + 1];

      for (this.am = this.ak; this.am < this.al; this.am++) {
         this.u = this.o[this.ar][this.g[this.ar][32] + this.am];
         if (this.X + this.o[this.ar][this.g[this.ar][10] + this.u] < this.m
            && this.Y + this.o[this.ar][this.g[this.ar][9] + this.u] + this.o[this.ar][this.g[this.ar][7] + this.u] > 0
            && this.Y + this.o[this.ar][this.g[this.ar][9] + this.u] < this.l) {
            if (this.o[this.ar][this.g[this.ar][4] + 1] == 1) {
               this.v = true;
            } else if (this.o[this.ar][this.g[this.ar][40] + this.as % this.at[this.ar] * this.an[this.ar] + this.u] == 1) {
               this.v = true;
            } else {
               this.v = false;
            }

            if (this.v) {
               if (this.o[this.ar][this.g[this.ar][11] + this.u] == 5) {
                  this.v = (b.B[1] - 1) * this.aj;
               } else {
                  this.v = 0;
               }

               this.a[this.a]
                  .drawRegion(
                     this.b[this.o[this.ar][this.g[this.ar][11] + this.u]],
                     this.o[this.ar][this.g[this.ar][5] + this.u],
                     this.o[this.ar][this.g[this.ar][6] + this.u] + this.v,
                     this.o[this.ar][this.g[this.ar][7] + this.u],
                     this.o[this.ar][this.g[this.ar][8] + this.u],
                     0,
                     this.Y + this.o[this.ar][this.g[this.ar][9] + this.u],
                     this.X + this.o[this.ar][this.g[this.ar][10] + this.u],
                     20
                  );
            }
         }
      }

      if (this.Z - this.o[this.ar][this.g[this.ar][36]] == this.aM[0] && this.aa - this.o[this.ar][this.g[this.ar][36] + 1] == this.aM[1]) {
         for (this.u = 0; this.u < this.ao[this.ar]; this.u++) {
            if (this.X + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 1] < this.m
               || this.X + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 3] < this.m) {
               this.a[this.a].setColor(b.a[this.ar][this.u]);
               this.a[this.a]
                  .drawLine(
                     this.Y + this.o[this.ar][this.g[this.ar][19] + this.u * 4],
                     this.X + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 1],
                     this.Y + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 2],
                     this.X + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 3]
                  );
            }
         }
      }
   }

   final void aF() {
      for (this.u = 0; this.u < this.ap[this.ar]; this.u++) {
         if (this.o[this.ar][this.g[this.ar][2]] == 1) {
            this.aY[0] = this.o[this.ar][this.g[this.ar][17] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u];
         } else {
            this.aY[0] = this.o[this.ar][this.g[this.ar][17] + this.u];
         }

         if (this.o[this.ar][this.g[this.ar][2] + 1] == 1) {
            this.aY[1] = this.o[this.ar][this.g[this.ar][18] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u];
         } else {
            this.aY[1] = this.o[this.ar][this.g[this.ar][18] + this.u];
         }

         if (this.X + this.aY[1] < this.m && this.Y + this.aY[0] + this.o[this.ar][this.g[this.ar][14] + this.u] > 0 && this.Y + this.aY[0] < this.l) {
            this.v = false;
            if (this.o[this.ar][this.g[this.ar][3] + 1] == 1) {
               this.v = 0;
            } else {
               this.v = this.as % this.at[this.ar];
            }

            if (this.Z == this.aM[0] + this.o[this.ar][this.g[this.ar][34] + this.v * 2]
               && this.aa == this.aM[1] + this.o[this.ar][this.g[this.ar][34] + this.v * 2 + 1]) {
               this.v = true;
            }

            if (!this.v) {
               break;
            }

            if (this.o[this.ar][this.g[this.ar][4] + 1] == 1) {
               this.v = true;
            } else if (this.o[this.ar][this.g[this.ar][41] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u] == 1) {
               this.v = true;
            } else {
               this.v = false;
            }

            if (this.v) {
               this.a[this.a]
                  .drawRegion(
                     this.b[this.o[this.ar][this.g[this.ar][16] + this.u]],
                     this.o[this.ar][this.g[this.ar][12] + this.u],
                     this.o[this.ar][this.g[this.ar][13] + this.u],
                     this.o[this.ar][this.g[this.ar][14] + this.u],
                     this.o[this.ar][this.g[this.ar][15] + this.u],
                     0,
                     this.Y + this.aY[0],
                     this.X + this.aY[1],
                     20
                  );
            }
         }
      }
   }

   final void aG() {
      this.v = -1 - this.an;
      if (this.aH[this.v] > 0 && this.b == 0) {
         this.w = (this.aq & 255) % this.aH[this.v];
      } else {
         this.w = 0;
      }

      for (this.u = 0; this.u < this.aF[this.v]; this.u++) {
         if (this.X + this.p[this.v][this.h[this.v][5] + this.u] < this.m
            && this.Y + this.p[this.v][this.h[this.v][4] + this.u] + this.p[this.v][this.h[this.v][2] + this.u] > 0
            && this.Y + this.p[this.v][this.h[this.v][4] + this.u] < this.l) {
            if (this.an > -15) {
               this.v = true;
            } else if (this.aH[this.v] != 0 && (this.r || !this.s)) {
               if (this.p[this.v][this.h[this.v][14] + this.w * this.aF[this.v] + this.u] == 1) {
                  this.v = true;
               } else {
                  this.v = false;
               }
            } else {
               this.v = true;
            }

            if (this.v) {
               this.a[this.a]
                  .drawRegion(
                     this.b[this.p[this.v][this.h[this.v][6] + this.u]],
                     this.p[this.v][this.h[this.v][0] + this.u],
                     this.p[this.v][this.h[this.v][1] + this.u],
                     this.p[this.v][this.h[this.v][2] + this.u],
                     this.p[this.v][this.h[this.v][3] + this.u],
                     0,
                     this.Y + this.p[this.v][this.h[this.v][4] + this.u],
                     this.X + this.p[this.v][this.h[this.v][5] + this.u],
                     20
                  );
            }
         }
      }
   }

   final void aH() {
      if (this.an < 0 && this.an >= -27) {
         this.aG();
         if (this.an > -15) {
            return;
         }

         if (this.r && !this.s && this.p[this.v][this.h[this.v][2] + this.aF[this.v]] > 0) {
            this.a[this.a]
               .drawRegion(
                  this.b[this.p[this.v][this.h[this.v][6] + this.aF[this.v]]],
                  this.p[this.v][this.h[this.v][0] + this.aF[this.v]],
                  this.p[this.v][this.h[this.v][1] + this.aF[this.v]],
                  this.p[this.v][this.h[this.v][2] + this.aF[this.v]],
                  this.p[this.v][this.h[this.v][3] + this.aF[this.v]],
                  0,
                  this.Y + this.p[this.v][this.h[this.v][4] + this.aF[this.v]],
                  this.X + this.p[this.v][this.h[this.v][5] + this.aF[this.v]],
                  20
               );
         } else if (!this.r && this.s && this.p[this.v][this.h[this.v][2] + this.aF[this.v] + 1] > 0) {
            this.a[this.a]
               .drawRegion(
                  this.b[this.p[this.v][this.h[this.v][6] + this.aF[this.v] + 1]],
                  this.p[this.v][this.h[this.v][0] + this.aF[this.v] + 1],
                  this.p[this.v][this.h[this.v][1] + this.aF[this.v] + 1],
                  this.p[this.v][this.h[this.v][2] + this.aF[this.v] + 1],
                  this.p[this.v][this.h[this.v][3] + this.aF[this.v] + 1],
                  0,
                  this.Y + this.p[this.v][this.h[this.v][4] + this.aF[this.v] + 1],
                  this.X + this.p[this.v][this.h[this.v][5] + this.aF[this.v] + 1],
                  20
               );
         }

         if (this.r && this.s || this.b != 0 && this.aW == 26) {
            for (this.u = 0; this.u < this.aG[this.v]; this.u++) {
               if (this.X + this.p[this.v][this.h[this.v][13] + this.w * this.aG[this.v] + this.u] < this.m
                  && this.Y + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u] + this.p[this.v][this.h[this.v][9] + this.u] > 0
                  && this.Y + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u] < this.l) {
                  if (this.p[this.v][this.h[this.v][15] + this.w * this.aG[this.v] + this.u] == 1) {
                     this.v = true;
                  } else {
                     this.v = false;
                  }

                  if (this.v) {
                     this.a[this.a]
                        .drawRegion(
                           this.b[this.p[this.v][this.h[this.v][11] + this.u]],
                           this.p[this.v][this.h[this.v][7] + this.u],
                           this.p[this.v][this.h[this.v][8] + this.u],
                           this.p[this.v][this.h[this.v][9] + this.u],
                           this.p[this.v][this.h[this.v][10] + this.u],
                           0,
                           this.Y + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u],
                           this.X + this.p[this.v][this.h[this.v][13] + this.w * this.aG[this.v] + this.u],
                           20
                        );
                  }
               }
            }
         }
      }
   }

   final void aI() {
      this.a[this.a]
         .drawRegion(
            this.b[2],
            this.aI[this.h[59] + this.an],
            this.aI[this.h[60] + this.an],
            this.aI[this.h[61] + this.an],
            this.aI[this.h[62] + this.an],
            0,
            this.Y + this.aI[this.h[63] + this.an],
            this.X + this.aI[this.h[64] + this.an],
            20
         );
   }

   final void aJ() {
      this.a[this.a]
         .drawRegion(
            this.b[2],
            this.aI[this.h[65] + this.an],
            this.aI[this.h[66] + this.an],
            this.aI[this.h[67] + this.an],
            this.aI[this.h[68] + this.an],
            0,
            this.Y + this.aI[this.h[69] + this.ao],
            this.X + this.aI[this.h[70] + this.ao],
            20
         );
   }

   final void aK() {
      if (this.an == 19 && this.b != 0) {
         this.ap = b.B[0] / 4;
      } else {
         this.ap = 0;
      }

      this.a[this.a]
         .drawRegion(
            this.b[2],
            this.aI[this.h[59] + this.an],
            this.aI[this.h[60] + this.an],
            this.aI[this.h[61] + this.an],
            this.aI[this.h[62] + this.an],
            0,
            this.Y + this.aI[this.h[63] + this.an] + this.ap,
            this.X + this.aI[this.h[64] + this.an],
            20
         );
   }

   final void aL() {
      try {
         this.v = this.c[this.Z][this.aa];
         if (this.v >= 0) {
            if (this.b[this.Z][this.aa] == 10 && this.ag[this.c[this.Z][this.aa]] == 4) {
               this.a[this.a]
                  .drawRegion(
                     this.a[9],
                     b.af[this.af[this.c[this.Z][this.aa]] % 2],
                     b.ag[this.af[this.c[this.Z][this.aa]] % 2],
                     b.ah[this.af[this.c[this.Z][this.aa]] % 2],
                     b.ai[this.af[this.c[this.Z][this.aa]] % 2],
                     0,
                     this.Y + this.aB[this.Z[this.c[this.Z][this.aa]]] - b.ah[this.af[this.c[this.Z][this.aa]] % 2],
                     this.X + this.aC[this.Z[this.c[this.Z][this.aa]]] - b.ai[this.af[this.c[this.Z][this.aa]] % 2],
                     20
                  );
            } else {
               this.aM();
               if (this.c != 0) {
                  this.aN();

                  for (this.u = 0; this.u < this.c; this.u++) {
                     if (this.W[this.d[0][this.u]] == 15) {
                        this.a[this.a]
                           .drawRegion(
                              this.b[2],
                              b.aa[this.J[this.d[0][this.u]] % 2],
                              b.ab[this.J[this.d[0][this.u]] % 2],
                              b.ac[this.J[this.d[0][this.u]] % 2],
                              b.ad[this.J[this.d[0][this.u]] % 2],
                              0,
                              this.Y + b.B[0] / 2 - b.ac[this.J[this.d[0][this.u]] % 2] / 2 + this.h[0][this.d[0][this.u]],
                              this.X + this.d[1][this.u] - b.ad[this.J[this.d[0][this.u]] % 2] + b.ae[this.J[this.d[0][this.u]] % 2],
                              20
                           );
                     } else {
                        this.aO();
                        if (this.Y + this.v > -b.B[0] / 2 && this.Y + this.v < this.l + b.B[0] / 4) {
                           this.aP();
                           if (this.W[this.d[0][this.u]] == 10) {
                              this.a[this.a].drawRegion(this.b[1], 40, 0, 12, 8, 0, this.Y + this.v + -6, this.X + this.d[1][this.u] + -11, 20);
                           }

                           this.a[this.a]
                              .drawRegion(
                                 this.a[this.A[this.d[0][this.u]]],
                                 this.aY[2],
                                 this.aY[3],
                                 this.aY[4],
                                 this.aY[5] - this.aT,
                                 0,
                                 this.Y + this.v - this.aU,
                                 this.X + this.d[1][this.u] - this.aV,
                                 20
                              );
                           this.aQ();
                        }
                     }
                  }
               }
            }
         }
      } catch (Exception var2) {
      }
   }

   final void aM() {
      for (this.c = 0; this.v >= 0; this.v = this.d[this.v]) {
         if ((this.W[this.v] <= -1 || this.W[this.v] >= 7 || this.h[0][this.v] != 1 || this.aI[this.h[this.q[1][0]] + this.W[this.v] * 4] != 2)
            && this.W[this.v] != 12
            && this.W[this.v] != 16
            && (this.W[this.v] != 13 || this.o[this.Z[this.c[this.Z][this.aa]]][this.g[this.Z[this.c[this.Z][this.aa]]][4]] != 0)) {
            this.d[0][this.c] = (short)this.v;
            if (this.W[this.v] == 13) {
               this.d[1][this.c] = this.H[this.v];
            } else if (this.W[this.v] == 15) {
               this.d[1][this.c] = (short)(b.B[1] / 2 + this.h[1][this.v]);
            } else {
               this.d[1][this.c] = (short)(b.B[1] / 2 + (this.G[this.v] - this.H[this.v]) / b.Y[1]);
            }

            if (this.X + this.d[1][this.c] > 0 && this.X + this.d[1][this.c] <= this.m + b.B[1]) {
               this.c++;
            }
         }
      }
   }

   final void aN() {
      for (this.u = 0; this.u < this.c - 1; this.u++) {
         for (this.v = this.u + 1; this.v < this.c; this.v++) {
            if (this.d[1][this.u] > this.d[1][this.v]) {
               this.d = this.d[0][this.u];
               this.d[0][this.u] = this.d[0][this.v];
               this.d[0][this.v] = this.d;
               this.d = this.d[1][this.u];
               this.d[1][this.u] = this.d[1][this.v];
               this.d[1][this.v] = this.d;
            }
         }
      }
   }

   final void aO() {
      if (this.W[this.d[0][this.u]] != -1 && this.W[this.d[0][this.u]] < 9) {
         this.w = this.X[this.d[0][this.u]];
      } else {
         this.w = this.F[this.d[0][this.u]];
      }

      this.aT = 0;
      this.aU = 0;
      this.aV = 0;
      if (this.W[this.d[0][this.u]] == 13) {
         this.aY[5] = this.J[this.d[0][this.u]];
         if (this.c[this.d[0][this.u]] % this.at[this.Z[this.c[this.Z][this.aa]]]
               >= this.o[this.Z[this.c[this.Z][this.aa]]][this.g[this.Z[this.c[this.Z][this.aa]]][39]]
            && this.c[this.d[0][this.u]] % this.at[this.Z[this.c[this.Z][this.aa]]]
               <= this.o[this.Z[this.c[this.Z][this.aa]]][this.g[this.Z[this.c[this.Z][this.aa]]][39] + 1]) {
            this.aT = this.ax[this.Z[this.c[this.Z][this.aa]]];
         }

         if (this.Z[this.c[this.Z][this.aa]] == 14) {
            this.aV = (byte)(this.aV - this.aI[this.h[20] + this.A[this.d[0][this.u]] * 4]);
         }

         this.v = this.G[this.d[0][this.u]];
      } else {
         if (this.W[this.d[0][this.u]] == 1 && this.h[0][this.d[0][this.u]] == 1) {
            this.w = 4;
            this.aY[5] = this.h[2][this.d[0][this.u]];
         } else {
            this.aY[5] = this.K[this.J[this.d[0][this.u]]];
         }

         if (this.W[this.d[0][this.u]] == 10) {
            this.aT = 7;
         }

         this.v = (this.G[this.d[0][this.u]] + this.H[this.d[0][this.u]]) / b.Y[0];
      }
   }

   final void aP() {
      if (this.w < 4) {
         this.aY[2] = this.aI[this.h[1] + this.A[this.d[0][this.u]] * 12 + this.w * 3 + this.aY[5]];
         this.aY[4] = this.aI[this.h[2] + this.A[this.d[0][this.u]] * 12 + this.w * 3 + this.aY[5]];
         this.aY[3] = this.aI[this.h[19] + this.A[this.d[0][this.u]] * 4 + this.w];
         this.aY[5] = this.aI[this.h[20] + this.A[this.d[0][this.u]] * 4 + this.w];
      } else if (this.w == 4) {
         this.aY[2] = this.aI[this.h[21] + this.A[this.d[0][this.u]] * 2 + this.aY[5]];
         this.aY[4] = this.aI[this.h[43] + this.A[this.d[0][this.u]]];
         this.aY[3] = this.aI[this.h[42] + this.A[this.d[0][this.u]]];
         this.aY[5] = this.aI[this.h[44] + this.A[this.d[0][this.u]]];
      } else if (this.w == 5) {
         if (this.aY[5] == 0) {
            this.aV = this.aI[this.h[25] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
         }

         this.aY[2] = this.aI[this.h[22] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
         this.aY[4] = this.aI[this.h[24] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
         this.aY[3] = this.aI[this.h[23] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
         this.aY[5] = this.aI[this.h[25] + this.A[this.d[0][this.u]] * 3 + this.aY[5]];
      } else if (this.w == 6) {
         this.aY[2] = this.aI[this.h[45] + this.A[this.d[0][this.u]]];
         this.aY[4] = this.aI[this.h[47] + this.A[this.d[0][this.u]]];
         this.aY[3] = this.aI[this.h[46] + this.A[this.d[0][this.u]]];
         this.aY[5] = this.aI[this.h[48] + this.A[this.d[0][this.u]]];
      } else if (this.w == 7) {
         this.aU = (byte)(this.aU + this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 2] / 2 * this.aI[this.h[26] + this.aY[5] * 2]);
         this.aV = (byte)(this.aV + this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 3] / 2 * this.aI[this.h[26] + this.aY[5] * 2 + 1]);
         this.aY[2] = this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4];
         this.aY[4] = this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 2];
         this.aY[3] = this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 1];
         this.aY[5] = this.aI[this.h[3] + this.A[this.d[0][this.u]] * 28 + this.aY[5] * 4 + 3];
      }

      if (this.w != 5 && this.w != 7) {
         this.aU = (byte)(this.aU + this.aY[4] / 2);
         this.aV = (byte)(this.aV + this.aY[5]);
      }
   }

   final void aQ() {
      if (this.W[this.d[0][this.u]] == 13) {
         if (this.Z[this.c[this.Z][this.aa]] == 0) {
            this.a[this.a]
               .drawRegion(
                  this.b[this.aI[this.h[75]]],
                  this.aI[this.h[75] + 1],
                  this.aI[this.h[75] + 2],
                  this.aI[this.h[75] + 3],
                  this.aI[this.h[75] + 4],
                  0,
                  this.Y + this.v + this.aI[this.h[75] + 5],
                  this.X + this.d[1][this.u] + this.aI[this.h[75] + 6],
                  20
               );
         }

         if (this.Z[this.c[this.Z][this.aa]] == 14
            || this.Z[this.c[this.Z][this.aa]] == 16
               && this.c[this.d[0][this.u]] >= this.aI[this.h[76]]
               && this.c[this.d[0][this.u]] <= this.aI[this.h[76] + 1]) {
            this.a[this.a]
               .drawRegion(
                  this.a[this.A[this.d[0][this.u]]],
                  this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6],
                  this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 1],
                  this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 2],
                  this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 3],
                  0,
                  this.Y + this.v - this.aU + this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 4],
                  this.X + this.d[1][this.u] - this.aV + this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 5],
                  20
               );
            return;
         }
      } else if (this.d[0][this.u] < 200) {
         if (this.M[this.d[0][this.u]] >= 0) {
            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  this.aI[this.h[71] + this.M[this.d[0][this.u]] + 13],
                  this.aI[this.h[72] + this.M[this.d[0][this.u]] + 13],
                  this.aI[this.h[73] + this.M[this.d[0][this.u]] + 13],
                  this.aI[this.h[74] + this.M[this.d[0][this.u]] + 13],
                  0,
                  this.Y + this.v - this.aI[this.h[73] + this.M[this.d[0][this.u]] + 13] / 2,
                  this.X + this.d[1][this.u] - this.aV - this.aI[this.h[74] + this.M[this.d[0][this.u]] + 13],
                  20
               );
         }

         if (this.O[this.d[0][this.u]] >= 0) {
            this.w = this.O[this.d[0][this.u]] % b.e.length;
            this.a[this.a]
               .drawRegion(
                  this.b[2],
                  b.e[this.w][0],
                  b.e[this.w][1],
                  b.e[this.w][2],
                  b.e[this.w][3],
                  0,
                  this.Y + this.v - b.e[this.w][2] / 2 + b.e[this.w][4],
                  this.X + this.d[1][this.u] - this.aV + b.e[this.w][5],
                  20
               );
         }

         this.b(this.d[0][this.u], this.Y + this.v, this.X + this.d[1][this.u] - this.aV);
      }
   }

   final void b(int var1, int var2, int var3) {
      if (this.N[var1] >= 0) {
         this.a[this.a]
            .drawRegion(
               this.c[2],
               this.aI[this.h[71] + 0],
               this.aI[this.h[72] + 0],
               this.aI[this.h[73] + 0],
               this.aI[this.h[74] + 0],
               0,
               var2 - this.aI[this.h[73] + 0],
               var3 - this.aI[this.h[74] + 0],
               20
            );
         this.a[this.a]
            .drawRegion(
               this.c[2],
               this.aI[this.h[71] + this.aI[this.h[96] + this.N[var1]]],
               this.aI[this.h[72] + this.aI[this.h[96] + this.N[var1]]],
               this.aI[this.h[73] + this.aI[this.h[96] + this.N[var1]]],
               this.aI[this.h[74] + this.aI[this.h[96] + this.N[var1]]],
               0,
               var2 - this.aI[this.h[73] + 0] + b.ak[0] - this.aI[this.h[73] + this.aI[this.h[96] + this.N[var1]]] / 2,
               var3 - this.aI[this.h[74] + 0] + b.ak[1] - this.aI[this.h[74] + this.aI[this.h[96] + this.N[var1]]] / 2,
               20
            );
      }
   }

   final void aR() {
      for (this.q = 0; this.q < this.aH; this.q++) {
         if (this.x[this.q][0] >= 0) {
            this.a[this.a]
               .drawRegion(
                  this.c[2],
                  this.aI[this.h[71] + this.aS[this.q]],
                  this.aI[this.h[72] + this.aS[this.q]],
                  this.aI[this.h[73] + this.aS[this.q]],
                  this.aI[this.h[74] + this.aS[this.q]],
                  0,
                  (this.x[this.q][0] + this.x[this.q][1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + this.aR[this.q],
                  (this.x[this.q][0] - this.x[this.q][1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + this.aQ[this.q],
                  20
               );
         }
      }
   }

   final void aS() {
      if (this.g && this.b == 0 || this.i >= 0) {
         this.n = 0;
      }

      if (this.aN > 0 && this.q) {
         this.n = 0;
         this.aN = 0;
      }

      if (this.n == 48 && !this.p) {
         this.aT();
      } else if (this.b == 0) {
         if (this.aN != 1) {
            this.aU();
         }
      } else if (this.b == 1) {
         this.bh();
      } else if (this.b == 2) {
         this.bk();
      } else if (this.b == 3) {
         this.bo();
      } else if (this.b == 4) {
         this.bI();
      } else if (this.b == 5) {
         this.bJ();
      }

      if (this.q || this.n == -6 || this.n == -7 || this.n == 48 || this.n == 5 || this.b != 0) {
         this.n = 0;
      }

      if (this.n != 0) {
         this.aN++;
      }
   }

   final void aT() {
      if ((this.b != 3 || this.R > 17 || this.R == 10 && this.K == 1) && this.b != 4 && this.b != 0 && this.b != 1 && this.b != 5) {
         this.cD();
      } else if (this.b == 0) {
         this.a = 1;
         this.al();
         this.a = 0;
         this.b = 4;
         this.aa = 0;
         this.aO = 1;
         this.n[0] = 2;
         this.n[1] = (this.l - this.O * (b.d[2] + 2)) / 2;
         this.n[2] = this.l - 2 - this.O * (b.d[2] + 2);
      } else {
         if (this.b == 4) {
            this.b = 0;
            this.aa = 5;
         }
      }
   }

   final void aU() {
      this.aV();
      switch (this.n) {
         case -7:
            this.bg();
            break;
         case -6:
            this.bf();
            return;
         case -5:
         case -4:
         case -3:
         case -2:
         case -1:
         case 0:
         default:
            break;
         case 1:
            this.aW();
            return;
         case 2:
            this.aX();
            return;
         case 3:
            this.aZ();
            return;
         case 4:
            this.aY();
            return;
         case 5:
            if (!this.e && !this.h) {
               if (this.b[this.a[0]][this.a[1]] >= 4 && this.b[this.a[0]][this.a[1]] <= 13) {
                  this.ba();
                  return;
               }

               if (this.b[this.a[0]][this.a[1]] < 0 && this.b[this.a[0]][this.a[1]] >= -28) {
                  this.bb();
                  return;
               }

               if (this.c[this.a[0]][this.a[1]] != -1) {
                  this.bc();
                  return;
               }
            } else {
               if (this.e) {
                  this.bd();
                  return;
               }

               if (this.h) {
                  if (this.b[this.a[0]][this.a[1]] > 0 && this.b[this.a[0]][this.a[1]] <= 3) {
                     return;
                  }

                  this.be();
                  return;
               }
            }
      }
   }

   final void aV() {
      if (this.aa != 5) {
         this.aa = 0;
      }

      if (this.e) {
         if (this.j >= 0) {
            this.o[0] = b.a[this.at][this.j][0];
            this.o[1] = b.b[this.at][this.j][0];
            this.o[2] = b.a[this.at][this.j][1];
            this.o[3] = b.b[this.at][this.j][1];
            return;
         }

         this.o[0] = 0;
         this.o[1] = 0;
         this.o[2] = this.B;
         this.o[3] = this.C;
      }
   }

   final void aW() {
      this.r = this.a[0] - this.a[1] - this.o[3] - this.f[0][0] + this.f[0][1];
      if (this.e && this.r < 0) {
         for (this.q = 0; this.q < 4; this.q++) {
            this.f[this.q][0] = this.f[this.q][0] + (this.r - 1) / 2;
            this.f[this.q][1] = this.f[this.q][1] - (this.r - 1) / 2;
         }

         this.aa = 1;
      } else {
         if (this.a[0] > -this.o[0]) {
            this.a[0]--;
            if (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1] - 2 < 0 || this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1] - 2 < 0 || this.e) {
               for (this.q = 0; this.q < 4; this.q++) {
                  this.f[this.q][0]--;
               }

               this.aa = 1;
            }
         }
      }
   }

   final void aX() {
      this.r = this.a[0] + this.o[2] - this.a[1] - this.f[3][0] + this.f[3][1] - 2;
      if (this.e && this.r > 0) {
         for (this.q = 0; this.q < 4; this.q++) {
            this.f[this.q][0] = this.f[this.q][0] + (this.r + 1) / 2;
            this.f[this.q][1] = this.f[this.q][1] - (this.r + 1) / 2;
         }

         this.aa = 2;
      } else {
         if (this.a[0] < this.O - 1 && !this.e || this.a[0] < this.O - this.o[2] && this.e) {
            this.a[0]++;
            if (this.a[0] + this.a[1] - this.f[1][0] - this.f[1][1] + 1 > 0 || this.a[0] - this.a[1] - this.f[3][0] + this.f[3][1] + 1 > 0 || this.e) {
               for (this.q = 0; this.q < 4; this.q++) {
                  this.f[this.q][0]++;
               }

               this.aa = 2;
            }
         }
      }
   }

   final void aY() {
      this.r = this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1];
      if (this.e && this.r < 0) {
         for (this.q = 0; this.q < 4; this.q++) {
            this.f[this.q][0] = this.f[this.q][0] + (this.r - 1) / 2;
            this.f[this.q][1] = this.f[this.q][1] + (this.r - 1) / 2;
         }

         this.aa = 4;
      } else {
         if (this.a[1] > -this.o[1]) {
            this.a[1]--;
            if (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1] - 2 < 0 || this.a[0] - this.a[1] - this.f[3][0] + this.f[3][1] + 1 > 0 || this.e) {
               for (this.q = 0; this.q < 4; this.q++) {
                  this.f[this.q][1]--;
               }

               this.aa = 4;
            }
         }
      }
   }

   final void aZ() {
      this.r = this.a[0] + this.o[2] + this.a[1] + this.o[3] - this.f[1][0] - this.f[1][1] - 2;
      if (this.e && this.r > 0) {
         for (this.q = 0; this.q < 4; this.q++) {
            this.f[this.q][0] = this.f[this.q][0] + (this.r + 1) / 2;
            this.f[this.q][1] = this.f[this.q][1] + (this.r + 1) / 2;
         }

         this.aa = 3;
      } else {
         if (this.a[1] < this.O - 1 && !this.e || this.a[1] < this.O - this.o[3] && this.e) {
            this.a[1]++;
            if (this.a[0] + this.a[1] - this.f[1][0] - this.f[1][1] + 1 > 0 || this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1] - 2 < 0 || this.e) {
               for (this.q = 0; this.q < 4; this.q++) {
                  this.f[this.q][1]++;
               }

               this.aa = 3;
            }
         }
      }
   }

   final void ba() {
      this.b = 3;
      if (this.c[this.a[0]][this.a[1]] >= 0) {
         this.ar = this.Z[this.c[this.a[0]][this.a[1]]];
         this.m = this.c[this.c[this.a[0]][this.a[1]]];
         if (this.ar != 23) {
            this.R = 18;
            this.x[0] = 0;
            this.x[1] = 1;
            this.x[2] = 2;
            this.y[0] = (byte)(this.aA[this.ar] / 5);
            if (this.ar == 22) {
               this.y[0] = (byte)(this.ad[this.c[this.a[0]][this.a[1]]] / 5);
            }

            this.y[1] = (byte)(this.ah[this.c[this.a[0]][this.a[1]]] / 10);
            this.y[2] = this.al[this.ar];
         } else {
            this.R = 21;
            this.an = 28;
            this.n = this.a[this.c[this.a[0]][this.a[1]]];
            this.x[0] = 2;
            this.y[0] = this.aE[this.aI[this.h[57] + this.an]];
            this.U = this.aI[this.h[56] + this.an];
         }
      } else {
         this.ar = 22;
         this.R = 18;
      }

      this.w[this.R] = this.aI[this.h[135] + this.ar];
      this.cu();
      this.aa = 5;
   }

   final void bb() {
      if (this.b[this.a[0]][this.a[1]] <= -15) {
         if (this.aI[this.h[57] + -1 - this.b[this.a[0]][this.a[1]]] >= 0) {
            this.R = 19;
            this.an = (byte)(-1 - this.b[this.a[0]][this.a[1]]);
            this.n = this.d[this.c[this.a[0]][this.a[1]]];
            this.x[0] = 0;
            this.x[1] = 2;
            this.y[0] = this.aI[this.h[29] + this.an * (this.ad + 1) + this.ad];
            this.y[1] = this.aE[this.aI[this.h[57] + this.an]];
            this.U = this.aI[this.h[56] + this.an];
         } else if (this.b[this.a[0]][this.a[1]] <= -27) {
            this.R = 22;
            this.an = 26;
            this.n = this.d[this.c[this.a[0]][this.a[1]]];
            this.U = this.aI[this.h[56] + this.an];
         } else {
            if (!this.f[this.c[this.a[0]][this.a[1]]]) {
               return;
            }

            this.R = 19;
            this.an = (byte)(-1 - this.b[this.a[0]][this.a[1]]);
         }

         this.b = 3;
         this.w[this.R] = this.aI[this.h[136] + this.an];
         this.cu();
         this.aa = 5;
      }
   }

   final void bc() {
      for (this.v = this.c[this.a[0]][this.a[1]]; this.v != -1; this.v = this.d[this.v]) {
         if (this.A[this.v] == 8 || this.A[this.v] == 9) {
            this.b = 3;
            this.R = 20;
            this.U = (byte)(this.A[this.v] - 8);
            this.j = this.v;
            this.x[0] = 2;
            this.y[0] = this.aI[this.h[131] + this.U];
            this.w[this.R] = this.aI[this.h[137] + this.U];
            this.cu();
            this.aa = 5;
         }
      }

      if (this.b == 0) {
         this.v = this.c[this.a[0]][this.a[1]];
         this.aO = this.v;
         this.e(false);
         this.b = 3;
         this.R = 23;
         this.U = this.A[this.v];
         this.j = this.v;
         this.x[0] = 0;
         this.x[1] = 4;
         this.x[2] = 3;
         this.y[0] = (byte)(this.P[this.v] / 10);
         this.y[1] = (byte)(this.R[this.v] / 10);
         this.y[2] = (byte)(this.Q[this.v] / 10);
         this.cu();
         this.aa = 5;
      }
   }

   final void bd() {
      if (this.f) {
         if (this.k < this.i) {
            this.h = 0;
         }

         if (this.k - -500 >= this.i) {
            if (this.aX == 0) {
               this.d = 0;
               this.g = true;
               this.W = b.m[this.d];
               this.X = b.n[this.d];
               return;
            }

            this.cc();
            if (this.aX != 3 && (this.aX != 1 || this.aW >= 14 || this.aW == 13 && this.aX == 1 && this.ag >= 30)) {
               this.d = -1;
               this.e = false;
            }

            if (this.aX == 1 && this.aW < 14) {
               this.s = (this.a.nextInt() & 15) % 4;

               for (this.r = 0; this.r < this.s; this.r++) {
                  this.au = (byte)(this.au - this.aI[this.h[162] - 1 - this.au]);
               }
            }
         }
      }
   }

   final void be() {
      this.d = 0;
      this.bR();
      if (this.i) {
         if (this.U >= 0) {
            if (this.k - -500 < this.aI[this.h[131] + this.U]) {
               return;
            }

            this.cm();
            this.k = this.k - this.aI[this.h[131] + this.U];
            this.e = this.e + this.aI[this.h[131] + this.U];
            this.aT[0] = (byte)this.a[0];
            this.aT[1] = (byte)this.a[1];
            this.h = (short)(b.B[0] / 2);
            this.i = 0;
            this.a.delete(0, this.a.length());
            this.a.append("-");
            this.a.append(this.aI[this.h[131] + this.U]);
            this.b = this.a.toString();
            this.dM();
         }

         this.bX();
      } else {
         this.f = 0;
         this.aC = 1;
         this.aB = this.aA;
         this.dI();
      }
   }

   final void bf() {
      if (!this.e && !this.h) {
         this.a = 1;
         this.al();
         this.a = 0;
         this.b = 1;
         this.aa = 0;
         this.z = 0;
         this.A = 0;
         this.aC = 1;
         this.aA = (byte)(23 + this.y);
         this.dI();
      } else {
         if (this.e) {
            if (this.aX == 0) {
               this.at = (byte)((this.at + 1) % 2);
               if (this.j >= 0) {
                  this.B = b.a[this.at][this.j][1];
                  this.C = b.b[this.at][this.j][1];
                  if (this.a[0] + b.a[this.at][this.j][0] < 0) {
                     this.aX();
                  }

                  if (this.a[0] + b.a[this.at][this.j][1] > this.O) {
                     this.aW();
                  }

                  if (this.a[1] + b.b[this.at][this.j][0] < 0) {
                     this.aZ();
                  }

                  if (this.a[1] + b.b[this.at][this.j][1] > this.O) {
                     this.aY();
                     return;
                  }
               }
            } else {
               if (this.aX == 1) {
                  this.au = (byte)(this.au - this.aI[this.h[162] - 1 - this.au]);
                  return;
               }

               if (this.aX == 3 && this.aW == 2) {
                  if (this.av == 0) {
                     this.av = -1;
                     return;
                  }

                  this.av = 0;
                  return;
               }
            }
         } else if (this.h) {
            if (this.b[this.a[0]][this.a[1]] > 0 && this.b[this.a[0]][this.a[1]] <= 3) {
               return;
            }

            this.be();
         }
      }
   }

   final void bg() {
      if (this.e) {
         this.cn();
         this.k = false;
         if (!this.e) {
            this.j = -1;
            this.d = -1;
         }

         this.aa = 5;
      } else if (this.h) {
         this.d = -1;
         this.h = false;
      } else {
         if (!this.e && !this.h) {
            this.az = 0;
            this.b = 3;
            this.R = 1;
            this.l = false;
            this.cu();
            this.aa = 5;
         }
      }
   }

   final void bh() {
      if (this.z == 0) {
         switch (this.n) {
            case -7:
               this.b = 0;
               this.aa = 5;
               break;
            case -6:
            case 5:
               this.bi();
               this.aa = 5;
            case -5:
            case -4:
            case -3:
            case -2:
            case -1:
            case 0:
            case 1:
            case 2:
            default:
               break;
            case 3:
               this.A = -1;
               this.z = 3;
               this.y++;
               if (this.y == this.x) {
                  this.y = 0;
               }

               this.aC = 1;
               this.aA = (byte)(23 + this.y);
               this.dI();
               break;
            case 4:
               this.A = 1;
         }
      }

      this.bj();
   }

   final void bi() {
      if (this.y != 6 && this.y != 3) {
         this.b = 2;
         this.C = 0;
         this.av = 0;
         if (this.y == 1) {
            this.B = 0;
         }

         if (this.y == 2) {
            this.B = 1;
         }

         if (this.y == 5) {
            this.B = 2;
         }

         if (this.y == 4) {
            this.B = 3;
         }

         if (this.y == 0) {
            this.B = 4;
         }

         while (true) {
            this.aW = this.aI[this.h[151 + this.B] + this.C];
            this.aX = this.aI[this.h[146 + this.B] + this.C];
            if (!this.a()) {
               this.cp();
               return;
            }

            this.C++;
            if (this.C == b.j[this.B]) {
               this.C = 0;
            }
         }
      } else if (this.y == 6) {
         this.b = 0;
         this.d = -1;
         this.h = true;
      } else {
         if (this.y == 3) {
            for (this.ag = 0; this.ag < 8; this.ag++) {
               if (this.ag > 3) {
                  this.ai = 3;
               } else {
                  this.ai = this.ag;
                  this.d[this.ag][0] = this.d[this.ag][1];
               }

               for (this.ah = 0; this.ah < this.c[this.ag][d.k[4]]; this.ah++) {
                  if (this.c[this.ag][this.ah] > this.d[this.ai][0]) {
                     this.d[this.ai][0] = this.c[this.ag][this.ah];
                  }
               }
            }

            this.b = 3;
            this.R = 26;
            this.cu();
         }
      }
   }

   final void bj() {
      this.z = (byte)(this.z + this.A);
      if (this.z == 3) {
         if (this.y == 0) {
            this.y = this.x;
         }

         this.y--;
         this.aC = 1;
         this.aA = (byte)(23 + this.y);
         this.dI();
         this.z = 0;
         this.A = 0;
      }

      if (this.z == 0 && this.A == -1) {
         this.A = 0;
      }
   }

   final void bk() {
      switch (this.n) {
         case -6:
         case 5:
            if (this.p) {
               break;
            }

            if (!this.o) {
               this.bl();
               return;
            }

            if (this.k < this.i) {
               this.h = 0;
            }

            if (this.k - -500 < this.i) {
               break;
            }

            this.bm();
         case -7:
            this.bn();
         case -5:
         case -4:
         case -3:
         case -2:
         case -1:
         case 0:
         case 1:
         case 2:
         default:
            break;
         case 3:
            if (this.o) {
               return;
            }

            do {
               this.C++;
               if (this.C == b.j[this.B]) {
                  this.C = 0;
               }

               this.aW = this.aI[this.h[151 + this.B] + this.C];
               this.aX = this.aI[this.h[146 + this.B] + this.C];
            } while (this.a());

            this.cp();
            return;
         case 4:
            if (this.o) {
               return;
            }

            do {
               this.C--;
               if (this.C < 0) {
                  this.C = (byte)(b.j[this.B] - 1);
               }

               this.aW = this.aI[this.h[151 + this.B] + this.C];
               this.aX = this.aI[this.h[146 + this.B] + this.C];
            } while (this.a());

            this.cp();
            return;
      }
   }

   final boolean a() {
      if (this.aX != 2 || this.K != 1 || (this.C != 2 || this.a[0][23]) && (this.C != 5 || this.a[1][26])) {
         if (this.aX <= 1 || this.aX == 3 && this.aW == 13 && !this.a[0][22]) {
            if (this.aX < 2) {
               if (this.K == 0) {
                  return false;
               }

               if (this.a[this.aX][this.aW]) {
                  return false;
               }
            }

            return true;
         } else {
            return false;
         }
      } else {
         return true;
      }
   }

   final void bl() {
      this.e = true;
      this.d = 0;
      this.j = -1;
      if (this.aX == 1) {
         this.au = (byte)(-1 - this.aW);
      }

      this.co();
      if (this.aX == 0 && this.aW == 22) {
         this.j = 0;
         this.B = b.a[this.at][this.j][1];
         this.C = b.b[this.at][this.j][1];
      }

      this.az = 0;
      this.b = 0;
      this.aa = 5;
   }

   final void bm() {
      this.k = this.k - this.i;
      this.e = this.e + this.i;
      this.n = true;
      this.aT[0] = (byte)this.a[0];
      this.aT[1] = (byte)this.a[1];
      this.h = (short)(b.B[0] / 2);
      this.i = 0;
      this.a.delete(0, this.a.length());
      this.a.append("-");
      this.a.append(this.i);
      this.b = this.a.toString();
      this.dM();
      this.e[this.C]++;
      this.e[b.j[3]] = (short)(this.e[b.j[3]] + this.i);
   }

   final void bn() {
      this.az = 0;
      if (!this.o) {
         this.b = 0;
      } else {
         this.b = 3;
         this.cv();
         this.o = false;
      }

      this.aa = 5;
      this.p = false;
   }

   final void bo() {
      switch (this.n) {
         case -7:
            this.bG();
         case -5:
         case -4:
         case -3:
         case -2:
         case -1:
         case 0:
         default:
            break;
         case 1:
            this.bs();
            return;
         case 2:
            this.bt();
            return;
         case 3:
            this.bp();
            return;
         case 4:
            this.bq();
            return;
         case 5:
            if (!this.p && this.v[this.R] > 0) {
               if (this.a[this.R][this.P] == 11) {
                  if (this.y[this.aI[this.h[92] + this.R] - 1] < 10) {
                     this.y[this.aI[this.h[92] + this.R] - 1]++;
                     this.cv();
                     return;
                  }
                  break;
               } else {
                  if (this.a[this.R][this.P] == 10) {
                     this.m = !this.m;
                     this.cv();
                     return;
                  }

                  if (this.a[this.R][this.P] == 112) {
                     this.br();
                     return;
                  }

                  if (this.a[this.R][this.P] == 12) {
                     this.bu();
                     return;
                  }
               }
            }
         case -6:
            if (!this.p) {
               this.bv();
               return;
            }
      }
   }

   final void bp() {
      if (!this.p && this.v[this.R] > 0) {
         if (this.a[this.R][this.P] == 11 && this.y[this.aI[this.h[92] + this.R] - 1] < 10) {
            this.y[this.aI[this.h[92] + this.R] - 1]++;
            this.cv();
            return;
         }

         if (this.a[this.R][this.P] == 10) {
            this.m = !this.m;
            this.cv();
            return;
         }

         if (this.a[this.R][this.P] == 112) {
            this.br();
            return;
         }

         if (this.R == 26 && !this.d) {
            this.P++;
            if (this.P == 4 && this.K == 0) {
               this.P++;
            }

            if (this.P >= this.v[this.R] || this.K == 1 && this.P >= this.v[this.R] - 1) {
               this.P = 0;
            }

            this.cv();
         }
      }
   }

   final void bq() {
      if (!this.p && this.v[this.R] > 0) {
         if (this.a[this.R][this.P] == 11 && this.y[this.aI[this.h[92] + this.R] - 1] > 1) {
            this.y[this.aI[this.h[92] + this.R] - 1]--;
            this.cv();
            return;
         }

         if (this.a[this.R][this.P] == 10) {
            this.m = !this.m;
            this.cv();
            return;
         }

         if (this.a[this.R][this.P] == 112) {
            this.br();
            return;
         }

         if (this.R == 26 && !this.d) {
            this.P--;
            if (this.P == 4 && this.K == 0) {
               this.P--;
            }

            if (this.P < 0) {
               if (this.K == 1) {
                  this.P = (byte)(this.v[this.R] - 2);
               } else {
                  this.P = (byte)(this.v[this.R] - 1);
               }
            }

            this.cv();
         }
      }
   }

   final void br() {
      this.aJ = (byte)((this.aJ + 1) % 2);
      this.a.a(this.aJ, (this.aJ + 1) % 2);
      this.cv();
      this.aK = this.aJ;
   }

   final void bs() {
      if (!this.p) {
         if (this.R == 2 || this.R == 5 || this.R == 3 || this.R == 10 && this.K == 0) {
            if (this.F > 0) {
               this.F = this.F - d.j[this.aC];
            }

            if (this.F < 0) {
               this.F = 0;
               return;
            }
         } else if (this.R != 26 && this.v[this.R] > 0) {
            if (this.R == 21) {
               this.P++;
               if (this.P >= this.v[this.R]) {
                  this.P = 0;
                  return;
               }
            } else {
               this.P--;
               if (this.P < 0) {
                  this.P = (byte)(this.v[this.R] - 1);
               }

               if (this.w && this.a[this.R][this.P] == 4) {
                  this.P--;
               }
            }
         }
      }
   }

   final void bt() {
      if (!this.p) {
         if (this.R == 2 || this.R == 5 || this.R == 3 || this.R == 10 && this.K == 0) {
            if (this.G > this.F + d.j[this.aC]) {
               this.F = this.F + d.j[this.aC];
               return;
            }
         } else if (this.R != 26 && this.v[this.R] > 0) {
            if (this.R != 21) {
               this.P++;
               if (this.P >= this.v[this.R]) {
                  this.P = 0;
               }

               if (this.w && this.a[this.R][this.P] == 4) {
                  this.P++;
                  return;
               }
            } else {
               this.P--;
               if (this.P < 0) {
                  this.P = (byte)(this.v[this.R] - 1);
               }
            }
         }
      }
   }

   final void bu() {
      this.i = this.aI[this.h[131] + this.aI[this.h[56] + this.an]];
      if (this.n) {
         this.az = 0;
         this.R = 20;
         this.x[0] = 2;
         this.y[0] = (byte)this.i;
         this.w[this.R] = this.aI[this.h[137] + this.aI[this.h[56] + this.an]];
         this.cu();
         this.aa = 5;
      } else {
         this.b = 2;
         this.aa = 5;
         this.C = this.U;
         this.B = 3;
         this.aW = this.aI[this.h[151 + this.B] + this.C];
         this.aX = this.aI[this.h[146 + this.B] + this.C];
         this.o = true;
         this.cp();
      }
   }

   final void bv() {
      if (this.R == 5) {
         this.bw();
      } else if (this.R == 9) {
         if (this.P > 0) {
            this.dH();
         }

         this.a = this.a + this.a[this.P];
         this.R = 15;
         this.cu();
      } else if (this.R == 7) {
         this.N = this.P;
         this.R = 17;
         this.cu();
      } else if (this.R == 12 || this.R == 13 || this.d && this.R == 26) {
         if (this.L > 0 && !this.d) {
            this.R = 26;
            this.P = 4;
            this.cv();
            this.d = true;
         } else {
            if (this.e[0][0] >= this.e[0][1] || this.L == 0 && this.R == 12) {
               if (this.b > 0) {
                  this.g = this.g / this.b;
               }

               this.R = 11;
            } else {
               this.R = 14;
            }

            this.cu();
            this.d = false;
         }
      } else if (this.R == 14) {
         this.R = 10;
         this.cu();
      } else if (this.R == 15) {
         this.br();
         this.R = 0;
         this.cu();
      } else if (this.R == 16) {
         this.f();
      } else if (this.R == 11) {
         this.bx();
      } else if (this.R == 10) {
         this.az = 0;
         this.g();
         this.aa = 5;
         this.b = 0;
      } else if (this.v[this.R] != 0) {
         if (this.a[this.R][this.P] == 5) {
            this.by();
         } else if (this.a[this.R][this.P] == 40) {
            this.S = this.R;
            this.R = 5;
            this.aA = 22;
            this.cv();
         } else if (this.a[this.R][this.P] == 0 || this.a[this.R][this.P] == 1) {
            this.bC();
         } else if (this.a[this.R][this.P] == 2) {
            this.S = this.R;
            this.Q = this.P;
            this.R = 4;
            this.cu();
         } else if (this.a[this.R][this.P] == 21) {
            if (this.R == 1) {
               this.az = 0;
               this.b = 0;
            } else {
               this.ea();
            }

            this.aa = 5;
         } else if (this.a[this.R][this.P] == 22) {
            this.bB();
         } else if (this.a[this.R][this.P] == 3) {
            this.cD();
         } else if (this.a[this.R][this.P] == 95) {
            this.R = 3;
            this.cv();
         } else if (this.a[this.R][this.P] == 107) {
            try {
               if (this.a.platformRequest(this.a.getAppProperty(this.a))) {
                  this.S = 0;
                  this.R = 5;
                  this.aA = 40;
                  this.cv();
               }
            } catch (Exception var2) {
            }
         } else if (this.a[this.R][this.P] == 6) {
            this.T = this.R;
            this.S = this.R;
            this.R = 5;
            this.aA = 16;
            this.cv();
         } else if (this.a[this.R][this.P] == 4) {
            this.S = this.R;
            this.R = 5;
            this.aA = 15;
            this.cv();
         } else {
            if (this.a[this.R][this.P] == 11) {
               if (this.y[this.aI[this.h[92] + this.R] - 1] < 10) {
                  this.y[this.aI[this.h[92] + this.R] - 1]++;
                  this.cv();
                  return;
               }
            } else {
               if (this.a[this.R][this.P] == 10) {
                  this.m = !this.m;
                  this.cv();
                  return;
               }

               if (this.a[this.R][this.P] == 12) {
                  this.bu();
                  return;
               }

               if (this.R == 17) {
                  this.bz();
                  return;
               }

               if (this.R == 8) {
                  this.bA();
                  return;
               }

               if (this.R == 20 || this.a[this.R][this.P] == 13) {
                  this.bF();
               }
            }
         }
      }
   }

   final void bw() {
      if (this.aA != 40) {
         if (this.aA == 15) {
            this.ea();
            this.aa = 5;
         } else if (this.aA == 16) {
            this.dS();
            if (this.y) {
               this.aA = 19;
            } else {
               this.aA = 18;
            }

            this.l = true;
            this.cv();
         } else if (this.aA == 22) {
            this.d();
         } else {
            if (this.aA == 14) {
               this.F = -1;
               this.H = -1;
            }

            this.R = this.T;
            this.cu();
         }
      }
   }

   final void bx() {
      if (this.K == 0) {
         this.R = 0;
      } else if (this.L + 1 >= this.a[8].length) {
         this.cD();
      } else {
         this.L++;
         this.F = this.L;
         this.G = this.M;
         if (this.E <= this.L) {
            this.E = (byte)(this.L + 1);
         }

         this.dT();
         this.R = 10;
         this.w[10] = this.n[this.L];
      }

      this.cu();
   }

   final void by() {
      if (this.R == 1) {
         if (this.l) {
            this.R = 0;
            this.cu();
            return;
         }

         this.T = 0;
         this.S = this.R;
         this.R = 5;
         this.aA = 17;
         this.cv();
      }
   }

   final void bz() {
      this.M = (byte)(this.a[this.R][this.P] - 8);
      if (this.K == 0) {
         this.R = 10;
         this.w[10] = this.a[7][this.N];
         this.cu();
      } else {
         this.R = 8;
         this.v[8] = this.E;
         this.cu();
         this.P = (byte)(this.v[8] - 1);
      }
   }

   final void bA() {
      this.L = this.P;
      this.F = this.P;
      this.G = this.M;
      this.dT();
      if (this.L == 0) {
         this.az = 0;
         this.g();
         this.aa = 5;
         this.b = 0;
      } else {
         this.R = 10;
         this.w[10] = this.n[this.L];
         this.cu();
      }
   }

   final void bB() {
      if (this.K == 1) {
         this.T = 17;
         this.S = this.R;
         this.R = 5;
         this.aA = 14;
         this.cv();
      } else {
         this.R = 7;
         this.cu();
      }
   }

   final void bC() {
      this.K = this.a[this.R][this.P];
      this.L = 0;
      if ((this.K != 0 || this.J == -1) && (this.K != 1 || this.F == -1)) {
         if (this.K == 1) {
            this.R = 17;
         } else {
            this.R = 7;
         }
      } else {
         this.R = 6;
      }

      this.cu();
   }

   final void bD() {
      this.az = 0;
      this.b = 0;
      if (this.R == 18) {
         this.c[this.c[this.a[0]][this.a[1]]] = this.m;
         this.al[this.Z[this.c[this.a[0]][this.a[1]]]] = this.y[2];
         this.o = this.Z[this.c[this.a[0]][this.a[1]]];
         this.cI();
         if (!this.m && this.Z[this.c[this.a[0]][this.a[1]]] != 22) {
            this.ax = this.c[this.a[0]][this.a[1]];
            this.d(true);
         }
      } else {
         this.bE();
      }

      this.aa = 5;
   }

   final void bE() {
      if (this.R == 19) {
         this.aE[this.aI[this.h[57] + this.an]] = this.y[1];
         this.o = this.an;
         this.cJ();
      }

      if (this.n) {
         this.C = this.aI[this.h[56] + this.an];
         this.B = 3;
         if (this.R == 21) {
            if (!this.a[this.c[this.a[0]][this.a[1]]]) {
               this.cj();
            }
         } else if (!this.d[this.c[this.a[0]][this.a[1]]]) {
            this.cj();
         }
      } else if (this.R == 21) {
         if (this.a[this.c[this.a[0]][this.a[1]]]) {
            this.cm();
         }
      } else {
         if (this.d[this.c[this.a[0]][this.a[1]]]) {
            this.cm();
         }

         if (this.R == 22) {
            this.bM();
         }
      }

      if (this.R == 21) {
         this.aE[this.aI[this.h[57] + this.an]] = this.y[0];
         this.o = 23;
         this.cI();
         this.c[this.c[this.a[0]][this.a[1]]] = this.m;
      }
   }

   final void bF() {
      if (this.k < this.i) {
         this.h = 0;
      }

      if (this.k - -500 >= this.i) {
         this.k = this.k - this.i;
         this.e = this.e + this.i;
         this.aT[0] = (byte)this.a[0];
         this.aT[1] = (byte)this.a[1];
         this.h = (short)(b.B[0] / 2);
         this.i = 0;
         this.a.delete(0, this.a.length());
         this.a.append("-");
         this.a.append(this.i);
         this.b = this.a.toString();
         this.dM();
         this.cm();
         this.aa = 5;
         if (this.U > 1) {
            this.n = false;
            if (this.U == 2) {
               this.R = 21;
            } else if (this.U == 5) {
               this.R = 22;
            } else {
               this.R = 19;
            }

            if (this.R == 19) {
               this.x[0] = 0;
            } else if (this.R == 21) {
               this.x[0] = 2;
            }

            if (this.R == 21) {
               this.y[0] = this.aE[this.aI[this.h[57] + this.an]];
            } else if (this.R == 19) {
               this.y[0] = this.aI[this.h[29] + this.an * (this.ad + 1) + this.ad];
            }

            this.cv();
            return;
         }

         this.az = 0;
         this.b = 0;
      }
   }

   final void bG() {
      if (this.R != 17 && this.R != 6 && this.R != 7 && this.R != 8 && this.R != 14 && this.R != 15) {
         if (this.R == 3) {
            this.R = 0;
            this.cv();
         } else if (this.R != 23 && this.R != 24 && this.R != 1 && (this.R != 26 || this.d) && (this.R != 25 || this.N != 0 && this.V >= 3)) {
            if (this.R == 25 && this.N == 1 && this.V >= 3) {
               this.b(12);
            } else if (this.R == 4) {
               this.P = this.Q;
               this.R = this.S;
               this.cv();
            } else if (this.R == 2) {
               this.b = this.c;
               this.R = this.S;
               if (this.b == 3) {
                  this.cv();
               }

               if (this.b == 2) {
                  this.cp();
               }

               this.aa = 5;
            } else if (this.R == 5 && this.aA != 18 && this.aA != 19) {
               this.R = this.S;
               this.cv();
            } else if (this.R == 20) {
               this.bH();
            } else if ((this.R == 18 || this.R == 19 || this.R == 22 || this.R == 21) && this.p) {
               this.az = 0;
               this.b = 0;
               this.aa = 5;
               this.p = false;
            } else if (this.R != 18 && this.R != 19 && this.R != 21 && this.R != 22) {
               if (this.R == 0 && this.c[this.v[0] - 1] == 107) {
                  this.S = this.R;
                  this.R = 5;
                  this.aA = 22;
                  this.cv();
               }
            } else {
               this.bD();
            }
         } else {
            this.az = 0;
            if (this.R == 24 && this.e) {
               this.aX = this.aZ;
               this.aW = this.aY;
               this.ct();
               this.at = this.ba;
               if (this.aX == 0 && this.aW == 22) {
                  this.B = b.a[this.at][this.j][1];
                  this.C = b.b[this.at][this.j][1];
               }
            }

            this.b = 0;
            this.aa = 5;
         }
      } else {
         if (this.R == 15) {
            this.aJ = 0;
         }

         this.aK = this.aJ;
         this.R = 0;
         this.cu();
      }
   }

   final void bH() {
      this.aa = 5;
      if (this.U > 1) {
         if (this.U == 2) {
            this.R = 21;
         } else if (this.U == 5) {
            this.R = 22;
         } else {
            this.R = 19;
         }

         if (this.R == 19) {
            this.x[0] = 0;
         } else if (this.R == 21) {
            this.x[0] = 2;
         }

         if (this.R == 21) {
            this.y[0] = this.aE[this.aI[this.h[57] + this.an]];
         } else if (this.R == 19) {
            this.y[0] = this.aI[this.h[29] + this.an * (this.ad + 1) + this.ad];
         }

         this.cv();
      } else {
         this.az = 0;
         this.b = 0;
      }
   }

   final void bI() {
      switch (this.n) {
         case -7:
         case 5:
            this.b = 0;
            this.aa = 5;
            break;
         case 3:
            if (this.aO < 2 && this.n[this.aO + 1] < this.n[this.aO]) {
               this.aO++;
               return;
            }
            break;
         case 4:
            if (this.aO > 0 && this.n[this.aO - 1] > this.n[this.aO]) {
               this.aO--;
               return;
            }
      }
   }

   final void bJ() {
      switch (this.n) {
         case -6:
         case 5:
            this.b = 0;
            this.aa = 5;
            break;
         case 1:
            if (this.F > 0) {
               this.F = this.F - d.j[this.aC];
            }

            if (this.F < 0) {
               this.F = 0;
               return;
            }
            break;
         case 2:
            if (this.G > this.F + d.j[this.aC]) {
               this.F = this.F + d.j[this.aC];
               return;
            }
      }
   }

   final void bK() {
      if (this.a[0] > 0) {
         if (this.b[this.a[0] - 1][this.a[1]] == 7) {
            this.as = this.c[this.a[0] - 1][this.a[1]];
            this.bP();
         } else if (this.b[this.a[0] - 1][this.a[1]] <= -15 && this.b[this.a[0] - 1][this.a[1]] >= -27) {
            this.aw = this.c[this.a[0] - 1][this.a[1]];
            this.a[0]--;
            this.bO();
            this.a[0]++;
         }
      }

      if (this.a[1] < this.O - 1) {
         if (this.b[this.a[0]][this.a[1] + 1] == 8) {
            this.as = this.c[this.a[0]][this.a[1] + 1];
            this.bP();
            return;
         }

         if (this.b[this.a[0]][this.a[1] + 1] <= -15 && this.b[this.a[0]][this.a[1] + 1] >= -27) {
            this.aw = this.c[this.a[0]][this.a[1] + 1];
            this.a[1]++;
            this.bO();
            this.a[1]--;
         }
      }
   }

   final void bL() {
      for (this.ar = 0; this.ar < 42; this.ar++) {
         if (this.l[0][this.ar] >= 0 && this.Z[this.ar] == 22) {
            this.as = this.ar;
            this.bP();
         }
      }
   }

   final void bM() {
      for (this.ar = 0; this.ar < 42; this.ar++) {
         if (this.l[0][this.ar] >= 0) {
            if (this.o[this.Z[this.ar]][this.g[this.Z[this.ar]][4] + 3] == 1) {
               this.as = this.ar;
               this.bN();
            } else {
               this.b[this.ar] = true;
            }
         }
      }
   }

   final void bN() {
      try {
         this.b[this.as] = false;

         for (this.aq = 0; this.aq < 15; this.aq++) {
            if (this.k[this.aq][0] >= 0 && this.d[this.c[this.k[this.aq][0]][this.k[this.aq][1]]]) {
               this.b[this.as] = true;
               if (this.k[this.aq][0] - b.j[0][0] >= this.l[0][this.as] + this.o[this.Z[this.as]][this.g[this.Z[this.as]][0]]
                  || this.k[this.aq][1] - b.j[1][0] >= this.l[1][this.as] + this.o[this.Z[this.as]][this.g[this.Z[this.as]][0] + 1]
                  || this.k[this.aq][0] + b.j[0][1] < this.l[0][this.as]
                  || this.k[this.aq][1] + b.j[1][1] < this.l[1][this.as]) {
                  this.b[this.as] = false;
               }

               if (this.b[this.as]) {
                  break;
               }
            }
         }

         if (!this.b[this.as]) {
            this.ax = (byte)this.as;
            this.d(true);
            if (this.ag[this.as] == 3) {
               if (this.af[this.as] < this.av[this.Z[this.as]]) {
                  this.aj[this.as] = 0;
               } else {
                  this.aj[this.as] = 1;
               }
            }
         }
      } catch (Exception var2) {
      }
   }

   final void bO() {
      this.f[this.aw] = false;
      if (this.aI[this.h[163] - 1 - this.b[this.a[0]][this.a[1]]] == 1 || this.aI[this.h[164] - 1 - this.b[this.a[0]][this.a[1]]] == 1) {
         this.f[this.aw] = true;
         if (this.a[0] < this.O - 1 && this.aI[this.h[163] - 1 - this.b[this.a[0]][this.a[1]]] == 1 && this.b[this.a[0] + 1][this.a[1]] == 0) {
            this.f[this.aw] = false;
         }

         if (this.a[1] > 0 && this.aI[this.h[164] - 1 - this.b[this.a[0]][this.a[1]]] == 1 && this.b[this.a[0]][this.a[1] - 1] == 0) {
            this.f[this.aw] = false;
         }
      }
   }

   final void bP() {
      if (this.Z[this.as] != 22) {
         this.a[this.as] = false;
         if (this.aa[this.as] == 0) {
            if (this.b[this.n[0][this.as]][this.n[1][this.as] - 1] == 0) {
               this.a[this.as] = true;
               return;
            }
         } else if (this.b[this.n[0][this.as] + 1][this.n[1][this.as]] == 0) {
            this.a[this.as] = true;
            return;
         }
      } else {
         this.a[this.as] = false;
         if (this.m[0][this.as] == 0) {
            return;
         }

         this.p[0] = this.l[0][this.as];
         this.p[1] = this.l[1][this.as];
         if (this.b[this.p[0]][this.p[1]] != 13) {
            this.p[1]++;
         }

         this.ad[this.as] = 1;
         this.q[0] = -1;
         this.bQ();
         this.ad[this.as] = (byte)(this.ad[this.as] + 5);
      }
   }

   final void bQ() {
      do {
         for (this.aq = 0; this.aq < 4; this.aq++) {
            if (this.p[0] + this.aI[this.h[31] + this.aq * 2] < this.O
               && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] < this.O
               && this.p[0] + this.aI[this.h[31] + this.aq * 2] >= 0
               && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] >= 0) {
               if ((this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] != 7 || this.aq != 1)
                  && (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] != 8 || this.aq != 0)) {
                  if (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] != 13
                     || this.p[0] + this.aI[this.h[31] + this.aq * 2] == this.q[0] && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] == this.q[1]) {
                     continue;
                  }

                  this.q[0] = this.p[0];
                  this.q[1] = this.p[1];
                  this.p[0] = this.p[0] + this.aI[this.h[31] + this.aq * 2];
                  this.p[1] = this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1];
                  this.c[this.p[0]][this.p[1]] = (byte)this.as;
                  if (this.ad[this.as] < 20) {
                     this.ad[this.as]++;
                  }
                  break;
               }

               if (this.m[0][this.c[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]]] == 0) {
                  this.l[0][this.c[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]]] = -1;
                  this.ai--;
               } else {
                  this.m[1][this.c[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]]] = 0;
               }

               this.c[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] = (byte)this.as;
               this.m[1][this.as] = 1;
               if (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2] * 2][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] * 2] == 0) {
                  this.a[this.as] = true;
               }

               this.aq = 4;
               break;
            }
         }

         if (this.aq == 4) {
            return;
         }
      } while (!this.a[this.as]);
   }

   final void bR() {
      this.i = true;
      this.aA = 5;
      this.U = -1;
      if (this.b[this.a[0]][this.a[1]] > 3 && this.b[this.a[0]][this.a[1]] <= 13) {
         this.bS();
         if (this.ar == 22) {
            this.j = false;
            if (this.c[this.a[0]][this.a[1]] < 0) {
               return;
            }

            if (this.Z[this.c[this.a[0]][this.a[1]]] == 22 && this.a[this.c[this.a[0]][this.a[1]]]) {
               this.bT();
               return;
            }

            return;
         }

         if (this.ac[this.c[this.a[0]][this.a[1]]] > 0) {
            this.i = false;
            return;
         }

         for (this.at = this.l[0][this.c[this.a[0]][this.a[1]]];
            this.at < this.l[0][this.c[this.a[0]][this.a[1]]] + this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0]];
            this.at++
         ) {
            for (this.au = this.l[1][this.c[this.a[0]][this.a[1]]];
               this.au
                  < this.l[1][this.c[this.a[0]][this.a[1]]] + this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0] + 1];
               this.au++
            ) {
               if (this.c[this.at][this.au] != -1
                  && this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][37]
                        + (
                              this.aa[this.c[this.a[0]][this.a[1]]]
                                    * this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0]]
                                 + this.at
                                 - this.l[0][this.c[this.a[0]][this.a[1]]]
                           )
                           * this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0] + 1]
                        + this.au
                        - this.l[1][this.c[this.a[0]][this.a[1]]]]
                     != 1) {
                  if (this.ar != 23 || this.A[this.c[this.at][this.au]] != 10 || this.d[this.c[this.at][this.au]] != -1) {
                     this.i = false;
                     return;
                  }

                  this.U = 2;
                  this.j = this.c[this.at][this.au];
               }
            }
         }
      } else {
         if (this.b[this.a[0]][this.a[1]] == 0) {
            this.bV();
            return;
         }

         if (this.b[this.a[0]][this.a[1]] < 0) {
            this.bW();
            return;
         }
      }
   }

   final void bS() {
      this.ar = -1;
      if (this.b[this.a[0]][this.a[1]] == 13) {
         this.ar = 22;
      }

      if ((this.b[this.a[0]][this.a[1]] == 5 || this.b[this.a[0]][this.a[1]] == 7) && this.b[this.a[0] - 1][this.a[1]] == 13) {
         this.ar = 22;
      }

      if ((this.b[this.a[0]][this.a[1]] == 6 || this.b[this.a[0]][this.a[1]] == 8) && this.b[this.a[0]][this.a[1] + 1] == 13) {
         this.ar = 22;
      }

      if (this.ar == -1) {
         this.ar = this.Z[this.c[this.a[0]][this.a[1]]];
      }
   }

   final void bT() {
      this.p[0] = this.l[0][this.c[this.a[0]][this.a[1]]];
      this.p[1] = this.l[1][this.c[this.a[0]][this.a[1]]];
      if (this.b[this.p[0]][this.p[1]] != 13) {
         if (this.c[this.p[0]][this.p[1]] != -1) {
            this.i = false;
         }

         if (this.p[0] == this.a[0] && this.p[1] == this.a[1]) {
            this.j = true;
         }

         this.p[1]++;
      } else {
         if (this.c[this.p[0] + 1][this.p[1]] != -1) {
            this.i = false;
         }

         if (this.p[0] + 1 == this.a[0] && this.p[1] == this.a[1]) {
            this.j = true;
         }
      }

      this.q[0] = -1;
      this.bU();
   }

   final void bU() {
      do {
         if (this.c[this.p[0]][this.p[1]] != -1) {
            this.i = false;
         }

         if (this.p[0] == this.a[0] && this.p[1] == this.a[1]) {
            this.j = true;
         }

         for (this.aq = 0; this.aq < 4; this.aq++) {
            if (this.p[0] + this.aI[this.h[31] + this.aq * 2] < this.O
               && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] < this.O
               && this.p[0] + this.aI[this.h[31] + this.aq * 2] >= 0
               && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] >= 0) {
               if (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 7 && this.aq == 1
                  || this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 8 && this.aq == 0) {
                  if (this.c[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] != -1) {
                     this.i = false;
                  }

                  if (this.p[0] + this.aI[this.h[31] + this.aq * 2] == this.a[0] && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] == this.a[1]) {
                     this.j = true;
                  }

                  this.aq = 4;
                  break;
               }

               if (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 13
                  && (this.p[0] + this.aI[this.h[31] + this.aq * 2] != this.q[0] || this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] != this.q[1])) {
                  this.q[0] = this.p[0];
                  this.q[1] = this.p[1];
                  this.p[0] = this.p[0] + this.aI[this.h[31] + this.aq * 2];
                  this.p[1] = this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1];
                  break;
               }
            }
         }
      } while (this.aq != 4);

      if (!this.j) {
         this.i = true;
      }
   }

   final void bV() {
      if (this.c[this.a[0]][this.a[1]] != -1) {
         this.i = false;
      }

      if (this.c[this.a[0]][this.a[1]] % 4 == 0) {
         if (this.a[0] > 0 && (this.b[this.a[0] - 1][this.a[1]] == 5 || this.b[this.a[0] - 1][this.a[1]] == 7)) {
            this.a[0]--;
            this.bR();
            this.a[0]++;
         }

         if (this.a[1] < this.O - 1 && (this.b[this.a[0]][this.a[1] + 1] == 6 || this.b[this.a[0]][this.a[1] + 1] == 8)) {
            this.a[1]++;
            this.bR();
            this.a[1]--;
         }

         if (this.a[0] == this.ab && this.a[1] == 0) {
            this.aA = 8;
            this.i = false;
         }
      }
   }

   final void bW() {
      for (this.at = 0; this.at < 2; this.at++) {
         if ((this.at != 0 || this.a[0] < this.O - 1)
            && (this.at != 1 || this.a[1] > 0)
            && this.aI[this.h[163 + this.at] - 1 - this.b[this.a[0]][this.a[1]]] != 0) {
            for (this.au = this.c[this.a[0] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.at] * 4 + 2] * 2]][this.a[1]
                  + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.at] * 4 + 2] * 2 + 1]];
               this.au >= 0;
               this.au = this.d[this.au]
            ) {
               if (this.au < 200
                  && this.W[this.au] == this.aI[this.h[53] + -1 - this.b[this.a[0]][this.a[1]]]
                  && this.h[2][this.au] == this.at
                  && this.h[0][this.au] < 2) {
                  this.i = false;
                  if (this.h[0][this.au] == 0) {
                     this.aA = 10;
                  }
                  break;
               }
            }

            if (!this.i) {
               break;
            }
         }
      }

      if (this.aI[this.h[56] + -1 - this.b[this.a[0]][this.a[1]]] != -1 && this.d[this.c[this.a[0]][this.a[1]]]) {
         this.U = this.aI[this.h[56] + -1 - this.b[this.a[0]][this.a[1]]];
      }
   }

   final void bX() {
      if (this.b[this.a[0]][this.a[1]] > 3 && this.b[this.a[0]][this.a[1]] <= 13) {
         if (this.ar != 22) {
            this.ca();
         } else {
            this.bY();
         }

         this.aa = 5;
      } else if (this.b[this.a[0]][this.a[1]] == 0) {
         if (this.c[this.a[0]][this.a[1]] % 4 != 0) {
            this.c[this.a[0]][this.a[1]] = (byte)(this.c[this.a[0]][this.a[1]] - this.c[this.a[0]][this.a[1]] % 4);
         } else {
            this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
            this.c[this.a[0]][this.a[1]] = 0;
            this.bK();
            this.aa = 5;
         }
      } else {
         if (this.b[this.a[0]][this.a[1]] < 0) {
            this.bZ();
         }
      }
   }

   final void bY() {
      if (this.j) {
         this.a[this.c[this.a[0]][this.a[1]]] = false;
      }

      if (this.b[this.a[0]][this.a[1]] == 5 || this.b[this.a[0]][this.a[1]] == 7) {
         this.b[this.a[0] - 1][this.a[1]] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
         this.c[this.a[0] - 1][this.a[1]] = 0;
         this.aw = this.a[0];
         this.ax = this.a[1];
         this.cb();
      } else if (this.b[this.a[0]][this.a[1]] != 6 && this.b[this.a[0]][this.a[1]] != 8) {
         if (this.b[this.a[0]][this.a[1]] == 13 && this.a[0] < this.O - 1 && (this.b[this.a[0] + 1][this.a[1]] == 5 || this.b[this.a[0] + 1][this.a[1]] == 7)) {
            this.aw = this.a[0] + 1;
            this.ax = this.a[1];
            this.cb();
            this.b[this.a[0] + 1][this.a[1]] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
            this.c[this.a[0] + 1][this.a[1]] = 0;
         }

         if (this.b[this.a[0]][this.a[1]] == 13 && this.a[1] > 0 && (this.b[this.a[0]][this.a[1] - 1] == 6 || this.b[this.a[0]][this.a[1] - 1] == 8)) {
            this.aw = this.a[0];
            this.ax = this.a[1] - 1;
            this.cb();
            this.b[this.a[0]][this.a[1] - 1] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
            this.c[this.a[0]][this.a[1] - 1] = 0;
         }
      } else {
         this.b[this.a[0]][this.a[1] + 1] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
         this.c[this.a[0]][this.a[1] + 1] = 0;
         this.aw = this.a[0];
         this.ax = this.a[1];
         this.cb();
      }

      this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
      this.c[this.a[0]][this.a[1]] = 0;
   }

   final void bZ() {
      if (this.b[this.a[0]][this.a[1]] <= -15) {
         this.ak[this.c[this.a[0]][this.a[1]]] = -1;
         this.ak--;
      }

      if (this.b[this.a[0]][this.a[1]] <= -27) {
         for (this.av = 0; this.av < 15; this.av++) {
            if ((this.a[0] == this.k[this.av][0] || this.a[0] - 1 == this.k[this.av][0])
               && (this.a[1] == this.k[this.av][1] || this.a[1] - 1 == this.k[this.av][1])
               && this.k[this.av][0] >= 0) {
               for (this.at = this.k[this.av][0]; this.at < this.k[this.av][0] + 2; this.at++) {
                  for (this.au = this.k[this.av][1]; this.au < this.k[this.av][1] + 2; this.au++) {
                     this.b[this.at][this.au] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
                     this.c[this.at][this.au] = 0;
                  }
               }

               this.k[this.av][0] = -1;
               this.ah--;
               break;
            }
         }

         this.bM();
      } else {
         if (this.b[this.a[0]][this.a[1]] == -14) {
            for (this.av = 0; this.av < 30; this.av++) {
               if (this.i[this.av][0] == this.a[0] && this.i[this.av][1] == this.a[1]) {
                  this.i[this.av][0] = -1;
                  this.ag--;
                  break;
               }
            }
         }

         this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
         this.c[this.a[0]][this.a[1]] = 0;
      }

      this.aa = 5;
   }

   final void ca() {
      this.e = this.c[this.a[0]][this.a[1]];
      this.ai--;

      for (this.at = this.l[0][this.e]; this.at < this.l[0][this.e] + this.o[this.ar][this.g[this.ar][0]]; this.at++) {
         for (this.au = this.l[1][this.e]; this.au < this.l[1][this.e] + this.o[this.ar][this.g[this.ar][0] + 1]; this.au++) {
            if (this.o[this.ar][this.g[this.ar][37]
                  + (this.aa[this.e] * this.o[this.ar][this.g[this.ar][0]] + this.at - this.l[0][this.e]) * this.o[this.ar][this.g[this.ar][0] + 1]
                  + this.au
                  - this.l[1][this.e]]
               != 1) {
               this.b[this.at][this.au] = (byte)((this.a.nextInt() & 65535) % 3 + 1);
               this.c[this.at][this.au] = 0;
            }
         }
      }

      this.dy();
      this.l[0][this.e] = -1;
   }

   final void cb() {
      if (this.b[this.aw][this.ax] != 5 && this.b[this.aw][this.ax] != 6) {
         this.m[1][this.c[this.aw][this.ax]] = 0;
      } else {
         this.m[0][this.c[this.aw][this.ax]] = 0;
         if (this.m[1][this.c[this.aw][this.ax]] != 0) {
            this.l[0][this.c[this.aw][this.ax]] = this.n[0][this.c[this.aw][this.ax]];
            this.l[1][this.c[this.aw][this.ax]] = this.n[1][this.c[this.aw][this.ax]];
         }
      }

      if (this.m[0][this.c[this.aw][this.ax]] == 0 && this.m[1][this.c[this.aw][this.ax]] == 0) {
         this.ai--;
         this.l[0][this.c[this.aw][this.ax]] = -1;
         this.dy();
      }
   }

   final void cc() {
      if (this.aX == 0) {
         this.cd();
         this.ce();
         if (this.o[this.Z[this.ay]][this.g[this.Z[this.ay]][4] + 3] == 1) {
            this.bN();
         } else {
            this.b[this.ay] = true;
         }

         if (this.Z[this.ay] == 23) {
            this.ag[this.ay] = 3;
            this.a[this.ay] = false;
         } else if (this.aD[this.Z[this.ay]] == 0) {
            this.aD[this.Z[this.ay]] = (byte)(this.aA[this.Z[this.ay]] / b.au[0]);
            this.aD[24] = (byte)(this.aD[24] + this.aD[this.Z[this.ay]]);
         }

         this.aa = 5;
      } else if (this.aX == 1) {
         this.cf();
         this.cg();
      } else if (this.aX == 2) {
         this.e[this.C]++;
         this.e[b.j[3]] = (short)(this.e[b.j[3]] + this.aI[this.h[131] + this.C]);
         this.cj();
      } else if (this.aX == 3) {
         this.ch();
      }

      this.ci();
   }

   final void cd() {
      if (this.j < 1 || !this.k) {
         this.ay = 0;

         while (this.ay < 42 && this.l[0][this.ay] >= 0) {
            this.ay++;
         }

         this.ai++;
         this.Z[this.ay] = this.aW;
         this.aa[this.ay] = this.at;
         this.l[0][this.ay] = (byte)this.a[0];
         this.l[1][this.ay] = (byte)this.a[1];
         this.ab[this.ay] = 0;
         this.ac[this.ay] = 0;
         this.ad[this.ay] = 0;
         if (this.aa[this.ay] == 0) {
            this.ae[this.ay] = (byte)(this.l[1][this.ay] + this.o[this.Z[this.ay]][this.g[this.Z[this.ay]][0] + 1] - 1);
         } else {
            this.ae[this.ay] = this.l[0][this.ay];
         }

         this.k = true;
         this.m[0][this.ay] = 0;
         this.m[1][this.ay] = 0;
      }

      if (this.j >= 0) {
         this.az = b.a[this.at][this.j][0];
      } else {
         this.az = 0;
      }
   }

   final void ce() {
      while (this.az < this.B) {
         if (this.j >= 0) {
            this.aA = b.b[this.at][this.j][0];
         } else {
            this.aA = 0;
         }

         for (; this.aA < this.C; this.aA++) {
            if (this.o[this.aW][this.g[this.aW][37]
                  + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.az) * this.o[this.aW][this.g[this.aW][0] + 1]
                  + this.aA]
               != 1) {
               this.b[this.a[0] + this.az][this.a[1] + this.aA] = this.o[this.aW][this.g[this.aW][37]
                  + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.az) * this.o[this.aW][this.g[this.aW][0] + 1]
                  + this.aA];
               if (this.b[this.a[0] + this.az][this.a[1] + this.aA] == 7 || this.b[this.a[0] + this.az][this.a[1] + this.aA] == 8) {
                  this.n[0][this.ay] = (byte)(this.a[0] + this.az);
                  this.n[1][this.ay] = (byte)(this.a[1] + this.aA);
               }

               if (this.b[this.a[0] + this.az][this.a[1] + this.aA] == 10) {
                  this.m[0][this.ay] = (byte)(this.a[0] + this.az);
                  this.m[1][this.ay] = (byte)(this.a[1] + this.aA);
               }

               this.c[this.a[0] + this.az][this.a[1] + this.aA] = (byte)this.ay;
            }
         }

         this.az++;
      }

      this.ah[this.ay] = 100;
      this.ai[this.ay] = 0;
      this.aj[this.ay] = -1;
      this.ag[this.ay] = 0;
      this.c[this.ay] = true;
      this.a[this.ay] = true;
      this.as = this.ay;
      if (this.Z[this.ay] != 23 && this.Z[this.ay] != 22) {
         this.bP();
      }

      if (this.Z[this.ay] == 22) {
         this.m[this.j][this.ay] = 1;
         this.bL();
      }
   }

   final void cf() {
      if (this.au > -15) {
         this.b[this.a[0]][this.a[1]] = this.au;
      } else {
         this.ay = 0;

         while (this.ay < 90 && this.ak[this.ay] >= 0) {
            this.ay++;
         }

         for (this.az = 0; this.az < this.B; this.az++) {
            for (this.aA = 0; this.aA < this.C; this.aA++) {
               this.b[this.a[0] + this.az][this.a[1] + this.aA] = this.au;
               if (this.au == -27) {
                  this.b[this.a[0] + this.az][this.a[1] + this.aA] = b.i[this.az][this.aA];
               }

               this.c[this.a[0] + this.az][this.a[1] + this.aA] = (byte)this.ay;
            }
         }

         if (this.au != -21 && this.au != -22 && this.au != -20) {
            this.d[this.ay] = false;
            this.e[this.ay] = true;
         } else {
            this.d[this.ay] = true;
            this.e[this.ay] = false;
         }

         this.ak[this.ay] = 0;
         this.aw = (byte)this.ay;
         this.bO();
         this.ak++;
      }
   }

   final void cg() {
      if (this.au == -14) {
         this.ay = 0;

         while (this.ay < 30 && this.i[this.ay][0] >= 0) {
            this.ay++;
         }

         this.i[this.ay][0] = (byte)this.a[0];
         this.i[this.ay][1] = (byte)this.a[1];
         this.ag++;
      }

      if (this.au == -27) {
         this.ay = 0;

         while (this.ay < 15 && this.k[this.ay][0] >= 0) {
            this.ay++;
         }

         this.k[this.ay][0] = (byte)this.a[0];
         this.k[this.ay][1] = (byte)this.a[1];
         this.ah++;
      }

      this.aa = 5;
   }

   final void ch() {
      if (this.aW == 13) {
         this.b[this.a[0]][this.a[1]] = this.aW;
         this.c[this.a[0]][this.a[1]] = -1;
         this.bL();
      } else {
         if (this.aW != 2 && this.aW != 1 && this.b[this.a[0]][this.a[1]] != 0) {
            this.c[this.a[0]][this.a[1]] = 0;
         }

         this.b[this.a[0]][this.a[1]] = 0;
         this.c[this.a[0]][this.a[1]] = (byte)(this.c[this.a[0]][this.a[1]] + this.aW + this.av);
         this.bK();
      }

      this.aa = 5;
   }

   final void ci() {
      this.dy();
      this.aT[0] = (byte)(this.b[0] + this.a[0]);
      this.aT[1] = (byte)(this.b[1] + this.a[1]);
      this.h = (short)(this.z / 2);
      this.i = 0;
      if (this.j < 0) {
         this.k = this.k - this.i;
         this.e = this.e + this.i;
         this.a.delete(0, this.a.length());
         this.a.append("-");
         this.a.append(this.i);
         this.b = this.a.toString();
      } else {
         this.k = this.k - this.i / 2;
         this.e = this.e + this.i / 2;
         this.a.delete(0, this.a.length());
         this.a.append("-");
         this.a.append(this.i / 2);
         this.b = this.a.toString();
      }

      this.dM();
      if (this.aX != 2) {
         for (this.Y = (byte)(this.a[0] / 5); this.Y <= (byte)((this.a[0] + this.B - 1) / 5); this.Y++) {
            for (this.Z = (byte)(this.a[1] / 5); this.Z <= (byte)((this.a[1] + this.C - 1) / 5); this.Z++) {
               this.cH();
            }
         }
      }

      if ((this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W < 0) {
         this.s();
      }

      if (this.K == 1 && this.L == 0 && this.j < 1) {
         this.cl();
      }
   }

   final void cj() {
      if (this.C < 3) {
         this.ck();
         this.ac++;
      } else {
         this.d[this.c[this.a[0]][this.a[1]]] = true;
         if (this.b[this.a[0]][this.a[1]] != -16
            && this.b[this.a[0]][this.a[1]] != -17
            && this.b[this.a[0]][this.a[1]] != -27
            && this.b[this.a[0]][this.a[1]] != -28) {
            this.e[this.c[this.a[0]][this.a[1]]] = false;
         }

         if (this.b[this.a[0]][this.a[1]] == -24 || this.b[this.a[0]][this.a[1]] == -25) {
            if (this.a[1] > 0 && this.b[this.a[0]][this.a[1] - 1] == 0) {
               this.b[this.a[0]][this.a[1]] = -25;
            }

            if (this.a[0] < this.O - 1 && this.b[this.a[0] + 1][this.a[1]] == 0) {
               this.b[this.a[0]][this.a[1]] = -24;
            }
         }

         if (this.b[this.a[0]][this.a[1]] == -27 || this.b[this.a[0]][this.a[1]] == -28) {
            this.bM();
         }

         this.aw = this.c[this.a[0]][this.a[1]];
         this.bO();
      }

      if (this.K == 1 && this.L == 0) {
         this.cl();
      }
   }

   final void ck() {
      this.ay = 200;

      while (this.ay < 222 && this.B[this.ay] >= 0) {
         this.ay++;
      }

      this.A[this.ay] = (byte)(8 + this.C);
      if (this.A[this.ay] == 10) {
         this.B[this.ay] = (byte)(this.l[0][this.c[this.a[0]][this.a[1]]] + this.aI[this.h[78]]);
         this.C[this.ay] = (byte)(this.l[1][this.c[this.a[0]][this.a[1]]] + this.aI[this.h[78] + 1]);
         this.F[this.ay] = 1;
         this.G[this.ay] = this.aI[this.h[78] + 2];
         this.H[this.ay] = this.aI[this.h[78] + 3];

         for (this.az = 0; this.az < 12; this.az++) {
            this.e[this.c[this.a[0]][this.a[1]]][this.az] = -1;
         }

         this.ag[this.c[this.a[0]][this.a[1]]] = 3;
         this.a[this.c[this.a[0]][this.a[1]]] = true;
      } else {
         this.B[this.ay] = (byte)this.a[0];
         this.C[this.ay] = (byte)this.a[1];
         this.F[this.ay] = 0;
         this.G[this.ay] = b.Z[0];
         this.H[this.ay] = 18;
      }

      this.I[this.ay] = 2;
      this.J[this.ay] = 0;
      this.W[this.ay] = -1;
      this.d[this.ay] = this.c[this.B[this.ay]][this.C[this.ay]];
      this.c[this.B[this.ay]][this.C[this.ay]] = (short)this.ay;
      if (this.A[this.ay] != 10) {
         this.aO = this.ay;
         this.dr();
      }
   }

   final void cl() {
      this.az = -1;
      if (this.aX < 2) {
         this.az = this.aW;
      }

      if (this.aX == 2) {
         this.az = this.C;
      }

      if (this.aX == 3 && this.aW < 10) {
         this.az = this.aW % 4;
      }

      if (this.az >= 0) {
         for (this.ay = 0; this.ay < this.b.length; this.ay++) {
            if (this.aI[this.h[140] + this.ay] == this.aX
               && (this.aI[this.h[141] + this.ay] == this.az || this.aI[this.h[141] + this.ay] == -1)
               && this.b[this.ay] == 0) {
               this.b[this.ay] = 1;
               return;
            }
         }
      }
   }

   final void cm() {
      if (this.U == 2) {
         this.a[this.c[this.a[0]][this.a[1]]] = false;

         for (this.ay = 200; this.ay < 222; this.ay++) {
            if (this.B[this.ay] >= 0 && this.A[this.ay] == 10 && this.c[this.a[0]][this.a[1]] == this.c[this.B[this.ay]][this.C[this.ay]]) {
               this.ac--;
               this.aB = this.ay;
               this.dq();
               this.B[this.ay] = -1;
               break;
            }
         }
      } else if (this.U < 2) {
         this.ac--;
         this.aB = this.j;
         this.dq();
         this.B[this.j] = -1;
      } else {
         this.d[this.c[this.a[0]][this.a[1]]] = false;
         this.e[this.c[this.a[0]][this.a[1]]] = true;
      }

      this.e[this.U]--;
      this.e[b.j[3]] = (short)(this.e[b.j[3]] - this.aI[this.h[131] + this.U]);
   }

   final void cn() {
      if (this.j >= 0 && this.j < 2) {
         this.j++;
         if (this.j < 2) {
            this.B = b.a[this.at][this.j][1];
            this.C = b.b[this.at][this.j][1];
         }

         if (this.j == 2) {
            this.B = 4;
            this.C = 2;
            this.aW = this.aI[this.h[151 + this.B] + this.C];
            this.aX = this.aI[this.h[146 + this.B] + this.C];
            this.i = this.aI[this.h[133] + this.aW];
            this.B = 1;
            this.C = 1;
            this.z = b.B[0];
            this.A = b.B[1];
            this.b[0] = 0;
            this.b[1] = 0;
            this.co();
            this.j = -1;
         }

         if (this.a[0] < 0) {
            this.a[0] = 0;

            for (this.q = 0; this.q < 4; this.q++) {
               this.f[this.q][0]++;
            }
         }

         if (this.a[1] < 0) {
            this.a[1] = 0;

            for (this.q = 0; this.q < 4; this.q++) {
               this.f[this.q][1]++;
            }
         }

         if (this.a[0] >= this.O - 1) {
            this.a[0] = this.O - 2;

            for (this.q = 0; this.q < 4; this.q++) {
               this.f[this.q][0]--;
            }
         }

         if (this.a[1] >= this.O - 1) {
            this.a[1] = this.O - 2;

            for (this.q = 0; this.q < 4; this.q++) {
               this.f[this.q][1]--;
            }
         }
      } else {
         this.e = false;
      }
   }

   final void co() {
      if (this.a[0] + this.B >= this.O) {
         this.a[0] = (byte)(this.O - this.B);
      }

      if (this.a[1] + this.C >= this.O) {
         this.a[1] = (byte)(this.O - this.C);
      }

      this.aC = (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + (this.z - this.l) / 2;
      this.aD = (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + (this.B - this.C + 2) * (b.B[1] / 2) / 2 - this.m / 2;
      this.aE = (this.aD / (b.B[1] / 2) + this.aC / (b.B[0] / 2)) / 2;
      this.aF = (this.aC / (b.B[0] / 2) - this.aD / (b.B[1] / 2)) / 2;

      for (this.aC = 0; this.aC < 4; this.aC++) {
         this.f[this.aC][0] = this.f[this.aC][0] + this.aE;
         this.f[this.aC][1] = this.f[this.aC][1] + this.aF;
      }
   }

   final void cp() {
      this.cq();
      if (this.aA >= 0) {
         if (!this.p) {
            this.aa = 5;
         }

         this.p = true;
         this.aC = 3;
         this.dI();
      } else {
         this.cr();
         this.a.delete(0, this.a.length());
         if (this.aX == 0) {
            if (this.aW != 23) {
               this.a.append(this.aA[this.aW] / 5);
            } else {
               this.a.append(b.aq[5]);
            }
         } else if (this.aX == 1) {
            if (this.aW >= 14) {
               this.a.append(this.aI[this.h[29] + this.aW * (this.ad + 1) + this.ad]);
            } else {
               this.a.append(this.aI[this.h[29] + this.aW * (this.ad + 1)]);
            }
         }

         this.b = this.a.toString();
         this.g = 0;
         this.h = d.n[3 + this.aI[this.h[132] + this.aX * 2 + 1]];
         this.i = (short)(105 - (b.b[1] - this.aI[this.h[74] + 10]) / 2);
         this.dN();
         this.ct();
      }
   }

   final void cq() {
      this.az = 1;
      this.aA = -1;
      switch (this.aX) {
         case 0:
            this.f = this.aI[this.h[135] + this.aW];
            if (this.ai >= 42) {
               this.aA = 0;
            }
            break;
         case 1:
            this.f = this.aI[this.h[136] + this.aW];
            if (-1 - this.aW <= -15 && this.ak >= 90) {
               this.aA = 1;
            }

            if (-1 - this.aW == -14 && this.ag >= 30) {
               this.aA = 2;
            }

            if (-1 - this.aW == -27 && this.ah >= 15) {
               this.aA = 3;
            }
            break;
         case 2:
            this.f = this.aI[this.h[137] + this.C];
            if (this.C < 3 && this.ac >= 22) {
               this.aA = 4;
            }
            break;
         case 3:
            this.f = this.aI[this.h[139] + this.aW];
      }

      this.g = 1;
      this.h = (short)(this.l / 2);
      this.i = 65;
      this.dL();
   }

   final void cr() {
      if (this.p) {
         this.aa = 5;
      }

      this.p = false;
      if (this.aX == 2) {
         this.f = this.aI[this.h[138] + this.C];
         this.g = 1;
         this.h = (short)(this.l / 2);
         this.i = 240;
         this.dL();
      }

      switch (this.aX) {
         case 0:
            this.i = this.az[this.aW] * 10;
            break;
         case 1:
            this.i = this.aI[this.h[58] + this.aW];
            break;
         case 2:
            this.i = this.aI[this.h[131] + this.C];
            break;
         case 3:
            this.i = this.aI[this.h[133] + this.aW];
      }

      this.a.delete(0, this.a.length());
      this.a.append(this.i);
      this.b = this.a.toString();
      this.g = 0;
      this.h = d.n[1 + this.aI[this.h[132] + this.aX * 2 + 1]];
      this.i = (short)(105 - (b.b[1] - this.aI[this.h[74] + 10]) / 2);
      this.dN();
      if (this.aX == 0) {
         this.a.delete(0, this.a.length());
         this.a.append(this.au[this.aW]);
         this.b = this.a.toString();
         this.g = 0;
         this.h = d.n[5 + this.aI[this.h[132] + this.aX * 2 + 1]];
         this.i = (short)(105 - (b.b[1] - this.aI[this.h[74] + 10]) / 2);
         this.dN();
      }
   }

   final void cs() {
      if (this.aX == 1 && this.aW == 26) {
         this.B = 2;
         this.C = 2;
      } else {
         this.B = 1;
         this.C = 1;
      }

      if (this.aX != 2) {
         this.z = (this.B + this.C) * b.B[0] / 2;
         this.A = (this.B + this.C) * b.B[1] / 2;
      } else {
         this.z = this.aI[this.h[51] + this.C];
         this.A = this.aI[this.h[52] + this.C];
      }

      this.x = 120 - this.z / 2;
      this.y = 230 - this.A / 2;
      if (this.aX == 1) {
         this.y = this.y - (this.C + 1) % 2 * b.B[1] / 2;
         this.A = this.A + (this.C + 1) % 2 * b.B[1] / 2;
      }

      this.b[0] = 0;
      this.b[1] = 0;
      if (this.aX == 1) {
         this.b[0] = -(this.C / 2);
         this.b[1] = this.C / 2;
      }
   }

   final void ct() {
      if (this.aX == 0) {
         this.B = this.o[this.aW][this.g[this.aW][0]];
         this.C = this.o[this.aW][this.g[this.aW][0] + 1];
         this.z = (this.B + this.C) * b.B[0] / 2;
         this.A = (this.B + this.C) * b.B[1] / 2;
         this.x = 120 - this.z / 2;
         this.y = d.o[this.aW] - this.A / 2;
         this.y = this.y - (this.C + 1) % 2 * b.B[1] / 2;
         this.A = this.A + (this.C + 1) % 2 * b.B[1] / 2;
         this.b[0] = -(this.C / 2);
         this.b[1] = this.C / 2;
         this.at = 0;
      } else {
         this.cs();
      }
   }

   final void cu() {
      this.P = 0;
      this.cv();
   }

   final void cv() {
      if (this.b == 3) {
         this.cw();
         this.cx();
         if (this.R == 26) {
            switch (this.P) {
               case 0:
               case 1:
               case 2:
               case 5:
                  for (this.aG = 0; this.aG < 2; this.aG++) {
                     this.a.delete(0, this.a.length());
                     if (this.aG == 0) {
                        if (this.P < 3) {
                           this.a.append(this.d[this.P][0]);
                        } else {
                           this.a.append(this.d[3][0]);
                        }
                     } else {
                        this.a.append(0);
                     }

                     this.b = this.a.toString();
                     this.g = 1;
                     this.h = d.l[this.aG];
                     this.i = d.m[this.aG];
                     this.dN();
                  }
                  break;
               case 3:
                  this.cy();
                  break;
               case 4:
                  this.cz();
            }
         }

         this.cA();
         this.cB();
         this.cC();
      }
   }

   final void cw() {
      this.az = this.aI[this.h[94] + this.R];
      if (this.R != 2) {
         if (this.R != 5) {
            this.aA = -1;
            switch (this.R) {
               case 18:
                  if (this.ar != 22 || this.c[this.a[0]][this.a[1]] >= 0 && this.a[this.c[this.a[0]][this.a[1]]]) {
                     if (!this.b[this.c[this.a[0]][this.a[1]]]) {
                        this.aA = 6;
                     } else if (!this.a[this.c[this.a[0]][this.a[1]]]) {
                        this.aA = 7;
                     } else if (this.ah[this.c[this.a[0]][this.a[1]]] < 10) {
                        this.aA = 11;
                     }
                  } else {
                     this.aA = 21;
                  }
                  break;
               case 19:
                  if (this.f[this.c[this.a[0]][this.a[1]]]) {
                     this.aA = 7;
                  }
            }
         }

         if (this.aA >= 0) {
            if (this.R != 5) {
               this.p = true;
            }

            this.aC = 3;
            this.dI();
         } else {
            this.p = false;
         }
      } else {
         this.p = false;
      }

      this.g = 1;
   }

   final void cx() {
      if (this.R == 1 && this.K == 0 && this.J == -1) {
         this.w = true;
      } else {
         this.w = false;
      }

      if (!this.p && this.R != 26 && (this.v[this.R] > 0 || this.R == 14 || this.R == 15 || this.R == 16 || this.R == 12 || this.R == 13)) {
         for (this.aG = 0; this.aG < this.a[this.R].length; this.aG++) {
            if (this.a[this.R][this.aG] != 11 && (this.a[this.R][this.aG] != 12 || !this.n)) {
               if (this.R == 8 && this.aG >= this.E) {
                  break;
               }

               if (!this.w || this.a[this.R][this.aG] != 4) {
                  this.f = this.a[this.R][this.aG];
                  if (this.a[this.R][this.aG] == 10 && !this.m) {
                     this.f++;
                  }

                  if (this.a[this.R][this.aG] == 112 && this.aJ > 0) {
                     this.f++;
                  }

                  if (this.R != 12 && this.R != 13) {
                     if (this.a[this.R][this.aG] == 12) {
                        this.i = d.p[this.R];
                     } else {
                        this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * this.aG);
                     }
                  } else {
                     this.i = (short)((this.m + b.c[this.R - 12][1]) / 2 + 3);
                  }

                  if (this.w) {
                     if (this.aG < 1) {
                        this.i = (short)(this.i + d.d[this.R][1] / 2);
                     } else {
                        this.i = (short)(this.i - d.d[this.R][1] / 2);
                     }
                  }

                  this.h = (short)(this.l / 2);
                  this.dL();
               }
            }
         }
      }

      if ((this.R != 2 || this.aA != 29) && this.w[this.R] != -1) {
         if (this.R != 26) {
            this.f = this.w[this.R];
         } else {
            this.f = this.k[this.P];
         }

         this.i = 65;
         this.h = (short)(this.l / 2);
         this.dL();
      }

      if (!this.p) {
         for (this.aG = 0; this.aG < this.aI[this.h[92] + this.R]; this.aG++) {
            this.a.delete(0, this.a.length());
            this.a.append(this.y[this.aG]);
            this.b = this.a.toString();
            this.g = 0;
            this.h = 153;
            this.i = (short)(d.e[this.R][this.aG] - b.b[0] / 2);
            this.dN();
         }
      }
   }

   final void cy() {
      for (this.aG = 0; this.aG < b.j[3] + 1; this.aG++) {
         this.a.delete(0, this.a.length());
         this.a.append(this.e[this.aG]);
         this.b = this.a.toString();
         this.g = 0;
         this.h = d.v[this.aG];
         this.i = d.w[this.aG];
         this.dN();
      }
   }

   final void cz() {
      this.ad();

      for (this.aG = 0; this.aG < 3; this.aG++) {
         this.a.delete(0, this.a.length());
         this.a.append(this.e[this.aG][0]);
         this.a.append("/");
         this.a.append(this.e[this.aG][1]);
         this.b = this.a.toString();
         this.g = 0;
         this.h = 70;
         this.i = (short)(d.z[this.aG] - b.b[0] / 2);
         this.dN();
      }
   }

   final void cA() {
      if (this.R == 23) {
         for (this.aG = 0; this.aG < 2; this.aG++) {
            this.a.delete(0, this.a.length());
            if (this.aG == 0) {
               this.a.append(this.f[2][this.j]);
            }

            if (this.aG == 1) {
               this.a.append(this.L[this.j]);
            }

            this.b = this.a.toString();
            this.g = 0;
            this.h = (short)(d.x[this.aG] + 7);
            this.i = (short)(d.y[this.aG] - b.b[0] / 2);
            this.dN();
         }
      }

      if (this.R == 10) {
         if (this.K == 1) {
            this.f = (byte)(8 + this.M);
            this.i = d.d[this.R][0];
            this.h = (short)(this.l / 2);
            this.dL();

            for (this.aG = 0; this.aG < 3; this.aG++) {
               this.a.delete(0, this.a.length());
               this.a.append(this.a[this.M][this.L][this.aG]);
               this.b = this.a.toString();
               this.g = 0;
               this.h = (short)(this.l / 2);
               this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * (this.aG + 1));
               this.dN();
            }
         } else {
            this.aA = (byte)(33 + this.N);
            this.aC = 0;
            this.dI();
         }
      }

      if (this.R == 3) {
         this.aA = 32;
         this.aC = 0;
         this.dI();
      }
   }

   final void cB() {
      if (this.R == 11) {
         this.h = (this.d * 2 - this.e + this.f * 5) * this.g / 10;
         if (this.h < 0) {
            this.h = 0;
         }

         for (this.aG = 0; this.aG < this.o.length; this.aG++) {
            this.g = 0;
            this.f = this.o[this.aG];
            this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * this.aG);
            this.h = (short)((this.l - d.A[0]) / 2 - 2);
            if (this.aG == this.o.length - 1) {
               this.i = (short)(this.i + 6);
            }

            this.dL();
            this.aH = this.d[this.az - 1];
            this.a.delete(0, this.a.length());
            if (this.aG == 0) {
               this.a.append(this.d);
            }

            if (this.aG == 1) {
               this.a.append(this.e);
            }

            if (this.aG == 2) {
               this.a.append(this.f);
            }

            if (this.aG == 3) {
               this.a.append(this.g);
            }

            if (this.aG == 4) {
               this.a.append(this.h);
            }

            this.b = this.a.toString();
            this.g = 2;
            this.h = (short)((this.l + d.A[0]) / 2 + 2);
            this.dN();

            while (this.d[this.az - 1] + this.aH < d.A[0]) {
               this.az--;
               this.b = "." + this.b;
               this.dN();
            }
         }
      }

      if (this.R == 20) {
         this.a.delete(0, this.a.length());
         this.a.append(this.aI[this.h[131] + this.U]);
         this.b = this.a.toString();
         this.g = 0;
         this.h = d.n[1];
         this.i = (short)(d.e[this.R][0] - b.b[0] / 2);
         this.dN();
      }

      if (this.R == 24) {
         if (this.aX == 0) {
            this.f = this.aI[this.h[135] + this.aW];
         }

         if (this.aX == 1) {
            this.f = this.aI[this.h[136] + this.aW];
         }

         this.g = 1;
         this.h = (short)(this.l / 2);
         this.i = 105;
         this.dL();
         this.ct();
      }
   }

   final void cC() {
      if (this.R == 25) {
         for (this.aG = 0; this.aG < this.u.length; this.h[0][this.aG] = this.aG++) {
            this.h[1][this.aG] = 0;

            for (this.aH = 0; this.aH < d.k[4]; this.aH++) {
               this.h[1][this.aG] = this.h[1][this.aG] + this.c[3 + this.aG][this.aH];
            }

            this.h[1][this.aG] = this.h[1][this.aG] / d.k[4];
         }

         for (this.aG = 0; this.aG < this.u.length - 1; this.aG++) {
            for (this.aH = this.aG + 1; this.aH < this.u.length; this.aH++) {
               if (this.h[1][this.aG] < this.h[1][this.aH]) {
                  this.aI = this.h[0][this.aG];
                  this.h[0][this.aG] = this.h[0][this.aH];
                  this.h[0][this.aH] = this.aI;
                  this.aI = this.h[1][this.aG];
                  this.h[1][this.aG] = this.h[1][this.aH];
                  this.h[1][this.aH] = this.aI;
               }
            }
         }

         for (this.aG = 0; this.aG < this.u.length; this.aG++) {
            this.g = 0;
            this.f = this.u[this.h[0][this.aG]];
            this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * this.aG);
            this.h = (short)((this.l - d.A[3]) / 2 + 13);
            this.dL();
            this.aH = this.d[this.az - 1] + 15;
            this.a.delete(0, this.a.length());
            this.a.append(this.h[1][this.aG]);
            this.b = this.a.toString();
            this.g = 2;
            this.h = (short)((this.l + d.A[0]) / 2 + 2);
            this.dN();

            while (this.d[this.az - 1] + this.aH < (d.A[3] + d.A[0]) / 2) {
               this.az--;
               this.b = "." + this.b;
               this.dN();
            }
         }
      }
   }

   final void cD() {
      this.c = this.b;
      if (this.b == 3 && this.R == 11) {
         this.S = 0;
         this.P = 0;
         this.aA = 29;
      } else {
         this.cE();
         this.S = this.R;
         this.aA = this.aI[this.h[171 + this.c] + this.aJ];
      }

      this.b = 3;
      this.R = 2;
      this.aC = 0;
      this.i[this.aA] = true;
      this.dI();
      this.cv();
      this.aa = 5;
   }

   final void cE() {
      this.aJ = 0;
      if (this.b == 2) {
         this.aJ = this.aI[this.h[175] + this.B] + this.C;
      }

      if (this.b == 3) {
         this.aJ = this.R;
         if (this.R == 26) {
            this.aJ = this.aJ + this.P;
         }
      }
   }

   final void cF() {
      this.a[this.a].drawRegion(this.c[2], b.i[0], b.i[1], b.i[2], b.i[3], 0, this.l - 40, 2, 20);
      if (this.c[2][d.k[4] + 1] == 0) {
         this.aK = 3;
      } else {
         this.aK = 5 - (this.c[1][d.k[4] + 1] - 1) / 2;
      }

      this.a[this.a]
         .drawRegion(
            this.c[2],
            this.aI[this.h[71] + this.aK],
            this.aI[this.h[72] + this.aK],
            this.aI[this.h[73] + this.aK],
            this.aI[this.h[74] + this.aK],
            0,
            this.l - 40 + (b.i[2] - this.aI[this.h[73] + this.aK]) / 2,
            2 + (b.i[3] - this.aI[this.h[74] + this.aK]) / 2,
            20
         );
   }

   final void cG() {
      this.a[this.a].drawRegion(this.c[2], 73, 0, 16, 13, 0, d.a[0], d.b[0], 20);
      this.j = 1;
      this.a.delete(0, this.a.length());
      this.a.append(this.k);
      this.b = this.a.toString();
      this.g = 0;
      this.h = d.a[1];
      this.i = d.b[1];
      if (this.az == 0) {
         this.dN();
      } else {
         this.k = 0;
         this.dO();
      }

      this.j = 0;
      if (this.h >= 0) {
         this.a[this.a].setColor(16711680);

         for (this.q = 0; this.q < 2; this.q++) {
            this.a[this.a].drawRect(d.a[0] - 2 - this.q, d.b[0] - 2 - this.q, d.a[1] + this.d[0] + this.q * 2 - d.a[0] + 3, 13 + this.q * 2 + 3);
         }

         this.h++;
         if (this.h >= this.u) {
            this.h = -1;
         }
      }
   }

   final void cH() {
      this.a[this.Y][this.Z] = 0;

      for (this.aL = this.Y * 5; this.aL < (this.Y + 1) * 5; this.aL++) {
         for (this.aM = this.Z * 5; this.aM < (this.Z + 1) * 5; this.aM++) {
            if (this.b[this.aL][this.aM] == 0) {
               this.a[this.Y][this.Z] = (short)(this.a[this.Y][this.Z] + b.as[this.c[this.aL][this.aM] / 4]);
               this.a[this.Y][this.Z] = (short)(this.a[this.Y][this.Z] + b.at[this.c[this.aL][this.aM] % 4]);
            } else if (this.b[this.aL][this.aM] < 0 && this.b[this.aL][this.aM] > -15) {
               this.a[this.Y][this.Z] = (short)(this.a[this.Y][this.Z] + this.aI[this.h[90] + -1 - this.b[this.aL][this.aM]]);
            }
         }
      }

      this.a[this.Y][this.Z] = (short)(this.a[this.Y][this.Z] / 3);
   }

   final void cI() {
      if (this.o != 23) {
         this.f[this.o] = (byte)(this.aA[this.o] / b.au[0] - this.al[this.o]);
         if (this.f[this.o] > 0) {
            this.f[this.o] = (short)(this.f[this.o] * 10);
         } else {
            this.f[this.o] = (short)(this.f[this.o] * 25);
         }
      } else {
         this.g[5] = (byte)(9 - this.aE[5]);
         if (this.g[5] > 0) {
            this.g[5] = (short)(this.g[5] * 10);
         } else {
            this.g[5] = (short)(this.g[5] * 25);
         }
      }
   }

   final void cJ() {
      if (this.aI[this.h[57] + this.o] >= 0) {
         this.g[this.aI[this.h[57] + this.o]] = 0;

         for (this.bb = 0; this.bb < this.ad; this.bb++) {
            this.g[this.aI[this.h[57] + this.o]] = (short)(
               this.g[this.aI[this.h[57] + this.o]] + this.aI[this.h[29] + this.o * (this.ad + 1) + this.bb] / b.au[this.bb]
            );
         }

         this.g[this.aI[this.h[57] + this.o]] = (short)(this.g[this.aI[this.h[57] + this.o]] - this.aE[this.aI[this.h[57] + this.o]]);
         if (this.g[this.aI[this.h[57] + this.o]] > 0) {
            this.g[this.aI[this.h[57] + this.o]] = (short)(this.g[this.aI[this.h[57] + this.o]] * 10);
         } else {
            this.g[this.aI[this.h[57] + this.o]] = (short)(this.g[this.aI[this.h[57] + this.o]] * 25);
         }
      }
   }

   protected final void keyPressed(int var1) {
      if (this.n == 0 && this.c) {
         try {
            if (var1 == -6 || var1 == 6 || var1 == 42) {
               this.n = -6;
            } else if (var1 == -7 || var1 == 7 || var1 == 35) {
               this.n = -7;
            } else if (var1 == 48) {
               this.n = 48;
            } else if (var1 == 55) {
               this.a = !this.a;
            } else {
               this.p = this.getGameAction(var1);
               if (this.p == 8 || var1 == 53) {
                  this.n = 5;
               } else if (this.p == 1 || var1 == 50) {
                  this.n = 1;
               } else if (this.p == 6 || var1 == 56) {
                  this.n = 2;
               } else if (this.p == 2 || var1 == 52) {
                  this.n = 4;
               } else if (this.p == 5 || var1 == 54) {
                  this.n = 3;
               }
            }

            this.q = false;
            this.aN = 0;
         } catch (Exception var3) {
         }
      }
   }

   protected final void keyReleased(int var1) {
      try {
         this.q = true;
         if (this.aN > 0) {
            this.n = 0;
         }

         this.aN = 0;
      } catch (Exception var3) {
      }
   }

   final void cK() {
      for (this.aO = 0; this.aO < 90; this.aO++) {
         if (this.ak[this.aO] >= 0) {
            this.ak[this.aO]++;
            if (this.ak[this.aO] > 100) {
               this.ak[this.aO] = 0;
            }
         }
      }
   }

   final void cL() {
      try {
         for (this.aO = 0; this.aO < 42; this.aO++) {
            if (this.l[0][this.aO] >= 0) {
               this.cM();
               this.cO();
               if (this.ag[this.aO] == 0 && this.Z[this.aO] != 22) {
                  this.af[this.aO]++;
                  if (this.ai[this.aO] == 2 && this.ac[this.aO] == 0) {
                     for (this.aP = 200; this.aP < 222; this.aP++) {
                        if (this.A[this.aP] == 9 && this.B[this.aP] == this.n[0][this.aO] && this.C[this.aP] == this.n[1][this.aO]) {
                           this.aB = this.aP;
                           this.dq();
                           this.d[this.aP] = -1;
                           this.c[this.m[0][this.aO]][this.m[1][this.aO]] = (short)this.aP;
                           this.ag[this.aO] = 4;
                           this.ai[this.aO] = 3;
                           this.af[this.aO] = 0;
                           break;
                        }
                     }
                  } else if ((this.ad[this.aO] <= 0 || this.Z[this.aO] == 14) && (this.Z[this.aO] != 14 || this.ad[this.aO] + this.ac[this.aO] <= 1)) {
                     if (this.ac[this.aO] > 0 && this.af[this.aO] >= this.aw[this.Z[this.aO]]) {
                        this.af[this.aO] = 0;
                        this.ag[this.aO] = 3;
                        if (!this.b[this.aO]) {
                           this.aj[this.aO] = 0;
                        }
                     }
                  } else {
                     this.cP();
                     this.af[this.aO] = 0;
                     this.ag[this.aO] = 1;
                  }

                  if (this.Z[this.aO] == 14 && this.af[this.aO] % 100 == 0 && this.ad[this.aO] == 1) {
                     this.ax = (byte)this.aO;
                     this.d(false);
                  }
               }

               this.cN();
            }
         }
      } catch (Exception var2) {
      }
   }

   final void cM() {
      if (this.ag[this.aO] == 1 || this.ag[this.aO] == 2) {
         this.af[this.aO]++;
         if (this.af[this.aO] == 5) {
            if (this.ag[this.aO] == 1) {
               this.aB = this.e[this.aO][this.ac[this.aO] - 1];
               this.dq();
               this.d[this.aB] = this.c[this.B[this.aB]][this.C[this.aB]];
               this.c[this.B[this.aB]][this.C[this.aB]] = (short)this.aB;
               if (this.ac[this.aO] != this.au[this.Z[this.aO]]) {
                  this.ag[this.aO] = 0;
                  return;
               }

               this.af[this.aO] = 0;
               this.ag[this.aO] = 3;
               if (!this.b[this.aO]) {
                  this.aj[this.aO] = 0;
                  return;
               }
            } else {
               this.af[this.aO] = 0;
               this.cR();
               if (this.ac[this.aO] == 0) {
                  if (this.ah[this.aO] < 10) {
                     this.ax = (byte)this.aO;
                     this.d(true);
                     this.bj = 1;
                     this.dD();
                  }

                  this.ag[this.aO] = 0;
                  this.aj[this.aO] = -1;
                  return;
               }

               this.aB = this.e[this.aO][this.ac[this.aO] - 1];
               this.dq();
            }
         }
      }
   }

   final void cN() {
      if (this.ag[this.aO] == 3) {
         this.af[this.aO]++;
         this.ab[this.aO]++;
         if (this.ab[this.aO] >= this.as[this.Z[this.aO]]) {
            this.ab[this.aO] = 0;
         }

         if (this.Z[this.aO] != 23) {
            if (this.af[this.aO] >= this.am[this.Z[this.aO]] - 1 || this.aj[this.aO] == 0) {
               this.ab[this.aO] = 0;
               this.af[this.aO] = 0;
               this.ag[this.aO] = 2;
               this.aB = this.e[this.aO][this.ac[this.aO] - 1];
               this.dq();
            }

            for (this.aP = 0; this.aP < this.ac[this.aO]; this.aP++) {
               this.c[this.e[this.aO][this.aP]] = this.ab[this.aO];
               if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 2] == 1) {
                  this.G[this.e[this.aO][this.aP]] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][21]
                     + this.ab[this.aO] % this.at[this.Z[this.aO]] * this.au[this.Z[this.aO]]
                     + (this.ab[this.aO] / this.at[this.Z[this.aO]] + this.aP) % this.au[this.Z[this.aO]]];
               }

               if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 3] == 1) {
                  this.H[this.e[this.aO][this.aP]] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][22]
                     + this.ab[this.aO] % this.at[this.Z[this.aO]] * this.au[this.Z[this.aO]]
                     + (this.ab[this.aO] / this.at[this.Z[this.aO]] + this.aP) % this.au[this.Z[this.aO]]];
               }

               if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 4] == 1) {
                  this.F[this.e[this.aO][this.aP]] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][23]
                     + this.ab[this.aO] % this.at[this.Z[this.aO]] * this.au[this.Z[this.aO]]
                     + (this.ab[this.aO] / this.at[this.Z[this.aO]] + this.aP) % this.au[this.Z[this.aO]]];
               }

               if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 5] == 1) {
                  this.J[this.e[this.aO][this.aP]] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][24]
                     + this.ab[this.aO] % this.at[this.Z[this.aO]] * this.au[this.Z[this.aO]]
                     + this.aP];
               }

               if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][3] + 2] == 0
                  && this.ag[this.aO] == 3
                  && (
                     this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + this.ab[this.aO] % this.at[this.Z[this.aO]] * 2] != 0
                        || this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + this.ab[this.aO] % this.at[this.Z[this.aO]] * 2 + 1] != 0
                  )) {
                  this.aB = this.e[this.aO][this.aP];
                  this.dq();
                  this.B[this.aB] = (byte)(
                     this.B[this.aB] + this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + this.ab[this.aO] % this.at[this.Z[this.aO]] * 2]
                  );
                  this.C[this.aB] = (byte)(
                     this.C[this.aB] + this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + this.ab[this.aO] % this.at[this.Z[this.aO]] * 2 + 1]
                  );
                  this.d[this.aB] = this.c[this.B[this.aB]][this.C[this.aB]];
                  this.c[this.B[this.aB]][this.C[this.aB]] = (short)this.aB;
               }
            }
         }
      }
   }

   final void cO() {
      if (this.ag[this.aO] == 4) {
         this.af[this.aO]++;
         if (this.af[this.aO] == this.l) {
            this.ag[this.aO] = 0;
            this.ai[this.aO] = 0;
            this.ah[this.aO] = 100;
            this.aB = this.c[this.m[0][this.aO]][this.m[1][this.aO]];
            this.c[this.n[0][this.aO]][this.n[1][this.aO]] = (short)this.aB;
            this.c[this.m[0][this.aO]][this.m[1][this.aO]] = -1;
            this.B[this.aB] = this.n[0][this.aO];
            this.C[this.aB] = this.n[1][this.aO];
            this.F[this.aB] = b.ao[this.aa[this.aO]];
            this.D[this.aB] = (byte)(this.B[this.aB] + this.aI[this.h[31] + this.F[this.aB] * 2]);
            this.E[this.aB] = (byte)(this.C[this.aB] + this.aI[this.h[31] + this.F[this.aB] * 2 + 1]);
            this.G[this.aB] = b.h[this.aa[this.aO]][0];
            this.H[this.aB] = b.h[this.aa[this.aO]][1];
            this.W[this.aB] = -1;
         }
      }
   }

   final void cP() {
      this.cQ();

      for (this.aR = 1; this.aR < this.ad[this.aO]; this.aR++) {
         this.W[this.f[this.aO][this.aR]] = 9;
      }

      this.aB = this.e[this.aO][this.ac[this.aO]];
      this.dq();
      this.B[this.aB] = (byte)(this.m[0][this.aO] + this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35]]);
      this.C[this.aB] = (byte)(this.m[1][this.aO] + this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + 1]);
      if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][4]] == 1) {
         this.G[this.aB] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][21] + this.ac[this.aO]];
         this.H[this.aB] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][22] + this.ac[this.aO]];
         this.F[this.aB] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][23] + this.ac[this.aO]];
         if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 5] == 1) {
            this.J[this.aB] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][24] + this.ac[this.aO]];
         } else {
            this.J[this.aB] = 0;
         }
      }

      this.ac[this.aO]++;
      this.ad[this.aO] = 0;
   }

   final void cQ() {
      this.P[this.f[this.aO][0]] = this.a(this.P[this.f[this.aO][0]] + this.f[this.Z[this.aO]]);
      this.aT[0] = this.B[this.f[this.aO][0]];
      this.aT[1] = this.C[this.f[this.aO][0]];
      this.h = (short)(
         (this.G[this.f[this.aO][0]] + this.H[this.f[this.aO][0]]) / b.Y[0]
            - this.aI[this.h[2] + this.A[this.f[this.aO][0]] * 12 + this.K[this.J[this.f[this.aO][0]]]] / 2
      );
      this.i = (short)(
         b.B[1] / 2 + (this.G[this.f[this.aO][0]] - this.H[this.f[this.aO][0]]) / b.Y[1] - this.aI[this.h[20] + this.A[this.f[this.aO][0]] * 4] - 15
      );
      this.k = this.k + this.b[this.f[this.aO][0]];
      this.d = this.d + this.b[this.f[this.aO][0]];
      this.L[this.f[this.aO][0]] = (byte)(this.L[this.f[this.aO][0]] - this.b[this.f[this.aO][0]]);
      this.a.delete(0, this.a.length());
      this.a.append("+");
      this.a.append(this.b[this.f[this.aO][0]]);
      this.b = this.a.toString();
      this.dM();
      this.b[this.f[this.aO][0]] = 0;
      this.e[this.aO][this.ac[this.aO]] = this.f[this.aO][0];
      this.c[this.e[this.aO][this.ac[this.aO]]] = 0;
      this.W[this.e[this.aO][this.ac[this.aO]]] = 13;
   }

   final void cR() {
      this.ac[this.aO]--;
      this.aB = this.e[this.aO][this.ac[this.aO]];
      this.dq();
      this.B[this.e[this.aO][this.ac[this.aO]]] = this.n[0][this.aO];
      this.C[this.e[this.aO][this.ac[this.aO]]] = this.n[1][this.aO];
      this.d[this.aB] = this.c[this.B[this.aB]][this.C[this.aB]];
      this.c[this.B[this.aB]][this.C[this.aB]] = (short)this.aB;
      this.W[this.aB] = -1;
      this.P[this.aB] = this.a(this.P[this.aB] + this.aA[this.Z[this.aO]] - b.ap[this.aj[this.aO] + 1]);
      this.F[this.aB] = b.ao[this.aa[this.aO]];
      this.D[this.aB] = (byte)(this.B[this.aB] + this.aI[this.h[31] + this.F[this.aB] * 2]);
      this.E[this.aB] = (byte)(this.C[this.aB] + this.aI[this.h[31] + this.F[this.aB] * 2 + 1]);
      this.G[this.aB] = b.h[this.aa[this.aO]][0];
      this.H[this.aB] = b.h[this.aa[this.aO]][1];
      if (this.aA[this.Z[this.aO]] >= 30 && (this.a.nextInt() & 65535) % 100 < this.aA[this.Z[this.aO]]) {
         this.O[this.aB] = 0;
      }

      this.ah[this.aO] = (byte)(this.ah[this.aO] - (this.a.nextInt() & 65535) % this.ay[this.Z[this.aO]] / (20 - 7 * this.M));
   }

   final void cS() {
      this.aU = 5 + (this.c[1][d.k[4] + 1] - 6 - this.M) * (this.b * (2 + this.M) / 3) + this.aD[24] * 15 / this.al;
      if (this.ai > 0 && this.a > 0 && this.a > this.ai * 5) {
         this.aU = this.aU / (this.a / (this.ai * 5));
      }

      if (this.aU < 3) {
         this.aU = 3;
      }

      if (this.aU > 80) {
         this.aU = 80;
      }

      if ((this.a.nextInt() & 4095) % 100 < this.aU) {
         for (this.aO = 0; this.aO < 200; this.aO++) {
            if (this.B[this.aO] < 0) {
               this.A[this.aO] = (byte)((this.a.nextInt() & 4095) % 8);
               this.B[this.aO] = this.ab;
               this.C[this.aO] = 0;
               this.D[this.aO] = this.ab;
               this.E[this.aO] = 1;
               this.F[this.aO] = 3;
               this.G[this.aO] = this.aI[this.h[36] + this.F[this.aO] * 2];
               this.H[this.aO] = -100;
               this.I[this.aO] = (byte)((this.a.nextInt() & 4095) % 4 + 1);
               this.J[this.aO] = 1;
               this.W[this.aO] = -1;
               this.L[this.aO] = (byte)(60 + (this.a.nextInt() & 65535) % 40 - 20);
               this.b[this.aO] = 0;
               this.R[this.aO] = (byte)((this.a.nextInt() & 65535) % 60);
               this.Q[this.aO] = (byte)((this.a.nextInt() & 65535) % 60);
               this.P[this.aO] = (byte)(100 - (this.a.nextInt() & 65535) % 20);
               this.S[this.aO] = (byte)((this.a.nextInt() & 65535) % 20);
               this.T[this.aO] = (byte)((this.a.nextInt() & 65535) % 60);
               this.U[this.aO] = (byte)(100 - (this.a.nextInt() & 65535) % 20);
               this.V[this.aO] = (byte)((this.a.nextInt() & 65535) % 20);
               this.M[this.aO] = -1;
               this.N[this.aO] = -1;
               this.O[this.aO] = -1;
               this.c[this.aO] = 0;
               this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
               this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
               this.f[0][this.aO] = -1;
               this.f[1][this.aO] = -1;
               this.f[2][this.aO] = 0;
               this.a++;
               this.f++;
               return;
            }
         }
      }
   }

   final void cT() {
      this.aB = this.aO;
      this.dq();
      this.B[this.aO] = -1;
      this.a--;
   }

   final void cU() {
      try {
         for (this.aO = 0; this.aO < 222; this.aO++) {
            if (this.B[this.aO] >= 0) {
               this.cV();
               if (this.W[this.aO] > -1 && this.W[this.aO] < 9) {
                  this.cW();
               } else {
                  this.df();
                  if (this.W[this.aO] < 11 || this.W[this.aO] == 18) {
                     this.dg();
                     if (this.A[this.aO] != 10) {
                        this.dh();
                     }
                  }

                  this.di();
                  if (this.W[this.aO] == 10 && this.b[this.D[this.aO]][this.E[this.aO]] != 13) {
                     if (this.b[this.D[this.aO]][this.E[this.aO]] == 7 && this.G[this.aO] > 15) {
                        this.G[this.aO] = 20;
                     }

                     if (this.b[this.D[this.aO]][this.E[this.aO]] == 8 && this.H[this.aO] < 4) {
                        this.H[this.aO] = -1;
                     }
                  }

                  if (this.W[this.aO] == 12 && this.c[this.aO] == 100) {
                     this.dj();
                     this.ac[this.c[this.B[this.aO]][this.C[this.aO]]]--;
                  } else {
                     this.dk();
                     this.dl();
                     this.dm();
                  }
               }
            }
         }
      } catch (Exception var2) {
      }
   }

   final void cV() {
      if (this.W[this.aO] != 13) {
         this.c[this.aO]++;
      }

      if (this.aO < 200) {
         if (this.O[this.aO] >= 0) {
            this.O[this.aO]++;
         }

         if (this.O[this.aO] >= this.v) {
            this.O[this.aO] = -1;
         }
      }

      if (this.aO < 200 && this.W[this.aO] != 13 && this.W[this.aO] != 18) {
         for (this.aP = 0; this.aP < this.ae; this.aP++) {
            this.aS = this.b[this.M][this.aP];
            if (this.aP == 0) {
               this.aS = this.aS + this.a[this.B[this.aO] / 5][this.C[this.aO] / 5];
            }

            if (this.c[this.aO] % this.aS == 0) {
               if (b.ar[this.aP] == 0 && this.g[this.aP][this.aO] > 0) {
                  this.g[this.aP][this.aO]--;
               }

               if (b.ar[this.aP] == 1 && this.g[this.aP][this.aO] < 100) {
                  this.g[this.aP][this.aO]++;
               }
            }
         }

         if (this.c[this.aO] % this.q == 0) {
            this.e(true);
         }
      }
   }

   final void cW() {
      if (this.W[this.aO] < 7) {
         this.dd();
      } else {
         if (this.W[this.aO] == 7 || this.W[this.aO] == 8) {
            this.G[this.aO] = (byte)(this.G[this.aO] + this.aI[this.h[31] + this.X[this.aO] * 2] * this.I[this.aO]);
            this.H[this.aO] = (byte)(this.H[this.aO] + this.aI[this.h[31] + this.X[this.aO] * 2 + 1] * this.I[this.aO]);
            this.J[this.aO]++;
            if (this.J[this.aO] > 3) {
               this.J[this.aO] = 0;
            }

            if (this.W[this.aO] == 7) {
               this.de();
               return;
            }

            if (this.W[this.aO] == 8) {
               this.aP = (this.H[this.aO] - this.aI[this.h[35] + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1])
                  * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]];
               if (this.aP >= 0) {
                  this.H[this.aO] = this.aI[this.h[35] + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1];
                  this.X[this.aO] = this.aI[this.h[35] + this.h[1][this.aO] * 4 + 3];
                  this.H[this.aO] = (byte)(this.H[this.aO] + this.aP * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]]);
                  this.h[1][this.aO]++;
                  if (this.h[1][this.aO] == 4) {
                     this.db();
                     return;
                  }
               }

               this.dc();
            }
         }
      }
   }

   final void cX() {
      if (this.aP >= 0) {
         this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] = this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]]
            + this.aT * 16
            + this.h[1][this.aO] * 4
            + this.aI[this.h[104] + this.X[this.aO]]
            + 1];
         this.X[this.aO] = this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]] + this.aT * 16 + this.h[1][this.aO] * 4 + 3];
         this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] = (byte)(
            this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO]
               + this.aP * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]]
         );
         this.h[1][this.aO]++;
         if (this.h[0][this.aO] == 0 && this.h[1][this.aO] == this.r[this.h[2][this.aO]][this.aT] + this.aI[this.h[102] + this.W[this.aO]]) {
            this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] = this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]]
               + this.aT * 16
               + (this.h[1][this.aO] - 1) * 4
               + this.aI[this.h[104] + this.X[this.aO]]
               + 1];
            this.h[1][this.aO] = 0;
            this.h[0][this.aO]++;
            this.c[this.aO] = 0;
            this.J[this.aO] = 0;
            this.cY();
            return;
         }

         if (this.h[0][this.aO] == 2) {
            this.W[this.aO] = -1;
            this.F[this.aO] = this.X[this.aO];
         }
      }
   }

   final void cY() {
      if (this.W[this.aO] == 6
         && this.e[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO]
            + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]]) {
         this.X[this.aO] = this.aI[this.h[30] + this.X[this.aO] * 4 + 2];
         this.h[1][this.aO] = 0;
         this.h[0][this.aO]++;
      } else if (this.W[this.aO] == 4 || this.W[this.aO] == 6) {
         this.e[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO]
            + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]] = true;
      }

      if (this.W[this.aO] == 4) {
         this.d[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO]
            + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]] = false;
      }

      if (this.W[this.aO] == 1) {
         this.aS = this.c[this.B[this.aO]][this.C[this.aO]];
         this.aT = 0;

         do {
            if (this.G[this.aS] == this.aI[this.h[11] + this.h[2][this.aO] * 4]
               && this.H[this.aS] == this.aI[this.h[11] + this.h[2][this.aO] * 4 + 1]
               && this.aS != this.aO) {
               this.aT++;
               break;
            }

            this.aS = this.d[this.aS];
         } while (this.aS >= 0);

         this.G[this.aO] = this.aI[this.h[11] + this.h[2][this.aO] * 4 + this.aT * 2];
         this.H[this.aO] = this.aI[this.h[11] + this.h[2][this.aO] * 4 + this.aT * 2 + 1];
      }
   }

   final void cZ() {
      if (this.c[this.aO] >= this.aI[this.h[this.q[1][0]] + this.W[this.aO] * 4 + 1]) {
         if (this.W[this.aO] != 1) {
            this.bd = this.b[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO]
               + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]];
            if (this.W[this.aO] == 4 || this.W[this.aO] == 6) {
               this.e[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO]
                  + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]] = false;
            }

            if (this.W[this.aO] == 4) {
               this.d[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO]
                  + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]] = true;
            }

            for (this.aP = 0; this.aP < this.ad; this.aP++) {
               if (b.ar[this.aP] == 0) {
                  this.g[this.aP][this.aO] = this.a(this.g[this.aP][this.aO] + this.aI[this.h[29] + (-1 - this.bd) * (this.ad + 1) + this.aP]);
               } else {
                  this.g[this.aP][this.aO] = this.a(this.g[this.aP][this.aO] - this.aI[this.h[29] + (-1 - this.bd) * (this.ad + 1) + this.aP]);
               }
            }

            if (this.W[this.aO] == 5) {
               this.M[this.aO] = (byte)((this.a.nextInt() & 65535) % 5);
            }
         }

         this.X[this.aO] = this.aI[this.h[30] + this.X[this.aO] * 4 + 2];
         this.h[1][this.aO] = 0;
         this.h[0][this.aO]++;
         if (this.W[this.aO] == 1) {
            this.Q[this.aO] = (byte)(this.Q[this.aO] - 50);
            if (this.h[2][this.aO] == 0) {
               this.H[this.aO] = this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]] + this.F[this.aO] * 16 + this.h[1][this.aO] * 4 + 2];
               return;
            }

            this.G[this.aO] = this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]] + this.F[this.aO] * 16 + this.h[1][this.aO] * 4 + 1];
         }
      }
   }

   final void da() {
      if (this.b[this.aO] > 0 && this.h[0][this.aO] != 1) {
         this.aT[0] = this.B[this.aO];
         this.aT[1] = this.C[this.aO];
         this.h = (short)((this.G[this.aO] + this.H[this.aO]) / b.Y[0] - this.aI[this.h[2] + this.A[this.aO] * 12 + this.K[this.J[this.aO]]] / 2);
         this.i = (short)(b.B[1] / 2 + (this.G[this.aO] - this.H[this.aO]) / b.Y[1] - this.aI[this.h[20] + this.A[this.aO] * 4] - 15);
         this.L[this.aO] = (byte)(this.L[this.aO] - this.b[this.aO]);
         this.k = this.k + this.b[this.aO];
         this.d = this.d + this.b[this.aO];
         this.a.delete(0, this.a.length());
         this.a.append("+");
         this.a.append(this.b[this.aO]);
         this.b = this.a.toString();
         this.b[this.aO] = 0;
         this.dM();
         this.P[this.aO] = this.a(
            this.P[this.aO]
               + this.g[this.aI[this.h[57]
                  + -1
                  - this.b[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4 + 2] * 2]][this.C[this.aO]
                     + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4 + 2] * 2 + 1]]]]
         );
      }
   }

   final void db() {
      this.W[this.aO] = -1;
      this.F[this.aO] = 1;
      this.J[this.aO] = 0;
      this.c[this.aO] = 1;
      this.G[this.aO] = this.aI[this.h[78] + 2];
      this.H[this.aO] = this.aI[this.h[78] + 3];
      this.aB = this.aO;
      this.dq();
      this.B[this.aO] = (byte)(this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]] + this.aI[this.h[78]]);
      this.C[this.aO] = (byte)(this.l[1][this.c[this.B[this.aO]][this.C[this.aO]]] + this.aI[this.h[78] + 1]);
      this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
      this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
   }

   final void dc() {
      if (this.G[this.aO] >= 20 || this.H[this.aO] >= 20 || this.G[this.aO] < 0 || this.H[this.aO] < 0) {
         this.G[this.aO] = (byte)(this.G[this.aO] - 20 * this.aI[this.h[31] + this.X[this.aO] * 2]);
         this.H[this.aO] = (byte)(this.H[this.aO] - 20 * this.aI[this.h[31] + this.X[this.aO] * 2 + 1]);
         this.aB = this.aO;
         this.dq();
         this.B[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.X[this.aO] * 2]);
         this.C[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.X[this.aO] * 2 + 1]);
         this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
         this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
      }
   }

   final void dd() {
      if (this.h[0][this.aO] != 1) {
         this.aT = this.F[this.aO];
      } else {
         this.aT = 0;
      }

      if (this.h[0][this.aO] != 1) {
         this.G[this.aO] = (byte)(this.G[this.aO] + this.aI[this.h[31] + this.X[this.aO] * 2] * this.I[this.aO]);
         this.H[this.aO] = (byte)(this.H[this.aO] + this.aI[this.h[31] + this.X[this.aO] * 2 + 1] * this.I[this.aO]);
         this.J[this.aO]++;
         if (this.J[this.aO] > 3) {
            this.J[this.aO] = 0;
         }

         this.aP = (
               this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO]
                  - this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]]
                     + this.aT * 16
                     + this.h[1][this.aO] * 4
                     + this.aI[this.h[104] + this.X[this.aO]]
                     + 1]
            )
            * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]];
         this.cX();
      } else {
         this.cZ();
         this.da();
      }
   }

   final void de() {
      this.aP = (
            this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO]
               - this.aI[this.h[this.aK[this.h[2][this.aO]]] + this.F[this.aO] * 12 + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1]
         )
         * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]];
      if (this.aP >= 0) {
         this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] = this.aI[this.h[this.aK[this.h[2][this.aO]]]
            + this.F[this.aO] * 12
            + this.h[1][this.aO] * 4
            + this.aI[this.h[104] + this.X[this.aO]]
            + 1];
         this.X[this.aO] = this.aI[this.h[this.aK[this.h[2][this.aO]]] + this.F[this.aO] * 12 + this.h[1][this.aO] * 4 + 3];
         this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] = (byte)(
            this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO]
               + this.aP * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]]
         );
         this.h[1][this.aO]++;
         if (this.h[1][this.aO] == this.r[this.h[2][this.aO]][this.F[this.aO]]) {
            this.W[this.aO] = -1;
            this.F[this.aO] = this.X[this.aO];
         }
      }
   }

   final void df() {
      if (this.g / 4 == 0 && this.e == 0 && this.W[this.aO] == -1 && this.aO < 200) {
         this.dz();
      }

      if (this.W[this.aO] == 9) {
         if (this.Z[this.c[this.B[this.aO]][this.C[this.aO]]] != 23) {
            if (this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] == 0) {
               this.aP = this.G[this.aO] - 4;
               if (this.C[this.aO] != this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] || this.H[this.aO] != 10) {
                  this.aP = this.aP + ((this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] - this.C[this.aO]) * 20 + 10 - this.H[this.aO]);
               }
            } else {
               this.aP = 19 - this.H[this.aO] - 4;
               if (this.B[this.aO] != this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] || this.G[this.aO] != 10) {
                  this.aP = this.aP + (this.B[this.aO] - this.ae[this.c[this.B[this.aO]][this.C[this.aO]]]) * 20 - 10 + this.G[this.aO];
               }
            }

            if (this.ad[this.c[this.B[this.aO]][this.C[this.aO]]] * 6 >= this.aP) {
               this.dt();
               return;
            }
         } else {
            if (this.b[this.B[this.aO]][this.C[this.aO]] == 5 && this.G[this.aO] < 6) {
               this.G[this.aO] = -1;
            }

            if (this.b[this.B[this.aO]][this.C[this.aO]] == 6 && this.H[this.aO] > 13) {
               this.H[this.aO] = 20;
            }
         }
      }
   }

   final void dg() {
      if (this.A[this.aO] != 10) {
         if (this.W[this.aO] == 10) {
            this.J[this.aO] = 0;
            this.G[this.aO] = (byte)(this.G[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2] * 2);
            this.H[this.aO] = (byte)(this.H[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2 + 1] * 2);
            return;
         }

         this.G[this.aO] = (byte)(this.G[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2] * this.I[this.aO]);
         this.H[this.aO] = (byte)(this.H[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2 + 1] * this.I[this.aO]);
         this.J[this.aO]++;
         if (this.J[this.aO] > 3) {
            this.J[this.aO] = 0;
            return;
         }
      } else if (this.ac[this.c[this.B[this.aO]][this.C[this.aO]]] > 0 && this.c[this.aO] % this.aw[23] == 0) {
         this.W[this.aO] = 8;
         this.h[1][this.aO] = 0;
         this.X[this.aO] = 0;
         this.G[this.aO] = this.aI[this.h[79] + 2];
         this.H[this.aO] = this.aI[this.h[79] + 3];
         this.aB = this.aO;
         this.dq();
         this.B[this.aO] = (byte)(this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]] + this.aI[this.h[79]]);
         this.C[this.aO] = (byte)(this.l[1][this.c[this.B[this.aO]][this.C[this.aO]]] + this.aI[this.h[79] + 1]);
         this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
         this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
      }
   }

   final void dh() {
      if (this.W[this.aO] != -1 && this.W[this.aO] != 18) {
         this.aP = (this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] - 10)
            * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
         if (this.aP >= 0) {
            if (this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2] == this.D[this.aO]
               && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2 + 1] == this.E[this.aO]) {
               this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = 10;
               this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 1];
               this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = (byte)(
                  this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO]
                     + this.aP * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]
               );
            }

            if (this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2] == this.D[this.aO]
               && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2 + 1] == this.E[this.aO]) {
               this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = 10;
               this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 3];
               this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = (byte)(
                  this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO]
                     + this.aP * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]
               );
            }
         }
      } else {
         this.aP = (
               this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] - this.aI[this.h[12] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]
            )
            * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
         if (this.aP >= 0
            && this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2] == this.D[this.aO]
            && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2 + 1] == this.E[this.aO]) {
            this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = this.aI[this.h[12] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
            this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 1];
            this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = (byte)(
               this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO]
                  + this.aP * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]
            );
         }

         this.aP = (
               this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] - this.aI[this.h[12] + 8 + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]
            )
            * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
         if (this.aP >= 0
            && (
               this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2] == this.D[this.aO]
                     && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2 + 1] == this.E[this.aO]
                  || this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2] == this.D[this.aO]
                     && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2 + 1] == this.E[this.aO]
                  || this.D[this.aO] < 0
            )) {
            this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = this.aI[this.h[12] + 8 + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
            this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 3];
            this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = (byte)(
               this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO]
                  + this.aP * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]
            );
            if (this.D[this.aO] < 0) {
               this.dr();
               return;
            }
         }
      }
   }

   final void di() {
      if (this.W[this.aO] == 14) {
         this.G[this.aO] = this.o[22][this.g[22][21] + this.F[this.aO] * 11 + this.c[this.aO]];
         this.H[this.aO] = this.o[22][this.g[22][22] + this.F[this.aO] * 11 + this.c[this.aO]];
         this.J[this.aO]++;
         if (this.J[this.aO] > 3) {
            this.J[this.aO] = 0;
         }

         if (this.c[this.aO] >= this.as[22]) {
            this.aB = this.aO;
            this.dq();
            this.B[this.aO] = this.D[this.aO];
            this.C[this.aO] = this.E[this.aO];
            this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
            this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
            if (this.b[this.B[this.aO]][this.C[this.aO]] == 13) {
               this.P[this.aO] = this.a(this.P[this.aO] + this.f[22]);
               this.W[this.aO] = 10;
               this.aT[0] = this.B[this.aO];
               this.aT[1] = this.C[this.aO];
               this.h = (short)((this.G[this.aO] + this.H[this.aO]) / b.Y[0] - this.aI[this.h[2] + this.A[this.aO] * 12 + this.K[this.J[this.aO]]] / 2);
               this.i = (short)(b.B[1] / 2 + (this.G[this.aO] - this.H[this.aO]) / b.Y[1] - this.aI[this.h[20] + this.A[this.aO] * 4] - 15);
               this.k = this.k + this.b[this.aO];
               this.d = this.d + this.b[this.aO];
               this.L[this.aO] = (byte)(this.L[this.aO] - this.b[this.aO]);
               this.a.delete(0, this.a.length());
               this.a.append("+");
               this.a.append(this.b[this.aO]);
               this.b = this.a.toString();
               this.dM();
               this.b[this.aO] = 0;
            } else {
               this.W[this.aO] = -1;
            }

            this.dr();
         }
      }
   }

   final void dj() {
      this.aB = this.aO;
      this.dq();
      this.aT[0] = this.B[this.aO];
      this.aT[1] = this.C[this.aO];
      this.h = (short)(
         this.aI[this.h[27] + (this.B[this.aO] - this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]]) * 4 + this.H[this.aO]]
            - this.aI[this.h[43] + this.A[this.aO]] / 2
      );
      this.i = (short)(
         this.aI[this.h[28] + (this.B[this.aO] - this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]]) * 4 + this.H[this.aO]]
            - this.aI[this.h[44] + this.A[this.aO]]
            - 15
      );
      this.L[this.aO] = (byte)(this.L[this.aO] - this.b[this.aO]);
      this.k = this.k + this.b[this.aO];
      this.d = this.d + this.b[this.aO];
      this.a.delete(0, this.a.length());
      this.a.append("+");
      this.a.append(this.b[this.aO]);
      this.b = this.a.toString();
      this.b[this.aO] = 0;
      this.dM();
      this.F[this.aO] = this.aa[this.c[this.B[this.aO]][this.C[this.aO]]];
      this.B[this.aO] = (byte)(this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]] + this.aI[this.h[77]]);
      this.C[this.aO] = (byte)(this.l[1][this.c[this.B[this.aO]][this.C[this.aO]]] + this.aI[this.h[77] + 1]);
      this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2]);
      this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2 + 1]);
      this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
      this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
      this.G[this.aO] = b.g[this.F[this.aO]][0];
      this.H[this.aO] = b.g[this.F[this.aO]][1];
      this.Q[this.aO] = this.a(this.Q[this.aO] - 50);
      this.R[this.aO] = this.a(this.R[this.aO] - 60);
      this.T[this.aO] = this.a(this.T[this.aO] - 60);
      this.W[this.aO] = -1;

      for (this.aR = 0; this.aR < this.au[23]; this.aR++) {
         if (this.e[this.c[this.B[this.aO]][this.C[this.aO]]][this.aR] == this.aO) {
            this.e[this.c[this.B[this.aO]][this.C[this.aO]]][this.aR] = -1;
            return;
         }
      }
   }

   final void dk() {
      if (this.W[this.aO] == 15 || this.W[this.aO] == 16) {
         this.J[this.aO]++;
         if (this.J[this.aO] > 3) {
            this.J[this.aO] = 0;
         }

         if (this.W[this.aO] == 15) {
            this.h[0][this.aO] = (byte)(this.h[0][this.aO] + ((this.a.nextInt() & 65535) % 3 - 1));
            this.h[1][this.aO] = (byte)(this.h[1][this.aO] + ((this.a.nextInt() & 65535) % 3 - 1));
            if (this.h[0][this.aO] < -2) {
               this.h[0][this.aO] = -2;
            }

            if (this.h[0][this.aO] > 2) {
               this.h[0][this.aO] = 2;
            }

            if (this.h[1][this.aO] < -2) {
               this.h[1][this.aO] = -2;
            }

            if (this.h[1][this.aO] > 2) {
               this.h[1][this.aO] = 2;
            }
         }

         if (this.c[this.aO] >= this.r) {
            if (this.W[this.aO] == 15) {
               this.aQ = this.aO;

               for (this.aO = this.c[this.B[this.aQ]][this.C[this.aQ]]; this.aO >= 0; this.aO = this.d[this.aO]) {
                  if (this.W[this.aO] == 17) {
                     this.W[this.aO] = -1;
                     this.bk = 1;
                     this.dG();
                     this.dr();
                  }
               }

               this.aO = this.aQ;
            }

            this.W[this.aO] = -1;
            this.V[this.aO] = 0;
            this.bk = 0;
            this.dG();
         }
      }
   }

   final void dl() {
      if (this.A[this.aO] == 8) {
         for (this.aP = this.c[this.B[this.aO]][this.C[this.aO]]; this.aP >= 0; this.aP = this.d[this.aP]) {
            if (this.aP < 200) {
               if (this.W[this.aP] != 15 && this.W[this.aP] != 16) {
                  this.V[this.aP] = 0;
               } else {
                  this.c[this.aP] = this.r;
               }
            }
         }
      }

      if (this.A[this.aO] == 9
         && this.W[this.aO] == -1
         && this.b[this.B[this.aO]][this.C[this.aO]] > 3
         && this.F[this.aO] > 1
         && (
            this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] == 0 && this.H[this.aO] >= 15
               || this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] == 1 && this.G[this.aO] <= 4
         )) {
         this.J[this.aO] = 0;
         this.W[this.aO] = 17;
         this.ai[this.c[this.B[this.aO]][this.C[this.aO]]] = 2;
      }
   }

   final void dm() {
      if ((this.W[this.aO] < 11 || this.W[this.aO] == 18)
         && this.A[this.aO] != 10
         && (this.G[this.aO] >= 20 || this.H[this.aO] >= 20 || this.G[this.aO] < 0 || this.H[this.aO] < 0)) {
         if (this.B[this.aO] != this.ab || this.C[this.aO] != 0 || this.H[this.aO] >= 0) {
            if (this.G[this.aO] != 10 && this.H[this.aO] != 10) {
               if (this.b[this.B[this.aO]][this.C[this.aO]] == 0 && this.b[this.D[this.aO]][this.E[this.aO]] != 0) {
                  if (this.A[this.aO] != 9) {
                     this.dx();
                     return;
                  }

                  this.x = true;
                  if (this.b[this.D[this.aO]][this.E[this.aO]] != 7 && this.b[this.D[this.aO]][this.E[this.aO]] != 8) {
                     this.x = false;
                  } else if (this.ah[this.c[this.D[this.aO]][this.E[this.aO]]] > 50) {
                     this.x = false;
                  }

                  if (!this.x) {
                     this.dx();
                     return;
                  }
               }
            } else {
               if (this.b[this.B[this.aO]][this.C[this.aO]] == 0
                  && (
                     this.F[this.aO] == 2 && this.b[this.D[this.aO]][this.E[this.aO]] != 5
                        || this.F[this.aO] == 3 && this.b[this.D[this.aO]][this.E[this.aO]] != 6
                        || this.f[0][this.aO] != this.Z[this.c[this.D[this.aO]][this.E[this.aO]]]
                  )) {
                  this.dx();
                  return;
               }

               if ((
                     !this.c[this.c[this.D[this.aO]][this.E[this.aO]]]
                        || !this.b[this.c[this.D[this.aO]][this.E[this.aO]]]
                        || !this.a[this.c[this.D[this.aO]][this.E[this.aO]]]
                        || this.ah[this.c[this.D[this.aO]][this.E[this.aO]]] < 10
                  )
                  && this.W[this.aO] == 9) {
                  this.W[this.aO] = -1;
                  this.dx();
                  return;
               }
            }

            this.dn();
            return;
         }

         if (this.H[this.aO] <= -100 && this.W[this.aO] == 18) {
            this.cT();
            return;
         }

         if (this.H[this.aO] >= -3 && this.W[this.aO] == -1) {
            this.dr();
         }
      }
   }

   final void dn() {
      this.G[this.aO] = (byte)(this.G[this.aO] - 20 * this.aI[this.h[31] + this.F[this.aO] * 2]);
      this.H[this.aO] = (byte)(this.H[this.aO] - 20 * this.aI[this.h[31] + this.F[this.aO] * 2 + 1]);
      if (this.W[this.aO] == 9 && this.Z[this.c[this.B[this.aO]][this.C[this.aO]]] == 23) {
         if (this.ac[this.c[this.B[this.aO]][this.C[this.aO]]] >= this.au[23]) {
            this.F[this.aO] = this.aa[this.c[this.B[this.aO]][this.C[this.aO]]];
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2 + 1]);
            this.G[this.aO] = b.g[this.F[this.aO]][0];
            this.H[this.aO] = b.g[this.F[this.aO]][1];
            this.W[this.aO] = -1;
            return;
         }

         this.dp();
      }

      this.do();
   }

   final void do() {
      this.aB = this.aO;
      this.dq();
      this.B[this.aO] = this.D[this.aO];
      this.C[this.aO] = this.E[this.aO];
      this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
      this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
      if (this.aO < 200 && this.b[this.B[this.aO]][this.C[this.aO]] > 3 && this.W[this.aO] == -1 && this.F[this.aO] > 1) {
         if (this.Z[this.c[this.B[this.aO]][this.C[this.aO]]] == 22) {
            this.bc = this.aO;
            this.dE();
            this.W[this.aO] = 14;
            this.c[this.aO] = 0;
         } else {
            this.bc = this.aO;
            this.dE();
            this.W[this.aO] = 9;
         }
      }

      if (this.b[this.B[this.aO]][this.C[this.aO]] != 13 && this.W[this.aO] == 10) {
         this.W[this.aO] = 14;
         this.c[this.aO] = 0;
         this.G[this.aO] = this.o[22][this.g[22][21] + this.F[this.aO] * 11 + this.c[this.aO]];
         this.H[this.aO] = this.o[22][this.g[22][22] + this.F[this.aO] * 11 + this.c[this.aO]];
         this.P[this.aO] = this.a(this.P[this.aO] + this.ad[this.c[this.B[this.aO]][this.C[this.aO]]]);
      }

      if (this.W[this.aO] != 12) {
         this.dr();
      }

      this.dC();
   }

   final void dp() {
      this.ac[this.c[this.B[this.aO]][this.C[this.aO]]]++;

      for (this.aR = 0; this.aR < this.au[23]; this.aR++) {
         if (this.e[this.c[this.B[this.aO]][this.C[this.aO]]][this.aR] < 0) {
            this.D[this.aO] = (byte)(
               this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]]
                  + this.aI[this.h[4] + this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] * 6 + this.aR % 3 * 2]
            );
            this.E[this.aO] = (byte)(
               this.l[1][this.c[this.B[this.aO]][this.C[this.aO]]]
                  + this.aI[this.h[4] + this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] * 6 + this.aR % 3 * 2 + 1]
            );
            this.H[this.aO] = this.aI[this.h[87] + this.aR / 3];
            this.e[this.c[this.B[this.aO]][this.C[this.aO]]][this.aR] = (short)this.aO;
            break;
         }
      }

      this.F[this.aO] = this.aI[this.h[86] + this.H[this.aO]];
      this.J[this.aO] = 0;
      this.c[this.aO] = 0;
      this.W[this.aO] = 12;
      this.P[this.aO] = this.a(this.P[this.aO] + this.g[5]);
   }

   final void dq() {
      this.aS = this.c[this.B[this.aB]][this.C[this.aB]];
      if (this.aS == this.aB) {
         this.c[this.B[this.aB]][this.C[this.aB]] = this.d[this.aB];
      } else {
         while (this.aS >= 0) {
            if (this.d[this.aS] == this.aB) {
               this.d[this.aS] = this.d[this.aB];
               return;
            }

            this.aS = this.d[this.aS];
         }
      }
   }

   final void dr() {
      try {
         if (this.A[this.aO] != 8 && this.A[this.aO] != 9) {
            if (this.b()) {
               return;
            }

            if (this.c()) {
               return;
            }

            if (this.d()) {
               return;
            }

            if (this.e()) {
               return;
            }

            if (this.i()) {
               return;
            }
         } else if (this.A[this.aO] == 9 && this.k()) {
            return;
         }

         for (this.aR = 0; this.aR < 4; this.aR++) {
            if (this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2] < this.O
               && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1] < this.O
               && this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2] >= 0
               && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1] >= 0) {
               this.z[this.aR] = this.b[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2]][this.C[this.aO]
                  + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1]];
            } else {
               this.z[this.aR] = 1;
            }
         }

         if (!this.l()) {
            ;
         }
      } catch (Exception var2) {
      }
   }

   final boolean b() {
      if (this.W[this.aO] != 14
         && (this.W[this.aO] != -1 || this.b[this.B[this.aO]][this.C[this.aO]] <= 3 || this.Z[this.c[this.B[this.aO]][this.C[this.aO]]] != 22)) {
         if (this.W[this.aO] == 18 && this.B[this.aO] == this.ab && this.C[this.aO] == 0) {
            this.D[this.aO] = this.ab;
            this.E[this.aO] = -1;
            return true;
         } else {
            return false;
         }
      } else {
         this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2]);
         this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2 + 1]);
         return true;
      }
   }

   final boolean c() {
      if (this.W[this.aO] != 10) {
         return false;
      }

      for (this.aR = 0; this.aR < 4; this.aR++) {
         if (this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2] < this.O
            && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1] < this.O
            && this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2] >= 0
            && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1] >= 0) {
            this.z[this.aR] = this.b[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2]][this.C[this.aO]
               + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1]];
            if (this.z[this.aR] == 7 && this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] == 1
               || this.z[this.aR] == 8 && this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] == 0) {
               this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2]);
               this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1]);
               return true;
            }
         } else {
            this.z[this.aR] = 1;
         }
      }

      if (this.z[0] == 13) {
         this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2]);
         this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2 + 1]);
         return true;
      } else if (this.z[1] == 13) {
         this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2]);
         this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2 + 1]);
         return true;
      } else if (this.z[3] == 13) {
         this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2]);
         this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2 + 1]);
         return true;
      } else {
         this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2]);
         this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2 + 1]);
         return true;
      }
   }

   final boolean d() {
      if (this.W[this.aO] == 9) {
         if (this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] == 0) {
            if (this.C[this.aO] == this.ae[this.c[this.B[this.aO]][this.C[this.aO]]]) {
               this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + 4]);
               this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + 4 + 1]);
            } else {
               this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + 6]);
               this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + 6 + 1]);
            }
         } else if (this.B[this.aO] == this.ae[this.c[this.B[this.aO]][this.C[this.aO]]]) {
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + 6]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + 6 + 1]);
         } else {
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + 4]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + 4 + 1]);
         }

         return true;
      } else if ((this.W[this.aO] == -1 || this.W[this.aO] == 18)
         && this.b[this.B[this.aO]][this.C[this.aO]] >= 4
         && this.b[this.B[this.aO]][this.C[this.aO]] <= 6) {
         this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] * 2]);
         this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] * 2 + 1]);
         return true;
      } else {
         return false;
      }
   }

   final boolean e() {
      if (this.W[this.aO] != 18) {
         if (this.Q[this.aO] > 50) {
            for (this.aR = 0; this.aR < 2; this.aR++) {
               if (this.b[this.B[this.aO]][this.C[this.aO]] == 0 && (this.c[this.B[this.aO]][this.C[this.aO]] & b.X[this.aR]) != 0) {
                  this.aT = 0;

                  for (this.aS = this.c[this.B[this.aO]][this.C[this.aO]]; this.aS >= 0; this.aS = this.d[this.aS]) {
                     if (this.W[this.aS] == 1 && this.h[2][this.aS] == this.aR && this.h[0][this.aS] < 2) {
                        this.aT++;
                     }
                  }

                  if (this.aT < 2) {
                     this.W[this.aO] = 1;
                     this.h[0][this.aO] = 0;
                     this.h[1][this.aO] = 0;
                     this.h[2][this.aO] = (byte)this.aR;
                     this.X[this.aO] = this.F[this.aO];
                     this.b[this.aO] = 0;
                     break;
                  }
               }
            }
         }

         if (this.f()) {
            return true;
         }
      }

      return false;
   }

   final boolean f() {
      for (this.aT = 0; this.aT < 2; this.aT++) {
         if ((this.aT != 0 || this.B[this.aO] != 0) && (this.aT != 1 || this.C[this.aO] != this.O - 1)) {
            this.aZ[0] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aT] * 4] * 2]);
            this.aZ[1] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aT] * 4] * 2 + 1]);
            this.bd = this.b[this.aZ[0]][this.aZ[1]];
            this.be = this.c[this.aZ[0]][this.aZ[1]];
            if (this.bd <= -15 && this.bd >= -27) {
               this.x = false;
               if (this.d[this.be]) {
                  if (this.g()) {
                     return true;
                  }

                  if (this.x) {
                     this.W[this.aO] = this.aI[this.h[53] + -1 - this.bd];
                     this.h[0][this.aO] = 0;
                     this.h[1][this.aO] = 0;
                     this.h[2][this.aO] = (byte)this.aT;
                     this.X[this.aO] = this.F[this.aO];
                     break;
                  }
               }
            }

            this.x = false;
            if (this.h()) {
               return true;
            }

            if (this.x) {
               this.D[this.aO] = this.aZ[0];
               this.E[this.aO] = this.aZ[1];
               this.f[1][this.aO] = this.f[0][this.aO];
               this.f[0][this.aO] = this.Z[this.be];
               this.f[2][this.aO]++;
               this.h[0][this.aO] = 0;
               this.h[1][this.aO] = 0;
               this.h[2][this.aO] = (byte)this.aT;
               this.X[this.aO] = this.F[this.aO];
               if (this.Z[this.be] != 23) {
                  this.b[this.aO] = this.al[this.Z[this.be]];
               }

               this.W[this.aO] = 7;
               return true;
            }
         }
      }

      return false;
   }

   final boolean g() {
      if (this.aI[this.h[163 + this.aT] - 1 - this.bd] == 1
         && (
            this.aI[this.h[55] + -1 - this.bd] >= this.g[this.aI[this.h[54] + -1 - this.bd]][this.aO] && b.ar[this.aI[this.h[54] + -1 - this.bd]] == 0
               || this.aI[this.h[55] + -1 - this.bd] <= this.g[this.aI[this.h[54] + -1 - this.bd]][this.aO] && b.ar[this.aI[this.h[54] + -1 - this.bd]] == 1
         )) {
         if (this.aI[this.h[57] + -1 - this.bd] >= 0) {
            if (this.L[this.aO] >= this.aE[this.aI[this.h[57] + -1 - this.bd]]) {
               this.b[this.aO] = this.aE[this.aI[this.h[57] + -1 - this.bd]];
               this.x = true;
            }
         } else {
            this.b[this.aO] = 0;
            this.x = true;
         }
      }

      if ((this.bd == -21 || this.bd == -22 || this.bd == -26) && this.x) {
         if (this.e[this.be]) {
            this.x = false;
         } else {
            this.aS = this.c[this.B[this.aO]][this.C[this.aO]];

            do {
               if ((this.W[this.aS] == 4 || this.W[this.aS] == 6) && this.h[2][this.aS] == this.aT && this.aS != this.aO) {
                  this.x = false;
                  break;
               }

               this.aS = this.d[this.aS];
            } while (this.aS >= 0);
         }
      }

      if (this.aI[this.h[53] + -1 - this.bd] == 5 && this.M[this.aO] > -1 && this.x) {
         this.b[this.aO] = 0;
         this.x = false;
      }

      return false;
   }

   final boolean h() {
      if (this.bd == 5 + this.aT
         && this.a[this.be]
         && this.b[this.be]
         && this.c[this.be]
         && this.ah[this.be] >= 10
         && (this.Z[this.be] == 23 || this.L[this.aO] >= this.al[this.Z[this.be]])) {
         this.q = this.be;
         if (this.Z[this.be] != 22 && this.Z[this.be] != 23 && this.ad[this.be] < 10) {
            this.dB();
            this.q = (short)((this.a.nextInt() & 65535) % 100);
            if (this.q < this.p) {
               this.x = true;
            }
         } else if (this.Z[this.be] == 22 && this.c[this.aZ[0]][this.aZ[1]] == -1) {
            this.dB();
            this.q = (short)((this.a.nextInt() & 65535) % 100);
            if (this.q < this.p) {
               this.x = true;
            }

            if (this.x) {
               this.aS = this.c[this.B[this.aO]][this.C[this.aO]];

               do {
                  if (this.W[this.aS] == 7 && this.h[2][this.aS] == this.aT && this.aS != this.aO) {
                     this.x = false;
                     break;
                  }

                  this.aS = this.d[this.aS];
               } while (this.aS >= 0);
            }
         } else if (this.Z[this.be] == 23
            && this.ac[this.be] < this.au[23]
            && (this.Q[this.aO] > 50 || this.R[this.aO] > 50 || this.T[this.aO] > 50)
            && this.L[this.aO] >= this.aE[this.aI[this.h[57] + 27 + 1]]) {
            this.b[this.aO] = this.aE[this.aI[this.h[57] + 27 + 1]];
            this.x = true;
         }
      }

      return false;
   }

   final boolean i() {
      this.aT = 0;

      for (this.aR = 0; this.aR < 4; this.aR++) {
         if (this.B[this.aO] + this.aI[this.h[31] + this.aR * 2] < this.O
            && this.C[this.aO] + this.aI[this.h[31] + this.aR * 2 + 1] < this.O
            && this.B[this.aO] + this.aI[this.h[31] + this.aR * 2] >= 0
            && this.C[this.aO] + this.aI[this.h[31] + this.aR * 2 + 1] >= 0) {
            this.z[this.aR] = this.b[this.B[this.aO] + this.aI[this.h[31] + this.aR * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aR * 2 + 1]];
            if (this.z[this.aR] == 0) {
               this.aT++;
            }
         } else {
            this.z[this.aR] = 1;
         }
      }

      if (this.aT > 2) {
         if (this.W[this.aO] == 18) {
            this.ds();

            for (this.aR = 0; this.aR < 4; this.aR++) {
               if (this.z[this.aI[this.h[32] + this.bc * 4 + this.aR]] == 0
                  && this.aI[this.h[32] + this.bc * 4 + this.aR] != this.aI[this.h[30] + this.F[this.aO] * 4 + 2]) {
                  this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[32] + this.bc * 4 + this.aR] * 2]);
                  this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[32] + this.bc * 4 + this.aR] * 2 + 1]);
                  return true;
               }
            }
         }

         if (this.j()) {
            return true;
         }
      }

      return false;
   }

   final boolean j() {
      for (this.aR = this.B[this.aO] - 1; this.aR <= this.B[this.aO] + 1; this.aR++) {
         if (this.aR >= 0) {
            if (this.aR >= this.O) {
               break;
            }

            for (this.aS = this.C[this.aO] - 1; this.aS <= this.C[this.aO] + 1; this.aS++) {
               if (this.aS >= 0) {
                  if (this.aS >= this.O) {
                     break;
                  }

                  if (this.b[this.aR][this.aS] == -14 && this.Y[this.c[this.aR][this.aS]] > 0) {
                     for (this.aT = 0; this.aT < this.Y[this.c[this.aR][this.aS]]; this.aT++) {
                        this.x = false;
                        if (this.j[this.c[this.aR][this.aS]][this.aT] >= 0) {
                           if (this.j[this.c[this.aR][this.aS]][this.aT] != 23) {
                              this.bh = this.j[this.c[this.aR][this.aS]][this.aT];
                              this.dA();
                              if (this.p >= 50) {
                                 this.x = true;
                              }
                           } else if (this.Q[this.aO] > 50 || this.R[this.aO] > 50) {
                              this.x = true;
                           }
                        } else if (this.aI[this.h[55] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]
                                 >= this.g[this.aI[this.h[54] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]][this.aO]
                              && b.ar[this.aI[this.h[54] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]] == 0
                           || this.aI[this.h[55] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]
                                 <= this.g[this.aI[this.h[54] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]][this.aO]
                              && b.ar[this.aI[this.h[54] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]] == 1
                              && this.aI[this.h[53] + this.j[this.c[this.aR][this.aS]][this.aT]] != -2) {
                           this.x = true;
                        }

                        if (this.x) {
                           this.ds();

                           for (this.aR = 0; this.aR < 4; this.aR++) {
                              if (this.z[this.aI[this.h[32] + this.bc * 4 + this.aR]] == 0
                                 && this.aI[this.h[32] + this.bc * 4 + this.aR] != this.aI[this.h[30] + this.F[this.aO] * 4 + 2]) {
                                 this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[32] + this.bc * 4 + this.aR] * 2]);
                                 this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[32] + this.bc * 4 + this.aR] * 2 + 1]);
                                 return true;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return false;
   }

   final boolean k() {
      if (this.b[this.B[this.aO]][this.C[this.aO]] > 3) {
         this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2]);
         this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.F[this.aO] * 2 + 1]);
         if (this.F[this.aO] > 1) {
            this.ai[this.c[this.B[this.aO]][this.C[this.aO]]] = 1;
         }

         return true;
      } else {
         for (this.aT = 0; this.aT < 2; this.aT++) {
            if ((this.aT != 0 || this.B[this.aO] != 0) && (this.aT != 1 || this.C[this.aO] != this.O - 1)) {
               this.aZ[0] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aT] * 4] * 2]);
               this.aZ[1] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aT] * 4] * 2 + 1]);
               this.bd = this.b[this.aZ[0]][this.aZ[1]];
               this.be = this.c[this.aZ[0]][this.aZ[1]];
               if (this.bd == 7 + this.aT && this.ah[this.be] <= 50 && this.ai[this.be] == 0) {
                  this.x = true;

                  for (this.aS = this.c[this.B[this.aO]][this.C[this.aO]]; this.aS >= 0; this.aS = this.d[this.aS]) {
                     if (this.A[this.aS] == 9 && this.D[this.aS] == this.aZ[0] && this.E[this.aS] == this.aZ[1]) {
                        this.x = false;
                        break;
                     }
                  }

                  if (this.x) {
                     this.D[this.aO] = this.aZ[0];
                     this.E[this.aO] = this.aZ[1];
                     return true;
                  }
               }
            }
         }

         return false;
      }
   }

   final boolean l() {
      this.aR = (this.a.nextInt() & 0xFF) % 4;
      if (this.z[0] != 0 || (this.z[1] == 0 || this.z[3] == 0) && this.aR >= 2) {
         this.aR = (this.a.nextInt() & 0xFF) % 4;
         if (this.z[1] != 0 || this.z[3] == 0 && this.aR >= 2) {
            if (this.z[3] == 0) {
               this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2]);
               this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2 + 1]);
               return true;
            }

            if (this.z[2] == 0) {
               this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2]);
               this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2 + 1]);
            } else {
               this.D[this.aO] = -1;
               this.W[this.aO] = 18;
            }

            return false;
         } else {
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2 + 1]);
            return true;
         }
      } else {
         this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2]);
         this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2 + 1]);
         return true;
      }
   }

   final void ds() {
      this.bc = 0;
      if (this.W[this.aO] == 18) {
         this.aV = this.ab - this.B[this.aO];
         this.aW = -this.C[this.aO];
      } else {
         this.aV = this.a[this.c[this.aR][this.aS]][this.aT][0] - this.B[this.aO];
         this.aW = this.a[this.c[this.aR][this.aS]][this.aT][1] - this.C[this.aO];
      }

      if (this.aV > 0) {
         this.bc = (byte)(this.bc + 4);
      } else {
         this.aV *= -1;
      }

      if (this.aW > 0) {
         this.bc = (byte)(this.bc + 2);
      } else {
         this.aW *= -1;
      }

      if (this.aV > this.aW) {
         this.bc++;
      }

      if ((this.a.nextInt() & 0xFF) % 4 == 0) {
         this.bc = (byte)((this.bc + (this.a.nextInt() & 15)) % 8);
      }
   }

   final void dt() {
      if (this.ad[this.c[this.B[this.aO]][this.C[this.aO]]] >= 10) {
         this.du();
      } else if (this.c[this.c[this.B[this.aO]][this.C[this.aO]]]
         && this.b[this.c[this.B[this.aO]][this.C[this.aO]]]
         && this.a[this.c[this.B[this.aO]][this.C[this.aO]]]
         && this.ah[this.c[this.B[this.aO]][this.C[this.aO]]] >= 10) {
         this.W[this.aO] = 11;
         this.f[this.c[this.B[this.aO]][this.C[this.aO]]][this.ad[this.c[this.B[this.aO]][this.C[this.aO]]]] = (short)this.aO;
         this.aB = this.aO;
         this.dq();
         this.aP = this.ad[this.c[this.B[this.aO]][this.C[this.aO]]] * 6;
         if (this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] == 0) {
            this.dv();
         } else {
            this.dw();
         }

         this.d[this.aB] = this.c[this.B[this.aB]][this.C[this.aB]];
         this.c[this.B[this.aB]][this.C[this.aB]] = (short)this.aB;
         this.ad[this.c[this.B[this.aO]][this.C[this.aO]]]++;
         if (this.Z[this.c[this.B[this.aO]][this.C[this.aO]]] == 14) {
            this.af[this.c[this.B[this.aO]][this.C[this.aO]]] = 0;
         }

         this.J[this.aO] = 0;
      } else {
         this.W[this.aO] = -1;
         this.dx();
      }
   }

   final void du() {
      this.aB = this.aO;
      this.dq();
      if (this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] == 0) {
         this.C[this.aO] = (byte)(this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] - 2);
         this.E[this.aO] = (byte)(this.C[this.aO] - 1);
         this.D[this.aO] = this.B[this.aO];
         this.H[this.aO] = 0;
         this.G[this.aO] = b.Z[0];
         this.F[this.aO] = 0;
         this.W[this.aO] = -1;
      } else {
         this.B[this.aO] = (byte)(this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] + 2);
         this.D[this.aO] = (byte)(this.B[this.aO] + 1);
         this.E[this.aO] = this.C[this.aO];
         this.H[this.aO] = b.Z[0];
         this.G[this.aO] = 18;
         this.F[this.aO] = 1;
         this.W[this.aO] = -1;
      }

      this.d[this.aB] = this.c[this.B[this.aB]][this.C[this.aB]];
      this.c[this.B[this.aB]][this.C[this.aB]] = (short)this.aB;
   }

   final void dv() {
      if (this.aP <= 16) {
         this.C[this.aO] = this.ae[this.c[this.B[this.aO]][this.C[this.aO]]];
         this.D[this.aO] = (byte)(this.B[this.aO] - 1);
         this.E[this.aO] = this.C[this.aO];
         if (this.aP <= 6) {
            this.H[this.aO] = 10;
            this.G[this.aO] = (byte)(this.aP + 4);
            this.F[this.aO] = 2;
         } else {
            this.aP -= 6;
            this.G[this.aO] = 10;
            this.H[this.aO] = (byte)(10 - this.aP);
            this.F[this.aO] = 3;
         }
      } else {
         this.aP -= 16;
         this.G[this.aO] = 10;
         this.H[this.aO] = (byte)((40 - this.aP) % 20);
         this.C[this.aO] = (byte)(this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] - 1 - (this.aP - 1) / 20);
         this.D[this.aO] = this.B[this.aO];
         this.E[this.aO] = (byte)(this.C[this.aO] + 1);
         this.F[this.aO] = 3;
      }
   }

   final void dw() {
      if (this.aP <= 14) {
         this.B[this.aO] = this.ae[this.c[this.B[this.aO]][this.C[this.aO]]];
         this.D[this.aO] = this.B[this.aO];
         this.E[this.aO] = (byte)(this.C[this.aO] + 1);
         if (this.aP <= 5) {
            this.H[this.aO] = (byte)(19 - this.aP - 4);
            this.G[this.aO] = 10;
            this.F[this.aO] = 3;
         } else {
            this.aP -= 5;
            this.G[this.aO] = (byte)(10 + this.aP);
            this.H[this.aO] = 10;
            this.F[this.aO] = 2;
         }
      } else {
         this.aP -= 15;
         this.G[this.aO] = (byte)(this.aP % 20);
         this.H[this.aO] = 10;
         this.B[this.aO] = (byte)(this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] + 1 + this.aP / 20);
         this.D[this.aO] = (byte)(this.B[this.aO] - 1);
         this.E[this.aO] = this.C[this.aO];
         this.F[this.aO] = 2;
      }
   }

   final void d(boolean var1) {
      this.aX = this.aO;

      for (this.aY = 0; this.aY < this.ad[this.ax]; this.aY++) {
         this.aO = this.f[this.ax][this.aY];
         this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 2];
         this.e[this.aI[this.h[105] + this.F[this.aO]]][this.aO] = this.aI[this.h[36] + this.F[this.aO] * 2 + this.aI[this.h[105] + this.F[this.aO]]];
         this.W[this.aO] = -1;
         if (var1) {
            this.P[this.aO] = this.a(this.P[this.aO] - b.ap[3]);
         }

         this.dr();
      }

      this.ad[this.ax] = 0;
      this.aO = this.aX;
   }

   final void dx() {
      this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 2];
      this.G[this.aO] = this.aI[this.h[36] + this.F[this.aO] * 2];
      this.H[this.aO] = this.aI[this.h[36] + this.F[this.aO] * 2 + 1];
      this.dr();
   }

   final void dy() {
      for (this.aR = 0; this.aR < 30; this.aR++) {
         this.Y[this.aR] = 0;
         if (this.i[this.aR][0] >= 0) {
            for (this.aS = this.i[this.aR][0] - 6; this.aS <= this.i[this.aR][0] + 6; this.aS++) {
               if (this.aS >= 0) {
                  if (this.aS >= this.O) {
                     break;
                  }

                  for (this.aT = this.i[this.aR][1] - 6; this.aT <= this.i[this.aR][1] + 6; this.aT++) {
                     if (this.aT >= 0) {
                        if (this.aT >= this.O) {
                           break;
                        }

                        for (this.bf = 0; this.bf < 2 && this.Y[this.aR] < 20; this.bf++) {
                           this.bg = 0;
                           if (this.b[this.aS][this.aT] <= -15
                              && this.b[this.aS][this.aT] >= -27
                              && this.aI[this.h[163 + this.bf] - 1 - this.b[this.aS][this.aT]] == 1) {
                              this.j[this.aR][this.Y[this.aR]] = this.b[this.aS][this.aT];
                              this.bg = 1;
                           }

                           if (this.b[this.aS][this.aT] == 5 + this.bf) {
                              this.j[this.aR][this.Y[this.aR]] = this.Z[this.c[this.aS][this.aT]];
                              this.bg = 1;
                           }

                           if (this.bg == 1) {
                              this.a[this.aR][this.Y[this.aR]][0] = (byte)(
                                 this.aS + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.bf] * 4 + 2] * 2]
                              );
                              this.a[this.aR][this.Y[this.aR]][1] = (byte)(
                                 this.aT + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.bf] * 4 + 2] * 2 + 1]
                              );
                              this.Y[this.aR]++;
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   final void dz() {
      if (this.P[this.aO] < 50) {
         this.aZ = (this.a.nextInt() & 65535) % (this.c[1][d.k[4] + 1] * 40);
      } else {
         this.aZ = 1000;
      }

      if (this.L[this.aO] < 4 || this.Q[this.aO] >= 96 || this.R[this.aO] >= 100 || 60 + 10 * this.M - this.P[this.aO] > this.aZ) {
         this.W[this.aO] = 18;
      }
   }

   final void dA() {
      this.p = 100;
      this.p = (short)(this.p - (this.Q[this.aO] + this.R[this.aO]) * 100 / 200);
      this.p = (short)(this.p - this.f[this.bh] * 2);
      if (this.f[0][this.aO] == this.bh) {
         this.p = (short)(this.p - b.av[0]);
      }

      if (this.f[1][this.aO] == this.bh) {
         this.p = (short)(this.p - b.av[1]);
      }
   }

   final void dB() {
      this.bh = this.Z[this.q];
      this.dA();
      if (this.bh != 22) {
         this.p = (short)(this.p - this.ad[this.q] * 50 / 10);
      }
   }

   final void e(boolean var1) {
      if (this.W[this.aO] != 15 && this.W[this.aO] != 16) {
         this.N[this.aO] = -1;

         for (this.bi = 0; this.bi < 10; this.bi++) {
            if (this.aI[this.h[95] + this.bi] == this.ad + 3) {
               if (this.c[this.aO] >= b.b[this.bi]) {
                  this.N[this.aO] = this.bi;
               }
            } else if (this.g[this.aI[this.h[95] + this.bi]][this.aO] <= b.b[this.bi] && this.aI[this.h[97] + this.bi] == 0
               || this.g[this.aI[this.h[95] + this.bi]][this.aO] >= b.b[this.bi] && this.aI[this.h[97] + this.bi] == 1) {
               this.N[this.aO] = this.bi;
            }

            if (this.N[this.aO] >= 0 && var1 && (this.a.nextInt() & 65535) % 25 > 0) {
               this.N[this.aO] = -1;
            }

            if (this.N[this.aO] >= 0) {
               return;
            }
         }
      }
   }

   final void dC() {
      if (this.aO < 200) {
         for (this.ba = this.d[this.aO]; this.ba != -1; this.ba = this.d[this.ba]) {
            if (this.W[this.ba] == 15 || this.W[this.ba] == 16) {
               this.J[this.aO] = 0;
               this.W[this.aO] = 17;
               return;
            }
         }

         if (this.W[this.aO] == -1) {
            for (this.ba = this.d[this.aO]; this.ba != -1; this.ba = this.d[this.ba]) {
               if (this.W[this.ba] == -1
                  && this.ba < 200
                  && this.V[this.aO] >= this.af
                  && this.V[this.ba] >= this.af
                  && (this.a.nextInt() & 65535) % this.b < this.V[this.aO] + this.V[this.ba]) {
                  this.W[this.aO] = 15;
                  this.W[this.ba] = 16;
                  this.h[0][this.aO] = 0;
                  this.h[1][this.aO] = 0;
                  this.c[this.aO] = 0;
                  this.c[this.ba] = 0;
                  this.N[this.aO] = -1;
                  this.N[this.ba] = -1;
                  this.bc = this.aO;
                  this.dE();
                  this.bc = this.ba;
                  this.dE();
                  this.bj = 0;
                  this.dD();
                  return;
               }
            }
         }
      }
   }

   final void dD() {
      if (!this.j[this.bj]) {
         this.f = 0;
         this.aC = 1;
         this.aA = (byte)(this.aE + this.bj);
         this.aB = this.aA;
         this.dI();
         this.j[this.bj] = true;
      }
   }

   final void dE() {
      if (this.M[this.bc] >= 0) {
         for (this.bb = 0; this.bb < this.aH; this.bb++) {
            if (this.x[this.bb][0] < 0) {
               this.x[this.bb][0] = this.B[this.bc];
               this.x[this.bb][1] = this.C[this.bc];
               this.aR[this.bb] = (byte)((this.G[this.bc] + this.H[this.bc]) / b.Y[0] - this.aI[this.h[73] + this.M[this.bc] + 13] / 2);
               this.aQ[this.bb] = (byte)(
                  b.B[1] / 2
                     + (this.G[this.bc] - this.H[this.bc]) / b.Y[1]
                     - this.aI[this.h[20] + this.A[this.bc] * 4 + this.F[this.bc]]
                     - this.aI[this.h[74] + this.M[this.bc] + 13]
               );
               this.aS[this.bb] = (byte)(this.M[this.bc] + 13);
               this.M[this.bc] = -1;
               return;
            }
         }
      }
   }

   final void dF() {
      for (this.bb = 0; this.bb < this.aH; this.bb++) {
         if (this.x[this.bb][0] >= 0) {
            if (this.aQ[this.bb] < this.aI) {
               this.x[this.bb][0] = -1;
            } else {
               this.aR[this.bb] = (byte)(this.aR[this.bb] + ((this.a.nextInt() & 65535) % 3 - 1));
               this.aQ[this.bb] = (byte)(this.aQ[this.bb] - 2);
            }
         }
      }
   }

   final void dG() {
      for (this.aP = 0; this.aP < this.ae; this.aP++) {
         if (b.ar[this.aP] == 0) {
            this.g[this.aP][this.aO] = this.a(this.g[this.aP][this.aO] - this.aI[this.h[33] + this.bk * this.ae + this.aP]);
         }

         if (b.ar[this.aP] == 1) {
            this.g[this.aP][this.aO] = this.a(this.g[this.aP][this.aO] + this.aI[this.h[33] + this.bk * this.ae + this.aP]);
         }
      }
   }

   final byte a(int var1) {
      if (var1 >= 100) {
         return 100;
      } else {
         return var1 <= 0 ? 0 : (byte)var1;
      }
   }

   final void dH() {
      for (this.s = 0; this.s < 3; this.s++) {
         this.a = null;

         try {
            this.a = this.getClass().getResourceAsStream(this.b[this.s] + this.P);
            if (this.a != null) {
               this.r = 0;
               this.i[this.s][0] = 0;

               for (this.q = 0; (this.D = this.a.read()) != -1; this.q++) {
                  if (this.D == 124) {
                     this.r++;
                     this.i[this.s][this.r] = (short)this.q;
                     this.q--;
                  } else if (this.D == 38) {
                     this.s[this.s][this.q] = 100;
                  } else if (this.D < 10) {
                     this.s[this.s][this.q] = (byte)(101 + this.D);
                  } else if (this.D != 31) {
                     this.dK();
                     this.s[this.s][this.q] = (byte)this.E;
                  } else {
                     try {
                        this.b = this.a.getAppProperty("MIDlet-Version");
                     } catch (Exception var2) {
                        this.b = "1.0.0";
                     }

                     for (this.t = 0; this.t < this.b.length(); this.t++) {
                        this.D = this.b.charAt(this.t);
                        this.dK();
                        this.s[this.s][this.q] = (byte)this.E;
                        this.q++;
                     }

                     this.q--;
                  }
               }
            }

            this.a.close();
            this.a = null;
         } catch (IOException var3) {
         }

         System.gc();
      }
   }

   final void dI() {
      this.be = 0;
      this.G = 0;
      this.l[0] = this.i[this.aC][this.aA];
      this.bf = 0;
      this.dJ();
      if (this.i[this.aC][this.aA] < this.i[this.aC][this.aA + 1]) {
         this.G++;
         this.m[this.G - 1] = (short)this.bf;
         this.l[this.G] = this.i[this.aC][this.aA + 1];
      }

      this.F = 0;
      if (this.aC == 3) {
         this.H = (this.m + d.B[this.aC]) / 2 - 10 * this.G;
         if (this.H < d.B[this.aC]) {
            this.H = d.B[this.aC];
            return;
         }
      } else {
         if (this.aC == 1) {
            if (this.G >= d.j[1] && this.aA >= 30) {
               this.H = d.B[this.aC] - (d.j[1] - 1) * 20;
               return;
            }

            this.H = d.B[this.aC] - (this.G - 1) * 20;
            return;
         }

         this.H = d.B[this.aC];
      }
   }

   final void dJ() {
      for (this.bd = this.i[this.aC][this.aA]; this.bd < this.i[this.aC][this.aA + 1]; this.bd++) {
         if (this.s[this.aC][this.bd] == 42 || this.s[this.aC][this.bd] == 100) {
            this.be = (short)(this.bd + 1);
            this.bg = this.bf;
         }

         if (this.s[this.aC][this.bd] >= 101) {
            this.bf++;
            this.bf = this.bf + this.aI[this.h[73] + this.aI[this.h[96] + this.s[this.aC][this.bd] - 101]];
         }

         if (this.s[this.aC][this.bd] < 100 && (this.s[this.aC][this.bd] / 30 != 0 || this.s[this.aC][this.bd] % 30 < 14)) {
            this.bf++;
            this.bf = this.bf
               + (b.a[this.s[this.aC][this.bd] / 30][this.s[this.aC][this.bd] % 30 + 1] - b.a[this.s[this.aC][this.bd] / 30][this.s[this.aC][this.bd] % 30]);
         }

         if (this.bf > d.A[this.aC] && this.be > this.l[this.G] || this.s[this.aC][this.bd] == 100) {
            this.G++;
            this.l[this.G] = (short)this.be;
            this.m[this.G - 1] = (short)this.bg;
            this.bd = (short)(this.be - 1);
            this.bf = 0;
         }
      }
   }

   final void dK() {
      if (this.j == 0) {
         for (this.u = 0; this.u < b.c.length; this.u++) {
            if (this.D == b.c[this.u]) {
               this.E = 43 + this.u;
               return;
            }
         }

         if (this.D >= 91 && this.D < 97) {
            this.E = 14 + this.D - 91;
            return;
         }

         if (this.D > 95) {
            this.D -= 32;
         }

         if (this.D >= 65 && this.D < 79) {
            this.E = this.D - 65;
            return;
         }

         if (this.D >= 79 && this.D <= 90) {
            this.E = 30 + this.D - 79;
            return;
         }

         if (this.D == 32) {
            this.E = 42;
            return;
         }

         if (this.D >= 48 && this.D <= 57) {
            this.E = 60 + this.D - 48;
            return;
         }

         this.E = 70;

         for (this.u = 0; this.u < 11; this.u++) {
            if (this.D == this.aI[this.h[130] + this.u]) {
               this.E = this.E + this.u;
               return;
            }
         }
      } else {
         if (this.D >= 48 && this.D <= 57) {
            this.E = this.D - 48;
         }

         for (this.u = 0; this.u < 3; this.u++) {
            if (this.D == d.a[this.u]) {
               this.E = 10 + this.u;
               return;
            }
         }
      }
   }

   final void dL() {
      this.d[this.az] = this.i[this.f + 1] - this.i[this.f] - 1;
      this.c[this.az] = this.i[this.f + 1] - this.i[this.f];
      this.f[this.az] = this.h;
      this.e[this.az] = this.i;

      for (this.bh = 0; this.bh < this.c[this.az]; this.bh++) {
         this.u[this.az][this.bh] = (byte)(this.aN[this.i[this.f] + this.bh] / 30);
         this.t[this.az][this.bh] = (byte)(this.aN[this.i[this.f] + this.bh] % 30);
         if (this.aN[this.i[this.f] + this.bh] / 30 != 0 || this.aN[this.i[this.f] + this.bh] % 30 < 14) {
            this.d[this.az] = this.d[this.az]
               + (b.a[this.u[this.az][this.bh]][this.t[this.az][this.bh] + 1] - b.a[this.u[this.az][this.bh]][this.t[this.az][this.bh]]);
         }
      }

      if (this.g == 1) {
         this.f[this.az] = this.f[this.az] - this.d[this.az] / 2;
      }

      if (this.g == 2) {
         this.f[this.az] = this.f[this.az] - this.d[this.az];
      }

      this.g[this.az] = 0;
      this.az++;
   }

   final void dM() {
      if (this.aG < this.aF) {
         this.bh = 0;

         while (this.bh < this.aF && this.l[this.bh] < this.o) {
            this.bh++;
         }

         if (this.bh < this.aF) {
            this.h[this.bh] = this.b.length();
            this.i[this.bh] = this.h[this.bh] - 1;
            this.k[this.bh] = this.h;
            this.j[this.bh] = this.i;
            this.v[this.bh][0] = this.aT[0];
            this.v[this.bh][1] = this.aT[1];
            this.j = 2;

            for (this.bi = 0; this.bi < this.h[this.bh]; this.bi++) {
               this.D = this.b.charAt(this.bi);
               this.dK();
               this.w[this.bh][this.bi] = (byte)this.E;
               this.i[this.bh] = this.i[this.bh] + (b.a[this.w[this.bh][this.bi] + 1] - b.a[this.w[this.bh][this.bi]]);
            }

            this.j = 0;
            this.k[this.bh] = this.k[this.bh] - this.i[this.bh] / 2;
            this.l[this.bh] = 0;
            this.aG++;
         }
      }
   }

   final void dN() {
      this.c[this.az] = this.b.length();
      this.d[this.az] = this.c[this.az] - 1;
      this.f[this.az] = this.h;
      this.e[this.az] = this.i;

      for (this.bh = 0; this.bh < this.c[this.az]; this.bh++) {
         this.D = this.b.charAt(this.bh);
         this.dK();
         this.u[this.az][this.bh] = (byte)(this.E / 30);
         this.t[this.az][this.bh] = (byte)(this.E % 30);
         if (this.j == 0) {
            this.d[this.az] = this.d[this.az]
               + (b.a[this.u[this.az][this.bh]][this.t[this.az][this.bh] + 1] - b.a[this.u[this.az][this.bh]][this.t[this.az][this.bh]]);
         } else {
            this.d[this.az] = this.d[this.az] + (b.a[this.t[this.az][this.bh] + 1] - b.a[this.t[this.az][this.bh]]);
         }
      }

      if (this.g == 1) {
         this.f[this.az] = this.f[this.az] - this.d[this.az] / 2;
      }

      if (this.g == 2) {
         this.f[this.az] = this.f[this.az] - this.d[this.az];
      }

      this.g[this.az] = this.j;
      this.az++;
   }

   final void dO() {
      this.c[this.k] = this.b.length();
      this.d[this.k] = this.c[this.k] - 1;
      this.f[this.k] = this.h;
      this.e[this.k] = this.i;

      for (this.bh = 0; this.bh < this.c[this.k]; this.bh++) {
         this.D = this.b.charAt(this.bh);
         this.dK();
         this.u[this.k][this.bh] = (byte)(this.E / 30);
         this.t[this.k][this.bh] = (byte)(this.E % 30);
         if (this.j == 0) {
            this.d[this.k] = this.d[this.k]
               + (b.a[this.u[this.k][this.bh]][this.t[this.k][this.bh] + 1] - b.a[this.u[this.k][this.bh]][this.t[this.k][this.bh]]);
         } else {
            this.d[this.k] = this.d[this.k] + (b.a[this.t[this.k][this.bh] + 1] - b.a[this.t[this.k][this.bh]]);
         }
      }

      if (this.g == 1) {
         this.f[this.k] = this.f[this.k] - this.d[this.k] / 2;
      }

      if (this.g == 2) {
         this.f[this.k] = this.f[this.k] - this.d[this.k];
      }

      this.g[this.k] = this.j;
   }

   final void dP() {
      this.a++;
      if (this.a >= 100) {
         this.a = 0;
      }

      for (this.bj = 0; this.bj < this.az; this.bj++) {
         this.bl = this.f[this.bj];
         this.bp = 0;

         for (this.bk = 0; this.bk < this.c[this.bj]; this.bk++) {
            if (this.g[this.bj] == 0) {
               this.bm = 0;
               if (this.u[this.bj][this.bk] == 0 && this.t[this.bj][this.bk] >= 14) {
                  this.bo = -1
                     - (this.bn + b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk] + 1] - b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk]]) / 2;
                  this.bp++;
               } else {
                  this.bo = 0;
               }

               this.bn = b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk] + 1] - b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk]];
               this.bq = this.P;
               if (this.w && this.P > 1) {
                  this.bq--;
               }

               if (this.R != 26
                  && this.v[this.R] > 0
                  && !this.p
                  && this.b == 3
                  && this.bj - this.aI[this.h[94] + this.R] == this.bq
                  && this.a[this.R][this.P] != 11
                  && (this.a[this.R][this.P] != 12 || !this.n)) {
                  this.bm = this.a[(this.bk + this.a - this.bp) % 4];
               }

               this.a[this.a]
                  .drawRegion(
                     this.d[4],
                     b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk]],
                     b.a[this.u[this.bj][this.bk]],
                     this.bn,
                     b.b[this.u[this.bj][this.bk]],
                     0,
                     this.bl + this.bo,
                     this.e[this.bj] + this.bm,
                     20
                  );
               if (this.bo == 0) {
                  this.bl = this.bl + this.bn + 1;
               }
            } else {
               this.a[this.a]
                  .drawRegion(
                     this.d[4],
                     b.a[this.t[this.bj][this.bk]],
                     58,
                     b.a[this.t[this.bj][this.bk] + 1] - b.a[this.t[this.bj][this.bk]],
                     15,
                     0,
                     this.bl,
                     this.e[this.bj],
                     20
                  );
               this.bl = this.bl + b.a[this.t[this.bj][this.bk] + 1] - b.a[this.t[this.bj][this.bk]] + 1;
            }
         }
      }
   }

   final void dQ() {
      if (this.aG != 0) {
         for (this.bj = 0; this.bj < this.aF; this.bj++) {
            if (this.l[this.bj] < this.o) {
               this.bl = this.k[this.bj] + (this.v[this.bj][0] + this.v[this.bj][1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W;

               for (this.bk = 0; this.bk < this.h[this.bj]; this.bk++) {
                  this.a[this.a]
                     .drawRegion(
                        this.d[4],
                        b.a[this.w[this.bj][this.bk]],
                        58,
                        b.a[this.w[this.bj][this.bk] + 1] - b.a[this.w[this.bj][this.bk]],
                        15,
                        0,
                        this.bl,
                        this.j[this.bj] + (this.v[this.bj][0] - this.v[this.bj][1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X - 2 * this.l[this.bj],
                        20
                     );
                  this.bl = this.bl + b.a[this.w[this.bj][this.bk] + 1] - b.a[this.w[this.bj][this.bk]] + 1;
               }
            }
         }
      }
   }

   final void dR() {
      if (this.aC == 1 && this.aA < 30) {
         this.br = this.G;
      } else {
         this.br = d.j[this.aC];
      }

      for (this.bj = this.F; this.bj < this.F + this.br; this.bj++) {
         if (this.bj >= this.G) {
            return;
         }

         this.bl = (this.l - this.m[this.bj]) / 2;

         for (this.bk = this.l[this.bj]; this.bk < this.l[this.bj + 1]; this.bk++) {
            if (this.s[this.aC][this.bk] != 100) {
               if (this.s[this.aC][this.bk] >= 101) {
                  this.bo = this.s[this.aC][this.bk] - 101;
                  this.a[this.a]
                     .drawRegion(
                        this.c[2],
                        this.aI[this.h[71] + this.aI[this.h[96] + this.bo]],
                        this.aI[this.h[72] + this.aI[this.h[96] + this.bo]],
                        this.aI[this.h[73] + this.aI[this.h[96] + this.bo]],
                        this.aI[this.h[74] + this.aI[this.h[96] + this.bo]],
                        0,
                        this.bl,
                        this.H + 20 * (this.bj - this.F) + (b.b[0] - this.aI[this.h[74] + this.aI[this.h[96] + this.bo]]) / 2,
                        20
                     );
                  this.bl = this.bl + this.aI[this.h[73] + this.aI[this.h[96] + this.bo]] + 1;
               } else {
                  if (this.s[this.aC][this.bk] / 30 == 0 && this.s[this.aC][this.bk] % 30 >= 14) {
                     this.bo = -1
                        - (
                              this.bn
                                 + b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30 + 1]
                                 - b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30]
                           )
                           / 2;
                  } else {
                     this.bo = 0;
                  }

                  this.bn = b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30 + 1]
                     - b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30];
                  this.a[this.a]
                     .drawRegion(
                        this.d[4],
                        b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30],
                        b.a[this.s[this.aC][this.bk] / 30],
                        this.bn,
                        b.b[this.s[this.aC][this.bk] / 30],
                        0,
                        this.bl + this.bo,
                        this.H + 20 * (this.bj - this.F),
                        20
                     );
                  if (this.bo == 0) {
                     this.bl = this.bl + this.bn + 1;
                  }
               }
            }
         }
      }
   }

   final void dS() {
      try {
         this.dV();
         if (this.y) {
            if (this.K == 0) {
               this.J = this.M;
            } else {
               this.H = this.L;
               this.I = this.M;
            }

            this.dT();
         }
      } catch (Exception var2) {
      }
   }

   final void a(boolean[] var1, byte[] var2, short[] var3, int[] var4, int var5, int var6, int var7) {
      try {
         for (this.bw = 0; this.bw < var6; this.bw++) {
            this.c <<= var5;
            this.by += var5;
            if (var1 != null) {
               if (var1[this.bw]) {
                  this.c++;
               }
            } else if (var2 != null) {
               this.c = this.c + (var2[this.bw] + var7);
            } else if (var3 != null) {
               this.c = this.c + (var3[this.bw] + var7);
            } else if (var4 != null) {
               this.c = this.c + (var4[this.bw] + var7);
            }

            if (this.by >= 32 || this.bw == var6 - 1) {
               while (this.by >= 8) {
                  this.a.write((int)(this.c >> this.by - 8));
                  this.by -= 8;
               }
            }
         }
      } catch (Exception var9) {
      }
   }

   final void b(boolean[] var1, byte[] var2, short[] var3, int[] var4, int var5, int var6, int var7) {
      try {
         this.bz = 1;

         for (this.bw = 0; this.bw < var5; this.bw++) {
            this.bz *= 2;
         }

         this.bz--;

         for (this.bw = 0; this.bw < var6; this.bw++) {
            while (this.by < var5) {
               this.c <<= 8;
               this.c = this.c + this.a.read();
               this.by += 8;
            }

            this.bx = (int)(this.c >> this.by - var5 & this.bz);
            this.bx -= var7;
            if (var1 != null) {
               if (this.bx > 0) {
                  var1[this.bw] = true;
               } else {
                  var1[this.bw] = false;
               }
            } else if (var2 != null) {
               var2[this.bw] = (byte)this.bx;
            } else if (var3 != null) {
               var3[this.bw] = (short)this.bx;
            } else if (var4 != null) {
               var4[this.bw] = this.bx;
            }

            this.by -= var5;
         }
      } catch (Exception var9) {
      }
   }

   final void dT() {
      try {
         this.a = new ByteArrayOutputStream();
         this.a = new DataOutputStream(this.a);
         this.a.write(this.E);
         this.a.write(this.F);
         this.a.write(this.G);
         this.a.write(this.H);
         this.a.write(this.I);
         this.a.write(this.J);
         this.by = 0;
         this.a(this.i, null, null, null, 1, this.i.length, 0);
         if (this.by > 0) {
            this.a.write((int)(this.c << 8 - this.by));
         }

         try {
            RecordStore.deleteRecordStore("pssav");
         } catch (Exception var3) {
         }

         this.a = RecordStore.openRecordStore("pssav", true);

         try {
            this.a.addRecord(this.a.toByteArray(), 0, this.a.size());
         } catch (Exception var2) {
         }

         this.a.closeRecordStore();
         this.a.close();
      } catch (Exception var4) {
      }
   }

   final void dU() {
      try {
         this.a = RecordStore.openRecordStore("pssav", true);
         this.y = false;
         if (this.a.getNumRecords() > 0) {
            this.y = true;
            System.gc();
            this.a = new DataInputStream(new ByteArrayInputStream(this.a.getRecord(1)));
            this.E = (byte)this.a.read();
            this.F = (byte)this.a.read();
            this.G = (byte)this.a.read();
            this.H = (byte)this.a.read();
            this.I = (byte)this.a.read();
            this.J = (byte)this.a.read();
            this.by = 0;
            this.b(this.i, null, null, null, 1, this.i.length, 0);
            this.v[8] = this.E;
            this.a.close();
         }

         this.a.closeRecordStore();
      } catch (Exception var2) {
      }
   }

   final void dV() {
      try {
         this.y = false;
         System.gc();
         this.a = new ByteArrayOutputStream();
         this.a = new DataOutputStream(this.a);
         this.dW();
         this.dX();
         this.dY();
         this.dZ();
         if (this.K == 0) {
            this.c = "pCuSav";
         } else {
            this.c = "pCaSav";
         }

         try {
            RecordStore.deleteRecordStore(this.c);
         } catch (Exception var3) {
         }

         this.a = RecordStore.openRecordStore(this.c, true);

         try {
            this.a.addRecord(this.a.toByteArray(), 0, this.a.size());
            this.y = true;
         } catch (Exception var2) {
         }

         this.a.closeRecordStore();
         this.a.close();
      } catch (Exception var4) {
      }
   }

   final void dW() {
      try {
         this.a.writeInt(this.b);
         if (this.K == 1) {
            this.a.write((byte)this.c);
         } else {
            this.a.write(this.N);
         }

         this.a.writeInt(this.d);
         this.a.writeInt(this.e);
         this.a.writeInt(this.g);
         this.a.writeInt(this.f);
         this.a.write(this.g);
         this.a.write(this.w);
         this.a.writeInt(this.i);
         this.a.write(this.P);
         this.a.write(this.y);
         this.a.write(this.R);
         this.a.writeInt(this.k);
         this.a.write(this.ab);
         this.a.writeShort(this.a);
         this.a.write(this.ac);
         this.a.write(this.ag);
         this.a.write(this.ah);
         this.a.write(this.ai);
         this.a.write(this.ak);
         if (this.K == 1) {
            this.a.write(this.D);
            this.a.write(this.Q);
         }

         this.by = 0;
         if (this.K == 1) {
            this.a(null, this.b, null, null, 1, this.b.length, 0);
         }

         this.a(this.j, null, null, null, 1, this.j.length, 0);

         for (this.bs = 0; this.bs < 3; this.bs++) {
            this.a(null, null, null, this.e[this.bs], 20, 1, 5000);
         }

         this.a(null, null, null, this.c[0], 24, d.k[4] + 2, 5000);
         this.a(null, null, null, this.c[1], 4, d.k[4] + 2, 1);
         this.a(null, null, null, this.c[2], 8, d.k[4] + 2, 1);
         if (this.K == 0) {
            for (this.bs = 3; this.bs < 8; this.bs++) {
               this.a(null, null, null, this.c[this.bs], 10, d.k[4] + 2, 1);
            }

            this.a(null, this.aW, null, null, 3, 4, 0);
            this.a(null, this.aX, null, null, 2, 4, 0);
         }

         for (this.bs = 0; this.bs < 30; this.bs++) {
            this.a(null, this.b[this.bs], null, null, 6, 30, 29);
            this.a(null, this.c[this.bs], null, null, 7, 30, 1);
         }
      } catch (Exception var2) {
      }
   }

   final void dX() {
      try {
         this.a(null, null, null, this.a, 5, 2, 1);

         for (this.bs = 0; this.bs < 4; this.bs++) {
            this.a(null, null, null, this.f[this.bs], 7, 2, 25);
         }

         for (this.bs = 0; this.bs < 222; this.bs++) {
            if (this.I[this.bs] < 1) {
               this.I[this.bs] = 1;
            }
         }

         this.a(null, this.B, null, null, 5, this.B.length, 1);
         this.a(null, this.C, null, null, 5, this.C.length, 1);
         this.a(null, this.D, null, null, 5, this.D.length, 1);
         this.a(null, this.E, null, null, 5, this.E.length, 1);
         this.a(null, this.G, null, null, 8, this.G.length, 128);
         this.a(null, this.H, null, null, 8, this.H.length, 128);
         this.a(null, this.A, null, null, 4, this.A.length, 1);
         this.a(null, this.F, null, null, 3, this.F.length, 0);
         this.a(null, this.I, null, null, 2, this.I.length, -1);
         this.a(null, this.W, null, null, 5, this.W.length, 1);
         this.a(null, this.X, null, null, 3, this.X.length, 0);

         for (this.bs = 0; this.bs < 3; this.bs++) {
            this.a(null, this.f[this.bs], null, null, 6, 200, 2);
            this.a(null, this.h[this.bs], null, null, 3, 222, 2);
         }

         this.a(null, this.L, null, null, 7, this.L.length, 10);
         this.a(null, null, this.b, null, 4, this.b.length, 1);
         this.a(null, this.M, null, null, 3, this.M.length, 1);
         this.a(null, null, this.e, null, 10, this.e.length, 10);

         for (this.bs = 0; this.bs < 30; this.bs++) {
            this.a(null, this.i[this.bs], null, null, 5, 2, 1);
         }
      } catch (Exception var2) {
      }
   }

   final void dY() {
      try {
         for (this.bs = 0; this.bs < 15; this.bs++) {
            this.a(null, this.k[this.bs], null, null, 5, 2, 1);
         }

         this.a(null, this.Z, null, null, 5, this.Z.length, 1);
         this.a(null, this.aa, null, null, 2, this.aa.length, 1);
         this.a(null, this.ab, null, null, 7, this.ab.length, 1);
         this.a(null, this.ad, null, null, 5, this.ad.length, 1);
         this.a(null, this.ae, null, null, 5, this.ae.length, 1);
         this.a(null, this.af, null, null, 8, this.af.length, 128);
         this.a(null, this.ag, null, null, 3, this.ag.length, 1);
         this.a(null, this.ah, null, null, 7, this.ah.length, 10);
         this.a(null, this.ai, null, null, 2, this.ai.length, 0);
         this.a(null, this.aj, null, null, 2, this.aj.length, 1);
         this.a(this.a, null, null, null, 1, this.a.length, 0);
         this.a(this.b, null, null, null, 1, this.b.length, 0);
         this.a(this.c, null, null, null, 1, this.c.length, 0);
         if (this.K == 1) {
            this.a(this.g, null, null, null, 1, this.g.length, 0);
         }

         for (this.bs = 0; this.bs < 2; this.bs++) {
            this.a(null, this.l[this.bs], null, null, 5, 42, 1);
            this.a(null, this.m[this.bs], null, null, 5, 42, 1);
            this.a(null, this.n[this.bs], null, null, 5, 42, 1);
         }

         this.a(null, this.ak, null, null, 7, this.ak.length, 10);
         this.a(this.d, null, null, null, 1, this.d.length, 0);
         this.a(this.e, null, null, null, 1, this.e.length, 0);
         this.a(this.f, null, null, null, 1, this.f.length, 0);
      } catch (Exception var2) {
      }
   }

   final void dZ() {
      try {
         if (this.K == 1) {
            this.a(this.h, null, null, null, 1, this.h.length, 0);
         }

         this.a(null, this.al, null, null, 4, this.al.length, 0);
         this.a(null, this.aE, null, null, 4, this.aE.length, 0);
         this.a(null, null, this.g, null, 9, this.g.length, 256);
         if (this.K == 1) {
            this.a(this.g, null, null, null, 1, this.g.length, 0);
            this.a(this.h, null, null, null, 1, this.h.length, 0);
         }

         if (this.by > 0) {
            this.a.write((int)(this.c << 8 - this.by));
         }

         for (this.bs = 0; this.bs < this.ae; this.bs++) {
            this.bu = 0;

            for (this.bt = 0; this.bt < 200; this.bt++) {
               if (this.B[this.bt] >= 0) {
                  this.bu = this.bu + this.g[this.bs][this.bt];
               }
            }

            if (this.a > 0) {
               this.bu = this.bu / this.a;
            }

            this.a.writeInt(this.bu);
         }
      } catch (Exception var2) {
      }
   }

   final void ea() {
      try {
         if (this.K == 0) {
            this.M = this.J;
         } else {
            if (this.F > this.H) {
               this.L = this.F;
               this.M = this.G;
               this.R = 10;
               this.w[10] = this.n[this.L];
               this.cu();
               return;
            }

            this.L = this.H;
            this.M = this.I;
         }

         this.g();
         if (this.K == 0) {
            this.c = "pCuSav";
         } else {
            this.c = "pCaSav";
         }

         this.a = RecordStore.openRecordStore(this.c, false);
         if (this.a.getNumRecords() > 0) {
            System.gc();
            this.a = new DataInputStream(new ByteArrayInputStream(this.a.getRecord(1)));
            this.eb();
            this.ec();
            this.ed();
            this.ee();
            this.ef();
            this.a.close();
         }

         this.a.closeRecordStore();
         this.az = 0;
         this.b = 0;
      } catch (Exception var2) {
      }
   }

   final void eb() {
      try {
         this.b = this.a.readInt();
         if (this.K == 1) {
            this.c = this.a.read();
         } else {
            this.N = (byte)this.a.read();
         }

         this.d = this.a.readInt();
         this.e = this.a.readInt();
         this.g = this.a.readInt();
         this.f = this.a.readInt();
         this.g = (byte)this.a.read();
         this.w = (byte)this.a.read();
         this.i = this.a.readInt();
         this.P = (byte)this.a.read();
         this.y = (byte)this.a.read();
         this.R = (byte)this.a.read();
         this.k = this.a.readInt();
         this.ab = (byte)this.a.read();
         this.a = this.a.readShort();
         this.ac = (byte)this.a.read();
         this.ag = (byte)this.a.read();
         this.ah = (byte)this.a.read();
         this.ai = (byte)this.a.read();
         this.ak = (byte)this.a.read();
         if (this.K == 1) {
            this.D = (byte)this.a.read();
            this.Q = (byte)this.a.read();
         }

         this.by = 0;
         if (this.K == 1) {
            this.b(null, this.b, null, null, 1, this.b.length, 0);
         }

         this.b(this.j, null, null, null, 1, this.j.length, 0);

         for (this.bs = 0; this.bs < 3; this.bs++) {
            this.b(null, null, null, this.e[this.bs], 20, 1, 5000);
         }

         this.b(null, null, null, this.c[0], 24, d.k[4] + 2, 5000);
         this.b(null, null, null, this.c[1], 4, d.k[4] + 2, 1);
         this.b(null, null, null, this.c[2], 8, d.k[4] + 2, 1);
         if (this.K == 0) {
            for (this.bs = 3; this.bs < 8; this.bs++) {
               this.b(null, null, null, this.c[this.bs], 10, d.k[4] + 2, 1);
            }

            this.b(null, this.aW, null, null, 3, 4, 0);
            this.b(null, this.aX, null, null, 2, 4, 0);
         }

         for (this.bs = 0; this.bs < 30; this.bs++) {
            this.b(null, this.b[this.bs], null, null, 6, 30, 29);
            this.b(null, this.c[this.bs], null, null, 7, 30, 1);
         }
      } catch (Exception var2) {
      }
   }

   final void ec() {
      try {
         this.b(null, null, null, this.a, 5, 2, 1);

         for (this.bs = 0; this.bs < 4; this.bs++) {
            this.b(null, null, null, this.f[this.bs], 7, 2, 25);
         }

         this.b(null, this.B, null, null, 5, this.B.length, 1);
         this.b(null, this.C, null, null, 5, this.C.length, 1);
         this.b(null, this.D, null, null, 5, this.D.length, 1);
         this.b(null, this.E, null, null, 5, this.E.length, 1);
         this.b(null, this.G, null, null, 8, this.G.length, 128);
         this.b(null, this.H, null, null, 8, this.H.length, 128);
         this.b(null, this.A, null, null, 4, this.A.length, 1);
         this.b(null, this.F, null, null, 3, this.F.length, 0);
         this.b(null, this.I, null, null, 2, this.I.length, -1);
         this.b(null, this.W, null, null, 5, this.W.length, 1);
         this.b(null, this.X, null, null, 3, this.X.length, 0);

         for (this.bs = 0; this.bs < 3; this.bs++) {
            this.b(null, this.f[this.bs], null, null, 6, 200, 2);
            this.b(null, this.h[this.bs], null, null, 3, 222, 2);
         }

         this.b(null, this.L, null, null, 7, this.L.length, 10);
         this.b(null, null, this.b, null, 4, this.b.length, 1);
         this.b(null, this.M, null, null, 3, this.M.length, 1);
         this.b(null, null, this.e, null, 10, this.e.length, 10);

         for (this.bs = 0; this.bs < 30; this.bs++) {
            this.b(null, this.i[this.bs], null, null, 5, 2, 1);
         }
      } catch (Exception var2) {
      }
   }

   final void ed() {
      try {
         for (this.bs = 0; this.bs < 15; this.bs++) {
            this.b(null, this.k[this.bs], null, null, 5, 2, 1);
         }

         this.b(null, this.Z, null, null, 5, this.Z.length, 1);
         this.b(null, this.aa, null, null, 2, this.aa.length, 1);
         this.b(null, this.ab, null, null, 7, this.ab.length, 1);
         this.b(null, this.ad, null, null, 5, this.ad.length, 1);
         this.b(null, this.ae, null, null, 5, this.ae.length, 1);
         this.b(null, this.af, null, null, 8, this.af.length, 128);
         this.b(null, this.ag, null, null, 3, this.ag.length, 1);
         this.b(null, this.ah, null, null, 7, this.ah.length, 10);
         this.b(null, this.ai, null, null, 2, this.ai.length, 0);
         this.b(null, this.aj, null, null, 2, this.aj.length, 1);
         this.b(this.a, null, null, null, 1, this.a.length, 0);
         this.b(this.b, null, null, null, 1, this.b.length, 0);
         this.b(this.c, null, null, null, 1, this.c.length, 0);
         if (this.K == 1) {
            this.b(this.g, null, null, null, 1, this.g.length, 0);
         }

         for (this.bs = 0; this.bs < 2; this.bs++) {
            this.b(null, this.l[this.bs], null, null, 5, 42, 1);
            this.b(null, this.m[this.bs], null, null, 5, 42, 1);
            this.b(null, this.n[this.bs], null, null, 5, 42, 1);
         }

         for (this.bs = 0; this.bs < 42; this.bs++) {
            this.ac[this.bs] = 0;
            if (this.Z[this.bs] == 23) {
               for (this.bt = 0; this.bt < 12; this.bt++) {
                  this.e[this.bs][this.bt] = -1;
               }
            }
         }

         this.b(null, this.ak, null, null, 7, this.ak.length, 10);
         this.b(this.d, null, null, null, 1, this.d.length, 0);
         this.b(this.e, null, null, null, 1, this.e.length, 0);
         this.b(this.f, null, null, null, 1, this.f.length, 0);
      } catch (Exception var2) {
      }
   }

   final void ee() {
      try {
         if (this.K == 1) {
            this.b(this.h, null, null, null, 1, this.h.length, 0);
         }

         this.b(null, this.al, null, null, 4, this.al.length, 0);
         this.b(null, this.aE, null, null, 4, this.aE.length, 0);
         this.b(null, null, this.g, null, 9, this.g.length, 256);
         if (this.K == 1) {
            this.b(this.g, null, null, null, 1, this.g.length, 0);
            this.b(this.h, null, null, null, 1, this.h.length, 0);
         } else {
            for (this.bs = 0; this.bs < this.g.length; this.bs++) {
               this.g[this.bs] = true;
            }

            for (this.bs = 0; this.bs < this.h.length; this.bs++) {
               this.h[this.bs] = true;
            }
         }

         for (this.bs = 0; this.bs < this.ae; this.bs++) {
            this.bu = this.a.readInt();
            this.bv = this.bu;
            if (100 - this.bu < this.bu) {
               this.bv = 100 - this.bu;
            }

            this.bv++;

            for (this.bt = 0; this.bt < 200; this.bt++) {
               if (this.B[this.bt] >= 0) {
                  this.g[this.bs][this.bt] = (byte)(this.bu + ((this.a.nextInt() & 65535) % this.bv - this.bv / 2));
               }
            }
         }
      } catch (Exception var2) {
      }
   }

   final void ef() {
      try {
         for (this.bs = 0; this.bs < 222; this.bs++) {
            if (this.B[this.bs] >= 0) {
               this.c[this.bs] = 5;
               this.J[this.bs] = 0;
               if (this.bs < 200) {
                  if (this.W[this.bs] == 11) {
                     this.W[this.bs] = 9;
                     this.ad[this.c[this.B[this.bs]][this.C[this.bs]]]--;
                  } else if (this.W[this.bs] == 12 || this.W[this.bs] == 13) {
                     this.e[this.c[this.B[this.bs]][this.C[this.bs]]][this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]] = (short)this.bs;
                     if (this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][4]] == 1
                        && this.W[this.bs] == 13) {
                        if (this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][2] + 2] == 0) {
                           this.G[this.bs] = this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][21]
                              + this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]];
                        }

                        if (this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][2] + 3] == 0) {
                           this.H[this.bs] = this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][22]
                              + this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]];
                        }

                        if (this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][2] + 4] == 0) {
                           this.F[this.bs] = this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][23]
                              + this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]];
                        }
                     }

                     this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]++;
                  }

                  this.N[this.bs] = -1;
                  this.O[this.bs] = -1;
               }
            }
         }

         this.az = 0;
         this.aG = 0;

         for (this.bs = 0; this.bs < 222; this.bs++) {
            this.d[this.bs] = -1;
            if (this.B[this.bs] >= 0) {
               if (this.A[this.bs] == 9
                  && this.b[this.B[this.bs]][this.C[this.bs]] >= 4
                  && this.b[this.B[this.bs]][this.C[this.bs]] <= 12
                  && this.ag[this.c[this.B[this.bs]][this.C[this.bs]]] == 4) {
                  this.c[this.m[0][this.c[this.B[this.bs]][this.C[this.bs]]]][this.m[1][this.c[this.B[this.bs]][this.C[this.bs]]]] = (short)this.bs;
               } else {
                  this.d[this.bs] = this.c[this.B[this.bs]][this.C[this.bs]];
                  this.c[this.B[this.bs]][this.C[this.bs]] = (short)this.bs;
               }
            }
         }

         for (this.bs = 0; this.bs < 24; this.bs++) {
            this.o = this.bs;
            this.cI();
         }

         for (this.Y = 0; this.Y < this.O / 5; this.Y++) {
            for (this.Z = 0; this.Z < this.O / 5; this.Z++) {
               this.cH();
            }
         }

         this.dy();

         for (this.bs = 0; this.bs < 42; this.bs++) {
            if (this.l[0][this.bs] >= 0 && this.aD[this.Z[this.bs]] == 0) {
               this.aD[this.Z[this.bs]] = (byte)(this.aA[this.Z[this.bs]] / b.au[0]);
               this.aD[24] = (byte)(this.aD[24] + this.aD[this.Z[this.bs]]);
            }
         }
      } catch (Exception var2) {
      }
   }
}
