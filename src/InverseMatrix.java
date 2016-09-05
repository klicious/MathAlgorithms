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
		System.out.println("lines.length = " + lines.length);
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				matrix[i][j] = (double) Integer.parseInt(lines[n].trim());
				n++;
				System.out.println(String.format("%.3f", matrix[i][j]));
			}
		}
		System.out.println(String.format("%.3f", matrix[0][3]));
		System.out.println(String.format("%.3f", matrix[1][3]));
		System.out.println(String.format("%.3f", matrix[2][3]));
		
		matrix[0][3] = (double) Integer.parseInt(lines[n++].trim());
		matrix[1][3] = (double) Integer.parseInt(lines[n++].trim());
		matrix[2][3] = (double) Integer.parseInt(lines[n++].trim());
		
		// OUTPUT variables e.g) inverse matrix (1 line = 1 row) / next line / solution x,y,z respectively.
		double[][] solution = solveMatrix(matrix);
		
		// write to output file
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("output.txt", "UTF-8");
			writer.println("");
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
	
	private static double[][] solveMatrix(double[][] matrix) {
		if(matrix.length < 1) return null;
		int row = matrix.length;
		int col = matrix[0].length;
		double[][] solution = new double[row][col];
		// Initialize 
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(i == j) {
					solution[i][j] = 1.0;
				} else {
					solution[i][j] = 0.0;
				}
			}
		}
		// check
		System.out.println("===== Initial matrix given =====");
		show(matrix);
		System.out.println("===== Initial solution matrix =====");
		show(solution);
		// solve
		// do elimination 'row' times then will be done.
		for(int pivot = 0; pivot < row; pivot++) {
			// put max value of pivot column to pivot row
			/*
			for(int r = 0; r < row; r++) {
				if(matrix[r][pivot] > matrix[pivot][pivot]) {
					swapRow(matrix, r, pivot);
				}
			}
			*/
			double value = matrix[pivot][pivot];
			divideRow(matrix, pivot, value);
			divideRow(solution, pivot, value);
			System.out.println();
			System.out.println("===== matrix given " + "pivot = " + pivot +" =====");
			show(matrix);
			System.out.println();
			System.out.println("===== solution matrix " + "pivot = " + pivot +" =====");
			show(solution);
			// divide pivot row by pivotValue to make the pivotValue to 1 then subtract pivot row to the rest of the row.
			for(int r = 0; r < row; r++) {
				//System.out.println("pivot = " + pivot + " row = " + r);
				if(r != pivot) {
					double[] curRow = new double[matrix[pivot].length];
					for(int a = 0; a < matrix[pivot].length; a++) {
						curRow[a] = matrix[pivot][a];
					}
					value = matrix[r][pivot];
					//System.out.println("value = " + value);
					multiplyArray(curRow, value);
					subRow(matrix, r, curRow);
					subRow(solution, r, curRow);
					
					/*
					System.out.println();
					System.out.println("===== matrix given " + "pivot = " + pivot + " row = " + r + " =====");
					show(matrix);
					System.out.println();
					System.out.println("===== solution matrix " + "pivot = " + pivot + " row = " + r + " =====");
					show(solution);
					*/
				}
			}
		}
		
		// push constants into the solution
		for(int r = 0; r < row; r++) {
			solution[r][col-1] = matrix[r][col-1];
		}
		// check
		System.out.println("===== Initial matrix after solve() =====");
		show(matrix);
		System.out.println("===== solution matrix after solve() =====");
		show(solution);

		return solution;
	}
	
	private static void show(double[][] m) {
		if(m.length < 1) return;
		int row = m.length;
		int col = m[0].length;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < row; i++) {
			sb.append("[");
			sb.append(" ");
			for(int j = 0; j < col; j++) {
				sb.append(String.format("%.3f", m[i][j]));
				sb.append(" ");
			}
			sb.append("]");
			sb.append(System.lineSeparator());
		}
		System.out.println("===== Printing Matrix =====");
		System.out.println(sb.toString());
		//System.out.println("===== Done Printing =====");
	}
	
	// multiply array 'a' by 'by'
	private static void multiplyArray(double[] a, double by) {
		for(int i = 0; i < a.length; i++) {
			a[i] *= by;
		}
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
			System.out.println("IN addRow() :: row length of m[row] = " + m[row].length + " and by = " + by.length + " does not match");
			return;
		}
		
		for(int i = 0; i < m[row].length; i++){
			m[row][i] += by[i];
		}
	}

}
