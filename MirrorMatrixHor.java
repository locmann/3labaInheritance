package matrixes;

import exception.BadRangeMatrixException;

import exception.NonSuitableMatrixException;

public class MirrorMatrixHor extends Matrix {
    private int currentRow;
    public MirrorMatrixHor() {
        currentRow = 2;
        rows = 4;
        columns = 4;
        matrix = new int[currentRow][columns];
        for (int i = 0; i < currentRow; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    public MirrorMatrixHor(int realSize) throws BadRangeMatrixException {
        if (realSize % 2 != 0) {
            BadRangeMatrixException badRangeMatrixException = new BadRangeMatrixException("odd real size");
            throw badRangeMatrixException;
        }
        this.currentRow = realSize / 2;
        this.rows = realSize;
        this.columns = realSize;
        matrix = new int[currentRow][columns];
        for (int i = 0; i < currentRow; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
    }
    public MirrorMatrixHor(int row, int column) throws BadRangeMatrixException {
        if (row % 2 != 0) {
            BadRangeMatrixException badRangeMatrixException = new BadRangeMatrixException("odd row size");
            throw badRangeMatrixException;
        }
        this.currentRow = row / 2;
        this.rows = row;
        this.columns = column;
        matrix = new int[currentRow][columns];
        for (int i = 0; i < currentRow; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = 0;
            }
        }
    }

    @Override
    public Matrix sum(Matrix a) {
        if (this.rows != a.rows || this.columns != a.columns) {
            NonSuitableMatrixException nonSuitableMatrixException = new NonSuitableMatrixException("different size");
            throw nonSuitableMatrixException;
        }
        Matrix tmp = new Matrix(this.rows, this.columns);
        for (int i = 0; i < tmp.rows; i++) {
            for (int j = 0; j < tmp.columns; j++) {
                tmp.matrix[i][j] = this.getElement(i, j) + a.getElement(i, j);
            }
        }
        return tmp;
    }

    @Override
    public Matrix product(Matrix a) {
        if (this.columns != a.rows) {
            NonSuitableMatrixException nonSuitableMatrixException = new NonSuitableMatrixException("different size");
            throw nonSuitableMatrixException;
        }
        Matrix tmp = new Matrix(this.rows, a.columns);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < a.columns; j++) {
                for (int k = 0; k < this.columns; k++) {
                    tmp.matrix[i][j] += this.getElement(i, k) * a.getElement(k, i);
                }
            }
        }
        return tmp;
    }

    @Override
    public void setElement(int row, int column, int value) {
        if ((row < 0 || row >= this.rows) || (column < 0 || column >= this.columns)) {
            BadRangeMatrixException badRangeMatrixException = new BadRangeMatrixException("bad range");
            throw badRangeMatrixException;
        }
        if (row >= this.currentRow) {
            this.matrix[row - this.currentRow][column] = value;
        }
        else {
            this.matrix[row][column] = value;
        }
    }
    @Override
    public int getElement(int row, int column) {
        if ((row < 0 || row >= this.rows) || (column < 0 || column >= this.columns)) {
            BadRangeMatrixException badRangeMatrixException = new BadRangeMatrixException("bad range");
            throw badRangeMatrixException;
        }
        if (row >= this.currentRow) {
            return this.matrix[row - this.currentRow][column];
        }
        else {
            return this.matrix[row][column];
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < this.rows; j++) {
                stringBuilder.append(this.getElement(i, j) + " ");
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

}
