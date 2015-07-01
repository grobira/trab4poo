package super4;
public class User {
	private String nome;
	private String endereco;
	private String telefone;
	private String email;
	private int ID;
	private String senha;

	public User(String cvs){
		String[] values = cvs.split(",");
		
		this.nome = values[0];
		this.endereco = values[1];
		this.telefone = values[2];
		this.email = values[3];
		this.ID = Integer.parseInt(values[4]);
		this.senha = values[5];
	}
	
	public User(String nome, String endereco, String telefone, String email, int ID, String senha){
		
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.email = email;
		this.ID = ID;
		this.senha = senha;
	}
	
	boolean validaLogin(String pass){
		if(this.senha.equals(pass))
			return true;
		return false;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public String toStringCSV(){
		String str = nome + "," + endereco + "," + telefone + "," + email + "," + ID + "," + senha;
		return str;
	}
}
