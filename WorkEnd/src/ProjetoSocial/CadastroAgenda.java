package ProjetoSocial;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import ProjetoSocial.ManipularDados;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import javax.swing.DropMode;

public class CadastroAgenda extends JFrame {

	private JPanel contentPane;
	private JTextField TextDesc;
	private JTextField textData;
	private JTextField textHora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAgenda frame = new CadastroAgenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public CadastroAgenda() throws Exception {
		setTitle("CADASTRO AGENDA");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 230, 140));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel DATA1 = new JLabel("DATA");
		DATA1.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel HORA = new JLabel("HORA");
		HORA.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JLabel DESCRI플O = new JLabel("DESCRI\u00C7\u00C3O");
		DESCRI플O.setFont(new Font("Tahoma", Font.BOLD, 12));{
		
		TextDesc = new JTextField();
		TextDesc.setColumns(10);
		
		JLabel STATUS = new JLabel("STATUS");
		STATUS.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		JRadioButton EXECUTANDO = new JRadioButton("EXECUTANDO");
		EXECUTANDO.setBackground(new Color(240, 230, 140));
		
		JRadioButton PARALISADO = new JRadioButton("PARALISADO");
		PARALISADO.setBackground(new Color(240, 230, 140));
		
		JRadioButton CONCLUIDO = new JRadioButton("CONCLUIDO");
		CONCLUIDO.setBackground(new Color(240, 230, 140));
		
		
		JTextField textData = new JFormattedTextField(new MaskFormatter("##/##/####"));
		textData.setColumns(10);
		
		JTextField textHora = new JFormattedTextField(new MaskFormatter("##:##"));
		textHora.setColumns(10);
		
		JButton SALVAR = new JButton("SALVAR");
		SALVAR.setBackground(new Color(255, 255, 51));
		SALVAR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				String STATUS = null;
				//data, hora, descri豫o
				String DATA = textData.getText();	
				String HORA = textHora.getText();	
				String DESC = TextDesc.getText();

				//ArrayList
				ArrayList<String> cadastroProj = new ArrayList();
				
	            //se selecionar o JRadio mostrar o status
	            if(EXECUTANDO.isSelected() == true) 
	            {
	            	STATUS = "EXECUTANDO";
				}
				if(PARALISADO.isSelected() == true) 
				{
					STATUS = "PARALISADO";
				}
				if(CONCLUIDO.isSelected() == true) 
				{
					STATUS = "CONCLUIDO";
				}
				String doc="WorkEndAgenda.txt", nome, dados2;
				dados2 = DATA+"\r\n"+HORA+"\r\n"+DESC+"\r\n"+STATUS;
				cadastroProj.add(dados2);
				
				try {
					ManipularDados.escritor(doc,dados2);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
	            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
	            			
			}
			});
		
		JButton btnNewButton = new JButton("ABRIR");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Path dir = Paths.get("C:/Users/marya/OneDrive/햞ea de Trabalho/eclipse-workspace/WorkEnd/WorkEndAgenda.txt");
				//"C:\Users\marya\OneDrive\햞ea de Trabalho\eclipse-workspace\WorkEnd\WorkEndAgenda.txt"
				try {
					byte [] text = Files.readAllBytes(dir);
					String leia = new String(text);
					
					JOptionPane.showMessageDialog(null, leia);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnNewButton.setBackground(Color.YELLOW);
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(32)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(STATUS)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(DATA1)
										.addComponent(HORA)
										.addComponent(DESCRI플O))
									.addGap(40)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(textHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
										.addComponent(TextDesc, GroupLayout.PREFERRED_SIZE, 255, GroupLayout.PREFERRED_SIZE))))
							.addContainerGap(25, Short.MAX_VALUE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(EXECUTANDO)
										.addComponent(PARALISADO))
									.addContainerGap(0, Short.MAX_VALUE))
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(CONCLUIDO)
									.addPreferredGap(ComponentPlacement.RELATED, 149, Short.MAX_VALUE)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnNewButton)
										.addComponent(SALVAR))
									.addGap(40))))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(DATA1)
								.addComponent(textData, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(HORA)
								.addComponent(textHora, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(DESCRI플O)
								.addComponent(TextDesc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(STATUS)
									.addGap(43))
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(EXECUTANDO)
									.addGap(18)))
							.addGap(11))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap(155, Short.MAX_VALUE)
							.addComponent(PARALISADO)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(CONCLUIDO)
						.addComponent(SALVAR))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton)
					.addGap(14))
		);
		contentPane.setLayout(gl_contentPane);
	}
}

	private Object setMascara(String string) {
		// TODO Auto-generated method stub
		return null;
	}	
}

