import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class InverseMatrix {

	/*
	 * Inverse Matrix
	 * 	How to get Inverse Matrix of 2x2
	 * 		A^-1 = (1 / (ad-bc))[(d -b), (-c a)]
	 * 	How to get Inverse Matrix of NxN using Gauss method.
	 */
	public static void main(String arg) {
		// INPUT variables e.g) Input of 3by3 Matrix, 9 numbers consecutively provided from top-left to bottom-right of the matrix
		String line = arg.replaceAll(System.lineSeparator(), " ").trim();
		
		String[] lines = line.split(" ");
		int n = 0;	
		double[][] matrix = new double[3][4];
		double[][] solution;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				matrix[i][j] = Integer.parseInt(lines[i].trim());
				n++;
			}
		}
		matrix[0][3] = Integer.parseInt(lines[n++].trim());
		matrix[1][3] = Integer.parseInt(lines[n++].trim());
		matrix[2][3] = Integer.parseInt(lines[n++].trim());
		
		// OUTPUT variables e.g) inverse matrix (1 line = 1 row) / next line / solution x,y,z respectively.
		double[][] solMatrix = new double[3][4];
		
		// write to output file
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			writer.println(result);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			writer.close();
		}

	}
	
	private static double[][] solve3vy3Matrix(double[][] matrix) {
		double[][] solution = new double[3][4];
		
		return solution;
	}
	
	// swap rows a and b of given matrix m
	private static void swapRow(double[][] m, int a, int b) {
		int n = m[a].length;
		
		for(int i = 0; i < n; i++) {
			double tmp = m[a][i];
			m[a][i] = m[b][i];
			m[b][i] = tmp;
		}
	}
	
	// divide row of given matrix m by b
	private static void divideRow(double[][] m, int row, double by) {
		int n = m[row].length;
		
		for(int i = 0; i < n; i++) {
			m[row][i] /= by;
		}
	}
	
	// multiply row of given matrix m by b
		private static void multiplyRow(double[][] m, int row, double by) {
			int n = m[row].length;
			
			for(int i = 0; i < n; i++) {
				m[row][i] *= by;
			}
		}
	
	// substitute row a of given matrix m by row by
	private static void subRow(double[][] m, int row, double[] by) {
		int n = m[row].length;
		if(n != by.length) {
			System.out.println("IN subRow() :: row length of m[row] = " + n + " and by = " + by.length + " does not match");
			return;
		}
		
		for(int i = 0; i < n; i++){
			m[row][i] -= by[i];
		}
	}
	
	// add 'row' of given matrix 'm' by row 'by'
	private static void addRow(double[][] m, int row, double[] by) {
		if(m[row].length != by.length) {
			System.out.println("IN addRow() :: row length of m[row] = " + n + " and by = " + by.length + " does not match");
			return;
		}
		
		for(int i = 0; i < m[row].length; i++){
			m[row][i] += by[i];
		}
	}

}
