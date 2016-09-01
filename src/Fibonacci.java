import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class Fibonacci {

	public static void main(String arg) {
		// INPUT variables e.g) 300 500
		String line = arg.replaceAll(System.lineSeparator(), " ").trim();
		
		String[] lines = line.split(" ");
		
		int max = Integer.parseInt(lines[0].trim());
		
		// OUTPUT variables e.g) 10 prime number every line / next line / total # of prime number with-in the range
		int[] fibo = fibonacci(max);
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i < fibo.length; i++){
			sb.append(fibo[i]);
			if(i%10 == 0 && i != 0) sb.append(System.lineSeparator());
			else sb.append(" ");
		}
		
		String result = sb.toString();
		
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
	
	private static int[] fibonacci(int n) {
		int progMax = n + 1;
		int[] result = new int[progMax];
		
		// get Fibonacci array
		for(int i = 0; i < progMax; i++) {
			if(i == 0) result[i] = 0;
			else if(i == 1) result[i] = 1; 
			else {
				result[i] = result[i - 1] + result[i - 2];
			}
		}
		
		return result;
	}

}
