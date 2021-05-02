package com.company;

import matrixes.Matrix;
import matrixes.MirrorMatrixHor;
import matrixes.SquareMatrix;

public class Main {

    public static void main(String[] args) {
        Matrix a1 = new Matrix(4, 4);
        a1.setElement(0, 0, 1);
        Matrix a3 = new SquareMatrix(4);
        a1 = a1.sum(a3);
        System.out.println(a1);
        MirrorMatrixHor mirrorMatrixHor = new MirrorMatrixHor(4);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                mirrorMatrixHor.setElement(i, j, 5);
            }
        }
        System.out.println(mirrorMatrixHor);
        System.out.println(mirrorMatrixHor.sum(a1));
    }
}
