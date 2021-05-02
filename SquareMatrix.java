package matrixes;

import exception.MyException;

public class SquareMatrix extends Matrix {

    public SquareMatrix(int size) {
        this.rows = size;
        this.columns = size;
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            matrix[i][i] = 1;
        }
    }

    public SquareMatrix(int size, int value) {
        this.rows = size;
        this.columns = size;
        matrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                matrix[i][j] = value;
            }
        }
    }

    @Override
    public Matrix sum(Matrix a) {
        if (this.rows != a.rows || this.columns != a.columns) {
            MyException myException = new MyException("different sizes!");
            throw myException;
        }
        SquareMatrix tmp = new SquareMatrix(this.rows, 0);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.columns; j++) {
                tmp.matrix[i][j] = this.matrix[i][j] + a.matrix[i][j];
            }
        }
        return tmp;
    }

}
