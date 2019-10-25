/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiplier;

/**
 * Command class to multiply two matrices together, if possible
 * @author katherinejackson
 */
public class MultMatrix extends Command {
   
    /**
     * Multiplies matrix a by matrix b
     * Checks dimensions to ensure multiplication is possible
     * if command is unsuccessful, an appropriate message will be put in 
     * errorMessage attribute
     * @param a : the first matrix
     * @param b : the second matrix
     * @return : the resultant matrix
     */
    public Matrix multiply (Matrix a, Matrix b) {
    
        if (a.getNumCols() != b.getNumRows()) {
            errorMessage = "Matrices have the wrong dimensions, unable to mutiply";
            return null;
        }
        
        int[][] result = new int[a.getNumRows()][b.getNumCols()];
        
        for (int row = 0 ; row < a.getNumRows(); row ++) {
            for (int col = 0; col < b.getNumCols(); col ++) {
                for (int el = 0; el < a.getNumCols(); el ++) {
                    result[row][col] += a.matrix[row][el] * b.matrix[el][col];
                }
            }
        }
        
        Matrix r = new Matrix(a.getNumRows(), b.getNumCols(), result);
        successful = true;
        return r;
}
    
}
