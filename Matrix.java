package matrixes;

import exception.MyException;

public class Matrix {
    protected int [][] matrix;
    protected int rows;
    protected int columns;

    Matrix() {
        rows = 2;
        columns = 2;
        matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            matrix[i][i] = 1;
        }
    }

    public Matrix(int row, int column) {
        rows = row;
        columns = column;
        matrix = new int[row][column];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    public Matrix sum(Matrix a) {
        if (this.rows != a.rows || this.columns != a.columns) {
            MyException myException = new MyException("different sizes!");
            throw myException;
        }
        Matrix tmp = new Matrix(this.rows, this.columns);
        for (int i = 0; i < tmp.rows; i++) {
            for (int j = 0; j < tmp.columns; j++) {
                tmp.matrix[i][j] = this.matrix[i][j] + a.matrix[i][j];
            }
        }
        return tmp;
    }

    public Matrix product(Matrix a) {
        if (this.columns != a.rows) {
            MyException myException = new MyException("columns != rows!");
            throw myException;
        }
        Matrix tmp = new Matrix(this.rows, a.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < a.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    tmp.matrix[i][j] += this.matrix[i][k] * a.matrix[k][j];
                }
            }
        }
        return tmp;
    }
    public void setElement(int row, int column, int value) {
        if ((row < 0 || row >= this.rows) || (column < 0 || column >= this.columns)) {
            MyException myException = new MyException("out of bound");
            throw myException;
        }
        this.matrix[row][column] = value;
    }
    public int getElement(int row, int column) {
        if ((row < 0 || row >= this.rows) || (column < 0 || column >= this.columns)) {
            MyException myException = new MyException("out of bound");
            throw myException;
        }
        return this.matrix[row][column];
    }

    public String toString() {
        String res = "";
        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix[i].length; j++) {
                res += String.format("%d ", this.matrix[i][j]);
            }
            res += "\n";
        }
        return res;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this == null || getClass() != o.getClass()) {
            return false;
        }
        Matrix a = (Matrix) o;
        if (this.rows != a.rows || this.columns != a.columns) {
            return false;
        }
        else {
            for (int i = 0; i < this.rows; i++) {
                for (int j = 0; j < this.columns; j++) {
                    if (this.matrix[i][j] != a.matrix[i][j]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
