import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PI {

	public static void main(String arg) {
		// INPUT variables e.g) 300 500
		String line = arg.replaceAll(System.lineSeparator(), " ").trim();
		
		String[] lines = line.split(" ");
			
		int n = Integer.parseInt(lines[0].trim());
		
		// OUTPUT variables e.g) 10 prime number every line / next line / total # of prime number with-in the range
		double pi = pi(n);
		//System.out.println("pi caclulated = " + pi);
		String result = String.format("%.6f", pi);
		
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
	
	private static double pi(int n){
		double out = 0;
		for(int i = 1; i < n; i++) {
			
			if(i%2 == 0) {
				out -= (1.0 / (2.0 * i - 1.0));
			} else {
				out += (1.0 / (2.0 * i - 1.0));
			}
			//System.out.println("IN pi("+ n +") :: At ForLoop(" + i + ") : out = " + out + " AND  current pi = " + out*4);
		}
		return out * 4;
	}

}
