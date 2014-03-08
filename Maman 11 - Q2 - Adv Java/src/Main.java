import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;


public class Main {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Welcome to the Cash Register program.\n");

		BufferedReader systemIn = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
		
		String line;
		while((line = systemIn.readLine()) != null) {
			System.out.println("Please start inputting items.\nWhen done, press Crtl+D to end.\n");
		}
		

	}

}
