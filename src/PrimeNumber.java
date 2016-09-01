import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrimeNumber {

	public static void main(String arg) {
		// INPUT variables e.g) 300 500
		String line = arg.replaceAll(System.lineSeparator(), " ").trim();
		
		String[] lines = line.split(" ");
		
		int min = Integer.parseInt(lines[0].trim());
		int max = Integer.parseInt(lines[1].trim());
		
		// OUTPUT variables e.g) 10 prime number every line / next line / total # of prime number with-in the range
		boolean[] primeNumbers = getPrimeNumbers(min, max);
		int totalPrimeNumbers = 0;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < primeNumbers.length; i++){
			if(primeNumbers[i] == true) {
				totalPrimeNumbers++;
				sb.append(i);
				if(totalPrimeNumbers%10 == 0) {
					sb.append(System.lineSeparator());
				} else {
					sb.append(" ");
				}
			}
		}
		sb.append(System.lineSeparator());
		sb.append(System.lineSeparator());
		sb.append(totalPrimeNumbers);
		
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
	
	private static boolean[] getPrimeNumbers(int n) {
		return getPrimeNumbers(2, n);
	}
	
	private static boolean[] getPrimeNumbers(int min, int max) {
		int progMax = max + 1;
		int n = (int) Math.sqrt(max);
		
		boolean[] result = new boolean[progMax];
		
		// Initialize
		for(int i = 0; i < progMax; i++) {
			if(i < min) result[i] = false;
			else result[i] = true;
		}
		
		for(int i = 2; i <= n; i++) {
			int k = 2;
			while(i*k < progMax) {
				result[i*k] = false;
				k++;
			}
		}
		
		return result;
	}

}
