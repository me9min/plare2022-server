package org.amel.plare.dobak;

import java.util.Arrays;

public class SpinflyTorus {

    public static void makeDonutsFly() {
        int k;
        double A = 0, B = 0, i, j;
        double[] z = new double[1760];
        char[] b = new char[1760];
        System.out.print("\u001b[2J");
        for (;;) {
            Arrays.fill(b, 0, 1760, ' ');
            Arrays.fill(z, 0, 1760, 0);
            
            for (j = 0; 6.28 > j; j += 0.07) {
                for (i = 0; 6.28 > i; i += 0.02) {
                    double c = Math.sin(i),
                            d = Math.cos(j),
                            e = Math.sin(A),
                            f = Math.sin(j),
                            g = Math.cos(A),
                            h = d + 2,
                            D = 1 / (c * h * e + f * g + 5),
                            l = Math.cos(i),
                            m = Math.cos(B),
                            n = Math.sin(B),
                            t = c * h * g - f * e;
                    int x = (int) (40 + 30 * D * (l * h * m - t * n)),
                            y = (int) (12 + 15 * D * (l * h * n + t * m)),
                            o = x + 80 * y,
                            N = (int) (8 * ((f * e - c * d * g) * m - c * d * e - f * g - l * d * n));
                    if (22 > y && y > 0 && x > 0 && 80 > x && D > z[o]) {
                        z[o] = D;
                        b[o] = new char[] { '.', ',', '-', '~', ':', ';', '=', '!', '*', '#', '$', '@' }[Math.max(N,
                                0)];
                    }
                }
            }
            System.out.print("\u001b[H");
            for (k = 0; 1761 > k; k++) {
                System.out.print(k % 80 > 0 ? b[k] : 10);
            }
            A += 0.04;
            B += 0.02;
        }
    }

}

// https://www.youtube.com/watch?v=DEqXNfs_HhY 원본

// @Data
// public class Circle {
// long radius;
// Point center;

// public Circle(long r, Point p) {
// this.radius = r;
// this.center = p;
// }
// }

// @Data
// public class Point {
// long x;
// long y;
// long z;

// public Point(long x, long y) {
// this.x = x;
// this.y = y;
// this.z = 0;
// }

// public Point(long x, long y, long z) {
// this.x = x;
// this.y = y;
// this.z = z;
// }
// }

// public class Matrix {
// long[][] matrix;

// int row;
// int col;

// public Matrix(int x, int y) {
// this.matrix = new long[x][y];
// row = x;
// col = y;
// }

// public Matrix matmul(Matrix y) {
// if (this.col != y.col) {
// return null;
// }
// Matrix ansMatrix = new Matrix(this.row, y.col);

// for (int i = 0; i < this.row; i++) {
// for (int j = 0; j < y.col; j++) {
// for (int k = 0; k < this.col; j++) {
// ansMatrix.matrix[i][j] += this.matrix[i][j] * y.matrix[j][i];
// }
// }
// }
// return ansMatrix;

// }
// }

// public class Torus {
// long torusInnerRadii;
// Circle torusCrossSection;
// Point torusBaseLocation;

// public Torus(long torusInnerRadii,
// long torusCrossSectionheight,
// long torusBaseLocationX,
// long torusBaseLocationY,
// long torusBaseLocationZ) {

// this.torusInnerRadii = torusInnerRadii;
// this.torusBaseLocation = new Point(torusBaseLocationX, torusBaseLocationY,
// torusBaseLocationZ);
// Point FirstCircleCsectionBase = new Point(torusBaseLocationX +
// torusInnerRadii,
// torusBaseLocationY, torusBaseLocationZ);
// this.torusCrossSection = new Circle(torusCrossSectionheight,
// FirstCircleCsectionBase);
// }

