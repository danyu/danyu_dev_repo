package danyu.networking.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class CrackSocket {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Socket st = null;
		PrintWriter out = null;
		BufferedReader in = null;
		try {
			st = new Socket("danyu", 7);
			out = new PrintWriter(st.getOutputStream(), true);
			in = new BufferedReader(new InputStreamReader(st.getInputStream()));

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			System.err.println("Don't know about host: danyu.");
			System.exit(1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Couldn't get I/O for "
					+ "the connection to: danyu.");
			System.exit(1);
		}

		BufferedReader stdIn = new BufferedReader(new InputStreamReader(
				System.in));
		String userInput;
		while ((userInput = stdIn.readLine()) != null) {
			out.print(userInput);
			System.out.println("echo: " + in.readLine());
		}

		out.close();
		in.close();
		stdIn.close();
		st.close();

	}

}
