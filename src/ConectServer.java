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
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				
				if(result){
					out.println("Login aceito!!");
				}else
					out.println("Login negado!!");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
		}else if(op == 2){
			c.adicionaUser(new User(values[1], values[2], values[3], values[4], c.users.size()+1, values[6]));
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.println("Usuario cadastrado com sucesso!");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(op == 3){
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				int i = 0;
				while(i < e.produtosCadastrados.size()){
					out.print(e.produtosCadastrados.get(i).print());
					i++;
				}
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
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
