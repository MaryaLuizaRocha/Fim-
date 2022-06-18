package ProjetoSocial;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class ManipularDados {
	public static void leitor(String path) throws IOException {
		BufferedReader buffRead = new BufferedReader(new FileReader(path));
		String linha = "";
		while (true) {
			if (linha != null) {
				//System.out.println(linha);
				JOptionPane.showMessageDialog(null, linha);
			} else
				//System.out.println("Registro não encontrado.");
				JOptionPane.showMessageDialog(null, "Registro não encontrado.");
				break;
		}
		buffRead.close();
	}

		public static void escritor(String path, String conteudo) throws IOException {
			BufferedWriter escrever = new BufferedWriter(new FileWriter(path));
			escrever.append(conteudo);
			escrever.close();

		}
}