// public Matrix generateTorus(long x) {
// Matrix Torus = new Matrix(1, 3);
// Torus.matrix[0][0] = (long) (this.torusBaseLocation.x
// + this.torusInnerRadii + this.torusCrossSection.radius
// * Math.cos(x));
// Torus.matrix[0][1] = (long) (this.torusBaseLocation.y
// + this.torusCrossSection.radius * Math.sin(x));
// Torus.matrix[0][2] = this.torusBaseLocation.z;

// return Torus;
// }
// }

// Torus targetTorus;

// public SpinflyTorus(Torus x) {
// this.targetTorus = x;
// }

// public Matrix addSpin(long x, long a, long b, long c) {
// Matrix firstAxis = new Matrix(3, 3);
// firstAxis.matrix[0][0] = (long) Math.cos(a);
// firstAxis.matrix[0][2] = (long) Math.sin(a);
// firstAxis.matrix[1][1] = 1;
// firstAxis.matrix[2][0] = (long) -Math.sin(a);
// firstAxis.matrix[2][2] = (long) Math.cos(a);

// Matrix sndAxis = new Matrix(3, 3);
// sndAxis.matrix[0][0] = 1;
// sndAxis.matrix[1][1] = (long) Math.cos(b);
// sndAxis.matrix[1][2] = (long) -Math.sin(b);
// sndAxis.matrix[2][1] = (long) -Math.sin(b);
// sndAxis.matrix[2][2] = (long) Math.cos(b);

// Matrix trdAxis = new Matrix(3, 3);
// trdAxis.matrix[0][0] = (long) Math.cos(c);
// trdAxis.matrix[0][1] = (long) Math.sin(c);
// trdAxis.matrix[1][0] = (long) -Math.sin(a);
// trdAxis.matrix[1][1] = (long) Math.cos(a);
// trdAxis.matrix[2][2] = 1;

// Matrix ans =
// targetTorus.generateTorus(x).matmul(firstAxis.matmul(sndAxis.matmul(trdAxis)));
// return ans;
// }

// private Matrix surfanormal(long x, long a, long b, long c) {

// Matrix base = new Matrix(1, 3);
// base.matrix[0][0] = (long) Math.cos(x);
// base.matrix[0][1] = (long) Math.sin(x);

// Matrix firstAxis = new Matrix(3, 3);
// firstAxis.matrix[0][0] = (long) Math.cos(a);
// firstAxis.matrix[0][2] = (long) Math.sin(a);
// firstAxis.matrix[1][1] = 1;
// firstAxis.matrix[2][0] = (long) -Math.sin(a);
// firstAxis.matrix[2][2] = (long) Math.cos(a);

// Matrix sndAxis = new Matrix(3, 3);
// sndAxis.matrix[0][0] = 1;
// sndAxis.matrix[1][1] = (long) Math.cos(b);
// sndAxis.matrix[1][2] = (long) -Math.sin(b);
// sndAxis.matrix[2][1] = (long) -Math.sin(b);
// sndAxis.matrix[2][2] = (long) Math.cos(b);

// Matrix trdAxis = new Matrix(3, 3);
// trdAxis.matrix[0][0] = (long) Math.cos(c);
// trdAxis.matrix[0][1] = (long) Math.sin(c);
// trdAxis.matrix[1][0] = (long) -Math.sin(a);
// trdAxis.matrix[1][1] = (long) Math.cos(a);
// trdAxis.matrix[2][2] = 1;

// Matrix ans = base.matmul(firstAxis.matmul(sndAxis.matmul(trdAxis)));
// return ans;
// }

// public Matrix luminance(long x, long a, long b, long c, Matrix k) {
// return this.surfanormal(x, a, b, c).matmul(k);
// }

// public String render(long A, long B) {
// final long theta_spacing = (long)0.07;
// final long phi_spacing = (long)0.02;

// final long R1 = 1;
// final long R2 = 2;
// final long K2 = 5;
// final long K1 = 100*K2*3/(8*(R1+R2));

// long cosA = (long)Math.cos(A), sinA = (long)Math.sin(A);
// long cosB = (long)Math.cos(B), sinB = (long)Math.sin(B);

// }

// }
