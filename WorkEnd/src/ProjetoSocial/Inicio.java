package ProjetoSocial;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JOptionPane;

import ProjetoSocial.ManipularDados;

public class Inicio {
public static void main(String[] args) throws IOException  {
		
		Path dir = Paths.get("C:", "Marya");
		//"C:\Users\marya\OneDrive\Área de Trabalho\Marya"
		Path path = dir.resolve("Workend.doc");
		
		JOptionPane.showMessageDialog(null, path);
		//System.out.println(path);
		ManipularDados.escritor(path.toString(), null);
}}
