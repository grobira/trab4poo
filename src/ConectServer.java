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
		String[] values = str.split(",");
		int op = Integer.parseInt(values[0]);
		boolean result;
		
		if(op == 1){
			result = login(values[1], values[2]);
			System.out.println("entrou na op");
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				
				if(result){
					out.println("Login accepted!!");
				}else
					out.println("Login denied!!");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
		}else if(op == 2){
			
		}else if(op == 3){
			
		}
		
	}
	
	public boolean login(String lg, String sn){
		User u = c.searchUser(lg);
		if(u != null){
			return u.validaLogin(sn);
		}
		return false;
	}

}
