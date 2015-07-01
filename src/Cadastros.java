import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;


public class Cadastros {
	List<User> users;
	
	public Cadastros(){
		users = new ArrayList<User>();
		atualizaCSV();
	}

	private void atualizaCSV() {
		try {
			BufferedReader in = new BufferedReader(new FileReader("src/users.csv"));
			String csv;
			while ((csv = in.readLine()) != null) {
				users.add(new User(csv));
				System.out.println("add!!");
			}
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("File users.csv was not found!");
			try {
				FileWriter arq = new FileWriter("src/users.csv");
				System.out.println("File users.csv was created!");
				arq.close();
			} catch (IOException l) {
				System.out.println("Error reading/creating the file!");
			}
		} catch (IOException e) {
			System.out.println("Error reading the file!");
		}	
	}
	
	public void adicionaUser(User u){
		users.add(u);
		adicionaUserCSV(u);
	}

	private void adicionaUserCSV(User u) {
		try {
			PrintWriter pw = new PrintWriter(new FileOutputStream(
					"src/users.csv", true));
			pw.println(u.toStringCSV());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}		
	}

	public User searchUser(String nome){
		for(User temp : users){
			if(temp.getNome() == nome){
				return temp;
			}
		}
		
		return null;
	}
}
