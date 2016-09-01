import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class GcfLcm {

	/*
	 * Greatest Common Factor and Least Common Multiple
	 * 
	 *  To find either the LCM or GCF of two numbers you always start out the same way:
	 *  	- you find the prime factorizations of the two numbers.
	 *  
	 *  Euclidean Algorithm - the greatest common divisor of two numbers does not change if the larger number is replaced by its difference with the smaller number.
	 *  	- e.g. 21 is the GCD of 252 and 105 (252 = 21 x 12 and 105 = 21 x 5), 
	 *  	and the same number 21 is also the GCD of 105 and 147 = 252 - 105.
	 *  	- Since this replacement reduce the larger of the two numbers,
	 *  	repeating this process gives successively smaller pairs of numbers until the two numbers become equal.
	 *  
	 */
	
	public static void main(String arg) {
		// INPUT variables e.g) 1587645 67545
		String line = arg.replaceAll(System.lineSeparator(), " ").trim();
		
		String[] lines = line.split(" ");
		
		long a = Integer.parseInt(lines[0].trim());
		long b = Integer.parseInt(lines[1].trim());
		
		// OUTPUT variables e.g) gcd lcm
		long gcd = gcd(a,b);
		long lcm = lcm(a,b);
		
		String result = gcd + " " + lcm;
		
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
	
	private static long gcd(long a, long b) {
		// Initialize - to keep a > b true.
		if(a < b) {
			long temp = a;
			a = b;
			b = temp;
		}
		
		// Proceed Euclidean Algorithm
		while (b > 0) {
			long temp = b;
			b = a%b;
			a = temp;
		}
		return a;
	}
	
	private static long lcm(long a, long b) {
		return a * (b / gcd(a,b));
	}

}
