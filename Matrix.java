/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiplier;

/**
 * Basic int matrix class
 * @author katherinejackson
 */
public class Matrix {
    
    int numRows;
    int numCols;
    int[][] matrix;

    public Matrix(int numRows, int numCols) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.matrix = new int[numRows][numCols]; 
    }
    
    public Matrix(int numRows, int numCols, int[][] matrix) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.matrix = matrix; 
    }

    public int getNumRows() {
        return numRows;
    }

    public void setNumRows(int numRows) {
        this.numRows = numRows;
    }

    public int getNumCols() {
        return numCols;
    }

    public void setNumCols(int numCols) {
        this.numCols = numCols;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }
    
    /**
     * Calls the multMatrix command to attempt to multiply this matrix with the 
     * given matrix
     * @param b : matrix to be multiplied with this matrix
     * @return : resultant matrix, null if unsuccessful
     */
    public Matrix multiply(Matrix b) {
        MultMatrix multCommand = new MultMatrix();
        Matrix result = multCommand.multiply(this, b);

        return result;
    }
    
    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                s += matrix[i][j] + "\t";
            }
            s += "\n";
        }
        return s;
    }
    
    public static void main(String[] args) {
        // testing
        int m = 2;
        int n = 2;
        Matrix m1 = new Matrix(m, n);
        Matrix m2 = new Matrix(m, n);
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                m1.matrix[i][j] = count;
                count ++;
            }
        }
        count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                m2.matrix[i][j] = count;
                count ++;
            }
        }
        Matrix result = m1.multiply(m2);
        
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        System.out.println(result.toString());

    }

}
