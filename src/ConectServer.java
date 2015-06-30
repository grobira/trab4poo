import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ConectServer implements Runnable {

	Estoque e;
	Cadastros c;
	Socket s;
	BufferedReader in;
	PrintWriter out;
	
	
	public ConectServer(Estoque e, Cadastros c, Socket s){
		this.e = e;
		this.c = c;
		this.s = s;
	}
	@Override
	public void run() {
		try {
			in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			String line;
			while((line = in.readLine()) != null){
				processCommand(line);
			}
			
			s.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		

	}
	private void processCommand(String str) {
		System.out.println(str);
	}

}
