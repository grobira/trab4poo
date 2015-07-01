package super4;
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
		int rw = 0;
		boolean result;
		
		if(op == 1){
			result = login(values[1], values[2]);
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				
				if(result){
					out.println("Login aceito!!");
					out.println("ok");
				}else{
					out.println("Login negado!!");
					out.println("ok");
				}
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}		
			
		}else if(op == 2){
			c.adicionaUser(new User(values[1], values[2], values[3], values[4], c.users.size()+1, values[6]));
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				out.println("Usuario cadastrado com sucesso!");
				out.println("ok");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(op == 3){
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				for(Produto p : e.produtosCadastrados){
					out.println(p.print());
				}
				out.println("ok");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else if(op == 4){
			try {
				out = new PrintWriter(s.getOutputStream(), true);
				
				Produto p = procuraProduto(values[1]);
				if(p != null){
					result = verificaDisponibilidade(Integer.parseInt(values[2]), p);
					if(result){
						p.setQuantidade(p.getQuantidade() - Integer.parseInt(values[2]));
						out.println("Compra efetuada com sucesso!\nValor parcial : " + p.getPreco() +"\nValor total da compra : " + p.getPreco()*Integer.parseInt(values[2]));
						out.println("ok");
						rw = 1;
					}else{
						out.println("Quantidade indisponivel! Temos apenas " + p.getQuantidade());
						out.println("ok");
					}
				}else{
					out.println("Produto não cadastrado no sistema!");
					out.println("ok");
				}
				
				
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(rw == 1){
			rewrite();
		}
		
	}
	
	private void rewrite(){
		e.rewrite();
	}
	
	public boolean login(String lg, String sn){
		User u = c.searchUser(lg);
		if(u != null)
			return u.validaLogin(sn);
		return false;
	}
	
	public Produto procuraProduto(String nome){
		Produto p = e.searchProduto(nome);
		if( p != null)
			return p;
		return null;
	}
	
	public boolean verificaDisponibilidade(int quant, Produto p){
		return p.disponibilidade(quant);
	}

}
