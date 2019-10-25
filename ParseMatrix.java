/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixmultiplier;

/**
 * Command class to parse a matrix from a given string
 * @author katherinejackson
 */
public class ParseMatrix extends Command {
    
    /**
     * Parses a matrix from the given string, if possible.
     * Command will only be marked successful if the rows and cols are correct length, 
     * and all data is int values.
     * If unsuccessful, an appropriate message will be put in the errorMessage attribute
     * @param s : the string containing the matrix
     *          The matrix should have rows separated by newline, and columns
     *          separated by a comma
     *          Ex: 1, 2
     *              3, 4
     * @param numRows : number of rows the matrix should have
     * @param numCols : number of cols the matrix should have
     * @param matrix : the matrix to be modified
     */
    public ParseMatrix(String s, int numRows, int numCols, int[][] matrix) {
        String[] rows = s.split("\n");
        if (rows.length != numRows) {
            errorMessage = "Error parseing string, wrong number of rows";
            return;
        }
        
        for (int i = 0; i < rows.length; i ++) {
            String[] elements = rows[i].split(",");
            if (elements.length != numCols) {
                errorMessage = "Error parseing string, wrong number of columns";
                return;
            }
            for (int j = 0; j < elements.length ; j ++) {
                elements[j] = elements[j].trim();
                try{
                    matrix[i][j] = Integer.parseInt(elements[j]);
                }
                catch(Exception e) {
                    errorMessage = "Error parseing string, non-integer character found";
                    return;
                }
            }
        }
        successful = true;
    }
    
}
