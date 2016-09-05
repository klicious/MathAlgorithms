import java.io.BufferedReader;
import java.io.FileReader;

public class MathAlgorithm {

	public static void main(String[] args) {
		// Set-up variables
		String parent, topic, Topic;
		String changeInput;
		parent = "MathAlgorithm";
		
		/*
		 * Prime Number
		 */
		topic = "prime_number";
		Topic = "Prime Number";
		changeInput = getInputFromFile(topic + "_input.txt");
		
		if (changeInput == null) {
			System.out.println(parent + ".java :: main() :: No strings read from " + topic + "_input.txt thus HALTing....");
			return;
		}	
		System.out.println("============================================");
		System.out.println(Topic + " Called");
		System.out.println("============================================");
		PrimeNumber.main(changeInput);
		System.out.println(parent + ".java :: main() :: " + Topic + " : " +  verifyResult("output.txt", topic + "_expected_output.txt"));
		
		/*
		 * Fibonacci
		 */
		topic = "fibonacci";
		Topic = "Fibonacci";
		changeInput = getInputFromFile(topic + "_input.txt");
		
		if (changeInput == null) {
			System.out.println(parent + ".java :: main() :: No strings read from " + topic + "_input.txt thus HALTing....");
			return;
		}	
		System.out.println("============================================");
		System.out.println(Topic + " Called");
		System.out.println("============================================");
		Fibonacci.main(changeInput);
		System.out.println(parent + ".java :: main() :: " + Topic + " : " +  verifyResult("output.txt", topic + "_expected_output.txt"));

		/*
		 * Greatest Common Factor & Least Common Multiple
		 */
		topic = "gcf_lcm";
		Topic = "GCF LCM";
		changeInput = getInputFromFile(topic + "_input.txt");
		
		if (changeInput == null) {
			System.out.println(parent + ".java :: main() :: No strings read from " + topic + "_input.txt thus HALTing....");
			return;
		}	
		System.out.println("============================================");
		System.out.println(Topic + " Called");
		System.out.println("============================================");
		GcfLcm.main(changeInput);
		System.out.println(parent + ".java :: main() :: " + Topic + " : " +  verifyResult("output.txt", topic + "_expected_output.txt"));
		
		/*
		 * PI
		 */
		topic = "pi";
		Topic = "PI";
		changeInput = getInputFromFile(topic + "_input.txt");
		
		if (changeInput == null) {
			System.out.println(parent + ".java :: main() :: No strings read from " + topic + "_input.txt thus HALTing....");
			return;
		}	
		System.out.println("============================================");
		System.out.println(Topic + " Called");
		System.out.println("============================================");
		PI.main(changeInput);
		System.out.println(parent + ".java :: main() :: " + Topic + " : " +  verifyResult("output.txt", topic + "_expected_output.txt"));
		
		/*
		 * Inverse Matrix
		 */
		topic = "inverse_matrix";
		Topic = "Inverse Matrix";
		changeInput = getInputFromFile(topic + "_input.txt");
		
		if (changeInput == null) {
			System.out.println(parent + ".java :: main() :: No strings read from " + topic + "_input.txt thus HALTing....");
			return;
		}	
		System.out.println("============================================");
		System.out.println(Topic + " Called");
		System.out.println("============================================");
		InverseMatrix.main(changeInput);
		System.out.println(parent + ".java :: main() :: " + Topic + " : " +  verifyResult("output.txt", topic + "_expected_output.txt"));
	}
	
	private static String getInputFromFile(String path) {
		String line;
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader (path))){
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString().trim();
	}
	
	private static boolean verifyResult(String outputFile, String expectedOutputFile) {
		String output = "output";
		String expectedOutput = "expectedOutput";
		String line = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader (outputFile))){
			StringBuilder sb = new StringBuilder();
			
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			output = sb.toString();
			System.out.println("Sort.java :: verifyResult() :: output : " + System.lineSeparator() + output);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader (expectedOutputFile))){
			StringBuilder sb = new StringBuilder();
			
			while( (line = br.readLine()) != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
			}
			expectedOutput = sb.toString();
			System.out.println("Sort.java :: verifyResult() :: expected_output : " + System.lineSeparator() + expectedOutput);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return output.equals(expectedOutput);
	}

}
