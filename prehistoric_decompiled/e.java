/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  javax.microedition.lcdui.Graphics
 *  javax.microedition.lcdui.Image
 *  javax.microedition.lcdui.game.GameCanvas
 *  javax.microedition.rms.RecordStore
 */
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

/*
 * Illegal identifiers - consider using --renameillegalidents true
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class e
extends GameCanvas
implements Runnable {
    boolean a;
    Park a;
    boolean b;
    boolean c;
    boolean d;
    String a;
    String[] a;
    Thread a;
    Graphics a;
    Image a;
    Graphics b;
    byte a;
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
    int E = 1;
    byte ay;
    byte az;
    byte[][] t;
    byte[][] u;
    int[] c;
    int[] d = false;
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
    short j = 0;
    short k;
    byte[] aT;
    String b = 0L;
    StringBuffer a;
    InputStream a;
    ByteArrayOutputStream a;
    DataOutputStream a;
    DataInputStream a;
    RecordStore a;
    int I = 60;
    int J = 7;
    int K = 5;
    int[][] g;
    int[] m;
    a a = null;
    byte aJ;
    int L;
    int M;
    byte aK;
    byte aL;
    byte aM;
    byte aN;
    int N = 0;
    int O;
    int P = 0;
    boolean t;
    boolean u;
    int Q = 0;
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
    short l = 240;
    short m = 320;
    short n;
    short o;
    int ae;
    int[] n = 0;
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
    int aj = 0;
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
    int[] o = false;
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
    int az = 0;
    int aA;
    int aB;
    int aC;
    int aD;
    int aE;
    int aF;
    int aG = 0;
    int aH;
    int aI;
    boolean w;
    int[][] h;
    int aJ = 0;
    int aK = 0;
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
    short p = false;
    short q = true;
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
    String c = false;

    public e(Park park) {
        super(false);
        this.b = (byte)3;
        this.f = (byte)-1;
        this.i = (byte)-1;
        this.k = (byte)24;
        this.l = (byte)100;
        this.m = (byte)4;
        this.n = (byte)4;
        this.o = (byte)15;
        this.p = (byte)20;
        this.q = (byte)20;
        this.r = (byte)30;
        this.s = (byte)10;
        this.t = (byte)(this.m * 10);
        this.u = (byte)10;
        this.v = (byte)45;
        this.a = new int[][]{{500, 400, 500, 600, 650, 700}, {500, 300, 350, 400, 450, 500}};
        this.b = new int[][]{{700}, {600}};
        this.a = new int[][][]{new int[][]{{100, 2, 5}, {750, 5, 40}, {1500, 6, 80}, {3000, 7, 120}, {6000, 8, 150}, {10000, 9, 170}}, new int[][]{{100, 2, 5}, {1500, 6, 60}, {3000, 7, 100}, {5000, 8, 150}, {10000, 9, 180}, {15000, 9, 190}}};
        this.b = new int[][][]{this.b, this.a};
        this.x = (byte)7;
        this.b = new byte[19];
        this.F = (byte)-1;
        this.G = (byte)-1;
        this.H = (byte)-1;
        this.I = (byte)-1;
        this.J = (byte)-1;
        this.R = (byte)9;
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
        this.a = new byte[][]{this.c, this.d, new byte[0], new byte[0], this.l, new byte[0], this.m, this.t, this.n, this.s, new byte[0], this.o, {39}, {34}, this.p, this.q, this.r, this.e, this.f, this.g, this.h, this.i, this.j, new byte[0], new byte[0], this.u, this.k};
        this.v = new byte[]{6, 6, 0, 0, 1, 0, 2, 2, this.E, 5, 0, 0, 0, 0, 0, 0, 0, 2, 2, 2, 1, 3, 1, 0, 0, 0, 6, 0};
        this.w = new byte[]{109, 110, 3, 95, 2, 20, -1, -1, 23, 114, 0, 29, -1, -1, -1, -1, -1, 7, 0, 0, 0, 0, 0, 19, 38, 98, 0};
        this.x = new byte[3];
        this.y = new byte[3];
        this.c = new int[8][d.k[4] + 2];
        this.d = new int[][]{{0, 500}, {0, 10}, {0, 10}, {0, 50}};
        this.a = new short[]{40, 100, 250, 150, 300, 200, 350, 50, 200, 400, 250, 500, 300, 600};
        this.e = new int[3][2];
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
        this.aa = (byte)5;
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
        this.ad = (byte)6;
        this.ae = (byte)7;
        this.W = new byte[222];
        this.g = new byte[][]{this.P, this.Q, this.R, this.S, this.T, this.U, this.V, this.W, this.L};
        this.b = new short[][]{{20, 20, 25, 25, 20, 350, 50}, {12, 12, 16, 16, 12, 150, 25}};
        this.af = (byte)20;
        this.b = (short)2000;
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
        this.al = (byte)114;
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
        this.ay = (byte)20;
        this.t = new byte[this.ay][80];
        this.u = new byte[this.ay][80];
        this.c = new int[this.ay];
        this.d = new int[this.ay];
        this.e = new int[this.ay];
        this.f = new int[this.ay];
        this.g = new int[this.ay];
        this.l = new short[250];
        this.m = new short[250];
        this.aB = (byte)-1;
        this.i = new boolean[32];
        this.aD = (byte)2;
        this.j = new boolean[this.aD];
        this.aE = (byte)12;
        this.aF = (byte)100;
        this.v = new byte[this.aF][2];
        this.w = new byte[this.aF][5];
        this.h = new int[this.aF];
        this.i = new int[this.aF];
        this.j = new int[this.aF];
        this.k = new int[this.aF];
        this.l = new int[this.aF];
        this.aH = (byte)20;
        this.x = new byte[this.aH][2];
        this.aQ = new byte[this.aH];
        this.aR = new byte[this.aH];
        this.aS = new byte[this.aH];
        this.aI = (byte)-60;
        this.aT = new byte[2];
        this.a = new StringBuffer(50);
        this.g = new int[][]{{0, 15662897, 16762897, 16691973, 0}, {0, 8940804, 8928768, 8859904, 0}};
        this.m = new int[]{(240 - this.I) / 2, 0, (240 + this.I) / 2};
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
        this.a = park;
        this.setFullScreenMode(true);
    }

    final void a() {
        try {
            this.b[0] = Image.createImage((String)"/splash2.png");
            this.a.drawImage(this.b[0], 0, 0, 20);
            this.b[0] = null;
        }
        catch (Exception exception) {}
        this.a(15);
        System.gc();
        this.t();
        System.gc();
        this.dH();
        this.a(60);
        this.L = 0;
        while (this.L < 32) {
            this.i[this.L] = false;
            ++this.L;
        }
        this.L = 0;
        while (this.L < this.aD) {
            this.j[this.L] = false;
            ++this.L;
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
        this.L = 0;
        while (this.L < 10) {
            this.M = 0;
            while (this.M < 10) {
                this.d[this.L][this.M] = (byte)(-1 - (this.a.nextInt() & 0xFFFF) % 12);
                ++this.M;
            }
            ++this.L;
        }
        this.a[0][this.v[0] - 1] = 40;
        this.cu();
        this.a(100);
        this.c();
    }

    final void b() {
        try {
            this.L = 0;
            while (this.L < 4) {
                System.gc();
                this.a = this.getClass().getResourceAsStream("/gpack" + this.L + ".dat");
                if (this.a != null) {
                    this.M = 0;
                    while (this.M < this.a[this.L].length) {
                        System.gc();
                        this.u = this.a.read();
                        this.v = this.a.read();
                        int n = this.v * 256 + this.u;
                        if (n != 0) {
                            byte[] byArray = new byte[n];
                            this.a.read(byArray, 0, n);
                            this.a[this.L][this.M] = Image.createImage((byte[])byArray, (int)0, (int)n);
                        }
                        ++this.M;
                    }
                }
                this.a.close();
                this.a = null;
                this.a(82 + this.L * 5);
                ++this.L;
            }
            System.gc();
            this.a = Image.createImage((int)this.l, (int)this.m);
            this.a[1] = this.b = this.a.getGraphics();
            this.b[7] = this.a[10];
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void a(int n) {
        this.m[1] = (240 - this.I) / 2 + n * this.I / 100;
        this.q = 0;
        while (this.q < 2) {
            this.r = 0;
            while (this.r < this.K) {
                this.a.setColor(this.g[this.q][this.r]);
                this.a.drawLine(this.m[this.q], 320 - this.J + this.r, this.m[this.q + 1], 320 - this.J + this.r);
                ++this.r;
            }
            ++this.q;
        }
        this.q = 0;
        while (this.q < 2) {
            this.a.setColor(0);
            this.a.drawLine(this.m[this.q * 2], 320 - this.J, this.m[this.q * 2], 320 - this.J + this.K - 1);
            ++this.q;
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
            return;
        }
        this.b = false;
    }

    final void e() {
        if (this.b == 3 && this.R == 16) {
            return;
        }
        this.i = (byte)-1;
        this.q = true;
        this.aL = this.b;
        this.aM = this.R;
        this.aN = this.aA;
        this.b = (byte)3;
        this.R = (byte)16;
        this.cv();
        this.aa = (byte)5;
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
        if (this.b == 1 || this.b == 4 || this.b == 5) {
            this.aL = this.b;
            this.b = 0;
            this.a = 1;
            this.aa = (byte)5;
            this.x();
            this.al();
            this.a = 0;
            this.b = this.aL;
            this.aa = 0;
        } else {
            this.aa = (byte)5;
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
        this.f = (byte)-1;
        this.h = (byte)-1;
        this.N = 0;
        while (this.N < this.aD) {
            this.j[this.N] = false;
            ++this.N;
        }
        this.e[0][0] = this.k = this.b[this.K][this.M][this.L];
        this.e[1][0] = 0;
        this.e[2][0] = 0;
        this.N = 0;
        while (this.N < 8) {
            this.c[this.N][0] = this.N < 3 ? this.e[this.N][0] : 0;
            this.c[this.N][d.k[4]] = 1;
            ++this.N;
        }
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.w = (byte)-1;
        this.V = 0;
        this.b[this.ab][0] = 0;
    }

    final void h() {
        if (this.K == 1) {
            this.O = this.aI[this.h[134] + this.L];
            this.N = 0;
            while (this.N < 2) {
                this.O = 0;
                while (this.O < this.aJ[this.N]) {
                    this.a[this.N][this.O] = this.aI[this.h[40 + this.N] + this.aJ[this.N] * this.L + this.O] == 1;
                    ++this.O;
                }
                ++this.N;
            }
            this.N = 0;
            while (this.N < this.b.length) {
                this.b[this.N] = 0;
                ++this.N;
            }
            this.D = 0;
            this.e[0][1] = this.a[this.M][this.L][0];
            this.e[1][1] = this.a[this.M][this.L][1];
            this.e[2][1] = this.a[this.M][this.L][2];
        } else if (this.K == 0) {
            this.N = 0;
            while (this.N < 2) {
                this.O = 0;
                while (this.O < this.a[this.N].length) {
                    this.a[this.N][this.O] = true;
                    ++this.O;
                }
                ++this.N;
            }
            this.O = (byte)30;
        }
        this.ab = (byte)(this.O / 2);
        this.a[0] = this.ab;
        this.a[1] = 0;
        this.r();
    }

    final void i() {
        this.N = 0;
        while (this.N < this.O) {
            this.O = 0;
            while (this.O < this.O) {
                this.b[this.N][this.O] = (this.a.nextInt() & 0xFFFF) % 20 == 0 ? (byte)(-1 - (this.a.nextInt() & 0xFFFF) % 12) : (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                this.c[this.N][this.O] = 0;
                this.c[this.N][this.O] = -1;
                if (!((this.N + 1) % 5 != 0 && this.N + 1 != this.O || (this.O + 1) % 5 != 0 && this.O + 1 != this.O)) {
                    this.Y = (byte)(this.N / 5);
                    this.Z = (byte)(this.O / 5);
                    this.cH();
                }
                ++this.O;
            }
            ++this.N;
        }
        this.N = 0;
        while (this.N < 222) {
            this.d[this.N] = -1;
            this.B[this.N] = -1;
            ++this.N;
        }
        this.N = 0;
        while (this.N < 42) {
            this.l[0][this.N] = -1;
            ++this.N;
        }
        this.N = 0;
        while (this.N < 90) {
            this.ak[this.N] = -1;
            ++this.N;
        }
        this.N = 0;
        while (this.N < 30) {
            this.i[this.N][0] = -1;
            ++this.N;
        }
        this.N = 0;
        while (this.N < 15) {
            this.k[this.N][0] = -1;
            ++this.N;
        }
    }

    final void j() {
        this.N = 0;
        while (this.N < this.aF) {
            this.l[this.N] = this.o;
            ++this.N;
        }
        this.N = 0;
        while (this.N < this.aH) {
            this.x[this.N][0] = -1;
            ++this.N;
        }
        this.N = 0;
        while (this.N < 24) {
            this.al[this.N] = (byte)(this.aA[this.N] / b.au[0]);
            this.o = this.N;
            this.cI();
            this.aD[this.N] = 0;
            ++this.N;
        }
        this.aD[24] = 0;
        this.N = 0;
        while (this.N < 6) {
            this.aE[this.N] = b.aq[this.N];
            ++this.N;
        }
        this.N = 0;
        while (this.N < 27) {
            if (this.aI[this.h[57] + this.N] >= 0) {
                this.o = this.N;
                this.cJ();
            }
            ++this.N;
        }
        this.ai = 0;
        this.ak = 0;
        this.a = 0;
        this.c[2][d.k[4] + 1] = 0;
        this.ac = 0;
        this.N = 0;
        while (this.N < b.j[3] + 1) {
            this.e[this.N] = 0;
            ++this.N;
        }
        this.N = 0;
        while (this.N < 4) {
            this.aW[this.N] = 0;
            ++this.N;
        }
        this.y = 0;
        this.d = (byte)-1;
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
                    continue;
                }
                Thread.sleep(1L);
                this.b = System.currentTimeMillis();
                if (this.b <= this.a + 100L) continue;
                this.aS();
                this.k();
                this.a = 1;
                if (this.aa != 0) {
                    this.x();
                }
                this.a = 0;
                this.a[this.a].drawImage(this.a, 0, 0, 20);
                if (this.i >= 0) {
                    this.i = (byte)(this.i + 1);
                }
                if (this.i >= this.s) {
                    this.i = (byte)-1;
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
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void k() {
        if (this.b == 0) {
            if (this.e % (this.m * 2) == 0 && this.a < 200 - (30 - this.O - 5) * 10 && this.a < 200) {
                this.cS();
            }
            this.e = (byte)(this.e + 1);
            if (this.e >= this.t) {
                this.e = 0;
                this.g = (byte)(this.g + 1);
                if (this.g >= 16) {
                    this.g = 0;
                }
            }
            this.cL();
            this.cK();
            this.cU();
            if (this.h) {
                if (this.d >= 0) {
                    this.d = (byte)(this.d + 1);
                }
                if (this.d >= 2) {
                    this.d = (byte)-1;
                }
            }
            if (!(!this.g && this.e || this.h)) {
                if (this.d >= 0) {
                    this.d = (byte)(this.d + 1);
                    if (this.d < this.n) {
                        this.W = b.m[this.d];
                        this.X = b.n[this.d];
                        this.aa = (byte)5;
                    } else {
                        this.d = (byte)-1;
                    }
                }
                if (this.g && this.d >= 3) {
                    this.cc();
                    this.cn();
                    this.g = false;
                }
            }
            this.q = 0;
            while (this.q < this.aF) {
                if (this.l[this.q] < this.o) {
                    int n = this.q;
                    this.l[n] = this.l[n] + 1;
                    if (this.l[this.q] == this.o) {
                        this.aG = (byte)(this.aG - 1);
                    }
                }
                ++this.q;
            }
            this.dF();
        }
    }

    final void l() {
        this.aj = (byte)(this.aj + 1);
        if (this.aj >= 3) {
            this.aj = 0;
        }
        if (!this.e) {
            this.a[this.a].drawRegion(this.c[1], 0, 0, b.B[0] - 2, (int)b.B[1], 0, (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W, (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X, 20);
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
                this.x += b.B[0] / 2 - this.aI[this.h[51] + this.C] / 2;
                this.y += b.B[1] / 2 - this.aI[this.h[52] + this.C];
            }
            this.af();
            if (this.aX < 2) {
                this.a[this.a].drawRegion(this.c[2], (int)b.C[1], (int)b.D[1], (int)b.E[1], (int)b.F[1], 0, this.x + this.z / 2 - b.G[1], this.y + b.H[1], 20);
            }
            if (this.aX == 2) {
                this.a[this.a].drawRegion(this.c[2], (int)b.C[2], (int)b.D[2], (int)b.E[2], (int)b.F[2], 0, this.x + this.z / 2 - b.G[2], this.y - b.H[2], 20);
            }
            this.d = (byte)(this.d + 1);
            if (this.d >= this.k) {
                this.d = 0;
                return;
            }
        } else {
            if (this.h) {
                this.q = this.d < 0 ? 0 : (int)this.d;
                this.a[this.a].drawRegion(this.c[2], (int)b.I[this.q], (int)b.J[this.q], (int)b.K[this.q], (int)b.L[this.q], 0, (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + b.M[this.q], (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + b.N[this.q], 20);
                return;
            }
            if (this.c[this.a[0]][this.a[1]] > -1 || this.b[this.a[0]][this.a[1]] > 3 && this.b[this.a[0]][this.a[1]] <= 13 || this.b[this.a[0]][this.a[1]] <= -15 && this.b[this.a[0]][this.a[1]] >= -28) {
                this.a[this.a].drawRegion(this.c[2], (int)b.C[0], (int)b.D[0], (int)b.E[0], (int)b.F[0], 0, (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + b.G[0], (this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + b.H[0], 20);
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
                this.w = (byte)-1;
            }
            if (this.k < -50 && this.w == -1) {
                this.w = 0;
                this.f = 0;
                this.aC = 1;
                this.aB = this.aA = (byte)20;
                this.dI();
                this.u = true;
            }
            if (this.k < 0 && this.w > -1) {
                this.w = (byte)(this.w + 1);
                if (this.w >= 48) {
                    this.b(13);
                }
            }
            this.ad();
            if (this.K == 1 && (this.e[0][0] >= this.e[0][1] && this.e[1][0] >= this.e[1][1] && this.e[2][0] >= this.e[2][1] && this.L != 0 || this.L == 0 && this.D >= 8)) {
                this.b(12);
            }
            if (this.Q < 1) {
                if (this.K == 1 && this.L == 0 && this.D < 8) {
                    this.t = true;
                    this.P = this.aI[this.h[142] + this.D];
                    while (this.P < this.aI[this.h[142] + this.D + 1]) {
                        if (this.b[this.P] == 0) {
                            this.t = false;
                            break;
                        }
                        ++this.P;
                    }
                    if (this.t) {
                        this.q();
                    }
                }
            } else {
                this.Q = this.Q < 8 ? ++this.Q : 0;
            }
            if (this.g == 0) {
                ++this.b;
                if (this.e[b.j[3]] > 0) {
                    this.ab();
                    if (!this.u) {
                        this.f = 0;
                        this.aC = 1;
                        this.aB = this.aA = (byte)9;
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
                    ++this.c;
                    this.b(24);
                }
                if (this.K == 0 && this.b % 12 == 0) {
                    this.b(25);
                    this.V = this.h[0][0] == 0 ? (byte)(this.V + 1) : (byte)0;
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
            this.f = (byte)(this.f + 1);
            if (this.f >= this.p) {
                this.f = (byte)-1;
            }
        }
    }

    final void o() {
        if (this.b == 1) {
            this.S();
            return;
        }
        if (this.b == 2) {
            this.ak();
            return;
        }
        if (this.b == 3) {
            this.L();
            return;
        }
        if (this.b == 4) {
            this.T();
            return;
        }
        if (this.b == 5) {
            this.E();
            this.Q();
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

    final void b(int n) {
        this.b = (byte)3;
        this.R = (byte)n;
        this.cu();
        this.aa = (byte)5;
        this.i = 0;
    }

    final void q() {
        this.a = 1;
        this.al();
        this.a = 0;
        this.b = (byte)5;
        this.aa = 0;
        this.aC = 1;
        this.aA = (byte)(30 + this.D);
        this.dI();
        this.D = (byte)(this.D + 1);
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
            this.T = 0;
            while (this.T < 2) {
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
                ++this.T;
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void u() {
        try {
            this.R = 0;
            while (this.R < 24) {
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
                    this.S = 0;
                    while (this.S < 42) {
                        this.U = this.a.read() & 0xFF;
                        this.V = this.a.read() & 0xFF;
                        this.W = this.V * 256 + this.U;
                        if (this.S < 41) {
                            this.g[this.R][this.S + 1] = (short)(this.g[this.R][this.S] + this.W);
                        }
                        if (this.W > 0) {
                            this.a.read(this.o[this.R], this.g[this.R][this.S], this.W);
                        }
                        ++this.S;
                    }
                }
                ++this.R;
            }
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    final void v() {
        try {
            this.R = 0;
            while (this.R < 27) {
                if (this.T == 0) {
                    this.aH[this.R] = (byte)this.a.read();
                    this.aF[this.R] = (byte)this.a.read();
                    this.aG[this.R] = (byte)this.a.read();
                    this.U = this.a.read() & 0xFF;
                    this.V = this.a.read() & 0xFF;
                    this.p[this.R] = new byte[this.V * 256 + this.U];
                } else {
                    this.h[this.R][0] = 0;
                    this.S = 0;
                    while (this.S < 16) {
                        this.U = this.a.read() & 0xFF;
                        this.V = this.a.read() & 0xFF;
                        this.W = this.V * 256 + this.U;
                        if (this.S < 15) {
                            this.h[this.R][this.S + 1] = (short)(this.h[this.R][this.S] + this.W);
                        }
                        if (this.W > 0) {
                            this.a.read(this.p[this.R], this.h[this.R][this.S], this.W);
                        }
                        ++this.S;
                    }
                }
                ++this.R;
            }
            return;
        }
        catch (IOException iOException) {
            return;
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
                this.R = 0;
                while (this.R < 177) {
                    this.U = this.a.read() & 0xFF;
                    this.V = this.a.read() & 0xFF;
                    this.W = this.V * 256 + this.U;
                    if (this.R < 176) {
                        this.h[this.R + 1] = (short)(this.h[this.R] + this.W);
                    }
                    if (this.W > 0) {
                        this.a.read(this.aI, this.h[this.R], this.W);
                    }
                    ++this.R;
                }
            }
            return;
        }
        catch (IOException iOException) {
            return;
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
        this.q = 0;
        while (this.q < this.m / 4) {
            this.u = d.a[0][0] - (d.a[0][0] - d.a[1][0]) * this.q / (this.m / 4);
            this.v = d.a[0][1] - (d.a[0][1] - d.a[1][1]) * this.q / (this.m / 4);
            this.w = d.a[0][2] - (d.a[0][2] - d.a[1][2]) * this.q / (this.m / 4);
            this.a[this.a].setColor(this.u, this.v, this.w);
            this.a[this.a].drawLine(0, this.m / 2 + this.q, this.l, this.m / 2 + this.q);
            ++this.q;
        }
        this.a[this.a].setColor(d.a[1][0], d.a[1][1], d.a[1][2]);
        this.a[this.a].fillRect(0, this.m * 3 / 4, this.l, this.m / 4);
        this.a[this.a].setColor(14734447);
        this.q = 0;
        while (this.q < 2) {
            this.r = 0;
            while (this.r < 7) {
                if (this.q == 1) {
                    this.a[this.a].fillRect(22 + d.c[0][this.r], (int)d.c[this.r], d.c[1][this.r] - 22 - d.c[0][this.r], this.m - d.c[this.r]);
                }
                this.a[this.a].drawRegion(this.d[2], (int)b.p[this.q], 0, 22, 42, 0, (int)d.c[this.q][this.r], (int)d.c[this.r], 20);
                ++this.r;
            }
            ++this.q;
        }
        this.q = 0;
        while (this.q < 5) {
            this.a[this.a].drawRegion(this.d[5], (int)d.b[this.q], (int)d.c[this.q], (int)d.d[this.q], (int)d.e[this.q], 0, (int)d.d[this.q], (int)d.f[this.q], 20);
            ++this.q;
        }
    }

    final void z() {
        this.w = 0;
        this.ac = 0;
        this.ac = 15;
        this.q = 0;
        while (this.q < 2) {
            this.r = 0;
            while (this.r < 2) {
                this.a[this.a].drawRegion(this.d[3], (int)b.a[this.q][this.r], (int)b.r[this.r], (int)b.q[this.r], (int)b.s[this.r], 0, (int)b.b[this.q][this.r], 0 - this.ac, 20);
                ++this.r;
            }
            ++this.q;
        }
        if ((this.b == 2 || this.b == 3 && ((this.R == 19 || this.R == 21 || this.R == 22) && this.n || this.R == 20 || this.R == 23 || this.R == 24)) && !this.p) {
            this.ab = this.b == 2 ? (this.aX == 2 ? 1 : 0) : (int)((byte)(this.R - 19 + 2));
            this.A();
        }
    }

    final void a(int n, int n2, int n3, int n4) {
        this.X = n2 + this.X;
        while (this.X < n4) {
            this.Y = (this.X - this.X) % b.B[1] == 0 ? n + this.W : n - b.B[0] / 2 + this.W;
            while (this.Y < n3) {
                this.F();
                this.J();
                this.Y += b.B[0];
            }
            this.X += b.B[1] / 2;
        }
    }

    final void A() {
        this.q = 0;
        while (this.q < 4) {
            this.r = 0;
            while (this.r < d.a[d.g[this.ab]][this.q / 2]) {
                this.a[this.a].drawRegion(this.d[4], (int)d.a[d.g[this.ab]][this.q / 2][this.r], (int)d.b[d.g[this.ab]][this.q / 2][this.r], (int)d.c[d.g[this.ab]][this.q / 2][this.r], (int)d.d[d.g[this.ab]][this.q / 2][this.r], 0, d.a[d.g[this.ab]][this.q][this.r] + d.g[this.ab], d.b[d.g[this.ab]][this.q][this.r] + d.h[this.ab], 20);
                ++this.r;
            }
            ++this.q;
        }
    }

    final void B() {
        this.ad = this.b == 2 && this.aX == 2 ? 176 - this.aI[this.h[119] + this.r] / 2 : 196;
        if ((this.b == 2 || this.b == 3 && this.R == 26 && !this.d) && !this.o) {
            this.r = 0;
            while (this.r < 2) {
                this.a[this.a].drawRegion(this.d[1], (int)this.aI[this.h[116] + this.r], (int)this.aI[this.h[117] + this.r], (int)this.aI[this.h[118] + this.r], (int)this.aI[this.h[119] + this.r], 0, d.e[this.r] + this.a[(this.a + this.r * 2) % 4], this.ad, 20);
                ++this.r;
            }
        }
    }

    final void C() {
        if (this.b == 3 && this.w[this.R] >= 0 && this.aI[this.h[93] + this.R] == 0 || this.b == 2) {
            this.s = 0;
            while (this.s < 2) {
                this.t = 0;
                while (this.t < b.u[0]) {
                    this.a[this.a].drawRegion(this.d[5], (int)b.t[this.s], (int)b.b[0][this.t], 50, (int)b.c[0][this.t], 0, (int)d.i[this.s], d.f[2][0] + b.d[0][this.t], 20);
                    ++this.t;
                }
                ++this.s;
            }
        }
    }

    final void D() {
        this.a[this.a].setColor(14734447);
        this.a[this.a].fillRect((int)d.F[0], this.H + d.F[1], (int)d.F[2], (int)d.F[3]);
        this.r = 0;
        while (this.r < 11) {
            this.a[this.a].drawRegion(this.d[5], (int)d.m[this.r], (int)d.n[this.r], (int)d.o[this.r], (int)d.p[this.r], 0, (int)d.D[this.r], this.H + d.E[this.r], 20);
            ++this.r;
        }
        this.q = 0;
        while (this.q < 2) {
            this.r = 0;
            while (this.r < 3) {
                this.a[this.a].drawRegion(this.d[2], (int)b.p[this.q], (int)d.k[this.r], 22, (int)d.l[this.r], 0, (int)d.g[this.q][this.r], this.H + d.C[this.r], 20);
                ++this.r;
            }
            ++this.q;
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
            if (this.b[this.Z][this.aa] != 0 && this.e && this.ah > 0 && (this.aX == 0 && this.o[this.aW][this.g[this.aW][4] + 3] == 1 || this.aX == 1 && this.aW == 26)) {
                this.u = 0;
                while (this.u < 15) {
                    if (this.k[this.u][0] >= 0 && this.d[this.c[this.k[this.u][0]][this.k[this.u][1]]] && this.Z >= this.k[this.u][0] - b.j[0][0] && this.Z <= this.k[this.u][0] + b.j[0][1] && this.aa >= this.k[this.u][1] - b.j[1][0] && this.aa <= this.k[this.u][1] + b.j[1][1]) {
                        this.a[this.a].drawRegion(this.c[1], 0, b.B[1] * 2, b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
                        return;
                    }
                    ++this.u;
                }
            }
            if (this.b[this.Z][this.aa] == 0) {
                this.a[this.a].drawRegion(this.b[2], (int)b.O[this.c[this.Z][this.aa] / 4], (int)b.P[this.c[this.Z][this.aa] / 4], b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
                return;
            }
            if (this.b[this.Z][this.aa] > 0) {
                this.G();
                return;
            }
            this.H();
            return;
        }
        this.I();
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
            this.a[this.a].drawRegion(this.c[0], 0, b.B[1] * (this.b[this.Z][this.aa] - 1), b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
        }
    }

    final void H() {
        if (this.b[this.Z][this.aa] < 0 && this.b[this.Z][this.aa] >= -27) {
            if (this.aI[this.h[89] + -1 - this.b[this.Z][this.aa]] == 0) {
                this.a[this.a].drawRegion(this.b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
                return;
            }
            this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
            return;
        }
        this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
    }

    final void I() {
        if (this.Z == this.ab && this.aa < 0) {
            this.a[this.a].drawRegion(this.b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
            this.aw();
        } else {
            this.a[this.a].drawRegion(this.c[0], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
        }
        if (this.Z != -1 && this.aa != -1 && this.Z != this.O && this.aa != this.O && (this.Z != this.ab || this.aa > 0)) {
            this.an = (this.Z == this.ab - 1 || this.Z == this.ab + 1) && this.aa < 0 ? (byte)-11 : (this.aa == -2 && this.Z >= 0 && this.Z < this.O ? (byte)-12 : this.d[(this.Z & 0xFFFF) % 10][(this.aa & 0xFFFF) % 10]);
            this.aG();
        }
    }

    final void J() {
        this.Z = ((this.X - this.X) / (b.B[1] / 2) + (this.Y - this.W) / (b.B[0] / 2)) / 2 + this.f[0][0];
        this.aa = ((this.Y - this.W) / (b.B[0] / 2) - (this.X - this.X) / (b.B[1] / 2)) / 2 + this.f[0][1];
        this.u = 0;
        while (this.u < 4) {
            if ((this.Z == this.aI[this.h[39] + this.u * 6] || this.Z == this.O && this.aI[this.h[39] + this.u * 6] == 30) && (this.aa == this.aI[this.h[39] + this.u * 6 + 1] || this.aa == this.O && this.aI[this.h[39] + this.u * 6 + 1] == 30)) {
                this.v = 0;
                while (this.v < 2) {
                    this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[65] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]], (int)this.aI[this.h[66] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]], (int)this.aI[this.h[67] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]], (int)this.aI[this.h[68] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2]], 0, this.Y + this.aI[this.h[69] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2 + 1]], this.X + this.aI[this.h[70] + this.aI[this.h[39] + this.u * 6 + (this.v + 1) * 2 + 1]], 20);
                    ++this.v;
                }
            }
            ++this.u;
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
        this.q = -b.j[0][0];
        while (this.q <= b.j[0][1]) {
            if (this.a[0] + this.q >= 0) {
                if (this.a[0] + this.q >= this.O) {
                    return;
                }
                this.r = -b.j[1][0];
                while (this.r <= b.j[1][1]) {
                    if (this.a[1] + this.r >= 0) {
                        if (this.a[1] + this.r >= this.O) break;
                        if (this.b[this.a[0] + this.q][this.a[1] + this.r] != 0) {
                            this.Y = (this.a[0] + this.q + this.a[1] + this.r - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W;
                            this.X = (this.a[0] + this.q - this.a[1] - this.r - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X;
                            if (this.Y < this.l && this.Y + b.B[0] >= 0 && this.X < this.m && this.X + b.B[1] >= 0) {
                                this.a[this.a].drawRegion(this.c[1], 0, b.B[1] * 2, b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
                            }
                        }
                    }
                    ++this.r;
                }
            }
            ++this.q;
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
                    case 2: {
                        this.a(this.P, 1, 10);
                        break;
                    }
                    case 5: {
                        this.a(3, 5, 0);
                        break;
                    }
                    case 3: {
                        this.r = 0;
                        while (this.r < b.j[3]) {
                            this.a[this.a].drawRegion(this.a[this.aI[this.h[154] + this.r]], (int)this.aI[this.h[49] + this.r], (int)this.aI[this.h[50] + this.r], (int)this.aI[this.h[51] + this.r], (int)this.aI[this.h[52] + this.r], 0, (int)d.t[this.r], d.u[this.r] - this.aI[this.h[52] + this.r] / 2, 20);
                            ++this.r;
                        }
                        this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + 10], (int)this.aI[this.h[72] + 10], (int)this.aI[this.h[73] + 10], (int)this.aI[this.h[74] + 10], 0, (int)d.t[this.r], d.u[this.r] - this.aI[this.h[74] + 10] / 2, 20);
                        break;
                    }
                    case 4: {
                        this.r = 0;
                        while (this.r < 3) {
                            this.a[this.a].drawRegion(this.e[this.r], (int)this.aI[this.h[98] + this.r], (int)this.aI[this.h[99] + this.r], (int)this.aI[this.h[100] + this.r], (int)this.aI[this.h[101] + this.r], 0, 63 - this.aI[this.h[100] + this.r], d.z[this.r] - this.aI[this.h[101] + this.r] / 2, 20);
                            this.q = this.e[this.r][0] >= this.e[this.r][1] ? 0 : 1;
                            this.a[this.a].drawRegion(this.c[2], (int)b.f[this.q][0], (int)b.f[this.q][1], (int)b.f[this.q][2], (int)b.f[this.q][3], 0, this.f[this.r + 2] + this.d[this.r + 2] + 6, d.z[this.r] - b.f[this.q][3] / 2, 20);
                            ++this.r;
                        }
                        break;
                    }
                }
            }
            this.P();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void M() {
        if (this.v[this.R] > 0 && this.R != 26 && !this.p) {
            this.r = 0;
            while (this.r < 2) {
                this.q = this.P;
                if (this.w && this.P > 1) {
                    --this.q;
                }
                if (this.r == 0) {
                    this.v = this.a[this.R][this.P] == 11 ? 55 - this.aI[this.h[118]] : (this.a[this.R][this.P] == 12 && this.n ? 70 - this.aI[this.h[118]] : (this.l - this.d[this.q + this.aI[this.h[94] + this.R]]) / 2 - 12 - this.aI[this.h[118]]);
                    this.v += this.a[this.a % 4];
                    this.u = this.a[this.R][this.P] == 11 || this.a[this.R][this.P] == 10 || this.a[this.R][this.P] == 112 ? 0 : 1;
                }
                if (this.r == 1) {
                    this.v = this.a[this.R][this.P] == 11 ? this.l - 55 : (this.a[this.R][this.P] == 12 && this.n ? this.l - 70 : (this.l + this.d[this.q + this.aI[this.h[94] + this.R]]) / 2 + 12);
                    this.v -= this.a[this.a % 4];
                    this.u = this.a[this.R][this.P] == 11 || this.a[this.R][this.P] == 10 || this.a[this.R][this.P] == 112 ? 1 : 0;
                }
                this.w = this.a[this.R][this.P] == 11 ? d.e[this.R][this.aI[this.h[92] + this.R] - 1] - this.aI[this.h[119]] / 2 : (this.a[this.R][this.P] == 12 ? d.p[this.R] + 2 : d.d[this.R][0] + d.d[this.R][1] * this.P + 2);
                if (this.w) {
                    this.w = this.P < 1 ? (this.w += d.d[this.R][1] / 2) : (this.w -= d.d[this.R][1] / 2);
                }
                this.a[this.a].drawRegion(this.d[1], (int)this.aI[this.h[116] + this.u], (int)this.aI[this.h[117] + this.u], (int)this.aI[this.h[118] + this.u], (int)this.aI[this.h[119] + this.u], 0, this.v, this.w, 20);
                ++this.r;
            }
        }
    }

    final void N() {
        if (!this.p) {
            this.r = 0;
            while (this.r < this.aI[this.h[92] + this.R]) {
                this.l = this.x[this.r];
                this.m = d.e[this.R][this.r];
                this.n = d.h[1];
                this.o = this.y[this.r];
                this.R();
                ++this.r;
            }
        }
        if (this.R != 2 || this.aA != 29) {
            this.r = 0;
            while (!(this.r >= this.aI[this.h[93] + this.R] || this.p && this.r > 0)) {
                this.u = this.aI[this.h[144] + this.aI[this.h[145] + this.R] + this.r];
                this.s = 0;
                while (this.s < 2) {
                    this.t = 0;
                    while (this.t < b.u[this.u]) {
                        this.a[this.a].drawRegion(this.d[5], (int)b.t[this.s], (int)b.b[this.u][this.t], 50, (int)b.c[this.u][this.t], 0, (int)d.i[this.s], d.f[this.R][this.r] + b.d[this.u][this.t], 20);
                        ++this.t;
                    }
                    ++this.s;
                }
                ++this.r;
            }
        }
        if (!this.p && ((this.R == 19 || this.R == 21 || this.R == 22) && this.n || this.R == 20)) {
            this.a[this.a].drawRegion(this.a[this.aI[this.h[154] + this.U]], (int)this.aI[this.h[49] + this.U], (int)this.aI[this.h[50] + this.U], (int)this.aI[this.h[51] + this.U], (int)this.aI[this.h[52] + this.U], 0, (this.l - this.aI[this.h[51] + this.U]) / 2, d.q[this.ab - 2] - this.aI[this.h[52] + this.U] / 2, 20);
        }
    }

    final void O() {
        if (this.R == 23) {
            this.a[this.a].drawRegion(this.a[this.U], (int)this.aI[this.h[1] + this.U * 12], (int)this.aI[this.h[19] + this.U * 4], (int)this.aI[this.h[2] + this.U * 12], (int)this.aI[this.h[20] + this.U * 4], 0, d.x[2] - this.aI[this.h[2] + this.U * 12] / 2, d.y[2] - this.aI[this.h[20] + this.U * 4] / 2, 20);
            this.b(this.j, d.x[2], d.y[2] - this.aI[this.h[20] + this.U * 4] / 2);
            this.r = 0;
            while (this.r < 2) {
                this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + b.aj[this.r]], (int)this.aI[this.h[72] + b.aj[this.r]], (int)this.aI[this.h[73] + b.aj[this.r]], (int)this.aI[this.h[74] + b.aj[this.r]], 0, d.x[this.r] - this.aI[this.h[73] + b.aj[this.r]] - 7, d.y[this.r] - this.aI[this.h[74] + b.aj[this.r]] / 2, 20);
                ++this.r;
            }
        }
        if (this.R == 2 || this.R == 5 || this.p || this.R == 3) {
            this.dR();
            this.Q();
        }
        if (this.R == 12 || this.R == 13) {
            this.a[this.a].drawRegion(this.c[this.R - 12 + 4], 0, 0, (int)b.c[this.R - 12][0], (int)b.c[this.R - 12][1], 0, (this.l - b.c[this.R - 12][0]) / 2, (this.m - b.c[this.R - 12][1]) / 2, 20);
        }
    }

    final void a(int n, int n2, int n3) {
        this.ab = 8;
        this.A();
        this.a[this.a].drawRegion(this.e[n], (int)this.aI[this.h[98] + n], (int)this.aI[this.h[99] + n], (int)this.aI[this.h[100] + n], (int)this.aI[this.h[101] + n], 0, d.i[0] - this.aI[this.h[100] + n], (int)d.j[0], 20);
        this.r = 0;
        while (this.r < 2) {
            this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[13] + 8 + this.r], (int)this.aI[this.h[14] + 8 + this.r], (int)this.aI[this.h[15] + 8 + this.r], (int)this.aI[this.h[16] + 8 + this.r], 0, d.i[1] - this.aI[this.h[15]] + this.aI[this.h[17] + 8 + this.r], d.j[1] + this.aI[this.h[18] + 8 + this.r], 20);
            ++this.r;
        }
        this.q = n2 - 1;
        while (this.q >= 0) {
            this.r = this.c[n + this.q][d.k[4]] - 1;
            while (this.r > 0) {
                this.s = d.k[1] - this.c[n + this.q][this.r] * d.k[2] / this.d[n][0];
                this.t = d.k[1] - this.c[n + this.q][this.r - 1] * d.k[2] / this.d[n][0];
                if (d.k[3] > Math.abs(this.s - this.t)) {
                    this.a[this.a].setColor(b.a[n3 + this.q * 2 + 1]);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 1, this.s + 1, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r), this.t + 1);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 1, this.s - 1, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r), this.t - 1);
                    this.a[this.a].setColor(b.a[n3 + this.q * 2]);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 1, this.s, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r), this.t);
                } else {
                    this.a[this.a].setColor(b.a[n3 + this.q * 2 + 1]);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 2, this.s, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r) + 1, this.t);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r), this.s, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r) - 1, this.t);
                    this.a[this.a].setColor(b.a[n3 + this.q * 2]);
                    this.a[this.a].drawLine(d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - 1 - this.r) + 1, this.s, d.k[0] + d.k[3] * (this.c[n + this.q][d.k[4]] - this.r), this.t);
                }
                --this.r;
            }
            --this.q;
        }
    }

    final void P() {
        if (this.R == 10) {
            if (this.K == 1) {
                this.r = 0;
                while (this.r < 3) {
                    this.a[this.a].drawRegion(this.e[this.r], (int)this.aI[this.h[98] + this.r], (int)this.aI[this.h[99] + this.r], (int)this.aI[this.h[100] + this.r], (int)this.aI[this.h[101] + this.r], 0, this.l / 2 - 7 - this.aI[this.h[100] + this.r], d.d[this.R][0] + (this.r + 1) * d.d[this.R][1] - (this.aI[this.h[101] + this.r] - b.b[0]) / 2, 20);
                    ++this.r;
                }
            } else {
                this.dR();
                this.Q();
            }
        }
        if (this.R == 20) {
            this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + 10], (int)this.aI[this.h[72] + 10], (int)this.aI[this.h[73] + 10], (int)this.aI[this.h[74] + 10], 0, d.n[0] - this.aI[this.h[73] + 10], d.e[this.R][0] - this.aI[this.h[74] + 10] / 2, 20);
        }
        if (this.R == 25) {
            this.r = 0;
            while (this.r < this.u.length) {
                this.q = (this.l - d.A[3]) / 2 + 10 - this.aI[this.h[73] + b.al[this.h[0][this.r]]];
                this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + b.al[this.h[0][this.r]]], (int)this.aI[this.h[72] + b.al[this.h[0][this.r]]], (int)this.aI[this.h[73] + b.al[this.h[0][this.r]]], (int)this.aI[this.h[74] + b.al[this.h[0][this.r]]], 0, this.q, d.d[this.R][0] + d.d[this.R][1] * this.r - (this.aI[this.h[74] + b.al[this.h[0][this.r]]] - b.b[0]) / 2, 20);
                if (this.h[0][this.r] == 0) {
                    this.a[this.a].drawRegion(this.d[1], (int)this.aI[this.h[116] + 1], (int)this.aI[this.h[117] + 1], (int)this.aI[this.h[118] + 1], (int)this.aI[this.h[119] + 1], 0, this.q - 4 - this.aI[this.h[118] + 1], d.d[this.R][0] + d.d[this.R][1] * this.r - (this.aI[this.h[119] + 1] - b.b[0]) / 2, 20);
                }
                ++this.r;
            }
        }
        if (this.R == 24) {
            this.a.setClip((int)d.f[0], (int)d.f[1], (int)d.f[2], (int)d.f[3]);
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
            this.a[this.a].drawRegion(this.d[5], (int)b.x[0], (int)b.y[0], (int)b.z[0], (int)b.A[0], 0, (int)d.r[this.aC], (int)d.s[this.aC * 2], 20);
        }
        if (this.F + d.j[this.aC] < this.G) {
            this.a[this.a].drawRegion(this.d[5], (int)b.x[1], (int)b.y[1], (int)b.z[1], (int)b.A[1], 0, (int)d.r[this.aC], (int)d.s[this.aC * 2 + 1], 20);
        }
    }

    final void R() {
        try {
            if (this.l == 0 && this.R == 23) {
                this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + 5 - (this.o - 1) / 2], (int)this.aI[this.h[72] + 5 - (this.o - 1) / 2], (int)this.aI[this.h[73] + 5 - (this.o - 1) / 2], (int)this.aI[this.h[74] + 5 - (this.o - 1) / 2], 0, 87 - this.aI[this.h[73] + 5 - (this.o - 1) / 2], this.m - this.aI[this.h[74] + 5 - (this.o - 1) / 2] / 2, 20);
            } else {
                this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[112] + this.l], (int)this.aI[this.h[113] + this.l], (int)this.aI[this.h[114] + this.l], (int)this.aI[this.h[115] + this.l], 0, 87 - this.aI[this.h[114] + this.l], this.m - this.aI[this.h[115] + this.l] / 2, 20);
            }
            this.a[this.a].drawRegion(this.d[4], (int)d.a[0][0][0], (int)d.b[0][0][0], 30, (int)d.d[0][0][0], 0, 90, this.m - d.d[0][0][0] / 2, 20);
            this.a[this.a].drawRegion(this.d[4], d.c[0][0][0] - 30, (int)d.b[0][0][0], 30, (int)d.d[0][0][0], 0, 120, this.m - d.d[0][0][0] / 2 + 1, 20);
            this.s = 0;
            while (this.s < this.o) {
                if (this.l != 2) {
                    this.ae = this.l != 3 && this.l != 4 ? this.o - 1 : 10 - this.o;
                    if (this.l == 0 && this.R != 23) {
                        this.ae = 9;
                    }
                    this.a[this.a].drawRegion(this.c[2], (int)b.v[this.aI[this.h[91] + this.ae]], (int)b.w[this.aI[this.h[91] + this.ae]], 4, 10, 0, d.h[0] + this.n * this.s, this.m - 5, 20);
                } else {
                    this.a[this.a].drawRegion(this.c[2], 63, 11, 8, 8, 0, d.h[0] + this.n * this.s, this.m - 4, 20);
                }
                ++this.s;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void S() {
        this.q = 0;
        while (this.q < this.x) {
            this.r = this.q == 0 && this.z == 0 ? 0 : 1;
            this.a[this.a].drawRegion(this.d[1], (int)b.e[this.r], (int)b.f[this.r], (int)b.g[this.r], (int)b.h[this.r], 0, (int)d.a[this.z][this.q], (int)d.b[this.z][this.q], 20);
            this.r = (this.y + this.q) % this.x;
            this.a[this.a].drawRegion(this.d[1], (int)this.aI[this.h[120] + this.r], (int)this.aI[this.h[121] + this.r], (int)this.aI[this.h[122] + this.r], (int)this.aI[this.h[123] + this.r], 0, d.a[this.z][this.q] + this.aI[this.h[124] + this.r], d.b[this.z][this.q] + this.aI[this.h[125] + this.r], 20);
            ++this.q;
        }
        this.a[this.a].drawRegion(this.d[1], (int)this.aI[this.h[116] + 2], (int)this.aI[this.h[117] + 2], (int)this.aI[this.h[118] + 2], (int)this.aI[this.h[119] + 2], 0, 106, 25 + this.a[this.a % 4], 20);
        this.E();
    }

    final void T() {
        this.q = 0;
        while (this.q < this.O) {
            this.r = 0;
            while (this.r < this.O) {
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
                this.a[this.a].drawRegion(this.b[4], b.d[0] + b.d[2] * this.s, (int)b.d[1], (int)b.d[2], (int)b.d[3], 0, this.n[this.aO] + (this.q + this.r) * (b.d[2] / 2 + 1), this.m / 2 + (this.q - this.r - 1) * (b.d[3] / 2), 20);
                ++this.r;
            }
            ++this.q;
        }
        this.a[this.a].setColor(0);
        this.a[this.a].drawLine(this.n[this.aO] - 1, this.m / 2 - 1, this.n[this.aO] + this.O * (b.d[2] / 2 + 1) - 1, this.m / 2 - (this.O + 1) * (b.d[3] / 2) + 1);
        this.a[this.a].drawLine(this.n[this.aO] - 1, this.m / 2, this.n[this.aO] + this.O * (b.d[2] / 2 + 1) - 1, this.m / 2 + this.O * (b.d[3] / 2));
        this.a[this.a].drawLine(this.n[this.aO] + this.O * (b.d[2] + 2) - 2, this.m / 2 - 1, this.n[this.aO] + this.O * (b.d[2] / 2 + 1) - 1, this.m / 2 - (this.O + 1) * (b.d[3] / 2) + 1);
        this.a[this.a].drawLine(this.n[this.aO] + this.O * (b.d[2] + 2) - 2, this.m / 2, this.n[this.aO] + this.O * (b.d[2] / 2 + 1), this.m / 2 + this.O * (b.d[3] / 2) - 1);
    }

    final void U() {
        if (this.aX == 0) {
            this.an = this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa];
        } else if (this.aX == 1) {
            this.an = this.aI[this.h[89] + this.aW];
        } else if (this.aX == 3) {
            this.an = (byte)(this.aW + this.av);
        }
        if (this.aX == 3 && this.an == 13) {
            this.au();
        }
        if (this.aX == 3 && this.an != 13) {
            if ((this.an & 2) != 0) {
                this.an = 19;
                this.aK();
            } else if ((this.an & 1) != 0) {
                this.an = 20;
                this.aK();
            } else {
                this.a[this.a].drawRegion(this.b[2], (int)b.O[this.an / 4], (int)b.P[this.an / 4], b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
            }
        } else {
            this.V();
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
            this.a[this.a].drawRegion(this.b[2], (int)b.O[0], (int)b.P[0], b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
            return;
        }
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
                    this.a[this.a].drawRegion(this.c[0], 0, b.B[1] * (this.an - 1), b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
                    return;
                }
                if (this.an == 13) {
                    this.a[this.a].drawRegion(this.b[5], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
                }
            }
        }
    }

    final void W() {
        this.v = false;
        if (this.b[this.a[0] + this.Z][this.a[1] + this.aa] >= -13 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] <= 3) {
            if (this.aX == 0 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] != 0) {
                if (this.a[0] + this.B <= this.O - 1 && this.at == 1 && (this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa] != 5 && this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa] != 7 || this.b[this.a[0] + this.Z + 1][this.a[1] + this.aa] != 0 || (this.c[this.a[0] + this.Z + 1][this.a[1] + this.aa] & 2) == 0)) {
                    this.v = true;
                }
                if (this.a[1] > 0 && this.at == 0 && (this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa] != 6 && this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa] != 8 || this.b[this.a[0] + this.Z][this.a[1] + this.aa - 1] != 0 || (this.c[this.a[0] + this.Z][this.a[1] + this.aa - 1] & 1) == 0)) {
                    this.v = true;
                }
                if (this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa] == 13) {
                    this.aP = 1;
                    this.aa();
                }
            } else {
                this.X();
            }
        }
        this.Y();
        if (this.v) {
            this.a[this.a].drawRegion(this.c[1], 0, 0, b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
            return;
        }
        this.f = false;
        this.a[this.a].drawRegion(this.c[1], 0, (int)b.B[1], b.B[0] - 2, (int)b.B[1], 0, this.Y, this.X, 20);
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
                this.aP = (byte)2;
                this.aa();
            }
        }
    }

    final void Y() {
        if (this.aX == 0 && this.aW != 22 && this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa] == 1) {
            this.v = true;
        }
        if (this.aX == 3 && this.b[this.a[0]][this.a[1]] == 0) {
            if (this.aW + this.av == 2 && (this.c[this.a[0]][this.a[1]] & 2) == 0) {
                this.v = true;
                if (this.a[0] > 0) {
                    if (this.b[this.a[0] - 1][this.a[1]] <= -15 && this.b[this.a[0] - 1][this.a[1]] >= -27 && this.aI[this.h[163] - 1 - this.b[this.a[0] - 1][this.a[1]]] == 1) {
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
                    if (this.b[this.a[0]][this.a[1] + 1] <= -15 && this.b[this.a[0]][this.a[1] + 1] >= -27 && this.aI[this.h[164] - 1 - this.b[this.a[0]][this.a[1] + 1]] == 1) {
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
        if (this.b[this.a[0] + this.Z][this.a[1] + this.aa] >= -13 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] != 0 && this.b[this.a[0] + this.Z][this.a[1] + this.aa] <= 3) {
            this.v = true;
            this.aV[0] = (byte)(this.a[0] + this.Z);
            this.aV[1] = (byte)(this.a[1] + this.aa);
            this.aR = 0;
            this.aQ = 0;
            while (this.aQ < 4) {
                if (this.aV[0] + this.aI[this.h[31] + this.aQ * 2] >= this.O || this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1] >= this.O || this.aV[0] + this.aI[this.h[31] + this.aQ * 2] < 0 || this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1] < 0) {
                    this.aU[this.aQ] = 1;
                } else {
                    this.aU[this.aQ] = this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]];
                    if ((this.aU[this.aQ] == 7 || this.aU[this.aQ] == 5) && this.aQ == 1 || (this.aU[this.aQ] == 8 || this.aU[this.aQ] == 6) && this.aQ == 0 || this.aU[this.aQ] == 13) {
                        this.aR = (byte)(this.aR + 1);
                    }
                }
                this.aQ = (byte)(this.aQ + 1);
            }
            if (this.aR > this.aP) {
                this.v = false;
                return;
            }
            this.aS = 0;
            while (this.aS < 4) {
                if (this.aU[this.aS] == 13) {
                    this.aV[0] = (byte)(this.a[0] + this.Z + this.aI[this.h[31] + this.aS * 2]);
                    this.aV[1] = (byte)(this.a[1] + this.aa + this.aI[this.h[31] + this.aS * 2 + 1]);
                    this.aR = 0;
                    this.aQ = 0;
                    while (this.aQ < 4) {
                        if (this.aV[0] + this.aI[this.h[31] + this.aQ * 2] < this.O && this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1] < this.O && this.aV[0] + this.aI[this.h[31] + this.aQ * 2] >= 0 && this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1] >= 0 && ((this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 7 || this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 5) && this.aQ == 1 || (this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 8 || this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 6) && this.aQ == 0 || this.b[this.aV[0] + this.aI[this.h[31] + this.aQ * 2]][this.aV[1] + this.aI[this.h[31] + this.aQ * 2 + 1]] == 13)) {
                            this.aR = (byte)(this.aR + 1);
                        }
                        this.aQ = (byte)(this.aQ + 1);
                    }
                    if (this.aR > 1) {
                        this.v = false;
                        return;
                    }
                }
                this.aS = (byte)(this.aS + 1);
            }
        }
    }

    final void ab() {
        this.k -= this.e[b.j[3]];
        this.e += this.e[b.j[3]];
        this.af = 200;
        while (this.af < 222) {
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
            ++this.af;
        }
    }

    final void ac() {
        this.ag = 0;
        while (this.ag < 8) {
            this.ah = 0;
            while (this.ah < d.k[4] - 1) {
                this.c[this.ag][d.k[4] - 1 - this.ah] = this.c[this.ag][d.k[4] - 2 - this.ah];
                ++this.ah;
            }
            this.c[this.ag][0] = this.c[this.ag][d.k[4] + 1];
            if (this.c[this.ag][d.k[4]] < d.k[4]) {
                int[] nArray = this.c[this.ag];
                short s = d.k[4];
                nArray[s] = nArray[s] + 1;
            }
            if (this.c[this.ag][0] < 0) {
                this.c[this.ag][0] = 0;
            }
            ++this.ag;
        }
        this.g += this.c[1][0];
        this.c[3][0] = 0;
        this.ag = 0;
        while (this.ag < this.O / 5) {
            this.ah = 0;
            while (this.ah < this.O / 5) {
                int[] nArray = this.c[3];
                nArray[0] = nArray[0] + this.a[this.ag][this.ah];
                ++this.ah;
            }
            ++this.ag;
        }
        int[] nArray = this.c[3];
        nArray[0] = nArray[0] / 10;
        int[] nArray2 = this.c[3];
        nArray2[0] = nArray2[0] + (this.aD[24] + this.ai * 2 + this.ak + this.a);
        int[] nArray3 = this.c[3];
        nArray3[0] = nArray3[0] * this.c[1][0];
        int[] nArray4 = this.c[3];
        nArray4[0] = nArray4[0] / 9;
        this.ag = 4;
        while (this.ag < 8) {
            if (this.b % 3 == 0) {
                this.aW[this.ag - 4] = this.c[this.ag][1] < this.a[this.M * 7 + this.aX[this.ag - 4] * 2 + 1] ? (byte)((this.a.nextInt() & 0xFFFF) % 4) : (this.c[this.ag][1] > this.a[this.M * 7 + this.aX[this.ag - 4] * 2 + 2] ? (byte)((this.a.nextInt() & 0xFFFF) % 4 + 4) : (byte)((this.a.nextInt() & 0xFFFF) % 8));
            }
            if ((this.a.nextInt() & 0xFFFF) % 5 == 0) {
                this.aX[this.ag - 4] = (byte)((this.a.nextInt() & 0xFFFF) % 3);
            }
            this.ah = (this.a.nextInt() & 0xFFFF) % this.a[this.M * 7];
            this.ai = this.a[this.M * 7] / 2;
            this.c[this.ag][0] = this.c[this.ag][1] + this.aI[this.h[176] + this.aW[this.ag - 4] * 3 + this.b % 3] + this.ah - this.ai;
            if (this.c[this.ag][0] < 0) {
                this.c[this.ag][0] = 0;
            }
            ++this.ag;
        }
    }

    final void ad() {
        this.ag = 0;
        while (this.ag < 3) {
            switch (this.ag) {
                case 0: {
                    this.c[this.ag][d.k[4] + 1] = this.k;
                    break;
                }
                case 1: {
                    if (this.a > 0) {
                        this.c[this.ag][d.k[4] + 1] = 0;
                        this.ah = 0;
                        while (this.ah < 200) {
                            if (this.B[this.ah] >= 0) {
                                int[] nArray = this.c[this.ag];
                                int n = d.k[4] + 1;
                                nArray[n] = nArray[n] + this.P[this.ah];
                            }
                            ++this.ah;
                        }
                        int[] nArray = this.c[this.ag];
                        int n = d.k[4] + 1;
                        nArray[n] = nArray[n] / this.a;
                        int[] nArray2 = this.c[this.ag];
                        int n2 = d.k[4] + 1;
                        nArray2[n2] = nArray2[n2] / 10;
                        break;
                    }
                    this.c[this.ag][d.k[4] + 1] = 0;
                    break;
                }
                case 2: {
                    this.c[this.ag][d.k[4] + 1] = this.a;
                }
            }
            ++this.ag;
        }
        this.ag = 0;
        while (this.ag < 3) {
            this.e[this.ag][0] = this.c[this.ag][d.k[4] + 1];
            ++this.ag;
        }
    }

    final void ae() {
        this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[106] + this.d], (int)this.aI[this.h[107] + this.d], (int)this.aI[this.h[108] + this.d], (int)this.aI[this.h[109] + this.d], 0, this.Y + this.aI[this.h[110] + this.an] - this.aI[this.h[108] + this.d] / 2, this.X + this.aI[this.h[111] + this.an] - this.aI[this.h[109] + this.d] / 2, 20);
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
                    this.aM[0] = 0;
                    while (this.aM[0] < this.o[this.ar][this.g[this.ar][0]]) {
                        this.aM[1] = 0;
                        while (this.aM[1] < this.o[this.ar][this.g[this.ar][0] + 1] && this.o[this.ar][this.g[this.ar][37] + (this.at * this.o[this.ar][this.g[this.ar][0]] + this.aM[0]) * this.o[this.ar][this.g[this.ar][0] + 1] + this.aM[1]] != 10) {
                            this.aM[1] = (byte)(this.aM[1] + 1);
                        }
                        if (this.aM[1] < this.o[this.ar][this.g[this.ar][0] + 1]) break;
                        this.aM[0] = (byte)(this.aM[0] + 1);
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
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ag() {
        this.X = this.y;
        while (this.X <= this.y + this.A - b.B[1]) {
            this.Y = (this.X - this.y) % b.B[1] == 0 ? this.x : this.x + b.B[0] / 2;
            while (this.Y <= this.x + this.z - b.B[0]) {
                this.Z = ((this.X - this.y) / (b.B[1] / 2) + (this.Y - this.x) / (b.B[0] / 2)) / 2 + this.b[0];
                this.aa = ((this.Y - this.x) / (b.B[0] / 2) - (this.X - this.y) / (b.B[1] / 2)) / 2 + this.b[1];
                if ((this.j != 1 || this.b != 0 || this.Z >= b.a[this.at][this.j][0] && this.aa >= b.b[this.at][this.j][0]) && this.Z >= 0 && this.aa >= 0 && this.Z < this.B && this.aa < this.C) {
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
                    if (this.b != 0 || this.g) {
                        this.U();
                    } else {
                        this.W();
                    }
                }
                this.Y += b.B[0];
            }
            this.X += b.B[1] / 2;
        }
    }

    final void ah() {
        if (!(this.b == 0 && this.d / this.m % 2 != 0 || this.b != 0 && this.aX == 3)) {
            this.X = this.y;
            while (this.X <= this.y + this.A - b.B[1]) {
                this.Y = (this.X - this.y) % b.B[1] == 0 ? this.x : this.x + b.B[0] / 2;
                while (this.Y <= this.x + this.z - b.B[0]) {
                    this.Z = ((this.X - this.y) / (b.B[1] / 2) + (this.Y - this.x) / (b.B[0] / 2)) / 2 + this.b[0];
                    this.aa = ((this.Y - this.x) / (b.B[0] / 2) - (this.X - this.y) / (b.B[1] / 2)) / 2 + this.b[1];
                    if ((this.j != 1 || this.b != 0 || this.Z >= b.a[this.at][this.j][0] && this.aa >= b.b[this.at][this.j][0]) && this.Z >= 0 && this.aa >= 0 && this.Z < this.B && this.aa < this.C) {
                        if (this.aX < 2) {
                            this.an = this.aX == 0 ? this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.Z) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aa] : (this.b != 0 ? (byte)(-1 - this.aW) : this.au);
                            if (this.an > 3) {
                                this.ai();
                            } else {
                                if (this.aW == 26) {
                                    this.an = b.i[this.Z][this.aa];
                                }
                                if (this.an < 0 && this.an >= -27) {
                                    this.aq = 0;
                                    this.r = this.b != 0;
                                    this.s = this.b == 0;
                                    this.aH();
                                }
                            }
                        } else {
                            this.U();
                        }
                    }
                    this.Y += b.B[0];
                }
                this.X += b.B[1] / 2;
            }
        }
    }

    final void ai() {
        this.as = 0;
        this.am = this.o[this.ar][this.g[this.ar][38] + (this.at * this.o[this.ar][this.g[this.ar][0]] + this.Z) * this.o[this.ar][this.g[this.ar][0] + 1] + this.aa];
        this.a(true);
        if (this.an == 10) {
            this.aD();
            if (this.o[this.ar][this.g[this.ar][4] + 3] == 1 && this.b != 0) {
                this.q = 0;
                while (this.q < b.am[2]) {
                    this.a[this.a].drawRegion(this.d[1], (int)this.aI[this.h[165] + b.an[2] + this.q], (int)this.aI[this.h[166] + b.an[2] + this.q], (int)this.aI[this.h[167] + b.an[2] + this.q], (int)this.aI[this.h[168] + b.an[2] + this.q], 0, d.a[0][3][0] + b.o[0] + this.aI[this.h[169] + b.an[2] + this.q], d.b[0][0][0] + b.o[1] + this.aI[this.h[170] + b.an[2] + this.q], 20);
                    ++this.q;
                }
            }
        }
        if (this.an == 9 || this.an == 11 || this.an == 12) {
            this.aD();
        }
        this.ao = this.an == 11 ? (byte)1 : 0;
        this.ap = this.an == 12 ? (byte)1 : 0;
        this.b(true);
    }

    final void aj() {
        this.s = this.b == 0 ? this.y : 176 - this.aI[this.h[52] + this.C] / 2;
        this.a[this.a].drawRegion(this.a[this.aW], (int)this.aI[this.h[49] + this.C], (int)this.aI[this.h[50] + this.C], (int)this.aI[this.h[51] + this.C], (int)this.aI[this.h[52] + this.C], 0, this.x, this.s, 20);
        this.f = false;
        switch (this.C) {
            case 0: 
            case 1: {
                if (this.b[this.a[0]][this.a[1]] != 0) break;
                this.f = true;
                return;
            }
            case 2: {
                if (this.b[this.a[0]][this.a[1]] <= 3 || this.Z[this.c[this.a[0]][this.a[1]]] != 23 || this.a[this.c[this.a[0]][this.a[1]]]) break;
                this.f = true;
                return;
            }
            case 3: 
            case 4: 
            case 5: {
                if (this.b[this.a[0]][this.a[1]] >= 0 || this.aI[this.h[56] + -1 - this.b[this.a[0]][this.a[1]]] != this.C || this.d[this.c[this.a[0]][this.a[1]]]) break;
                this.f = true;
            }
        }
    }

    final void ak() {
        if (!this.p) {
            this.aj = 0;
            while (this.aj < this.aI[this.h[132] + this.aX * 2]) {
                this.a[this.a].drawRegion(this.e[this.aj], (int)this.aI[this.h[98] + this.aj], (int)this.aI[this.h[99] + this.aj], (int)this.aI[this.h[100] + this.aj], (int)this.aI[this.h[101] + this.aj], 0, d.n[this.aI[this.h[132] + this.aX * 2 + 1] + this.aj * 2] - this.aI[this.h[100] + this.aj], 105, 20);
                ++this.aj;
            }
            if (this.aX < 2) {
                this.a.setClip((int)d.f[0], (int)d.f[1], (int)d.f[2], (int)d.f[3]);
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
        this.X = -(b.B[1] / 2) - 1 * b.B[1] + this.X;
        while (this.X < this.m + 4 * b.B[1]) {
            this.Y = (this.X - this.X) % b.B[1] == 0 ? -1 * b.B[0] + this.W : -(b.B[0] / 2) - 1 * b.B[0] + this.W;
            while (this.Y < this.l + 1 * b.B[0]) {
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
                    if (this.an == 0 || this.an > 3) {
                        this.am();
                        this.ap();
                        this.ao();
                    } else {
                        this.an();
                    }
                }
                this.Y += b.B[0];
            }
            this.X += b.B[1] / 2;
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
            if (this.an == 11 && (this.ag[this.c[this.Z][this.aa]] != 1 && this.ag[this.c[this.Z][this.aa]] != 0 || this.aa != this.ae[this.c[this.Z][this.aa]]) && (this.ag[this.c[this.Z][this.aa]] != 2 || this.aa != this.n[1][this.c[this.Z][this.aa]])) {
                this.ao = 1;
            }
            this.ap = 0;
            if (this.an == 12 && (this.ag[this.c[this.Z][this.aa]] != 1 && this.ag[this.c[this.Z][this.aa]] != 0 || this.Z != this.ae[this.c[this.Z][this.aa]]) && (this.ag[this.c[this.Z][this.aa]] != 2 || this.Z != this.n[0][this.c[this.Z][this.aa]])) {
                this.ap = 1;
            }
            if (this.ar != 22) {
                this.am = this.o[this.ar][this.g[this.ar][38] + (this.aa[this.c[this.Z][this.aa]] * this.o[this.ar][this.g[this.ar][0]] + this.Z - this.l[0][this.c[this.Z][this.aa]]) * this.o[this.ar][this.g[this.ar][0] + 1] + this.aa - this.l[1][this.c[this.Z][this.aa]]];
                return;
            }
            if (this.an == 6 || this.an == 8) {
                this.am = (byte)74;
            }
            if (this.an == 5 || this.an == 7) {
                this.am = (byte)-123;
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
            if (this.an <= -15 && this.e / this.m % 2 != 0 && (this.f[this.c[this.Z][this.aa]] || this.aI[this.h[56] + -1 - this.an] >= 0 && !this.d[this.c[this.Z][this.aa]])) {
                this.q = this.aI[this.h[163] - 1 - this.an] == 1 ? 1 : 0;
                this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[165] + b.an[this.q]], (int)this.aI[this.h[166] + b.an[this.q]], (int)this.aI[this.h[167] + b.an[this.q]], (int)this.aI[this.h[168] + b.an[this.q]], 0, this.Y + this.aI[this.h[169] + b.an[this.q]], this.X + this.aI[this.h[170] + b.an[this.q]], 20);
            }
            if (this.an <= -15 && this.g == 0 && this.e == 0 && this.ak[this.c[this.Z][this.aa]] >= 0 && this.aI[this.h[56] + -1 - this.an] >= 0 && this.d[this.c[this.Z][this.aa]]) {
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
                        this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[165] + b.an[this.q]], (int)this.aI[this.h[166] + b.an[this.q]], (int)this.aI[this.h[167] + b.an[this.q]], (int)this.aI[this.h[168] + b.an[this.q]], 0, this.Y + this.aI[this.h[169] + b.an[this.q]], this.X + this.aI[this.h[170] + b.an[this.q]], 20);
                    } else if (!this.c[this.c[this.Z][this.aa]]) {
                        this.r = 0;
                        while (this.r < b.am[3]) {
                            this.a[this.a].drawRegion(this.d[1], (int)this.aI[this.h[165] + b.an[3] + this.r], (int)this.aI[this.h[166] + b.an[3] + this.r], (int)this.aI[this.h[167] + b.an[3] + this.r], (int)this.aI[this.h[168] + b.an[3] + this.r], 0, this.Y + this.aI[this.h[169] + b.an[3] + this.r], this.X + this.aI[this.h[170] + b.an[3] + this.r], 20);
                            ++this.r;
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
                this.q = 0;
                while (this.q < b.am[2]) {
                    this.a[this.a].drawRegion(this.d[1], (int)this.aI[this.h[165] + b.an[2] + this.q], (int)this.aI[this.h[166] + b.an[2] + this.q], (int)this.aI[this.h[167] + b.an[2] + this.q], (int)this.aI[this.h[168] + b.an[2] + this.q], 0, this.Y + this.aI[this.h[169] + b.an[2] + this.q], this.X + this.aI[this.h[170] + b.an[2] + this.q], 20);
                    ++this.q;
                }
            }
            if (this.ah[this.c[this.Z][this.aa]] < 10 && this.e / this.m % 2 == 1) {
                this.q = 0;
                while (this.q < b.am[4]) {
                    this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[165] + b.an[4] + this.q], (int)this.aI[this.h[166] + b.an[4] + this.q], (int)this.aI[this.h[167] + b.an[4] + this.q], (int)this.aI[this.h[168] + b.an[4] + this.q], 0, this.Y + this.aI[this.h[169] + b.an[4] + this.q], this.X + this.aI[this.h[170] + b.an[4] + this.q], 20);
                    ++this.q;
                }
            }
        }
    }

    final void aq() {
        if (this.b == 0 && !this.e && !this.h) {
            this.a[this.a].drawRegion(this.d[0], (int)this.aI[this.h[126] + 0], (int)this.aI[this.h[127] + 0], (int)this.aI[this.h[128] + 0], (int)this.aI[this.h[129] + 0], 0, 0, this.m - this.aI[this.h[129] + 0], 20);
            this.a[this.a].drawRegion(this.d[0], (int)this.aI[this.h[126] + 1], (int)this.aI[this.h[127] + 1], (int)this.aI[this.h[128] + 1], (int)this.aI[this.h[129] + 1], 0, this.l - this.aI[this.h[128] + 1], this.m - this.aI[this.h[129] + 1], 20);
            return;
        }
        if (this.b == 0 && this.e) {
            if (this.aX != 2 && this.B != 4 && (this.aX != 1 || this.aI[this.h[162] - 1 - this.au] != 0)) {
                this.a[this.a].drawRegion(this.d[0], (int)this.aI[this.h[126] + 4], (int)this.aI[this.h[127] + 4], (int)this.aI[this.h[128] + 4], (int)this.aI[this.h[129] + 4], 0, 0, this.m - this.aI[this.h[129] + 4], 20);
            }
        } else if ((this.b != 3 || this.aI[this.h[143] + this.R] != 2 && (this.R != 5 || this.aA != 40) || this.d && this.R == 26) && !this.p && this.b != 4) {
            this.a[this.a].drawRegion(this.d[0], (int)this.aI[this.h[126] + 2], (int)this.aI[this.h[127] + 2], (int)this.aI[this.h[128] + 2], (int)this.aI[this.h[129] + 2], 0, 0, this.m - this.aI[this.h[129] + 2], 20);
        }
        if ((this.b != 3 || this.aI[this.h[143] + this.R] != 0 && (this.R != 5 || this.aA != 18 && this.aA != 19 && this.aA != 38 && this.aA != 39) || this.R == 0 && this.c[this.v[0] - 1] == 107) && (!this.d || this.R != 26) && this.b != 5) {
            this.a[this.a].drawRegion(this.d[0], (int)this.aI[this.h[126] + 3], (int)this.aI[this.h[127] + 3], (int)this.aI[this.h[128] + 3], (int)this.aI[this.h[129] + 3], 0, this.l - this.aI[this.h[128] + 3], this.m - this.aI[this.h[129] + 3], 20);
        }
    }

    final void ar() {
        this.q = 0;
        while (this.q < 2) {
            this.a[this.a].drawRegion(this.c[3], (int)this.aI[this.h[13] + this.g * 2 + this.q], (int)this.aI[this.h[14] + this.g * 2 + this.q], (int)this.aI[this.h[15] + this.g * 2 + this.q], (int)this.aI[this.h[16] + this.g * 2 + this.q], 0, this.l - this.aI[this.h[15]] - 2 + this.aI[this.h[17] + this.g * 2 + this.q], 2 + this.aI[this.h[18] + this.g * 2 + this.q], 20);
            ++this.q;
        }
    }

    final void as() {
        this.u = 0;
        while (this.u < b.Q[0]) {
            this.a[this.a].drawRegion(this.b[6], 0, 112, 15, 12, 0, this.Y + this.aI[this.h[37] + this.u], this.X + this.aI[this.h[38] + this.u], 20);
            ++this.u;
        }
    }

    final void at() {
        this.u = 0;
        while (this.u < b.Q[1]) {
            this.a[this.a].drawRegion(this.b[6], 0, 112, 15, 12, 0, this.Y + this.aI[this.h[37] + 3 + this.u], this.X + this.aI[this.h[38] + 3 + this.u], 20);
            ++this.u;
        }
        this.u = 0;
        while (this.u < b.V.length) {
            this.a[this.a].drawRegion(this.b[2], (int)b.R[this.u], (int)b.S[this.u], (int)b.T[this.u], (int)b.U[this.u], 0, this.Y + b.V[this.u], this.X + b.W[this.u], 20);
            ++this.u;
        }
    }

    final void au() {
        if (this.an != 13) {
            this.an = 22;
            this.aK();
            this.an = 21;
            this.aK();
            return;
        }
        if (this.an == 13) {
            this.an = 2;
            this.aK();
            this.an = 1;
            this.aK();
        }
    }

    final void av() {
        if (this.an != 13) {
            this.an = 23;
            this.aK();
            this.an = 24;
            this.aK();
            return;
        }
        if (this.an == 13) {
            this.an = 18;
            this.aK();
            this.an = 17;
            this.aK();
        }
    }

    final void aw() {
        this.an = 21;
        this.aK();
        this.an = 24;
        this.aK();
    }

    final void ax() {
        this.v = this.aa == this.O - 1 ? true : this.b[this.Z][this.aa + 1] != 0 && this.b[this.Z][this.aa + 1] != 6 && this.b[this.Z][this.aa + 1] != 8 && this.b[this.Z][this.aa + 1] != -17 && this.b[this.Z][this.aa + 1] != -19 && this.b[this.Z][this.aa + 1] != -22 && this.b[this.Z][this.aa + 1] != -20 && this.b[this.Z][this.aa + 1] != -23 && this.b[this.Z][this.aa + 1] != -24 && this.b[this.Z][this.aa + 1] != -25 && this.b[this.Z][this.aa + 1] != -26;
        if (this.v) {
            this.an = 22;
            this.aK();
        }
        this.v = this.Z == 0 ? true : this.b[this.Z - 1][this.aa] != 0 && this.b[this.Z - 1][this.aa] != 5 && this.b[this.Z - 1][this.aa] != 7 && this.b[this.Z - 1][this.aa] != -15 && this.b[this.Z - 1][this.aa] != -16 && this.b[this.Z - 1][this.aa] != -18 && this.b[this.Z - 1][this.aa] != -21 && this.b[this.Z - 1][this.aa] != -20 && this.b[this.Z - 1][this.aa] != -24 && this.b[this.Z - 1][this.aa] != -25 && this.b[this.Z - 1][this.aa] != -26;
        if (this.v) {
            this.an = 21;
            this.aK();
        }
    }

    final void a(boolean bl) {
        if ((this.am & 0x40) != 0) {
            this.an = 2;
            this.aK();
        }
        if ((this.am & 4) != 0) {
            this.an = 8;
            this.aK();
        }
        if ((this.am & 0x80) != 0) {
            this.an = 1;
            this.aK();
        }
        if ((this.am & 8) != 0) {
            this.an = 7;
            this.aK();
        }
        if ((this.am & 0x4A) == 74) {
            this.an = 15;
            this.aK();
        }
        if ((this.am & 0x85) == 133) {
            this.an = 16;
            this.aK();
        }
        this.ay();
    }

    final void ay() {
        if (this.an == 9 && this.ar == 23) {
            this.u = 0;
            while (this.u < 1) {
                this.a[this.a].drawRegion(this.b[this.aI[this.h[88] + 3 + this.u]], (int)this.aI[this.h[80] + 3 + this.u], (int)this.aI[this.h[81] + 3 + this.u], (int)this.aI[this.h[82] + 3 + this.u], (int)this.aI[this.h[83] + 3 + this.u], 0, this.Y + this.aI[this.h[84] + 3 + this.u], this.X + this.aI[this.h[85] + 3 + this.u], 20);
                ++this.u;
            }
        }
        if (this.an == 4 && this.ar == 23) {
            this.u = 0;
            while (this.u < 1) {
                this.a[this.a].drawRegion(this.b[this.aI[this.h[88] + 6 + this.u]], (int)this.aI[this.h[80] + 6 + this.u], (int)this.aI[this.h[81] + 6 + this.u], (int)this.aI[this.h[82] + 6 + this.u], (int)this.aI[this.h[83] + 6 + this.u], 0, this.Y + this.aI[this.h[84] + 6 + this.u + 3 * (this.Z - this.aL[0])], this.X + this.aI[this.h[85] + 6 + this.u + 3 * (this.Z - this.aL[0])], 20);
                ++this.u;
            }
            if (this.b == 0) {
                this.u = 0;
                while (this.u < 2) {
                    this.v = this.c[this.Z][this.aa];
                    if (this.v < 0) {
                        return;
                    }
                    this.c = 0;
                    while (this.v >= 0) {
                        if (this.H[this.v] == this.u && this.W[this.v] == 12) {
                            this.a[this.a].drawRegion(this.a[this.A[this.v]], (int)this.aI[this.h[21] + this.A[this.v] * 2 + 1], (int)this.aI[this.h[42] + this.A[this.v]], (int)this.aI[this.h[43] + this.A[this.v]], (int)this.aI[this.h[44] + this.A[this.v]], 0, this.Y + this.aI[this.h[27] + (this.Z - this.aL[0]) * 4 + this.u] - this.aI[this.h[43] + this.A[this.v]] / 2, this.X + this.aI[this.h[28] + (this.Z - this.aL[0]) * 4 + this.u] - this.aI[this.h[44] + this.A[this.v]], 20);
                            break;
                        }
                        this.v = this.d[this.v];
                        this.c = (short)(this.c + 1);
                    }
                    ++this.u;
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
        this.a[this.a].drawRegion(this.b[5], 0, (b.B[1] - 1) * this.aj, b.B[0] - 2, (int)b.B[1], 0, this.Y + 0, this.X + -1, 20);
        if (this.aa > 0 && this.c[this.Z][this.aa] == -1 && this.b[this.Z][this.aa - 1] == 6) {
            this.a[this.a].drawRegion(this.b[1], 40, 0, 12, 9, 0, this.Y + (this.o[22][this.g[22][21] + 33 + this.as[22]] + this.o[22][this.g[22][22] + 33 + this.as[22]]) / b.Y[0] + -6, this.X + b.B[1] / 2 + (this.o[22][this.g[22][21] + 33 + this.as[22]] - this.o[22][this.g[22][22] + 33 + this.as[22]]) / b.Y[1] + -11, 20);
        }
        if (this.Z < this.O - 1 && this.c[this.Z][this.aa] == -1 && this.b[this.Z + 1][this.aa] == 5) {
            this.a[this.a].drawRegion(this.b[1], 40, 0, 12, 9, 0, this.Y + (this.o[22][this.g[22][21] + 22 + this.as[22]] + this.o[22][this.g[22][22] + 22 + this.as[22]]) / b.Y[0] + -6, this.X + b.B[1] / 2 + (this.o[22][this.g[22][21] + 22 + this.as[22]] - this.o[22][this.g[22][22] + 22 + this.as[22]]) / b.Y[1] + -11, 20);
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
            this.v = this.aa == 0 ? true : this.b[this.Z][this.aa - 1] != 0;
            if (this.v) {
                this.an = 23;
                this.aK();
            }
        }
        this.v = this.Z == this.O - 1 ? true : this.b[this.Z + 1][this.aa] != 0;
        if (this.v) {
            this.an = 24;
            this.aK();
        }
    }

    final void b(boolean bl) {
        if (this.an == 4 && this.ar == 23) {
            this.u = 0;
            while (this.u < 2) {
                this.a[this.a].drawRegion(this.b[this.aI[this.h[88] + 4 + this.u]], (int)this.aI[this.h[80] + 4 + this.u], (int)this.aI[this.h[81] + 4 + this.u], (int)this.aI[this.h[82] + 4 + this.u], (int)this.aI[this.h[83] + 4 + this.u], 0, this.Y + this.aI[this.h[84] + 4 + this.u + 3 * (this.Z - this.aL[0])], this.X + this.aI[this.h[85] + 4 + this.u + 3 * (this.Z - this.aL[0])], 20);
                ++this.u;
            }
            if (this.b == 0) {
                this.u = 2;
                while (this.u < 4) {
                    this.v = this.c[this.Z][this.aa];
                    if (this.v < 0) break;
                    this.c = 0;
                    while (this.v >= 0) {
                        if (this.H[this.v] == this.u && this.W[this.v] == 12) {
                            this.a[this.a].drawRegion(this.a[this.A[this.v]], (int)this.aI[this.h[1] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]], (int)this.aI[this.h[19] + this.A[this.v] * 4 + this.F[this.v]], (int)this.aI[this.h[2] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]], this.aI[this.h[20] + this.A[this.v] * 4 + this.F[this.v]] - 7, 0, this.Y + this.aI[this.h[27] + (this.Z - this.aL[0]) * 4 + this.u] - this.aI[this.h[2] + this.A[this.v] * 12 + this.F[this.v] * 3 + this.K[this.J[this.v]]] / 2, this.X + this.aI[this.h[28] + (this.Z - this.aL[0]) * 4 + this.u] - this.aI[this.h[20] + this.A[this.v] * 4 + this.F[this.v]], 20);
                            break;
                        }
                        this.v = this.d[this.v];
                        this.c = (short)(this.c + 1);
                    }
                    ++this.u;
                }
            }
        }
        if ((this.am & 0x10) != 0) {
            this.an = 18;
            this.aK();
        }
        this.c(bl);
    }

    final void c(boolean bl) {
        if ((this.am & 1) != 0) {
            this.an = 10;
            this.aK();
        }
        if ((this.am & 0x20) != 0) {
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
            this.u = 0;
            while (this.u < this.aq[this.ar]) {
                if (!(this.o[this.ar][this.g[this.ar][4] + 2] == 0 && this.u % 2 != 0 || this.X + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 1] >= this.m && this.X + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 3] >= this.m)) {
                    this.a[this.a].setColor(b.b[this.ar][this.u]);
                    this.a[this.a].drawLine(this.Y + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2], this.X + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 1], this.Y + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 2], this.X + this.o[this.ar][this.g[this.ar][20] + this.as % this.at[this.ar] * (this.aq[this.ar] + 1) * 2 + this.u * 2 + 3]);
                }
                ++this.u;
            }
        }
        this.w = 0;
        this.u = 0;
        while (this.u < this.ar[this.ar]) {
            if (this.u > 0) {
                this.w += this.o[this.ar][this.g[this.ar][1] + (this.u - 1) * 2 + 1] - this.o[this.ar][this.g[this.ar][1] + (this.u - 1) * 2] + 1;
            }
            if (this.as % this.at[this.ar] >= this.o[this.ar][this.g[this.ar][1] + this.u * 2] && this.as % this.at[this.ar] <= this.o[this.ar][this.g[this.ar][1] + this.u * 2 + 1]) {
                this.aY[0] = this.o[this.ar][this.g[this.ar][30] + this.w + this.as % this.at[this.ar] - this.o[this.ar][this.g[this.ar][1] + this.u * 2]];
                this.aY[1] = this.o[this.ar][this.g[this.ar][31] + this.w + this.as % this.at[this.ar] - this.o[this.ar][this.g[this.ar][1] + this.u * 2]];
                if (this.X + this.aY[1] < this.m && this.Y + this.aY[0] + this.o[this.ar][this.g[this.ar][27] + this.u] > 0 && this.Y + this.aY[0] < this.l) {
                    this.v = false;
                    this.v = this.o[this.ar][this.g[this.ar][3] + 3] == 1 ? 0 : this.as % this.at[this.ar];
                    if (this.Z == this.aM[0] + this.o[this.ar][this.g[this.ar][36] + this.v * 2] && this.aa == this.aM[1] + this.o[this.ar][this.g[this.ar][36] + this.v * 2 + 1]) {
                        this.v = true;
                    }
                    if (this.v) {
                        this.a[this.a].drawRegion(this.b[this.o[this.ar][this.g[this.ar][29] + this.u]], (int)this.o[this.ar][this.g[this.ar][25] + this.u], (int)this.o[this.ar][this.g[this.ar][26] + this.u], (int)this.o[this.ar][this.g[this.ar][27] + this.u], (int)this.o[this.ar][this.g[this.ar][28] + this.u], 0, this.Y + this.aY[0], this.X + this.aY[1], 20);
                    }
                }
            }
            ++this.u;
        }
    }

    final void aE() {
        this.am = (this.Z - this.aL[0]) * (this.o[this.ar][this.g[this.ar][0] + 1] - 1) + this.aa - this.aL[1] - 1;
        this.ak = this.o[this.ar][this.g[this.ar][33] + this.am];
        this.al = this.o[this.ar][this.g[this.ar][33] + this.am + 1];
        this.am = this.ak;
        while (this.am < this.al) {
            this.u = this.o[this.ar][this.g[this.ar][32] + this.am];
            if (this.X + this.o[this.ar][this.g[this.ar][10] + this.u] < this.m && this.Y + this.o[this.ar][this.g[this.ar][9] + this.u] + this.o[this.ar][this.g[this.ar][7] + this.u] > 0 && this.Y + this.o[this.ar][this.g[this.ar][9] + this.u] < this.l) {
                this.v = this.o[this.ar][this.g[this.ar][4] + 1] == 1 ? true : this.o[this.ar][this.g[this.ar][40] + this.as % this.at[this.ar] * this.an[this.ar] + this.u] == 1;
                if (this.v) {
                    this.v = this.o[this.ar][this.g[this.ar][11] + this.u] == 5 ? (b.B[1] - 1) * this.aj : 0;
                    this.a[this.a].drawRegion(this.b[this.o[this.ar][this.g[this.ar][11] + this.u]], (int)this.o[this.ar][this.g[this.ar][5] + this.u], this.o[this.ar][this.g[this.ar][6] + this.u] + this.v, (int)this.o[this.ar][this.g[this.ar][7] + this.u], (int)this.o[this.ar][this.g[this.ar][8] + this.u], 0, this.Y + this.o[this.ar][this.g[this.ar][9] + this.u], this.X + this.o[this.ar][this.g[this.ar][10] + this.u], 20);
                }
            }
            ++this.am;
        }
        if (this.Z - this.o[this.ar][this.g[this.ar][36]] == this.aM[0] && this.aa - this.o[this.ar][this.g[this.ar][36] + 1] == this.aM[1]) {
            this.u = 0;
            while (this.u < this.ao[this.ar]) {
                if (this.X + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 1] < this.m || this.X + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 3] < this.m) {
                    this.a[this.a].setColor(b.a[this.ar][this.u]);
                    this.a[this.a].drawLine(this.Y + this.o[this.ar][this.g[this.ar][19] + this.u * 4], this.X + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 1], this.Y + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 2], this.X + this.o[this.ar][this.g[this.ar][19] + this.u * 4 + 3]);
                }
                ++this.u;
            }
        }
    }

    final void aF() {
        this.u = 0;
        while (this.u < this.ap[this.ar]) {
            this.aY[0] = this.o[this.ar][this.g[this.ar][2]] == 1 ? this.o[this.ar][this.g[this.ar][17] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u] : this.o[this.ar][this.g[this.ar][17] + this.u];
            this.aY[1] = this.o[this.ar][this.g[this.ar][2] + 1] == 1 ? this.o[this.ar][this.g[this.ar][18] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u] : this.o[this.ar][this.g[this.ar][18] + this.u];
            if (this.X + this.aY[1] < this.m && this.Y + this.aY[0] + this.o[this.ar][this.g[this.ar][14] + this.u] > 0 && this.Y + this.aY[0] < this.l) {
                this.v = false;
                this.v = this.o[this.ar][this.g[this.ar][3] + 1] == 1 ? 0 : this.as % this.at[this.ar];
                if (this.Z == this.aM[0] + this.o[this.ar][this.g[this.ar][34] + this.v * 2] && this.aa == this.aM[1] + this.o[this.ar][this.g[this.ar][34] + this.v * 2 + 1]) {
                    this.v = true;
                }
                if (!this.v) break;
                this.v = this.o[this.ar][this.g[this.ar][4] + 1] == 1 ? true : this.o[this.ar][this.g[this.ar][41] + this.as % this.at[this.ar] * this.ap[this.ar] + this.u] == 1;
                if (this.v) {
                    this.a[this.a].drawRegion(this.b[this.o[this.ar][this.g[this.ar][16] + this.u]], (int)this.o[this.ar][this.g[this.ar][12] + this.u], (int)this.o[this.ar][this.g[this.ar][13] + this.u], (int)this.o[this.ar][this.g[this.ar][14] + this.u], (int)this.o[this.ar][this.g[this.ar][15] + this.u], 0, this.Y + this.aY[0], this.X + this.aY[1], 20);
                }
            }
            ++this.u;
        }
    }

    final void aG() {
        this.v = -1 - this.an;
        this.w = this.aH[this.v] > 0 && this.b == 0 ? (this.aq & 0xFF) % this.aH[this.v] : 0;
        this.u = 0;
        while (this.u < this.aF[this.v]) {
            if (this.X + this.p[this.v][this.h[this.v][5] + this.u] < this.m && this.Y + this.p[this.v][this.h[this.v][4] + this.u] + this.p[this.v][this.h[this.v][2] + this.u] > 0 && this.Y + this.p[this.v][this.h[this.v][4] + this.u] < this.l) {
                this.v = this.an > -15 ? true : (this.aH[this.v] == 0 || !this.r && this.s ? true : this.p[this.v][this.h[this.v][14] + this.w * this.aF[this.v] + this.u] == 1);
                if (this.v) {
                    this.a[this.a].drawRegion(this.b[this.p[this.v][this.h[this.v][6] + this.u]], (int)this.p[this.v][this.h[this.v][0] + this.u], (int)this.p[this.v][this.h[this.v][1] + this.u], (int)this.p[this.v][this.h[this.v][2] + this.u], (int)this.p[this.v][this.h[this.v][3] + this.u], 0, this.Y + this.p[this.v][this.h[this.v][4] + this.u], this.X + this.p[this.v][this.h[this.v][5] + this.u], 20);
                }
            }
            ++this.u;
        }
    }

    final void aH() {
        if (this.an < 0 && this.an >= -27) {
            this.aG();
            if (this.an > -15) {
                return;
            }
            if (this.r && !this.s && this.p[this.v][this.h[this.v][2] + this.aF[this.v]] > 0) {
                this.a[this.a].drawRegion(this.b[this.p[this.v][this.h[this.v][6] + this.aF[this.v]]], (int)this.p[this.v][this.h[this.v][0] + this.aF[this.v]], (int)this.p[this.v][this.h[this.v][1] + this.aF[this.v]], (int)this.p[this.v][this.h[this.v][2] + this.aF[this.v]], (int)this.p[this.v][this.h[this.v][3] + this.aF[this.v]], 0, this.Y + this.p[this.v][this.h[this.v][4] + this.aF[this.v]], this.X + this.p[this.v][this.h[this.v][5] + this.aF[this.v]], 20);
            } else if (!this.r && this.s && this.p[this.v][this.h[this.v][2] + this.aF[this.v] + 1] > 0) {
                this.a[this.a].drawRegion(this.b[this.p[this.v][this.h[this.v][6] + this.aF[this.v] + 1]], (int)this.p[this.v][this.h[this.v][0] + this.aF[this.v] + 1], (int)this.p[this.v][this.h[this.v][1] + this.aF[this.v] + 1], (int)this.p[this.v][this.h[this.v][2] + this.aF[this.v] + 1], (int)this.p[this.v][this.h[this.v][3] + this.aF[this.v] + 1], 0, this.Y + this.p[this.v][this.h[this.v][4] + this.aF[this.v] + 1], this.X + this.p[this.v][this.h[this.v][5] + this.aF[this.v] + 1], 20);
            }
            if (this.r && this.s || this.b != 0 && this.aW == 26) {
                this.u = 0;
                while (this.u < this.aG[this.v]) {
                    if (this.X + this.p[this.v][this.h[this.v][13] + this.w * this.aG[this.v] + this.u] < this.m && this.Y + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u] + this.p[this.v][this.h[this.v][9] + this.u] > 0 && this.Y + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u] < this.l) {
                        this.v = this.p[this.v][this.h[this.v][15] + this.w * this.aG[this.v] + this.u] == 1;
                        if (this.v) {
                            this.a[this.a].drawRegion(this.b[this.p[this.v][this.h[this.v][11] + this.u]], (int)this.p[this.v][this.h[this.v][7] + this.u], (int)this.p[this.v][this.h[this.v][8] + this.u], (int)this.p[this.v][this.h[this.v][9] + this.u], (int)this.p[this.v][this.h[this.v][10] + this.u], 0, this.Y + this.p[this.v][this.h[this.v][12] + this.w * this.aG[this.v] + this.u], this.X + this.p[this.v][this.h[this.v][13] + this.w * this.aG[this.v] + this.u], 20);
                        }
                    }
                    ++this.u;
                }
            }
        }
    }

    final void aI() {
        this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[59] + this.an], (int)this.aI[this.h[60] + this.an], (int)this.aI[this.h[61] + this.an], (int)this.aI[this.h[62] + this.an], 0, this.Y + this.aI[this.h[63] + this.an], this.X + this.aI[this.h[64] + this.an], 20);
    }

    final void aJ() {
        this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[65] + this.an], (int)this.aI[this.h[66] + this.an], (int)this.aI[this.h[67] + this.an], (int)this.aI[this.h[68] + this.an], 0, this.Y + this.aI[this.h[69] + this.ao], this.X + this.aI[this.h[70] + this.ao], 20);
    }

    final void aK() {
        this.ap = this.an == 19 && this.b != 0 ? b.B[0] / 4 : 0;
        this.a[this.a].drawRegion(this.b[2], (int)this.aI[this.h[59] + this.an], (int)this.aI[this.h[60] + this.an], (int)this.aI[this.h[61] + this.an], (int)this.aI[this.h[62] + this.an], 0, this.Y + this.aI[this.h[63] + this.an] + this.ap, this.X + this.aI[this.h[64] + this.an], 20);
    }

    final void aL() {
        try {
            this.v = this.c[this.Z][this.aa];
            if (this.v < 0) {
                return;
            }
            if (this.b[this.Z][this.aa] == 10 && this.ag[this.c[this.Z][this.aa]] == 4) {
                this.a[this.a].drawRegion(this.a[9], (int)b.af[this.af[this.c[this.Z][this.aa]] % 2], (int)b.ag[this.af[this.c[this.Z][this.aa]] % 2], (int)b.ah[this.af[this.c[this.Z][this.aa]] % 2], (int)b.ai[this.af[this.c[this.Z][this.aa]] % 2], 0, this.Y + this.aB[this.Z[this.c[this.Z][this.aa]]] - b.ah[this.af[this.c[this.Z][this.aa]] % 2], this.X + this.aC[this.Z[this.c[this.Z][this.aa]]] - b.ai[this.af[this.c[this.Z][this.aa]] % 2], 20);
                return;
            }
            this.aM();
            if (this.c == 0) {
                return;
            }
            this.aN();
            this.u = 0;
            while (this.u < this.c) {
                if (this.W[this.d[0][this.u]] == 15) {
                    this.a[this.a].drawRegion(this.b[2], (int)b.aa[this.J[this.d[0][this.u]] % 2], (int)b.ab[this.J[this.d[0][this.u]] % 2], (int)b.ac[this.J[this.d[0][this.u]] % 2], (int)b.ad[this.J[this.d[0][this.u]] % 2], 0, this.Y + b.B[0] / 2 - b.ac[this.J[this.d[0][this.u]] % 2] / 2 + this.h[0][this.d[0][this.u]], this.X + this.d[1][this.u] - b.ad[this.J[this.d[0][this.u]] % 2] + b.ae[this.J[this.d[0][this.u]] % 2], 20);
                } else {
                    this.aO();
                    if (this.Y + this.v > -b.B[0] / 2 && this.Y + this.v < this.l + b.B[0] / 4) {
                        this.aP();
                        if (this.W[this.d[0][this.u]] == 10) {
                            this.a[this.a].drawRegion(this.b[1], 40, 0, 12, 8, 0, this.Y + this.v + -6, this.X + this.d[1][this.u] + -11, 20);
                        }
                        this.a[this.a].drawRegion(this.a[this.A[this.d[0][this.u]]], (int)this.aY[2], (int)this.aY[3], (int)this.aY[4], this.aY[5] - this.aT, 0, this.Y + this.v - this.aU, this.X + this.d[1][this.u] - this.aV, 20);
                        this.aQ();
                    }
                }
                ++this.u;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void aM() {
        this.c = 0;
        while (this.v >= 0) {
            if (!(this.W[this.v] > -1 && this.W[this.v] < 7 && this.h[0][this.v] == 1 && this.aI[this.h[this.q[1][0]] + this.W[this.v] * 4] == 2 || this.W[this.v] == 12 || this.W[this.v] == 16 || this.W[this.v] == 13 && this.o[this.Z[this.c[this.Z][this.aa]]][this.g[this.Z[this.c[this.Z][this.aa]]][4]] == 0)) {
                this.d[0][this.c] = (short)this.v;
                this.d[1][this.c] = this.W[this.v] == 13 ? (short)this.H[this.v] : (this.W[this.v] == 15 ? (short)(b.B[1] / 2 + this.h[1][this.v]) : (short)(b.B[1] / 2 + (this.G[this.v] - this.H[this.v]) / b.Y[1]));
                if (this.X + this.d[1][this.c] > 0 && this.X + this.d[1][this.c] <= this.m + b.B[1]) {
                    this.c = (short)(this.c + 1);
                }
            }
            this.v = this.d[this.v];
        }
    }

    final void aN() {
        this.u = 0;
        while (this.u < this.c - 1) {
            this.v = this.u + 1;
            while (this.v < this.c) {
                if (this.d[1][this.u] > this.d[1][this.v]) {
                    this.d = this.d[0][this.u];
                    this.d[0][this.u] = this.d[0][this.v];
                    this.d[0][this.v] = this.d;
                    this.d = this.d[1][this.u];
                    this.d[1][this.u] = this.d[1][this.v];
                    this.d[1][this.v] = this.d;
                }
                ++this.v;
            }
            ++this.u;
        }
    }

    final void aO() {
        this.w = this.W[this.d[0][this.u]] == -1 || this.W[this.d[0][this.u]] >= 9 ? this.F[this.d[0][this.u]] : this.X[this.d[0][this.u]];
        this.aT = 0;
        this.aU = 0;
        this.aV = 0;
        if (this.W[this.d[0][this.u]] == 13) {
            this.aY[5] = this.J[this.d[0][this.u]];
            if (this.c[this.d[0][this.u]] % this.at[this.Z[this.c[this.Z][this.aa]]] >= this.o[this.Z[this.c[this.Z][this.aa]]][this.g[this.Z[this.c[this.Z][this.aa]]][39]] && this.c[this.d[0][this.u]] % this.at[this.Z[this.c[this.Z][this.aa]]] <= this.o[this.Z[this.c[this.Z][this.aa]]][this.g[this.Z[this.c[this.Z][this.aa]]][39] + 1]) {
                this.aT = this.ax[this.Z[this.c[this.Z][this.aa]]];
            }
            if (this.Z[this.c[this.Z][this.aa]] == 14) {
                this.aV = (byte)(this.aV - this.aI[this.h[20] + this.A[this.d[0][this.u]] * 4]);
            }
            this.v = this.G[this.d[0][this.u]];
            return;
        }
        if (this.W[this.d[0][this.u]] == 1 && this.h[0][this.d[0][this.u]] == 1) {
            this.w = 4;
            this.aY[5] = this.h[2][this.d[0][this.u]];
        } else {
            this.aY[5] = this.K[this.J[this.d[0][this.u]]];
        }
        if (this.W[this.d[0][this.u]] == 10) {
            this.aT = (byte)7;
        }
        this.v = (this.G[this.d[0][this.u]] + this.H[this.d[0][this.u]]) / b.Y[0];
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
                this.a[this.a].drawRegion(this.b[this.aI[this.h[75]]], (int)this.aI[this.h[75] + 1], (int)this.aI[this.h[75] + 2], (int)this.aI[this.h[75] + 3], (int)this.aI[this.h[75] + 4], 0, this.Y + this.v + this.aI[this.h[75] + 5], this.X + this.d[1][this.u] + this.aI[this.h[75] + 6], 20);
            }
            if (this.Z[this.c[this.Z][this.aa]] == 14 || this.Z[this.c[this.Z][this.aa]] == 16 && this.c[this.d[0][this.u]] >= this.aI[this.h[76]] && this.c[this.d[0][this.u]] <= this.aI[this.h[76] + 1]) {
                this.a[this.a].drawRegion(this.a[this.A[this.d[0][this.u]]], (int)this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6], (int)this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 1], (int)this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 2], (int)this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 3], 0, this.Y + this.v - this.aU + this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 4], this.X + this.d[1][this.u] - this.aV + this.aI[this.h[0] + this.A[this.d[0][this.u]] * 24 + this.w * 6 + 5], 20);
                return;
            }
        } else if (this.d[0][this.u] < 200) {
            if (this.M[this.d[0][this.u]] >= 0) {
                this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + this.M[this.d[0][this.u]] + 13], (int)this.aI[this.h[72] + this.M[this.d[0][this.u]] + 13], (int)this.aI[this.h[73] + this.M[this.d[0][this.u]] + 13], (int)this.aI[this.h[74] + this.M[this.d[0][this.u]] + 13], 0, this.Y + this.v - this.aI[this.h[73] + this.M[this.d[0][this.u]] + 13] / 2, this.X + this.d[1][this.u] - this.aV - this.aI[this.h[74] + this.M[this.d[0][this.u]] + 13], 20);
            }
            if (this.O[this.d[0][this.u]] >= 0) {
                this.w = this.O[this.d[0][this.u]] % b.e.length;
                this.a[this.a].drawRegion(this.b[2], (int)b.e[this.w][0], (int)b.e[this.w][1], (int)b.e[this.w][2], (int)b.e[this.w][3], 0, this.Y + this.v - b.e[this.w][2] / 2 + b.e[this.w][4], this.X + this.d[1][this.u] - this.aV + b.e[this.w][5], 20);
            }
            this.b(this.d[0][this.u], this.Y + this.v, this.X + this.d[1][this.u] - this.aV);
        }
    }

    final void b(int n, int n2, int n3) {
        if (this.N[n] >= 0) {
            this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + 0], (int)this.aI[this.h[72] + 0], (int)this.aI[this.h[73] + 0], (int)this.aI[this.h[74] + 0], 0, n2 - this.aI[this.h[73] + 0], n3 - this.aI[this.h[74] + 0], 20);
            this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + this.aI[this.h[96] + this.N[n]]], (int)this.aI[this.h[72] + this.aI[this.h[96] + this.N[n]]], (int)this.aI[this.h[73] + this.aI[this.h[96] + this.N[n]]], (int)this.aI[this.h[74] + this.aI[this.h[96] + this.N[n]]], 0, n2 - this.aI[this.h[73] + 0] + b.ak[0] - this.aI[this.h[73] + this.aI[this.h[96] + this.N[n]]] / 2, n3 - this.aI[this.h[74] + 0] + b.ak[1] - this.aI[this.h[74] + this.aI[this.h[96] + this.N[n]]] / 2, 20);
        }
    }

    final void aR() {
        this.q = 0;
        while (this.q < this.aH) {
            if (this.x[this.q][0] >= 0) {
                this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + this.aS[this.q]], (int)this.aI[this.h[72] + this.aS[this.q]], (int)this.aI[this.h[73] + this.aS[this.q]], (int)this.aI[this.h[74] + this.aS[this.q]], 0, (this.x[this.q][0] + this.x[this.q][1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W + this.aR[this.q], (this.x[this.q][0] - this.x[this.q][1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X + this.aQ[this.q], 20);
            }
            ++this.q;
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
            ++this.aN;
        }
    }

    final void aT() {
        if ((this.b != 3 || this.R > 17 || this.R == 10 && this.K == 1) && this.b != 4 && this.b != 0 && this.b != 1 && this.b != 5) {
            this.cD();
            return;
        }
        if (this.b == 0) {
            this.a = 1;
            this.al();
            this.a = 0;
            this.b = (byte)4;
            this.aa = 0;
            this.aO = 1;
            this.n[0] = 2;
            this.n[1] = (this.l - this.O * (b.d[2] + 2)) / 2;
            this.n[2] = this.l - 2 - this.O * (b.d[2] + 2);
            return;
        }
        if (this.b == 4) {
            this.b = 0;
            this.aa = (byte)5;
        }
    }

    final void aU() {
        this.aV();
        switch (this.n) {
            case 1: {
                this.aW();
                return;
            }
            case 2: {
                this.aX();
                return;
            }
            case 4: {
                this.aY();
                return;
            }
            case 3: {
                this.aZ();
                return;
            }
            case 5: {
                if (!this.e && !this.h) {
                    if (this.b[this.a[0]][this.a[1]] >= 4 && this.b[this.a[0]][this.a[1]] <= 13) {
                        this.ba();
                        return;
                    }
                    if (this.b[this.a[0]][this.a[1]] < 0 && this.b[this.a[0]][this.a[1]] >= -28) {
                        this.bb();
                        return;
                    }
                    if (this.c[this.a[0]][this.a[1]] == -1) break;
                    this.bc();
                    return;
                }
                if (this.e) {
                    this.bd();
                    return;
                }
                if (!this.h) break;
                if (this.b[this.a[0]][this.a[1]] > 0 && this.b[this.a[0]][this.a[1]] <= 3) {
                    return;
                }
                this.be();
                return;
            }
            case -6: {
                this.bf();
                return;
            }
            case -7: {
                this.bg();
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
            this.q = 0;
            while (this.q < 4) {
                int[] nArray = this.f[this.q];
                nArray[0] = nArray[0] + (this.r - 1) / 2;
                int[] nArray2 = this.f[this.q];
                nArray2[1] = nArray2[1] - (this.r - 1) / 2;
                ++this.q;
            }
            this.aa = 1;
            return;
        }
        if (this.a[0] > -this.o[0]) {
            this.a[0] = this.a[0] - 1;
            if (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1] - 2 < 0 || this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1] - 2 < 0 || this.e) {
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[0] = nArray[0] - 1;
                    ++this.q;
                }
                this.aa = 1;
            }
        }
    }

    final void aX() {
        this.r = this.a[0] + this.o[2] - this.a[1] - this.f[3][0] + this.f[3][1] - 2;
        if (this.e && this.r > 0) {
            this.q = 0;
            while (this.q < 4) {
                int[] nArray = this.f[this.q];
                nArray[0] = nArray[0] + (this.r + 1) / 2;
                int[] nArray2 = this.f[this.q];
                nArray2[1] = nArray2[1] - (this.r + 1) / 2;
                ++this.q;
            }
            this.aa = (byte)2;
            return;
        }
        if (this.a[0] < this.O - 1 && !this.e || this.a[0] < this.O - this.o[2] && this.e) {
            this.a[0] = this.a[0] + 1;
            if (this.a[0] + this.a[1] - this.f[1][0] - this.f[1][1] + 1 > 0 || this.a[0] - this.a[1] - this.f[3][0] + this.f[3][1] + 1 > 0 || this.e) {
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[0] = nArray[0] + 1;
                    ++this.q;
                }
                this.aa = (byte)2;
            }
        }
    }

    final void aY() {
        this.r = this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1];
        if (this.e && this.r < 0) {
            this.q = 0;
            while (this.q < 4) {
                int[] nArray = this.f[this.q];
                nArray[0] = nArray[0] + (this.r - 1) / 2;
                int[] nArray2 = this.f[this.q];
                nArray2[1] = nArray2[1] + (this.r - 1) / 2;
                ++this.q;
            }
            this.aa = (byte)4;
            return;
        }
        if (this.a[1] > -this.o[1]) {
            this.a[1] = this.a[1] - 1;
            if (this.a[0] + this.a[1] - this.f[0][0] - this.f[0][1] - 2 < 0 || this.a[0] - this.a[1] - this.f[3][0] + this.f[3][1] + 1 > 0 || this.e) {
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[1] = nArray[1] - 1;
                    ++this.q;
                }
                this.aa = (byte)4;
            }
        }
    }

    final void aZ() {
        this.r = this.a[0] + this.o[2] + this.a[1] + this.o[3] - this.f[1][0] - this.f[1][1] - 2;
        if (this.e && this.r > 0) {
            this.q = 0;
            while (this.q < 4) {
                int[] nArray = this.f[this.q];
                nArray[0] = nArray[0] + (this.r + 1) / 2;
                int[] nArray2 = this.f[this.q];
                nArray2[1] = nArray2[1] + (this.r + 1) / 2;
                ++this.q;
            }
            this.aa = (byte)3;
            return;
        }
        if (this.a[1] < this.O - 1 && !this.e || this.a[1] < this.O - this.o[3] && this.e) {
            this.a[1] = this.a[1] + 1;
            if (this.a[0] + this.a[1] - this.f[1][0] - this.f[1][1] + 1 > 0 || this.a[0] - this.a[1] - this.f[0][0] + this.f[0][1] - 2 < 0 || this.e) {
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[1] = nArray[1] + 1;
                    ++this.q;
                }
                this.aa = (byte)3;
            }
        }
    }

    final void ba() {
        this.b = (byte)3;
        if (this.c[this.a[0]][this.a[1]] >= 0) {
            this.ar = this.Z[this.c[this.a[0]][this.a[1]]];
            this.m = this.c[this.c[this.a[0]][this.a[1]]];
            if (this.ar != 23) {
                this.R = (byte)18;
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
                this.R = (byte)21;
                this.an = (byte)28;
                this.n = this.a[this.c[this.a[0]][this.a[1]]];
                this.x[0] = 2;
                this.y[0] = this.aE[this.aI[this.h[57] + this.an]];
                this.U = this.aI[this.h[56] + this.an];
            }
        } else {
            this.ar = (byte)22;
            this.R = (byte)18;
        }
        this.w[this.R] = this.aI[this.h[135] + this.ar];
        this.cu();
        this.aa = (byte)5;
    }

    final void bb() {
        if (this.b[this.a[0]][this.a[1]] <= -15) {
            if (this.aI[this.h[57] + -1 - this.b[this.a[0]][this.a[1]]] >= 0) {
                this.R = (byte)19;
                this.an = (byte)(-1 - this.b[this.a[0]][this.a[1]]);
                this.n = this.d[this.c[this.a[0]][this.a[1]]];
                this.x[0] = 0;
                this.x[1] = 2;
                this.y[0] = this.aI[this.h[29] + this.an * (this.ad + 1) + this.ad];
                this.y[1] = this.aE[this.aI[this.h[57] + this.an]];
                this.U = this.aI[this.h[56] + this.an];
            } else if (this.b[this.a[0]][this.a[1]] <= -27) {
                this.R = (byte)22;
                this.an = (byte)26;
                this.n = this.d[this.c[this.a[0]][this.a[1]]];
                this.U = this.aI[this.h[56] + this.an];
            } else if (this.f[this.c[this.a[0]][this.a[1]]]) {
                this.R = (byte)19;
                this.an = (byte)(-1 - this.b[this.a[0]][this.a[1]]);
            } else {
                return;
            }
            this.b = (byte)3;
            this.w[this.R] = this.aI[this.h[136] + this.an];
            this.cu();
            this.aa = (byte)5;
        }
    }

    final void bc() {
        this.v = this.c[this.a[0]][this.a[1]];
        while (this.v != -1) {
            if (this.A[this.v] == 8 || this.A[this.v] == 9) {
                this.b = (byte)3;
                this.R = (byte)20;
                this.U = (byte)(this.A[this.v] - 8);
                this.j = this.v;
                this.x[0] = 2;
                this.y[0] = this.aI[this.h[131] + this.U];
                this.w[this.R] = this.aI[this.h[137] + this.U];
                this.cu();
                this.aa = (byte)5;
            }
            this.v = this.d[this.v];
        }
        if (this.b == 0) {
            this.aO = this.v = this.c[this.a[0]][this.a[1]];
            this.e(false);
            this.b = (byte)3;
            this.R = (byte)23;
            this.U = this.A[this.v];
            this.j = this.v;
            this.x[0] = 0;
            this.x[1] = 4;
            this.x[2] = 3;
            this.y[0] = (byte)(this.P[this.v] / 10);
            this.y[1] = (byte)(this.R[this.v] / 10);
            this.y[2] = (byte)(this.Q[this.v] / 10);
            this.cu();
            this.aa = (byte)5;
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
                    this.d = (byte)-1;
                    this.e = false;
                }
                if (this.aX == 1 && this.aW < 14) {
                    this.s = (this.a.nextInt() & 0xF) % 4;
                    this.r = 0;
                    while (this.r < this.s) {
                        this.au = (byte)(this.au - this.aI[this.h[162] - 1 - this.au]);
                        ++this.r;
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
                this.k -= this.aI[this.h[131] + this.U];
                this.e += this.aI[this.h[131] + this.U];
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
            return;
        }
        this.f = 0;
        this.aC = 1;
        this.aB = this.aA;
        this.dI();
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
            return;
        }
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
                        this.av = (byte)-1;
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

    final void bg() {
        if (this.e) {
            this.cn();
            this.k = false;
            if (!this.e) {
                this.j = (byte)-1;
                this.d = (byte)-1;
            }
            this.aa = (byte)5;
            return;
        }
        if (this.h) {
            this.d = (byte)-1;
            this.h = false;
            return;
        }
        if (!this.e && !this.h) {
            this.az = 0;
            this.b = (byte)3;
            this.R = 1;
            this.l = false;
            this.cu();
            this.aa = (byte)5;
        }
    }

    final void bh() {
        if (this.z == 0) {
            switch (this.n) {
                case 3: {
                    this.A = (byte)-1;
                    this.z = (byte)3;
                    this.y = (byte)(this.y + 1);
                    if (this.y == this.x) {
                        this.y = 0;
                    }
                    this.aC = 1;
                    this.aA = (byte)(23 + this.y);
                    this.dI();
                    break;
                }
                case 4: {
                    this.A = 1;
                    break;
                }
                case -6: 
                case 5: {
                    this.bi();
                    this.aa = (byte)5;
                    break;
                }
                case -7: {
                    this.b = 0;
                    this.aa = (byte)5;
                }
            }
        }
        this.bj();
    }

    final void bi() {
        if (this.y != 6 && this.y != 3) {
            this.b = (byte)2;
            this.C = 0;
            this.av = 0;
            if (this.y == 1) {
                this.B = 0;
            }
            if (this.y == 2) {
                this.B = 1;
            }
            if (this.y == 5) {
                this.B = (byte)2;
            }
            if (this.y == 4) {
                this.B = (byte)3;
            }
            if (this.y == 0) {
                this.B = (byte)4;
            }
            while (true) {
                this.aW = this.aI[this.h[151 + this.B] + this.C];
                this.aX = this.aI[this.h[146 + this.B] + this.C];
                if (!this.a()) break;
                this.C = (byte)(this.C + 1);
                if (this.C != b.j[this.B]) continue;
                this.C = 0;
            }
            this.cp();
            return;
        }
        if (this.y == 6) {
            this.b = 0;
            this.d = (byte)-1;
            this.h = true;
            return;
        }
        if (this.y == 3) {
            this.ag = 0;
            while (this.ag < 8) {
                if (this.ag > 3) {
                    this.ai = 3;
                } else {
                    this.ai = this.ag;
                    this.d[this.ag][0] = this.d[this.ag][1];
                }
                this.ah = 0;
                while (this.ah < this.c[this.ag][d.k[4]]) {
                    if (this.c[this.ag][this.ah] > this.d[this.ai][0]) {
                        this.d[this.ai][0] = this.c[this.ag][this.ah];
                    }
                    ++this.ah;
                }
                ++this.ag;
            }
            this.b = (byte)3;
            this.R = (byte)26;
            this.cu();
        }
    }

    final void bj() {
        this.z = (byte)(this.z + this.A);
        if (this.z == 3) {
            if (this.y == 0) {
                this.y = this.x;
            }
            this.y = (byte)(this.y - 1);
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
            case 3: {
                if (this.o) {
                    return;
                }
                do {
                    this.C = (byte)(this.C + 1);
                    if (this.C == b.j[this.B]) {
                        this.C = 0;
                    }
                    this.aW = this.aI[this.h[151 + this.B] + this.C];
                    this.aX = this.aI[this.h[146 + this.B] + this.C];
                } while (this.a());
                this.cp();
                return;
            }
            case 4: {
                if (this.o) {
                    return;
                }
                do {
                    this.C = (byte)(this.C - 1);
                    if (this.C < 0) {
                        this.C = (byte)(b.j[this.B] - 1);
                    }
                    this.aW = this.aI[this.h[151 + this.B] + this.C];
                    this.aX = this.aI[this.h[146 + this.B] + this.C];
                } while (this.a());
                this.cp();
                return;
            }
            case -6: 
            case 5: {
                if (this.p) break;
                if (!this.o) {
                    this.bl();
                    return;
                }
                if (this.k < this.i) {
                    this.h = 0;
                }
                if (this.k - -500 < this.i) break;
                this.bm();
            }
            case -7: {
                this.bn();
            }
        }
    }

    final boolean a() {
        if (this.aX == 2 && this.K == 1 && (this.C == 2 && !this.a[0][23] || this.C == 5 && !this.a[1][26])) {
            return true;
        }
        if (this.aX > 1 && (this.aX != 3 || this.aW != 13 || this.a[0][22])) {
            return false;
        }
        if (this.aX < 2) {
            if (this.K == 0) {
                return false;
            }
            if (this.a[this.aX][this.aW]) {
                return false;
            }
        }
        return true;
    }

    final void bl() {
        this.e = true;
        this.d = 0;
        this.j = (byte)-1;
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
        this.aa = (byte)5;
    }

    final void bm() {
        this.k -= this.i;
        this.e += this.i;
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
        byte by = this.C;
        this.e[by] = (short)(this.e[by] + 1);
        byte by2 = b.j[3];
        this.e[by2] = (short)(this.e[by2] + this.i);
    }

    final void bn() {
        this.az = 0;
        if (!this.o) {
            this.b = 0;
        } else {
            this.b = (byte)3;
            this.cv();
            this.o = false;
        }
        this.aa = (byte)5;
        this.p = false;
    }

    final void bo() {
        switch (this.n) {
            case 3: {
                this.bp();
                return;
            }
            case 4: {
                this.bq();
                return;
            }
            case 1: {
                this.bs();
                return;
            }
            case 2: {
                this.bt();
                return;
            }
            case 5: {
                if (!this.p && this.v[this.R] > 0) {
                    if (this.a[this.R][this.P] == 11) {
                        if (this.y[this.aI[this.h[92] + this.R] - 1] >= 10) break;
                        int n = this.aI[this.h[92] + this.R] - 1;
                        this.y[n] = (byte)(this.y[n] + 1);
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
                    if (this.a[this.R][this.P] == 12) {
                        this.bu();
                        return;
                    }
                }
            }
            case -6: {
                if (this.p) break;
                this.bv();
                return;
            }
            case -7: {
                this.bG();
            }
        }
    }

    final void bp() {
        if (!this.p && this.v[this.R] > 0) {
            if (this.a[this.R][this.P] == 11 && this.y[this.aI[this.h[92] + this.R] - 1] < 10) {
                int n = this.aI[this.h[92] + this.R] - 1;
                this.y[n] = (byte)(this.y[n] + 1);
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
                this.P = (byte)(this.P + 1);
                if (this.P == 4 && this.K == 0) {
                    this.P = (byte)(this.P + 1);
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
                int n = this.aI[this.h[92] + this.R] - 1;
                this.y[n] = (byte)(this.y[n] - 1);
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
                this.P = (byte)(this.P - 1);
                if (this.P == 4 && this.K == 0) {
                    this.P = (byte)(this.P - 1);
                }
                if (this.P < 0) {
                    this.P = this.K == 1 ? (byte)(this.v[this.R] - 2) : (byte)(this.v[this.R] - 1);
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
                    this.F -= d.j[this.aC];
                }
                if (this.F < 0) {
                    this.F = 0;
                    return;
                }
            } else if (this.R != 26 && this.v[this.R] > 0) {
                if (this.R == 21) {
                    this.P = (byte)(this.P + 1);
                    if (this.P >= this.v[this.R]) {
                        this.P = 0;
                        return;
                    }
                } else {
                    this.P = (byte)(this.P - 1);
                    if (this.P < 0) {
                        this.P = (byte)(this.v[this.R] - 1);
                    }
                    if (this.w && this.a[this.R][this.P] == 4) {
                        this.P = (byte)(this.P - 1);
                    }
                }
            }
        }
    }

    final void bt() {
        if (!this.p) {
            if (this.R == 2 || this.R == 5 || this.R == 3 || this.R == 10 && this.K == 0) {
                if (this.G > this.F + d.j[this.aC]) {
                    this.F += d.j[this.aC];
                    return;
                }
            } else if (this.R != 26 && this.v[this.R] > 0) {
                if (this.R != 21) {
                    this.P = (byte)(this.P + 1);
                    if (this.P >= this.v[this.R]) {
                        this.P = 0;
                    }
                    if (this.w && this.a[this.R][this.P] == 4) {
                        this.P = (byte)(this.P + 1);
                        return;
                    }
                } else {
                    this.P = (byte)(this.P - 1);
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
            this.R = (byte)20;
            this.x[0] = 2;
            this.y[0] = (byte)this.i;
            this.w[this.R] = this.aI[this.h[137] + this.aI[this.h[56] + this.an]];
            this.cu();
            this.aa = (byte)5;
            return;
        }
        this.b = (byte)2;
        this.aa = (byte)5;
        this.C = this.U;
        this.B = (byte)3;
        this.aW = this.aI[this.h[151 + this.B] + this.C];
        this.aX = this.aI[this.h[146 + this.B] + this.C];
        this.o = true;
        this.cp();
    }

    final void bv() {
        if (this.R == 5) {
            this.bw();
            return;
        }
        if (this.R == 9) {
            if (this.P > 0) {
                this.dH();
            }
            this.a = this.a + this.a[this.P];
            this.R = (byte)15;
            this.cu();
            return;
        }
        if (this.R == 7) {
            this.N = this.P;
            this.R = (byte)17;
            this.cu();
            return;
        }
        if (this.R == 12 || this.R == 13 || this.d && this.R == 26) {
            if (this.L > 0 && !this.d) {
                this.R = (byte)26;
                this.P = (byte)4;
                this.cv();
                this.d = true;
                return;
            }
            if (this.e[0][0] >= this.e[0][1] || this.L == 0 && this.R == 12) {
                if (this.b > 0) {
                    this.g /= this.b;
                }
                this.R = (byte)11;
            } else {
                this.R = (byte)14;
            }
            this.cu();
            this.d = false;
            return;
        }
        if (this.R == 14) {
            this.R = (byte)10;
            this.cu();
            return;
        }
        if (this.R == 15) {
            this.br();
            this.R = 0;
            this.cu();
            return;
        }
        if (this.R == 16) {
            this.f();
            return;
        }
        if (this.R == 11) {
            this.bx();
            return;
        }
        if (this.R == 10) {
            this.az = 0;
            this.g();
            this.aa = (byte)5;
            this.b = 0;
            return;
        }
        if (this.v[this.R] == 0) {
            return;
        }
        if (this.a[this.R][this.P] == 5) {
            this.by();
            return;
        }
        if (this.a[this.R][this.P] == 40) {
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)22;
            this.cv();
            return;
        }
        if (this.a[this.R][this.P] == 0 || this.a[this.R][this.P] == 1) {
            this.bC();
            return;
        }
        if (this.a[this.R][this.P] == 2) {
            this.S = this.R;
            this.Q = this.P;
            this.R = (byte)4;
            this.cu();
            return;
        }
        if (this.a[this.R][this.P] == 21) {
            if (this.R == 1) {
                this.az = 0;
                this.b = 0;
            } else {
                this.ea();
            }
            this.aa = (byte)5;
            return;
        }
        if (this.a[this.R][this.P] == 22) {
            this.bB();
            return;
        }
        if (this.a[this.R][this.P] == 3) {
            this.cD();
            return;
        }
        if (this.a[this.R][this.P] == 95) {
            this.R = (byte)3;
            this.cv();
            return;
        }
        if (this.a[this.R][this.P] == 107) {
            try {
                if (this.a.platformRequest(this.a.getAppProperty(this.a))) {
                    this.S = 0;
                    this.R = (byte)5;
                    this.aA = (byte)40;
                    this.cv();
                }
                return;
            }
            catch (Exception exception) {
                return;
            }
        }
        if (this.a[this.R][this.P] == 6) {
            this.T = this.R;
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)16;
            this.cv();
            return;
        }
        if (this.a[this.R][this.P] == 4) {
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)15;
            this.cv();
            return;
        }
        if (this.a[this.R][this.P] == 11) {
            if (this.y[this.aI[this.h[92] + this.R] - 1] < 10) {
                int n = this.aI[this.h[92] + this.R] - 1;
                this.y[n] = (byte)(this.y[n] + 1);
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

    final void bw() {
        if (this.aA == 40) {
            return;
        }
        if (this.aA == 15) {
            this.ea();
            this.aa = (byte)5;
            return;
        }
        if (this.aA == 16) {
            this.dS();
            this.aA = this.y ? (byte)19 : (byte)18;
            this.l = true;
            this.cv();
            return;
        }
        if (this.aA == 22) {
            this.d();
            return;
        }
        if (this.aA == 14) {
            this.F = (byte)-1;
            this.H = (byte)-1;
        }
        this.R = this.T;
        this.cu();
    }

    final void bx() {
        if (this.K == 0) {
            this.R = 0;
        } else if (this.L + 1 >= this.a[8].length) {
            this.cD();
        } else {
            this.F = this.L = (byte)(this.L + 1);
            this.G = this.M;
            if (this.E <= this.L) {
                this.E = (byte)(this.L + 1);
            }
            this.dT();
            this.R = (byte)10;
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
            this.R = (byte)5;
            this.aA = (byte)17;
            this.cv();
        }
    }

    final void bz() {
        this.M = (byte)(this.a[this.R][this.P] - 8);
        if (this.K == 0) {
            this.R = (byte)10;
            this.w[10] = this.a[7][this.N];
            this.cu();
            return;
        }
        this.R = (byte)8;
        this.v[8] = this.E;
        this.cu();
        this.P = (byte)(this.v[8] - 1);
    }

    final void bA() {
        this.L = this.P;
        this.F = this.P;
        this.G = this.M;
        this.dT();
        if (this.L == 0) {
            this.az = 0;
            this.g();
            this.aa = (byte)5;
            this.b = 0;
            return;
        }
        this.R = (byte)10;
        this.w[10] = this.n[this.L];
        this.cu();
    }

    final void bB() {
        if (this.K == 1) {
            this.T = (byte)17;
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)14;
            this.cv();
            return;
        }
        this.R = (byte)7;
        this.cu();
    }

    final void bC() {
        this.K = this.a[this.R][this.P];
        this.L = 0;
        this.R = this.K == 0 && this.J != -1 || this.K == 1 && this.F != -1 ? (byte)6 : (this.K == 1 ? (byte)17 : (byte)7);
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
        this.aa = (byte)5;
    }

    final void bE() {
        if (this.R == 19) {
            this.aE[this.aI[this.h[57] + this.an]] = this.y[1];
            this.o = this.an;
            this.cJ();
        }
        if (this.n) {
            this.C = this.aI[this.h[56] + this.an];
            this.B = (byte)3;
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
            this.k -= this.i;
            this.e += this.i;
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
            this.aa = (byte)5;
            if (this.U > 1) {
                this.n = false;
                this.R = this.U == 2 ? (byte)21 : (this.U == 5 ? (byte)22 : (byte)19);
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
        if (this.R == 17 || this.R == 6 || this.R == 7 || this.R == 8 || this.R == 14 || this.R == 15) {
            if (this.R == 15) {
                this.aJ = 0;
            }
            this.aK = this.aJ;
            this.R = 0;
            this.cu();
            return;
        }
        if (this.R == 3) {
            this.R = 0;
            this.cv();
            return;
        }
        if (this.R == 23 || this.R == 24 || this.R == 1 || this.R == 26 && !this.d || this.R == 25 && (this.N == 0 || this.V < 3)) {
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
            this.aa = (byte)5;
            return;
        }
        if (this.R == 25 && this.N == 1 && this.V >= 3) {
            this.b(12);
            return;
        }
        if (this.R == 4) {
            this.P = this.Q;
            this.R = this.S;
            this.cv();
            return;
        }
        if (this.R == 2) {
            this.b = this.c;
            this.R = this.S;
            if (this.b == 3) {
                this.cv();
            }
            if (this.b == 2) {
                this.cp();
            }
            this.aa = (byte)5;
            return;
        }
        if (this.R == 5 && this.aA != 18 && this.aA != 19) {
            this.R = this.S;
            this.cv();
            return;
        }
        if (this.R == 20) {
            this.bH();
            return;
        }
        if ((this.R == 18 || this.R == 19 || this.R == 22 || this.R == 21) && this.p) {
            this.az = 0;
            this.b = 0;
            this.aa = (byte)5;
            this.p = false;
            return;
        }
        if (this.R == 18 || this.R == 19 || this.R == 21 || this.R == 22) {
            this.bD();
            return;
        }
        if (this.R == 0 && this.c[this.v[0] - 1] == 107) {
            this.S = this.R;
            this.R = (byte)5;
            this.aA = (byte)22;
            this.cv();
        }
    }

    final void bH() {
        this.aa = (byte)5;
        if (this.U > 1) {
            this.R = this.U == 2 ? (byte)21 : (this.U == 5 ? (byte)22 : (byte)19);
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

    final void bI() {
        switch (this.n) {
            case 3: {
                if (this.aO >= 2 || this.n[this.aO + 1] >= this.n[this.aO]) break;
                this.aO = (byte)(this.aO + 1);
                return;
            }
            case 4: {
                if (this.aO <= 0 || this.n[this.aO - 1] <= this.n[this.aO]) break;
                this.aO = (byte)(this.aO - 1);
                return;
            }
            case -7: 
            case 5: {
                this.b = 0;
                this.aa = (byte)5;
            }
        }
    }

    final void bJ() {
        switch (this.n) {
            case 1: {
                if (this.F > 0) {
                    this.F -= d.j[this.aC];
                }
                if (this.F >= 0) break;
                this.F = 0;
                return;
            }
            case 2: {
                if (this.G <= this.F + d.j[this.aC]) break;
                this.F += d.j[this.aC];
                return;
            }
            case -6: 
            case 5: {
                this.b = 0;
                this.aa = (byte)5;
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
                this.a[0] = this.a[0] - 1;
                this.bO();
                this.a[0] = this.a[0] + 1;
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
                this.a[1] = this.a[1] + 1;
                this.bO();
                this.a[1] = this.a[1] - 1;
            }
        }
    }

    final void bL() {
        this.ar = 0;
        while (this.ar < 42) {
            if (this.l[0][this.ar] >= 0 && this.Z[this.ar] == 22) {
                this.as = this.ar;
                this.bP();
            }
            ++this.ar;
        }
    }

    final void bM() {
        this.ar = 0;
        while (this.ar < 42) {
            if (this.l[0][this.ar] >= 0) {
                if (this.o[this.Z[this.ar]][this.g[this.Z[this.ar]][4] + 3] == 1) {
                    this.as = this.ar;
                    this.bN();
                } else {
                    this.b[this.ar] = true;
                }
            }
            ++this.ar;
        }
    }

    final void bN() {
        try {
            this.b[this.as] = false;
            this.aq = 0;
            while (this.aq < 15) {
                if (this.k[this.aq][0] >= 0 && this.d[this.c[this.k[this.aq][0]][this.k[this.aq][1]]]) {
                    this.b[this.as] = true;
                    if (this.k[this.aq][0] - b.j[0][0] >= this.l[0][this.as] + this.o[this.Z[this.as]][this.g[this.Z[this.as]][0]] || this.k[this.aq][1] - b.j[1][0] >= this.l[1][this.as] + this.o[this.Z[this.as]][this.g[this.Z[this.as]][0] + 1] || this.k[this.aq][0] + b.j[0][1] < this.l[0][this.as] || this.k[this.aq][1] + b.j[1][1] < this.l[1][this.as]) {
                        this.b[this.as] = false;
                    }
                    if (this.b[this.as]) break;
                }
                ++this.aq;
            }
            if (!this.b[this.as]) {
                this.ax = (byte)this.as;
                this.d(true);
                if (this.ag[this.as] == 3) {
                    this.aj[this.as] = this.af[this.as] < this.av[this.Z[this.as]] ? (byte)0 : 1;
                }
            }
            return;
        }
        catch (Exception exception) {
            return;
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
                this.p[1] = this.p[1] + 1;
            }
            this.ad[this.as] = 1;
            this.q[0] = -1;
            this.bQ();
            int n = this.as;
            this.ad[n] = (byte)(this.ad[n] + 5);
        }
    }

    final void bQ() {
        do {
            this.aq = 0;
            while (this.aq < 4) {
                if (this.p[0] + this.aI[this.h[31] + this.aq * 2] < this.O && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] < this.O && this.p[0] + this.aI[this.h[31] + this.aq * 2] >= 0 && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] >= 0) {
                    if (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 7 && this.aq == 1 || this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 8 && this.aq == 0) {
                        if (this.m[0][this.c[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]]] == 0) {
                            this.l[0][this.c[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]]] = -1;
                            this.ai = (byte)(this.ai - 1);
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
                    if (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 13 && (this.p[0] + this.aI[this.h[31] + this.aq * 2] != this.q[0] || this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] != this.q[1])) {
                        this.q[0] = this.p[0];
                        this.q[1] = this.p[1];
                        this.p[0] = this.p[0] + this.aI[this.h[31] + this.aq * 2];
                        this.p[1] = this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1];
                        this.c[this.p[0]][this.p[1]] = (byte)this.as;
                        if (this.ad[this.as] >= 20) break;
                        int n = this.as;
                        this.ad[n] = (byte)(this.ad[n] + 1);
                        break;
                    }
                }
                ++this.aq;
            }
            if (this.aq != 4) continue;
            return;
        } while (!this.a[this.as]);
    }

    /*
     * Enabled aggressive block sorting
     */
    final void bR() {
        block15: {
            this.i = true;
            this.aA = (byte)5;
            this.U = (byte)-1;
            if (this.b[this.a[0]][this.a[1]] > 3 && this.b[this.a[0]][this.a[1]] <= 13) {
                this.bS();
                if (this.ar != 22) {
                    if (this.ac[this.c[this.a[0]][this.a[1]]] > 0) {
                        this.i = false;
                        return;
                    }
                    break block15;
                } else {
                    this.j = false;
                    if (this.c[this.a[0]][this.a[1]] < 0) {
                        return;
                    }
                    if (this.Z[this.c[this.a[0]][this.a[1]]] != 22 || !this.a[this.c[this.a[0]][this.a[1]]]) return;
                    this.bT();
                    return;
                }
            }
            if (this.b[this.a[0]][this.a[1]] == 0) {
                this.bV();
                return;
            }
            if (this.b[this.a[0]][this.a[1]] >= 0) return;
            this.bW();
            return;
        }
        this.at = this.l[0][this.c[this.a[0]][this.a[1]]];
        while (this.at < this.l[0][this.c[this.a[0]][this.a[1]]] + this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0]]) {
            this.au = this.l[1][this.c[this.a[0]][this.a[1]]];
            while (this.au < this.l[1][this.c[this.a[0]][this.a[1]]] + this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0] + 1]) {
                if (this.c[this.at][this.au] != -1 && this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][37] + (this.aa[this.c[this.a[0]][this.a[1]]] * this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0]] + this.at - this.l[0][this.c[this.a[0]][this.a[1]]]) * this.o[this.Z[this.c[this.a[0]][this.a[1]]]][this.g[this.Z[this.c[this.a[0]][this.a[1]]]][0] + 1] + this.au - this.l[1][this.c[this.a[0]][this.a[1]]]] != 1) {
                    if (this.ar == 23 && this.A[this.c[this.at][this.au]] == 10 && this.d[this.c[this.at][this.au]] == -1) {
                        this.U = (byte)2;
                        this.j = this.c[this.at][this.au];
                    } else {
                        this.i = false;
                        return;
                    }
                }
                ++this.au;
            }
            ++this.at;
        }
        return;
    }

    final void bS() {
        this.ar = (byte)-1;
        if (this.b[this.a[0]][this.a[1]] == 13) {
            this.ar = (byte)22;
        }
        if ((this.b[this.a[0]][this.a[1]] == 5 || this.b[this.a[0]][this.a[1]] == 7) && this.b[this.a[0] - 1][this.a[1]] == 13) {
            this.ar = (byte)22;
        }
        if ((this.b[this.a[0]][this.a[1]] == 6 || this.b[this.a[0]][this.a[1]] == 8) && this.b[this.a[0]][this.a[1] + 1] == 13) {
            this.ar = (byte)22;
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
            this.p[1] = this.p[1] + 1;
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
        block0: do {
            if (this.c[this.p[0]][this.p[1]] != -1) {
                this.i = false;
            }
            if (this.p[0] == this.a[0] && this.p[1] == this.a[1]) {
                this.j = true;
            }
            this.aq = 0;
            while (this.aq < 4) {
                if (this.p[0] + this.aI[this.h[31] + this.aq * 2] < this.O && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] < this.O && this.p[0] + this.aI[this.h[31] + this.aq * 2] >= 0 && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] >= 0) {
                    if (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 7 && this.aq == 1 || this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 8 && this.aq == 0) {
                        if (this.c[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] != -1) {
                            this.i = false;
                        }
                        if (this.p[0] + this.aI[this.h[31] + this.aq * 2] == this.a[0] && this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] == this.a[1]) {
                            this.j = true;
                        }
                        this.aq = 4;
                        continue block0;
                    }
                    if (this.b[this.p[0] + this.aI[this.h[31] + this.aq * 2]][this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1]] == 13 && (this.p[0] + this.aI[this.h[31] + this.aq * 2] != this.q[0] || this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1] != this.q[1])) {
                        this.q[0] = this.p[0];
                        this.q[1] = this.p[1];
                        this.p[0] = this.p[0] + this.aI[this.h[31] + this.aq * 2];
                        this.p[1] = this.p[1] + this.aI[this.h[31] + this.aq * 2 + 1];
                        continue block0;
                    }
                }
                ++this.aq;
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
                this.a[0] = this.a[0] - 1;
                this.bR();
                this.a[0] = this.a[0] + 1;
            }
            if (this.a[1] < this.O - 1 && (this.b[this.a[0]][this.a[1] + 1] == 6 || this.b[this.a[0]][this.a[1] + 1] == 8)) {
                this.a[1] = this.a[1] + 1;
                this.bR();
                this.a[1] = this.a[1] - 1;
            }
            if (this.a[0] == this.ab && this.a[1] == 0) {
                this.aA = (byte)8;
                this.i = false;
            }
        }
    }

    final void bW() {
        this.at = 0;
        while (this.at < 2) {
            if (!(this.at == 0 && this.a[0] >= this.O - 1 || this.at == 1 && this.a[1] <= 0 || this.aI[this.h[163 + this.at] - 1 - this.b[this.a[0]][this.a[1]]] == 0)) {
                this.au = this.c[this.a[0] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.at] * 4 + 2] * 2]][this.a[1] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.at] * 4 + 2] * 2 + 1]];
                while (this.au >= 0) {
                    if (this.au < 200 && this.W[this.au] == this.aI[this.h[53] + -1 - this.b[this.a[0]][this.a[1]]] && this.h[2][this.au] == this.at && this.h[0][this.au] < 2) {
                        this.i = false;
                        if (this.h[0][this.au] != 0) break;
                        this.aA = (byte)10;
                        break;
                    }
                    this.au = this.d[this.au];
                }
                if (!this.i) break;
            }
            ++this.at;
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
            this.aa = (byte)5;
            return;
        }
        if (this.b[this.a[0]][this.a[1]] == 0) {
            if (this.c[this.a[0]][this.a[1]] % 4 != 0) {
                byte[] byArray = this.c[this.a[0]];
                int n = this.a[1];
                byArray[n] = (byte)(byArray[n] - this.c[this.a[0]][this.a[1]] % 4);
                return;
            }
            this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
            this.c[this.a[0]][this.a[1]] = 0;
            this.bK();
            this.aa = (byte)5;
            return;
        }
        if (this.b[this.a[0]][this.a[1]] < 0) {
            this.bZ();
        }
    }

    final void bY() {
        if (this.j) {
            this.a[this.c[this.a[0]][this.a[1]]] = false;
        }
        if (this.b[this.a[0]][this.a[1]] == 5 || this.b[this.a[0]][this.a[1]] == 7) {
            this.b[this.a[0] - 1][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
            this.c[this.a[0] - 1][this.a[1]] = 0;
            this.aw = this.a[0];
            this.ax = this.a[1];
            this.cb();
        } else if (this.b[this.a[0]][this.a[1]] == 6 || this.b[this.a[0]][this.a[1]] == 8) {
            this.b[this.a[0]][this.a[1] + 1] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
            this.c[this.a[0]][this.a[1] + 1] = 0;
            this.aw = this.a[0];
            this.ax = this.a[1];
            this.cb();
        } else {
            if (this.b[this.a[0]][this.a[1]] == 13 && this.a[0] < this.O - 1 && (this.b[this.a[0] + 1][this.a[1]] == 5 || this.b[this.a[0] + 1][this.a[1]] == 7)) {
                this.aw = this.a[0] + 1;
                this.ax = this.a[1];
                this.cb();
                this.b[this.a[0] + 1][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                this.c[this.a[0] + 1][this.a[1]] = 0;
            }
            if (this.b[this.a[0]][this.a[1]] == 13 && this.a[1] > 0 && (this.b[this.a[0]][this.a[1] - 1] == 6 || this.b[this.a[0]][this.a[1] - 1] == 8)) {
                this.aw = this.a[0];
                this.ax = this.a[1] - 1;
                this.cb();
                this.b[this.a[0]][this.a[1] - 1] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                this.c[this.a[0]][this.a[1] - 1] = 0;
            }
        }
        this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
        this.c[this.a[0]][this.a[1]] = 0;
    }

    final void bZ() {
        if (this.b[this.a[0]][this.a[1]] <= -15) {
            this.ak[this.c[this.a[0]][this.a[1]]] = -1;
            this.ak = (byte)(this.ak - 1);
        }
        if (this.b[this.a[0]][this.a[1]] <= -27) {
            this.av = 0;
            while (this.av < 15) {
                if (!(this.a[0] != this.k[this.av][0] && this.a[0] - 1 != this.k[this.av][0] || this.a[1] != this.k[this.av][1] && this.a[1] - 1 != this.k[this.av][1] || this.k[this.av][0] < 0)) {
                    this.at = this.k[this.av][0];
                    while (this.at < this.k[this.av][0] + 2) {
                        this.au = this.k[this.av][1];
                        while (this.au < this.k[this.av][1] + 2) {
                            this.b[this.at][this.au] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                            this.c[this.at][this.au] = 0;
                            ++this.au;
                        }
                        ++this.at;
                    }
                    this.k[this.av][0] = -1;
                    this.ah = (byte)(this.ah - 1);
                    break;
                }
                ++this.av;
            }
            this.bM();
        } else {
            if (this.b[this.a[0]][this.a[1]] == -14) {
                this.av = 0;
                while (this.av < 30) {
                    if (this.i[this.av][0] == this.a[0] && this.i[this.av][1] == this.a[1]) {
                        this.i[this.av][0] = -1;
                        this.ag = (byte)(this.ag - 1);
                        break;
                    }
                    ++this.av;
                }
            }
            this.b[this.a[0]][this.a[1]] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
            this.c[this.a[0]][this.a[1]] = 0;
        }
        this.aa = (byte)5;
    }

    final void ca() {
        this.e = this.c[this.a[0]][this.a[1]];
        this.ai = (byte)(this.ai - 1);
        this.at = this.l[0][this.e];
        while (this.at < this.l[0][this.e] + this.o[this.ar][this.g[this.ar][0]]) {
            this.au = this.l[1][this.e];
            while (this.au < this.l[1][this.e] + this.o[this.ar][this.g[this.ar][0] + 1]) {
                if (this.o[this.ar][this.g[this.ar][37] + (this.aa[this.e] * this.o[this.ar][this.g[this.ar][0]] + this.at - this.l[0][this.e]) * this.o[this.ar][this.g[this.ar][0] + 1] + this.au - this.l[1][this.e]] != 1) {
                    this.b[this.at][this.au] = (byte)((this.a.nextInt() & 0xFFFF) % 3 + 1);
                    this.c[this.at][this.au] = 0;
                }
                ++this.au;
            }
            ++this.at;
        }
        this.dy();
        this.l[0][this.e] = -1;
    }

    final void cb() {
        if (this.b[this.aw][this.ax] == 5 || this.b[this.aw][this.ax] == 6) {
            this.m[0][this.c[this.aw][this.ax]] = 0;
            if (this.m[1][this.c[this.aw][this.ax]] != 0) {
                this.l[0][this.c[this.aw][this.ax]] = this.n[0][this.c[this.aw][this.ax]];
                this.l[1][this.c[this.aw][this.ax]] = this.n[1][this.c[this.aw][this.ax]];
            }
        } else {
            this.m[1][this.c[this.aw][this.ax]] = 0;
        }
        if (this.m[0][this.c[this.aw][this.ax]] == 0 && this.m[1][this.c[this.aw][this.ax]] == 0) {
            this.ai = (byte)(this.ai - 1);
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
            this.aa = (byte)5;
        } else if (this.aX == 1) {
            this.cf();
            this.cg();
        } else if (this.aX == 2) {
            byte by = this.C;
            this.e[by] = (short)(this.e[by] + 1);
            byte by2 = b.j[3];
            this.e[by2] = (short)(this.e[by2] + this.aI[this.h[131] + this.C]);
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
                ++this.ay;
            }
            this.ai = (byte)(this.ai + 1);
            this.Z[this.ay] = this.aW;
            this.aa[this.ay] = this.at;
            this.l[0][this.ay] = (byte)this.a[0];
            this.l[1][this.ay] = (byte)this.a[1];
            this.ab[this.ay] = 0;
            this.ac[this.ay] = 0;
            this.ad[this.ay] = 0;
            this.ae[this.ay] = this.aa[this.ay] == 0 ? (byte)(this.l[1][this.ay] + this.o[this.Z[this.ay]][this.g[this.Z[this.ay]][0] + 1] - 1) : this.l[0][this.ay];
            this.k = true;
            this.m[0][this.ay] = 0;
            this.m[1][this.ay] = 0;
        }
        if (this.j >= 0) {
            this.az = b.a[this.at][this.j][0];
            return;
        }
        this.az = 0;
    }

    final void ce() {
        while (this.az < this.B) {
            this.aA = this.j >= 0 ? b.b[this.at][this.j][0] : 0;
            while (this.aA < this.C) {
                if (this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.az) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aA] != 1) {
                    this.b[this.a[0] + this.az][this.a[1] + this.aA] = this.o[this.aW][this.g[this.aW][37] + (this.at * this.o[this.aW][this.g[this.aW][0]] + this.az) * this.o[this.aW][this.g[this.aW][0] + 1] + this.aA];
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
                ++this.aA;
            }
            ++this.az;
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
            return;
        }
        this.ay = 0;
        while (this.ay < 90 && this.ak[this.ay] >= 0) {
            ++this.ay;
        }
        this.az = 0;
        while (this.az < this.B) {
            this.aA = 0;
            while (this.aA < this.C) {
                this.b[this.a[0] + this.az][this.a[1] + this.aA] = this.au;
                if (this.au == -27) {
                    this.b[this.a[0] + this.az][this.a[1] + this.aA] = b.i[this.az][this.aA];
                }
                this.c[this.a[0] + this.az][this.a[1] + this.aA] = (byte)this.ay;
                ++this.aA;
            }
            ++this.az;
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
        this.ak = (byte)(this.ak + 1);
    }

    final void cg() {
        if (this.au == -14) {
            this.ay = 0;
            while (this.ay < 30 && this.i[this.ay][0] >= 0) {
                ++this.ay;
            }
            this.i[this.ay][0] = (byte)this.a[0];
            this.i[this.ay][1] = (byte)this.a[1];
            this.ag = (byte)(this.ag + 1);
        }
        if (this.au == -27) {
            this.ay = 0;
            while (this.ay < 15 && this.k[this.ay][0] >= 0) {
                ++this.ay;
            }
            this.k[this.ay][0] = (byte)this.a[0];
            this.k[this.ay][1] = (byte)this.a[1];
            this.ah = (byte)(this.ah + 1);
        }
        this.aa = (byte)5;
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
            byte[] byArray = this.c[this.a[0]];
            int n = this.a[1];
            byArray[n] = (byte)(byArray[n] + (this.aW + this.av));
            this.bK();
        }
        this.aa = (byte)5;
    }

    final void ci() {
        this.dy();
        this.aT[0] = (byte)(this.b[0] + this.a[0]);
        this.aT[1] = (byte)(this.b[1] + this.a[1]);
        this.h = (short)(this.z / 2);
        this.i = 0;
        if (this.j < 0) {
            this.k -= this.i;
            this.e += this.i;
            this.a.delete(0, this.a.length());
            this.a.append("-");
            this.a.append(this.i);
            this.b = this.a.toString();
        } else {
            this.k -= this.i / 2;
            this.e += this.i / 2;
            this.a.delete(0, this.a.length());
            this.a.append("-");
            this.a.append(this.i / 2);
            this.b = this.a.toString();
        }
        this.dM();
        if (this.aX != 2) {
            this.Y = (byte)(this.a[0] / 5);
            while (this.Y <= (byte)((this.a[0] + this.B - 1) / 5)) {
                this.Z = (byte)(this.a[1] / 5);
                while (this.Z <= (byte)((this.a[1] + this.C - 1) / 5)) {
                    this.cH();
                    this.Z = (byte)(this.Z + 1);
                }
                this.Y = (byte)(this.Y + 1);
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
            this.ac = (byte)(this.ac + 1);
        } else {
            this.d[this.c[this.a[0]][this.a[1]]] = true;
            if (this.b[this.a[0]][this.a[1]] != -16 && this.b[this.a[0]][this.a[1]] != -17 && this.b[this.a[0]][this.a[1]] != -27 && this.b[this.a[0]][this.a[1]] != -28) {
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
            ++this.ay;
        }
        this.A[this.ay] = (byte)(8 + this.C);
        if (this.A[this.ay] == 10) {
            this.B[this.ay] = (byte)(this.l[0][this.c[this.a[0]][this.a[1]]] + this.aI[this.h[78]]);
            this.C[this.ay] = (byte)(this.l[1][this.c[this.a[0]][this.a[1]]] + this.aI[this.h[78] + 1]);
            this.F[this.ay] = 1;
            this.G[this.ay] = this.aI[this.h[78] + 2];
            this.H[this.ay] = this.aI[this.h[78] + 3];
            this.az = 0;
            while (this.az < 12) {
                this.e[this.c[this.a[0]][this.a[1]]][this.az] = -1;
                ++this.az;
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
            this.ay = 0;
            while (this.ay < this.b.length) {
                if (this.aI[this.h[140] + this.ay] == this.aX && (this.aI[this.h[141] + this.ay] == this.az || this.aI[this.h[141] + this.ay] == -1) && this.b[this.ay] == 0) {
                    this.b[this.ay] = 1;
                    return;
                }
                ++this.ay;
            }
        }
    }

    final void cm() {
        if (this.U == 2) {
            this.a[this.c[this.a[0]][this.a[1]]] = false;
            this.ay = 200;
            while (this.ay < 222) {
                if (this.B[this.ay] >= 0 && this.A[this.ay] == 10 && this.c[this.a[0]][this.a[1]] == this.c[this.B[this.ay]][this.C[this.ay]]) {
                    this.ac = (byte)(this.ac - 1);
                    this.aB = this.ay;
                    this.dq();
                    this.B[this.ay] = -1;
                    break;
                }
                ++this.ay;
            }
        } else if (this.U < 2) {
            this.ac = (byte)(this.ac - 1);
            this.aB = this.j;
            this.dq();
            this.B[this.j] = -1;
        } else {
            this.d[this.c[this.a[0]][this.a[1]]] = false;
            this.e[this.c[this.a[0]][this.a[1]]] = true;
        }
        byte by = this.U;
        this.e[by] = (short)(this.e[by] - 1);
        byte by2 = b.j[3];
        this.e[by2] = (short)(this.e[by2] - this.aI[this.h[131] + this.U]);
    }

    final void cn() {
        if (this.j >= 0 && this.j < 2) {
            this.j = (byte)(this.j + 1);
            if (this.j < 2) {
                this.B = b.a[this.at][this.j][1];
                this.C = b.b[this.at][this.j][1];
            }
            if (this.j == 2) {
                this.B = (byte)4;
                this.C = (byte)2;
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
                this.j = (byte)-1;
            }
            if (this.a[0] < 0) {
                this.a[0] = 0;
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[0] = nArray[0] + 1;
                    ++this.q;
                }
            }
            if (this.a[1] < 0) {
                this.a[1] = 0;
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[1] = nArray[1] + 1;
                    ++this.q;
                }
            }
            if (this.a[0] >= this.O - 1) {
                this.a[0] = this.O - 2;
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[0] = nArray[0] - 1;
                    ++this.q;
                }
            }
            if (this.a[1] >= this.O - 1) {
                this.a[1] = this.O - 2;
                this.q = 0;
                while (this.q < 4) {
                    int[] nArray = this.f[this.q];
                    nArray[1] = nArray[1] - 1;
                    ++this.q;
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
        this.aC = 0;
        while (this.aC < 4) {
            int[] nArray = this.f[this.aC];
            nArray[0] = nArray[0] + this.aE;
            int[] nArray2 = this.f[this.aC];
            nArray2[1] = nArray2[1] + this.aF;
            ++this.aC;
        }
    }

    final void cp() {
        this.cq();
        if (this.aA >= 0) {
            if (!this.p) {
                this.aa = (byte)5;
            }
            this.p = true;
            this.aC = (byte)3;
            this.dI();
            return;
        }
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

    final void cq() {
        this.az = 1;
        this.aA = (byte)-1;
        switch (this.aX) {
            case 0: {
                this.f = this.aI[this.h[135] + this.aW];
                if (this.ai < 42) break;
                this.aA = 0;
                break;
            }
            case 1: {
                this.f = this.aI[this.h[136] + this.aW];
                if (-1 - this.aW <= -15 && this.ak >= 90) {
                    this.aA = 1;
                }
                if (-1 - this.aW == -14 && this.ag >= 30) {
                    this.aA = (byte)2;
                }
                if (-1 - this.aW != -27 || this.ah < 15) break;
                this.aA = (byte)3;
                break;
            }
            case 2: {
                this.f = this.aI[this.h[137] + this.C];
                if (this.C >= 3 || this.ac < 22) break;
                this.aA = (byte)4;
                break;
            }
            case 3: {
                this.f = this.aI[this.h[139] + this.aW];
            }
        }
        this.g = 1;
        this.h = (short)(this.l / 2);
        this.i = (short)65;
        this.dL();
    }

    final void cr() {
        if (this.p) {
            this.aa = (byte)5;
        }
        this.p = false;
        if (this.aX == 2) {
            this.f = this.aI[this.h[138] + this.C];
            this.g = 1;
            this.h = (short)(this.l / 2);
            this.i = (short)240;
            this.dL();
        }
        switch (this.aX) {
            case 0: {
                this.i = this.az[this.aW] * 10;
                break;
            }
            case 1: {
                this.i = this.aI[this.h[58] + this.aW];
                break;
            }
            case 2: {
                this.i = this.aI[this.h[131] + this.C];
                break;
            }
            case 3: {
                this.i = this.aI[this.h[133] + this.aW];
            }
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
            this.y -= (this.C + 1) % 2 * b.B[1] / 2;
            this.A += (this.C + 1) % 2 * b.B[1] / 2;
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
            this.y -= (this.C + 1) % 2 * b.B[1] / 2;
            this.A += (this.C + 1) % 2 * b.B[1] / 2;
            this.b[0] = -(this.C / 2);
            this.b[1] = this.C / 2;
            this.at = 0;
            return;
        }
        this.cs();
    }

    final void cu() {
        this.P = 0;
        this.cv();
    }

    final void cv() {
        if (this.b != 3) {
            return;
        }
        this.cw();
        this.cx();
        if (this.R == 26) {
            switch (this.P) {
                case 0: 
                case 1: 
                case 2: 
                case 5: {
                    this.aG = 0;
                    while (this.aG < 2) {
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
                        ++this.aG;
                    }
                    break;
                }
                case 3: {
                    this.cy();
                    break;
                }
                case 4: {
                    this.cz();
                }
            }
        }
        this.cA();
        this.cB();
        this.cC();
    }

    final void cw() {
        this.az = this.aI[this.h[94] + this.R];
        if (this.R != 2) {
            if (this.R != 5) {
                this.aA = (byte)-1;
                switch (this.R) {
                    case 18: {
                        if (!(this.ar != 22 || this.c[this.a[0]][this.a[1]] >= 0 && this.a[this.c[this.a[0]][this.a[1]]])) {
                            this.aA = (byte)21;
                            break;
                        }
                        if (!this.b[this.c[this.a[0]][this.a[1]]]) {
                            this.aA = (byte)6;
                            break;
                        }
                        if (!this.a[this.c[this.a[0]][this.a[1]]]) {
                            this.aA = (byte)7;
                            break;
                        }
                        if (this.ah[this.c[this.a[0]][this.a[1]]] >= 10) break;
                        this.aA = (byte)11;
                        break;
                    }
                    case 19: {
                        if (!this.f[this.c[this.a[0]][this.a[1]]]) break;
                        this.aA = (byte)7;
                    }
                }
            }
            if (this.aA >= 0) {
                if (this.R != 5) {
                    this.p = true;
                }
                this.aC = (byte)3;
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
        this.w = this.R == 1 && this.K == 0 && this.J == -1;
        if (!(this.p || this.R == 26 || this.v[this.R] <= 0 && this.R != 14 && this.R != 15 && this.R != 16 && this.R != 12 && this.R != 13)) {
            this.aG = 0;
            while (this.aG < this.a[this.R].length) {
                if (!(this.a[this.R][this.aG] == 11 || this.a[this.R][this.aG] == 12 && this.n)) {
                    if (this.R == 8 && this.aG >= this.E) break;
                    if (!this.w || this.a[this.R][this.aG] != 4) {
                        this.f = this.a[this.R][this.aG];
                        if (this.a[this.R][this.aG] == 10 && !this.m) {
                            this.f = (short)(this.f + 1);
                        }
                        if (this.a[this.R][this.aG] == 112 && this.aJ > 0) {
                            this.f = (short)(this.f + 1);
                        }
                        this.i = this.R == 12 || this.R == 13 ? (short)((this.m + b.c[this.R - 12][1]) / 2 + 3) : (this.a[this.R][this.aG] == 12 ? d.p[this.R] : (short)(d.d[this.R][0] + d.d[this.R][1] * this.aG));
                        if (this.w) {
                            this.i = this.aG < 1 ? (short)(this.i + d.d[this.R][1] / 2) : (short)(this.i - d.d[this.R][1] / 2);
                        }
                        this.h = (short)(this.l / 2);
                        this.dL();
                    }
                }
                ++this.aG;
            }
        }
        if ((this.R != 2 || this.aA != 29) && this.w[this.R] != -1) {
            this.f = this.R != 26 ? (short)this.w[this.R] : (short)this.k[this.P];
            this.i = (short)65;
            this.h = (short)(this.l / 2);
            this.dL();
        }
        if (!this.p) {
            this.aG = 0;
            while (this.aG < this.aI[this.h[92] + this.R]) {
                this.a.delete(0, this.a.length());
                this.a.append(this.y[this.aG]);
                this.b = this.a.toString();
                this.g = 0;
                this.h = (short)153;
                this.i = (short)(d.e[this.R][this.aG] - b.b[0] / 2);
                this.dN();
                ++this.aG;
            }
        }
    }

    final void cy() {
        this.aG = 0;
        while (this.aG < b.j[3] + 1) {
            this.a.delete(0, this.a.length());
            this.a.append(this.e[this.aG]);
            this.b = this.a.toString();
            this.g = 0;
            this.h = d.v[this.aG];
            this.i = d.w[this.aG];
            this.dN();
            ++this.aG;
        }
    }

    final void cz() {
        this.ad();
        this.aG = 0;
        while (this.aG < 3) {
            this.a.delete(0, this.a.length());
            this.a.append(this.e[this.aG][0]);
            this.a.append("/");
            this.a.append(this.e[this.aG][1]);
            this.b = this.a.toString();
            this.g = 0;
            this.h = (short)70;
            this.i = (short)(d.z[this.aG] - b.b[0] / 2);
            this.dN();
            ++this.aG;
        }
    }

    final void cA() {
        if (this.R == 23) {
            this.aG = 0;
            while (this.aG < 2) {
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
                ++this.aG;
            }
        }
        if (this.R == 10) {
            if (this.K == 1) {
                this.f = (byte)(8 + this.M);
                this.i = d.d[this.R][0];
                this.h = (short)(this.l / 2);
                this.dL();
                this.aG = 0;
                while (this.aG < 3) {
                    this.a.delete(0, this.a.length());
                    this.a.append(this.a[this.M][this.L][this.aG]);
                    this.b = this.a.toString();
                    this.g = 0;
                    this.h = (short)(this.l / 2);
                    this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * (this.aG + 1));
                    this.dN();
                    ++this.aG;
                }
            } else {
                this.aA = (byte)(33 + this.N);
                this.aC = 0;
                this.dI();
            }
        }
        if (this.R == 3) {
            this.aA = (byte)32;
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
            this.aG = 0;
            while (this.aG < this.o.length) {
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
                this.g = (short)2;
                this.h = (short)((this.l + d.A[0]) / 2 + 2);
                this.dN();
                while (this.d[this.az - 1] + this.aH < d.A[0]) {
                    this.az = (byte)(this.az - 1);
                    this.b = "." + this.b;
                    this.dN();
                }
                ++this.aG;
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
            this.i = (short)105;
            this.dL();
            this.ct();
        }
    }

    final void cC() {
        if (this.R == 25) {
            this.aG = 0;
            while (this.aG < this.u.length) {
                this.h[1][this.aG] = 0;
                this.aH = 0;
                while (this.aH < d.k[4]) {
                    int[] nArray = this.h[1];
                    int n = this.aG;
                    nArray[n] = nArray[n] + this.c[3 + this.aG][this.aH];
                    ++this.aH;
                }
                int[] nArray = this.h[1];
                int n = this.aG;
                nArray[n] = nArray[n] / d.k[4];
                this.h[0][this.aG] = this.aG;
                ++this.aG;
            }
            this.aG = 0;
            while (this.aG < this.u.length - 1) {
                this.aH = this.aG + 1;
                while (this.aH < this.u.length) {
                    if (this.h[1][this.aG] < this.h[1][this.aH]) {
                        this.aI = this.h[0][this.aG];
                        this.h[0][this.aG] = this.h[0][this.aH];
                        this.h[0][this.aH] = this.aI;
                        this.aI = this.h[1][this.aG];
                        this.h[1][this.aG] = this.h[1][this.aH];
                        this.h[1][this.aH] = this.aI;
                    }
                    ++this.aH;
                }
                ++this.aG;
            }
            this.aG = 0;
            while (this.aG < this.u.length) {
                this.g = 0;
                this.f = this.u[this.h[0][this.aG]];
                this.i = (short)(d.d[this.R][0] + d.d[this.R][1] * this.aG);
                this.h = (short)((this.l - d.A[3]) / 2 + 13);
                this.dL();
                this.aH = this.d[this.az - 1] + 15;
                this.a.delete(0, this.a.length());
                this.a.append(this.h[1][this.aG]);
                this.b = this.a.toString();
                this.g = (short)2;
                this.h = (short)((this.l + d.A[0]) / 2 + 2);
                this.dN();
                while (this.d[this.az - 1] + this.aH < (d.A[3] + d.A[0]) / 2) {
                    this.az = (byte)(this.az - 1);
                    this.b = "." + this.b;
                    this.dN();
                }
                ++this.aG;
            }
        }
    }

    final void cD() {
        this.c = this.b;
        if (this.b == 3 && this.R == 11) {
            this.S = 0;
            this.P = 0;
            this.aA = (byte)29;
        } else {
            this.cE();
            this.S = this.R;
            this.aA = this.aI[this.h[171 + this.c] + this.aJ];
        }
        this.b = (byte)3;
        this.R = (byte)2;
        this.aC = 0;
        this.i[this.aA] = true;
        this.dI();
        this.cv();
        this.aa = (byte)5;
    }

    final void cE() {
        this.aJ = 0;
        if (this.b == 2) {
            this.aJ = this.aI[this.h[175] + this.B] + this.C;
        }
        if (this.b == 3) {
            this.aJ = this.R;
            if (this.R == 26) {
                this.aJ += this.P;
            }
        }
    }

    final void cF() {
        this.a[this.a].drawRegion(this.c[2], (int)b.i[0], (int)b.i[1], (int)b.i[2], (int)b.i[3], 0, this.l - 40, 2, 20);
        this.aK = this.c[2][d.k[4] + 1] == 0 ? 3 : 5 - (this.c[1][d.k[4] + 1] - 1) / 2;
        this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + this.aK], (int)this.aI[this.h[72] + this.aK], (int)this.aI[this.h[73] + this.aK], (int)this.aI[this.h[74] + this.aK], 0, this.l - 40 + (b.i[2] - this.aI[this.h[73] + this.aK]) / 2, 2 + (b.i[3] - this.aI[this.h[74] + this.aK]) / 2, 20);
    }

    final void cG() {
        this.a[this.a].drawRegion(this.c[2], 73, 0, 16, 13, 0, (int)d.a[0], (int)d.b[0], 20);
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
            this.a[this.a].setColor(0xFF0000);
            this.q = 0;
            while (this.q < 2) {
                this.a[this.a].drawRect(d.a[0] - 2 - this.q, d.b[0] - 2 - this.q, d.a[1] + this.d[0] + this.q * 2 - d.a[0] + 3, 13 + this.q * 2 + 3);
                ++this.q;
            }
            this.h = (byte)(this.h + 1);
            if (this.h >= this.u) {
                this.h = (byte)-1;
            }
        }
    }

    final void cH() {
        this.a[this.Y][this.Z] = 0;
        this.aL = this.Y * 5;
        while (this.aL < (this.Y + 1) * 5) {
            this.aM = this.Z * 5;
            while (this.aM < (this.Z + 1) * 5) {
                if (this.b[this.aL][this.aM] == 0) {
                    short[] sArray = this.a[this.Y];
                    byte by = this.Z;
                    sArray[by] = (short)(sArray[by] + b.as[this.c[this.aL][this.aM] / 4]);
                    short[] sArray2 = this.a[this.Y];
                    byte by2 = this.Z;
                    sArray2[by2] = (short)(sArray2[by2] + b.at[this.c[this.aL][this.aM] % 4]);
                } else if (this.b[this.aL][this.aM] < 0 && this.b[this.aL][this.aM] > -15) {
                    short[] sArray = this.a[this.Y];
                    byte by = this.Z;
                    sArray[by] = (short)(sArray[by] + this.aI[this.h[90] + -1 - this.b[this.aL][this.aM]]);
                }
                ++this.aM;
            }
            ++this.aL;
        }
        short[] sArray = this.a[this.Y];
        byte by = this.Z;
        sArray[by] = (short)(sArray[by] / 3);
    }

    final void cI() {
        if (this.o != 23) {
            this.f[this.o] = (byte)(this.aA[this.o] / b.au[0] - this.al[this.o]);
            if (this.f[this.o] > 0) {
                int n = this.o;
                this.f[n] = (short)(this.f[n] * 10);
                return;
            }
            int n = this.o;
            this.f[n] = (short)(this.f[n] * 25);
            return;
        }
        this.g[5] = (byte)(9 - this.aE[5]);
        if (this.g[5] > 0) {
            this.g[5] = (short)(this.g[5] * 10);
            return;
        }
        this.g[5] = (short)(this.g[5] * 25);
    }

    final void cJ() {
        if (this.aI[this.h[57] + this.o] < 0) {
            return;
        }
        this.g[this.aI[this.h[57] + this.o]] = 0;
        this.bb = 0;
        while (this.bb < this.ad) {
            byte by = this.aI[this.h[57] + this.o];
            this.g[by] = (short)(this.g[by] + this.aI[this.h[29] + this.o * (this.ad + 1) + this.bb] / b.au[this.bb]);
            this.bb = (byte)(this.bb + 1);
        }
        byte by = this.aI[this.h[57] + this.o];
        this.g[by] = (short)(this.g[by] - this.aE[this.aI[this.h[57] + this.o]]);
        if (this.g[this.aI[this.h[57] + this.o]] > 0) {
            byte by2 = this.aI[this.h[57] + this.o];
            this.g[by2] = (short)(this.g[by2] * 10);
            return;
        }
        byte by3 = this.aI[this.h[57] + this.o];
        this.g[by3] = (short)(this.g[by3] * 25);
    }

    protected final void keyPressed(int n) {
        if (this.n != 0 || !this.c) {
            return;
        }
        try {
            if (n == -6 || n == 6 || n == 42) {
                this.n = -6;
            } else if (n == -7 || n == 7 || n == 35) {
                this.n = -7;
            } else if (n == 48) {
                this.n = 48;
            } else if (n == 55) {
                this.a = !this.a;
            } else {
                this.p = this.getGameAction(n);
                if (this.p == 8 || n == 53) {
                    this.n = 5;
                } else if (this.p == 1 || n == 50) {
                    this.n = 1;
                } else if (this.p == 6 || n == 56) {
                    this.n = 2;
                } else if (this.p == 2 || n == 52) {
                    this.n = 4;
                } else if (this.p == 5 || n == 54) {
                    this.n = 3;
                }
            }
            this.q = false;
            this.aN = 0;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    protected final void keyReleased(int n) {
        try {
            this.q = true;
            if (this.aN > 0) {
                this.n = 0;
            }
            this.aN = 0;
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void cK() {
        this.aO = 0;
        while (this.aO < 90) {
            if (this.ak[this.aO] >= 0) {
                int n = this.aO;
                this.ak[n] = (byte)(this.ak[n] + 1);
                if (this.ak[this.aO] > 100) {
                    this.ak[this.aO] = 0;
                }
            }
            ++this.aO;
        }
    }

    final void cL() {
        try {
            this.aO = 0;
            while (this.aO < 42) {
                if (this.l[0][this.aO] >= 0) {
                    this.cM();
                    this.cO();
                    if (this.ag[this.aO] == 0 && this.Z[this.aO] != 22) {
                        int n = this.aO;
                        this.af[n] = (byte)(this.af[n] + 1);
                        if (this.ai[this.aO] == 2 && this.ac[this.aO] == 0) {
                            this.aP = 200;
                            while (this.aP < 222) {
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
                                ++this.aP;
                            }
                        } else if (this.ad[this.aO] > 0 && this.Z[this.aO] != 14 || this.Z[this.aO] == 14 && this.ad[this.aO] + this.ac[this.aO] > 1) {
                            this.cP();
                            this.af[this.aO] = 0;
                            this.ag[this.aO] = 1;
                        } else if (this.ac[this.aO] > 0 && this.af[this.aO] >= this.aw[this.Z[this.aO]]) {
                            this.af[this.aO] = 0;
                            this.ag[this.aO] = 3;
                            if (!this.b[this.aO]) {
                                this.aj[this.aO] = 0;
                            }
                        }
                        if (this.Z[this.aO] == 14 && this.af[this.aO] % 100 == 0 && this.ad[this.aO] == 1) {
                            this.ax = (byte)this.aO;
                            this.d(false);
                        }
                    }
                    this.cN();
                }
                ++this.aO;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    final void cM() {
        if (this.ag[this.aO] != 1 && this.ag[this.aO] != 2) return;
        int n = this.aO;
        this.af[n] = (byte)(this.af[n] + 1);
        if (this.af[this.aO] != 5) return;
        if (this.ag[this.aO] == 1) {
            this.aB = this.e[this.aO][this.ac[this.aO] - 1];
            this.dq();
            this.d[this.aB] = this.c[this.B[this.aB]][this.C[this.aB]];
            this.c[this.B[this.aB]][this.C[this.aB]] = (short)this.aB;
            if (this.ac[this.aO] == this.au[this.Z[this.aO]]) {
                this.af[this.aO] = 0;
                this.ag[this.aO] = 3;
                if (this.b[this.aO]) return;
                this.aj[this.aO] = 0;
                return;
            }
            this.ag[this.aO] = 0;
            return;
        }
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

    final void cN() {
        if (this.ag[this.aO] == 3) {
            int n = this.aO;
            this.af[n] = (byte)(this.af[n] + 1);
            int n2 = this.aO;
            this.ab[n2] = (byte)(this.ab[n2] + 1);
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
                this.aP = 0;
                while (this.aP < this.ac[this.aO]) {
                    this.c[this.e[this.aO][this.aP]] = this.ab[this.aO];
                    if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 2] == 1) {
                        this.G[this.e[this.aO][this.aP]] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][21] + this.ab[this.aO] % this.at[this.Z[this.aO]] * this.au[this.Z[this.aO]] + (this.ab[this.aO] / this.at[this.Z[this.aO]] + this.aP) % this.au[this.Z[this.aO]]];
                    }
                    if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 3] == 1) {
                        this.H[this.e[this.aO][this.aP]] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][22] + this.ab[this.aO] % this.at[this.Z[this.aO]] * this.au[this.Z[this.aO]] + (this.ab[this.aO] / this.at[this.Z[this.aO]] + this.aP) % this.au[this.Z[this.aO]]];
                    }
                    if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 4] == 1) {
                        this.F[this.e[this.aO][this.aP]] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][23] + this.ab[this.aO] % this.at[this.Z[this.aO]] * this.au[this.Z[this.aO]] + (this.ab[this.aO] / this.at[this.Z[this.aO]] + this.aP) % this.au[this.Z[this.aO]]];
                    }
                    if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 5] == 1) {
                        this.J[this.e[this.aO][this.aP]] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][24] + this.ab[this.aO] % this.at[this.Z[this.aO]] * this.au[this.Z[this.aO]] + this.aP];
                    }
                    if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][3] + 2] == 0 && this.ag[this.aO] == 3 && (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + this.ab[this.aO] % this.at[this.Z[this.aO]] * 2] != 0 || this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + this.ab[this.aO] % this.at[this.Z[this.aO]] * 2 + 1] != 0)) {
                        this.aB = this.e[this.aO][this.aP];
                        this.dq();
                        int n3 = this.aB;
                        this.B[n3] = (byte)(this.B[n3] + this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + this.ab[this.aO] % this.at[this.Z[this.aO]] * 2]);
                        int n4 = this.aB;
                        this.C[n4] = (byte)(this.C[n4] + this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + this.ab[this.aO] % this.at[this.Z[this.aO]] * 2 + 1]);
                        this.d[this.aB] = this.c[this.B[this.aB]][this.C[this.aB]];
                        this.c[this.B[this.aB]][this.C[this.aB]] = (short)this.aB;
                    }
                    ++this.aP;
                }
            }
        }
    }

    final void cO() {
        if (this.ag[this.aO] == 4) {
            int n = this.aO;
            this.af[n] = (byte)(this.af[n] + 1);
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
        this.aR = 1;
        while (this.aR < this.ad[this.aO]) {
            this.W[this.f[this.aO][this.aR]] = 9;
            ++this.aR;
        }
        this.aB = this.e[this.aO][this.ac[this.aO]];
        this.dq();
        this.B[this.aB] = (byte)(this.m[0][this.aO] + this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35]]);
        this.C[this.aB] = (byte)(this.m[1][this.aO] + this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][35] + 1]);
        if (this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][4]] == 1) {
            this.G[this.aB] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][21] + this.ac[this.aO]];
            this.H[this.aB] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][22] + this.ac[this.aO]];
            this.F[this.aB] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][23] + this.ac[this.aO]];
            this.J[this.aB] = this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][2] + 5] == 1 ? this.o[this.Z[this.aO]][this.g[this.Z[this.aO]][24] + this.ac[this.aO]] : (byte)0;
        }
        int n = this.aO;
        this.ac[n] = (byte)(this.ac[n] + 1);
        this.ad[this.aO] = 0;
    }

    final void cQ() {
        this.P[this.f[this.aO][0]] = this.a(this.P[this.f[this.aO][0]] + this.f[this.Z[this.aO]]);
        this.aT[0] = this.B[this.f[this.aO][0]];
        this.aT[1] = this.C[this.f[this.aO][0]];
        this.h = (short)((this.G[this.f[this.aO][0]] + this.H[this.f[this.aO][0]]) / b.Y[0] - this.aI[this.h[2] + this.A[this.f[this.aO][0]] * 12 + this.K[this.J[this.f[this.aO][0]]]] / 2);
        this.i = (short)(b.B[1] / 2 + (this.G[this.f[this.aO][0]] - this.H[this.f[this.aO][0]]) / b.Y[1] - this.aI[this.h[20] + this.A[this.f[this.aO][0]] * 4] - 15);
        this.k += this.b[this.f[this.aO][0]];
        this.d += this.b[this.f[this.aO][0]];
        short s = this.f[this.aO][0];
        this.L[s] = (byte)(this.L[s] - this.b[this.f[this.aO][0]]);
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
        int n = this.aO;
        this.ac[n] = (byte)(this.ac[n] - 1);
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
        if (this.aA[this.Z[this.aO]] >= 30 && (this.a.nextInt() & 0xFFFF) % 100 < this.aA[this.Z[this.aO]]) {
            this.O[this.aB] = 0;
        }
        int n2 = this.aO;
        this.ah[n2] = (byte)(this.ah[n2] - (this.a.nextInt() & 0xFFFF) % this.ay[this.Z[this.aO]] / (20 - 7 * this.M));
    }

    final void cS() {
        this.aU = 5 + (this.c[1][d.k[4] + 1] - 6 - this.M) * (this.b * (2 + this.M) / 3) + this.aD[24] * 15 / this.al;
        if (this.ai > 0 && this.a > 0 && this.a > this.ai * 5) {
            this.aU /= this.a / (this.ai * 5);
        }
        if (this.aU < 3) {
            this.aU = 3;
        }
        if (this.aU > 80) {
            this.aU = 80;
        }
        if ((this.a.nextInt() & 0xFFF) % 100 >= this.aU) {
            return;
        }
        this.aO = 0;
        while (this.aO < 200) {
            if (this.B[this.aO] < 0) {
                this.A[this.aO] = (byte)((this.a.nextInt() & 0xFFF) % 8);
                this.B[this.aO] = this.ab;
                this.C[this.aO] = 0;
                this.D[this.aO] = this.ab;
                this.E[this.aO] = 1;
                this.F[this.aO] = 3;
                this.G[this.aO] = this.aI[this.h[36] + this.F[this.aO] * 2];
                this.H[this.aO] = -100;
                this.I[this.aO] = (byte)((this.a.nextInt() & 0xFFF) % 4 + 1);
                this.J[this.aO] = 1;
                this.W[this.aO] = -1;
                this.L[this.aO] = (byte)(60 + (this.a.nextInt() & 0xFFFF) % 40 - 20);
                this.b[this.aO] = 0;
                this.R[this.aO] = (byte)((this.a.nextInt() & 0xFFFF) % 60);
                this.Q[this.aO] = (byte)((this.a.nextInt() & 0xFFFF) % 60);
                this.P[this.aO] = (byte)(100 - (this.a.nextInt() & 0xFFFF) % 20);
                this.S[this.aO] = (byte)((this.a.nextInt() & 0xFFFF) % 20);
                this.T[this.aO] = (byte)((this.a.nextInt() & 0xFFFF) % 60);
                this.U[this.aO] = (byte)(100 - (this.a.nextInt() & 0xFFFF) % 20);
                this.V[this.aO] = (byte)((this.a.nextInt() & 0xFFFF) % 20);
                this.M[this.aO] = -1;
                this.N[this.aO] = -1;
                this.O[this.aO] = -1;
                this.c[this.aO] = 0;
                this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
                this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
                this.f[0][this.aO] = -1;
                this.f[1][this.aO] = -1;
                this.f[2][this.aO] = 0;
                this.a = (short)(this.a + 1);
                ++this.f;
                return;
            }
            ++this.aO;
        }
    }

    final void cT() {
        this.aB = this.aO;
        this.dq();
        this.B[this.aO] = -1;
        this.a = (short)(this.a - 1);
    }

    final void cU() {
        try {
            this.aO = 0;
            while (this.aO < 222) {
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
                            byte by = this.c[this.B[this.aO]][this.C[this.aO]];
                            this.ac[by] = (byte)(this.ac[by] - 1);
                        } else {
                            this.dk();
                            this.dl();
                            this.dm();
                        }
                    }
                }
                ++this.aO;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void cV() {
        if (this.W[this.aO] != 13) {
            int n = this.aO;
            this.c[n] = (short)(this.c[n] + 1);
        }
        if (this.aO < 200) {
            if (this.O[this.aO] >= 0) {
                int n = this.aO;
                this.O[n] = (byte)(this.O[n] + 1);
            }
            if (this.O[this.aO] >= this.v) {
                this.O[this.aO] = -1;
            }
        }
        if (this.aO < 200 && this.W[this.aO] != 13 && this.W[this.aO] != 18) {
            this.aP = 0;
            while (this.aP < this.ae) {
                this.aS = this.b[this.M][this.aP];
                if (this.aP == 0) {
                    this.aS += this.a[this.B[this.aO] / 5][this.C[this.aO] / 5];
                }
                if (this.c[this.aO] % this.aS == 0) {
                    if (b.ar[this.aP] == 0 && this.g[this.aP][this.aO] > 0) {
                        byte[] byArray = this.g[this.aP];
                        int n = this.aO;
                        byArray[n] = (byte)(byArray[n] - 1);
                    }
                    if (b.ar[this.aP] == 1 && this.g[this.aP][this.aO] < 100) {
                        byte[] byArray = this.g[this.aP];
                        int n = this.aO;
                        byArray[n] = (byte)(byArray[n] + 1);
                    }
                }
                ++this.aP;
            }
            if (this.c[this.aO] % this.q == 0) {
                this.e(true);
            }
        }
    }

    final void cW() {
        if (this.W[this.aO] < 7) {
            this.dd();
            return;
        }
        if (this.W[this.aO] == 7 || this.W[this.aO] == 8) {
            int n = this.aO;
            this.G[n] = (byte)(this.G[n] + this.aI[this.h[31] + this.X[this.aO] * 2] * this.I[this.aO]);
            int n2 = this.aO;
            this.H[n2] = (byte)(this.H[n2] + this.aI[this.h[31] + this.X[this.aO] * 2 + 1] * this.I[this.aO]);
            int n3 = this.aO;
            this.J[n3] = (byte)(this.J[n3] + 1);
            if (this.J[this.aO] > 3) {
                this.J[this.aO] = 0;
            }
            if (this.W[this.aO] == 7) {
                this.de();
                return;
            }
            if (this.W[this.aO] == 8) {
                this.aP = (this.H[this.aO] - this.aI[this.h[35] + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1]) * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]];
                if (this.aP >= 0) {
                    this.H[this.aO] = this.aI[this.h[35] + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1];
                    this.X[this.aO] = this.aI[this.h[35] + this.h[1][this.aO] * 4 + 3];
                    int n4 = this.aO;
                    this.H[n4] = (byte)(this.H[n4] + this.aP * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]]);
                    byte[] byArray = this.h[1];
                    int n5 = this.aO;
                    byArray[n5] = (byte)(byArray[n5] + 1);
                    if (this.h[1][this.aO] == 4) {
                        this.db();
                        return;
                    }
                }
                this.dc();
            }
        }
    }

    final void cX() {
        if (this.aP >= 0) {
            this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] = this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]] + this.aT * 16 + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1];
            this.X[this.aO] = this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]] + this.aT * 16 + this.h[1][this.aO] * 4 + 3];
            byte[] byArray = this.e[this.aI[this.h[104] + this.X[this.aO]]];
            int n = this.aO;
            byArray[n] = (byte)(byArray[n] + this.aP * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]]);
            byte[] byArray2 = this.h[1];
            int n2 = this.aO;
            byArray2[n2] = (byte)(byArray2[n2] + 1);
            if (this.h[0][this.aO] == 0 && this.h[1][this.aO] == this.r[this.h[2][this.aO]][this.aT] + this.aI[this.h[102] + this.W[this.aO]]) {
                this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] = this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]] + this.aT * 16 + (this.h[1][this.aO] - 1) * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1];
                this.h[1][this.aO] = 0;
                byte[] byArray3 = this.h[0];
                int n3 = this.aO;
                byArray3[n3] = (byte)(byArray3[n3] + 1);
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
        if (this.W[this.aO] == 6 && this.e[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]]) {
            this.X[this.aO] = this.aI[this.h[30] + this.X[this.aO] * 4 + 2];
            this.h[1][this.aO] = 0;
            byte[] byArray = this.h[0];
            int n = this.aO;
            byArray[n] = (byte)(byArray[n] + 1);
        } else if (this.W[this.aO] == 4 || this.W[this.aO] == 6) {
            this.e[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]] = true;
        }
        if (this.W[this.aO] == 4) {
            this.d[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]] = false;
        }
        if (this.W[this.aO] == 1) {
            this.aS = this.c[this.B[this.aO]][this.C[this.aO]];
            this.aT = 0;
            do {
                if (this.G[this.aS] == this.aI[this.h[11] + this.h[2][this.aO] * 4] && this.H[this.aS] == this.aI[this.h[11] + this.h[2][this.aO] * 4 + 1] && this.aS != this.aO) {
                    ++this.aT;
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
                this.bd = this.b[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]];
                if (this.W[this.aO] == 4 || this.W[this.aO] == 6) {
                    this.e[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]] = false;
                }
                if (this.W[this.aO] == 4) {
                    this.d[this.c[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4] * 2 + 1]]] = true;
                }
                this.aP = 0;
                while (this.aP < this.ad) {
                    this.g[this.aP][this.aO] = b.ar[this.aP] == 0 ? this.a(this.g[this.aP][this.aO] + this.aI[this.h[29] + (-1 - this.bd) * (this.ad + 1) + this.aP]) : this.a(this.g[this.aP][this.aO] - this.aI[this.h[29] + (-1 - this.bd) * (this.ad + 1) + this.aP]);
                    ++this.aP;
                }
                if (this.W[this.aO] == 5) {
                    this.M[this.aO] = (byte)((this.a.nextInt() & 0xFFFF) % 5);
                }
            }
            this.X[this.aO] = this.aI[this.h[30] + this.X[this.aO] * 4 + 2];
            this.h[1][this.aO] = 0;
            byte[] byArray = this.h[0];
            int n = this.aO;
            byArray[n] = (byte)(byArray[n] + 1);
            if (this.W[this.aO] == 1) {
                int n2 = this.aO;
                this.Q[n2] = (byte)(this.Q[n2] - 50);
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
            int n = this.aO;
            this.L[n] = (byte)(this.L[n] - this.b[this.aO]);
            this.k += this.b[this.aO];
            this.d += this.b[this.aO];
            this.a.delete(0, this.a.length());
            this.a.append("+");
            this.a.append(this.b[this.aO]);
            this.b = this.a.toString();
            this.b[this.aO] = 0;
            this.dM();
            this.P[this.aO] = this.a(this.P[this.aO] + this.g[this.aI[this.h[57] + -1 - this.b[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4 + 2] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.X[this.aO] * 4 + 2] * 2 + 1]]]]);
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
            int n = this.aO;
            this.G[n] = (byte)(this.G[n] - 20 * this.aI[this.h[31] + this.X[this.aO] * 2]);
            int n2 = this.aO;
            this.H[n2] = (byte)(this.H[n2] - 20 * this.aI[this.h[31] + this.X[this.aO] * 2 + 1]);
            this.aB = this.aO;
            this.dq();
            this.B[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.X[this.aO] * 2]);
            this.C[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.X[this.aO] * 2 + 1]);
            this.d[this.aO] = this.c[this.B[this.aO]][this.C[this.aO]];
            this.c[this.B[this.aO]][this.C[this.aO]] = (short)this.aO;
        }
    }

    final void dd() {
        this.aT = this.h[0][this.aO] != 1 ? this.F[this.aO] : 0;
        if (this.h[0][this.aO] != 1) {
            int n = this.aO;
            this.G[n] = (byte)(this.G[n] + this.aI[this.h[31] + this.X[this.aO] * 2] * this.I[this.aO]);
            int n2 = this.aO;
            this.H[n2] = (byte)(this.H[n2] + this.aI[this.h[31] + this.X[this.aO] * 2 + 1] * this.I[this.aO]);
            int n3 = this.aO;
            this.J[n3] = (byte)(this.J[n3] + 1);
            if (this.J[this.aO] > 3) {
                this.J[this.aO] = 0;
            }
            this.aP = (this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] - this.aI[this.h[this.q[this.h[0][this.aO]][this.h[2][this.aO]]] + this.aT * 16 + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1]) * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]];
            this.cX();
            return;
        }
        this.cZ();
        this.da();
    }

    final void de() {
        this.aP = (this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] - this.aI[this.h[this.aK[this.h[2][this.aO]]] + this.F[this.aO] * 12 + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1]) * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]];
        if (this.aP >= 0) {
            this.e[this.aI[this.h[104] + this.X[this.aO]]][this.aO] = this.aI[this.h[this.aK[this.h[2][this.aO]]] + this.F[this.aO] * 12 + this.h[1][this.aO] * 4 + this.aI[this.h[104] + this.X[this.aO]] + 1];
            this.X[this.aO] = this.aI[this.h[this.aK[this.h[2][this.aO]]] + this.F[this.aO] * 12 + this.h[1][this.aO] * 4 + 3];
            byte[] byArray = this.e[this.aI[this.h[104] + this.X[this.aO]]];
            int n = this.aO;
            byArray[n] = (byte)(byArray[n] + this.aP * this.aI[this.h[31] + this.X[this.aO] * 2 + this.aI[this.h[104] + this.X[this.aO]]]);
            byte[] byArray2 = this.h[1];
            int n2 = this.aO;
            byArray2[n2] = (byte)(byArray2[n2] + 1);
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
                        this.aP += (this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] - this.C[this.aO]) * 20 + 10 - this.H[this.aO];
                    }
                } else {
                    this.aP = 19 - this.H[this.aO] - 4;
                    if (this.B[this.aO] != this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] || this.G[this.aO] != 10) {
                        this.aP += (this.B[this.aO] - this.ae[this.c[this.B[this.aO]][this.C[this.aO]]]) * 20 - 10 + this.G[this.aO];
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
                int n = this.aO;
                this.G[n] = (byte)(this.G[n] + this.aI[this.h[31] + this.F[this.aO] * 2] * 2);
                int n2 = this.aO;
                this.H[n2] = (byte)(this.H[n2] + this.aI[this.h[31] + this.F[this.aO] * 2 + 1] * 2);
                return;
            }
            int n = this.aO;
            this.G[n] = (byte)(this.G[n] + this.aI[this.h[31] + this.F[this.aO] * 2] * this.I[this.aO]);
            int n3 = this.aO;
            this.H[n3] = (byte)(this.H[n3] + this.aI[this.h[31] + this.F[this.aO] * 2 + 1] * this.I[this.aO]);
            int n4 = this.aO;
            this.J[n4] = (byte)(this.J[n4] + 1);
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
        if (this.W[this.aO] == -1 || this.W[this.aO] == 18) {
            this.aP = (this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] - this.aI[this.h[12] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]) * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
            if (this.aP >= 0 && this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2] == this.D[this.aO] && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2 + 1] == this.E[this.aO]) {
                this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = this.aI[this.h[12] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
                this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 1];
                byte[] byArray = this.e[this.aI[this.h[104] + this.F[this.aO]]];
                int n = this.aO;
                byArray[n] = (byte)(byArray[n] + this.aP * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]);
            }
            this.aP = (this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] - this.aI[this.h[12] + 8 + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]) * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
            if (this.aP >= 0 && (this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2] == this.D[this.aO] && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2 + 1] == this.E[this.aO] || this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2] == this.D[this.aO] && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2 + 1] == this.E[this.aO] || this.D[this.aO] < 0)) {
                this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = this.aI[this.h[12] + 8 + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
                this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 3];
                byte[] byArray = this.e[this.aI[this.h[104] + this.F[this.aO]]];
                int n = this.aO;
                byArray[n] = (byte)(byArray[n] + this.aP * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]);
                if (this.D[this.aO] < 0) {
                    this.dr();
                    return;
                }
            }
        } else {
            this.aP = (this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] - 10) * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]];
            if (this.aP >= 0) {
                if (this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2] == this.D[this.aO] && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2 + 1] == this.E[this.aO]) {
                    this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = 10;
                    this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 1];
                    byte[] byArray = this.e[this.aI[this.h[104] + this.F[this.aO]]];
                    int n = this.aO;
                    byArray[n] = (byte)(byArray[n] + this.aP * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]);
                }
                if (this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2] == this.D[this.aO] && this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2 + 1] == this.E[this.aO]) {
                    this.e[this.aI[this.h[104] + this.F[this.aO]]][this.aO] = 10;
                    this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 3];
                    byte[] byArray = this.e[this.aI[this.h[104] + this.F[this.aO]]];
                    int n = this.aO;
                    byArray[n] = (byte)(byArray[n] + this.aP * this.aI[this.h[31] + this.F[this.aO] * 2 + this.aI[this.h[104] + this.F[this.aO]]]);
                }
            }
        }
    }

    final void di() {
        if (this.W[this.aO] == 14) {
            this.G[this.aO] = this.o[22][this.g[22][21] + this.F[this.aO] * 11 + this.c[this.aO]];
            this.H[this.aO] = this.o[22][this.g[22][22] + this.F[this.aO] * 11 + this.c[this.aO]];
            int n = this.aO;
            this.J[n] = (byte)(this.J[n] + 1);
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
                    this.k += this.b[this.aO];
                    this.d += this.b[this.aO];
                    int n2 = this.aO;
                    this.L[n2] = (byte)(this.L[n2] - this.b[this.aO]);
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
        this.h = (short)(this.aI[this.h[27] + (this.B[this.aO] - this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]]) * 4 + this.H[this.aO]] - this.aI[this.h[43] + this.A[this.aO]] / 2);
        this.i = (short)(this.aI[this.h[28] + (this.B[this.aO] - this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]]) * 4 + this.H[this.aO]] - this.aI[this.h[44] + this.A[this.aO]] - 15);
        int n = this.aO;
        this.L[n] = (byte)(this.L[n] - this.b[this.aO]);
        this.k += this.b[this.aO];
        this.d += this.b[this.aO];
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
        this.aR = 0;
        while (this.aR < this.au[23]) {
            if (this.e[this.c[this.B[this.aO]][this.C[this.aO]]][this.aR] == this.aO) {
                this.e[this.c[this.B[this.aO]][this.C[this.aO]]][this.aR] = -1;
                return;
            }
            ++this.aR;
        }
    }

    final void dk() {
        if (this.W[this.aO] == 15 || this.W[this.aO] == 16) {
            int n = this.aO;
            this.J[n] = (byte)(this.J[n] + 1);
            if (this.J[this.aO] > 3) {
                this.J[this.aO] = 0;
            }
            if (this.W[this.aO] == 15) {
                byte[] byArray = this.h[0];
                int n2 = this.aO;
                byArray[n2] = (byte)(byArray[n2] + ((this.a.nextInt() & 0xFFFF) % 3 - 1));
                byte[] byArray2 = this.h[1];
                int n3 = this.aO;
                byArray2[n3] = (byte)(byArray2[n3] + ((this.a.nextInt() & 0xFFFF) % 3 - 1));
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
                    this.aO = this.c[this.B[this.aQ]][this.C[this.aQ]];
                    while (this.aO >= 0) {
                        if (this.W[this.aO] == 17) {
                            this.W[this.aO] = -1;
                            this.bk = 1;
                            this.dG();
                            this.dr();
                        }
                        this.aO = this.d[this.aO];
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
            this.aP = this.c[this.B[this.aO]][this.C[this.aO]];
            while (this.aP >= 0) {
                if (this.aP < 200) {
                    if (this.W[this.aP] == 15 || this.W[this.aP] == 16) {
                        this.c[this.aP] = this.r;
                    } else {
                        this.V[this.aP] = 0;
                    }
                }
                this.aP = this.d[this.aP];
            }
        }
        if (this.A[this.aO] == 9 && this.W[this.aO] == -1 && this.b[this.B[this.aO]][this.C[this.aO]] > 3 && this.F[this.aO] > 1 && (this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] == 0 && this.H[this.aO] >= 15 || this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] == 1 && this.G[this.aO] <= 4)) {
            this.J[this.aO] = 0;
            this.W[this.aO] = 17;
            this.ai[this.c[this.B[this.aO]][this.C[this.aO]]] = 2;
        }
    }

    final void dm() {
        if (!(this.W[this.aO] >= 11 && this.W[this.aO] != 18 || this.A[this.aO] == 10 || this.G[this.aO] < 20 && this.H[this.aO] < 20 && this.G[this.aO] >= 0 && this.H[this.aO] >= 0)) {
            if (this.B[this.aO] != this.ab || this.C[this.aO] != 0 || this.H[this.aO] >= 0) {
                if (this.G[this.aO] == 10 || this.H[this.aO] == 10) {
                    if (this.b[this.B[this.aO]][this.C[this.aO]] == 0 && (this.F[this.aO] == 2 && this.b[this.D[this.aO]][this.E[this.aO]] != 5 || this.F[this.aO] == 3 && this.b[this.D[this.aO]][this.E[this.aO]] != 6 || this.f[0][this.aO] != this.Z[this.c[this.D[this.aO]][this.E[this.aO]]])) {
                        this.dx();
                        return;
                    }
                    if (!(this.c[this.c[this.D[this.aO]][this.E[this.aO]]] && this.b[this.c[this.D[this.aO]][this.E[this.aO]]] && this.a[this.c[this.D[this.aO]][this.E[this.aO]]] && this.ah[this.c[this.D[this.aO]][this.E[this.aO]]] >= 10 || this.W[this.aO] != 9)) {
                        this.W[this.aO] = -1;
                        this.dx();
                        return;
                    }
                } else if (this.b[this.B[this.aO]][this.C[this.aO]] == 0 && this.b[this.D[this.aO]][this.E[this.aO]] != 0) {
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
        int n = this.aO;
        this.G[n] = (byte)(this.G[n] - 20 * this.aI[this.h[31] + this.F[this.aO] * 2]);
        int n2 = this.aO;
        this.H[n2] = (byte)(this.H[n2] - 20 * this.aI[this.h[31] + this.F[this.aO] * 2 + 1]);
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
        byte by = this.c[this.B[this.aO]][this.C[this.aO]];
        this.ac[by] = (byte)(this.ac[by] + 1);
        this.aR = 0;
        while (this.aR < this.au[23]) {
            if (this.e[this.c[this.B[this.aO]][this.C[this.aO]]][this.aR] < 0) {
                this.D[this.aO] = (byte)(this.l[0][this.c[this.B[this.aO]][this.C[this.aO]]] + this.aI[this.h[4] + this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] * 6 + this.aR % 3 * 2]);
                this.E[this.aO] = (byte)(this.l[1][this.c[this.B[this.aO]][this.C[this.aO]]] + this.aI[this.h[4] + this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] * 6 + this.aR % 3 * 2 + 1]);
                this.H[this.aO] = this.aI[this.h[87] + this.aR / 3];
                this.e[this.c[this.B[this.aO]][this.C[this.aO]]][this.aR] = (short)this.aO;
                break;
            }
            ++this.aR;
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
            return;
        }
        while (this.aS >= 0) {
            if (this.d[this.aS] == this.aB) {
                this.d[this.aS] = this.d[this.aB];
                return;
            }
            this.aS = this.d[this.aS];
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
            this.aR = 0;
            while (this.aR < 4) {
                this.z[this.aR] = this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2] >= this.O || this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1] >= this.O || this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2] < 0 || this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1] < 0 ? (byte)1 : this.b[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1]];
                ++this.aR;
            }
            if (this.l()) {
                return;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final boolean b() {
        if (this.W[this.aO] == 14 || this.W[this.aO] == -1 && this.b[this.B[this.aO]][this.C[this.aO]] > 3 && this.Z[this.c[this.B[this.aO]][this.C[this.aO]]] == 22) {
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2 + 1]);
            return true;
        }
        if (this.W[this.aO] == 18 && this.B[this.aO] == this.ab && this.C[this.aO] == 0) {
            this.D[this.aO] = this.ab;
            this.E[this.aO] = -1;
            return true;
        }
        return false;
    }

    final boolean c() {
        if (this.W[this.aO] == 10) {
            this.aR = 0;
            while (this.aR < 4) {
                if (this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2] >= this.O || this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1] >= this.O || this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2] < 0 || this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1] < 0) {
                    this.z[this.aR] = 1;
                } else {
                    this.z[this.aR] = this.b[this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1]];
                    if (this.z[this.aR] == 7 && this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] == 1 || this.z[this.aR] == 8 && this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] == 0) {
                        this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2]);
                        this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + this.aR] * 2 + 1]);
                        return true;
                    }
                }
                ++this.aR;
            }
            if (this.z[0] == 13) {
                this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2]);
                this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2 + 1]);
                return true;
            }
            if (this.z[1] == 13) {
                this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2]);
                this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2 + 1]);
                return true;
            }
            if (this.z[3] == 13) {
                this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2]);
                this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 3] * 2 + 1]);
                return true;
            }
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 2] * 2 + 1]);
            return true;
        }
        return false;
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
        }
        if ((this.W[this.aO] == -1 || this.W[this.aO] == 18) && this.b[this.B[this.aO]][this.C[this.aO]] >= 4 && this.b[this.B[this.aO]][this.C[this.aO]] <= 6) {
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] * 2]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aa[this.c[this.B[this.aO]][this.C[this.aO]]] * 2 + 1]);
            return true;
        }
        return false;
    }

    final boolean e() {
        if (this.W[this.aO] != 18) {
            if (this.Q[this.aO] > 50) {
                this.aR = 0;
                while (this.aR < 2) {
                    if (this.b[this.B[this.aO]][this.C[this.aO]] == 0 && (this.c[this.B[this.aO]][this.C[this.aO]] & b.X[this.aR]) != 0) {
                        this.aT = 0;
                        this.aS = this.c[this.B[this.aO]][this.C[this.aO]];
                        while (this.aS >= 0) {
                            if (this.W[this.aS] == 1 && this.h[2][this.aS] == this.aR && this.h[0][this.aS] < 2) {
                                ++this.aT;
                            }
                            this.aS = this.d[this.aS];
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
                    ++this.aR;
                }
            }
            if (this.f()) {
                return true;
            }
        }
        return false;
    }

    final boolean f() {
        this.aT = 0;
        while (this.aT < 2) {
            if (!(this.aT == 0 && this.B[this.aO] == 0 || this.aT == 1 && this.C[this.aO] == this.O - 1)) {
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
                    byte[] byArray = this.f[2];
                    int n = this.aO;
                    byArray[n] = (byte)(byArray[n] + 1);
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
            ++this.aT;
        }
        return false;
    }

    final boolean g() {
        if (this.aI[this.h[163 + this.aT] - 1 - this.bd] == 1 && (this.aI[this.h[55] + -1 - this.bd] >= this.g[this.aI[this.h[54] + -1 - this.bd]][this.aO] && b.ar[this.aI[this.h[54] + -1 - this.bd]] == 0 || this.aI[this.h[55] + -1 - this.bd] <= this.g[this.aI[this.h[54] + -1 - this.bd]][this.aO] && b.ar[this.aI[this.h[54] + -1 - this.bd]] == 1)) {
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
        if (this.bd == 5 + this.aT && this.a[this.be] && this.b[this.be] && this.c[this.be] && this.ah[this.be] >= 10 && (this.Z[this.be] == 23 || this.L[this.aO] >= this.al[this.Z[this.be]])) {
            this.q = this.be;
            if (this.Z[this.be] != 22 && this.Z[this.be] != 23 && this.ad[this.be] < 10) {
                this.dB();
                this.q = (short)((this.a.nextInt() & 0xFFFF) % 100);
                if (this.q < this.p) {
                    this.x = true;
                }
            } else if (this.Z[this.be] == 22 && this.c[this.aZ[0]][this.aZ[1]] == -1) {
                this.dB();
                this.q = (short)((this.a.nextInt() & 0xFFFF) % 100);
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
            } else if (this.Z[this.be] == 23 && this.ac[this.be] < this.au[23] && (this.Q[this.aO] > 50 || this.R[this.aO] > 50 || this.T[this.aO] > 50) && this.L[this.aO] >= this.aE[this.aI[this.h[57] + 27 + 1]]) {
                this.b[this.aO] = this.aE[this.aI[this.h[57] + 27 + 1]];
                this.x = true;
            }
        }
        return false;
    }

    final boolean i() {
        this.aT = 0;
        this.aR = 0;
        while (this.aR < 4) {
            if (this.B[this.aO] + this.aI[this.h[31] + this.aR * 2] >= this.O || this.C[this.aO] + this.aI[this.h[31] + this.aR * 2 + 1] >= this.O || this.B[this.aO] + this.aI[this.h[31] + this.aR * 2] < 0 || this.C[this.aO] + this.aI[this.h[31] + this.aR * 2 + 1] < 0) {
                this.z[this.aR] = 1;
            } else {
                this.z[this.aR] = this.b[this.B[this.aO] + this.aI[this.h[31] + this.aR * 2]][this.C[this.aO] + this.aI[this.h[31] + this.aR * 2 + 1]];
                if (this.z[this.aR] == 0) {
                    ++this.aT;
                }
            }
            ++this.aR;
        }
        if (this.aT > 2) {
            if (this.W[this.aO] == 18) {
                this.ds();
                this.aR = 0;
                while (this.aR < 4) {
                    if (this.z[this.aI[this.h[32] + this.bc * 4 + this.aR]] == 0 && this.aI[this.h[32] + this.bc * 4 + this.aR] != this.aI[this.h[30] + this.F[this.aO] * 4 + 2]) {
                        this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[32] + this.bc * 4 + this.aR] * 2]);
                        this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[32] + this.bc * 4 + this.aR] * 2 + 1]);
                        return true;
                    }
                    ++this.aR;
                }
            }
            if (this.j()) {
                return true;
            }
        }
        return false;
    }

    final boolean j() {
        this.aR = this.B[this.aO] - 1;
        while (this.aR <= this.B[this.aO] + 1) {
            if (this.aR >= 0) {
                if (this.aR >= this.O) break;
                this.aS = this.C[this.aO] - 1;
                while (this.aS <= this.C[this.aO] + 1) {
                    if (this.aS >= 0) {
                        if (this.aS >= this.O) break;
                        if (this.b[this.aR][this.aS] == -14 && this.Y[this.c[this.aR][this.aS]] > 0) {
                            this.aT = 0;
                            while (this.aT < this.Y[this.c[this.aR][this.aS]]) {
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
                                } else if (this.aI[this.h[55] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]] >= this.g[this.aI[this.h[54] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]][this.aO] && b.ar[this.aI[this.h[54] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]] == 0 || this.aI[this.h[55] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]] <= this.g[this.aI[this.h[54] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]][this.aO] && b.ar[this.aI[this.h[54] + -1 - this.j[this.c[this.aR][this.aS]][this.aT]]] == 1 && this.aI[this.h[53] + this.j[this.c[this.aR][this.aS]][this.aT]] != -2) {
                                    this.x = true;
                                }
                                if (this.x) {
                                    this.ds();
                                    this.aR = 0;
                                    while (this.aR < 4) {
                                        if (this.z[this.aI[this.h[32] + this.bc * 4 + this.aR]] == 0 && this.aI[this.h[32] + this.bc * 4 + this.aR] != this.aI[this.h[30] + this.F[this.aO] * 4 + 2]) {
                                            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[32] + this.bc * 4 + this.aR] * 2]);
                                            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[32] + this.bc * 4 + this.aR] * 2 + 1]);
                                            return true;
                                        }
                                        ++this.aR;
                                    }
                                }
                                ++this.aT;
                            }
                        }
                    }
                    ++this.aS;
                }
            }
            ++this.aR;
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
        }
        this.aT = 0;
        while (this.aT < 2) {
            if (!(this.aT == 0 && this.B[this.aO] == 0 || this.aT == 1 && this.C[this.aO] == this.O - 1)) {
                this.aZ[0] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aT] * 4] * 2]);
                this.aZ[1] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.aT] * 4] * 2 + 1]);
                this.bd = this.b[this.aZ[0]][this.aZ[1]];
                this.be = this.c[this.aZ[0]][this.aZ[1]];
                if (this.bd == 7 + this.aT && this.ah[this.be] <= 50 && this.ai[this.be] == 0) {
                    this.x = true;
                    this.aS = this.c[this.B[this.aO]][this.C[this.aO]];
                    while (this.aS >= 0) {
                        if (this.A[this.aS] == 9 && this.D[this.aS] == this.aZ[0] && this.E[this.aS] == this.aZ[1]) {
                            this.x = false;
                            break;
                        }
                        this.aS = this.d[this.aS];
                    }
                    if (this.x) {
                        this.D[this.aO] = this.aZ[0];
                        this.E[this.aO] = this.aZ[1];
                        return true;
                    }
                }
            }
            ++this.aT;
        }
        return false;
    }

    final boolean l() {
        this.aR = (this.a.nextInt() & 0xFF) % 4;
        if (this.z[0] == 0 && (this.z[1] != 0 && this.z[3] != 0 || this.aR < 2)) {
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4] * 2 + 1]);
            return true;
        }
        this.aR = (this.a.nextInt() & 0xFF) % 4;
        if (this.z[1] == 0 && (this.z[3] != 0 || this.aR < 2)) {
            this.D[this.aO] = (byte)(this.B[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2]);
            this.E[this.aO] = (byte)(this.C[this.aO] + this.aI[this.h[31] + this.aI[this.h[30] + this.F[this.aO] * 4 + 1] * 2 + 1]);
            return true;
        }
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
            this.bc = (byte)(this.bc + 1);
        }
        if ((this.a.nextInt() & 0xFF) % 4 == 0) {
            this.bc = (byte)((this.bc + (this.a.nextInt() & 0xF)) % 8);
        }
    }

    final void dt() {
        if (this.ad[this.c[this.B[this.aO]][this.C[this.aO]]] >= 10) {
            this.du();
            return;
        }
        if (!(this.c[this.c[this.B[this.aO]][this.C[this.aO]]] && this.b[this.c[this.B[this.aO]][this.C[this.aO]]] && this.a[this.c[this.B[this.aO]][this.C[this.aO]]] && this.ah[this.c[this.B[this.aO]][this.C[this.aO]]] >= 10)) {
            this.W[this.aO] = -1;
            this.dx();
            return;
        }
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
        byte by = this.c[this.B[this.aO]][this.C[this.aO]];
        this.ad[by] = (byte)(this.ad[by] + 1);
        if (this.Z[this.c[this.B[this.aO]][this.C[this.aO]]] == 14) {
            this.af[this.c[this.B[this.aO]][this.C[this.aO]]] = 0;
        }
        this.J[this.aO] = 0;
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
                return;
            }
            this.aP -= 6;
            this.G[this.aO] = 10;
            this.H[this.aO] = (byte)(10 - this.aP);
            this.F[this.aO] = 3;
            return;
        }
        this.aP -= 16;
        this.G[this.aO] = 10;
        this.H[this.aO] = (byte)((40 - this.aP) % 20);
        this.C[this.aO] = (byte)(this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] - 1 - (this.aP - 1) / 20);
        this.D[this.aO] = this.B[this.aO];
        this.E[this.aO] = (byte)(this.C[this.aO] + 1);
        this.F[this.aO] = 3;
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
                return;
            }
            this.aP -= 5;
            this.G[this.aO] = (byte)(10 + this.aP);
            this.H[this.aO] = 10;
            this.F[this.aO] = 2;
            return;
        }
        this.aP -= 15;
        this.G[this.aO] = (byte)(this.aP % 20);
        this.H[this.aO] = 10;
        this.B[this.aO] = (byte)(this.ae[this.c[this.B[this.aO]][this.C[this.aO]]] + 1 + this.aP / 20);
        this.D[this.aO] = (byte)(this.B[this.aO] - 1);
        this.E[this.aO] = this.C[this.aO];
        this.F[this.aO] = 2;
    }

    final void d(boolean bl) {
        this.aX = this.aO;
        this.aY = 0;
        while (this.aY < this.ad[this.ax]) {
            this.aO = this.f[this.ax][this.aY];
            this.F[this.aO] = this.aI[this.h[30] + this.F[this.aO] * 4 + 2];
            this.e[this.aI[this.h[105] + this.F[this.aO]]][this.aO] = this.aI[this.h[36] + this.F[this.aO] * 2 + this.aI[this.h[105] + this.F[this.aO]]];
            this.W[this.aO] = -1;
            if (bl) {
                this.P[this.aO] = this.a(this.P[this.aO] - b.ap[3]);
            }
            this.dr();
            ++this.aY;
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
        this.aR = 0;
        while (this.aR < 30) {
            this.Y[this.aR] = 0;
            if (this.i[this.aR][0] >= 0) {
                this.aS = this.i[this.aR][0] - 6;
                while (this.aS <= this.i[this.aR][0] + 6) {
                    if (this.aS >= 0) {
                        if (this.aS >= this.O) break;
                        this.aT = this.i[this.aR][1] - 6;
                        while (this.aT <= this.i[this.aR][1] + 6) {
                            if (this.aT >= 0) {
                                if (this.aT >= this.O) break;
                                this.bf = 0;
                                while (this.bf < 2 && this.Y[this.aR] < 20) {
                                    this.bg = 0;
                                    if (this.b[this.aS][this.aT] <= -15 && this.b[this.aS][this.aT] >= -27 && this.aI[this.h[163 + this.bf] - 1 - this.b[this.aS][this.aT]] == 1) {
                                        this.j[this.aR][this.Y[this.aR]] = this.b[this.aS][this.aT];
                                        this.bg = 1;
                                    }
                                    if (this.b[this.aS][this.aT] == 5 + this.bf) {
                                        this.j[this.aR][this.Y[this.aR]] = this.Z[this.c[this.aS][this.aT]];
                                        this.bg = 1;
                                    }
                                    if (this.bg == 1) {
                                        this.a[this.aR][this.Y[this.aR]][0] = (byte)(this.aS + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.bf] * 4 + 2] * 2]);
                                        this.a[this.aR][this.Y[this.aR]][1] = (byte)(this.aT + this.aI[this.h[31] + this.aI[this.h[30] + this.aI[this.h[103] + this.bf] * 4 + 2] * 2 + 1]);
                                        int n = this.aR;
                                        this.Y[n] = (byte)(this.Y[n] + 1);
                                    }
                                    this.bf = (byte)(this.bf + 1);
                                }
                            }
                            ++this.aT;
                        }
                    }
                    ++this.aS;
                }
            }
            ++this.aR;
        }
    }

    final void dz() {
        this.aZ = this.P[this.aO] < 50 ? (this.a.nextInt() & 0xFFFF) % (this.c[1][d.k[4] + 1] * 40) : 1000;
        if (this.L[this.aO] < 4 || this.Q[this.aO] >= 96 || this.R[this.aO] >= 100 || 60 + 10 * this.M - this.P[this.aO] > this.aZ) {
            this.W[this.aO] = 18;
        }
    }

    final void dA() {
        this.p = (short)100;
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

    final void e(boolean bl) {
        if (this.W[this.aO] == 15 || this.W[this.aO] == 16) {
            return;
        }
        this.N[this.aO] = -1;
        this.bi = 0;
        while (this.bi < 10) {
            if (this.aI[this.h[95] + this.bi] == this.ad + 3) {
                if (this.c[this.aO] >= b.b[this.bi]) {
                    this.N[this.aO] = this.bi;
                }
            } else if (this.g[this.aI[this.h[95] + this.bi]][this.aO] <= b.b[this.bi] && this.aI[this.h[97] + this.bi] == 0 || this.g[this.aI[this.h[95] + this.bi]][this.aO] >= b.b[this.bi] && this.aI[this.h[97] + this.bi] == 1) {
                this.N[this.aO] = this.bi;
            }
            if (this.N[this.aO] >= 0 && bl && (this.a.nextInt() & 0xFFFF) % 25 > 0) {
                this.N[this.aO] = -1;
            }
            if (this.N[this.aO] >= 0) {
                return;
            }
            this.bi = (byte)(this.bi + 1);
        }
    }

    final void dC() {
        if (this.aO >= 200) {
            return;
        }
        this.ba = this.d[this.aO];
        while (this.ba != -1) {
            if (this.W[this.ba] == 15 || this.W[this.ba] == 16) {
                this.J[this.aO] = 0;
                this.W[this.aO] = 17;
                return;
            }
            this.ba = this.d[this.ba];
        }
        if (this.W[this.aO] != -1) {
            return;
        }
        this.ba = this.d[this.aO];
        while (this.ba != -1) {
            if (this.W[this.ba] == -1 && this.ba < 200 && this.V[this.aO] >= this.af && this.V[this.ba] >= this.af && (this.a.nextInt() & 0xFFFF) % this.b < this.V[this.aO] + this.V[this.ba]) {
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
            this.ba = this.d[this.ba];
        }
    }

    final void dD() {
        if (!this.j[this.bj]) {
            this.f = 0;
            this.aC = 1;
            this.aB = this.aA = (byte)(this.aE + this.bj);
            this.dI();
            this.j[this.bj] = true;
        }
    }

    final void dE() {
        if (this.M[this.bc] < 0) {
            return;
        }
        this.bb = 0;
        while (this.bb < this.aH) {
            if (this.x[this.bb][0] < 0) {
                this.x[this.bb][0] = this.B[this.bc];
                this.x[this.bb][1] = this.C[this.bc];
                this.aR[this.bb] = (byte)((this.G[this.bc] + this.H[this.bc]) / b.Y[0] - this.aI[this.h[73] + this.M[this.bc] + 13] / 2);
                this.aQ[this.bb] = (byte)(b.B[1] / 2 + (this.G[this.bc] - this.H[this.bc]) / b.Y[1] - this.aI[this.h[20] + this.A[this.bc] * 4 + this.F[this.bc]] - this.aI[this.h[74] + this.M[this.bc] + 13]);
                this.aS[this.bb] = (byte)(this.M[this.bc] + 13);
                this.M[this.bc] = -1;
                return;
            }
            ++this.bb;
        }
    }

    final void dF() {
        this.bb = 0;
        while (this.bb < this.aH) {
            if (this.x[this.bb][0] >= 0) {
                if (this.aQ[this.bb] < this.aI) {
                    this.x[this.bb][0] = -1;
                } else {
                    int n = this.bb;
                    this.aR[n] = (byte)(this.aR[n] + ((this.a.nextInt() & 0xFFFF) % 3 - 1));
                    int n2 = this.bb;
                    this.aQ[n2] = (byte)(this.aQ[n2] - 2);
                }
            }
            ++this.bb;
        }
    }

    final void dG() {
        this.aP = 0;
        while (this.aP < this.ae) {
            if (b.ar[this.aP] == 0) {
                this.g[this.aP][this.aO] = this.a(this.g[this.aP][this.aO] - this.aI[this.h[33] + this.bk * this.ae + this.aP]);
            }
            if (b.ar[this.aP] == 1) {
                this.g[this.aP][this.aO] = this.a(this.g[this.aP][this.aO] + this.aI[this.h[33] + this.bk * this.ae + this.aP]);
            }
            ++this.aP;
        }
    }

    final byte a(int n) {
        if (n >= 100) {
            return 100;
        }
        if (n <= 0) {
            return 0;
        }
        return (byte)n;
    }

    final void dH() {
        this.s = 0;
        while (this.s < 3) {
            this.a = null;
            try {
                this.a = this.getClass().getResourceAsStream(this.b[this.s] + this.P);
                if (this.a != null) {
                    this.r = 0;
                    this.i[this.s][0] = 0;
                    this.q = 0;
                    while ((this.D = this.a.read()) != -1) {
                        if (this.D == 124) {
                            ++this.r;
                            this.i[this.s][this.r] = (short)this.q;
                            --this.q;
                        } else if (this.D == 38) {
                            this.s[this.s][this.q] = 100;
                        } else if (this.D < 10) {
                            this.s[this.s][this.q] = (byte)(101 + this.D);
                        } else if (this.D == 31) {
                            try {
                                this.b = this.a.getAppProperty("MIDlet-Version");
                            }
                            catch (Exception exception) {
                                this.b = "1.0.0";
                            }
                            this.t = 0;
                            while (this.t < this.b.length()) {
                                this.D = this.b.charAt(this.t);
                                this.dK();
                                this.s[this.s][this.q] = (byte)this.E;
                                ++this.q;
                                ++this.t;
                            }
                            --this.q;
                        } else {
                            this.dK();
                            this.s[this.s][this.q] = (byte)this.E;
                        }
                        ++this.q;
                    }
                }
                this.a.close();
                this.a = null;
            }
            catch (IOException iOException) {}
            System.gc();
            ++this.s;
        }
    }

    final void dI() {
        this.be = 0;
        this.G = 0;
        this.l[0] = this.i[this.aC][this.aA];
        this.bf = 0;
        this.dJ();
        if (this.i[this.aC][this.aA] < this.i[this.aC][this.aA + 1]) {
            ++this.G;
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
                if (this.G < d.j[1] || this.aA < 30) {
                    this.H = d.B[this.aC] - (this.G - 1) * 20;
                    return;
                }
                this.H = d.B[this.aC] - (d.j[1] - 1) * 20;
                return;
            }
            this.H = d.B[this.aC];
        }
    }

    final void dJ() {
        this.bd = this.i[this.aC][this.aA];
        while (this.bd < this.i[this.aC][this.aA + 1]) {
            if (this.s[this.aC][this.bd] == 42 || this.s[this.aC][this.bd] == 100) {
                this.be = (short)(this.bd + 1);
                this.bg = this.bf;
            }
            if (this.s[this.aC][this.bd] >= 101) {
                ++this.bf;
                this.bf += this.aI[this.h[73] + this.aI[this.h[96] + this.s[this.aC][this.bd] - 101]];
            }
            if (this.s[this.aC][this.bd] < 100 && (this.s[this.aC][this.bd] / 30 != 0 || this.s[this.aC][this.bd] % 30 < 14)) {
                ++this.bf;
                this.bf += b.a[this.s[this.aC][this.bd] / 30][this.s[this.aC][this.bd] % 30 + 1] - b.a[this.s[this.aC][this.bd] / 30][this.s[this.aC][this.bd] % 30];
            }
            if (this.bf > d.A[this.aC] && this.be > this.l[this.G] || this.s[this.aC][this.bd] == 100) {
                ++this.G;
                this.l[this.G] = (short)this.be;
                this.m[this.G - 1] = (short)this.bg;
                this.bd = (short)(this.be - 1);
                this.bf = 0;
            }
            ++this.bd;
        }
    }

    final void dK() {
        if (this.j == 0) {
            this.u = 0;
            while (this.u < b.c.length) {
                if (this.D == b.c[this.u]) {
                    this.E = 43 + this.u;
                    return;
                }
                ++this.u;
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
            this.u = 0;
            while (this.u < 11) {
                if (this.D == this.aI[this.h[130] + this.u]) {
                    this.E += this.u;
                    return;
                }
                ++this.u;
            }
        } else {
            if (this.D >= 48 && this.D <= 57) {
                this.E = this.D - 48;
            }
            this.u = 0;
            while (this.u < 3) {
                if (this.D == d.a[this.u]) {
                    this.E = 10 + this.u;
                    return;
                }
                ++this.u;
            }
        }
    }

    final void dL() {
        this.d[this.az] = this.i[this.f + 1] - this.i[this.f] - 1;
        this.c[this.az] = this.i[this.f + 1] - this.i[this.f];
        this.f[this.az] = this.h;
        this.e[this.az] = this.i;
        this.bh = 0;
        while (this.bh < this.c[this.az]) {
            this.u[this.az][this.bh] = (byte)(this.aN[this.i[this.f] + this.bh] / 30);
            this.t[this.az][this.bh] = (byte)(this.aN[this.i[this.f] + this.bh] % 30);
            if (this.aN[this.i[this.f] + this.bh] / 30 != 0 || this.aN[this.i[this.f] + this.bh] % 30 < 14) {
                byte by = this.az;
                this.d[by] = this.d[by] + (b.a[this.u[this.az][this.bh]][this.t[this.az][this.bh] + 1] - b.a[this.u[this.az][this.bh]][this.t[this.az][this.bh]]);
            }
            ++this.bh;
        }
        if (this.g == 1) {
            byte by = this.az;
            this.f[by] = this.f[by] - this.d[this.az] / 2;
        }
        if (this.g == 2) {
            byte by = this.az;
            this.f[by] = this.f[by] - this.d[this.az];
        }
        this.g[this.az] = 0;
        this.az = (byte)(this.az + 1);
    }

    final void dM() {
        if (this.aG >= this.aF) {
            return;
        }
        this.bh = 0;
        while (this.bh < this.aF && this.l[this.bh] < this.o) {
            ++this.bh;
        }
        if (this.bh >= this.aF) {
            return;
        }
        this.h[this.bh] = this.b.length();
        this.i[this.bh] = this.h[this.bh] - 1;
        this.k[this.bh] = this.h;
        this.j[this.bh] = this.i;
        this.v[this.bh][0] = this.aT[0];
        this.v[this.bh][1] = this.aT[1];
        this.j = (short)2;
        this.bi = 0;
        while (this.bi < this.h[this.bh]) {
            this.D = this.b.charAt(this.bi);
            this.dK();
            this.w[this.bh][this.bi] = (byte)this.E;
            int n = this.bh;
            this.i[n] = this.i[n] + (b.a[this.w[this.bh][this.bi] + 1] - b.a[this.w[this.bh][this.bi]]);
            ++this.bi;
        }
        this.j = 0;
        int n = this.bh;
        this.k[n] = this.k[n] - this.i[this.bh] / 2;
        this.l[this.bh] = 0;
        this.aG = (byte)(this.aG + 1);
    }

    final void dN() {
        this.c[this.az] = this.b.length();
        this.d[this.az] = this.c[this.az] - 1;
        this.f[this.az] = this.h;
        this.e[this.az] = this.i;
        this.bh = 0;
        while (this.bh < this.c[this.az]) {
            this.D = this.b.charAt(this.bh);
            this.dK();
            this.u[this.az][this.bh] = (byte)(this.E / 30);
            this.t[this.az][this.bh] = (byte)(this.E % 30);
            if (this.j == 0) {
                byte by = this.az;
                this.d[by] = this.d[by] + (b.a[this.u[this.az][this.bh]][this.t[this.az][this.bh] + 1] - b.a[this.u[this.az][this.bh]][this.t[this.az][this.bh]]);
            } else {
                byte by = this.az;
                this.d[by] = this.d[by] + (b.a[this.t[this.az][this.bh] + 1] - b.a[this.t[this.az][this.bh]]);
            }
            ++this.bh;
        }
        if (this.g == 1) {
            byte by = this.az;
            this.f[by] = this.f[by] - this.d[this.az] / 2;
        }
        if (this.g == 2) {
            byte by = this.az;
            this.f[by] = this.f[by] - this.d[this.az];
        }
        this.g[this.az] = this.j;
        this.az = (byte)(this.az + 1);
    }

    final void dO() {
        this.c[this.k] = this.b.length();
        this.d[this.k] = this.c[this.k] - 1;
        this.f[this.k] = this.h;
        this.e[this.k] = this.i;
        this.bh = 0;
        while (this.bh < this.c[this.k]) {
            this.D = this.b.charAt(this.bh);
            this.dK();
            this.u[this.k][this.bh] = (byte)(this.E / 30);
            this.t[this.k][this.bh] = (byte)(this.E % 30);
            if (this.j == 0) {
                short s = this.k;
                this.d[s] = this.d[s] + (b.a[this.u[this.k][this.bh]][this.t[this.k][this.bh] + 1] - b.a[this.u[this.k][this.bh]][this.t[this.k][this.bh]]);
            } else {
                short s = this.k;
                this.d[s] = this.d[s] + (b.a[this.t[this.k][this.bh] + 1] - b.a[this.t[this.k][this.bh]]);
            }
            ++this.bh;
        }
        if (this.g == 1) {
            short s = this.k;
            this.f[s] = this.f[s] - this.d[this.k] / 2;
        }
        if (this.g == 2) {
            short s = this.k;
            this.f[s] = this.f[s] - this.d[this.k];
        }
        this.g[this.k] = this.j;
    }

    final void dP() {
        ++this.a;
        if (this.a >= 100) {
            this.a = 0;
        }
        this.bj = 0;
        while (this.bj < this.az) {
            this.bl = this.f[this.bj];
            this.bp = 0;
            this.bk = 0;
            while (this.bk < this.c[this.bj]) {
                if (this.g[this.bj] == 0) {
                    this.bm = 0;
                    if (this.u[this.bj][this.bk] == 0 && this.t[this.bj][this.bk] >= 14) {
                        this.bo = -1 - (this.bn + b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk] + 1] - b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk]]) / 2;
                        ++this.bp;
                    } else {
                        this.bo = 0;
                    }
                    this.bn = b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk] + 1] - b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk]];
                    this.bq = this.P;
                    if (this.w && this.P > 1) {
                        --this.bq;
                    }
                    if (!(this.R == 26 || this.v[this.R] <= 0 || this.p || this.b != 3 || this.bj - this.aI[this.h[94] + this.R] != this.bq || this.a[this.R][this.P] == 11 || this.a[this.R][this.P] == 12 && this.n)) {
                        this.bm = this.a[(this.bk + this.a - this.bp) % 4];
                    }
                    this.a[this.a].drawRegion(this.d[4], (int)b.a[this.u[this.bj][this.bk]][this.t[this.bj][this.bk]], (int)b.a[this.u[this.bj][this.bk]], this.bn, (int)b.b[this.u[this.bj][this.bk]], 0, this.bl + this.bo, this.e[this.bj] + this.bm, 20);
                    if (this.bo == 0) {
                        this.bl += this.bn + 1;
                    }
                } else {
                    this.a[this.a].drawRegion(this.d[4], (int)b.a[this.t[this.bj][this.bk]], 58, b.a[this.t[this.bj][this.bk] + 1] - b.a[this.t[this.bj][this.bk]], 15, 0, this.bl, this.e[this.bj], 20);
                    this.bl += b.a[this.t[this.bj][this.bk] + 1] - b.a[this.t[this.bj][this.bk]] + 1;
                }
                ++this.bk;
            }
            ++this.bj;
        }
    }

    final void dQ() {
        if (this.aG == 0) {
            return;
        }
        this.bj = 0;
        while (this.bj < this.aF) {
            if (this.l[this.bj] < this.o) {
                this.bl = this.k[this.bj] + (this.v[this.bj][0] + this.v[this.bj][1] - this.f[0][0] - this.f[0][1]) * (b.B[0] / 2) + this.W;
                this.bk = 0;
                while (this.bk < this.h[this.bj]) {
                    this.a[this.a].drawRegion(this.d[4], (int)b.a[this.w[this.bj][this.bk]], 58, b.a[this.w[this.bj][this.bk] + 1] - b.a[this.w[this.bj][this.bk]], 15, 0, this.bl, this.j[this.bj] + (this.v[this.bj][0] - this.v[this.bj][1] - this.f[0][0] + this.f[0][1]) * (b.B[1] / 2) + this.X - 2 * this.l[this.bj], 20);
                    this.bl += b.a[this.w[this.bj][this.bk] + 1] - b.a[this.w[this.bj][this.bk]] + 1;
                    ++this.bk;
                }
            }
            ++this.bj;
        }
    }

    final void dR() {
        this.br = this.aC != 1 || this.aA >= 30 ? d.j[this.aC] : this.G;
        this.bj = this.F;
        while (this.bj < this.F + this.br) {
            if (this.bj >= this.G) {
                return;
            }
            this.bl = (this.l - this.m[this.bj]) / 2;
            this.bk = this.l[this.bj];
            while (this.bk < this.l[this.bj + 1]) {
                if (this.s[this.aC][this.bk] != 100) {
                    if (this.s[this.aC][this.bk] >= 101) {
                        this.bo = this.s[this.aC][this.bk] - 101;
                        this.a[this.a].drawRegion(this.c[2], (int)this.aI[this.h[71] + this.aI[this.h[96] + this.bo]], (int)this.aI[this.h[72] + this.aI[this.h[96] + this.bo]], (int)this.aI[this.h[73] + this.aI[this.h[96] + this.bo]], (int)this.aI[this.h[74] + this.aI[this.h[96] + this.bo]], 0, this.bl, this.H + 20 * (this.bj - this.F) + (b.b[0] - this.aI[this.h[74] + this.aI[this.h[96] + this.bo]]) / 2, 20);
                        this.bl += this.aI[this.h[73] + this.aI[this.h[96] + this.bo]] + 1;
                    } else {
                        this.bo = this.s[this.aC][this.bk] / 30 == 0 && this.s[this.aC][this.bk] % 30 >= 14 ? -1 - (this.bn + b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30 + 1] - b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30]) / 2 : 0;
                        this.bn = b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30 + 1] - b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30];
                        this.a[this.a].drawRegion(this.d[4], (int)b.a[this.s[this.aC][this.bk] / 30][this.s[this.aC][this.bk] % 30], (int)b.a[this.s[this.aC][this.bk] / 30], this.bn, (int)b.b[this.s[this.aC][this.bk] / 30], 0, this.bl + this.bo, this.H + 20 * (this.bj - this.F), 20);
                        if (this.bo == 0) {
                            this.bl += this.bn + 1;
                        }
                    }
                }
                ++this.bk;
            }
            ++this.bj;
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
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void a(boolean[] blArray, byte[] byArray, short[] sArray, int[] nArray, int n, int n2, int n3) {
        try {
            this.bw = 0;
            while (this.bw < n2) {
                this.c <<= n;
                this.by += n;
                if (blArray != null) {
                    if (blArray[this.bw]) {
                        ++this.c;
                    }
                } else if (byArray != null) {
                    this.c += (long)(byArray[this.bw] + n3);
                } else if (sArray != null) {
                    this.c += (long)(sArray[this.bw] + n3);
                } else if (nArray != null) {
                    this.c += (long)(nArray[this.bw] + n3);
                }
                if (this.by >= 32 || this.bw == n2 - 1) {
                    while (this.by >= 8) {
                        this.a.write((int)(this.c >> this.by - 8));
                        this.by -= 8;
                    }
                }
                ++this.bw;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void b(boolean[] blArray, byte[] byArray, short[] sArray, int[] nArray, int n, int n2, int n3) {
        try {
            this.bz = 1;
            this.bw = 0;
            while (this.bw < n) {
                this.bz *= 2;
                ++this.bw;
            }
            --this.bz;
            this.bw = 0;
            while (this.bw < n2) {
                while (this.by < n) {
                    this.c <<= 8;
                    this.c += (long)this.a.read();
                    this.by += 8;
                }
                this.bx = (int)(this.c >> this.by - n & (long)this.bz);
                this.bx -= n3;
                if (blArray != null) {
                    blArray[this.bw] = this.bx > 0;
                } else if (byArray != null) {
                    byArray[this.bw] = (byte)this.bx;
                } else if (sArray != null) {
                    sArray[this.bw] = (short)this.bx;
                } else if (nArray != null) {
                    nArray[this.bw] = this.bx;
                }
                this.by -= n;
                ++this.bw;
            }
            return;
        }
        catch (Exception exception) {
            return;
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
                RecordStore.deleteRecordStore((String)"pssav");
            }
            catch (Exception exception) {}
            this.a = RecordStore.openRecordStore((String)"pssav", (boolean)true);
            try {
                this.a.addRecord(this.a.toByteArray(), 0, this.a.size());
            }
            catch (Exception exception) {}
            this.a.closeRecordStore();
            this.a.close();
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dU() {
        try {
            this.a = RecordStore.openRecordStore((String)"pssav", (boolean)true);
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
            return;
        }
        catch (Exception exception) {
            return;
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
            this.c = this.K == 0 ? "pCuSav" : "pCaSav";
            try {
                RecordStore.deleteRecordStore((String)this.c);
            }
            catch (Exception exception) {}
            this.a = RecordStore.openRecordStore((String)this.c, (boolean)true);
            try {
                this.a.addRecord(this.a.toByteArray(), 0, this.a.size());
                this.y = true;
            }
            catch (Exception exception) {}
            this.a.closeRecordStore();
            this.a.close();
            return;
        }
        catch (Exception exception) {
            return;
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
            this.bs = 0;
            while (this.bs < 3) {
                this.a(null, null, null, this.e[this.bs], 20, 1, 5000);
                ++this.bs;
            }
            this.a(null, null, null, this.c[0], 24, d.k[4] + 2, 5000);
            this.a(null, null, null, this.c[1], 4, d.k[4] + 2, 1);
            this.a(null, null, null, this.c[2], 8, d.k[4] + 2, 1);
            if (this.K == 0) {
                this.bs = 3;
                while (this.bs < 8) {
                    this.a(null, null, null, this.c[this.bs], 10, d.k[4] + 2, 1);
                    ++this.bs;
                }
                this.a(null, this.aW, null, null, 3, 4, 0);
                this.a(null, this.aX, null, null, 2, 4, 0);
            }
            this.bs = 0;
            while (this.bs < 30) {
                this.a(null, this.b[this.bs], null, null, 6, 30, 29);
                this.a(null, this.c[this.bs], null, null, 7, 30, 1);
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dX() {
        try {
            this.a(null, null, null, this.a, 5, 2, 1);
            this.bs = 0;
            while (this.bs < 4) {
                this.a(null, null, null, this.f[this.bs], 7, 2, 25);
                ++this.bs;
            }
            this.bs = 0;
            while (this.bs < 222) {
                if (this.I[this.bs] < 1) {
                    this.I[this.bs] = 1;
                }
                ++this.bs;
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
            this.bs = 0;
            while (this.bs < 3) {
                this.a(null, this.f[this.bs], null, null, 6, 200, 2);
                this.a(null, this.h[this.bs], null, null, 3, 222, 2);
                ++this.bs;
            }
            this.a(null, this.L, null, null, 7, this.L.length, 10);
            this.a(null, null, this.b, null, 4, this.b.length, 1);
            this.a(null, this.M, null, null, 3, this.M.length, 1);
            this.a(null, null, this.e, null, 10, this.e.length, 10);
            this.bs = 0;
            while (this.bs < 30) {
                this.a(null, this.i[this.bs], null, null, 5, 2, 1);
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void dY() {
        try {
            this.bs = 0;
            while (this.bs < 15) {
                this.a(null, this.k[this.bs], null, null, 5, 2, 1);
                ++this.bs;
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
            this.bs = 0;
            while (this.bs < 2) {
                this.a(null, this.l[this.bs], null, null, 5, 42, 1);
                this.a(null, this.m[this.bs], null, null, 5, 42, 1);
                this.a(null, this.n[this.bs], null, null, 5, 42, 1);
                ++this.bs;
            }
            this.a(null, this.ak, null, null, 7, this.ak.length, 10);
            this.a(this.d, null, null, null, 1, this.d.length, 0);
            this.a(this.e, null, null, null, 1, this.e.length, 0);
            this.a(this.f, null, null, null, 1, this.f.length, 0);
            return;
        }
        catch (Exception exception) {
            return;
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
            this.bs = 0;
            while (this.bs < this.ae) {
                this.bu = 0;
                this.bt = 0;
                while (this.bt < 200) {
                    if (this.B[this.bt] >= 0) {
                        this.bu += this.g[this.bs][this.bt];
                    }
                    ++this.bt;
                }
                if (this.a > 0) {
                    this.bu /= this.a;
                }
                this.a.writeInt(this.bu);
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
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
                    this.R = (byte)10;
                    this.w[10] = this.n[this.L];
                    this.cu();
                    return;
                }
                this.L = this.H;
                this.M = this.I;
            }
            this.g();
            this.c = this.K == 0 ? "pCuSav" : "pCaSav";
            this.a = RecordStore.openRecordStore((String)this.c, (boolean)false);
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
            return;
        }
        catch (Exception exception) {
            return;
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
            this.bs = 0;
            while (this.bs < 3) {
                this.b(null, null, null, this.e[this.bs], 20, 1, 5000);
                ++this.bs;
            }
            this.b(null, null, null, this.c[0], 24, d.k[4] + 2, 5000);
            this.b(null, null, null, this.c[1], 4, d.k[4] + 2, 1);
            this.b(null, null, null, this.c[2], 8, d.k[4] + 2, 1);
            if (this.K == 0) {
                this.bs = 3;
                while (this.bs < 8) {
                    this.b(null, null, null, this.c[this.bs], 10, d.k[4] + 2, 1);
                    ++this.bs;
                }
                this.b(null, this.aW, null, null, 3, 4, 0);
                this.b(null, this.aX, null, null, 2, 4, 0);
            }
            this.bs = 0;
            while (this.bs < 30) {
                this.b(null, this.b[this.bs], null, null, 6, 30, 29);
                this.b(null, this.c[this.bs], null, null, 7, 30, 1);
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ec() {
        try {
            this.b(null, null, null, this.a, 5, 2, 1);
            this.bs = 0;
            while (this.bs < 4) {
                this.b(null, null, null, this.f[this.bs], 7, 2, 25);
                ++this.bs;
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
            this.bs = 0;
            while (this.bs < 3) {
                this.b(null, this.f[this.bs], null, null, 6, 200, 2);
                this.b(null, this.h[this.bs], null, null, 3, 222, 2);
                ++this.bs;
            }
            this.b(null, this.L, null, null, 7, this.L.length, 10);
            this.b(null, null, this.b, null, 4, this.b.length, 1);
            this.b(null, this.M, null, null, 3, this.M.length, 1);
            this.b(null, null, this.e, null, 10, this.e.length, 10);
            this.bs = 0;
            while (this.bs < 30) {
                this.b(null, this.i[this.bs], null, null, 5, 2, 1);
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ed() {
        try {
            this.bs = 0;
            while (this.bs < 15) {
                this.b(null, this.k[this.bs], null, null, 5, 2, 1);
                ++this.bs;
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
            this.bs = 0;
            while (this.bs < 2) {
                this.b(null, this.l[this.bs], null, null, 5, 42, 1);
                this.b(null, this.m[this.bs], null, null, 5, 42, 1);
                this.b(null, this.n[this.bs], null, null, 5, 42, 1);
                ++this.bs;
            }
            this.bs = 0;
            while (this.bs < 42) {
                this.ac[this.bs] = 0;
                if (this.Z[this.bs] == 23) {
                    this.bt = 0;
                    while (this.bt < 12) {
                        this.e[this.bs][this.bt] = -1;
                        ++this.bt;
                    }
                }
                ++this.bs;
            }
            this.b(null, this.ak, null, null, 7, this.ak.length, 10);
            this.b(this.d, null, null, null, 1, this.d.length, 0);
            this.b(this.e, null, null, null, 1, this.e.length, 0);
            this.b(this.f, null, null, null, 1, this.f.length, 0);
            return;
        }
        catch (Exception exception) {
            return;
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
                this.bs = 0;
                while (this.bs < this.g.length) {
                    this.g[this.bs] = true;
                    ++this.bs;
                }
                this.bs = 0;
                while (this.bs < this.h.length) {
                    this.h[this.bs] = true;
                    ++this.bs;
                }
            }
            this.bs = 0;
            while (this.bs < this.ae) {
                this.bv = this.bu = this.a.readInt();
                if (100 - this.bu < this.bu) {
                    this.bv = 100 - this.bu;
                }
                ++this.bv;
                this.bt = 0;
                while (this.bt < 200) {
                    if (this.B[this.bt] >= 0) {
                        this.g[this.bs][this.bt] = (byte)(this.bu + ((this.a.nextInt() & 0xFFFF) % this.bv - this.bv / 2));
                    }
                    ++this.bt;
                }
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    final void ef() {
        try {
            this.bs = 0;
            while (this.bs < 222) {
                if (this.B[this.bs] >= 0) {
                    this.c[this.bs] = 5;
                    this.J[this.bs] = 0;
                    if (this.bs < 200) {
                        if (this.W[this.bs] == 11) {
                            this.W[this.bs] = 9;
                            byte by = this.c[this.B[this.bs]][this.C[this.bs]];
                            this.ad[by] = (byte)(this.ad[by] - 1);
                        } else if (this.W[this.bs] == 12 || this.W[this.bs] == 13) {
                            this.e[this.c[this.B[this.bs]][this.C[this.bs]]][this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]] = (short)this.bs;
                            if (this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][4]] == 1 && this.W[this.bs] == 13) {
                                if (this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][2] + 2] == 0) {
                                    this.G[this.bs] = this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][21] + this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]];
                                }
                                if (this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][2] + 3] == 0) {
                                    this.H[this.bs] = this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][22] + this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]];
                                }
                                if (this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][2] + 4] == 0) {
                                    this.F[this.bs] = this.o[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][this.g[this.Z[this.c[this.B[this.bs]][this.C[this.bs]]]][23] + this.ac[this.c[this.B[this.bs]][this.C[this.bs]]]];
                                }
                            }
                            byte by = this.c[this.B[this.bs]][this.C[this.bs]];
                            this.ac[by] = (byte)(this.ac[by] + 1);
                        }
                        this.N[this.bs] = -1;
                        this.O[this.bs] = -1;
                    }
                }
                ++this.bs;
            }
            this.az = 0;
            this.aG = 0;
            this.bs = 0;
            while (this.bs < 222) {
                this.d[this.bs] = -1;
                if (this.B[this.bs] >= 0) {
                    if (this.A[this.bs] == 9 && this.b[this.B[this.bs]][this.C[this.bs]] >= 4 && this.b[this.B[this.bs]][this.C[this.bs]] <= 12 && this.ag[this.c[this.B[this.bs]][this.C[this.bs]]] == 4) {
                        this.c[this.m[0][this.c[this.B[this.bs]][this.C[this.bs]]]][this.m[1][this.c[this.B[this.bs]][this.C[this.bs]]]] = (short)this.bs;
                    } else {
                        this.d[this.bs] = this.c[this.B[this.bs]][this.C[this.bs]];
                        this.c[this.B[this.bs]][this.C[this.bs]] = (short)this.bs;
                    }
                }
                ++this.bs;
            }
            this.bs = 0;
            while (this.bs < 24) {
                this.o = this.bs++;
                this.cI();
            }
            this.Y = 0;
            while (this.Y < this.O / 5) {
                this.Z = 0;
                while (this.Z < this.O / 5) {
                    this.cH();
                    this.Z = (byte)(this.Z + 1);
                }
                this.Y = (byte)(this.Y + 1);
            }
            this.dy();
            this.bs = 0;
            while (this.bs < 42) {
                if (this.l[0][this.bs] >= 0 && this.aD[this.Z[this.bs]] == 0) {
                    this.aD[this.Z[this.bs]] = (byte)(this.aA[this.Z[this.bs]] / b.au[0]);
                    this.aD[24] = (byte)(this.aD[24] + this.aD[this.Z[this.bs]]);
                }
                ++this.bs;
            }
            return;
        }
        catch (Exception exception) {
            return;
        }
    }
}

